package cc.ifnot.demo.dao.impl

import cc.ifnot.demo.bean.RoncooUser
import cc.ifnot.demo.util.base.JdbcDaoImpl
import cc.ifnot.demo.util.base.Page
import cc.ifnot.demo.util.base.Sql
import org.springframework.stereotype.Repository

import com.mysql.jdbc.StringUtils
import cc.ifnot.demo.dao.RoncooUserDao

@Repository
class RoncooUserDaoImpl : JdbcDaoImpl(), RoncooUserDao {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    override fun insert(roncooUser: RoncooUser): Int {
        val sql = "insert into roncoo_user (name, create_time) values (?, ?)"
        return jdbcTemplate!!.update(sql, roncooUser.name, roncooUser.createTime)
    }

    override fun deleteById(id: Int): Int {
        val sql = "delete from roncoo_user where id=?"
        return jdbcTemplate!!.update(sql, id)
    }

    override fun updateById(roncooUser: RoncooUser): Int {
        val sql = "update roncoo_user set name=?, create_time=? where id=?"
        return jdbcTemplate!!.update(sql, roncooUser.name, roncooUser.createTime, roncooUser.id)
    }

    override fun selectById(id: Int): RoncooUser {
        val sql = "select * from roncoo_user where id=?"
        /*return jdbcTemplate.queryForObject(sql, new RowMapper<RoncooUser>() {
			@Override
			public RoncooUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				RoncooUser roncooUser = new RoncooUser();
				roncooUser.setId(rs.getInt("id"));
				roncooUser.setName(rs.getString("name"));
				roncooUser.setCreateTime(rs.getDate("create_time"));
				return roncooUser;
			}
		}, id);*/

        return queryForObject(sql, RoncooUser::class.java, id)
    }

    override fun queryForPage(pageCurrent: Int, pageSize: Int, name: String): Page<Any> {
        // 确定参数
        /*String sql = "select * from roncoo_user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class, name);*/

        // 若name可能为空，则要进行判定，如下
        /*StringBuffer sql = new StringBuffer("select * from roncoo_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);*/

        // 若要like查询，如下
        val sql = StringBuffer("select * from roncoo_user where 1")
        if (!StringUtils.isNullOrEmpty(name)) {
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ")
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser::class.java)
    }


}
