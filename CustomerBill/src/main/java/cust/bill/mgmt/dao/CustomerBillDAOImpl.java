package cust.bill.mgmt.dao;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import cust.bill.mgmt.dao.model.AppliedPayment;
import cust.bill.mgmt.dao.model.Attachment;
import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillUpdate;
import cust.bill.mgmt.dao.model.RelatedPartyRef;
import cust.bill.mgmt.util.CassandraDataUtility;

/**
 * DAO class for CustomerBill to perform GET operation.
 * Please see the {@link cust.bill.mgmt.service.CustomerBillDAO} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.1
 */
@Repository
public class CustomerBillDAOImpl implements CustomerBillDAO {

	/**
	 * Logger Object
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * CassandraOperations Object
	 */
	@Autowired
    private CassandraOperations oCassandraOperations;
	
	/**
	 * <p>Get Customer Bill w.r.t. ID from Cassandra DB</p>
	 * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public CustomerBill customerBillFind(final String stID) {
		logger.info("CustomerBillDAOImpl::CustomerBill:customerBillFind");
    	List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("CustomerBill"), Row.class);
    	logger.warn("CustomerBillDAOImpl::CustomerBill:customerBillFind"+lRow.size());
		List<CustomerBill> lCustomerBillOnDemand = new ArrayList<CustomerBill>();
		lRow.forEach(row -> lCustomerBillOnDemand.add(CassandraDataUtility.row2CustomerBill(row)));
    	logger.warn("CustomerBillDAOImpl::CustomerBill:customerBillFind"+lCustomerBillOnDemand.size());
    	for (CustomerBill oCustomerBill:lCustomerBillOnDemand)
    		if (oCustomerBill.getId().equalsIgnoreCase(stID)) {
    			logger.warn("CustomerBillDAOImpl::CustomerBill:customerBillFind"+oCustomerBill);
    			return oCustomerBill;
    		}
    	return null;
	}
	
	/**
	 * <p>Get List of Customer Bills from Cassandra DB</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<CustomerBill> customerBill() {
		logger.info("CustomerBillOnDemandDAOImpl::customerBill()");
		List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("CustomerBill"), Row.class);
    	List<CustomerBill> lCustomerBill = new ArrayList<CustomerBill>();
    	//converting Row into CustomerBillOnDemand List
    	lRow.forEach(row -> lCustomerBill.add(CassandraDataUtility.row2CustomerBill(row)));
        return lCustomerBill;
	}

	/**
     * Updating the CustomerBill Information
     * @param stID
	 * 			ID of Customer Bill
	 * @param oCustomerBillUpdate
	 * 			Update of Customer Bill
	 * @return CustomerBill
	 * 			Customer Bill object associated to 'stID'
     * @since 1.0.1
     */
	@Override
	public CustomerBill customerBillPatch(final String stID, final CustomerBillUpdate oCustomerBillUpdate) {
		logger.info("CustomerBillOnDemandDAOImpl::customerBillPatch");
		CustomerBill oCustomerBill = customerBillFind(stID);
		StringBuffer sbInsertCQL = new StringBuffer("Insert into custbillmgmt.CustomerBillOnDemand JSON '{"
				+ "\"id\": \""+stID+"\","
				+ "\"href\": \""+oCustomerBill.getHref()+"\","
				+ "\"billNo\": \""+oCustomerBill.getBillNo()+"\","
				+ "\"runType\": \""+oCustomerBill.getRunType()+"\","
				+ "\"category\": \""+oCustomerBill.getCategory()+"\","
				+ "\"state\": \""+oCustomerBillUpdate.getState()+" \","///This is being updated
				+ "\"baseType\": \""+oCustomerBill.getBaseType()+"\","
				+ "\"type\": \""+oCustomerBill.getType()+"\","
				+ "\"schemaLocation\": \""+oCustomerBill.getSchemaLocation()+"\","
				+ "\"lastUpdate\": \""+OffsetDateTime.now()+"\","
			    + "\"billDate\": \""+oCustomerBill.getBillDate()+"\","
	    		+ "\"nextBillDate\": \""+oCustomerBill.getNextBillDate()+"\","
			    + "\"paymentDueDate\": \""+oCustomerBill.getPaymentDueDate()+"\","
			    + "\"billingPeriod\": {"
			    + "\"endDateTime\": \""+oCustomerBill.getBillingPeriod().getEndDateTime()+"\","
			    + "\"startDateTime\": \""+oCustomerBill.getBillingPeriod().getStartDateTime()+"\""
			    + "},"
			    + "\"amountDue\": {"
			    + "\"value\": "+oCustomerBill.getAmountDue().getValue()+","
			    + "\"unit\": \""+oCustomerBill.getAmountDue().getUnit()+"\""
			    + "},"
			    + "\"remainingAmount\": {"
			    + "\"value\": "+oCustomerBill.getRemainingAmount().getValue()+","
			    + "\"unit\": \""+oCustomerBill.getRemainingAmount().getUnit()+"\""
			    + "},"
			    + "\"taxExcludedAmount\": {"
			    + "\"value\": "+oCustomerBill.getTaxExcludedAmount().getValue()+","
			    + "\"unit\": \""+oCustomerBill.getTaxExcludedAmount().getUnit()+"\""
			    + "},"
			    + "\"taxIncludedAmount\": {"
			    + "\"value\": "+oCustomerBill.getTaxIncludedAmount().getValue()+","
			    + "\"unit\": \""+oCustomerBill.getTaxIncludedAmount().getUnit()+"\""
			    + "},");
		sbInsertCQL.append("\"billDocument\": [ ");
		boolean bComma = false;
		for (Attachment oAttachment : oCustomerBill.getBillDocument()) {
			if (bComma) {
				sbInsertCQL.append(",");
				bComma = false;
			}
			sbInsertCQL.append("{"
				+ "\"id\": \""+oAttachment.getId()+"\","
			    + "\"href\": \""+oAttachment.getHref()+"\"," 
			    + "\"name\": \""+oAttachment.getName()+"\","
				+ "\"description\": \""+oAttachment.getDescription()+"\","
				+ "\"mimeType\": \""+oAttachment.getMimeType()+"\","
				+ "\"sizeUnit\": \""+oAttachment.getSizeUnit()+"\","
				+ "\"size\": "+oAttachment.getSize()+","
				+ "\"url\": \""+oAttachment.getUrl()+"\","
				+ "\"type\": \""+oAttachment.getType()+"\","
				+ "\"schemaLocation\": \""+oAttachment.getSchemaLocation()+"\""
			    + "}");
			bComma = !bComma;
		}
		sbInsertCQL.append("],");		
		sbInsertCQL.append("\"appliedPayment\": [ ");
		bComma = false;
		for (AppliedPayment oAppliedPayment : oCustomerBill.getAppliedPayment()) {
			if (bComma) {
				sbInsertCQL.append(",");
				bComma = false;		
			}
			sbInsertCQL.append(""
					+ "{"
						+ "\"appliedAmount\": {"
						    + "\"value\": "+oAppliedPayment.getAppliedAmount().getValue()+"," 
						    + "\"name\": \""+oAppliedPayment.getAppliedAmount().getUnit()+"\""
					    + "},"
						+ "\"payment\": {"
							+ "\"id\": \""+oAppliedPayment.getPayment().getId()+"\","
							+ "\"paymentDate\": \""+oAppliedPayment.getPayment().getPaymentDate()+"\","
							+ "\"type\": \""+oAppliedPayment.getPayment().getType()+"\","
							+ "\"amount\": {"
								+ "\"value\": "+oAppliedPayment.getPayment().getAmount().getValue()+","
								+ "\"unit\": \""+oAppliedPayment.getPayment().getAmount().getUnit()+"\""
							+ "}"
					    + "}"
					+ "}");
			bComma = !bComma;
		}
		sbInsertCQL.append("],");
		
		sbInsertCQL.append("\"billingAccount\": {"
			    + "\"id\": \""+oCustomerBill.getBillingAccount().getId()+"\","
			    + "\"href\": \""+oCustomerBill.getBillingAccount().getHref()+"\"," 
			    + "\"name\": \""+oCustomerBill.getBillingAccount().getName()+"\","
			    + "\"type\": \""+oCustomerBill.getBillingAccount().getType()+"\""
			    + "},");
		sbInsertCQL.append("\"taxItem\": [ ");
		bComma = false;
		for (AppliedPayment oAppliedPayment : oCustomerBill.getAppliedPayment()) {
			if (bComma) {
				sbInsertCQL.append(",");
				bComma = false;		
			}
			sbInsertCQL.append("{"
					+ "\"taxCategory\": \""+oAppliedPayment.getPayment().getId()+"\","
					+ "\"paymentDate\": \""+oAppliedPayment.getPayment().getPaymentDate()+"\","
					+ "\"type\": \""+oAppliedPayment.getPayment().getType()+"\","
					+ "\"taxAmount\": {"
						+ "\"value\": "+oAppliedPayment.getPayment().getAmount().getValue()+","
						+ "\"unit\": \""+oAppliedPayment.getPayment().getAmount().getUnit()+"\""
					+ "}"
			    + "}");
			bComma = !bComma;
		}
		sbInsertCQL.append("],");		
		sbInsertCQL.append("\"paymentMethod\": {"
			    + "\"id\": \""+oCustomerBill.getPaymentMethod().getId()+"\","
			    + "\"href\": \""+oCustomerBill.getPaymentMethod().getHref()+"\"," 
			    + "\"name\": \""+oCustomerBill.getPaymentMethod().getName()+"\","
			    + "\"type\": \""+oCustomerBill.getPaymentMethod().getType()+"\""
			    + "},");		
		/*sbInsertCQL.append("\"relatedpartyref\": [");
		bComma = false;
		for (RelatedPartyRef oRelatedPartyRef : oCustomerBill.getRelatedParty()) {
			if (bComma) {
				sbInsertCQL.append(",");
				bComma = false;
			}
			sbInsertCQL.append("{"
				+ "\"href\": \""+oRelatedPartyRef.getHref()+"\"," 
				+ "\"role\": \""+oRelatedPartyRef.getRole()+"\","
				+ "\"id\": \""+oRelatedPartyRef.getId()+"\","
			    + "\"name\": \""+oRelatedPartyRef.getName()+"\","
				+ "\"type\": \""+oRelatedPartyRef.getType()+"\""
			    + "}");
			bComma = !bComma;
		}
		sbInsertCQL.append("],");*/
		sbInsertCQL.append("\"financialAccount\": {"
			    + "\"id\": \""+oCustomerBill.getFinancialAccount().getId()+"\","
			    + "\"href\": \""+oCustomerBill.getFinancialAccount().getHref()+"\"," 
			    + "\"name\": \""+oCustomerBill.getFinancialAccount().getName()+"\","
			    + "\"type\": \""+oCustomerBill.getFinancialAccount().getType()+"\""
			    + "}"
			  + "}';");

		System.out.println("\n\n###\n"+sbInsertCQL.toString()+"\n###\n\n");
		oCassandraOperations.execute(sbInsertCQL.toString());
		return customerBillFind(stID);
	}   
	
}