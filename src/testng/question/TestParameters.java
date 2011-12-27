package testng.question;

import java.util.ArrayList;
import java.util.List;

public class TestParameters {
	private final String url;
	private final List<WebserviceProperty> properties = new ArrayList<WebserviceProperty>();

	public String getUrl() {
		return url;
	}

	public List<WebserviceProperty> getProperties() {
		return properties;
	}

	public TestParameters(final String url) {
		super();
		this.url = url;
	}

	@Override
	public String toString() {

		return this.url;
	}
}
