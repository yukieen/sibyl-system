package human.web;

import human.model.Human;
import human.model.Psychopass;
import human.service.HumanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HogeController {
	
	private final Human human = new Human("ほげくん",new Psychopass());

	@Autowired
	private HumanService service;
	
	@ModelAttribute("human")
	public Human human(){
		return human;
	}
	
    @RequestMapping("/")
    public String index() {
		return "hoge";
    }
    
    @RequestMapping("/sexy")
    public String sexy() {
    	increment(100);
        return "hoge";
    }
    
    @RequestMapping("/bye")
    public String bye() {
    	increment(75);
        return "hoge";
    }
    
    @RequestMapping("/party")
    public String party() {
    	decrement(30);
        return "hoge";
    }
    
    @RequestMapping("/grand-final")
    public String grandFinal() {
    	increment(30);
        return "hoge";
    }
    
    @RequestMapping("/oppai")
    public String oppai() {
    	decrement(100);
        return "hoge";
    }
    
    @RequestMapping(value = "/paralize", method = RequestMethod.POST)
    public String paralize(){
    	human.paralize();
    	return "hoge";
    }
    
    private void increment(int value){
    	human.getPsychoPass().increment(value);
    	service.increment(value);
    }
   
    private void decrement(int value){
    	human.getPsychoPass().decrement(value);
    	service.decrement(value);
    }
}
