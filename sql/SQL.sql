/*
    기업 및 사용자 DB 관련 테스트 용 가데이터 SQL
*/

CREATE TABLE company (
    comp_id VARCHAR(100) PRIMARY KEY,
    comp_nm VARCHAR(200)
);

CREATE TABLE users (
    user_id VARCHAR(100) PRIMARY KEY,
    user_nm VARCHAR(200)
);

INSERT INTO company VALUES ('wanted007', '원티드');
INSERT INTO company VALUES ('samsungSDS', '삼성SDS');
INSERT INTO company VALUES ('itsmille', '밀리의서재');
INSERT INTO company VALUES ('codeit', '코드잇');
INSERT INTO company VALUES ('ddoubleu', '디더블유');

SELECT * FROM company;
-- ==>>
/*
codeit	코드잇
ddoubleu	디더블유
itsmille	밀리의서재
samsungSDS	삼성SDS
wanted007	원티드
*/

INSERT INTO users VALUES ('user001', '홍길동');
INSERT INTO users VALUES ('user002', '김첨지');
INSERT INTO users VALUES ('user003', '김향안');
INSERT INTO users VALUES ('user004', '도준완');
INSERT INTO users VALUES ('user005', '김남우');

SELECT * FROM users;
-- ==>
/*
user001	홍길동
user002	김첨지
user003	김향안
user004	도준완
user005	김남우
*/