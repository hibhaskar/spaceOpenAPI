package cust.bill.mgmt.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import cust.bill.mgmt.bus.model.AppliedCustomerBillingRate;
import cust.bill.mgmt.service.AppliedCustomerBillingRateServiceImpl;
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
public class AppliedCustomerBillingRateApiController implements AppliedCustomerBillingRateApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AppliedCustomerBillingRateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    AppliedCustomerBillingRateServiceImpl oAppliedCustomerBillingRateServiceImpl;
    
    @RequestMapping(value = "/appliedCustomerBillingRate",
            produces = { "application/json;charset=utf-8" }, 
            consumes = { "application/json;charset=utf-8" },
            method = RequestMethod.GET)
    public ResponseEntity<List<AppliedCustomerBillingRate>> appliedCustomerBillingRateFind(
		@ApiParam(value = "Selection of attributes separated by comma") 
		@Valid @RequestParam(value = "fields", required = false) String fields,
		@ApiParam(value = "Example of a filter criteria that can be used to find applied customer billing rates") 
		@Valid @RequestParam(value = "bill.id", required = false) String billId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(
                        		getObjectMapper().get().readValue(""
                        				+ "[ {  \"date\" : \"2000-01-23T04:56:07.000+00:00\",  "
                        				+ "\"taxExcludedAmount\" : {    \"unit\" : \"unit\",    "
                        				+ "\"value\" : 0.8008282  },  \"@type\" : \"@type\",  "
                        				+ "\"description\" : \"description\",  \"bill\" : {    "
                        				+ "\"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  "
                        				+ "\"type\" : \"type\",  \"characteristic\" : [ {    "
                        				+ "\"@type\" : \"@type\",    \"name\" : \"name\",    "
                        				+ "\"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, "
                        				+ "{    \"@type\" : \"@type\",    \"name\" : \"name\",    "
                        				+ "\"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  "
                        				+ "\"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"id\" : \"id\",  "
                        				+ "\"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  "
                        				+ "\"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  "
                        				+ "\"appliedTax\" : [ {    \"taxRate\" : 0.8008282,    \"taxAmount\" : {      "
                        				+ "\"unit\" : \"unit\",      \"value\" : 0.8008282    },    "
                        				+ "\"taxCategory\" : \"taxCategory\"  }, {    \"taxRate\" : 0.8008282,    "
                        				+ "\"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    "
                        				+ "\"taxCategory\" : \"taxCategory\"  } ]}, "
                        				+ "{  \"date\" : \"2000-01-23T04:56:07.000+00:00\",  "
                        				+ "\"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  "
                        				+ "\"@type\" : \"@type\",  \"description\" : \"description\",  "
                        				+ "\"bill\" : {    \"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"type\" : \"type\",  "
                        				+ "\"characteristic\" : [ "
                        				+ "{    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  }, "
                        				+ "{    \"@type\" : \"@type\",    \"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  "
                        				+ "\"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"id\" : \"id\",  \"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  "
                        				+ "\"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  "
                        				+ "\"appliedTax\" : [ "
                        				+ "{    \"taxRate\" : 0.8008282,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    "
                        				+ "\"taxCategory\" : \"taxCategory\"  }, "
                        				+ "{    \"taxRate\" : 0.8008282,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    "
                        				+ "\"taxCategory\" : \"taxCategory\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default "
            		+ "AppliedCustomerBillingRateApi interface so no example is generated");
        }
            
        List<cust.bill.mgmt.dao.model.AppliedCustomerBillingRate> lDAOBillRate = 
        		oAppliedCustomerBillingRateServiceImpl.appliedCustomerBillingRate();
        logger.warn("List of AppliedCustomerBillingRate: "+lDAOBillRate.size());
        if (lDAOBillRate.size()==0)
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        /*List<AppliedCustomerBillingRate> lBusAppliedCustomerBillingRate = 
        		new ArrayList<AppliedCustomerBillingRate>();
        lDAOBillRate.forEach(
				oDAOCustomerBill -> lBusAppliedCustomerBillingRate.add(
				new AppliedCustomerBillingRate(oDAOCustomerBill)));
        logger.warn("List<cust.bill.mgmt.bus.model.CustomerBill>"+lBusAppliedCustomerBillingRate.size());
        
        return new ResponseEntity<List<AppliedCustomerBillingRate>>(lBusAppliedCustomerBillingRate,HttpStatus.OK);*/
        List<AppliedCustomerBillingRate> lBUSBillRate = new ArrayList<AppliedCustomerBillingRate>();
    	/*lCustomerBillOnDemand.forEach(
				oDAOCustomerBillOnDemand -> lBusCustomerBillOnDemand.add(
						new CustomerBillOnDemand(oDAOCustomerBillOnDemand)));*/
    	 //try {
		System.out.println("\nCopying properties from fromBean to toBean...\n");
		lBUSBillRate = lDAOBillRate.stream().map(oDAOBillRate -> {
			AppliedCustomerBillingRate oBUSBillRate = new AppliedCustomerBillingRate();
	        BeanUtils.copyProperties(oDAOBillRate, oBUSBillRate);
            return oBUSBillRate;
        }).collect(Collectors.toList());
 		/*} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
 		System.out.println("DAO...");
		System.out.println(lDAOBillRate);
		System.out.println("BUS...");
		System.out.println(lBUSBillRate);
 		
        logger.warn("List<cust.bill.mgmt.bus.model.CustomerBill>"+lBUSBillRate.size());
        
        return new ResponseEntity<List<AppliedCustomerBillingRate>>
        	(lBUSBillRate, HttpStatus.OK);
        
    }

    @ApiOperation(value = "Retrieve an applied customer billing rate", nickname = "appliedCustomerBillingRateGet", 
    		notes = "This operation retrieves an applied customer billing rate entity. "
    				+ "Attribute selection is enabled for all first level attributes. "
    				+ "Filtering on sub-resources may be available depending on the compliance level supported by an implementation.", 
    				response = AppliedCustomerBillingRate.class, tags={ "appliedCustomerBillingRate", })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Success", response = AppliedCustomerBillingRate.class) })
    @RequestMapping(value = "/appliedCustomerBillingRate/{id}",
            produces = { "application/json;charset=utf-8" }, 
            consumes = { "application/json;charset=utf-8" },
            method = RequestMethod.GET)
    public ResponseEntity<cust.bill.mgmt.bus.model.AppliedCustomerBillingRate> appliedCustomerBillingRateGet(
    		@ApiParam(value = "",required=true) @PathVariable("id") String id,
    		@ApiParam(value = "Selection of attributes separated by comma") 
    		@Valid @RequestParam(value = "fields", required = false) String fields) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(
                    		getObjectMapper().get().readValue("{  \"date\" : \"2000-01-23T04:56:07.000+00:00\",  "
                    				+ "\"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  "
                    				+ "\"@type\" : \"@type\",  \"description\" : \"description\",  \"bill\" : {    "
                    				+ "\"@type\" : \"@type\",    \"id\" : \"id\",    \"href\" : \"href\"  },  "
                    				+ "\"type\" : \"type\",  \"characteristic\" : [ {    \"@type\" : \"@type\",    "
                    				+ "\"name\" : \"name\",    \"@schemaLocation\" : \"@schemaLocation\",    "
                    				+ "\"value\" : \"value\"  }, {    \"@type\" : \"@type\",    \"name\" : \"name\",    "
                    				+ "\"@schemaLocation\" : \"@schemaLocation\",    \"value\" : \"value\"  } ],  "
                    				+ "\"@baseType\" : \"@baseType\",  \"name\" : \"name\",  \"id\" : \"id\",  "
                    				+ "\"href\" : \"href\",  \"@schemaLocation\" : \"@schemaLocation\",  "
                    				+ "\"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  "
                    				+ "\"appliedTax\" : [ "
                    				+ "{    \"taxRate\" : 0.8008282,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  }, "
                    				+ "{    \"taxRate\" : 0.8008282,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  } ]}", 
                    				AppliedCustomerBillingRate.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default "
        			+ "AppliedCustomerBillingRateApi interface so no example is generated");
        }
        
        cust.bill.mgmt.dao.model.AppliedCustomerBillingRate oDAOAppliedCustomerBillingRate = 
        		oAppliedCustomerBillingRateServiceImpl.appliedCustomerBillingRateFind(id);
        logger.warn("AppliedCustomerBillingRate:: "+oDAOAppliedCustomerBillingRate);
        if (oDAOAppliedCustomerBillingRate == null)
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        AppliedCustomerBillingRate oBUSAppliedCustomerBillingRate = new AppliedCustomerBillingRate();
        //try {
		System.out.println("\nCopying properties from fromBean to toBean...\n");
		
		BeanUtils.copyProperties(oDAOAppliedCustomerBillingRate, oBUSAppliedCustomerBillingRate);
		System.out.println("DAO...");
		System.out.println(oDAOAppliedCustomerBillingRate);
		System.out.println("BUS...");
		System.out.println(oBUSAppliedCustomerBillingRate);
		/*} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
        return new ResponseEntity<AppliedCustomerBillingRate>(oBUSAppliedCustomerBillingRate,HttpStatus.OK);
        /*return new ResponseEntity<AppliedCustomerBillingRate>(
        		new AppliedCustomerBillingRate(oAppliedCustomerBillingRate), HttpStatus.OK);*/
    }    
}
