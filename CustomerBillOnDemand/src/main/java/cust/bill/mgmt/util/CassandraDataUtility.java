package cust.bill.mgmt.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cassandra.support.exception.CassandraUncategorizedException;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.UDTValue;
import com.datastax.driver.core.exceptions.CodecNotFoundException;

import cust.bill.mgmt.dao.model.AppliedBillingRateCharacteristic;
import cust.bill.mgmt.dao.model.AppliedBillingTaxRate;
import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;
import cust.bill.mgmt.dao.model.AppliedPayment;
import cust.bill.mgmt.dao.model.Attachment;
import cust.bill.mgmt.dao.model.BillRef;
import cust.bill.mgmt.dao.model.BillingAccountRef;
import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.FinancialAccountRef;
import cust.bill.mgmt.dao.model.Money;
import cust.bill.mgmt.dao.model.PaymentMethodRef;
import cust.bill.mgmt.dao.model.PaymentRef;
import cust.bill.mgmt.dao.model.RelatedPartyRef;
import cust.bill.mgmt.dao.model.StateValue;
import cust.bill.mgmt.dao.model.StateValues;
import cust.bill.mgmt.dao.model.TaxItem;
import cust.bill.mgmt.dao.model.TimePeriod;

/**
 * Perform Cassandra Data Type Conversion
 * @author BHASKAR
 * @version 1.0.0
 */
public final class CassandraDataUtility {
	
	/**
	 * Convert UTDValues to CustomerBillOnDemand
	 * @return CustomerBillOnDemand
	 * @since 1.0.0
	 */
	public static CustomerBillOnDemand row2CustomerBillOnDemand(Row row) 
			throws NumberFormatException {
		CustomerBillOnDemand oCustomerBillOnDemand = new CustomerBillOnDemand();
		oCustomerBillOnDemand.setId(getString(row,"id"));
		oCustomerBillOnDemand.setHref(getString(row,"href"));
		oCustomerBillOnDemand.setName(getString(row,"name"));
		oCustomerBillOnDemand.setDescription(getString(row,"description"));
		oCustomerBillOnDemand.setState(StateValues.fromValue(getString(row,"state")));
		oCustomerBillOnDemand.setLastUpdate(getString(row,"lastupdate"));
		oCustomerBillOnDemand.setType(getString(row,"type"));
		oCustomerBillOnDemand.setSchemaLocation(getString(row,"schemaLocation"));
		UDTValue billingaccount = getUDTValue(row,"billingaccountref");
		oCustomerBillOnDemand.setBillingAccount(new BillingAccountRef(
				getString(billingaccount,"id"),getString(billingaccount,"href"),
				getString(billingaccount,"name"),getString(billingaccount,"type")));
		UDTValue relatedpartyref = getUDTValue(row,"relatedpartyref");
		oCustomerBillOnDemand.setRelatedParty(new RelatedPartyRef(
				getString(relatedpartyref, "id"),getString(relatedpartyref, "href"),
				getString(relatedpartyref, "name"),getString(relatedpartyref, "role"),
				getString(relatedpartyref, "type")));
		UDTValue bill = getUDTValue(row,"billref");
    	oCustomerBillOnDemand.setCustomerBill(
    			new BillRef(getString(bill, "id"),getString(bill, "href"),getString(bill, "type")));		
		return oCustomerBillOnDemand;
	}
	
