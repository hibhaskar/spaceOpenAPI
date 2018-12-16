package cust.bill.mgmt.api;

import java.beans.FeatureDescriptor;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import cust.bill.mgmt.dao.model.CustomerBillOnDemand;
import cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest;
import cust.bill.mgmt.service.CustomerBillOnDemandServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", 
		date = "2018-09-29T16:06:28.483+05:30")

//@Controller
@RestController
@RequestMapping("/v.1")
public class CustomerBillOnDemandApiController implements CustomerBillOnDemandApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerBillOnDemandApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }    
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    CustomerBillOnDemandServiceImpl oCustomerBillOnDemandServiceImpl;
    
    @ApiOperation(value = "Create a customer bill on demand", nickname = "customerBillOnDemandCreate", notes = "This operation creates a customer bill on demand entity.", response = CustomerBillOnDemand.class, tags={ "CustomerBillOnDemand", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Success", response = CustomerBillOnDemand.class) 
    })
    @RequestMapping(value = "/customerBillOnDemand",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    public ResponseEntity<CustomerBillOnDemand> customerBillOnDemandCreate(
    		@ApiParam(value = "",required=true) @Valid @RequestBody CustomerBillOnDemandRequest customerBillOnDemand) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"customerBill\" : {    \"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"@type\" : \"@type\",  \"lastUpdate\" : \"lastUpdate\",  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"relatedParty\" : {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }}", CustomerBillOnDemand.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillOnDemandApi interface so no example is generated");
        }
        if (customerBillOnDemand == null)
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        /*cust.bill.mgmt.dao.model.CustomerBillOnDemand oDAOCustomerBillOnDemand = 
    			new cust.bill.mgmt.dao.model.CustomerBillOnDemand();*/
        cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest oDAOCustomerBillOnDemandRequest = 
    			new cust.bill.mgmt.dao.model.CustomerBillOnDemandRequest();
        BeanUtils.copyProperties(customerBillOnDemand, oDAOCustomerBillOnDemandRequest);
        cust.bill.mgmt.dao.model.CustomerBillOnDemand oDAOCustomerBillOnDemand = 
        		oCustomerBillOnDemandServiceImpl.customerBillOnDemandCreate(oDAOCustomerBillOnDemandRequest);
        /*CustomerBillOnDemand oBUSCustomerBillOnDemand = new CustomerBillOnDemand();
        BeanUtils.copyProperties(oDAOCustomerBillOnDemand.getBillingAccount(), 
				oBUSCustomerBillOnDemand.billingAccount, getNullPropertyNames(oDAOCustomerBillOnDemand));
            
        return new ResponseEntity<CustomerBillOnDemand>(oBUSCustomerBillOnDemand, HttpStatus.OK);*/
        return new ResponseEntity<CustomerBillOnDemand>(oDAOCustomerBillOnDemand, HttpStatus.OK);
    }
    
    @SuppressWarnings("unchecked")
	@ApiOperation(value = "Retrieve customer bill on demand with filter criteria", nickname = "customerBillOnDemandFind", notes = "This operation list customer bill on demand entities. Attribute selection is enabled for all first level attributes. Filtering may be available depending on the compliance level supported by an implementation.", response = CustomerBillOnDemand.class, responseContainer = "List", tags={ "CustomerBillOnDemand", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = CustomerBillOnDemand.class, responseContainer = "List") })
    @RequestMapping(value = "/customerBillOnDemand",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    public ResponseEntity<List<CustomerBillOnDemand>> customerBillOnDemandFind (
    		@ApiParam(value = "Attributes selection") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	logger.info("ResponseEntity<List<CustomerBillOnDemand>> customerBillOnDemandFind");
    	if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
            	try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue(
                    		"[ {  \"customerBill\" : {    \"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"@type\" : \"@type\",  \"lastUpdate\" : \"lastUpdate\",  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"relatedParty\" : {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }}, {  \"customerBill\" : {    \"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"@type\" : \"@type\",  \"lastUpdate\" : \"lastUpdate\",  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"relatedParty\" : {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillOnDemandApi interface so no example is generated");
        }
    	List<cust.bill.mgmt.dao.model.CustomerBillOnDemand> lDAOCustomerBillOnDemand = 
    			oCustomerBillOnDemandServiceImpl.customerBillOnDemand();
        logger.warn("List of CustomerBillOnDemand:: "+lDAOCustomerBillOnDemand.size());
    	if (lDAOCustomerBillOnDemand == null || lDAOCustomerBillOnDemand.size()==0)
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    	/*List<CustomerBillOnDemand> lBUSCustomerBillOnDemand = new ArrayList<CustomerBillOnDemand>();
    	lCustomerBillOnDemand.forEach(
				oDAOCustomerBillOnDemand -> lBusCustomerBillOnDemand.add(
						new CustomerBillOnDemand(oDAOCustomerBillOnDemand)));
    	 //try {
 			System.out.println("\nCopying properties from fromBean to toBean...\n");
 			lBUSCustomerBillOnDemand = lDAOCustomerBillOnDemand.stream().map(oDAOCustomerBillOnDemand -> {
 				CustomerBillOnDemand oBUSCustomerBillOnDemand = new CustomerBillOnDemand();
 		        BeanUtils.copyProperties(oDAOCustomerBillOnDemand, oBUSCustomerBillOnDemand);
 		        //BeanUtils.copyProperties(oDAOCustomerBillOnDemand.getBillingAccount(), oBUSCustomerBillOnDemand.billingAccount);
 	            return oBUSCustomerBillOnDemand;
 	        }).collect(Collectors.toList());
 		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
 			
		System.out.println(lDAOCustomerBillOnDemand);
		System.out.println(lBUSCustomerBillOnDemand);
 		
        logger.warn("List<cust.bill.mgmt.bus.model.CustomerBill>"+lBUSCustomerBillOnDemand.size());
        
        return new ResponseEntity<List<CustomerBillOnDemand>>
        	(lBUSCustomerBillOnDemand, HttpStatus.OK);*/
    	return new ResponseEntity<List<CustomerBillOnDemand>>(lDAOCustomerBillOnDemand, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve a customer bill on demand with its id", nickname = "customerBillOnDemandGet", notes = "This operation retrieves a customer bill on demand entity. Attribute selection is enabled for all first level attributes. Filtering on sub-resources may be available depending on the compliance level supported by an implementation.", response = CustomerBillOnDemand.class, tags={ "CustomerBillOnDemand", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = CustomerBillOnDemand.class) })
    @RequestMapping(value = "/customerBillOnDemand/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    public ResponseEntity<CustomerBillOnDemand> customerBillOnDemandGet(
    		@ApiParam(value = "",required=true) @PathVariable("id") String id,
    		@ApiParam(value = "Attributes selection") @Valid @RequestParam(value = "fields", required = false) String fields) {
    	logger.info("customerBillOnDemandGet");
    	if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"customerBill\" : {    \"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"@type\" : \"@type\",  \"lastUpdate\" : \"lastUpdate\",  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"relatedParty\" : {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }}", CustomerBillOnDemand.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillOnDemandApi interface so no example is generated");
        }
        
    	cust.bill.mgmt.dao.model.CustomerBillOnDemand oDAOCustomerBillOnDemand = 
    			oCustomerBillOnDemandServiceImpl.customerBillOnDemandFind(id);
        logger.info("CustomerBillOnDemand:: "+oDAOCustomerBillOnDemand);
        if (oDAOCustomerBillOnDemand == null)
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        /*CustomerBillOnDemand oBUSCustomerBillOnDemand = new CustomerBillOnDemand();
        //try {
			System.out.println("\nCopying properties from fromBean to toBean...\n");
			
			BeanUtils.copyProperties(oDAOCustomerBillOnDemand, oBUSCustomerBillOnDemand);
			System.out.println("\nCopying properties from fromBean to toBean...\n");
			BeanUtils.copyProperties(oDAOCustomerBillOnDemand.getBillingAccount(), 
					oBUSCustomerBillOnDemand.billingAccount, getNullPropertyNames(oDAOCustomerBillOnDemand));
	            
			System.out.println(oDAOCustomerBillOnDemand);
			System.out.println(oBUSCustomerBillOnDemand);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
        return new ResponseEntity<CustomerBillOnDemand>(oBUSCustomerBillOnDemand,HttpStatus.OK);*/
        		/*new CustomerBillOnDemand(oBUSCustomerBillOnDemand),
        		HttpStatus.OK);*/
        return new ResponseEntity<CustomerBillOnDemand>(oDAOCustomerBillOnDemand,HttpStatus.OK);
    }
    
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
    
}