package cust.bill.mgmt.bus.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
public class CustomerBill {

  private String id = null;

  private String href = null;

  private String billNo = null;

  private String runType = null;

  private String category = null;

  private StateValue state = null;
  
  private OffsetDateTime lastUpdate = null;
  
  private OffsetDateTime billDate = null;
  
  private OffsetDateTime nextBillDate = null;
  
  private TimePeriod billPeriod = null;

  private Money amtDue = null;

  private OffsetDateTime paymentDueDate = null;
  
  private Money remAmount = null;

  private Money tEAmount = null;

  private Money tIAmount = null;

  private String baseType = null;

  private String type = null;

  private String schemaLocation = null;

  private List<Attachment> billDoc = null;

  private List<AppliedPayment> appPayment = null;

  private BillingAccountRef billAccount = null;

  private List<TaxItem> taxItm = null;

  private PaymentMethodRef payMethod = null;

  private List<RelatedPartyRef> relParty = null;

  private FinancialAccountRef financialAcc = null;
  
  /**
   * @param oDAOCustomerBill
   *//*
  public CustomerBill(cust.bill.mgmt.dao.model.CustomerBill oDAOCustomerBill) {
	super();
	this.id = (oDAOCustomerBill.getId());
	this.href = (oDAOCustomerBill.getHref());
	this.billNo = (oDAOCustomerBill.getBillNo());
	this.runType = (oDAOCustomerBill.getRunType());
	this.category = (oDAOCustomerBill.getCategory());
	this.state = StateValue.fromValue(oDAOCustomerBill.getState()+"");
	this.lastUpdate = oDAOCustomerBill.getLastUpdate();
	this.billDate = oDAOCustomerBill.getBillDate();
	this.nextBillDate = oDAOCustomerBill.getNextBillDate();
	this.billPeriod = new TimePeriod(oDAOCustomerBill.getBillingPeriod());
	this.amtDue = new Money(oDAOCustomerBill.getAmountDue());
	this.paymentDueDate = oDAOCustomerBill.getPaymentDueDate();
	this.remAmount = new Money(oDAOCustomerBill.getRemainingAmount());
	this.tEAmount = new Money(oDAOCustomerBill.getTaxExcludedAmount());
	this.tIAmount = new Money(oDAOCustomerBill.getTaxIncludedAmount());
	System.out.println("oDAOCustomerBill.getBaseType(): "+oDAOCustomerBill.getBaseType());
	this.baseType = (oDAOCustomerBill.getBaseType()+"");
	this.type = (oDAOCustomerBill.getType());
	this.schemaLocation = (oDAOCustomerBill.getSchemaLocation());
	this.billDoc = new ArrayList<Attachment>();
	oDAOCustomerBill.getBillDocument().forEach(
			oDAOAttachment -> this.billDoc.add(new Attachment(oDAOAttachment)));
	//this.billDoc = oDAOCustomerBill.getBillDocument();
	this.appPayment = new ArrayList<AppliedPayment>();
	oDAOCustomerBill.getAppliedPayment().forEach(
			oDAOAppliedPayment -> this.appPayment.add(new AppliedPayment(oDAOAppliedPayment)));
	//this.appPayment = oDAOCustomerBill.getAppliedPayment();
	this.billAccount = new BillingAccountRef(oDAOCustomerBill.getBillingAccount());
	this.taxItm = new ArrayList<TaxItem>();
	oDAOCustomerBill.getTaxItem().forEach(
			oDAOTaxItem -> this.taxItm.add(new TaxItem(oDAOTaxItem)));
	//this.taxItm = oDAOCustomerBill.getTaxItem();
	this.payMethod = new PaymentMethodRef(oDAOCustomerBill.getPaymentMethod());
	this.relParty = new ArrayList<RelatedPartyRef>();
	oDAOCustomerBill.getRelatedParty().forEach(
			oDAORelatedPartyRef -> this.relParty.add(new RelatedPartyRef(oDAORelatedPartyRef)));
	//this.relParty = oDAOCustomerBill.getRelatedParty();
	this.financialAcc = new FinancialAccountRef(oDAOCustomerBill.getFinancialAccount());
  }*/
	
  public CustomerBill id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of he bill
   * @return id
  **/
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
   * onCycle (a bill can be created as a result of a cycle run) or offCycle 
   * (a bill can be created as a result of other events such as customer request or account close)
   * @return runType
  **/
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
   * @return state
  **/
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
   * A payment method reference. A payment method defines a specific mean of payment (e.g direct debit) 
   * used to build the call of payment
   * @return paymentMethod
  **/
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
   * A financial account reference. An account of money owed 
   * by a party to another entity in exchange for goods or services that have been delivered or used. 
   * An account receivable aggregates the amounts of one or more billing accounts owned by a given party.
   * @return financialAccount
  **/
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
    return Objects.hash(id, href, billNo, runType, category, state, lastUpdate, 
    		billDate, nextBillDate, billPeriod, 
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