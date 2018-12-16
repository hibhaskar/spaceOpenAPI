package cust.bill.mgmt.dao.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.validation.annotation.Validated;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The billing account receives all charges (recurring, one time and usage) of the offers and products assigned to 
 * it during order process. Periodically according to billing cycle specifications attached to the billing account or 
 * as a result of an event, a customer bill (aka invoice) is produced. 
 * This customer bill concerns different related parties which play a role on it : 
 * for example, a customer bill is produced by an operator, is sent to a bill receiver and has to be paid by a payer. 
 * A payment method could be assigned to the customer bill to build the call of payment. 
 * Lettering process enables to assign automatically or manually incoming amount from payments to customer bills 
 * (payment items). A tax item is created for each tax rate used in the customer bill. 
 * The financial account represents a financial entity which records all customer’s accounting events : 
 * payment amount are recorded as credit and invoices amount are recorded as debit. 
 * It gives the customer overall balance (account balance). 
 * The customer bill is linked to one or more documents that can be downloaded via a provided url.
 */
@ApiModel(description = "The billing account receives all charges (recurring, one time and usage) "
		+ "of the offers and products assigned to it during order process. "
		+ "Periodically according to billing cycle specifications attached to the billing account or "
		+ "as a result of an event, a customer bill (aka invoice) is produced. "
		+ "This customer bill concerns different related parties which play a role on it : "
		+ "for example, a customer bill is produced by an operator, "
		+ "is sent to a bill receiver and has to be paid by a payer. "
		+ "A payment method could be assigned to the customer bill to build the call of payment. "
		+ "Lettering process enables to assign automatically or manually incoming amount from payments to customer bills "
		+ "(payment items). A tax item is created for each tax rate used in the customer bill. "
		+ "The financial account represents a financial entity which records all customer’s accounting events : "
		+ "payment amount are recorded as credit and invoices amount are recorded as debit. "
		+ "It gives the customer overall balance (account balance). "
		+ "The customer bill is linked to one or more documents that can be downloaded via a provided url.")
@Validated
@javax.annotation.Generated(
	value = "cust.bill.mgmt.codegen.languages.SpringCodegen", 
	date = "2018-09-29T16:06:28.483+05:30")
@Table(keyspace = "custbillmgmt", name="CustomerBill")
public class CustomerBill implements Serializable {

	/**
	 * 
	 */
	public CustomerBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param href
	 * @param billNo
	 * @param runType
	 * @param category
	 * @param state
	 * @param lastUpdate
	 * @param billDate
	 * @param nextBillDate
	 * @param billPeriod
	 * @param amtDue
	 * @param paymentDueDate
	 * @param remAmount
	 * @param tEAmount
	 * @param tIAmount
	 * @param baseType
	 * @param type
	 * @param schemaLocation
	 * @param billDoc
	 * @param appPayment
	 * @param billAccount
	 * @param taxItm
	 * @param payMethod
	 * @param relParty
	 * @param financialAcc
	 */
	public CustomerBill(String id, String href, String billNo, String runType, String category, StateValue state,
			OffsetDateTime lastUpdate, OffsetDateTime billDate, OffsetDateTime nextBillDate, TimePeriod billPeriod,
			Money amtDue, OffsetDateTime paymentDueDate, Money remAmount, Money tEAmount, Money tIAmount,
			String baseType, String type, String schemaLocation, List<Attachment> billDoc,
			List<AppliedPayment> appPayment, BillingAccountRef billAccount, List<TaxItem> taxItm,
			PaymentMethodRef payMethod, List<RelatedPartyRef> relParty, FinancialAccountRef financialAcc) {
		super();
		this.id = id;
		this.href = href;
		this.billNo = billNo;
		this.runType = runType;
		this.category = category;
		this.state = state;
		this.lastUpdate = lastUpdate;
		this.billDate = billDate;
		this.nextBillDate = nextBillDate;
		this.billPeriod = billPeriod;
		this.amtDue = amtDue;
		this.paymentDueDate = paymentDueDate;
		this.remAmount = remAmount;
		this.tEAmount = tEAmount;
		this.tIAmount = tIAmount;
		this.baseType = baseType;
		this.type = type;
		this.schemaLocation = schemaLocation;
		this.billDoc = billDoc;
		this.appPayment = appPayment;
		this.billAccount = billAccount;
		this.taxItm = taxItm;
		this.payMethod = payMethod;
		this.relParty = relParty;
		this.financialAcc = financialAcc;
	}

