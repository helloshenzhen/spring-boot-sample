package wang.crick.study.globalexception.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.crick.study.globalexception.dao.UserDao;
import wang.crick.study.globalexception.exception.BusinessException;
import wang.crick.study.globalexception.exception.UserException;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
/*    public String getUsernameById(long id) {
        try {
            if (0 == id % 2) {
                LOGGER.error(" getUsernameById occur error ,the id : [{}]",id);
                throw new IllegalArgumentException("error param!");
            } else {
                throw new UserException("custom exception!");
            }
        } catch (Exception e) {
            LOGGER.error(" getUsernameById occur error :[{}] ,the id : [{}]",e,id);
            e.printStackTrace();
        }
        return "test error";
    }*/

//service层捕获异常并且重新封装异常再抛出
    public String getUsernameById(long id) {
        try {
            return userDao.getUsernameByIdDao(id);
        } catch (BusinessException e) {
            LOGGER.error("the message is : [{}]",e.getMessage());
            e.printStackTrace();
            throw new BusinessException(e.getCode(),e.getMessage());
        }
//        return "service throw!";
    }
}
