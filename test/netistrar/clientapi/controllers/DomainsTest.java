package netistrar.clientapi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import netistrar.clientapi.APIProvider;
import netistrar.clientapi.exception.TransactionException;
import netistrar.clientapi.objects.domain.DomainNameContact;
import netistrar.clientapi.objects.domain.DomainNameListResults;
import netistrar.clientapi.objects.domain.DomainNameObject;
import netistrar.clientapi.objects.domain.descriptor.DomainNameCreateDescriptor;
import netistrar.clientapi.objects.domain.descriptor.DomainNameRenewDescriptor;
import netistrar.clientapi.objects.domain.descriptor.DomainNameUpdateDescriptor;
import netistrar.clientapi.objects.test.domain.TestDomainNameUpdateDescriptor;
import netistrar.clientapi.objects.transaction.Transaction;
import netistrar.clientapi.objects.transaction.TransactionElement;
import netistrar.clientapi.objects.transaction.TransactionError;
import netistrar.clientapi.objects.utility.BulkOperationProgress;

class DomainsTest {

	private APIProvider api;

	public DomainsTest() {
		this.api = new APIProvider("http://restapi.netistrar.test", "TESTAPIKEY", "TESTAPISECRET");
	}

	@Test
	void testCanValidateCreateOperationsForMultipleDomains() throws Exception {

		String ukDomain = "validationdomain.uk";
		String comDomain = "validationdomain.com";
		DomainNameContact owner = new DomainNameContact();

		DomainNameCreateDescriptor createDescriptor = new DomainNameCreateDescriptor(
				new String[] { ukDomain, comDomain }, 1, owner, new String[] { "monkeynameserver" }, null, null, null,
				null, null);

		Map<String, Map<String, TransactionError>> validationErrors = this.api.domains().validate(createDescriptor);

		Map<String, TransactionError> ukValidationErrors = validationErrors.get(ukDomain);
		assertTrue(ukValidationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(ukValidationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));

		Map<String, TransactionError> comValidationErrors = validationErrors.get(comDomain);

		assertTrue(comValidationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(comValidationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));

	}

	@Test
	void testFailedTransactionIsReturnedIfValidationErrorsOnCreate() throws Exception {

		String ukDomain = "validationdomain.uk";
		String comDomain = "validationdomain.com";
		DomainNameContact owner = new DomainNameContact();

		DomainNameCreateDescriptor createDescriptor = new DomainNameCreateDescriptor(new String[] { ukDomain }, 1,
				owner, new String[] { "monkeynameserver" }, null, null, null, null, null);

		Transaction domainTransaction = this.api.domains().create(createDescriptor, null);

		assertEquals(1, domainTransaction.getTransactionElements().size());
		Map<String, TransactionError> validationErrors = domainTransaction.getTransactionElements().get(ukDomain)
				.getElementErrors();
		assertTrue(validationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(validationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));

	}

