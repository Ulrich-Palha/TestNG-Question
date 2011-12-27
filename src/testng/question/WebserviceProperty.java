package testng.question;

public class WebserviceProperty {
	private final String propertyName;
	private final String propertyValue;

	public WebserviceProperty(final String name, final String value) {

		this.propertyName = name;
		this.propertyValue = value;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(propertyName);
		builder.append("=");
		builder.append(propertyValue);
		return builder.toString();
	}
}
