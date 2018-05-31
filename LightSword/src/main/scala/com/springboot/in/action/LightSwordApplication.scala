package com.springboot.in.action

import org.springframework.boot.SpringApplication

/**
 * scala单利对象，启动
 *
 * App自带main方法
 */
object LightSwordApplication extends App {
    
    //classof相当于getClass/.class
    SpringApplication.run(classOf[AppConfig])
}