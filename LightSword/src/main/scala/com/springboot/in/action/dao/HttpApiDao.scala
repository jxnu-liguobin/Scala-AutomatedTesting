package com.springboot.in.action.dao

import java.util.List

import com.springboot.in.action.entity.HttpApi
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import scala.language.implicitConversions
import org.springframework.data.jpa.repository.Modifying
import javax.transaction.Transaction
import org.springframework.transaction.annotation.Transactional

/**
 * 用例dao特质
 *
 * 特质 类似接口，可以多继承，多个用with隔开，允许有实现的方法，且默认抽象，又像Java抽象类
 */
trait HttpApiDao extends CrudRepository[HttpApi, Integer] {

    //查询所有用例
    def findAll(): List[HttpApi] // JavaConversions

    //添加用例
    def save(t: HttpApi): HttpApi

    //根据id查询用例
    def findOne(id: Integer): HttpApi

    @Query(value       = "SELECT * FROM http_api where http_suite_id = ?1", nativeQuery = true)
    def listByHttpSuiteId(id: Integer): List[HttpApi]

    // 根据用例集id,查询用例api列表
    @Query(value       = "SELECT id FROM http_api where http_suite_id = ?1", nativeQuery = true)
    def listTestCaseId(httpSuiteId: Integer): List[Integer] // 隐式转换,直接用scala的List会报错:javax.persistence.NonUniqueResultException: result returns more than one elements] with root cause

    //根据用例名查询用例
    @Query(value       = "SELECT * FROM http_api where name like %?1% ", nativeQuery = true) // like '%?%'
    def findByName(name: String): List[HttpApi]

    //用例集中，成功的用例数目
    @Query(value       = "select count(*) from http_api where http_suite_id = ?1 and state = 1", nativeQuery = true)
    def countPass(httpSuiteId: Integer): Int

    //用例集中，失败的用例数目
    @Query(value       = "select count(*) from http_api where http_suite_id = ?1 and state = 0", nativeQuery = true)
    def countFail(httpSuiteId: Integer): Int

    // 根据id,删除用例,使用原生的sql语句查询
    @Query(value       = "delete from http_api where id = ?1 ", nativeQuery = true)
    @Modifying
    @Transactional
    def deleteById(httpApiId: Integer): Int

}