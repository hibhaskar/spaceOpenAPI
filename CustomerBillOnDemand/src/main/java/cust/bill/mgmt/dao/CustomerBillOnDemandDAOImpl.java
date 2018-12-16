package cust.bill.mgmt.dao;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest;
import cust.bill.mgmt.util.CassandraDataUtility;

/**
 * DAO class for CustomerBillOnDemand to perform GET operation.
 * Please see the {@link cust.bill.mgmt.service.CustomerBillOnDemandDAO} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.1
 */
@Repository
public class CustomerBillOnDemandDAOImpl implements CustomerBillOnDemandDAO {
	
	/**
	 * Logger Object
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	/**
	 * CassandraOperations Object
	 */
	@Autowired
    private CassandraOperations oCassandraOperations;
	
	//@Autowired
	//private CassandraAdminOperations oCassandraOperations;
	
	/**
	 * <p>Get List of Customer On Demand from Cassandra DB</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<CustomerBillOnDemand> customerBillOnDemand() {
		logger.info("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand:customerBillOnDemand");
		List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("CustomerBillOnDemand"), Row.class);
		logger.info("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand:customerBillOnDemand"+lRow.size());
    	List<CustomerBillOnDemand> lCustomerBill = new ArrayList<CustomerBillOnDemand>();
    	//converting Row into CustomerBillOnDemand List
    	lRow.forEach(row -> lCustomerBill.add(CassandraDataUtility.row2CustomerBillOnDemand(row)));
		logger.info("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand:customerBillOnDemand"+lCustomerBill.size());
        return lCustomerBill;
	}

	/**
	 * <p>Get Customer On Demand w.r.t. ID from Cassandra DB</p>
	 * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public CustomerBillOnDemand customerBillOnDemandFind(String stID) {
		logger.info("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand:customerBillOnDemandFind");
    	List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("CustomerBillOnDemand"), Row.class);
    	logger.warn("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand"
    			+ ":customerBillOnDemandFind"+lRow.size());
		List<CustomerBillOnDemand> lCustomerBillOnDemand = new ArrayList<CustomerBillOnDemand>();
		lRow.forEach(row -> lCustomerBillOnDemand.add(CassandraDataUtility.row2CustomerBillOnDemand(row)));
    	logger.warn("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand"
    			+ ":customerBillOnDemandFind"+lCustomerBillOnDemand.size());
    	for (CustomerBillOnDemand oCustomerBill:lCustomerBillOnDemand)
    		if (oCustomerBill.getId().equalsIgnoreCase(stID)) {
    			logger.warn("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand"
    					+ ":customerBillOnDemandFind"+oCustomerBill);
    			return oCustomerBill;
    		}
    	return null;
	}

	/**
     * Create a CustomerBillOnDemand
     * @param customerBillOnDemand
	 * @return CustomerBillOnDemand
	 * 			Created Customer Bill On Demand
     * @since 1.0.1
     */
	@Override
	public CustomerBillOnDemand customerBillOnDemandCreate(CustomerBillOnDemandRequest cbodRequest) 
			throws DataAccessException {
		logger.info("CustomerBillOnDemandDAOImpl::CustomerBillOnDemand:customerBillOnDemandCreate");
		//long lID = longID.incrementAndGet();
		String stID = OffsetDateTime.now()+"";
					
		/*Insert oInsert = QueryBuilder.insertInto("custbillmgmt","CustomerBillOnDemand")
				.value("id", stID) //
				.value("href", "http://localhost:8095/cbm/v.1/customerBillOnDemand/"+lID) //
				.value("description", cbodRequest.getDescription()) //
				.value("name", cbodRequest.getName()) //
				.value("state","inProgress")
				.value("lastUpdate",OffsetDateTime.now()+"")
				.value("type","customerBillOnDemand")
				.value("schemaLocation", "www.customerBillOnDemand.json")
				//.value("billingAccount", udtValue)
				.value("billingAccount", new BillingAccountRef(
						cbodRequest.getBillingAccount().getId(),
						cbodRequest.getBillingAccount().getHref(),
						cbodRequest.getBillingAccount().getName(),
						cbodRequest.getBillingAccount().getType())) //
				.value("relatedParty",  new RelatedPartyRef( 
						cbodRequest.getRelatedParty().getId(),
						cbodRequest.getRelatedParty().getHref(),
						cbodRequest.getRelatedParty().getName(),
						cbodRequest.getRelatedParty().getRole(),
						cbodRequest.getRelatedParty().getType()))
				.ifNotExists();*/
				
		String stInsertCQL2 = "Insert into custbillmgmt.CustomerBillOnDemand JSON '{"
				+ "\"id\": \""+stID+"\","
				+ "\"state\": \"inProgress\","
				+ "\"lastUpdate\":\""+OffsetDateTime.now()+"\","
				+ "\"type\":\"customerBillOnDemand\","
				+ "\"schemaLocation\":\"www.customerBillOnDemand.json\","
				+ "\"name\": \""+cbodRequest.getName()+"\","//Settlement bill\","
			    + "\"description\": \""+cbodRequest.getDescription()+"\","//Settlement Bill on demand\","
			    + "\"billingaccountref\": {"
			    + "\"id\": \""+cbodRequest.getBillingAccount().getId()+"\","//11\","
			    + "\"href\": \""+cbodRequest.getBillingAccount().getHref()+"\","//https://host:port/accountManagement/billingAccountref/65\"," 
			    + "\"name\": \""+cbodRequest.getBillingAccount().getName()+"\","//Daniel Smith billing account\","
			    + "\"type\": \""+cbodRequest.getBillingAccount().getType()+"\""//billingaccount\""
			    + "},"
			    + "\"relatedpartyref\": {"
			    + "\"id\": \""+cbodRequest.getRelatedParty().getId()+"\","
			    + "\"href\": \""+cbodRequest.getRelatedParty().getHref()+"\","
			    + "\"name\": \""+cbodRequest.getRelatedParty().getName()+"\","
			    + "\"role\": \""+cbodRequest.getRelatedParty().getRole()+"\","
			    + "\"type\": \""+cbodRequest.getRelatedParty().getType()+"\""
			    + "}"
			    + "}'";
		System.out.println("\n\n\n"+stInsertCQL2+"\n\n\n");
		oCassandraOperations.execute(stInsertCQL2);//oInsert);//
		return customerBillOnDemandFind(stID);
	}
	
}