	@Test
	void testOperationErrorsOccurIfUnexpectedCreateError() throws Exception {

		String rightsUK = "ganymede-netistrar.uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		Transaction transaction = this.api.domains().create(new DomainNameCreateDescriptor(new String[] { rightsUK }, 1,
				owner, new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 0, false), null);

		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertNotNull(transaction.getTransactionDateTime());
		assertNotNull(transaction.getOrderId());
		assertEquals("GBP", transaction.getOrderCurrency());
		assertEquals(0, transaction.getOrderSubtotal().floatValue());
		assertEquals(0, transaction.getOrderTaxes().floatValue());
		assertEquals(0, transaction.getOrderTotal().floatValue());

		assertEquals(1, transaction.getTransactionElements().size());
		Map<String, TransactionElement> elements = transaction.getTransactionElements();
		TransactionElement element = elements.get(rightsUK);
		assertEquals(rightsUK, element.getDescription());
		assertEquals("FAILED", element.getElementStatus());
		assertEquals(0, element.getOperationData().size());
		assertEquals(0, element.getOrderLineSubtotal().floatValue());
		assertEquals(0, element.getOrderLineTaxes().floatValue());
		assertEquals(0, element.getOrderLineTotal().floatValue());
		assertEquals(1, element.getElementErrors().size());

		TransactionError elementError = element.getElementErrors().get("DOMAIN_REGISTRATION_ERROR");
		assertTrue(elementError instanceof TransactionError);
		assertEquals("DOMAIN_REGISTRATION_ERROR", elementError.getCode());

		try {
			// Now confirm that the registration didn't actually take place.
			this.api.domains().get(rightsUK);
			fail("Should have thrown here");
		} catch (Exception e) {
			// Success
		}

	}

	@Test
	void testCanCreateValidSingleUKDomainNameWithAllAssociatedAssetsAndTransactionIsReturned() throws Exception {

		String newUKDomain = "validdomain-" + new Date().getTime() + ".uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		String key = this.api.utility().createBulkOperation();

		Transaction transaction = this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain },
				1, owner, new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 1, true), key);

		assertTrue(transaction instanceof Transaction);
		assertNotNull(transaction.getTransactionDateTime());
		assertEquals("DOMAIN_CREATE", transaction.getTransactionType());
		assertEquals("SUCCEEDED", transaction.getTransactionStatus());
		assertNotNull(transaction.getOrderId());
		assertEquals("GBP", transaction.getOrderCurrency());
		assertEquals(4.50, transaction.getOrderSubtotal().floatValue());
		assertEquals("0.9", transaction.getOrderTaxes().toString());
		assertEquals("5.4", transaction.getOrderTotal().toString());

		assertEquals(1, transaction.getTransactionElements().size());
		Map<String, TransactionElement> elements = transaction.getTransactionElements();
		TransactionElement element = elements.get(newUKDomain);
		assertEquals(newUKDomain, element.getDescription());
		assertEquals("SUCCEEDED", element.getElementStatus());
		assertEquals("4.5", element.getOrderLineSubtotal().toString());
		assertEquals("0.9", element.getOrderLineTaxes().toString());
		assertEquals("5.4", element.getOrderLineTotal().toString());

		// Now confirm that the registration actually took place correctly.
		DomainNameObject domainName = this.api.domains().get(newUKDomain);
		assertNotNull(domainName.getExpiryDate());
		assertEquals("Marky Babes", domainName.getOwnerContact().getName());
		assertEquals("IND", domainName.getOwnerContact().getAdditionalData().get("nominetRegistrantType"));
		assertTrue(domainName.getLocked());
		assertNull(domainName.getLockedUntil());
		assertEquals(1, domainName.getPrivacyProxy().intValue());
		assertTrue(domainName.getAutoRenew());

	}

	@Test
	void testWhenPrivacySettingSetToTwoThisIsCorrectlyReflectedOnCreate() throws Exception {

		String newUKDomain = "validdomain-" + new Date().getTime() + ".uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		String key = this.api.utility().createBulkOperation();

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 2, true), key);

		// Now confirm that the registration actually took place correctly.
		DomainNameObject domainName = this.api.domains().get(newUKDomain);
		assertEquals("Marky Babes", domainName.getOwnerContact().getName());
		assertEquals("IND", domainName.getOwnerContact().getAdditionalData().get("nominetRegistrantType"));
		assertTrue(domainName.getLocked());
		assertNull(domainName.getLockedUntil());
		assertEquals(2, domainName.getPrivacyProxy().intValue());
		assertTrue(domainName.getAutoRenew());
	}

	@Test
	void testOperationErrorReturnedAtTheTransactionLevelIfPaymentFailsForCreate() throws Exception {

		this.api.test().updateAccountBalance(1);

		String newUKDomain = "validdomain-" + new Date().getTime() + ".uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		Transaction transaction = this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain },
				1, owner, new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 2, false), null);

		assertEquals("DOMAIN_CREATE", transaction.getTransactionType());
		assertEquals("FAILED", transaction.getTransactionStatus());
		assertNotNull(transaction.getTransactionDateTime());

		assertNull(transaction.getOrderId());
		assertNull(transaction.getOrderCurrency());
		assertNull(transaction.getOrderSubtotal());
		assertNull(transaction.getOrderTaxes());
		assertNull(transaction.getOrderTotal());

		assertEquals(0, transaction.getTransactionElements().size());
		assertTrue(transaction.getTransactionError() instanceof TransactionError);
		assertEquals("PAYMENT_ERROR", transaction.getTransactionError().getCode());

		this.api.test().updateAccountBalance(10000);

	}

	@Test
	void testRenewFailsWithValidationErrorIfTooManyYearsAttemptedForAdd() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain1-" + new Date().getTime() + ".uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 2, true), null);

		Transaction transaction = this.api.domains()
				.renew(new DomainNameRenewDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 10), null);

		assertTrue(transaction instanceof Transaction);

		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertNotNull(transaction.getTransactionDateTime());
		assertNull(transaction.getOrderId());
		assertNull(transaction.getOrderCurrency());
		assertNull(transaction.getOrderSubtotal());
		assertNull(transaction.getOrderTaxes());
		assertNull(transaction.getOrderTotal());

		assertEquals(2, transaction.getTransactionElements().size());
		Map<String, TransactionElement> elements = transaction.getTransactionElements();
		TransactionElement element = elements.get(newUKDomain1);
		assertEquals(newUKDomain1, element.getDescription());
		assertEquals("FAILED", element.getElementStatus());
		assertNotNull(element.getElementErrors().get("DOMAIN_TOO_MANY_REGISTRATION_YEARS"));

		element = elements.get(newUKDomain2);
		assertEquals(newUKDomain2, element.getDescription());
		assertEquals("FAILED", element.getElementStatus());
		assertNotNull(element.getElementErrors().get("DOMAIN_TOO_MANY_REGISTRATION_YEARS"));

	}

	@Test
	void testCanRenewValidMultipleDomains() throws Exception {

		// Create a couple of new domains
		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain1-" + new Date().getTime() + ".uk";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		Transaction transaction = this.api
				.domains().create(
						new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
								new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 2, true),
						null);

		// Renew these domains
		String bulkKey = this.api.utility().createBulkOperation();

		transaction = this.api.domains()
				.renew(new DomainNameRenewDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 2), bulkKey);

		assertTrue(transaction instanceof Transaction);
		assertNotNull(transaction.getTransactionDateTime());
		assertEquals("DOMAIN_RENEW", transaction.getTransactionType());
		assertEquals("SUCCEEDED", transaction.getTransactionStatus());
		assertNotNull(transaction.getOrderId());
		assertEquals("GBP", transaction.getOrderCurrency());
		assertEquals("14.0", transaction.getOrderSubtotal().toString());
		assertEquals("2.8", transaction.getOrderTaxes().toString());
		assertEquals("16.8", transaction.getOrderTotal().toString());

		assertEquals(2, transaction.getTransactionElements().size());
		Map<String, TransactionElement> elements = transaction.getTransactionElements();

		TransactionElement element = elements.get(newUKDomain1);
		assertEquals(newUKDomain1, element.getDescription());
		assertEquals("SUCCEEDED", element.getElementStatus());
		assertEquals("7.0", element.getOrderLineSubtotal().toString());
		assertEquals("1.4", element.getOrderLineTaxes().toString());
		assertEquals("8.4", element.getOrderLineTotal().toString());

		element = elements.get(newUKDomain2);
		assertEquals(newUKDomain2, element.getDescription());
		assertEquals("SUCCEEDED", element.getElementStatus());
		assertEquals("7.0", element.getOrderLineSubtotal().toString());
		assertEquals("1.4", element.getOrderLineTaxes().toString());
		assertEquals("8.4", element.getOrderLineTotal().toString());

		Calendar expiryCalendar = Calendar.getInstance();
		expiryCalendar.add(Calendar.YEAR, 3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		// Check updated expiry data.

		DomainNameObject domainName = this.api.domains().get(newUKDomain1);
		assertEquals(dateFormat.format(expiryCalendar.getTime()), domainName.getExpiryDate().split(" ")[0]);

		domainName = this.api.domains().get(newUKDomain2);
		assertEquals(dateFormat.format(expiryCalendar.getTime()), domainName.getExpiryDate().split(" ")[0]);

	}

	@Test
	void testOperationErrorsAreReturnedIfAnAttemptToUpdateDomainForDomainNamesNotInAccount() throws Exception {

		DomainNameContact newContact = new DomainNameContact("Oxil Chocs", "oxil@mylanding.com", null, null, null,
				"Oxfordshire", "OX4 6DG", "GB", null, null, null, null, null, null, null, null);
		Transaction transaction = this.api.domains().update(new DomainNameUpdateDescriptor(
				new String[] { "bingo.com", "bingo.org" }, newContact, null, null, null, null, null, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement element1 = transaction.getTransactionElements().get("bingo.com");
		assertEquals("bingo.com", element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_NOT_IN_ACCOUNT"));

		TransactionElement element2 = transaction.getTransactionElements().get("bingo.org");
		assertEquals("bingo.org", element2.getDescription());
		assertEquals("FAILED", element2.getElementStatus());
		assertEquals(1, element2.getElementErrors().size());
		assertNotNull(element2.getElementErrors().get("DOMAIN_NOT_IN_ACCOUNT"));

	}

	@Test
	void testOperationErrorsAreReturnedIfAnAttemptToUpdateDomainForNonActiveDomainNames() throws Exception {

		String testInactiveDomain = "inactivedomain-" + new Date().getTime() + ".rodeo";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { testInactiveDomain }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, true), null);

		// Now make the domain inactive
		this.api.test().updateDomains(
				new TestDomainNameUpdateDescriptor(new String[] { testInactiveDomain }, "EXPIRED", null, null, null));

		// Attempt an update of inactive domain
		DomainNameContact newContact = new DomainNameContact("Oxil Chocs", "oxil@mylanding.com", null, null, null,
				"Oxfordshire", "OX4 6DG", "GB", null, null, null, null, null, null, null, null);
		Transaction transaction = this.api.domains().update(new DomainNameUpdateDescriptor(
				new String[] { testInactiveDomain }, newContact, null, null, null, null, null, null, null), null);

		TransactionElement element1 = transaction.getTransactionElements().get(testInactiveDomain);
		assertEquals(testInactiveDomain, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_INVALID_FOR_UPDATE"));

		// Now make the domain inactive
		this.api.test().updateDomains(
				new TestDomainNameUpdateDescriptor(new String[] { testInactiveDomain }, "SUSPENDED", null, null, null));

		// Attempt an update of inactive domain
		newContact = new DomainNameContact("Oxil Chocs", "oxil@mylanding.com", null, null, null, "Oxfordshire",
				"OX4 6DG", "GB", null, null, null, null, null, null, null, null);
		transaction = this.api.domains().update(new DomainNameUpdateDescriptor(new String[] { testInactiveDomain },
				newContact, null, null, null, null, null, null, null), null);

		element1 = transaction.getTransactionElements().get(testInactiveDomain);
		assertEquals(testInactiveDomain, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_INVALID_FOR_UPDATE"));

		// Now make the domain inactive
		this.api.test().updateDomains(
				new TestDomainNameUpdateDescriptor(new String[] { testInactiveDomain }, "RGP", null, null, null));

		// Attempt an update of inactive domain
		newContact = new DomainNameContact("Oxil Chocs", "oxil@mylanding.com", null, null, null, "Oxfordshire",
				"OX4 6DG", "GB", null, null, null, null, null, null, null, null);

		transaction = this.api.domains().update(new DomainNameUpdateDescriptor(new String[] { testInactiveDomain },
				newContact, null, null, null, null, null, null, null), null);

		element1 = transaction.getTransactionElements().get(testInactiveDomain);
		assertEquals(testInactiveDomain, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_INVALID_FOR_UPDATE"));

	}

	@Test
	void testValidationErrorsAreReturnedWhenBulkUpdatingContactsForDomainNames() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain1-" + new Date().getTime() + ".uk";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);
		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, true), null);

		DomainNameContact newContact = new DomainNameContact("Oxil Chocs", "oxil@mylanding.com", "Bingo", null, null,
				null, "Oxfordshire", "OX4 6DG", "GB", null, null, null, null, null, null, null);

		Transaction transaction = this.api.domains()
				.update(new DomainNameUpdateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, newContact, null,
						null, null, null, null, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement element1 = transaction.getTransactionElements().get(newUKDomain1);
		assertEquals(newUKDomain1, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_INVALID_OWNER_CONTACT"));

		Map<String, TransactionError> subordinateErrors = element1.getElementErrors()
				.get("DOMAIN_INVALID_OWNER_CONTACT").getRelatedErrors();

		assertNotNull(subordinateErrors.get("CONTACT_MISSING_CITY"));
		assertNotNull(subordinateErrors.get("CONTACT_MISSING_NOMINETREGISTRANTTYPE"));

	}

	@Test
	void testSuccessfulTransactionIsReturnedWhenContactUpdateSucceeds() throws Exception {

		String newUKDomain = "validdomain-" + new Date().getTime() + ".uk";

		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "myorg", "33 My Street", null,
				"Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);

		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, true), null);

		additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "STAT");
		DomainNameContact newOwner = new DomainNameContact("New Man", "new@oxil.co.uk", "My Business", "66 My Street",
				"Arbury", "Cambridge", "Cambs", "CB4 2JL", "FR", "+44", "18657878787", "123", "+44", "18657878787",
				"123", additionalData);

		Transaction transaction = this.api.domains().update(new DomainNameUpdateDescriptor(new String[] { newUKDomain },
				newOwner, null, null, null, null, null, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("SUCCEEDED", transaction.getTransactionStatus());
		assertEquals(1, transaction.getTransactionElements().size());

		TransactionElement transactionElement = transaction.getTransactionElements().get(newUKDomain);
		assertEquals("SUCCEEDED", transactionElement.getElementStatus());

		// Now actually pull the contact and check the update
		DomainNameObject domainName = this.api.domains().get(newUKDomain);
		DomainNameContact ownerContact = domainName.getOwnerContact();
		assertEquals("New Man", ownerContact.getName());
		assertEquals("new@oxil.co.uk", ownerContact.getEmailAddress());
		assertEquals("66 My Street", ownerContact.getStreet1());
		assertEquals("Arbury", ownerContact.getStreet2());
		assertEquals("Cambridge", ownerContact.getCity());
		assertEquals("Cambs", ownerContact.getCounty());
		assertEquals("CB4 2JL", ownerContact.getPostcode());
		assertEquals("FR", ownerContact.getCountry());
		assertEquals("My Business", ownerContact.getOrganisation());
		assertEquals("+44", ownerContact.getTelephoneDiallingCode());
		assertEquals("18657878787", ownerContact.getTelephone());
		assertEquals("123", ownerContact.getTelephoneExt());
		assertEquals("+44", ownerContact.getFaxDiallingCode());
		assertEquals("18657878787", ownerContact.getFax());
		assertEquals("123", ownerContact.getFaxExt());
		assertEquals("STAT", ownerContact.getAdditionalData().get("nominetRegistrantType"));

	}

	@Test
	void testValidationErrorsOccurIfBulkUpdatingNameserversForInvalidNames() throws Exception {
		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain1-" + new Date().getTime() + ".uk";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);
		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, true), null);

		Transaction transaction = this.api.domains()
				.update(new DomainNameUpdateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, null, null, null,
						null, new String[] { "22.45.66.77", "rubbishdnsname" }, null, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement element1 = transaction.getTransactionElements().get(newUKDomain1);
		assertEquals(newUKDomain1, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertNotNull(element1.getElementErrors().get("DOMAIN_INVALID_NAMESERVER_FORMAT"));

		TransactionElement element2 = transaction.getTransactionElements().get(newUKDomain2);
		assertEquals(newUKDomain2, element2.getDescription());
		assertEquals("FAILED", element2.getElementStatus());
		assertEquals(1, element2.getElementErrors().size());
		assertNotNull(element2.getElementErrors().get("DOMAIN_INVALID_NAMESERVER_FORMAT"));

	}

	@Test
	void testSuccessfulTransactionIsReturnedWhenNameserverUpdateSucceeds() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain1-" + new Date().getTime() + ".uk";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", null, null, null, null, null, null, null);
		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, true), null);

		Transaction transaction = this.api.domains()
				.update(new DomainNameUpdateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, null, null, null,
						null, new String[] { "ns1.oxil.com", "ns2.oxil.com", "ns3.oxil.com" }, null, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("SUCCEEDED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement transactionElement = transaction.getTransactionElements().get(newUKDomain1);
		assertEquals("SUCCEEDED", transactionElement.getElementStatus());

		transactionElement = transaction.getTransactionElements().get(newUKDomain2);
		assertEquals("SUCCEEDED", transactionElement.getElementStatus());

		// Now actually pull the domain and check the update
		DomainNameObject domainName = this.api.domains().get(newUKDomain1);
		String[] ns = domainName.getNameservers();
		assertEquals("ns1.oxil.com", ns[0]);
		assertEquals("ns2.oxil.com", ns[1]);
		assertEquals("ns3.oxil.com", ns[2]);

		domainName = this.api.domains().get(newUKDomain2);
		ns = domainName.getNameservers();
		assertEquals("ns1.oxil.com", ns[0]);
		assertEquals("ns2.oxil.com", ns[1]);
		assertEquals("ns3.oxil.com", ns[2]);

	}

	@Test
	void testValidationErrorsOccurIfBulkUpdatingLockedStatusToUnlockedWhenMandatoryLockInPlace() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".rodeo";
		String newUKDomain2 = "validdomain-" + new Date().getTime() + "1.rodeo";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", "", "", "", "", "", "", null);
		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, 2, true), null);

		Transaction transaction = this.api.domains().update(new DomainNameUpdateDescriptor(
				new String[] { newUKDomain1, newUKDomain2 }, null, null, null, null, null, false, null, null), null);

		assertTrue(transaction instanceof Transaction);
		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("ALL_ELEMENTS_FAILED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement element1 = transaction.getTransactionElements().get(newUKDomain1);
		assertEquals(newUKDomain1, element1.getDescription());
		assertEquals("FAILED", element1.getElementStatus());
		assertEquals(1, element1.getElementErrors().size());
		assertTrue(element1.getElementErrors().containsKey("DOMAIN_IN_MANDATORY_LOCK"));

		TransactionElement element2 = transaction.getTransactionElements().get(newUKDomain2);
		assertEquals(newUKDomain2, element2.getDescription());
		assertEquals("FAILED", element2.getElementStatus());
		assertEquals(1, element2.getElementErrors().size());
		assertTrue(element2.getElementErrors().containsKey("DOMAIN_IN_MANDATORY_LOCK"));

	}

	@Test
	void testCanUpdateValidDomainAttributesCorrectlyForDomainNames() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
		String newUKDomain2 = "validdomain-" + new Date().getTime() + "1.uk";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", "", "", "", "", "", "", null);
		Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);

		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, null), null);

		this.api.test().updateDomains(
				new TestDomainNameUpdateDescriptor(new String[] { newUKDomain1 }, null, null, null, null));

		Transaction transaction = this.api.domains().update(new DomainNameUpdateDescriptor(
				new String[] { newUKDomain1, newUKDomain2 }, null, null, null, null, null, false, 0, true), null);

		assertTrue(transaction instanceof Transaction);

		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("SUCCEEDED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		TransactionElement transactionElement = transaction.getTransactionElements().get(newUKDomain1);
		assertEquals("SUCCEEDED", transactionElement.getElementStatus());

		transactionElement = transaction.getTransactionElements().get(newUKDomain2);
		assertEquals("SUCCEEDED", transactionElement.getElementStatus());

		// Now actually pull the domain and check the update
		DomainNameObject domainName = this.api.domains().get(newUKDomain1);
		assertFalse(domainName.getLocked());
		assertEquals(0, (int) domainName.getPrivacyProxy());
		assertTrue(domainName.getAutoRenew());

		domainName = this.api.domains().get(newUKDomain2);
		assertFalse(domainName.getLocked());
		assertEquals(0, (int) domainName.getPrivacyProxy());
		assertTrue(domainName.getAutoRenew());

		// Now try and set privacy proxy to 2
		transaction = this.api.domains().update(new DomainNameUpdateDescriptor(
				new String[] { newUKDomain1, newUKDomain2 }, null, null, null, null, null, null, 2, null), null);

		// Now actually pull the domain and check the update
		domainName = this.api.domains().get(newUKDomain1);
		assertFalse(domainName.getLocked());
		assertEquals(2, (int) domainName.getPrivacyProxy());
		assertTrue(domainName.getAutoRenew());
	}

	@Test
	void testTransactionProgressForUpdatesAreMonitoredCorrectlyWhenProgressKeyPassed() throws Exception {

		String newUKDomain1 = "validdomain-" + new Date().getTime() + ".rodeo";
		String newUKDomain2 = "validdomain-" + new Date().getTime() + "1.rodeo";
		DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", "", "", "", "", "", "", null);
		this.api.domains().create(new DomainNameCreateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, 1, owner,
				new String[] { "ns1.netistrar.com", "ns2.netistrar.com" }, null, null, null, null, null), null);

		this.api.test().updateDomains(
				new TestDomainNameUpdateDescriptor(new String[] { newUKDomain1 }, null, "_UNSET", "_UNSET", null));

		String progressKey = this.api.utility().createBulkOperation();

		// Run transaction
		Transaction transaction = this.api.domains()
				.update(new DomainNameUpdateDescriptor(new String[] { newUKDomain1, newUKDomain2 }, null, null, null,
						null, null, false, 0, true), progressKey);

		assertTrue(transaction instanceof Transaction);

		assertEquals("DOMAIN_UPDATE", transaction.getTransactionType());
		assertEquals("PARTIALLY_SUCCEEDED", transaction.getTransactionStatus());
		assertEquals(2, transaction.getTransactionElements().size());

		
		// Also, check the bulk operation
		BulkOperationProgress bulkOperationProgress = this.api.utility().getBulkOperationProgress(progressKey);
		assertEquals("COMPLETED", bulkOperationProgress.getStatus());
		assertEquals("SUCCEEDED", bulkOperationProgress.getProgressItems()[0].getStatus());
		assertEquals("FAILED", bulkOperationProgress.getProgressItems()[1].getStatus());

	}
	
	

	@Test
	void testCanGetMultipleDomainNamesIfValid() throws Exception {

        // Firstly, attempt to get invalid domains with ignore set to false.
        try {
            this.api.domains().getMultiple(new String[] {"biggles.com", "boggles.org"}, false);
            fail("Should have thrown an exception here.");
        } catch (TransactionException e) {
        		
            assertEquals(1, e.getTransactionErrors().size());
            assertEquals("DOMAIN_NOT_IN_ACCOUNT", e.getTransactionErrors().get("DOMAIN_NOT_IN_ACCOUNT").getCode());
            assertEquals(new ArrayList(Arrays.asList(new String[]{"biggles.com", "boggles.org"})) , e.getTransactionErrors().get("DOMAIN_NOT_IN_ACCOUNT").getAdditionalInfo().get("missingDomainNames"));
        }


        String newUKDomain1 = "validdomain-" + new Date().getTime() + ".uk";
        String newUKDomain2 = "validdomain-" + new Date().getTime() + "1.uk";
        DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", "", "", "", "", "", "", null);
        //owner.__setSerialisablePropertyValue("status", "LIVE");
        Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);
		
        this.api.domains().create(new DomainNameCreateDescriptor(new String[] {newUKDomain1, newUKDomain2}, 1, owner, 
        		new String[] {"ns1.netistrar.com", "ns2.netistrar.com"}, null, null, null, 2,false), null);


        this.api.test().updateDomains(new TestDomainNameUpdateDescriptor(new String[] {newUKDomain1}, null, "_UNSET", "_UNSET", false));

        // Check that with ignore set to true, only valid domains are returned.
        Map<String,DomainNameObject> domains = this.api.domains().getMultiple(new String[] {"biggles.com", "boggles.org"}, true);
        assertEquals(0, domains.size());


        // Now check we can get the domain names as expected.
        Map<String,DomainNameObject> domainNames = this.api.domains().getMultiple(new String[] {newUKDomain1, newUKDomain2},true);
        assertEquals(2, domainNames.size());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        Date expiryDate = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
       
        
       // assertTrue(domainNames.get(newUKDomain1) instanceof DomainNameObject);
        DomainNameObject domainName = domainNames.get(newUKDomain1);
        assertEquals(newUKDomain1, domainName.getDomainName());
        assertEquals("ns1.netistrar.com", domainName.getNameservers()[0]);
        assertEquals("ns2.netistrar.com", domainName.getNameservers()[1]);
        assertEquals("Marky Babes", domainName.getOwnerContact().getName());
        assertEquals(null, domainName.getAdminContact());
        assertEquals(null, domainName.getBillingContact());
        assertEquals(null, domainName.getTechnicalContact());
        assertEquals(format.format(expiryDate), domainName.getExpiryDate().substring(0, 10));
        assertEquals(false, domainName.getAutoRenew());
        assertEquals(false, domainName.getLocked());
        assertEquals(2, (int)domainName.getPrivacyProxy());
        assertNotEquals("N/A", domainName.getAuthCode());

        assertTrue(domainNames.get(newUKDomain2) instanceof DomainNameObject);
        domainName = domainNames.get(newUKDomain2);
        assertEquals(newUKDomain2, domainName.getDomainName());
        assertEquals(format.format(new Date()), domainName.getRegisteredDate().substring(0, 10));
        assertEquals("ns1.netistrar.com", domainName.getNameservers()[0]);
        assertEquals("ns2.netistrar.com", domainName.getNameservers()[1]);
        assertEquals("Marky Babes", domainName.getOwnerContact().getName());
        assertEquals(null, domainName.getAdminContact());
        assertEquals(null, domainName.getBillingContact());
        assertEquals(null, domainName.getTechnicalContact());
        assertEquals(format.format(expiryDate),domainName.getExpiryDate().substring( 0, 10));
        assertEquals(false, domainName.getAutoRenew());
        assertEquals(true, domainName.getLocked());
        assertNull(domainName.getLockedUntil());
        assertEquals("N/A", domainName.getAuthCode());
        assertEquals(2, (int)domainName.getPrivacyProxy());


    }


	@Test
	void testCanListDomains() throws Exception {


        String listDomain1 = "zzzz-domain" + new Date().getTime() + ".uk";
        String listDomain2 = "zzzz-domain" + new Date().getTime() + "1.uk";
        String listDomain3 = "zzzz-domain" + new Date().getTime() + "2.uk";
        String listDomain4 = "aaaa-domain" + new Date().getTime() + ".uk";
        String listDomain5 = "aaaa-domain" + new Date().getTime() + "1.uk";
        String listDomain6 = "aaaa-domain" + new Date().getTime() + "2.uk";


        DomainNameContact owner = new DomainNameContact("Marky Babes", "mark@oxil.co.uk", "My Org", "33 My Street",
				null, "Oxford", "Oxon", "OX4 2RD", "GB", "", "", "", "", "", "", null);
        //owner.__setSerialisablePropertyValue("status", "LIVE");
        Map<String, Object> additionalData = new HashMap<String, Object>();
		additionalData.put("nominetRegistrantType", "IND");
		owner.setAdditionalData(additionalData);
		
        this.api.domains().create(new DomainNameCreateDescriptor(new String[] {listDomain1, listDomain2, listDomain3, listDomain4, listDomain5, listDomain6}, 1, owner, 
        		new String[] {"ns1.netistrar.com", "ns2.netistrar.com"}, null, null, null, 2,false), null);


        // Try a reverse order list
        DomainNameListResults listedDomains = this.api.domains().list("", 10, 1, "domainName", "DESC");

        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(10, (int)listedDomains.getPageSize());
        assertEquals(1, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(10, listedDomains.getDomainNameSummaries().length);
        assertEquals(listDomain3, listedDomains.getDomainNameSummaries()[0].getDomainName());
        assertEquals(listDomain2, listedDomains.getDomainNameSummaries()[1].getDomainName());
        assertEquals(listDomain1, listedDomains.getDomainNameSummaries()[2].getDomainName());

        // Try a paged list
        listedDomains = this.api.domains().list("", 1, null, "domainName", "DESC");

        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(1, (int)listedDomains.getPageSize());
        assertEquals(1, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(1, listedDomains.getDomainNameSummaries().length);
        assertEquals(listDomain3, listedDomains.getDomainNameSummaries()[0].getDomainName());

        // Page 2
        listedDomains = this.api.domains().list("", 1, 2, "domainName", "DESC");
        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(1, (int)listedDomains.getPageSize());
        assertEquals(2, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(1, listedDomains.getDomainNameSummaries().length);
        assertEquals(listDomain2, listedDomains.getDomainNameSummaries()[0].getDomainName());

        // Bigger page size
        listedDomains = this.api.domains().list("", 2, 1, "domainName", "DESC");
        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(2, (int)listedDomains.getPageSize());
        assertEquals(1, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(2, listedDomains.getDomainNameSummaries().length);
        assertEquals(listDomain3, listedDomains.getDomainNameSummaries()[0].getDomainName());
        assertEquals(listDomain2, listedDomains.getDomainNameSummaries()[1].getDomainName());

        // Page 2
        listedDomains = this.api.domains().list("", 2, 2, "domainName", "DESC");
        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(2, (int)listedDomains.getPageSize());
        assertEquals(2, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(2, listedDomains.getDomainNameSummaries().length);
        assertEquals(listDomain1, listedDomains.getDomainNameSummaries()[0].getDomainName());

        // Different sort column
        listedDomains = this.api.domains().list("", 10, 1, "registeredDate", "DESC");
        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("", listedDomains.getSearchTerm());
        assertEquals(10, (int)listedDomains.getPageSize());
        assertEquals(1, (int)listedDomains.getPage());
        assertEquals("registeredDate", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() > 10);
        assertTrue(listedDomains.getTotalNumberOfPages() > 1);
        assertEquals(10, listedDomains.getDomainNameSummaries().length);
        

        // Filtered search
        listedDomains = this.api.domains().list("aaaa", 10, 1, "domainName", "DESC");
        assertTrue(listedDomains instanceof DomainNameListResults);
        assertEquals("aaaa", listedDomains.getSearchTerm());
        assertEquals(10, (int)listedDomains.getPageSize());
        assertEquals(1, (int)listedDomains.getPage());
        assertEquals("domainName", listedDomains.getOrderBy());
        assertEquals("DESC", listedDomains.getOrderDirection());
        assertTrue(listedDomains.getTotalNumberOfDomains() >= 3);
        assertTrue(listedDomains.getTotalNumberOfPages() >= 1);
        assertEquals(listDomain6, listedDomains.getDomainNameSummaries()[0].getDomainName());
        assertEquals(listDomain5, listedDomains.getDomainNameSummaries()[1].getDomainName());
        assertEquals(listDomain4, listedDomains.getDomainNameSummaries()[2].getDomainName());


    }

	
	

}
