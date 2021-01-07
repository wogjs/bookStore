# SpringBoot, JPA, Mybatis, Mustache를 이용한 온라인 서점 개발 :kr:
SpringBoot, JPA 개인공부용 Toy Project [![Build Status](https://travis-ci.org/wogjs/bookstore.svg?branch=master)](https://travis-ci.org/wogjs/bookstore)

## 프로젝트 
Spring과 AWS를 이용해서 온라인 서점 배포를 목적으로 개발시작

Springboot, JPA, MyBatis, Mustache를 이용한 온라인 서점 개발

전반적인 쿼리기능은 JPA로 구현하였으나 특정 쿼리의 경우 MyBatis를 이용하여 구현

배포 환경은 AWS의 EC2의 Linux 2 AMI를 이용

CI는 Travis CI를 이용하였으며 AWS의 S3와 CodeDeploy를 사용

CD의 경우 Nginx를 사용

서점 주소 : http://bookstore.jaeheon.xyz/

## 사용기술 :sunny:
* SpringFramework
    + Spring Boot 2.3.4
    + Gradle 6.6.1
* 뷰
    + Mustache
    + JavaScript
* 데이터베이스
    + Mysql
* ORM Framework
    + JPA
* Persistence Framework
    + MyBatis
* 암호화
    + Spring security
* AWS 클라우드
    + EC2
    + RDS
    + S3
    + CodeDeploy
    + Route53
* CI / CD
    + Trvis CI
    + Nginx
