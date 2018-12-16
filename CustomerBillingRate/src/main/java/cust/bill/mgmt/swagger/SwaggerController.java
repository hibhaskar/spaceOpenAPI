package cust.bill.mgmt.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirection to swagger api documentation
 *  
 * @author BHASKAR
 * @version 1.0.0
 */
@Controller
public class SwaggerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@RequestMapping(value = "/v.1")
    public String index() {
		logger.info("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
