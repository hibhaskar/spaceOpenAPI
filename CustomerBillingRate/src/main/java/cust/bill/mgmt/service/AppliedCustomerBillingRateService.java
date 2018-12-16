package cust.bill.mgmt.service;

import java.util.List;

import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;

/**
 * Service interface for AppliedCustomerBillingRate to perform operation.
 * @author BHASKAR
 * @version 1.0.0
 */
public interface AppliedCustomerBillingRateService {

	
	/**
     * Getting the All CustomerBillOnDemands information
     * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
     * @since 1.0.0
     */
	public List<AppliedCustomerBillingRate> appliedCustomerBillingRate();
	
	
	/**
     * Getting the CustomerBillOnDemand Information using Id
     * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
     * @since 1.0.0
     */
	public AppliedCustomerBillingRate appliedCustomerBillingRateFind(String stID);
	
}