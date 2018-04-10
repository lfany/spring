package cc.ifnot.demo.controller

import org.springframework.web.bind.annotation.*

import java.util.HashMap

@RestController
@RequestMapping("/api")
class ApiController {

    @CrossOrigin(origins = arrayOf("http://localhost:8080"))
    @RequestMapping(value = "/get", method = arrayOf(RequestMethod.POST))
    operator fun get(@RequestParam name: String): HashMap<String, Any> {
        val map = HashMap<String, Any>()
        map["title"] = "hello world"
        map["name"] = name
        return map
    }
}