  @PrimaryKey("id")
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  @Field(name = "href")
  private String href = null;

  @JsonProperty("billNo")
  @Field(name = "billno")
  private String billNo = null;

  @JsonProperty("runType")
  @Field(name = "runtype")
  private String runType = null;

  @JsonProperty("category")
  @Field(name = "category")
  private String category = null;

  @JsonProperty("state")
  @Field(name = "state")
  private StateValue state = null;
  
  @JsonProperty("lastUpdate")
  @Field(name = "lastupdate")
  private OffsetDateTime lastUpdate = null;
  
  @JsonProperty("billDate")
  @Field(name = "billdate")
  private OffsetDateTime billDate = null;
  
  @JsonProperty("nextBillDate")
  @Field(name = "nextbilldate")
  private OffsetDateTime nextBillDate = null;
  
  @JsonProperty("billingPeriod")
  @Frozen
  @Field(name = "billingperiod")
  private TimePeriod billPeriod = null;

  @JsonProperty("amountDue")
  @Frozen
  @Field(name = "amountdue")
  private Money amtDue = null;

  @JsonProperty("paymentDueDate")
  @Field(name = "paymentduedate")
  private OffsetDateTime paymentDueDate = null;
  
  @JsonProperty("remainingAmount")
  @Frozen
  @Field(name = "remainingamount")
  private Money remAmount = null;

  @JsonProperty("taxExcludedAmount")
  @Frozen
  @Field(name = "taxexcludedamount")
  private Money tEAmount = null;

  @JsonProperty("taxIncludedAmount")
  @Frozen
  @Field(name = "taxincludedamount")
  private Money tIAmount = null;

  @JsonProperty("@baseType")
  @Field(name = "baseType")
  private String baseType = null;

  @JsonProperty("@type")
  @Field(name = "baseType")
  private String type = null;

  @JsonProperty("@schemaLocation")
  @Field(name = "schemalocation")
  private String schemaLocation = null;

  @JsonProperty("billDocument")
  @Valid
  @Field(name = "billdocument")
  private List<Attachment> billDoc = null;

  @JsonProperty("appliedPayment")
  @Valid
  @Field(name = "appliedpayment")
  private List<AppliedPayment> appPayment = null;

  @JsonProperty("billingAccount")
  @Field(name = "billingaccount")
  private BillingAccountRef billAccount = null;

  @JsonProperty("taxItem")
  @Valid
  @Field(name = "taxitem")
  private List<TaxItem> taxItm = null;

  @JsonProperty("paymentMethod")
  @Field(name = "paymentmethod")
  private PaymentMethodRef payMethod = null;

  @JsonProperty("relatedParty")
  @Valid
  @Field(name = "relatedparty")
  private List<RelatedPartyRef> relParty = null;

  @JsonProperty("financialAccount")
  @Field(name = "financialaccount")
  private FinancialAccountRef financialAcc = null;

  public CustomerBill id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of he bill
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of he bill")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerBill href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Bill unique reference
   * @return href
  **/
  @ApiModelProperty(value = "Bill unique reference")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CustomerBill billNo(String billNo) {
    this.billNo = billNo;
    return this;
  }

  /**
   * Bill reference known by the customer or the party and displayed on the bill. 
   * Could be different from the id
   * @return billNo
  **/
  @ApiModelProperty(value = "Bill reference known by the customer or the party and displayed on the bill. "
  		+ "Could be different from the id")
  public String getBillNo() {
    return billNo;
  }

  public void setBillNo(String billNo) {
    this.billNo = billNo;
  }

  public CustomerBill runType(String runType) {
    this.runType = runType;
    return this;
  }

  /**
   * onCycle (a bill can be created as a result of a cycle run) or 
   * offCycle (a bill can be created as a result of other events such as customer request or account close)
   * @return runType
  **/
  @ApiModelProperty(value = "onCycle (a bill can be created as a result of a cycle run) or "
  		+ "offCycle (a bill can be created as a result of other events such as customer request or account close)")
  public String getRunType() {
    return runType;
  }

  public void setRunType(String runType) {
    this.runType = runType;
  }

  public CustomerBill category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Category of the bill produced : normal, duplicate, interim, last, trial customer or credit note for example
   * @return category
  **/
  @ApiModelProperty(value = "Category of the bill produced : "
  		+ "normal, duplicate, interim, last, trial customer or credit note for example")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public CustomerBill state(StateValue state) {
    this.state = state;
    return this;
  }

