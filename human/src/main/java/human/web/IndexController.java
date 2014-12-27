package human.web;

import human.model.PsychoPass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by haljik on 14/12/27.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("psychoPass", new PsychoPass());
        return "hoge";
    }
}
