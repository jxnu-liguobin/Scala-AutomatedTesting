package com.springboot.in.action.dao

import java.util.List

import com.springboot.in.action.entity.HttpSuite
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.Query

/**
 * 用例集特质
 */
trait HttpSuiteDao extends CrudRepository[HttpSuite, Integer] {

    //查询所有用例集
    def findAll(): List[HttpSuite] // JavaConversions

    //新增用例集
    def save(t: HttpSuite): HttpSuite

    //根据id查询用例集
    def findOne(id: Integer): HttpSuite

    // 根据id,删除用例集,使用原生的sql语句查询
    @Query(value       = "delete from http_suite where id = ?1 ", nativeQuery = true)
    @Modifying
    @Transactional
    def deleteById(httpApiId: Integer): Int

}