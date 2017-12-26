package cc.ifnot.demo.service;

import java.util.Date;

import cc.ifnot.demo.bean.RoncooUser;
import cc.ifnot.demo.bean.RoncooUserLog;
import cc.ifnot.demo.dao.RoncooUserDao;
import cc.ifnot.demo.dao.RoncooUserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private RoncooUserDao roncooUserDao;

    @Autowired
    private RoncooUserLogDao roncooUserLogDao;

    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    public String register(String name, String ip) {
        // 1.添加用户
        RoncooUser roncooUser = new RoncooUser();
        roncooUser.setName(name);
        roncooUser.setCreateTime(new Date());
        roncooUserDao.insert(roncooUser);

        // 测试使用
        //boolean flag = true;
        //if (flag) {
        //	throw new RuntimeException();
        //}

        // 2.添加注册日志
        RoncooUserLog roncooUserLog = new RoncooUserLog();
        roncooUserLog.setUserName(name);
        roncooUserLog.setUserIp(ip);
        roncooUserLog.setCreateTime(new Date());
        roncooUserLogDao.save(roncooUserLog);

        return "success";
    }

}
