package wang.crick.study.globalexception.common;

/**
 * @Author easyhuang
 * @Date 19-3-27 下午3:24
 * @Version 1.0
 **/


public class FailResponse extends AbstractResponse {

    private String result = "fail";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
