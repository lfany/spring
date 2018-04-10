package cc.ifnot.demo.bean

import java.util.Date

class RoncooUser {
    var id: Int = 0
    var name: String? = null
    var createTime: Date? = null

    override fun toString(): String {
        return "RoncooUser [id=$id, name=$name, createTime=$createTime]"
    }

}
