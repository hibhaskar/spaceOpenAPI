package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * Financial account reference. An account of money owed by a party to another entity in exchange for goods or
 *  services that have been delivered or used. 
 *  A financial account aggregates the amounts of one or more party accounts (billing or settlement)
 *  owned by a given party.
 */
public class FinancialAccountRef {
  
  private String id = null;

  private String href = null;

  private String name = null;

  private String type = null;

  /**
   * @param oFinancialAccountRef
   *//*
  public FinancialAccountRef(cust.bill.mgmt.dao.model.FinancialAccountRef oFinancialAccountRef) {
	super();
	this.id = new String(oFinancialAccountRef.getId());
	this.href = new String(oFinancialAccountRef.getHref());
	this.name = new String(oFinancialAccountRef.getName());
	this.type = new String(oFinancialAccountRef.getType());
  }*/

  /**
   * @param id
   * @param href
   * @param name
   * @param type
   */
  public FinancialAccountRef(String id, String href, String name, String type) {
	super();
	this.id = id;
	this.href = href;
	this.name = name;
	this.type = type;
  }

  public FinancialAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the account
   * @return id
  **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FinancialAccountRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Unique reference of the account
   * @return href
  **/
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public FinancialAccountRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Account name
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FinancialAccountRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the type of the financial account
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
    FinancialAccountRef financialAccountRef = (FinancialAccountRef) o;
    
    return Objects.equals(this.id, financialAccountRef.id) &&
        Objects.equals(this.href, financialAccountRef.href) &&
        Objects.equals(this.name, financialAccountRef.name) &&
        Objects.equals(this.type, financialAccountRef.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinancialAccountRef {\n");
    
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