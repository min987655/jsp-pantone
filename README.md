### Jsp PANTONE 프로젝트

## 오라클 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER pantone IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO pantone;
GRANT CREATE TABLESPACE TO pantone;
GRANT CREATE TABLE TO pantone;
GRANT RESOURCE, CONNECT to pantone;
GRANT CREATE SEQUENCE to pantone;
ALTER user pantone DEFAULT TABLESPACE users QUOTA UNLIMITED on users;
```

## 테이블
```sql
CREATE TABLE member(
	id number primary key,
  username varchar2(100) not null unique,
  password varchar2(100) not null,
  email varchar2(100) not null,
  userProfile varchar2(200),
  userRole varchar2(20),
  createDate timestamp
);

CREATE TABLE palette(
	id number primary key,
  memberId number,
  title varchar2(100) not null,
  content clob not null,
  readCount number default 0,
  likeCount number default 0,
  createDate timestamp,
  foreign key (memberId) references member (id)
);

CREATE TABLE reply(
	id number primary key,
  memberId number,
  paletteId number,
  content varchar2(300) not null,
  createDate timestamp,
  foreign key (memberId) references member (id) on delete set null,
  foreign key (boardId) references board (id) on delete cascade
);

CREATE TABLE faq(
	id number primary key,
  memberId number,
  title varchar2(100) not null,
  content clob not null,
  readCount number default 0,
  createDate timestamp,
  foreign key (memberId) references member (id)
);

CREATE TABLE colorTrend(
	id number primary key,
  memberId number,
  title varchar2(100) not null,
  content clob not null,
  readCount number default 0,
  createDate timestamp,
  foreign key (memberId) references member (id)
);
```

## 테이블 시퀀스
```sql
CREATE SEQUENCE MEMBER_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE PALETTE_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE REPLY_SEQ
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE FAQ_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE COLORTREND_SEQ
  START WITH 1
  INCREMENT BY 1;
```

## 페이징 쿼리
```sql
SELECT /*+ INDEX_DESC(PALETTE SYS_C007733)*/id,
userId, title, content, readCount, createDate
FROM palette
OFFSET 0 ROWS FETCH NEXT 9 ROWS ONLY;
```