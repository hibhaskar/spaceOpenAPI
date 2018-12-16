package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * BillingAccount reference. 
 * A BillingAccount is a detailed description of a bill structure.
 */
public class BillingAccountRef {

	private String id = null;
	
	private String href = null;
	
	private String name = null;
	
	private String type = null;
	 
	/**
	 * @param oBillingAccountRef
	 *//*
	public BillingAccountRef(cust.bill.mgmt.dao.model.BillingAccountRef oBillingAccountRef) {
		super();
		this.id = new String(oBillingAccountRef.getId());
		this.href = new String(oBillingAccountRef.getHref());
		this.name = new String(oBillingAccountRef.getName());
		this.type = new String(oBillingAccountRef.getType());
	}*/
	
	/**
	 * @param id
	 * @param href
	 * @param name
	 * @param type
	 */
	public BillingAccountRef(String id, String href, String name, String type) {
		super();
		this.id = id;
		this.href = href;
		this.name = name;
		this.type = type;
	}
	
	public BillingAccountRef id(String id) {
	    this.id = id;
	    return this;
	}

	/**
	 * Unique identifier of the billing account
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BillingAccountRef href(String href) {
	    this.href = href;
	    return this;
	}

	/**
	 * Reference of the billing account
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BillingAccountRef name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Billing account name
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BillingAccountRef type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of the billing account
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
		BillingAccountRef billingAccountRef = (BillingAccountRef) o;
		return Objects.equals(this.id, billingAccountRef.id) &&
	        Objects.equals(this.href, billingAccountRef.href) &&
	        Objects.equals(this.name, billingAccountRef.name) &&
	        Objects.equals(this.type, billingAccountRef.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, name, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("class BillingAccountRef {\n");
	    
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