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

import cust.bill.mgmt.dao.CustomerBillDAOImpl;
import cust.bill.mgmt.dao.model.AppliedPayment;
import cust.bill.mgmt.dao.model.Attachment;
import cust.bill.mgmt.dao.model.BillingAccountRef;
import cust.bill.mgmt.dao.model.CustomerBill;
import cust.bill.mgmt.dao.model.FinancialAccountRef;
import cust.bill.mgmt.dao.model.Money;
import cust.bill.mgmt.dao.model.PaymentMethodRef;
import cust.bill.mgmt.dao.model.PaymentRef;
import cust.bill.mgmt.dao.model.RelatedPartyRef;
import cust.bill.mgmt.dao.model.StateValue;
import cust.bill.mgmt.dao.model.TaxItem;
import cust.bill.mgmt.dao.model.TimePeriod;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerBillServiceTest {
	
	@Mock
	private CustomerBillDAOImpl oCustomerBillDAO;
	
	@InjectMocks
	private CustomerBillServiceImpl oCustomerBillService;
	
	@BeforeClass
	public static void stepup() {
	}
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCustomerBillList() {
		System.out.println("testCustomerBillList:::");
		List<CustomerBill> lCustomerBill = populateData();
		when(oCustomerBillDAO.customerBill()).thenReturn(lCustomerBill);		
		List<CustomerBill> result = oCustomerBillDAO.customerBill();
		assertEquals(1, result.size());
	}
	
	@Test
	public void testCustomerBillById() {
		System.out.println("testCustomerBillById:::");
		List<CustomerBill> lCustomerBill = populateData();
		when(oCustomerBillDAO.customerBillFind("8297")).thenReturn(lCustomerBill.get(0));
		CustomerBill oCustomerBill = oCustomerBillService.customerBillFind("8297");
		assertEquals("8297", oCustomerBill.getId());
		assertEquals("1516171800", oCustomerBill.getBillNo());
	}
	
	@After
	public void setdown() {
	}
	
	@AfterClass
	public static void stepdown() {
	}
	
	
	private static List<CustomerBill> populateData() {
		List<CustomerBill> lCustomerBill = new ArrayList<CustomerBill>();
		CustomerBill oCustomerBill1 = new CustomerBill();
		oCustomerBill1.setId("8297");
		oCustomerBill1.setHref("");
		oCustomerBill1.setBillNo("1516171800");
		oCustomerBill1.setRunType("onCycle");
		oCustomerBill1.setCategory("normal");
		oCustomerBill1.setState(StateValue.SENT);
		oCustomerBill1.setLastUpdate(OffsetDateTime.now());
		oCustomerBill1.setBillDate(OffsetDateTime.now());
		oCustomerBill1.setNextBillDate(OffsetDateTime.now().plusDays(30));
		oCustomerBill1.setBillingPeriod(
				new TimePeriod(OffsetDateTime.now().minusDays(30),OffsetDateTime.now().minusDays(1)));
		oCustomerBill1.setAmountDue(new Money ("EUR",1016.6f));
		oCustomerBill1.setPaymentDueDate(OffsetDateTime.now().plusDays(20));
		oCustomerBill1.setRemainingAmount(new Money ("EUR",466.6f));
		oCustomerBill1.setTaxExcludedAmount(new Money ("EUR",850.0f));
		oCustomerBill1.setTaxIncludedAmount(new Money ("EUR",1016.6f));
		oCustomerBill1.setBaseType("bill");
		oCustomerBill1.setSchemaLocation("");	

			List<Attachment> lAttachment = new ArrayList<Attachment>();
			lAttachment.add(
					new Attachment("22","","CustomeBill1516171800.pdf","application/pdf","bytes","",130f,"","","billDocument"));
		oCustomerBill1.setBillDocument(lAttachment);
		
			List<AppliedPayment> lAppliedPayment = new ArrayList<AppliedPayment>();		
				AppliedPayment oAppliedPayment1 = new AppliedPayment();
				oAppliedPayment1.setAppliedAmount(new Money ("EUR",100.0f));
					PaymentRef oPaymentRef1 = new PaymentRef();
					oPaymentRef1.setAmount(new Money ("EUR",1016.6f));
					oPaymentRef1.setHref("");
					oPaymentRef1.setId("601");
					oPaymentRef1.setPaymentDate(OffsetDateTime.now().plusDays(5));
					oPaymentRef1.setType("Payment");
				oAppliedPayment1.setPayment(oPaymentRef1);
			lAppliedPayment.add(oAppliedPayment1);
			
				AppliedPayment oAppliedPayment2 = new AppliedPayment();
				oAppliedPayment2.setAppliedAmount(new Money ("EUR",450.0f));
					PaymentRef oPaymentRef2 = new PaymentRef();
					oPaymentRef2.setAmount(new Money ("EUR",1016.6f));
					oPaymentRef2.setHref("");
					oPaymentRef2.setId("602");
					oPaymentRef2.setPaymentDate(OffsetDateTime.now().plusDays(10));
					oPaymentRef2.setType("Payment");
				oAppliedPayment2.setPayment(oPaymentRef1);
			lAppliedPayment.add(oAppliedPayment2);		
		oCustomerBill1.setAppliedPayment(lAppliedPayment);
		oCustomerBill1.setBillingAccount(
				new BillingAccountRef("65", "","Adam Smith billing account","billingAccount"));
		
			List<TaxItem> lTaxItem1 = new ArrayList<TaxItem>();
				TaxItem oTaxItem = new TaxItem();
				oTaxItem.setTaxCategory("VAT");
				oTaxItem.setTaxRate(19.6f);
				oTaxItem.setTaxAmount(new Money("EUR",1016.6f));
			lTaxItem1.add(oTaxItem);
		oCustomerBill1.setTaxItem(lTaxItem1);
		oCustomerBill1.setPaymentMethod(new PaymentMethodRef("41","","Adam Smith Credit Card","creditCard"));
		
			List<RelatedPartyRef> lRelatedPartyRef1 = new ArrayList<RelatedPartyRef>();
			lRelatedPartyRef1.add(new RelatedPartyRef("500","issuer","Orange","organizationParty",""));
			lRelatedPartyRef1.add(new RelatedPartyRef("710","billReceiver","Adam Smith","individualParty",""));
			lRelatedPartyRef1.add(new RelatedPartyRef("710","payer","Adam Smith","individualParty",""));
		oCustomerBill1.setRelatedParty(lRelatedPartyRef1);
		oCustomerBill1.setFinancialAccount(
				new FinancialAccountRef("15","Adam Smith financial account","financialAccount",""));
		
		lCustomerBill.add(oCustomerBill1);
		return lCustomerBill;
	}
}