package com.springboot.in.action.controller

import java.util
import java.util.Date

import org.springframework.web.bind.annotation.{ RequestMapping, RestController }
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.stereotype.Controller

/**
 * 测试
 */

@Controller
@RequestMapping(Array("/hello"))
class HelloController {

    @ResponseBody
    @RequestMapping(Array("", "/"))
    def greeting() = {
        val now = new Date
        val content = "你好!现在是北京时间 : " + now
        val json = new util.HashMap[String, String]
        json.put("content", content)
        json
    }

}
