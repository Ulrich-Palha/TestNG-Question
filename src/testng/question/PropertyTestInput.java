package testng.question;


public class PropertyTestInput {

	private final String xmlPayload;
	private final TestParameters testParams;
	private final int testPropertyIndex;

	public PropertyTestInput(final String xmlPayload,
			final TestParameters testParams, final int testPropertyIndex) {
		super();
		this.xmlPayload = xmlPayload;
		this.testParams = testParams;
		this.testPropertyIndex = testPropertyIndex;
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

		builder.append(testParams.getProperties().get(this.testPropertyIndex)
				.toString());

		return builder.toString();
	}
}
