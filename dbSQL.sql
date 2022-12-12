-- DB초기화
SET @tables = NULL;
SELECT GROUP_CONCAT(table_schema, '.', table_name) INTO @tables
  FROM information_schema.tables
  WHERE table_schema = 'JADEN'; -- specify DB name here.

SET @tables = CONCAT('DROP TABLE ', @tables);
PREPARE stmt FROM @tables;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- 고객
use JADEN;
CREATE TABLE customer (
	cusNo INTEGER NOT NULL, -- 고객번호,
	name VARCHAR(255) NOT NULL, -- 이름,
	id VARCHAR(255) NOT NULL, -- 아이디,
	pwd VARCHAR(255) NOT NULL, -- 비밀번호,
	startDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 가입날짜,
	changeDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 변경날짜,
	stat INTEGER NOT NULL -- 상태
);

-- 고객
ALTER TABLE customer
	ADD CONSTRAINT PK_customer -- 고객 Primary key
	PRIMARY KEY (
		cusNo -- 고객번호
	);

ALTER TABLE customer
	MODIFY COLUMN cusNo INTEGER NOT NULL AUTO_INCREMENT;

-- 상품
CREATE TABLE good (
	goodNo INTEGER NOT NULL, -- 상품번호,
	name VARCHAR(255) NOT NULL, -- 상품이름,
	type INTEGER NOT NULL, -- 상품종류,
	company VARCHAR(255) NOT NULL, -- 상품회사,
	startDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 출시날짜,
	changeDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 변경날짜,
	stat INTEGER NOT NULL -- 상태
);

-- 상품
ALTER TABLE good
	ADD CONSTRAINT PK_good -- 상품 Primary key
	PRIMARY KEY (
		goodNo -- 상품번호
	);

ALTER TABLE good
	MODIFY COLUMN goodNo INTEGER NOT NULL AUTO_INCREMENT;


-- 가입상품
CREATE TABLE gJoin (
	gJoinNo INTEGER NOT NULL, -- 가입상품번호,
	goodNo INTEGER NOT NULL, -- 상품번호,
	cusNo INTEGER NOT NULL, -- 고객번호,
	startDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 가입날짜,
	changeDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 변경날짜,
	stat INTEGER NOT NULL -- 상태
);

-- 가입상품
ALTER TABLE gJoin
	ADD CONSTRAINT PK_gJoin -- 가입상품 Primary key
	PRIMARY KEY (
		gJoinNo -- 가입상품번호
	);

ALTER TABLE gJoin
	MODIFY COLUMN gJoinNo INTEGER NOT NULL AUTO_INCREMENT;

-- 상품리뷰
CREATE TABLE gReview (
	gReviewNo INTEGER NOT NULL, -- 상품리뷰번호,
	goodNo INTEGER NOT NULL, -- 상품번호,
	cusNo INTEGER NOT NULL, -- 고객번호,
	subject VARCHAR(255) NOT NULL, -- 제목,
	contents VARCHAR(255) NOT NULL, -- 내용,
	startDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 작성날짜,
	changeDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 변경날짜,
	stat INTEGER NOT NULL -- 상태
);

-- 상품리뷰
ALTER TABLE gReview
	ADD CONSTRAINT PK_gReview -- 상품리뷰 Primary key
	PRIMARY KEY (
		gReviewNo -- 상품리뷰번호
	);

ALTER TABLE gReview
	MODIFY COLUMN gReviewNo INTEGER NOT NULL AUTO_INCREMENT;

-- 상품댓글
CREATE TABLE gComment (
	gCommentNo INTEGER NOT NULL, -- 상품댓글번호,
	gReviewNo INTEGER NOT NULL, -- 상품리뷰번호,
	cusId INTEGER NOT NULL, -- 고객번호,
	subject VARCHAR(255) NOT NULL, -- 제목,
	contents VARCHAR(255) NOT NULL, -- 내용,
	startDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 작성날짜,
	changeDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 변경날짜,
	stat INTEGER NOT NULL -- 상태
);

-- 상품댓글
ALTER TABLE gComment
	ADD CONSTRAINT PK_gComment -- 상품댓글 Primary key
	PRIMARY KEY (
		gCommentNo -- 상품댓글번호
	);

ALTER TABLE gComment
	MODIFY COLUMN gCommentNo INTEGER NOT NULL AUTO_INCREMENT;

-- 가입상품
ALTER TABLE gJoin
	ADD CONSTRAINT FK_good_TO_gJoin -- 상품 -> 가입상품
	FOREIGN KEY (
		goodNo -- 상품번호
	)
	REFERENCES good ( -- 상품
		goodNo -- 상품번호
	);

-- 가입상품
ALTER TABLE gJoin
	ADD CONSTRAINT FK_customer_TO_gJoin -- 고객 -> 가입상품
	FOREIGN KEY (
		cusNo -- 고객번호
	)
	REFERENCES customer ( -- 고객
		cusNo -- 고객번호
	);

-- 상품리뷰
ALTER TABLE gReview
	ADD CONSTRAINT FK_good_TO_gReview -- 상품 -> 상품리뷰
	FOREIGN KEY (
		goodNo -- 상품번호
	)
	REFERENCES good ( -- 상품
		goodNo -- 상품번호
	);

-- 상품리뷰
ALTER TABLE gReview
	ADD CONSTRAINT FK_customer_TO_gReview -- 고객 -> 상품리뷰
	FOREIGN KEY (
		cusNo -- 고객번호
	)
	REFERENCES customer ( -- 고객
		cusNo -- 고객번호
	);

-- 상품댓글
ALTER TABLE gComment
	ADD CONSTRAINT FK_gReview_TO_gComment -- 상품리뷰 -> 상품댓글
	FOREIGN KEY (
		gReviewNo -- 상품리뷰번호
	)
	REFERENCES gReview ( -- 상품리뷰
		gReviewNo -- 상품리뷰번호
	);


DROP PROCEDURE IF EXISTS createCustomer;

DELIMITER $$
CREATE PROCEDURE createCustomer(
	pName VARCHAR(200),
	pId VARCHAR(200),
	pPwd VARCHAR(200) 
)
    
BEGIN
	DECLARE cus_cnt INT;	
		SELECT COUNT(*)
		INTO cus_cnt -- 변수에 값 할당
		FROM customer
        WHERE id=pId;

	IF cus_cnt = 0 THEN
		INSERT INTO customer(name,id,pwd,startDate,changeDate,stat) VALUES (pName,pId,pPwd,DEFAULT,DEFAULT,1);
	ELSE
		SELECT 1 FROM DUAL;
END IF;
END ;
$$
DELIMITER ;


INSERT INTO customer(name,id,pwd,startDate,changeDate,stat)
VALUES ('국찬호','jaden','1111',DEFAULT,DEFAULT,1);
INSERT INTO customer(name,id,pwd,startDate,changeDate,stat)
VALUES ('박재현','jay','1111',DEFAULT,DEFAULT,1);
INSERT INTO customer(name,id,pwd,startDate,changeDate,stat)
VALUES ('권오진','metal','1111',DEFAULT,DEFAULT,1);
INSERT INTO customer(name,id,pwd,startDate,changeDate,stat)
VALUES ('박도영','tony','1111',DEFAULT,DEFAULT,1);
INSERT INTO good(name,type,company,startDate,changeDate,stat) VALUES ('드래곤볼',1,'학산문화사',DEFAULT,DEFAULT,1);
COMMIT;