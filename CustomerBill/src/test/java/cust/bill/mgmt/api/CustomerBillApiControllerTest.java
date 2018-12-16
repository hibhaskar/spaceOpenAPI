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

import cust.bill.mgmt.CustomerBillStarter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomerBillStarter.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerBillApiControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext oWebApplicationContext;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(oWebApplicationContext).build();
	}

	@Test
	public void verifyCustomerBillList() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/customerBill")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));				
		resultActions.andDo(print());
		resultActions.andExpect(status().isOk());
	}
	
	@Test
	public void verifyCustomerBillById() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/customerBill/8297")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));		
		resultActions.andDo(print());
		resultActions.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$.id", is("8297")));
		resultActions.andExpect(jsonPath("$.runType").value("onCycle"));
		resultActions.andExpect(jsonPath("$.billNo").value("1516171800"));	
	}
	
	@Test
	public void verifyCustomerBillByIvalidId() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/v.1/customerBill/11")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));		
		resultActions.andDo(print());
		resultActions.andExpect(status().isNoContent());
	}
}