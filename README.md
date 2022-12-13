# Fings Market
----
#### API Document
---

JDBC(Java DataBase Connectivity)
JDBC는 자바 프로그램이 DBMS에 일관된 방식으로 접근할 수 있도록 API를 제공하는 자바 클래스

JPA(Java Persisitence API)
자바 진영의 ORM 기술 표준.객체와 테이블을 매핑해서 패러다임의 불일치를 개발자 대신 해결해 줌

R2DBC(Reactive Relational Database Connectivity)
논블러킹 방식으로 데이터베이스를 처리하기 위함

HikariCP란?
Springboot 2.0 부터 default로 설정되어 있으며 Zero-Overhead가 특징으로 높은 성능을 자랑하는 DB Connection Pool

Reactive Programing
적은 양의 스레드와 최소한의 하드웨어 자원으로 동시성을 핸들링하기 위해 만들어짐(Async, Non-Blocking)

Webflux
Reative 구현체 중 하나

GraphQL
그래프QL은 REST 및 부속 웹서비스 아키텍처를 대체 가능함
클라이언트는 필요한 데이터의 구조를 지정할 수 있으며, 서버는 정확히 동일한 구조로 데이터를 반환


### Object -> (Customer, Good, gJoin, gReview, gComment)
**등록
POST
>/{my name}/{object}

**조회
GET
>/{my name}/{object}/{Id}

**변경
PUT
>/{my name}/{object}/{Id}

**삭제
PATCH
>/{my name}/{object}/{Id}

### 요건
1. stat

>>DB TABLE에 공통적으로 있는 컬럼인 stat으로 각 인스턴스의 상황 제어
>>>0 - 무효
>>>1 - 유효

2. 탈퇴 & 삭제

>>DB에서 stat 내용 변경.
>>실제로 DB에서 DELETE 하는 것이 아님