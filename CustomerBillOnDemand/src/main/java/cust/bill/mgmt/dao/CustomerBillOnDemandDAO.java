package cust.bill.mgmt.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest;

/**
 * DAO interface for CustomerBillOnDemand to perform GET operation.
 * @author BHASKAR
 * @version 1.0.1
 */
public interface CustomerBillOnDemandDAO {

	/**
     * Create a CustomerBillOnDemand
     * @param customerBillOnDemand
	 * @return CustomerBillOnDemand
	 * 			Created Customer Bill On Demand
	 * @throws Exception 
     * @since 1.0.1
     */
	public CustomerBillOnDemand customerBillOnDemandCreate(CustomerBillOnDemandRequest customerBillOnDemand) 
			throws DataAccessException;
			
	/**
     * Getting the All CustomerBillOnDemands information
     * @return List<CustomerBillOnDemand>
     * @since 1.0.0
     */
    public List<CustomerBillOnDemand> customerBillOnDemand();
    
    
    /**
     * Getting the CustomerBillOnDemand Information using ID
     * @param stID
     * @return CustomerBillOnDemand
     * @since 1.0.0
     */
    public CustomerBillOnDemand customerBillOnDemandFind(String stID);

}