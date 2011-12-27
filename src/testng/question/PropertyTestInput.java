package testng.question;

import java.util.Iterator;

public class PropertyTestInput {

	private final String xmlPayload;
	private final TestParameters testParams;

	public PropertyTestInput(final String xmlPayload,
			final TestParameters testParams) {
		super();
		this.xmlPayload = xmlPayload;
		this.testParams = testParams;
	}

	public String getXmlPayload() {
		return xmlPayload;
	}

	public TestParameters getTestParams() {
		return testParams;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(testParams.getUrl());
		builder.append(": ");

		for (final Iterator<WebserviceProperty> it = testParams.getProperties()
				.iterator(); it.hasNext();) {

			builder.append(it.next().toString());
			if (it.hasNext()) {
				builder.append(", ");
			}
		}
		return builder.toString();
	}
}
