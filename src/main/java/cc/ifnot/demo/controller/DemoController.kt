package cc.ifnot.demo.controller

import cc.ifnot.demo.bean.Base
import cc.ifnot.demo.bean.Demo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.Date
import java.util.HashMap

@RestController
@RequestMapping("/demo")
class DemoController {

    @Value(value = "\${ifnot.secret}")
    private val secret: String? = null

    @Value(value = "\${ifnot.number}")
    private val id: Int = 0

    @Value(value = "\${ifnot.desc}")
    private val desc: String? = null

    @RequestMapping
    fun all(): Base {
        logger.debug("debug: logger test")
        logger.info("info: logger test")
        return Base()
    }

    // @RequestParam 简单类型的绑定，可以出来get和post
    @RequestMapping("/get")
    operator fun get(@RequestParam(value = "name", defaultValue = "aa") name: String): HashMap<String, Any?> {
        val hashMap = HashMap<String, Any?>()
        hashMap["title"] = "hello world!"
        hashMap["name"] = name
        hashMap["secret"] = secret
        hashMap["id"] = id
        hashMap["desc"] = desc
        return hashMap
    }

    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/get/{id}/{name}")
    fun getDemo(@PathVariable(value = "id", required = false) id: Int, @PathVariable(value = "name", required = false) name: String): Demo {
        val demo = Demo()
        demo.id = id
        demo.name = name
        demo.date = Date()
        return demo
    }

    companion object {

        private val logger = LoggerFactory.getLogger(DemoController::class.java)
    }

}
