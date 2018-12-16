package cust.bill.mgmt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cust.bill.mgmt.dao.CustomerBillOnDemandDAOImpl;
import cust.bill.mgmt.dao.model.BillRef;
import cust.bill.mgmt.dao.model.BillingAccountRef;
import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.RelatedPartyRef;
import cust.bill.mgmt.dao.model.StateValues;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerBillOnDemandServiceTest {
	
	@Mock
	private CustomerBillOnDemandDAOImpl oCustomerBillOnDemandDAO;
	
	@InjectMocks
	private CustomerBillOnDemandServiceImpl oCustomerBillOnDemandService;
	
	@BeforeClass
	public static void stepup() {
	}
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCustomerBillOnDemandList() {
		System.out.println("testCustomerBillOnDemandList:::");
		List<CustomerBillOnDemand> lCustomerBillOnDemand = populateData();
		when(oCustomerBillOnDemandDAO.customerBillOnDemand()).thenReturn(lCustomerBillOnDemand);		
		List<CustomerBillOnDemand> result = oCustomerBillOnDemandService.customerBillOnDemand();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testCustomerBillOnDemandById() {
		System.out.println("testCustomerBillOnDemandById:::");
		List<CustomerBillOnDemand> lCustomerBillOnDemand = populateData();
		when(oCustomerBillOnDemandDAO.customerBillOnDemandFind("115643244")).thenReturn(lCustomerBillOnDemand.get(0));
		CustomerBillOnDemand oCustomerBillOnDemand = oCustomerBillOnDemandService.customerBillOnDemandFind("115643244");
		assertEquals("115643244", oCustomerBillOnDemand.getId());
		assertEquals("Last bill", oCustomerBillOnDemand.getName());
	}
	
	@After
	public void setdown() {
	}
	
	@AfterClass
	public static void stepdown() {
	}
	
	
	private static List<CustomerBillOnDemand> populateData() {
		List<CustomerBillOnDemand> lCustomerBillOnDemand = new ArrayList<CustomerBillOnDemand>();
		
		CustomerBillOnDemand oCustomerBillOnDemand = new CustomerBillOnDemand();
		oCustomerBillOnDemand.setId("115643244");
		oCustomerBillOnDemand.setHref("");
		oCustomerBillOnDemand.setName("Last bill");
		oCustomerBillOnDemand.setDescription("Bill on demand requested for de-registration");
		oCustomerBillOnDemand.setState(StateValues.DONE);
		oCustomerBillOnDemand.setLastUpdate("2018-09-28T15:44:28");
		oCustomerBillOnDemand.setType("customerBillOnDemand");
		oCustomerBillOnDemand.setSchemaLocation("");		
		oCustomerBillOnDemand.setBillingAccount(
				new BillingAccountRef("65","","Adam Smith billing account","billing Account"));
		oCustomerBillOnDemand.setRelatedParty(
				new RelatedPartyRef("710","","Adam Smith","billReceiver","individualParty"));
		oCustomerBillOnDemand.setCustomerBill(new BillRef("8297","","customerBill"));		
		lCustomerBillOnDemand.add(oCustomerBillOnDemand);
		
		CustomerBillOnDemand oCustomerBillOnDemand1 = new CustomerBillOnDemand();
		oCustomerBillOnDemand1.setId("1156434");
		oCustomerBillOnDemand1.setHref("");
		oCustomerBillOnDemand1.setName("Settlement bill");
		oCustomerBillOnDemand1.setDescription("Settlement Bill on demand requested");
		oCustomerBillOnDemand1.setState(StateValues.DONE);
		oCustomerBillOnDemand1.setLastUpdate("2018-09-29T20:44:28");
		oCustomerBillOnDemand1.setType("customerBillOnDemand");
		oCustomerBillOnDemand1.setSchemaLocation("");		
		oCustomerBillOnDemand1.setBillingAccount(
				new BillingAccountRef("125","","Daniel Smith billing account","billing Account"));
		oCustomerBillOnDemand1.setRelatedParty(
				new RelatedPartyRef("710","","Daniel Smith","billReceiver","individualParty"));
		oCustomerBillOnDemand1.setCustomerBill(new BillRef("8297","","customerBill"));		
		lCustomerBillOnDemand.add(oCustomerBillOnDemand1);
		
		return lCustomerBillOnDemand;
	}
}