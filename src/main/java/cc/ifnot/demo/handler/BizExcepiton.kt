package cc.ifnot.demo.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView

@ControllerAdvice
class BizExcepiton {

    /**
     * 统一的异常处理
     */

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.OK)
    fun processException(exception: RuntimeException): ModelAndView {
        logger.info("info: 自定义异常处理- RuntimeException")
        val m = ModelAndView()
        m.addObject("ifnotException", exception.message)
        m.viewName = "error/500"
        exception.printStackTrace()
        return m
    }

    /**
     * 统一的异常处理
     */

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.OK)
    fun processException(exception: Exception): ModelAndView {
        logger.info("info: 自定义异常处理- Exception")
        val m = ModelAndView()
        m.addObject("ifnotException", exception.message)
        m.viewName = "error/500"
        exception.printStackTrace()
        return m
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BizExcepiton::class.java)
    }

}
