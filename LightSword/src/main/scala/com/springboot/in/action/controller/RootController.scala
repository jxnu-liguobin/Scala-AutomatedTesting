package com.springboot.in.action.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ RequestMapping, RequestMethod }
import org.springframework.web.servlet.ModelAndView

/**
 * 主控制器
 */
@Controller
class RootController {

    @RequestMapping(value  = { Array("/about") }, method = Array(RequestMethod.GET))
    def about() = new ModelAndView("/about")

    @RequestMapping(value  = { Array("", "/") }, method = Array(RequestMethod.GET))
    def index() = new ModelAndView("/home")

}
