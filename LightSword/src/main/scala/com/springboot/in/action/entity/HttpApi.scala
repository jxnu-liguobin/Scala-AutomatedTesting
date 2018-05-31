package com.springboot.in.action.entity

import java.util.Date
import javax.persistence.{ Entity, GeneratedValue, GenerationType, Id }
import scala.language.implicitConversions
import scala.beans.BeanProperty

/**
 * 用例实体
 */
@Entity
class HttpApi {
    
    //JPA自增长主键
    // @BeanProperty JSON对应属性名
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @BeanProperty
    var id: Integer = _

    @BeanProperty
    var httpSuiteId: Integer = _
    //用例名称
    @BeanProperty
    var name: String = _

    //用例状态: -1未执行 0失败 1成功
    @BeanProperty
    var state: Integer = _
    //接口
    @BeanProperty
    var url: String = _

    //方法GET,POST
    @BeanProperty
    var method: String = _

    //post参数json string
    @BeanProperty
    var paramJsonStr: String = _

    //期望输出
    @BeanProperty
    var expectOutput: String = _

    //实际输出
    @BeanProperty
    var actualOutput: String = _

    //运行次数
    @BeanProperty
    var runTimes: Integer = _
    //创建人
    @BeanProperty
    var owner: String = _
    @BeanProperty
    var gmtCreate: Date = _
    @BeanProperty
    var gmtModify: Date = _

}