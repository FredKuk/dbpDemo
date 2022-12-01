# Fings Market
----
#### API Document
---

### Object -> (Customer, Good, gJoin, gReview, gComment)
**등록
POST
>/{my name}/{object}

**조회
GET
>/{my name}/{object}/{Id}

**변경
POST
>/{my name}/{object}/{Id}

**삭제
PUT
>/{my name}/{object}/{Id}

### 요건
1. stat
DB TABLE에 공통적으로 있는 컬럼인 stat으로 각 인스턴스의 상황 제어
0 - 무효
1 - 유효

2. 탈퇴 & 삭제
DB에서 stat 내용 변경.
실제로 DB에서 DELETE 하는 것이 아님