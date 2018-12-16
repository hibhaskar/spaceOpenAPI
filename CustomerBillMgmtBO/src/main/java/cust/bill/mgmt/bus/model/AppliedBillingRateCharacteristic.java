package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * An applied billing rate has dynamic characteristics according to the its type 
 * (characteristics are based on the service type, line of business or on others parameters)
 */
public class AppliedBillingRateCharacteristic {
	private String name = null;

	private String value = null;

	private String type = null;

	private String schemaLocation = null;
  
	public AppliedBillingRateCharacteristic name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Characteristic name
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppliedBillingRateCharacteristic value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Value affected to the characteristic
	 * @return value
	 **/
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AppliedBillingRateCharacteristic type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the (class) type of the characteristic
	 * @return type
	 **/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AppliedBillingRateCharacteristic schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * Link to the schema describing the REST resource
	 * @return schemaLocation
	 **/
	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    AppliedBillingRateCharacteristic appliedBillingRateCharacteristic = 
	    		(AppliedBillingRateCharacteristic) o;
	    return Objects.equals(this.name, appliedBillingRateCharacteristic.name) &&
	        Objects.equals(this.value, appliedBillingRateCharacteristic.value) &&
	        Objects.equals(this.type, appliedBillingRateCharacteristic.type) &&
	        Objects.equals(this.schemaLocation, appliedBillingRateCharacteristic.schemaLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value, type, schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AppliedBillingRateCharacteristic {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}		
		return o.toString().replace("\n", "\n    ");
	}
}