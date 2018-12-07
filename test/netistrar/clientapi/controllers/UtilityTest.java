package netistrar.clientapi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import netistrar.clientapi.APIProvider;
import netistrar.clientapi.exception.RateLimitExceededException;

public class UtilityTest {
	private APIProvider api;

	public UtilityTest() {
		this.api = new APIProvider("http://restapi.netistrar.test", "TESTAPIKEY", "TESTAPISECRET");
	}

	@Test
	void testRateLimitExceededExceptionRaisedWhenRateExceeded() throws Exception {

		try {
			for (int i = 0; i < 11; i++) {
				this.api.utility().ping();
			}
			fail("should have failed");
		} catch (RateLimitExceededException $e) {
		}

		assertTrue(true);

	}

}
