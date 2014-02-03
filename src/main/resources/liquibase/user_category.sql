--liquibase formatted sql

--changeset luyanfei:1
create table user_category(
	user_id bigint(19) not null,
	category_id bigint(19) not null,
	primary key (user_id,category_id)
) engine=innodb default charset=utf8;
--rollback drop table user_catetory;

--changeset luyanfei:2
alter table user_category add foreign key (user_id) 
	references user (id) on delete cascade;
--rollback alter table user_category drop foreign key user_category_ibfk_1;
	
--changeset luyanfei:3
alter table user_category add foreign key (category_id) 
	references category (id) on delete cascade;
--rollback alter table user_category drop foreign key user_category_ibfk_2;
	