package wang.crick.study.globalexception.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author easyhuang
 * @Date 19-3-26 下午9:55
 * @Version 1.0
 **/

@NoArgsConstructor
@Data
@ToString
public class ResponseInfo extends SuccessResponse {

    private int code = 200;
    private String message= "操作成功";
    private Object data;
    private Status status = Status.SUCCESS;


    public enum Status{
        ERROR,
        SUCCESS,
        WARN
    }


    public ResponseInfo(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        if (200 != code){
            status = Status.ERROR;
        }
    }



    public ResponseInfo(Object data, String message, Status status) {
        this.data = data;
        this.message = message;
        this.status = status;
        if (status != Status.SUCCESS){
            code = 500;
        }
    }

    public void setCode(int code){
        this.code = code;
        if (200 != code){
            status = Status.ERROR;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
        if (!(Status.SUCCESS.toString().equals(status))){
            code = 500;
        }
    }

    public ResponseInfo addMessage(Status status, String message){
        this.status = status;
        this.message = message;
        return this;
    }
}
