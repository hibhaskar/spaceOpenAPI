package cust.bill.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cust.bill.mgmt.dao.CustomerBillDAO;
import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillUpdate;

/**
 * Service class for CustomerBillOnDemand to perform operation.
 * Please see the {@link cust.bill.mgmt.service.CustomerBillOnDemandService} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.0
 */
@Service
public class CustomerBillServiceImpl implements CustomerBillService {

	/**
	 * Logger Object
	 */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
	 * CustomerBill Data Access Object
	 */
	@Autowired  
	CustomerBillDAO oCustomerBillDAO;
	
	/**
	 * <p>Get List of Customer Bill</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<CustomerBill> customerBill() {
		logger.info("CustomerBillServiceImpl::List<CustomerBill>:customerBill");
		return oCustomerBillDAO.customerBill();
	}

	/**
	 * <p>Get Customer On Demand w.r.t. ID</p>
	 * @param stID
	 * 			ID of Customer Bill
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public CustomerBill customerBillFind(final String stID) {
		logger.info("CustomerBillServiceImpl::CustomerBill:customerBillFind");
		return oCustomerBillDAO.customerBillFind(stID);
	}

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
	@Override
	public CustomerBill customerBillPatch(final String stID, final CustomerBillUpdate oCustomerBillUpdate) {
		logger.info("CustomerBillServiceImpl::CustomerBill:customerBillPatch");
		return oCustomerBillDAO.customerBillPatch(stID, oCustomerBillUpdate);
	}
}