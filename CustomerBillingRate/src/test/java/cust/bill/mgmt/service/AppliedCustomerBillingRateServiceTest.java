package cust.bill.mgmt.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
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

import cust.bill.mgmt.dao.AppliedCustomerBillingRateDAOImpl;
import cust.bill.mgmt.dao.model.AppliedBillingRateCharacteristic;
import cust.bill.mgmt.dao.model.AppliedBillingTaxRate;
import cust.bill.mgmt.dao.model.AppliedCustomerBillingRate;
import cust.bill.mgmt.dao.model.BillRef;
import cust.bill.mgmt.dao.model.Money;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppliedCustomerBillingRateServiceTest {
	
	@Mock
	private AppliedCustomerBillingRateDAOImpl oAppliedCustomerBillingRateDAO;
	
	@InjectMocks
	private AppliedCustomerBillingRateServiceImpl oAppliedCustomerBillingRateService;
	
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
		List<AppliedCustomerBillingRate> lAppliedCustomerBillingRate = populateData();
		when(oAppliedCustomerBillingRateDAO.appliedCustomerBillingRate())
				.thenReturn(lAppliedCustomerBillingRate);		
		List<AppliedCustomerBillingRate> result = 
				oAppliedCustomerBillingRateService.appliedCustomerBillingRate();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testCustomerBillOnDemandById() {
		System.out.println("testCustomerBillOnDemandById:::");
		List<AppliedCustomerBillingRate> lAppliedCustomerBillingRate = populateData();
		when(oAppliedCustomerBillingRateDAO.appliedCustomerBillingRateFind("2082"))
				.thenReturn(lAppliedCustomerBillingRate.get(0));
		AppliedCustomerBillingRate oAppliedCustomerBillingRate = 
				oAppliedCustomerBillingRateService.appliedCustomerBillingRateFind("2082");
		assertEquals("2082", oAppliedCustomerBillingRate.getId());
		assertEquals("National Voice Usage", oAppliedCustomerBillingRate.getName());
	}
	
	@After
	public void setdown() {
	}
	
	@AfterClass
	public static void stepdown() {
	}
	
	
	private static List<AppliedCustomerBillingRate> populateData() {		
		List<AppliedCustomerBillingRate> lBillingRate = new ArrayList<AppliedCustomerBillingRate>();
		/****************************************************************************************/
		AppliedCustomerBillingRate oAppliedCustomerBillingRate1 = new AppliedCustomerBillingRate();
		oAppliedCustomerBillingRate1.setId("2082");
		oAppliedCustomerBillingRate1.setName("National Voice Usage");
		oAppliedCustomerBillingRate1.setDescription("National Voice Usage amount");
		oAppliedCustomerBillingRate1.setDate(OffsetDateTime.now());
		oAppliedCustomerBillingRate1.setType("usageCharge");
		oAppliedCustomerBillingRate1.setTaxExcludedAmount(new Money ("EUR",350.0f));
		oAppliedCustomerBillingRate1.setTaxIncludedAmount(new Money ("EUR",418.60f));
		oAppliedCustomerBillingRate1.setBaseType("appliedBillingRate");
		oAppliedCustomerBillingRate1.setBillType("appliedCustomerBillingRate");
		oAppliedCustomerBillingRate1.setSchemaLocation("www.appliedBillingRate.appliedCustomerBillingRate.json");
		
			AppliedBillingTaxRate oAppliedBillingTaxRate = new AppliedBillingTaxRate();
			oAppliedBillingTaxRate.setTaxCategory("VAT");
			oAppliedBillingTaxRate.setTaxRate(19.6f);
			oAppliedBillingTaxRate.setTaxAmount(new Money ("EUR",68.60f));
			List<AppliedBillingTaxRate> lAppliedBillingTaxRate = new ArrayList<AppliedBillingTaxRate>();
			lAppliedBillingTaxRate.add(oAppliedBillingTaxRate);
		oAppliedCustomerBillingRate1.setAppliedTax(lAppliedBillingTaxRate);
		oAppliedCustomerBillingRate1.setBill(
				new BillRef("8297","customerBill","https://host:port/customerBillManagement/customerBill/8297"));
		
			List<AppliedBillingRateCharacteristic> lCharacteristics = new ArrayList<AppliedBillingRateCharacteristic> ();
			AppliedBillingRateCharacteristic oAppliedBillingRateCharacteristic1 = new AppliedBillingRateCharacteristic();
			oAppliedBillingRateCharacteristic1.setName("unitCode");
			oAppliedBillingRateCharacteristic1.setValue("mn");
			AppliedBillingRateCharacteristic oAppliedBillingRateCharacteristic2 = new AppliedBillingRateCharacteristic();
			oAppliedBillingRateCharacteristic2.setName("UnitNumber");
			oAppliedBillingRateCharacteristic2.setValue("3600");
			lCharacteristics.add(oAppliedBillingRateCharacteristic1);
			lCharacteristics.add(oAppliedBillingRateCharacteristic2);
		oAppliedCustomerBillingRate1.setCharacteristic(lCharacteristics);
		
		lBillingRate.add(oAppliedCustomerBillingRate1);
		/************************************************************************************************************/
		AppliedCustomerBillingRate oAppliedCustomerBillingRate2 = new AppliedCustomerBillingRate();
		oAppliedCustomerBillingRate2.setId("2081");
		oAppliedCustomerBillingRate2.setName("Inter-National Voice Usage");
		oAppliedCustomerBillingRate2.setDescription("Inter-National Voice Usage amount");
		oAppliedCustomerBillingRate2.setDate(OffsetDateTime.now());
		oAppliedCustomerBillingRate2.setType("usageCharge");
		oAppliedCustomerBillingRate2.setTaxExcludedAmount(new Money ("EUR",305.0f));
		oAppliedCustomerBillingRate2.setTaxIncludedAmount(new Money ("EUR",428.60f));
		oAppliedCustomerBillingRate2.setBaseType("appliedBillingRate");
		oAppliedCustomerBillingRate2.setBillType("appliedCustomerBillingRate");
		oAppliedCustomerBillingRate2.setSchemaLocation("\"www.appliedBillingRate.appliedCustomerBillingRate.json\"");
		
			AppliedBillingTaxRate oAppliedBillingTaxRate1 = new AppliedBillingTaxRate();
			oAppliedBillingTaxRate1.setTaxCategory("VAT");
			oAppliedBillingTaxRate1.setTaxRate(19.6f);
			oAppliedBillingTaxRate.setTaxAmount(new Money ("EUR",68.60f));
			List<AppliedBillingTaxRate> lAppliedBillingTaxRate1 = new ArrayList<AppliedBillingTaxRate>();
			lAppliedBillingTaxRate1.add(oAppliedBillingTaxRate);
		oAppliedCustomerBillingRate2.setAppliedTax(lAppliedBillingTaxRate);
		oAppliedCustomerBillingRate2.setBill(
				new BillRef("8297","customerBill","https://host:port/customerBillManagement/customerBill/8297"));
		
			List<AppliedBillingRateCharacteristic> lCharacteristics1 = new ArrayList<AppliedBillingRateCharacteristic> ();
			AppliedBillingRateCharacteristic oAppliedBillingRateCharacteristic3 = new AppliedBillingRateCharacteristic();
			oAppliedBillingRateCharacteristic3.setName("unitCode");
			oAppliedBillingRateCharacteristic3.setValue("mn");
			AppliedBillingRateCharacteristic oAppliedBillingRateCharacteristic4 = new AppliedBillingRateCharacteristic();
			oAppliedBillingRateCharacteristic4.setName("UnitNumber");
			oAppliedBillingRateCharacteristic4.setValue("3600");
			lCharacteristics.add(oAppliedBillingRateCharacteristic3);
			lCharacteristics.add(oAppliedBillingRateCharacteristic4);
		oAppliedCustomerBillingRate2.setCharacteristic(lCharacteristics1);
		
		lBillingRate.add(oAppliedCustomerBillingRate2);
		
		return lBillingRate;
	}
}