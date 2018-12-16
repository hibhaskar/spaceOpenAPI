package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BillingAccount reference. A BillingAccount is a detailed description of a bill structure.
 */
@ApiModel(description = "BillingAccount reference. "
		+ "A BillingAccount is a detailed description of a bill structure.")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")
public class BillingAccountRef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BillingAccountRef() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@type")
  private String type = null;

  public BillingAccountRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the billing account
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the billing account")
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
  @ApiModelProperty(value = "Reference of the billing account")
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
  @ApiModelProperty(value = "Billing account name")
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
  @ApiModelProperty(value = "Indicates the type of the billing account")
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