package wang.crick.study.globalexception.common;

public class SuccessResponse extends AbstractResponse {

    private String result = "success";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
