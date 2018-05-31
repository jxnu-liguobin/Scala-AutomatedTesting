package com.springboot.in.action.controller

import java.util

import com.alibaba.fastjson.serializer.SerializerFeature
import com.springboot.in.action.dao.HttpReportDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{ RequestMapping, RestController }
import org.springframework.web.servlet.ModelAndView

import scala.collection.JavaConversions._
import java.util.Arrays
import java.util.ArrayList
import com.springboot.in.action.entity.HttpReport

/**
 * 用例报告控制层
 */
@RestController
@RequestMapping(Array("/httpreport")) //构造注入用例报告dao
class HttpReportController @Autowired() (val HttpReportDao: HttpReportDao) {

    //分页查询用例报告
    @RequestMapping(value = { Array("", "/") })
    def list(model: Model) = {

        val reports = HttpReportDao.findAll
        model.addAttribute("reports", reports)
        val rateList = new util.ArrayList[Double]
        val trendList = new util.ArrayList[Object]
        val list = new ArrayList[HttpReport](reports.length);
        for (r <- reports) {
            rateList.add(r.rate) //通过率列表
            val qt = new util.HashMap[String, Any]
            qt.put("id", r.id)
            qt.put("failed", r.fail)
            qt.put("totalCases", r.pass + r.fail)
            qt.put("rate", r.rate)
            trendList.add(qt) //用例报告详情列表
        }

        val jsonstr = com.alibaba.fastjson.JSON.toJSONString(trendList, SerializerFeature.BrowserCompatible)
        println("用例测试报告：" + jsonstr)
        model.addAttribute("rateList", rateList) //前台通过率图
        model.addAttribute("trendList", jsonstr) //前台质量趋势图
        new ModelAndView("/httpreport/list")
    }

}
