package wang.crick.study.globalexception.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author easyhuang
 * @Date 19-3-27 下午1:59
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@ToString
public class BusinessException extends RuntimeException{

     private static final long serialVersionUID = 8882366904034518527L;

     private Integer code;

     private String message;

    public BusinessException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BusinessException(Integer code) {
        super();
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, Integer code) {
        super(cause);
        this.code = code;
        this.message = message;
    }

}
