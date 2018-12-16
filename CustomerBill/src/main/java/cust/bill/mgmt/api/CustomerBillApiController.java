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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import cust.bill.mgmt.bus.model.CustomerBill;
import cust.bill.mgmt.dao.model.CustomerBillUpdate;
import cust.bill.mgmt.service.CustomerBillServiceImpl;
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
public class CustomerBillApiController implements CustomerBillApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerBillApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    CustomerBillServiceImpl oCustomerBillServiceImpl;

    @ApiOperation(value = "List customer bills", nickname = "customerBillFind", notes = "This operation list customer bill entities. Attribute selection is enabled for all first level attributes. Filtering may be available depending on the compliance level supported by an implementation.", response = CustomerBill.class, responseContainer = "List", tags={ "customerBill", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = CustomerBill.class, responseContainer = "List") })
    @RequestMapping(value = "/customerBill",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    public ResponseEntity<List<CustomerBill>> customerBillFind (
    		@ApiParam(value = "Selection of attributes separated by comma") @Valid @RequestParam(value = "fields", required = false) String fields,
    		@ApiParam(value = "Example of filter criteria that can be used to find customer bills") @Valid @RequestParam(value = "billingAccount.id", required = false) String billingAccountId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"runType\" : \"runType\",  \"@type\" : \"@type\",  \"taxItem\" : [ {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  }, {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  } ],  \"financialAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"remainingAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"@baseType\" : \"@baseType\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billNo\" : \"billNo\",  \"billDocument\" : [ {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  }, {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  } ],  \"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"billingPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"billDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"nextBillDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"amountDue\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"appliedPayment\" : [ {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  }, {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  } ],  \"paymentDueDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"paymentMethod\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"category\" : \"category\",  \"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  }}, {  \"runType\" : \"runType\",  \"@type\" : \"@type\",  \"taxItem\" : [ {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  }, {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  } ],  \"financialAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"remainingAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"@baseType\" : \"@baseType\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billNo\" : \"billNo\",  \"billDocument\" : [ {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  }, {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  } ],  \"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"billingPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"billDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"nextBillDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"amountDue\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"appliedPayment\" : [ {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  }, {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  } ],  \"paymentDueDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"paymentMethod\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"category\" : \"category\",  \"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  }} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillApi interface so no example is generated");
        }
        List<cust.bill.mgmt.dao.model.CustomerBill> lDAOCustomerBill = oCustomerBillServiceImpl.customerBill();
        logger.warn("List of CustomerBill: "+lDAOCustomerBill.size());
        if (lDAOCustomerBill.size()==0)
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<CustomerBill> lBUSCustomerBill = new ArrayList<CustomerBill>();
    	/*lCustomerBillOnDemand.forEach(
				oDAOCustomerBillOnDemand -> lBusCustomerBillOnDemand.add(
						new CustomerBillOnDemand(oDAOCustomerBillOnDemand)));*/
    	 //try {
 			System.out.println("\nCopying properties from DAOBean to BUSBean...\n");
 			lBUSCustomerBill = lDAOCustomerBill.stream().map(
 					oDAOCustomerBill -> {
		 				CustomerBill oBUSCustomerBill = new CustomerBill();
		 		        BeanUtils.copyProperties(oDAOCustomerBill, oBUSCustomerBill);
		 	            return oBUSCustomerBill;
 	        }).collect(Collectors.toList());
 		/*} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
 		System.out.println("DAO...");
		System.out.println(lDAOCustomerBill);
		System.out.println("BUS...");
		System.out.println(lBUSCustomerBill);
 		
        logger.warn("List<cust.bill.mgmt.bus.model.CustomerBill>"+lBUSCustomerBill.size());
        
        return new ResponseEntity<List<CustomerBill>>
        	(lBUSCustomerBill, HttpStatus.OK);
        /*List<cust.bill.mgmt.bus.model.CustomerBill> lBusCustomerBill = new ArrayList<cust.bill.mgmt.bus.model.CustomerBill>();
        lDAOCustomerBill.forEach(
				oDAOCustomerBill -> lBusCustomerBill.add(new cust.bill.mgmt.bus.model.CustomerBill(oDAOCustomerBill)));
        logger.warn("List<cust.bill.mgmt.bus.model.CustomerBill>"+lBusCustomerBill.size());*/
        //return new ResponseEntity<List<cust.bill.mgmt.bus.model.CustomerBill>>(lBusCustomerBill, HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve a customer bill", nickname = "customerBillGet", notes = "This operation retrieves a customer bill entity. Attribute selection is enabled for all first level attributes. Filtering on sub-resources may be available depending on the compliance level supported by an implementation.", response = CustomerBill.class, tags={ "customerBill", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = CustomerBill.class) })
    @RequestMapping(value = "/customerBill/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.GET)
    public ResponseEntity<CustomerBill> customerBillGet(
    		@ApiParam(value = "",required=true) @PathVariable("id") String id,
    		@ApiParam(value = "Selection of attributes separated by comma") @Valid @RequestParam(value = "fields", required = false) String fields) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"runType\" : \"runType\",  \"@type\" : \"@type\",  \"taxItem\" : [ {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  }, {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  } ],  \"financialAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"remainingAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"@baseType\" : \"@baseType\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billNo\" : \"billNo\",  \"billDocument\" : [ {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  }, {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  } ],  \"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"billingPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"billDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"nextBillDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"amountDue\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"appliedPayment\" : [ {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  }, {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  } ],  \"paymentDueDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"paymentMethod\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"category\" : \"category\",  \"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  }}", CustomerBill.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillApi interface so no example is generated");
        }
        cust.bill.mgmt.dao.model.CustomerBill oDAOCustomerBill = oCustomerBillServiceImpl.customerBillFind(id);
        logger.warn("CustomerBill: "+oDAOCustomerBill);
        if (oDAOCustomerBill == null)
        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        CustomerBill oBUSCustomerBill = new CustomerBill();
		System.out.println("\nCopying properties from fromBean to toBean...\n");
		BeanUtils.copyProperties(oDAOCustomerBill, oBUSCustomerBill);
		System.out.println(oDAOCustomerBill);
		System.out.println(oBUSCustomerBill);

		//return new ResponseEntity<CustomerBillOnDemand>(oBUSCustomerBillOnDemand,HttpStatus.OK);
        return new ResponseEntity<CustomerBill>(oBUSCustomerBill, HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "Partially update a customer bill", nickname = "customerBillPatch", notes = "Note: this operation is available only to ADMIN API users. The PATCH Bill operation is optional. An implementation is not required to support PATCH to be compliant with the standard. This operation allows partial updates of a customer bill entity. Only state attribute is patchable. This operation allows partial updates of a customer bill entity. Support of json/merge (https://tools.ietf.org/html/rfc7386) is mandatory, support of json/patch (http://tools.ietf.org/html/rfc5789) is optional.", response = CustomerBill.class, tags={ "customerBill", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = CustomerBill.class) })
    @RequestMapping(value = "/customerBill/{id}",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.PATCH)
    public ResponseEntity<CustomerBill> customerBillPatch(
    		@ApiParam(value = "",required=true) @PathVariable("id") String id,
    		@ApiParam(value = "" ,required=true )  @Valid @RequestBody CustomerBillUpdate customerBill) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"runType\" : \"runType\",  \"@type\" : \"@type\",  \"taxItem\" : [ {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  }, {    \"taxRate\" : 1.4658129,    \"taxAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    },    \"taxCategory\" : \"taxCategory\"  } ],  \"financialAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"billingAccount\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"remainingAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"@baseType\" : \"@baseType\",  \"id\" : \"id\",  \"href\" : \"href\",  \"state\" : { },  \"@schemaLocation\" : \"@schemaLocation\",  \"billNo\" : \"billNo\",  \"billDocument\" : [ {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  }, {    \"size\" : 6.0274563,    \"@type\" : \"@type\",    \"name\" : \"name\",    \"description\" : \"description\",    \"sizeUnit\" : \"sizeUnit\",    \"id\" : \"id\",    \"href\" : \"href\",    \"mimeType\" : \"mimeType\",    \"@schemaLocation\" : \"@schemaLocation\",    \"url\" : \"url\"  } ],  \"taxExcludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"billingPeriod\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"billDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"relatedParty\" : [ {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  }, {    \"role\" : \"role\",    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  } ],  \"nextBillDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"amountDue\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  },  \"appliedPayment\" : [ {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  }, {    \"payment\" : {      \"amount\" : {        \"unit\" : \"unit\",        \"value\" : 0.8008282      },      \"@type\" : \"@type\",      \"id\" : \"id\",      \"href\" : \"href\",      \"paymentDate\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"appliedAmount\" : {      \"unit\" : \"unit\",      \"value\" : 0.8008282    }  } ],  \"paymentDueDate\" : \"2000-01-23T04:56:07.000+00:00\",  \"lastUpdate\" : \"2000-01-23T04:56:07.000+00:00\",  \"paymentMethod\" : {    \"@type\" : \"@type\",    \"name\" : \"name\",    \"id\" : \"id\",    \"href\" : \"href\"  },  \"category\" : \"category\",  \"taxIncludedAmount\" : {    \"unit\" : \"unit\",    \"value\" : 0.8008282  }}", CustomerBill.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                	logger.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
        	logger.warn("ObjectMapper or HttpServletRequest not configured in default CustomerBillApi interface so no "
        			+ "example is generated");
        }
        if (customerBill == null)
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        		
		cust.bill.mgmt.dao.model.CustomerBill oDAOCustomerBill = 
				oCustomerBillServiceImpl.customerBillPatch(id,customerBill);
		
		CustomerBill oBUSCustomerBill = new CustomerBill();
		System.out.println("\nCopying properties from fromBean to toBean...\n");
		BeanUtils.copyProperties(oDAOCustomerBill, oBUSCustomerBill);
		System.out.println(oDAOCustomerBill);
		System.out.println(oBUSCustomerBill);
		
		
		/*CustomerBillOnDemand oBUSCustomerBillOnDemand = new CustomerBillOnDemand();
		BeanUtils.copyProperties(oDAOCustomerBillOnDemand.getBillingAccount(), 
				oBUSCustomerBillOnDemand.billingAccount, getNullPropertyNames(oDAOCustomerBillOnDemand));
		    
		return new ResponseEntity<CustomerBillOnDemand>(oBUSCustomerBillOnDemand, HttpStatus.OK);*/
		return new ResponseEntity<CustomerBill>(oBUSCustomerBill, HttpStatus.OK);
        //return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}