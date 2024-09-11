package org.zerock.b2;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//
//CREATE DATABASE malldb;
//
//CREATE USER 'malldbuser'@'localhost' IDENTIFIED BY 'malldbuser';
//CREATE USER 'malldbuser'@'%' IDENTIFIED BY 'malldbuser';
//
//GRANT ALL PRIVILEGES ON malldb.* TO 'malldbuser'@'localhost';
//
//GRANT ALL PRIVILEGES ON malldb.* TO 'malldbuser'@'%';

//mariadb -u root -pzerock


@SpringBootApplication
@MapperScan(basePackages = {"org.zerock.b2.**.mapper"})
@EnableAspectJAutoProxy
public class B2Application {

    public static void main(String[] args) {
        SpringApplication.run(B2Application.class, args);
    }

}
