/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package cc.ifnot.demo.util.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.util.Assert

/**
 * spirng jdbc 基本支撑类
 *
 * @author wujing
 */
abstract class JdbcDaoImpl {

    @Autowired
    protected var jdbcTemplate: JdbcTemplate? = null

    /**
     * 获取当前事务最后一次更新的主键值
     */
    val lastId: Long?
        get() = jdbcTemplate!!.queryForObject("select last_insert_id() as id", Long::class.java)

    /**
     * 获取对象信息
     */
    fun <T> queryForObject(sql: String, clazz: Class<T>, vararg args: Any): T {
        Assert.hasText(sql, "sql 语句不能为空")
        return jdbcTemplate!!.queryForObject(sql, BeanPropertyRowMapper(clazz), *args)
    }

    /**
     * 获取对象集合信息
     */
    fun <T> queryForObjectList(sql: String, clazz: Class<T>, vararg args: Any): List<T> {
        Assert.hasText(sql, "sql 语句不能为空")
        return jdbcTemplate!!.query(sql, args, BeanPropertyRowMapper(clazz))
    }

    /**
     * 分页，jdbcTemplate 不支持like自定义，只能拼装
     */
    fun queryForPage(sql: String, pageCurrent: Int, pageSize: Int, vararg args: Any): Page<Any> {
        var pageCurrent = pageCurrent
        var pageSize = pageSize
        Assert.hasText(sql, "sql 语句不能为空")
        Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1")
        val sqlCount = Sql.countSql(sql)
        val count = jdbcTemplate!!.queryForObject(sqlCount, Int::class.java, *args)
        pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent)
        pageSize = Sql.checkPageSize(pageSize)
        val totalPage = Sql.countTotalPage(count, pageSize)
        val sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize)
        val list = jdbcTemplate!!.queryForList(sqlList, *args)
        return Page(count, totalPage, pageCurrent, pageSize, list)
    }

    /**
     * 分页，jdbcTemplate 不支持like是定义，只能拼装
     */
    fun <T> queryForPage(sql: String, pageCurrent: Int, pageSize: Int, clazz: Class<T>?, vararg args: Any): Page<T> {
        var pageCurrent = pageCurrent
        var pageSize = pageSize
        Assert.hasText(sql, "sql 语句不能为空")
        Assert.isTrue(pageCurrent >= 1, "pageNo 必须大于等于1")
        Assert.isTrue(clazz != null, "clazz 不能为空")
        val sqlCount = Sql.countSql(sql)
        val count = jdbcTemplate!!.queryForObject(sqlCount, Int::class.java, *args)
        pageCurrent = Sql.checkPageCurrent(count, pageSize, pageCurrent)
        pageSize = Sql.checkPageSize(pageSize)
        val totalPage = Sql.countTotalPage(count, pageSize)
        val sqlList = sql + Sql.limitSql(count, pageCurrent, pageSize)
        val list = jdbcTemplate!!.query(sqlList, BeanPropertyRowMapper(clazz!!), *args)
        return Page(count, totalPage, pageCurrent, pageSize, list)
    }

}
