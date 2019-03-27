package wang.crick.study.globalexception.aop;

import org.springframework.web.bind.annotation.*;
import wang.crick.study.globalexception.directory.ErrorCode;
import wang.crick.study.globalexception.exception.BusinessException;
import wang.crick.study.globalexception.exception.CustomException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
@ResponseBody
//@RestControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> getErrorObject(int code, String message) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", code);
        error.put("message", message);
        error.put("result","fail");
        return error;
    }


/*    @ExceptionHandler(Exception.class)
    public Object exceptionHandler() {
        return getErrorObject(ErrorCode.Error.getCode(), ErrorCode.Error.getMessage());
    }*/

    @ExceptionHandler(CustomException.class)
    public Object customException(CustomException e) {
        return getErrorObject(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object exceptionHandlerTwo(Exception e){
        return getErrorObject(500,e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Object exceptionHandlerThree(BusinessException e){
        return getErrorObject(e.getCode(),e.getMessage());
    }
}
