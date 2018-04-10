package cc.ifnot.demo.util.filter

import java.io.IOException

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter

/**
 * 自定义filter
 *
 * @author wujing
 */
@WebFilter(urlPatterns = arrayOf("/*"))
class CustomFilter : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {
        println("init filter")
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        println("do filter")
        chain.doFilter(request, response)
    }

    override fun destroy() {
        println("destroy filter")
    }

}
