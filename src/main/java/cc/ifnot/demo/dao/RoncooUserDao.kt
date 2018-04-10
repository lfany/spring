package cc.ifnot.demo.dao


import cc.ifnot.demo.bean.RoncooUser
import cc.ifnot.demo.util.base.Page

interface RoncooUserDao {

    fun insert(roncooUser: RoncooUser): Int

    fun deleteById(id: Int): Int

    fun updateById(roncooUser: RoncooUser): Int

    fun selectById(id: Int): RoncooUser

    fun queryForPage(i: Int, j: Int, string: String): Page<Any>

}
