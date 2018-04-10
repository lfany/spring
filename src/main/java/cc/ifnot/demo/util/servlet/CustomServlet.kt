package cc.ifnot.demo.util.servlet

import java.io.IOException

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 自定义servlet
 *
 * @author wujing
 */
@WebServlet(urlPatterns = arrayOf("/ifnot"), name = "customServlet")
class CustomServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        println("servlet get method")
        doPost(request, response)
    }

    @Throws(ServletException::class, IOException::class)
    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        println("servlet post method")
        response.writer.write("hello world")
    }

    companion object {

        /**
         *
         */
        private val serialVersionUID = 1L
    }

}
