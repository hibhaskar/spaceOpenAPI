package cust.bill.mgmt.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest;

/**
 * Service interface for CustomerBillOnDemand to perform operation.
 * @author BHASKAR
 * @version 1.0.1
 */
public interface CustomerBillOnDemandService {
	
	/**
     * Create a CustomerBillOnDemand
     * @param customerBillOnDemand
	 * @return CustomerBillOnDemand
	 * 			Created Customer Bill On Demand
     * @since 1.0.1
     */
	public CustomerBillOnDemand customerBillOnDemandCreate(
			CustomerBillOnDemandRequest customerBillOnDemand) throws DataAccessException;
	
	/**
     * Getting the All CustomerBillOnDemands information
     * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
     * @since 1.0.0
     */
	public List<CustomerBillOnDemand> customerBillOnDemand();
	
	
	/**
     * Getting the CustomerBillOnDemand Information using Id
     * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
     * @since 1.0.0
     */
    public CustomerBillOnDemand customerBillOnDemandFind(final String stID);
    
}