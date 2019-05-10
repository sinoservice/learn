----------------------------------------------
-- Export file for user TMSAPP@SCCDBT       --
----------------------------------------------

set define off
spool mrduan.log

prompt
prompt Creating table TB_REMINDER
prompt ==========================
prompt
create table TMSAPP.TB_REMINDER
(
  fid           VARCHAR2(64) not null,
  work_no       VARCHAR2(255),
  master_phone  VARCHAR2(255),
  cus_name      VARCHAR2(255),
  status        NUMBER(11),
  reminder_time DATE,
  biz_id        VARCHAR2(255)
)
tablespace TMSAPP
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TMSAPP.TB_REMINDER
  add primary key (FID)
  using index 
  tablespace TMSAPP
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_VOICE_REPLY
prompt =============================
prompt
create table TMSAPP.TB_VOICE_REPLY
(
  fid         VARCHAR2(64) not null,
  status_code VARCHAR2(255),
  duration    NUMBER(11) default 0,
  biz_id      VARCHAR2(255),
  start_time  VARCHAR2(255),
  end_time    VARCHAR2(255),
  status_msg  VARCHAR2(255),
  status      NUMBER(11) default 0
)
tablespace TMSAPP
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TMSAPP.TB_VOICE_REPLY
  add primary key (FID)
  using index 
  tablespace TMSAPP
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
