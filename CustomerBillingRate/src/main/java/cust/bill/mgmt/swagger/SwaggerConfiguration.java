package cust.bill.mgmt.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfiguration for swagger api documentation
 *  
 * @author BHASKAR
 * @version 1.0.0
 */
@javax.annotation.Generated(
		value = "cust.bill.mgmt.codegen.languages.SpringCodegen", 
		date = "2018-09-29T16:06:28.483+05:30")

@Configuration
public class SwaggerConfiguration {
	
	/**
	 * Logger Object
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	/**
	 * <p>Get Documentation on 'TMF API Reference: TMF 678 - Customer Bill Management'</p>
	 * @param 
	 * @return ApiInfo
	 * 			Information/Documentation on APIs
	 * @since 1.0.0
	 */
    public ApiInfo apiInfo() {
    	logger.info("SwaggerConfiguration::ApiInfo apiInfo()");
        return new ApiInfoBuilder()
            .title("API CustomerBillDAO")
            .description("##TMF API Reference: TMF 678 - Customer bill Management  "
            		+ "<br/>"
            		+ "<p>##Release: pre-release 17.5  The Customer Bill Management API allows to find and retrieve one or "
            		+ "several customer bills (also called invoices) produced for a customer. "
            		+ "A customer bill is an electronic or paper document produced at the end of the billing process. "
            		+ "The customer bill gathers and displays different items (applied customer billing rates generated "
            		+ "during the rating and billing processes) to be charged to a customer. "
            		+ "It represents a total amount due for all the products during the billing period and all significant "
            		+ "information like dates, bill reference... "
            		+ "This API provides also operations to find and retrieve the details of applied customer billing rates "
            		+ "presented on a customer bill.  "
            		+ "Finally, this API allows to request in real-time a customer bill creation and to manage this request.</p>"
            		+ "<br/>"
            		+ "<p>### Resources  "
            		+ "<br/>- **customerBill** :  an electronic or paper document produced at the end of the "
            		+ "billing process that  gathers and displays different items (applied customer billing rates generated "
            		+ "during the rating and billing processes) to be charged to a customer. "
            		+ "<br/>- **appliedCustomerBillingRate** : applied billing rates created before or during the billing process "
            		+ "and displayed on a customer bill. "
            		+ "<br/>- **customerBillOnDemand** : used to manage the creation request of a customer bill in real-time "
            		+ "(on demand).  "
            		+ "<br/>###Customer Bill Management API performs the following operations : "
            		+ "<br/>- Retrieve a customer bill or a collection of customer bills depending on filter criteria. "
            		+ "<br/>- Partial update of  a customer bill (for administration purposes). "
            		+ "<br/>-  Retrieve an applied customer billing rate or a collection of applied customerbilling rates "
            		+ "depending on filter criteria. "
            		+ "-  Create a customer bill on demand request, retrieve one or a collection of  customer bill on demand "
            		+ "request(s) depending on filter criteria.  "
            		+ "- Manage notification of events on customer bill and customer bill on demand.  "
            		+ "<br/><br/>"
            		+ "Copyright © TM Forum 2017. All Rights Reserved.").license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("2.1.2_release")
            .contact(new Contact("","", ""))
            .build();
    }

	/**
	 * <p>Get SWAGGER_2 Bean</p>
	 * @param 
	 * @return Docket
	 * 			
	 * @since 1.0.0
	 */
    @Bean
    public Docket customImplementation(){
    	logger.info("SwaggerConfiguration::Docket customImplementation()");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("cust.bill.mgmt.api"))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
}