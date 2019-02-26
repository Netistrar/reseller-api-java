package netistrar.clientapi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import netistrar.clientapi.APIProvider;
import netistrar.clientapi.objects.domain.DomainAvailability;
import netistrar.clientapi.objects.domain.DomainAvailabilityPrice;
import netistrar.clientapi.objects.domain.DomainAvailabilityResults;
import netistrar.clientapi.objects.domain.descriptor.DomainNameAvailabilityDescriptor;
import netistrar.clientapi.objects.domain.descriptor.DomainNameSuggestionOptions;

class DomainAvailabilityTest {

	private APIProvider api;

	public DomainAvailabilityTest() {
		this.api = new APIProvider("http://restapi.netistrar.test", "TESTAPIKEY", "TESTAPISECRET");
	}

	@Test
	void testCanGetHintedDomainAvailabilityViaAPI() throws Exception {

		DomainAvailabilityResults availability = this.api.domains()
				.hintedAvailability(new DomainNameAvailabilityDescriptor().setSearchString("test.com"));

		assertTrue(availability instanceof DomainAvailabilityResults);
		DomainAvailability directResult = availability.getDirectResult();
		assertTrue(directResult instanceof DomainAvailability);

		assertEquals("HINTED_UNAVAILABLE", directResult.getAvailability());
		assertEquals(1, directResult.getPrices().get("transfer").length);

		availability = this.api.domains().hintedAvailability(new DomainNameAvailabilityDescriptor("bodybuilding", null,
				new String[] { "com", "net", "org" }, true, null));

		assertEquals("bodybuilding.com", availability.getTldResults().get("com").getDomainName());
		assertTrue(availability.getTldSuggestions().get("org").length > 0);

	}

	@Test
	void testCanFillHintedSuggestionsUsingSuggestedOptions() throws Exception {
		DomainNameSuggestionOptions suggestedOptions = new DomainNameSuggestionOptions(true, true, 20);
		DomainNameAvailabilityDescriptor descriptor = new DomainNameAvailabilityDescriptor("testing1234567", null, null,
				true, suggestedOptions);
		DomainAvailabilityResults availability = this.api.domains().hintedAvailability(descriptor);

		assertTrue(availability instanceof DomainAvailabilityResults);
		assertEquals((int) suggestedOptions.getFillCount(), (int) availability.getSuggestions().length);
	}

	@Test
	void testCanRemoveTldsFromSuggestionsUsingSuggestedOptions() throws Exception {
		DomainNameSuggestionOptions suggestedOptions = new DomainNameSuggestionOptions(false, false, 10);
		DomainNameAvailabilityDescriptor descriptor = new DomainNameAvailabilityDescriptor("testing123456", null, null,
				true, suggestedOptions);
		DomainAvailabilityResults availability = this.api.domains().hintedAvailability(descriptor);

		assertTrue(availability instanceof DomainAvailabilityResults);
		assertNull(availability.getTldResults());
	}

	@Test
	void testCanGetLiveAvailabilityViaAPI() throws Exception {

		DomainAvailability availability = this.api.domains().liveAvailability("james.uk");
		assertTrue(availability instanceof DomainAvailability);
		assertEquals("AVAILABLE", availability.getAvailability());
		assertEquals(10, availability.getPrices().get("registration").length);

		assertTrue(availability.getPrices().get("registration")[0] instanceof DomainAvailabilityPrice);

	}

	@Test
	void testCanGetAllTLDsOptionallyLimitedByCategory() throws Exception {

		String[] tlds = this.api.domains().tldList(null);
		assertTrue(tlds.length > 100);
		List tldList = Arrays.asList(tlds);
		assertTrue(tldList.contains("uk"));
		assertTrue(tldList.contains("com"));

		tlds = this.api.domains().tldList("National");
		tldList = Arrays.asList(tlds);
		assertEquals(7, tlds.length);
		assertTrue(tldList.contains("uk"));
		assertTrue(tldList.contains("scot"));

		tlds = this.api.domains().tldList("Popular");
		tldList = Arrays.asList(tlds);
		assertEquals(7, tlds.length);
		assertTrue(tldList.contains("computer"));
		assertTrue(tldList.contains("community"));

	}

	@Test
	void testCanGetAllTLDCategories() throws Exception {

		String[] categories = this.api.domains().tldCategoryList();
		List categoryList = Arrays.asList(categories);
		assertTrue(categoryList.contains("Popular"));
		assertTrue(categoryList.contains("National"));
		assertTrue(categoryList.contains("International"));
	}

}
