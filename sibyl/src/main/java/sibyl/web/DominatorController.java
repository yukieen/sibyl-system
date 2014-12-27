package sibyl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sibyl.datasource.Dominator;
import sibyl.model.Psychopass;

/**
 * Created by haljik on 14/12/27.
 */
@Controller
@RequestMapping("/dominator")
public class DominatorController {

    @ModelAttribute
    public Dominator dominator() {
        return new Dominator();
    }

    @ModelAttribute
    public Psychopass psychoPass() {
        return new Psychopass();
    }

    @ModelAttribute("target")
    public String target() {
        return "localhost:32615";
    }

    @RequestMapping
    public String startUp() {
        return "dominator";
    }

    @RequestMapping("/aime")
    public String aime(@RequestParam("target") String target,
                       @ModelAttribute Dominator dominator,Model model) {
        Psychopass psychoPass = dominator.aime(target);
        model.addAttribute("psychoPass",psychoPass);
        model.addAttribute("target", target);
        return "dominator";
    }

    @RequestMapping("/execute/{target}")
    public String execute(@PathVariable("target") String target,
                       @ModelAttribute Dominator dominator,Model model) {
        dominator.execute(target);
        model.addAttribute("target", target);
        return "dominator";
    }


}
