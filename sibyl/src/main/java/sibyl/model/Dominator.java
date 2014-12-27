package sibyl.model;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by haljik on 14/12/27.
 */
@Component
public class Dominator {
    ExecutionMode mode = ExecutionMode.None;

    public Psychopass aime(String target) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Psychopass psychopass = restTemplate.getForObject("http://" + target + "/metrics", Psychopass.class);
            mode = psychopass.mode();
            return psychopass;
        } catch(Exception e) {
            mode = ExecutionMode.None;
            return new Psychopass();
        }
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