  /**
   * 
   * @return state
  **/
  @ApiModelProperty(value = "")
  @Valid
  public StateValue getState() {
    return state;
  }

  public void setState(StateValue state) {
    this.state = state;
  }

  public CustomerBill lastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Date of bill last update
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date of bill last update")
  @Valid
  public OffsetDateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(OffsetDateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public CustomerBill billDate(OffsetDateTime billDate) {
    this.billDate = billDate;
    return this;
  }

  /**
   * Bill date
   * @return billDate
  **/
  @ApiModelProperty(value = "Bill date")
  @Valid
  public OffsetDateTime getBillDate() {
    return billDate;
  }

  public void setBillDate(OffsetDateTime billDate) {
    this.billDate = billDate;
  }

  public CustomerBill nextBillDate(OffsetDateTime nextBillDate) {
    this.nextBillDate = nextBillDate;
    return this;
  }

  /**
   * ). Approximate date of  the next bill production given for information (only used for onCycle bill)
   * @return nextBillDate
  **/
  @ApiModelProperty(value = "). Approximate date of  the next bill production given for information "
  		+ "(only used for onCycle bill)")
  @Valid
  public OffsetDateTime getNextBillDate() {
    return nextBillDate;
  }

  public void setNextBillDate(OffsetDateTime nextBillDate) {
    this.nextBillDate = nextBillDate;
  }

  public CustomerBill billingPeriod(TimePeriod billingPeriod) {
    this.billPeriod = billingPeriod;
    return this;
  }

  /**
   * Billing period of the bill (used for onCycle bill only)
   * @return billingPeriod
  **/
  @ApiModelProperty(value = "Billing period of the bill (used for onCycle bill only)")
  @Valid
  public TimePeriod getBillingPeriod() {
    return billPeriod;
  }

  public void setBillingPeriod(TimePeriod billingPeriod) {
    this.billPeriod = billingPeriod;
  }

  public CustomerBill amountDue(Money amountDue) {
    this.amtDue = amountDue;
    return this;
  }

  /**
   * Amount due for this bill expressed in the given currency
   * @return amountDue
  **/
  @ApiModelProperty(value = "Amount due for this bill expressed in the given currency")
  @Valid
  public Money getAmountDue() {
    return amtDue;
  }

  public void setAmountDue(Money amountDue) {
    this.amtDue = amountDue;
  }

  public CustomerBill paymentDueDate(OffsetDateTime paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
    return this;
  }

  /**
   * Date at which the amount due should have been paid
   * @return paymentDueDate
  **/
  @ApiModelProperty(value = "Date at which the amount due should have been paid")
  @Valid
  public OffsetDateTime getPaymentDueDate() {
    return paymentDueDate;
  }

  public void setPaymentDueDate(OffsetDateTime paymentDueDate) {
    this.paymentDueDate = paymentDueDate;
  }

  public CustomerBill remainingAmount(Money remainingAmount) {
    this.remAmount = remainingAmount;
    return this;
  }

  /**
   * Remaining amount to be paid for this bill expressed in the given currency
   * @return remainingAmount
  **/
  @ApiModelProperty(value = "Remaining amount to be paid for this bill expressed in the given currency")
  @Valid
  public Money getRemainingAmount() {
    return remAmount;
  }

  public void setRemainingAmount(Money remainingAmount) {
    this.remAmount = remainingAmount;
  }

  public CustomerBill taxExcludedAmount(Money taxExcludedAmount) {
    this.tEAmount = taxExcludedAmount;
    return this;
  }

  /**
   * Total tax excluded amount expressed in the given currency
   * @return taxExcludedAmount
  **/
  @ApiModelProperty(value = "Total tax excluded amount expressed in the given currency")
  @Valid
  public Money getTaxExcludedAmount() {
    return tEAmount;
  }

  public void setTaxExcludedAmount(Money taxExcludedAmount) {
    this.tEAmount = taxExcludedAmount;
  }

  public CustomerBill taxIncludedAmount(Money taxIncludedAmount) {
    this.tIAmount = taxIncludedAmount;
    return this;
  }

  /**
   * Total tax included amount expressed in the given
   * @return taxIncludedAmount
  **/
  @ApiModelProperty(value = "Total tax included amount expressed in the given")
  @Valid
  public Money getTaxIncludedAmount() {
    return tIAmount;
  }

  public void setTaxIncludedAmount(Money taxIncludedAmount) {
    this.tIAmount = taxIncludedAmount;
  }

  public CustomerBill baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * Indicates the base (class) type of the customer bill
   * @return baseType
  **/
  @ApiModelProperty(value = "Indicates the base (class) type of the customer bill")
  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public CustomerBill type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the (class) type of the customer bill
   * @return type
  **/
  @ApiModelProperty(value = "Indicates the (class) type of the customer bill")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CustomerBill schemaLocation(String schemaLocation) {
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

  public CustomerBill billDocument(List<Attachment> billDocument) {
    this.billDoc = billDocument;
    return this;
  }

  public CustomerBill addBillDocumentItem(Attachment billDocumentItem) {
    if (this.billDoc == null) {
      this.billDoc = new ArrayList<>();
    }
    this.billDoc.add(billDocumentItem);
    return this;
  }

  /**
   * A list of documents accompanying an entity
   * @return billDocument
  **/
  @ApiModelProperty(value = "A list of documents accompanying an entity")
  @Valid
  public List<Attachment> getBillDocument() {
    return billDoc;
  }

  public void setBillDocument(List<Attachment> billDocument) {
    this.billDoc = billDocument;
  }

  public CustomerBill appliedPayment(List<AppliedPayment> appliedPayment) {
    this.appPayment = appliedPayment;
    return this;
  }

  public CustomerBill addAppliedPaymentItem(AppliedPayment appliedPaymentItem) {
    if (this.appPayment == null) {
      this.appPayment = new ArrayList<>();
    }
    this.appPayment.add(appliedPaymentItem);
    return this;
  }

  /**
   * A list of payment items already assigned to this bill
   * @return appliedPayment
  **/
  @ApiModelProperty(value = "A list of payment items already assigned to this bill")
  @Valid
  public List<AppliedPayment> getAppliedPayment() {
    return appPayment;
  }

  public void setAppliedPayment(List<AppliedPayment> appliedPayment) {
    this.appPayment = appliedPayment;
  }

  public CustomerBill billingAccount(BillingAccountRef billingAccount) {
    this.billAccount = billingAccount;
    return this;
  }

  /**
   * Reference of the BillingAccount that produced this bill
   * @return billingAccount
  **/
  @ApiModelProperty(value = "Reference of the BillingAccount that produced this bill")
  @Valid
  public BillingAccountRef getBillingAccount() {
    return billAccount;
  }

  public void setBillingAccount(BillingAccountRef billingAccount) {
    this.billAccount = billingAccount;
  }

  public CustomerBill taxItem(List<TaxItem> taxItem) {
    this.taxItm = taxItem;
    return this;
  }

  public CustomerBill addTaxItemItem(TaxItem taxItemItem) {
    if (this.taxItm == null) {
      this.taxItm = new ArrayList<>();
    }
    this.taxItm.add(taxItemItem);
    return this;
  }

  /**
   * A list of  tax items created for each tax rate and tax type used in the bill. 
   * The tax item summarize the total of the various tax types.
   * @return taxItem
  **/
  @ApiModelProperty(value = "A list of  tax items created for each tax rate and tax type used in the bill. "
  		+ "The tax item summarize the total of the various tax types.")
  @Valid
  public List<TaxItem> getTaxItem() {
    return taxItm;
  }

  public void setTaxItem(List<TaxItem> taxItem) {
    this.taxItm = taxItem;
  }

  public CustomerBill paymentMethod(PaymentMethodRef paymentMethod) {
    this.payMethod = paymentMethod;
    return this;
  }

  /**
   * A payment method reference. A payment method defines a specific mean of payment (e.g direct debit) used to build the call of payment
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "A payment method reference. A payment method defines a specific mean of payment (e.g direct debit) used to build the call of payment")
  @Valid
  public PaymentMethodRef getPaymentMethod() {
    return payMethod;
  }

  public void setPaymentMethod(PaymentMethodRef paymentMethod) {
    this.payMethod = paymentMethod;
  }

  public CustomerBill relatedParty(List<RelatedPartyRef> relatedParty) {
    this.relParty = relatedParty;
    return this;
  }

  public CustomerBill addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
    if (this.relParty == null) {
      this.relParty = new ArrayList<>();
    }
    this.relParty.add(relatedPartyItem);
    return this;
  }

  /**
   * A list of related party references. A related party defines party or party role linked to the bill
   * @return relatedParty
  **/
  @ApiModelProperty(value = "A list of related party references. "
  		+ "A related party defines party or party role linked to the bill")
  @Valid
  public List<RelatedPartyRef> getRelatedParty() {
    return relParty;
  }

  public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
    this.relParty = relatedParty;
  }

  public CustomerBill financialAccount(FinancialAccountRef financialAccount) {
    this.financialAcc = financialAccount;
    return this;
  }

  /**
   * A financial account reference. 
   * An account of money owed by a party to another entity in exchange for goods or 
   * services that have been delivered or used. 
   * An account receivable aggregates the amounts of one or more billing accounts owned by a given party.
   * @return financialAccount
  **/
  @ApiModelProperty(value = "A financial account reference. "
  		+ "An account of money owed by a party to another entity in exchange for goods or "
  		+ "services that have been delivered or used. An account receivable aggregates the amounts of one or "
  		+ "more billing accounts owned by a given party.")
  @Valid
  public FinancialAccountRef getFinancialAccount() {
    return financialAcc;
  }

  public void setFinancialAccount(FinancialAccountRef financialAccount) {
    this.financialAcc = financialAccount;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerBill customerBill = (CustomerBill) o;
    return Objects.equals(this.id, customerBill.id) &&
        Objects.equals(this.href, customerBill.href) &&
        Objects.equals(this.billNo, customerBill.billNo) &&
        Objects.equals(this.runType, customerBill.runType) &&
        Objects.equals(this.category, customerBill.category) &&
        Objects.equals(this.state, customerBill.state) &&
        Objects.equals(this.lastUpdate, customerBill.lastUpdate) &&
        Objects.equals(this.billDate, customerBill.billDate) &&
        Objects.equals(this.nextBillDate, customerBill.nextBillDate) &&
        Objects.equals(this.billPeriod, customerBill.billPeriod) &&
        Objects.equals(this.amtDue, customerBill.amtDue) &&
        Objects.equals(this.paymentDueDate, customerBill.paymentDueDate) &&
        Objects.equals(this.remAmount, customerBill.remAmount) &&
        Objects.equals(this.tEAmount, customerBill.tEAmount) &&
        Objects.equals(this.tIAmount, customerBill.tIAmount) &&
        Objects.equals(this.baseType, customerBill.baseType) &&
        Objects.equals(this.type, customerBill.type) &&
        Objects.equals(this.schemaLocation, customerBill.schemaLocation) &&
        Objects.equals(this.billDoc, customerBill.billDoc) &&
        Objects.equals(this.appPayment, customerBill.appPayment) &&
        Objects.equals(this.billAccount, customerBill.billAccount) &&
        Objects.equals(this.taxItm, customerBill.taxItm) &&
        Objects.equals(this.payMethod, customerBill.payMethod) &&
        Objects.equals(this.relParty, customerBill.relParty) &&
        Objects.equals(this.financialAcc, customerBill.financialAcc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, billNo, runType, category, state, lastUpdate, billDate, nextBillDate, billPeriod, 
    		amtDue, paymentDueDate, remAmount, tEAmount, tIAmount, baseType, type, schemaLocation, billDoc, 
    		appPayment, billAccount, taxItm, payMethod, relParty, financialAcc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerBillDAO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    billNo: ").append(toIndentedString(billNo)).append("\n");
    sb.append("    runType: ").append(toIndentedString(runType)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    billDate: ").append(toIndentedString(billDate)).append("\n");
    sb.append("    nextBillDate: ").append(toIndentedString(nextBillDate)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billPeriod)).append("\n");
    sb.append("    amountDue: ").append(toIndentedString(amtDue)).append("\n");
    sb.append("    paymentDueDate: ").append(toIndentedString(paymentDueDate)).append("\n");
    sb.append("    remainingAmount: ").append(toIndentedString(remAmount)).append("\n");
    sb.append("    taxExcludedAmount: ").append(toIndentedString(tEAmount)).append("\n");
    sb.append("    taxIncludedAmount: ").append(toIndentedString(tIAmount)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    billDocument: ").append(toIndentedString(billDoc)).append("\n");
    sb.append("    appliedPayment: ").append(toIndentedString(appPayment)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billAccount)).append("\n");
    sb.append("    taxItem: ").append(toIndentedString(taxItm)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(payMethod)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relParty)).append("\n");
    sb.append("    financialAccount: ").append(toIndentedString(financialAcc)).append("\n");
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