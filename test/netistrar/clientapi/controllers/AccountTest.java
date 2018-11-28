package netistrar.clientapi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import netistrar.clientapi.APIProvider;
import netistrar.clientapi.objects.account.AccountNotification;
import netistrar.clientapi.objects.domain.DomainNameContact;
import netistrar.clientapi.objects.domain.descriptor.DomainNameTransferDescriptor;

public class AccountTest {

	private APIProvider api;

	public AccountTest() {
		this.api = new APIProvider("http://restapi.netistrar.test", "TESTAPIKEY", "TESTAPISECRET");
	}

	@Test
	void testCanRetrieveCurrentBalance() throws Exception {

		this.api.test().updateAccountBalance(10000);

		float result = this.api.account().balance();
		assertEquals(10000, result);

		this.api.test().updateAccountBalance(7500);

		result = this.api.account().balance();
		assertEquals(7500, result);

	}

	@Test
	void testCanListAndGetSingleAccountNotifications() throws Exception {

		String[][] newDomains = this.api.test().createPullTransferRodeoDomains(2);

		String rodeoTestDomain = newDomains[0][0];
		String rodeoTestAuth = newDomains[0][1];
		String rodeoTestIdentifier = rodeoTestDomain + "," + rodeoTestAuth;

		String rodeoTestDomain2 = newDomains[1][0];
		String rodeoTestAuth2 = newDomains[1][1];
		String rodeoTestIdentifier2 = rodeoTestDomain2 + "," + rodeoTestAuth2;

		DomainNameContact validContact = new DomainNameContact("Test", "test@test.com", "", "hello street",
				"hello road", "hello", "helloshire", "he12 144", "GB", "", "", "", "", "", "",
				new HashMap<String, Object>());

		String[] domains = new String[] { rodeoTestIdentifier, rodeoTestIdentifier2 };

		this.api.domains().transferCreate(
				new DomainNameTransferDescriptor(domains, validContact, null, null, null, 1, true), null);
		this.api.test().approveIncomingTransferOtherRegistrar(new String[] { rodeoTestDomain });
		this.api.test().rejectIncomingTransferOtherRegistrar(new String[] { rodeoTestDomain2 });

		AccountNotification[] allAccountNotifications = this.api.account().listNotifications(50, "", "");
		assertTrue(allAccountNotifications.length >= 4);

		AccountNotification firstNotification = allAccountNotifications[0];
		AccountNotification secondNotification = allAccountNotifications[1];
		AccountNotification thirdNotification = allAccountNotifications[2];
		AccountNotification fourthNotification = allAccountNotifications[3];

		assertEquals("Domain Transfer In - Rejected",
				firstNotification.getNotificationType() + " - " + firstNotification.getNotificationSubType());
		assertEquals("Domain Transfer In - Completed",
				secondNotification.getNotificationType() + " - " + secondNotification.getNotificationSubType());
		assertEquals("Domain Transfer In - Initiated",
				thirdNotification.getNotificationType() + " - " + thirdNotification.getNotificationSubType());
		assertEquals("Domain Transfer In - Initiated",
				fourthNotification.getNotificationType() + " - " + fourthNotification.getNotificationSubType());

		AccountNotification[] limitedNotifications = this.api.account().listNotifications(2, "", "");
		assertEquals(2, limitedNotifications.length);
		assertTrue(firstNotification.equals(limitedNotifications[0]));
		assertTrue(secondNotification.equals(limitedNotifications[1]));

		limitedNotifications = this.api.account().listNotifications(50, "Domain Transfer In", "Initiated");
		assertTrue(limitedNotifications.length >= 2);
		assertTrue(thirdNotification.equals(limitedNotifications[0]));
		assertTrue(fourthNotification.equals(limitedNotifications[1]));

		limitedNotifications = this.api.account().listNotifications(50, "Domain Transfer In", "Completed");
		assertTrue(limitedNotifications.length >= 1);
		assertTrue(secondNotification.equals(limitedNotifications[0]));

		limitedNotifications = this.api.account().listNotifications(50, "Domain Transfer In", "Completed,Rejected");
		assertTrue(limitedNotifications.length >= 2);
		assertTrue(firstNotification.equals(limitedNotifications[0]));
		assertTrue(secondNotification.equals(limitedNotifications[1]));

		assertTrue(firstNotification.equals(this.api.account().getNotification(firstNotification.getId())));
		assertTrue(secondNotification.equals(this.api.account().getNotification(secondNotification.getId())));
		assertTrue(thirdNotification.equals(this.api.account().getNotification(thirdNotification.getId())));
		assertTrue(fourthNotification.equals(this.api.account().getNotification(fourthNotification.getId())));

	}

}
