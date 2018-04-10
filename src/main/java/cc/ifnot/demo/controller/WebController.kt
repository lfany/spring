package cc.ifnot.demo.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@EnableAutoConfiguration
@RequestMapping("/web")
class WebController {

    private val logger = LoggerFactory.getLogger(WebController::class.java)

    @RequestMapping(value = "upload", method = arrayOf(RequestMethod.GET))
    fun upload(map: ModelMap): String {
        logger.info("Web: file upload page")
        map["title"] = "文件上传"
        map["fileName"] = "xxx"
        return "file/upload"
    }

    @RequestMapping("freemarker")
    fun freemarker(map: ModelMap): String {
        logger.info("info: web controller freemarker")
        map["title"] = "freemarker!"
        return "freemarker/index"
    }

    @RequestMapping("thymeleaf")
    fun thymeleaf(map: ModelMap): String {
        logger.info("info: web controller thymeleaf")
        map["title"] = "thymeleaf!"
        return "thymeleaf/index"
    }

    @RequestMapping("exception")
    @Throws(Exception::class)
    fun exception(map: ModelMap): String {
        throw Exception("测试异常")
    }

    @RequestMapping("runtimeexception")
    fun runtimeexception(map: ModelMap): String {
        throw RuntimeException("测试异常")
    }

}
