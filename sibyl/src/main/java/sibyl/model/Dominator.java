package sibyl.model;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sibyl.model.ExecutionMode;
import sibyl.model.Psychopass;

/**
 * Created by haljik on 14/12/27.
 */
@Component
public class Dominator {
    ExecutionMode mode = ExecutionMode.None;

    public Psychopass aime(String target) {
        RestTemplate restTemplate = new RestTemplate();
        Psychopass psychopass = restTemplate.getForObject("http://" + target + "/metrics", Psychopass.class);
        mode = psychopass.mode();
        return psychopass;
    }


    public boolean isExecutable() {
        return mode.isExecutable();
    }

    public void execute(String target) {
        aime(target);
        mode.execute(target);
    }

    public String getMessage() {
        return mode.getMessage();
    }
}
