package cc.ifnot.demo.util.listerner

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

/**
 * 自定义listener
 *
 * @author wujing
 */
@WebListener
class CustomListener : ServletContextListener {

    override fun contextInitialized(sce: ServletContextEvent) {
        println("contextInitialized")
    }

    override fun contextDestroyed(sce: ServletContextEvent) {
        println("contextDestroyed")
    }

}
