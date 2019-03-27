package wang.crick.study.globalexception.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.crick.study.globalexception.common.AbstractResponse;
import wang.crick.study.globalexception.common.ResponseInfo;
import wang.crick.study.globalexception.exception.BusinessException;
import wang.crick.study.globalexception.service.UserService;

@RestController
@RequestMapping("/user")
public class UserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public AbstractResponse getInfo(@PathVariable("id") int id) {
        //controller层一定要捕获并且处理异常
/*        ResponseInfo info = new ResponseInfo();
        try {
            info.setData(userService.getUsernameById(id));
            return info;
        } catch (BusinessException e) {
            info.setMessage(e.getMessage());
            info.setCode(e.getCode());
            info.setResult("fail");
            return info;
        }*/
//        controller层一定要捕获并且处理异常
//        这里是采用了同意处理异常的方式进行处理
        ResponseInfo info = new ResponseInfo();
        info.setData(userService.getUsernameById(id));
/*        if (null != userService.getUsernameById(id)){
            throw new BusinessException(500,"bad system!!!");
        }*/
        return info;


//        try {
        //return userService.getUsernameById(id);
//        } catch (Exception e) {
//            LOGGER.error(" UserApi getInfo error : [{}],the id : [{}]",e,id);
//            LOGGER.error(" UserApi getInfo error : [{}],the id : [{}]",e.getMessage(),id);
//            e.printStackTrace();
////            throw new RuntimeException(e);
//        }
//        return " UserApi occer error!!!";
    }

    @GetMapping("/info/{id}")
    public Object getInfo2(@PathVariable("id") int id) {
            return userService.getUsernameById(id);
    }
}