    /**
	 * Convert UTDValues to CustomerBill
	 * @return CustomerBillOnDemand
	 * @since 1.0.0
	 */
	public static CustomerBill row2CustomerBill(Row row) throws NumberFormatException {
		CustomerBill oCustomerBill = new CustomerBill();
		oCustomerBill.setId(getString(row,"id"));
		oCustomerBill.setHref(getString(row,"href"));
		oCustomerBill.setBillNo(getString(row,"billNo"));
		oCustomerBill.setRunType(getString(row,"runtype"));
		oCustomerBill.setCategory(getString(row,"category"));
		oCustomerBill.setCategory(getString(row,"baseType"));
		oCustomerBill.setCategory(getString(row,"type"));
		oCustomerBill.setCategory(getString(row,"schemaLocation"));		
		oCustomerBill.setState(StateValue.fromValue(getString(row,"state")));
		oCustomerBill.setLastUpdate(getOffsetDateTime(getString(row,"lastupdate")));
		oCustomerBill.setBillDate(getOffsetDateTime(getString(row,"billdate")));
		oCustomerBill.setNextBillDate(getOffsetDateTime(getString(row,"nextbilldate")));
		oCustomerBill.setPaymentDueDate(getOffsetDateTime(getString(row,"paymentduedate")));
		UDTValue billPeriod = getUDTValue(row,"billingperiod");
		oCustomerBill.setBillingPeriod(
				new TimePeriod(getOffsetDateTime(getString(billPeriod,"startdatetime")),
						getOffsetDateTime(getString(billPeriod,"startdatetime"))));
		
		UDTValue amtDue = getUDTValue(row,"amountdue");
		oCustomerBill.setAmountDue(new Money(
				getString(amtDue, "unit"),Float.valueOf(getFloat(amtDue,"value"))));
		UDTValue remAmount = getUDTValue(row,"remainingamount");
		oCustomerBill.setRemainingAmount(
				new Money(getString(remAmount, "unit"),Float.valueOf(getFloat(remAmount,"value"))));
		UDTValue tEAmount = getUDTValue(row,"taxexcludedamount");
		oCustomerBill.setTaxExcludedAmount(
				new Money(getString(tEAmount, "unit"),Float.valueOf(getFloat(tEAmount, "value"))));
		UDTValue tIAmount = getUDTValue(row,"taxincludedamount");
		oCustomerBill.setTaxIncludedAmount(
				new Money(getString(tIAmount, "unit"),Float.valueOf(getFloat(tIAmount, "value"))));
		
		List<UDTValue> lbillDoc = row.getList("billdocument", UDTValue.class);
		List<Attachment> lAttachment = new ArrayList<Attachment>();
		for (UDTValue billdoc:lbillDoc)
			lAttachment.add(new Attachment(
					getString(billdoc, "id"),getString(billdoc, "href"),
					getString(billdoc, "name"),getString(billdoc, "description"),
					getString(billdoc, "mimetype"),getString(billdoc, "sizeunit"),
					Float.valueOf(getFloat(billdoc, "size")),
					getString(billdoc, "url"),getString(billdoc, "type"),
					getString(billdoc, "schemaLocation")));
		oCustomerBill.setBillDocument(lAttachment);
		
		List<UDTValue> lappPayment = getList(row, "appliedpayment");
		List<AppliedPayment> lAppliedPayment = new ArrayList<AppliedPayment>();
		for (UDTValue appPayment:lappPayment) {
			AppliedPayment oAppliedPayment = new AppliedPayment();
			UDTValue appliedamount = getUDTValue(appPayment, "appliedamount");
			oAppliedPayment.setAppliedAmount(
					new Money(getString(appliedamount, "unit"),
							Float.valueOf(getFloat(appliedamount,"value"))));
			
			UDTValue payment = getUDTValue(appPayment, "payment");
			PaymentRef oPaymentRef = new PaymentRef();
			oPaymentRef.setId(getString(payment, "id"));
			oPaymentRef.setHref(getString(payment, "href"));
			oPaymentRef.setType(getString(payment, "type"));
			oPaymentRef.setPaymentDate(
					getOffsetDateTime(payment.getString("paymentDate")));
			UDTValue amount = getUDTValue(payment, "amount");
			oPaymentRef.setAmount(
					new Money(getString(amount, "unit"),
							Float.valueOf(getFloat(amount, "value"))));
			oAppliedPayment.setPayment(oPaymentRef);
			
			lAppliedPayment.add(oAppliedPayment);
		}
		oCustomerBill.setAppliedPayment(lAppliedPayment);
		 
		List<UDTValue> ltaxitem = getList(row, "taxitem");
		List<TaxItem> lTaxItem = new ArrayList<TaxItem>();
		for (UDTValue taxItm:ltaxitem) {
			TaxItem oTaxItem = new TaxItem();
			oTaxItem.setTaxCategory(getString(taxItm, "taxcategory"));
			oTaxItem.setTaxRate(Float.valueOf(getString(taxItm, "taxrate")));
			UDTValue taxamount = getUDTValue(taxItm, "taxamount");
			oTaxItem.setTaxAmount(
					new Money(getString(taxamount, "unit"),
	    					Float.valueOf(getFloat(taxamount, "value"))));
			lTaxItem.add(oTaxItem);
		}
		oCustomerBill.setTaxItem(lTaxItem);
		
		List<UDTValue> lrelParty = getList(row, "relatedpartyref");
		List<RelatedPartyRef> lRelatedPartyRef = new ArrayList<RelatedPartyRef>();
		for (UDTValue relParty:lrelParty) {
			lRelatedPartyRef.add(new RelatedPartyRef(
					getString(relParty, "id"),getString(relParty, "href"),
					getString(relParty, "name"),getString(relParty, "role"),
					getString(relParty, "type")));
		}
		oCustomerBill.setRelatedParty(lRelatedPartyRef);
		
		UDTValue billingaccount = getUDTValue(row,"billingaccount");
    	System.out.println("UDTValue: "+billingaccount);
    	oCustomerBill.setBillingAccount(
    			new BillingAccountRef(
    					getString(billingaccount, "id"),
    					getString(billingaccount, "href"),
    					getString(billingaccount, "name"),
    					getString(billingaccount, "type")));
    	
    	UDTValue paymentmethod = getUDTValue(row,"paymentmethod");
    	System.out.println("UDTValue: "+paymentmethod);
    	oCustomerBill.setPaymentMethod(
    			new PaymentMethodRef (
    					getString(paymentmethod, "id"),
    					getString(paymentmethod, "href"),
    					getString(paymentmethod, "name"),
    					getString(paymentmethod, "type")));
    	
    	UDTValue financialaccount = getUDTValue(row,"financialaccount");
    	System.out.println("UDTValue: "+financialaccount);
    	oCustomerBill.setFinancialAccount(
    			new FinancialAccountRef (
    					getString(financialaccount, "id"),
    					getString(financialaccount, "href"),
    					getString(financialaccount, "name"),
    					getString(financialaccount, "type")));
    	return oCustomerBill;
	}
	
