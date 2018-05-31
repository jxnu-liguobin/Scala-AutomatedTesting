package com.springboot.in.action.dao

import java.util.List

import com.springboot.in.action.entity.HttpReport
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * 测试报告dao特质
 */
trait HttpReportDao extends CrudRepository[HttpReport, Integer] {

    //查询所有测试报告列表
    @Query(value       = "select * from `http_report`", nativeQuery = true)
    def findAll(): List[HttpReport] // JavaConversions

    //新增一个测试报告
    def save(t: HttpReport): HttpReport

    // 根据id查询测试报告
    def findOne(id: Integer): HttpReport

}
