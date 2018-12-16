package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * Bill reference
 */
public class BillRef {
	private String id = null;
	
	private String href = null;
	
	private String type = null;

  	/**
	 * @param oBillRef
	 *//*
	public BillRef(cust.bill.mgmt.dao.model.BillRef oBillRef) {
		super();
		this.id = new String(oBillRef.getId());
		this.href = new String(oBillRef.getHref());
		this.type = new String(oBillRef.getType());
	}*/
	
	/**
	 * @param id
	 * @param href
	 * @param type
	 */
	public BillRef(String id, String href, String type) {
		super();
		this.id = id;
		this.href = href;
		this.type = type;
	}
  
	public BillRef id(String id) {
	    this.id = id;
	    return this;
	}

	/**
	 * Unique identifier of the bill
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BillRef href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Reference of the bill
	 * @return href
	 **/
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public BillRef type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the (class) type of the bill
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
		BillRef billRef = (BillRef) o;
		return Objects.equals(this.id, billRef.id) &&
	        Objects.equals(this.href, billRef.href) &&
	        Objects.equals(this.type, billRef.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, type);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("class BillRef {\n");
	
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
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