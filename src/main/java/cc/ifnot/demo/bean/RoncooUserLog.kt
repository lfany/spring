package cc.ifnot.demo.bean

import java.util.Date

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class RoncooUserLog {

    @Id
    @GeneratedValue
    var id: Int? = null

    @Column
    var createTime: Date? = null

    @Column
    var userName: String? = null

    @Column
    var userIp: String? = null

    override fun toString(): String {
        return "RoncooUserLog [id=$id, createTime=$createTime, userName=$userName, userIp=$userIp]"
    }

}
