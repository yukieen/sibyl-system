package sibyl.datasource;

import org.springframework.stereotype.Component;
import sibyl.model.PsychoPass;

import javax.xml.transform.Result;

/**
 * Created by haljik on 14/12/27.
 */
@Component
public class Dominator {
    ExecutionMode mode = ExecutionMode.None;

    public PsychoPass aime(String target) {
        PsychoPass psychoPass = new PsychoPass();
        return psychoPass;
    }

    public boolean isExecutable() {
        return mode.isExecutable();
    }

    public void execute(String target) {
        mode.execute(target);
    }

    public String getMessage() {
        return mode.getMessage();
    }
}
