package cust.bill.mgmt.dao;

import java.util.List;

import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillUpdate;

/**
 * DAO interface for CustomerBillOnDemand to perform GET operation.
 * @author BHASKAR
 * @version 1.0.1
 */
public interface CustomerBillDAO {
	
	/**
     * Getting the CustomerBillOnDemand Information using Id
     * @param stID
     * 			ID of Customer Bill
     * @return CustomerBillOnDemand
     * @since 1.0.0
     */
    public CustomerBill customerBillFind(final String stID);
        
    /**
     * Getting the All CustomerBill information
     * @return List<CustomerBillOnDemand>
     * @since 1.0.0
     */
    public List<CustomerBill> customerBill();

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
    public CustomerBill customerBillPatch(final String stID, final CustomerBillUpdate oCustomerBillUpdate);
}