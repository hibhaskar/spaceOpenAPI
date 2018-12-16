package cust.bill.mgmt.dao.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import cust.bill.mgmt.dao.model.AppliedBillingRateCharacteristic;
import cust.bill.mgmt.dao.model.AppliedBillingTaxRate;
import cust.bill.mgmt.dao.model.BillRef;
import cust.bill.mgmt.dao.model.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A customer bill displays applied billing rates created before or during the billing process.
 */
@ApiModel(description = "A customer bill displays applied billing rates created before or "
		+ "during the billing process.")
@Validated
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", date = "2018-09-29T16:06:28.483+05:30")
public class AppliedCustomerBillingRate implements Serializable {
	
	public AppliedCustomerBillingRate() {
		super();
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param href
	 * @param type
	 * @param date
	 * @param name
	 * @param description
	 * @param taxExcludedAmount
	 * @param taxIncludedAmount
	 * @param baseType
	 * @param billType
	 * @param schemaLocation
	 * @param appliedTax
	 * @param bill
	 * @param characteristic
	 */
	public AppliedCustomerBillingRate(String id, String href, String type, OffsetDateTime date, String name,
			String description, Money taxExcludedAmount, Money taxIncludedAmount, String baseType, String billType,
			String schemaLocation, List<AppliedBillingTaxRate> appliedTax, BillRef bill,
			List<AppliedBillingRateCharacteristic> characteristic) {
		super();
		this.id = id;
		this.href = href;
		this.type = type;
		this.date = date;
		this.name = name;
		this.description = description;
		this.taxExcludedAmount = taxExcludedAmount;
		this.taxIncludedAmount = taxIncludedAmount;
		this.baseType = baseType;
		this.billType = billType;
		this.schemaLocation = schemaLocation;
		this.appliedTax = appliedTax;
		this.bill = bill;
		this.characteristic = characteristic;
	}

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("taxExcludedAmount")
  private Money taxExcludedAmount = null;

  @JsonProperty("taxIncludedAmount")
  private Money taxIncludedAmount = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@billType")
  private String billType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("appliedTax")
  @Valid
  private List<AppliedBillingTaxRate> appliedTax = null;

  @JsonProperty("bill")
  private BillRef bill = null;

  @JsonProperty("characteristic")
  @Valid
  private List<AppliedBillingRateCharacteristic> characteristic = null;

  public AppliedCustomerBillingRate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the customer applied billing rate
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the customer applied billing rate")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AppliedCustomerBillingRate href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the customer applied billing rate
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the customer applied billing rate")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AppliedCustomerBillingRate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the applied billing rate : appliedBillingCharge (any kind of charge except taxation charges :
   *  recurringCharge, oneTimeCharge, usageCharge),  
   *  appliedBillingCredit (any kind of credit : rebate or productAlteration) or 
   *  appliedPenaltyCharge (penalty charges such as late fees, payment rejection fees,...)
   * @return billType
  **/
  @ApiModelProperty(value = "Type of the applied billing rate : appliedBillingCharge "
  		+ "(any kind of charge except taxation charges : recurringCharge, oneTimeCharge, usageCharge),  "
  		+ "appliedBillingCredit (any kind of credit : rebate or productAlteration) or "
  		+ "appliedPenaltyCharge (penalty charges such as late fees, payment rejection fees,...)")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AppliedCustomerBillingRate date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Creation date of the applied billing rate
   * @return date
  **/
  @ApiModelProperty(value = "Creation date of the applied billing rate")
  @Valid
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public AppliedCustomerBillingRate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the customer applied billing rate
   * @return name
  **/
  @ApiModelProperty(value = "Name of the customer applied billing rate")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppliedCustomerBillingRate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Additional data to be displayed on the bill for this customer applied billing rate
   * @return description
  **/
  @ApiModelProperty(value = "Additional data to be displayed on the bill for this customer applied billing rate")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AppliedCustomerBillingRate taxExcludedAmount(Money taxExcludedAmount) {
    this.taxExcludedAmount = taxExcludedAmount;
    return this;
  }

  /**
   * Tax excluded amount to be charged on the bill (expressed in the given currency) for this applied billing rate
   * @return taxExcludedAmount
  **/
  @ApiModelProperty(value = "Tax excluded amount to be charged on the bill (expressed in the given currency) "
  		+ "for this applied billing rate")
  @Valid
  public Money getTaxExcludedAmount() {
    return taxExcludedAmount;
  }

  public void setTaxExcludedAmount(Money taxExcludedAmount) {
    this.taxExcludedAmount = taxExcludedAmount;
  }

  public AppliedCustomerBillingRate taxIncludedAmount(Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
    return this;
  }

  /**
   * Tax included amount to be charged on the bill (expressed in the given currency) for this applied billing rate
   * @return taxIncludedAmount
  **/
  @ApiModelProperty(value = "Tax included amount to be charged on the bill "
  		+ "(expressed in the given currency) for this applied billing rate")
  @Valid
  public Money getTaxIncludedAmount() {
    return taxIncludedAmount;
  }

