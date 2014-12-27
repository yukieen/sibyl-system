package human.web;

import javax.servlet.http.HttpServletRequest;

import human.model.Human;
import human.model.Psychopass;
import human.service.HumanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("human")
public class HogeController {
	
	@Autowired
	private HumanService service;
	
	@ModelAttribute("human")
	public Human human() {
		return new Human("ほげくん",new Psychopass());
	}
	
    @RequestMapping("/")
    public String index() {
		return "hoge";
    }
    
    @RequestMapping("/up")
    public String up(@ModelAttribute Human human) {
    	human.getPsychoPass().increment(100);
    	service.increment(100);
        return "hoge";
    }
    
    @RequestMapping("/down")
    public String down(@ModelAttribute Human human) {
    	human.getPsychoPass().decrement(100);
    	service.decrement(100);
        return "hoge";
    }
    
    @RequestMapping("/paralize")
    public void paralize(@ModelAttribute Human human){
    	human.paralize();
    }
}
