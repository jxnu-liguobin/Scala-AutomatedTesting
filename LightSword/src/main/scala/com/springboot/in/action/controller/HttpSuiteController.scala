package com.springboot.in.action.controller

import com.springboot.in.action.dao.HttpSuiteDao
import com.springboot.in.action.entity.HttpSuite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{ RequestMapping, RequestMethod, RequestParam, ResponseBody, RestController }
// java-scala conversion
import scala.collection.JavaConversions._

import org.springframework.web.servlet.ModelAndView

/**
 * 用例集控制层
 *
 * 可以理解为项目
 */
@RestController
@RequestMapping(Array("/httpsuite")) //动态注入用例集dao
class HttpSuiteController @Autowired() (val HttpSuiteDao: HttpSuiteDao) {

    //分页查询用例集
    @RequestMapping(value = { Array("", "/") })
    def list(model: Model) = {
        val HttpSuites = HttpSuiteDao.findAll
        model.addAttribute("HttpSuites", HttpSuites)
        new ModelAndView("/httpsuite/list")
    }

    //打开新增用例集页面
    @RequestMapping(Array("/newPage"))
    def goNewPage() = {
        new ModelAndView("/httpsuite/new")
    }

    //提交新增用例集的请求
    @RequestMapping(value  = Array("/postnew"), method = Array(RequestMethod.POST))
    @ResponseBody
    def newOne(@RequestParam(value = "name") name: String) = {
        val p = new HttpSuite
        p.name = name
        HttpSuiteDao.save(p)
    }

    //删除用例集
    @RequestMapping(value  = { Array("/delete") }, method = Array(RequestMethod.GET))
    @ResponseBody
    def delHttpApiById(@RequestParam(value = "id") httpSuiteId: Integer): Boolean = {
        val re = HttpSuiteDao.deleteById(httpSuiteId)
        if (re != 0) {
            return true
        } else {
            return false
        }
    }

}