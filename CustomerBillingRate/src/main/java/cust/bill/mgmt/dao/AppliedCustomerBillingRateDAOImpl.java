package cust.bill.mgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;
import cust.bill.mgmt.util.CassandraDataUtility;

/**
 * DAO class for AppliedCustomerBillingRate to perform GET operation.
 * Please see the {@link cust.bill.mgmt.service.AppliedCustomerBillingRateDAO} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.0
 */
@Repository
public class AppliedCustomerBillingRateDAOImpl implements AppliedCustomerBillingRateDAO {

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
	 * <p>Get Customer On Demand w.r.t. ID from Cassandra DB</p>
	 * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public AppliedCustomerBillingRate appliedCustomerBillingRateFind(String id) {
		logger.info("AppliedCustomerBillingRateDAOImpl::AppliedCustomerBillingRate:appliedCustomerBillingRateFind");	
    	List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("AppliedCustomerBillingRate"), Row.class);
    	logger.warn("AppliedCustomerBillingRateDAOImpl::AppliedCustomerBillingRate"
    			+ ":appliedCustomerBillingRateFind"+lRow.size());
		List<AppliedCustomerBillingRate> lCustomerBill = new ArrayList<AppliedCustomerBillingRate>();
		lRow.forEach(row -> lCustomerBill.add(CassandraDataUtility.row2AppliedCustomerBillingRate(row)));
    	logger.warn("AppliedCustomerBillingRateDAOImpl::AppliedCustomerBillingRate"
    			+ ":appliedCustomerBillingRateFind"+lCustomerBill.size());
    	for (AppliedCustomerBillingRate oAppliedCustomerBillingRate:lCustomerBill)
    		if (oAppliedCustomerBillingRate.getId().equalsIgnoreCase(id)) {
    			logger.warn("AppliedCustomerBillingRateDAOImpl::AppliedCustomerBillingRate"
    					+ ":appliedCustomerBillingRateFind"+oAppliedCustomerBillingRate);
    			return oAppliedCustomerBillingRate;
    		}
    	return null;
	}
	
	/**
	 * <p>Get List of Customer On Demand from Cassandra DB</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<AppliedCustomerBillingRate> appliedCustomerBillingRate() {
		logger.info("AppliedCustomerBillingRateDAOImpl::List<AppliedCustomerBillingRate>"
				+ ":appliedCustomerBillingRateFind");
		/*System.out.println("Approach: 0");
    	List<T> xx = (List<T>)oCassandraOperations.selectAll(claz);
    	//return (List<T>) oCassandraOperations.selectAll(claz);
    	return xx;*/

    	/*System.out.println("Approach: 1");
    	// List of columns, that has to be selected from table users
    	final String[] columns = new String[] { 
    			"id", "href", "type", "date", "name", "description", "basetype", "billtype", "schemalocation" };
    	
    	Select select = QueryBuilder.select(columns).from("AppliedCustomerBillingRate");
    	final List<AppliedCustomerBillingRate> results = oCassandraOperations.select(select, AppliedCustomerBillingRate.class);
    	System.out.println("\n###"+results+"\n###");*/
    	
    	/*System.out.println("\nApproach: 2");
    	Select selectQuery = QueryBuilder.select().all().from("custbillmgmt", "AppliedCustomerBillingRate");
    	final List<AppliedCustomerBillingRate> res = oCassandraOperations.select(selectQuery, AppliedCustomerBillingRate.class);
    	System.out.println("\n{{{"+res+"\n}}}");*/
    	
    	/*System.out.println("\nApproach: 3");
    	List<T> lCustomerBill = (List<T>) oCassandraOperations.select(
    			"select * from custbillmgmt.AppliedCustomerBillingRate",AppliedCustomerBillingRate.class);
    			"select id, href, type, date, name, description, basetype, billtype, schemalocation, "
    			+ "toJson(taxExcludedAmount), toJson(taxIncludedAmount), toJson(billref), "
    			+ "appliedbillingtaxrate, appliedbillingratecharacteristic from custbillmgmt.AppliedCustomerBillingRate",
    			AppliedCustomerBillingRate.class);
    	System.out.println("\n\n\n...."+lCustomerBill+".....\n\n\n");
    	
    	System.out.println("\nApproach: 4");*/
    	List<Row> lRow = oCassandraOperations.select(QueryBuilder.select().from("AppliedCustomerBillingRate"), Row.class);
    	logger.info("AppliedCustomerBillingRateDAOImpl::List<AppliedCustomerBillingRate>"
    			+ ":appliedCustomerBillingRateFind"+lRow.size());
    	List<AppliedCustomerBillingRate> lCustomerBill = new ArrayList<AppliedCustomerBillingRate>();
    	lRow.forEach(row -> lCustomerBill.add(CassandraDataUtility.row2AppliedCustomerBillingRate(row)));
    	logger.info("AppliedCustomerBillingRateDAOImpl::List<AppliedCustomerBillingRate>"
    			+ ":appliedCustomerBillingRateFind"+lCustomerBill.size());
    	/*for (Row row:lRow) {
    		System.out.println("..................................................");
	    	lCustomerBill.add(CassandraGlobalConverter.row2AppliedCustomerBillingRate(row));
    	}*/    
        return lCustomerBill;
	}

}