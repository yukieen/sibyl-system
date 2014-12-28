package sibyl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sibyl.model.Dominator;
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
    public Psychopass psychopass() {
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
        Psychopass psychoPass = dominator.aim(target);
        model.addAttribute("psychopass",psychoPass);
        model.addAttribute("target", target);
        return "dominator";
    }

    @RequestMapping("/execute")
    public String execute(@RequestParam("target") String target,
                       @ModelAttribute Dominator dominator,
                       Model model) {
        Psychopass psychoPass = dominator.aim(target);
        dominator.execute(target);
        model.addAttribute("psychopass", psychoPass);
        model.addAttribute("target", target);
        return "dominator";
    }


}
