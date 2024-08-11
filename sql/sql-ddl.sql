/*
    기업과 사용자의 DB 를 등록하는 과정 생략을 위해
    DB 상 기업 및 사용자 고정 데이터를 넣고 시작
*/
-- 기업 Entity DDL
CREATE TABLE COMPANY_INFO (
    COMP_ID VARCHAR(100) PRIMARY KEY,
    COMP_NM VARCHAR(200)
);


-- 사용자 Entity DDL
CREATE TABLE USER_INFO (
    USER_ID VARCHAR(100) PRIMARY KEY,
    USER_NM VARCHAR(200)
);


/*
    다량 검색을 위한 MYSQL 의 기능을 위한 ALTER 구문
*/
ALTER TABLE jobpost ADD FULLTEXT(nation, region, position, technic, title, contents);
ALTER TABLE company ADD FULLTEXT(comp_nm);