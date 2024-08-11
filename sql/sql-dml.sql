/*
    기업과 사용자의 DB 를 등록하는 과정 생략을 위해
    DB 상 기업 및 사용자 고정 데이터를 넣고 시작
*/
-- 기업 데이터 5가지
INSERT INTO COMPANY_INFO VALUES ('wanted007', '원티드');
INSERT INTO COMPANY_INFO VALUES ('samsungSDS', '삼성SDS');
INSERT INTO COMPANY_INFO VALUES ('itsmille', '밀리의서재');
INSERT INTO COMPANY_INFO VALUES ('codeit', '코드잇');
INSERT INTO COMPANY_INFO VALUES ('ddoubleu', '디더블유');

SELECT * FROM COMPANY_INFO;
-- ==>>
/*
codeit	코드잇
ddoubleu	디더블유
itsmille	밀리의서재
samsungSDS	삼성SDS
wanted007	원티드
*/


-- 사용자 데이터 5가지
INSERT INTO USER_INFO VALUES ('user001', '홍길동');
INSERT INTO USER_INFO VALUES ('user002', '김첨지');
INSERT INTO USER_INFO VALUES ('user003', '김향안');
INSERT INTO USER_INFO VALUES ('user004', '도준완');
INSERT INTO USER_INFO VALUES ('user005', '김남우');

SELECT * FROM USER_INFO;
-- ==>
/*
user001	홍길동
user002	김첨지
user003	김향안
user004	도준완
user005	김남우
*/