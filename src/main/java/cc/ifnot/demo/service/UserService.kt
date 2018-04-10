package cc.ifnot.demo.service

import java.util.Date

import cc.ifnot.demo.bean.RoncooUser
import cc.ifnot.demo.bean.RoncooUserLog
import cc.ifnot.demo.dao.RoncooUserDao
import cc.ifnot.demo.dao.RoncooUserLogDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

    @Autowired
    private val roncooUserDao: RoncooUserDao? = null

    @Autowired
    private val roncooUserLogDao: RoncooUserLogDao? = null

    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    fun register(name: String, ip: String): String {
        // 1.添加用户
        val roncooUser = RoncooUser()
        roncooUser.name = name
        roncooUser.createTime = Date()
        roncooUserDao!!.insert(roncooUser)

        // 测试使用
        //boolean flag = true;
        //if (flag) {
        //	throw new RuntimeException();
        //}

        // 2.添加注册日志
        val roncooUserLog = RoncooUserLog()
        roncooUserLog.userName = name
        roncooUserLog.userIp = ip
        roncooUserLog.createTime = Date()
        roncooUserLogDao!!.save(roncooUserLog)

        return "success"
    }

}