    /**
	 * Convert UTDValues to AppliedCustomerBillingRate
	 * @return CustomerBillOnDemand
	 * @since 1.0.0
	 */
	public static AppliedCustomerBillingRate row2AppliedCustomerBillingRate(Row row) {
		AppliedCustomerBillingRate oAppliedCustomerBillingRate = new AppliedCustomerBillingRate();
    	oAppliedCustomerBillingRate.setId(getString(row,"id"));
    	oAppliedCustomerBillingRate.setName(getString(row,"name"));
    	oAppliedCustomerBillingRate.setDescription(getString(row,"description"));
    	oAppliedCustomerBillingRate.setType(getString(row,"type"));
    	oAppliedCustomerBillingRate.setBaseType(getString(row,"basetype"));
    	oAppliedCustomerBillingRate.setBillType(getString(row,"billtype"));
    	oAppliedCustomerBillingRate.setSchemaLocation(getString(row,"schemalocation"));
    		    	
    	UDTValue tEAmount = getUDTValue(row,"taxExcludedAmount");
    	oAppliedCustomerBillingRate.setTaxExcludedAmount(
    			new Money(getString(tEAmount, "unit"),
    					Float.valueOf(getFloat(tEAmount, "value"))));
    	
    	UDTValue tIAmount = getUDTValue(row,"taxIncludedAmount");
    	oAppliedCustomerBillingRate.setTaxIncludedAmount(
    			new Money(getString(tIAmount, "unit"),
    					Float.valueOf(getFloat(tIAmount, "value"))));
    	
    	UDTValue bill = getUDTValue(row,"billref");
    	oAppliedCustomerBillingRate.setBill(
    			new BillRef(
    					getString(bill, "id"),
    					getString(bill, "href"),
    					getString(bill, "type")));
    	
    	List<UDTValue> appliedbillingtaxrate = getList(row, "appliedbillingtaxrate");
    	List<AppliedBillingTaxRate> lAppliedBillingTaxRate = new ArrayList<AppliedBillingTaxRate> ();
    	for (UDTValue udt:appliedbillingtaxrate) {
    		AppliedBillingTaxRate oAppliedBillingTaxRate = new AppliedBillingTaxRate();
    		oAppliedBillingTaxRate.setTaxCategory(getString(udt, "taxcategory"));
    		oAppliedBillingTaxRate.setTaxRate(Float.valueOf(getString(udt, "taxrate")));
    		UDTValue money = getUDTValue(udt, "taxamount");
    		oAppliedBillingTaxRate.setTaxAmount(
    				new Money(
    						getString(money, "unit"),
    						Float.valueOf(getFloat(money, "value"))));
    		lAppliedBillingTaxRate.add(oAppliedBillingTaxRate);
    	}
    	oAppliedCustomerBillingRate.setAppliedTax(lAppliedBillingTaxRate);
    	
    	List<UDTValue> appliedbillingratecharacteristic = getList(row, "appliedbillingratecharacteristic");
    	List<AppliedBillingRateCharacteristic> lAppliedBillingRateCharacteristic = new ArrayList<AppliedBillingRateCharacteristic> ();
    	for (UDTValue udt:appliedbillingratecharacteristic) {
    		AppliedBillingRateCharacteristic oAppliedBillingRateCharacteristic = new AppliedBillingRateCharacteristic();
    		oAppliedBillingRateCharacteristic.setName(getString(udt, "name"));
    		oAppliedBillingRateCharacteristic.setValue(getString(udt, "value"));
    		oAppliedBillingRateCharacteristic.setType(getString(udt, "type"));
    		oAppliedBillingRateCharacteristic.setSchemaLocation(getString(udt, "schemaLocation"));
    		lAppliedBillingRateCharacteristic.add(oAppliedBillingRateCharacteristic);
    	}
    	oAppliedCustomerBillingRate.setCharacteristic(lAppliedBillingRateCharacteristic);
    	return oAppliedCustomerBillingRate;
	}
	
