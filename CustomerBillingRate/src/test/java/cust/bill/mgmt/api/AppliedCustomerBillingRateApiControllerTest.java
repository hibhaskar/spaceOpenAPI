package cust.bill.mgmt.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cust.bill.mgmt.CustomerBillingRateStarter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomerBillingRateStarter.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppliedCustomerBillingRateApiControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext oWebApplicationContext;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(oWebApplicationContext).build();
	}

	@Test
	public void verifyCustomerBillOnDemandList() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/appliedCustomerBillingRate")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
				
		resultActions.andDo(print());
		resultActions.andExpect(status().isOk());
	}
	
	@Test
	public void verifyCustomerBillOnDemandById() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/appliedCustomerBillingRate/2082")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		resultActions.andDo(print());
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.id", is("2082")));
		resultActions.andExpect(jsonPath("$.type").value("appliedCustomerBillingRate"));
		resultActions.andExpect(jsonPath("$.name").value("National Voice Usage"));	
	}
	
	@Test
	public void verifyCustomerBillOnDemandByIvalidId() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/appliedCustomerBillingRate/11")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));		
		resultActions.andDo(print());
		resultActions.andExpect(status().isNoContent());
	}
}