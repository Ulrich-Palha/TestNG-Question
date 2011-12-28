package testng.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWebService {

	// used to pass data between tests
	private final List<PropertyTestInput> webServiceOutput = new ArrayList<PropertyTestInput>();

	@Test(dataProvider = "getWebServiceUrls", priority = 1)
	public void testWebserviceStatus(final TestParameters params) {
		final String xmlPayload = stubWebservice(params.getUrl());

		for (int ii = params.getProperties().size() - 1; ii >= 0; ii--) {

			final PropertyTestInput input = new PropertyTestInput(xmlPayload,
					params, ii);
			// Code to verify status code of webservice would go here

			// add output of test and original test params as input to next test
			webServiceOutput.add(input);
		}
	}

	@Test(dataProvider = "getPropertyTestInput", priority = 2)
	public void testWebserviceProperties(final PropertyTestInput input) {
		// Code to test WebServiceProperties goes here
	}

	@DataProvider(name = "getPropertyTestInput")
	public Iterator getPropertyTestInput() {
		return new TestNGIterator<PropertyTestInput>(
				this.webServiceOutput.iterator());

	}

	@DataProvider(name = "getWebServiceUrls")
	public Object[][] getWebServiceUrls() {

		// hardcoded for illustration purposes
		final TestParameters param1 = new TestParameters(
				"http://mydomain.com/ws/customer/65");
		param1.getProperties().add(new WebserviceProperty("name", "Joe"));
		param1.getProperties().add(new WebserviceProperty("member", "true"));
		final TestParameters param2 = new TestParameters(
				"http://mydomain.com/ws/customer/69");
		param2.getProperties().add(new WebserviceProperty("age", "24"));
		param2.getProperties().add(new WebserviceProperty("zip", "1011"));
		return new Object[][] { { param1 }, { param2 } };
	}

	class TestNGIterator<E> implements Iterator {
		private final Iterator<E> it;

		public TestNGIterator(final Iterator<E> it) {
			this.it = it;
		}

		public boolean hasNext() {
			return it.hasNext();
		}

		public Object next() {
			final E element = it.next();
			return new Object[] { element };
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// Assume real webservice returns an XML document
	private String stubWebservice(final String url) {
		final int serviceNum = Integer
				.parseInt(url.substring(url.length() - 2));

		String retVal = "";
		switch (serviceNum) {
		case 65:
			retVal = "name=Joe&member=true";
			break;
		case 69:
			retVal = "age=24&zip=10011";
			break;
		}
		return retVal;
	}
}
