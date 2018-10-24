package netistrar.clientapi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import netistrar.clientapi.APIProvider;
import netistrar.clientapi.objects.domain.DomainNameContact;
import netistrar.clientapi.objects.domain.DomainNameTransaction;
import netistrar.clientapi.objects.domain.descriptor.DomainNameCreateDescriptor;

class DomainsTest {

	private APIProvider api;

	public DomainsTest() {
		this.api = new APIProvider("http://restapi.netistrar.test", "TESTAPIKEY");
	}

	@Test
	void testCanValidateCreateOperationsForMultipleDomains() throws Exception {

		String ukDomain = "validationdomain.uk";
		String comDomain = "validationdomain.com";
		DomainNameContact owner = new DomainNameContact();

		DomainNameCreateDescriptor createDescriptor = new DomainNameCreateDescriptor(
				new String[] { ukDomain, comDomain }, 1, owner, new String[] { "monkeynameserver" }, null, null, null,
				null, null);

		Map<String, Object> validationErrors = this.api.domains().validate(createDescriptor);

		Map<String, Object> ukValidationErrors = (Map<String, Object>) validationErrors.get(ukDomain);
		assertTrue(ukValidationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(ukValidationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));

		Map<String, Object> comValidationErrors = (Map<String, Object>) validationErrors.get(comDomain);

		assertTrue(comValidationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(comValidationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));

	}

	@Test
	void testFailedTransactionIsReturnedIfValidationErrorsOnCreate() throws Exception {

		String ukDomain = "validationdomain.uk";
		String comDomain = "validationdomain.com";
		DomainNameContact owner = new DomainNameContact();

		DomainNameCreateDescriptor createDescriptor = new DomainNameCreateDescriptor(
				new String[] { ukDomain}, 1, owner, new String[] { "monkeynameserver" }, null, null, null,
				null, null);

		DomainNameTransaction domainTransaction = this.api.domains().create(createDescriptor, null);

		assertEquals(1, domainTransaction.getTransactionElements().size());
		Map<String, Object> validationErrors =  domainTransaction.getTransactionElements().get(ukDomain).getElementErrors();
		assertTrue(validationErrors.keySet().contains("DOMAIN_INVALID_OWNER_CONTACT"));
		assertTrue(validationErrors.keySet().contains("DOMAIN_INVALID_NAMESERVER_FORMAT"));
	
		
	}
	
	
	

}
