package cust.bill.mgmt.dao;

import java.util.List;

import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;

/**
 * DAO interface for CustomerBillOnDemand to perform GET operation.
 * @author BHASKAR
 * @version 1.0.0
 */
public interface AppliedCustomerBillingRateDAO {
    
	/**
     * Getting the CustomerBillOnDemand Information using Id
     * @param id
     * @return CustomerBillOnDemand
     * @since 1.0.0
     */
    public AppliedCustomerBillingRate appliedCustomerBillingRateFind(String id);
 
    
    /**
     * Getting the All AppliedCustomerBillingRate information
     * @return List<AppliedCustomerBillingRate>
     * @since 1.0.0
     */
    public List<AppliedCustomerBillingRate> appliedCustomerBillingRate();
    
}