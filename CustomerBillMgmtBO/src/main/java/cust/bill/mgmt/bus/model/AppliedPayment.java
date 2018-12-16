package cust.bill.mgmt.bus.model;

import java.util.Objects;

/**
 * The applied payment is the result of lettering process. 
 * It enables to assign automatically or manually part of incoming payment amount to a bill.
 */

public class AppliedPayment   {
	
	private Money appliedAmount = null;

	private PaymentRef payment = null;

	/**
	 * @param oAppliedPayment
	 *//*
	public AppliedPayment(cust.bill.mgmt.dao.model.AppliedPayment oAppliedPayment) {
		super();
		this.appliedAmount = new Money(oAppliedPayment.getAppliedAmount());
		this.payment = new PaymentRef(oAppliedPayment.getPayment());
	}*/
	
	public AppliedPayment appliedAmount(Money appliedAmount) {
		this.appliedAmount = appliedAmount;
		return this;
	}

	/**
	 * Part of a payment amount lettered to the bill
	 * @return appliedAmount
	 **/
	public Money getAppliedAmount() {
		return appliedAmount;
	}

	public void setAppliedAmount(Money appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public AppliedPayment payment(PaymentRef payment) {
		this.payment = payment;
		return this;
	}

	/**
	 * A payment reference
	 * @return payment
	 **/
	public PaymentRef getPayment() {
		return payment;
	}

	public void setPayment(PaymentRef payment) {
		this.payment = payment;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AppliedPayment appliedPayment = (AppliedPayment) o;
		return Objects.equals(this.appliedAmount, appliedPayment.appliedAmount) &&
				Objects.equals(this.payment, appliedPayment.payment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(appliedAmount, payment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AppliedPayment {\n");
    
		sb.append("    appliedAmount: ").append(toIndentedString(appliedAmount)).append("\n");
		sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
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