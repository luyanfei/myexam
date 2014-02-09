--liquibase formatted sql

--changeset luyanfei_seq:1
insert into attempt_seq(next_val) values(0);
--rollback delete from attempt_seq where next_val=0;

--changeset luyanfei_seq:2
insert into brief_answer_seq(next_val) values(0);
--rollback delete from brief_answer_seq where next_val=0;

--changeset luyanfei_seq:3
insert into category_seq(next_val) values(0);
--rollback delete from category_seq where next_val=0;

--changeset luyanfei_seq:4
insert into fill_blank_seq(next_val) values(0);
--rollback delete from fill_blank_seq where next_val=0;

--changeset luyanfei_seq:5
insert into glossary_seq(next_val) values(0);
--rollback delete from glossary_seq where next_val=0;

--changeset luyanfei_seq:6
insert into quiz_seq(next_val) values(0);
--rollback delete from quiz_seq where next_val=0;

--changeset luyanfei_seq:7
insert into role_seq(next_val) values(0);
--rollback delete from role_seq where next_val=0;

--changeset luyanfei_seq:8
insert into single_choice_seq(next_val) values(0);
--rollback delete from single_choice_seq where next_val=0;

--changeset luyanfei_seq:9
insert into true_or_false_seq(next_val) values(0);
--rollback delete from true_or_false_seq where next_val=0;

--changeset luyanfei_seq:10
insert into user_seq(next_val) values(0);
--rollback delete from user_seq where next_val=0;