package human.web;

import human.service.HumanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoge")
public class HogeController {
	
	@Autowired
	private HumanService service;
	
    @RequestMapping("/up")
    public String up() {
    	service.increment(100);
        return "hoge";
    }
    
    @RequestMapping("/down")
    public String down() {
    	service.decrement(100);
        return "hoge";
    }
}
