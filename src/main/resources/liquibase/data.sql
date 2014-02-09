--liquibase formatted sql

--changeset luyanfei_data:1
insert into attempt_seq(next_val) values(0);
--rollback delete from attempt_seq where next_val=0;

--changeset luyanfei_data:2
insert into brief_answer_seq(next_val) values(0);
--rollback delete from brief_answer_seq where next_val=0;

--changeset luyanfei_data:3
insert into category_seq(next_val) values(0);
--rollback delete from category_seq where next_val=0;

--changeset luyanfei_data:4
insert into fill_blank_seq(next_val) values(0);
--rollback delete from fill_blank_seq where next_val=0;

--changeset luyanfei_data:5
insert into glossary_seq(next_val) values(0);
--rollback delete from glossary_seq where next_val=0;

--changeset luyanfei_data:6
insert into quiz_seq(next_val) values(0);
--rollback delete from quiz_seq where next_val=0;

--changeset luyanfei_data:7
insert into role_seq(next_val) values(0);
--rollback delete from role_seq where next_val=0;

--changeset luyanfei_data:8
insert into single_choice_seq(next_val) values(0);
--rollback delete from single_choice_seq where next_val=0;

--changeset luyanfei_data:9
insert into true_or_false_seq(next_val) values(0);
--rollback delete from true_or_false_seq where next_val=0;

--changeset luyanfei_data:10
insert into user_seq(next_val) values(0);
--rollback delete from user_seq where next_val=0;

--changeset luyanfei_data:11
update role_seq set next_val=10;
--rollback update role_seq set next_val=0;

--changeset luyanfei_data:12
insert into role(id,rolename,description) values(1,'TEACHER','教师角色');
--roleback delete from role where id=1;

--changeset luyanfei_data:13
insert into role(id,rolename,description) values(2,'CANDIDATE','考生角色');
--roleback delete from role where id=2;

--changeset luyanfei_data:14
insert into role(id,rolename,description) values(3,'MANAGER','管理员角色');
--roleback delete from role where id=3;

--changeset luyanfei_data:15
update user_seq set next_val=10;
--rollback update user_seq set next_val=0;

--changeset luyanfei_data:16
insert into user(id,username,password,enabled,email,display_name) 
	values(1,'teacher1','teacher1',1,'teacher1@myexam.com','Sir Zhang');
--roleback delete from user where id=1;

--changeset luyanfei_data:17
insert into user_role (user_id,role_id) values (1,1);
--roleback delete from user_role where user_id=1 and role_id=1;

--changeset luyanfei_data:18
insert into user_role (user_id,role_id) values (1,2);
--roleback delete from user_role where user_id=1 and role_id=2;

--changeset luyanfei_data:19
insert into user(id,username,password,enabled,email,display_name) 
	values(2,'candidate1','candidate1',1,'candidate1@myexam.com','Mr. Li');
--roleback delete from user where id=2;
	
--changeset luyanfei_data:20
insert into user_role (user_id,role_id) values (2,2);
--roleback delete from user_role where user_id=2 and role_id=2;
