package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * PaymentMethod reference. A payment method defines a specific mean of payment (e.g direct debit).
 */
public class PaymentMethodRef {
	
	private String id = null;
	
	private String href = null;
	
	private String name = null;
	
	private String type = null;

	/**
	 * @param oPaymentMethodRef
	 *//*
	public PaymentMethodRef(cust.bill.mgmt.dao.model.PaymentMethodRef oPaymentMethodRef) {
		super();
		this.id = oPaymentMethodRef.getId();
		this.href = oPaymentMethodRef.getHref();
		this.name = oPaymentMethodRef.getName();
		this.type = oPaymentMethodRef.getType();
	}*/
	
	/**
	 * @param id
	 * @param href
	 * @param name
	 * @param type
	 */
	public PaymentMethodRef(String id, String href, String name, String type) {
		super();
		this.id = id;
		this.href = href;
		this.name = name;
		this.type = type;
	}

	public PaymentMethodRef id(String id) {
	    this.id = id;
	    return this;
	}

	/**
	 * Unique identifier of the payment method
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaymentMethodRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the payment method
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public PaymentMethodRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the payment method
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PaymentMethodRef type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of payment method
	 * @return type
	 **/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PaymentMethodRef paymentMethodRef = (PaymentMethodRef) o;
		return Objects.equals(this.id, paymentMethodRef.id) &&
				Objects.equals(this.href, paymentMethodRef.href) &&
				Objects.equals(this.name, paymentMethodRef.name) &&
				Objects.equals(this.type, paymentMethodRef.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentMethodRef {\n");
    
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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