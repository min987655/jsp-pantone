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

CREATE TABLE board(
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
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (memberId) references member (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
);
```

## 테이블 시퀀스
```sql
CREATE SEQUENCE MEMBER_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE BOARD_SEQ
  START WITH 1
  INCREMENT BY 1;
  
CREATE SEQUENCE REPLY_SEQ
  START WITH 1
  INCREMENT BY 1;
```

## 페이징 쿼리
```sql
SELECT /*+ INDEX_DESC(BOARD SYS_C007969)*/id,
userId, title, content, readCount, createDate
FROM board
OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;
```