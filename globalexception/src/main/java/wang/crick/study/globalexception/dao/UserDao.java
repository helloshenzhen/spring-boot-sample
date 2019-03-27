package wang.crick.study.globalexception.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wang.crick.study.globalexception.common.ResultCode;
import wang.crick.study.globalexception.exception.BusinessException;
import wang.crick.study.globalexception.exception.UserException;

/**
 * @Author easyhuang
 * @Date 19-3-24 下午5:13
 * @Version 1.0
 **/
@Component
public class UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    //dao层只抛出异常，不捕获异常
    public String getUsernameByIdDao(Long id){
        if (0 == id % 3){
//            return "right2";
//            throw new IllegalArgumentException("error param!");
//            throw new IllegalArgumentException("jkl diudiudiu error param! hahahaha");
            throw new BusinessException(ResultCode.ABNORMAL_OPERATING_DATABASE.getCode(),"jkl diudiudiu error param! hahahaha");
        }else if ( 1 == id % 3){
//            throw new UserException("custom exception!");
//            return "right1";
            throw new BusinessException(ResultCode.INVALID_ARGUMENT.getCode(),"dong dong dong exception");
        } else {
            return "you are good!";
        }
    }
}
