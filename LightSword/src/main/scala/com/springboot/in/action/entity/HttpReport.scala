package com.springboot.in.action.entity

import java.util.Date
import javax.persistence.{ Entity, GeneratedValue, GenerationType, Id }

import scala.beans.BeanProperty
import scala.language.implicitConversions

/**
 * 用例测试报告实体类
 */
@Entity
class HttpReport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @BeanProperty
    var id: Integer = _

    @BeanProperty
    var httpSuiteId: Integer = _

    @BeanProperty
    var httpSuiteName: String = _

    @BeanProperty
    var pass: Integer = _

    @BeanProperty
    var fail: Integer = _

    //通过率 rate %
    var rate: Double = _

    //报告时间
    @BeanProperty
    var time: Date = _

}
