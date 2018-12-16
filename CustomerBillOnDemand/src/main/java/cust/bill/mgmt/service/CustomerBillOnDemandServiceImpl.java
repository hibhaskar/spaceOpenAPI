package cust.bill.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import cust.bill.mgmt.dao.CustomerBillOnDemandDAOImpl;
import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest;

/**
 * Service class for CustomerBillOnDemand to perform operation.
 * Please see the {@link cust.bill.mgmt.service.CustomerBillOnDemandService} interface for true identity
 * 
 * @author BHASKAR
 * @version 1.0.1
 */
@Service
public class CustomerBillOnDemandServiceImpl implements CustomerBillOnDemandService {

	/**
	 * Logger Object
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * CustomerBillOnDemand Data Access Object
	 */
	@Autowired  
	CustomerBillOnDemandDAOImpl oCustomerBillOnDemandDAO;
	
	/**
     * Create a CustomerBillOnDemand
     * @param customerBillOnDemand
	 * @return CustomerBillOnDemand
	 * 			Created Customer Bill On Demand
	 * @throws Exception 
     * @since 1.0.1
     */
	public CustomerBillOnDemand customerBillOnDemandCreate(
			CustomerBillOnDemandRequest customerBillOnDemand) throws DataAccessException {
		return oCustomerBillOnDemandDAO.customerBillOnDemandCreate(customerBillOnDemand);
	}
	
	/**
	 * <p>Get List of CustomerBillOnDemand</p>
	 * @param 
	 * @return List<CustomerBillOnDemand>
	 * 			List of Customer Bill On Demand
	 * @since 1.0.0
	 */
	@Override
	public List<CustomerBillOnDemand> customerBillOnDemand() {
		logger.info("CustomerBillOnDemandServiceImpl::List<CustomerBillOnDemand>:customerBillOnDemand");
		return oCustomerBillOnDemandDAO.customerBillOnDemand();
	}

	/**
	 * <p>Get CustomerBillOnDemand w.r.t. ID</p>
	 * @param stID
	 * 			ID of Customer Bill On Demand
	 * @return CustomerBillOnDemand
	 * 			Customer Bill On Demand object associated to 'stID'
	 * @since 1.0.0
	 */
	@Override
	public CustomerBillOnDemand customerBillOnDemandFind(final String stID) {
		logger.info("CustomerBillOnDemandServiceImpl::CustomerBillOnDemandServiceImpl:customerBillOnDemandFind");
		return oCustomerBillOnDemandDAO.customerBillOnDemandFind(stID);
	}
}