	/**
	 * Convert UTDValue to String
	 * @param	row
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	String
	 * 			Field Value
	 * @since 1.0.0
	 */
	public static String getString(Row row, String stField) {
		try {
			return row.getString(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return "";
		}		
	}
	
	/**
	 * Convert UTDValue to Float
	 * @param	row
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	Float
	 * 			Field Value
	 * @since 1.0.0
	 */
	public static Float getFloat(Row row, String stField) {
		try {
			return row.getFloat(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return 0.0f;
		}		
	}
	
	/**
	 * Convert UTDValue to UDTValue
	 * @param	row
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	UDTValue
	 * 			UDTValue Field Value
	 * @since 1.0.0
	 */
	public static UDTValue getUDTValue(Row row, String stField) {
		try {
			return row.getUDTValue(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return null;
		}		
	}
	
	/**
	 * Convert UTDValue to List<UDTValue>
	 * @param	row
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	List<UDTValue>
	 * 			List of UDTValue Field Value
	 * @since 1.0.0
	 */
	public static List<UDTValue> getList(Row row, String stField) {
		try {
			return row.getList(stField, UDTValue.class);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return new ArrayList<UDTValue>();
		}		
	}
	
	/**
	 * Convert UTDValue to UDTValue:String
	 * @param	oUDTValue
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	String
	 * 			Field Value
	 * @since 1.0.0
	 */
	public static String getString(UDTValue oUDTValue, String stField) {
		try {
			if (oUDTValue == null)
				return "";
			return oUDTValue.getString(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return "";
		}		
	}
	
	/**
	 * Convert UTDValue to UDTValue:Float
	 * @param	oUDTValue
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	Float
	 * 			Field Value
	 * @since 1.0.0
	 */
	public static Float getFloat(UDTValue oUDTValue, String stField) {
		try {
			if (oUDTValue == null)
				return 0.0f;
			return oUDTValue.getFloat(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return 0.0f;
		}		
	}
	
	/**
	 * Convert UTDValue to UDTValue:Float
	 * @param	oUDTValue
	 * 			Cassandra 'Row'
	 * 			stField
	 * 			Name of the Field
	 * @return 	UDTValue
	 * 			UDTValue Field Value
	 * @since 1.0.0
	 */
	public static UDTValue getUDTValue(UDTValue oUDTValue, String stField) {
		try {
			if (oUDTValue == null)
				return null;
			return oUDTValue.getUDTValue(stField);
		} catch (IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return null;
		}		
	}
	
	/**
	 * Convert String to OffsetDateTime
	 * @param	stOffsetDateTime
	 * 			String
	 * @return 	OffsetDateTime
	 * 			OffsetDateTime Field Value
	 * @since 1.0.0
	 */
	public static OffsetDateTime getOffsetDateTime(String stOffsetDateTime) {
		try {
			return OffsetDateTime.parse(stOffsetDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
		} catch (DateTimeParseException | IllegalArgumentException | CodecNotFoundException | CassandraUncategorizedException oException) {
			return OffsetDateTime.now();
		}		
	}
}