package cc.ifnot.demo.dao;


import cc.ifnot.demo.bean.RoncooUser;
import cc.ifnot.demo.util.base.Page;

public interface RoncooUserDao {

	int insert(RoncooUser roncooUser);

	int deleteById(int id);

	int updateById(RoncooUser roncooUser);

	RoncooUser selectById(int id);

	Page<RoncooUser> queryForPage(int i, int j, String string);

}
