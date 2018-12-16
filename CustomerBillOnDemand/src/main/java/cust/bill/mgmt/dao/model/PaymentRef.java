package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A payment reference
 */
@ApiModel(description = "A payment reference")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")
public class PaymentRef implements Serializable {

	public PaymentRef() {
		super();
	}

	private static final long serialVersionUID = 1L;
  
  /**
	* @param id
	* @param href
	* @param paymentDate
	* @param amount
	* @param type
	*/
  public PaymentRef(String id, String href, OffsetDateTime paymentDate, Money amount, String type) {
	super();
	this.id = id;
	this.href = href;
	this.paymentDate = paymentDate;
	this.amount = amount;
	this.type = type;
  }

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("paymentDate")
  private OffsetDateTime paymentDate = null;
  
  @JsonProperty("amount")
  private Money amount = null;

  @JsonProperty("@type")
  private String type = null;

  public PaymentRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the payment
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the payment")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PaymentRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the payment
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the payment")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PaymentRef paymentDate(OffsetDateTime paymentDate) {
    this.paymentDate = paymentDate;
    return this;
  }

  /**
   * Payment date
   * @return paymentDate
  **/
  @ApiModelProperty(value = "Payment date")
  @Valid
  public OffsetDateTime getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(OffsetDateTime paymentDate) {
    this.paymentDate = paymentDate;
  }

  public PaymentRef amount(Money amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Payment amount done
   * @return amount
  **/
  @ApiModelProperty(value = "Payment amount done")
  @Valid
  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }

  public PaymentRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the type of payment
   * @return type
  **/
  @ApiModelProperty(value = "Indicates the type of payment")
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
    PaymentRef paymentRef = (PaymentRef) o;
    return Objects.equals(this.id, paymentRef.id) &&
        Objects.equals(this.href, paymentRef.href) &&
        Objects.equals(this.paymentDate, paymentRef.paymentDate) &&
        Objects.equals(this.amount, paymentRef.amount) &&
        Objects.equals(this.type, paymentRef.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, paymentDate, amount, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRef {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    paymentDate: ").append(toIndentedString(paymentDate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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