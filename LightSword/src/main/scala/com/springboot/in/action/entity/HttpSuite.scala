package com.springboot.in.action.entity

import java.util.Date
import javax.persistence.{ Entity, GeneratedValue, GenerationType, Id }
import scala.language.implicitConversions
import scala.beans.BeanProperty

/**
 * 用例集实体类
 *
 * 项目
 */
@Entity
class HttpSuite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @BeanProperty
    var id: Integer = _

    @BeanProperty
    var name: String = _

}