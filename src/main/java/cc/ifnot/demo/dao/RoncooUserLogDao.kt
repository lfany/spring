package cc.ifnot.demo.dao


import cc.ifnot.demo.bean.RoncooUserLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RoncooUserLogDao : JpaRepository<RoncooUserLog, Int> {

    @Query(value = "select u from RoncooUserLog u where u.userName=?1")
    fun findByUserName(string: String): RoncooUserLog

    fun findByUserNameAndUserIp(string: String, ip: String): RoncooUserLog

    fun findByUserName(string: String, pageable: Pageable): Page<RoncooUserLog>
}
