package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * A base / value business entity used to represent money
 */
public class Money {
	
	private String unit = null;

	private Float value = null;
  
  	/**
	 * @param unit
	 * @param value
	 */
	public Money(String unit, Float value) {
		super();
		this.unit = unit;
		this.value = value;
	}
	
  	/**
	 * @param unit
	 * @param value
	 *//*
	public Money(cust.bill.mgmt.dao.model.Money oMoney) {
		super();
		this.unit = new String(oMoney.getUnit());
		this.value = new Float(oMoney.getValue());
	}*/
	
	public Money unit(String unit) {
	    this.unit = unit;
	    return this;
	}

	/**
	  * Currency code (ISO4217 norm uses 3 letters to define the currency).
	  * @return unit
	 **/
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Money value(Float value) {
		this.value = value;
		return this;
	}

	/**
	 * A positive floating point number
	 * @return value
	 **/
	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money) o;
		return Objects.equals(this.unit, money.unit) &&
				Objects.equals(this.value, money.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(unit, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Money {\n");
    
		sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
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