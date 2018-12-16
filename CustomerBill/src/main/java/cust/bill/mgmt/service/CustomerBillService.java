package cust.bill.mgmt.service;

import java.util.List;

import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillUpdate;

/**
 * Service interface for CustomerBill to perform operation.
 * @author BHASKAR
 * @version 1.0.0
 */
public interface CustomerBillService {
	
	/**
     * Getting the All CustomerBills information
     * @param 
	 * @return List<CustomerBill>
	 * 			List of Customer Bill
     * @since 1.0.0
     */
	public List<CustomerBill> customerBill();

	/**
     * Getting the CustomerBill Information using Id
     * @param stID
	 * 			ID of Customer Bill
	 * @return CustomerBill
	 * 			Customer Bill object associated to 'stID'
     * @since 1.0.0
     */
    public CustomerBill customerBillFind(final String stID);

	/**
     * Updating the CustomerBill Information
     * @param stID
	 * 			ID of Customer Bill
	 * @param oCustomerBillUpdate
	 * 			Update of Customer Bill
	 * @return CustomerBill
	 * 			Customer Bill object associated to 'stID'
     * @since 1.0.0
     */
    public CustomerBill customerBillPatch(final String stID, final CustomerBillUpdate oCustomerBillUpdate);

}