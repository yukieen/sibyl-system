package sibyl.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.web.client.RestTemplate;

/**
 * Created by haljik on 14/12/27.
 */
public enum ExecutionMode {
    None("執行対象ではありません。トリガーをロックします") {
        @Override
        public void execute(String target) {
            return;
        }
    },
    Paralizer("執行モード、ノンリーサル・パラライザー。落ち着いて照準を定め対象を制圧してください。"){
        @Override
        public void execute(String target) {
            RestTemplate template = new RestTemplate();
            template.postForLocation("http://" + target + "/paralize", null);
        }
    },
    Eliminator("執行モード、リーサル・エリミネーター。慎重に照準を定め対象を排除してください") {
        @Override
        public void execute(String target) {
            RestTemplate template = new RestTemplate();
            template.postForLocation("http://" + target + "/shutdown", null);
        }
    },
    Decomposer("執行モード、デストロイ・デコンポーザー。対象を完全排除します。ご注意ください") {
        @Override
        public void execute(String target) {
            RestTemplate template = new RestTemplate();
            template.postForLocation("http://" + target + "/shutdown", null);
        }
    };

    String message;
    private ExecutionMode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public abstract void execute(String target);

    public boolean isExecutable() {
        return this != None;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}