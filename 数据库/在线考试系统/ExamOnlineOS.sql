/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2016                    */
/* Created on:     2019/12/16 10:09:50                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('exam_information') and o.name = 'FK_EXAM_INF_REFERENCE_COURSE')
alter table exam_information
   drop constraint FK_EXAM_INF_REFERENCE_COURSE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('grade') and o.name = 'FK_GRADE_REFERENCE_PAPER_IN')
alter table grade
   drop constraint FK_GRADE_REFERENCE_PAPER_IN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('grade') and o.name = 'FK_GRADE_REFERENCE_STUDENT')
alter table grade
   drop constraint FK_GRADE_REFERENCE_STUDENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_information') and o.name = 'FK_PAPER_IN_REFERENCE_EXAM_INF')
alter table paper_information
   drop constraint FK_PAPER_IN_REFERENCE_EXAM_INF
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_question') and o.name = 'FK_PAPER_QU_REFERENCE_PAPER_IN')
alter table paper_question
   drop constraint FK_PAPER_QU_REFERENCE_PAPER_IN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_question') and o.name = 'FK_PAPER_QU_REFERENCE_QUESTION')
alter table paper_question
   drop constraint FK_PAPER_QU_REFERENCE_QUESTION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_solution') and o.name = 'FK_PAPER_SO_REFERENCE_STUDENT')
alter table paper_solution
   drop constraint FK_PAPER_SO_REFERENCE_STUDENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_solution') and o.name = 'FK_PAPER_SO_REFERENCE_PAPER_IN')
alter table paper_solution
   drop constraint FK_PAPER_SO_REFERENCE_PAPER_IN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('paper_solution') and o.name = 'FK_PAPER_SO_REFERENCE_QUESTION')
alter table paper_solution
   drop constraint FK_PAPER_SO_REFERENCE_QUESTION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('question_bank') and o.name = 'FK_QUESTION_REFERENCE_COURSE')
alter table question_bank
   drop constraint FK_QUESTION_REFERENCE_COURSE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('student_course') and o.name = 'FK_STUDENT__REFERENCE_STUDENT')
alter table student_course
   drop constraint FK_STUDENT__REFERENCE_STUDENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('student_course') and o.name = 'FK_STUDENT__REFERENCE_COURSE')
alter table student_course
   drop constraint FK_STUDENT__REFERENCE_COURSE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('admin')
            and   type = 'U')
   drop table admin
go

if exists (select 1
            from  sysobjects
           where  id = object_id('course')
            and   type = 'U')
   drop table course
go

if exists (select 1
            from  sysobjects
           where  id = object_id('exam_information')
            and   type = 'U')
   drop table exam_information
go

if exists (select 1
            from  sysobjects
           where  id = object_id('grade')
            and   type = 'U')
   drop table grade
go

if exists (select 1
            from  sysobjects
           where  id = object_id('paper_information')
            and   type = 'U')
   drop table paper_information
go

if exists (select 1
            from  sysobjects
           where  id = object_id('paper_question')
            and   type = 'U')
   drop table paper_question
go

if exists (select 1
            from  sysobjects
           where  id = object_id('paper_solution')
            and   type = 'U')
   drop table paper_solution
go

if exists (select 1
            from  sysobjects
           where  id = object_id('question_bank')
            and   type = 'U')
   drop table question_bank
go

if exists (select 1
            from  sysobjects
           where  id = object_id('student')
            and   type = 'U')
   drop table student
go

if exists (select 1
            from  sysobjects
           where  id = object_id('student_course')
            and   type = 'U')
   drop table student_course
go

if exists (select 1
            from  sysobjects
           where  id = object_id('teacher')
            and   type = 'U')
   drop table teacher
go

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin (
   Mid                  int                  not null,
   Mpwd                 varchar(16)          not null,
   Mname                varchar(15)          not null,
   Mmobile              varchar(11)          not null,
   constraint PK_ADMIN primary key (Mid)
)
go

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course (
   Cid                  int                  not null,
   Cname                varchar(15)          not null,
   constraint PK_COURSE primary key (Cid)
)
go

/*==============================================================*/
/* Table: exam_information                                      */
/*==============================================================*/
create table exam_information (
   EIid                 int                  identity,
   EIname               varchar(15)          not null,
   start_time           datetime             not null,
   finish_time          datetime             not null,
   Cid                  int                  not null,
   constraint PK_EXAM_INFORMATION primary key (EIid)
)
go

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade (
   Gid                  int                  identity,
   Sid                  int                  not null,
   PIid                 int                  not null,
   score                float(4)             not null,
   use_time             int                  not null,
   constraint PK_GRADE primary key (Gid)
)
go

