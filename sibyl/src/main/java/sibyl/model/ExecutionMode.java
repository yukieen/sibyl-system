package sibyl.model;

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

        }
    },
    Eliminator("執行モード、リーサル・エリミネーター。慎重に照準を定め対象を排除してください") {
        @Override
        public void execute(String target) {

        }
    },
    Decomposer("執行モード、デストロイ・デコンポーザー。対象を完全排除します。ご注意ください") {
        @Override
        public void execute(String target) {

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
}