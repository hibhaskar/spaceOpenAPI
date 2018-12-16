package cust.bill.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cust.bill.mgmt.dao.AppliedCustomerBillingRateDAOImpl;
import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;

/**
 * Service class for CustomerBillOnDemand to perform operation.
 * Please see the {@link cust.bill.mgmt.service.CustomerBillOnDemandService} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.0
 */
@Service
public class AppliedCustomerBillingRateServiceImpl implements AppliedCustomerBillingRateService {
	
	/**
	 * Logger Object
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * CustomerBillOnDemand Data Access Object
	 */
	@Autowired
	AppliedCustomerBillingRateDAOImpl oAppliedCustomerBillingRateDAOImpl;
	
	/**
	 * <p>Get List of AppliedCustomerBillingRate</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<AppliedCustomerBillingRate> appliedCustomerBillingRate() {
		logger.info("AppliedCustomerBillingRateServiceImpl::List<AppliedCustomerBillingRate>"
				+ ":appliedCustomerBillingRateFind");
		return oAppliedCustomerBillingRateDAOImpl.appliedCustomerBillingRate();
	}

	/**
	 * <p>Get Customer On Demand w.r.t. ID</p>
	 * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public AppliedCustomerBillingRate appliedCustomerBillingRateFind(String stID) {
		logger.info("AppliedCustomerBillingRateServiceImpl::List<AppliedCustomerBillingRate>" 
				+":appliedCustomerBillingRateFind");
        return oAppliedCustomerBillingRateDAOImpl.appliedCustomerBillingRateFind(stID);
	}
}