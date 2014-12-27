package human.web;

import human.service.HumanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoge")
public class HogeController {
	@Autowired
	HumanService service;
	
	
    @RequestMapping("/up")
    public String up() {
    	service.praise(100);
        return "hoge";
    }
    
    @RequestMapping("/down")
    public String down() {
    	service.abuse(100);
        return "hoge";
    }
}
