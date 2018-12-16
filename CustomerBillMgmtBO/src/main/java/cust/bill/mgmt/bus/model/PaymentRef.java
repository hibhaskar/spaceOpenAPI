package cust.bill.mgmt.bus.model;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A payment reference
 */
public class PaymentRef {

	private String id = null;

	private String href = null;

	private OffsetDateTime paymentDate = null;
  
	private Money amount = null;

	private String type = null;
	
	/**
	 * @param oPaymentRef
	 *//*
	public PaymentRef(cust.bill.mgmt.dao.model.PaymentRef oPaymentRef) {
		super();
		this.id = (oPaymentRef.getId());
		this.href = (oPaymentRef.getHref());
		this.paymentDate = OffsetDateTime.parse(oPaymentRef.getPaymentDate()+"");
		this.amount = new Money(oPaymentRef.getAmount());
		this.type = (oPaymentRef.getType());
	}*/

	public PaymentRef id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the payment
	 * @return id
	 **/
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