/*==============================================================*/
/* Table: paper_information                                     */
/*==============================================================*/
create table paper_information (
   PIid                 int                  identity,
   EIid                 int                  null,
   total_score          float(4)             not null,
   total_time           int                  not null,
   constraint PK_PAPER_INFORMATION primary key (PIid)
)
go

/*==============================================================*/
/* Table: paper_question                                        */
/*==============================================================*/
create table paper_question (
   PIid                 int                  null,
   QBid                 int                  null,
   PQ_score             float(4)             null
)
go

/*==============================================================*/
/* Table: paper_solution                                        */
/*==============================================================*/
create table paper_solution (
   Sid                  int                  not null,
   PIid                 int                  not null,
   solution             varchar(255)         not null,
   PSscore              float(4)             not null,
   QBid                 int                  not null
)
go

/*==============================================================*/
/* Table: question_bank                                         */
/*==============================================================*/
create table question_bank (
   QBid                 int                  identity,
   question             varchar(255)         not null,
   answer               varchar(255)         not null,
   Cid                  int                  not null,
   is_single            int                  not null,
   degree               int                  not null,
   A                    varchar(255)         null,
   B                    varchar(255)         null,
   C                    varchar(255)         null,
   D                    varchar(255)         null,
   E                    varchar(255)         null,
   F                    varchar(255)         null,
   G                    varchar(255)         null,
   constraint PK_QUESTION_BANK primary key (QBid)
)
go

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student (
   Sid                  int                  not null,
   Sname                varchar(15)          not null,
   Spwd                 varchar(16)          not null,
   subject              varchar(15)          not null,
   Smobile              varchar(11)          not null,
   constraint PK_STUDENT primary key (Sid)
)
go

/*==============================================================*/
/* Table: student_course                                        */
/*==============================================================*/
create table student_course (
   Sid                  int                  null,
   Cid                  int                  null
)
go

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher (
   Tid                  int                  not null,
   Tname                varchar(15)          not null,
   Tpwd                 varchar(16)          not null,
   Tmobile              varchar(11)          not null,
   constraint PK_TEACHER primary key (Tid)
)
go

alter table exam_information
   add constraint FK_EXAM_INF_REFERENCE_COURSE foreign key (Cid)
      references course (Cid)
go

alter table grade
   add constraint FK_GRADE_REFERENCE_PAPER_IN foreign key (PIid)
      references paper_information (PIid)
go

alter table grade
   add constraint FK_GRADE_REFERENCE_STUDENT foreign key (Sid)
      references student (Sid)
go

alter table paper_information
   add constraint FK_PAPER_IN_REFERENCE_EXAM_INF foreign key (EIid)
      references exam_information (EIid)
go

alter table paper_question
   add constraint FK_PAPER_QU_REFERENCE_PAPER_IN foreign key (PIid)
      references paper_information (PIid)
go

alter table paper_question
   add constraint FK_PAPER_QU_REFERENCE_QUESTION foreign key (QBid)
      references question_bank (QBid)
go

alter table paper_solution
   add constraint FK_PAPER_SO_REFERENCE_STUDENT foreign key (Sid)
      references student (Sid)
go

alter table paper_solution
   add constraint FK_PAPER_SO_REFERENCE_PAPER_IN foreign key (PIid)
      references paper_information (PIid)
go

alter table paper_solution
   add constraint FK_PAPER_SO_REFERENCE_QUESTION foreign key (QBid)
      references question_bank (QBid)
go

alter table question_bank
   add constraint FK_QUESTION_REFERENCE_COURSE foreign key (Cid)
      references course (Cid)
go

alter table student_course
   add constraint FK_STUDENT__REFERENCE_STUDENT foreign key (Sid)
      references student (Sid)
go

alter table student_course
   add constraint FK_STUDENT__REFERENCE_COURSE foreign key (Cid)
      references course (Cid)
go

