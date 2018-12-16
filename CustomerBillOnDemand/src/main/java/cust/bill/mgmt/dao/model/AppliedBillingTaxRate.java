package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The applied billing tax rate represents taxes applied billing rate it refers to. 
 * It is calculated during the billing process.
 */
@ApiModel(description = "The applied billing tax rate represents taxes applied billing rate it refers to. "
		+ "It is calculated during the billing process.")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")
public class AppliedBillingTaxRate implements Serializable {

	public AppliedBillingTaxRate() {
		super();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param taxCategory
	 * @param taxRate
	 * @param taxAmount
	 */
	public AppliedBillingTaxRate(String taxCategory, Float taxRate, Money taxAmount) {
		super();
		this.taxCategory = taxCategory;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}

  @JsonProperty("taxCategory")
  private String taxCategory = null;

  @JsonProperty("taxRate")
  private Float taxRate = null;

  @JsonProperty("taxAmount")
  private Money taxAmount = null;

  public AppliedBillingTaxRate taxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
    return this;
  }

  /**
   * A categorization of the tax rate
   * @return taxCategory
  **/
  @ApiModelProperty(value = "A categorization of the tax rate")
  public String getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  public AppliedBillingTaxRate taxRate(Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * Applied rate
   * @return taxRate
  **/
  @ApiModelProperty(value = "Applied rate")
  public Float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public AppliedBillingTaxRate taxAmount(Money taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

  /**
   * Tax amount expressed in the given currency
   * @return taxAmount
  **/
  @ApiModelProperty(required = true, value = "Tax amount expressed in the given currency")
  @NotNull
  @Valid
  public Money getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Money taxAmount) {
    this.taxAmount = taxAmount;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppliedBillingTaxRate appliedBillingTaxRate = (AppliedBillingTaxRate) o;
    return Objects.equals(this.taxCategory, appliedBillingTaxRate.taxCategory) &&
        Objects.equals(this.taxRate, appliedBillingTaxRate.taxRate) &&
        Objects.equals(this.taxAmount, appliedBillingTaxRate.taxAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxCategory, taxRate, taxAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppliedBillingTaxRate {\n");
    
    sb.append("    taxCategory: ").append(toIndentedString(taxCategory)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
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