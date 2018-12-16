package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A tax item is created for each tax rate and tax type used in the bill. 
 * The tax item specifies the applied tax rate and the total resulting amount.
 */
@ApiModel(description = "A tax item is created for each tax rate and tax type used in the bill. "
		+ "The tax item specifies the applied tax rate and the total resulting amount.")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")
public class TaxItem implements Serializable {

	public TaxItem() {
		super();
	}

	private static final long serialVersionUID = 1L;

   /**
	 * @param taxCategory
	 * @param taxRate
	 * @param taxAmount
	 */
	public TaxItem(String taxCategory, Float taxRate, Money taxAmount) {
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

  public TaxItem taxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
    return this;
  }

  /**
   * A tax category
   * @return taxCategory
  **/
  @ApiModelProperty(value = "A tax category")
  public String getTaxCategory() {
    return taxCategory;
  }

  public void setTaxCategory(String taxCategory) {
    this.taxCategory = taxCategory;
  }

  public TaxItem taxRate(Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * Applied rate of the tax
   * @return taxRate
  **/
  @ApiModelProperty(value = "Applied rate of the tax")
  public Float getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public TaxItem taxAmount(Money taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

  /**
   * Amount of tax expressed in the given currency
   * @return taxAmount
  **/
  @ApiModelProperty(value = "Amount of tax expressed in the given currency")
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
    TaxItem taxItem = (TaxItem) o;
    return Objects.equals(this.taxCategory, taxItem.taxCategory) &&
        Objects.equals(this.taxRate, taxItem.taxRate) &&
        Objects.equals(this.taxAmount, taxItem.taxAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxCategory, taxRate, taxAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxItem {\n");
    
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