  public void setTaxIncludedAmount(Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
  }

  public AppliedCustomerBillingRate baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Indicates the base (class) billType of the applied customer billing rate
   * @return baseType
  **/
  @ApiModelProperty(value = "Indicates the base (class) billType of the applied customer billing rate")
  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public AppliedCustomerBillingRate BillType(String type) {
    this.billType = type;
    return this;
  }

  /**
   * Indicates the (class) billType of the applied customer billing rate
   * @return billType
  **/
  @ApiModelProperty(value = "Indicates the (class) billType of the applied customer billing rate")
  public String getBillType() {
    return billType;
  }

  public void setBillType(String type) {
    this.billType = type;
  }

  public AppliedCustomerBillingRate schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * Link to the schema describing the REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "Link to the schema describing the REST resource")
  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public AppliedCustomerBillingRate appliedTax(List<AppliedBillingTaxRate> appliedTax) {
    this.appliedTax = appliedTax;
    return this;
  }

  public AppliedCustomerBillingRate addAppliedTaxItem(AppliedBillingTaxRate appliedTaxItem) {
    if (this.appliedTax == null) {
      this.appliedTax = new ArrayList<>();
    }
    this.appliedTax.add(appliedTaxItem);
    return this;
  }

  /**
   * A list of applied billing tax rates. 
   * The applied billing tax rate represents taxes applied to billing rate it refers to. 
   * It is calculated during the billing process
   * @return appliedTax
  **/
  @ApiModelProperty(value = "A list of applied billing tax rates. "
  		+ "The applied billing tax rate represents taxes applied to billing rate it refers to. "
  		+ "It is calculated during the billing process")
  @Valid
  public List<AppliedBillingTaxRate> getAppliedTax() {
    return appliedTax;
  }

  public void setAppliedTax(List<AppliedBillingTaxRate> appliedTax) {
    this.appliedTax = appliedTax;
  }

  public AppliedCustomerBillingRate bill(BillRef bill) {
    this.bill = bill;
    return this;
  }

  /**
   * Reference of the bill on which the applied billing rate  is presented
   * @return bill
  **/
  @ApiModelProperty(value = "Reference of the bill on which the applied billing rate  is presented")
  @Valid
  public BillRef getBill() {
    return bill;
  }

  public void setBill(BillRef bill) {
    this.bill = bill;
  }

  public AppliedCustomerBillingRate characteristic(List<AppliedBillingRateCharacteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public AppliedCustomerBillingRate addCharacteristicItem(AppliedBillingRateCharacteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * A list of applied billing rate characteristics. 
   * An applied billing rate has dynamic characteristics according to the its billType 
   * (characteristics are based on the service billType, line of business or on others parameters for example)
   * @return characteristic
  **/
  @ApiModelProperty(value = "A list of applied billing rate characteristics. "
  		+ "An applied billing rate has dynamic characteristics according to the its billType "
  		+ "(characteristics are based on the service billType, "
  		+ "line of business or on others parameters for example)")
  @Valid
  public List<AppliedBillingRateCharacteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<AppliedBillingRateCharacteristic> characteristic) {
    this.characteristic = characteristic;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppliedCustomerBillingRate appliedCustomerBillingRate = (AppliedCustomerBillingRate) o;
    return Objects.equals(this.id, appliedCustomerBillingRate.id) &&
        Objects.equals(this.href, appliedCustomerBillingRate.href) &&
        Objects.equals(this.billType, appliedCustomerBillingRate.billType) &&
        Objects.equals(this.date, appliedCustomerBillingRate.date) &&
        Objects.equals(this.name, appliedCustomerBillingRate.name) &&
        Objects.equals(this.description, appliedCustomerBillingRate.description) &&
        Objects.equals(this.taxExcludedAmount, appliedCustomerBillingRate.taxExcludedAmount) &&
        Objects.equals(this.taxIncludedAmount, appliedCustomerBillingRate.taxIncludedAmount) &&
        Objects.equals(this.baseType, appliedCustomerBillingRate.baseType) &&
        Objects.equals(this.billType, appliedCustomerBillingRate.billType) &&
        Objects.equals(this.schemaLocation, appliedCustomerBillingRate.schemaLocation) &&
        Objects.equals(this.appliedTax, appliedCustomerBillingRate.appliedTax) &&
        Objects.equals(this.bill, appliedCustomerBillingRate.bill) &&
        Objects.equals(this.characteristic, appliedCustomerBillingRate.characteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, billType, date, name, description, taxExcludedAmount, taxIncludedAmount, baseType, billType, schemaLocation, appliedTax, bill, characteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppliedCustomerBillingRate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    billType: ").append(toIndentedString(billType)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    taxExcludedAmount: ").append(toIndentedString(taxExcludedAmount)).append("\n");
    sb.append("    taxIncludedAmount: ").append(toIndentedString(taxIncludedAmount)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    billType: ").append(toIndentedString(billType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    appliedTax: ").append(toIndentedString(appliedTax)).append("\n");
    sb.append("    bill: ").append(toIndentedString(bill)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
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