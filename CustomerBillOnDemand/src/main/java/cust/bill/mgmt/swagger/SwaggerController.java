package cust.bill.mgmt.swagger;

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
	@RequestMapping(value = "/v.1")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
