--liquibase formatted sql

--changeset luyanfei_schema:1
create table user_category(
	user_id bigint(19) not null,
	category_id bigint(19) not null,
	primary key (user_id,category_id)
) engine=innodb default charset=utf8;
--rollback drop table user_catetory;

--changeset luyanfei_schema:2
alter table user_category add foreign key (user_id) 
	references user (id) on delete cascade;
--rollback alter table user_category drop foreign key user_category_ibfk_1;
	
--changeset luyanfei_schema:3
alter table user_category add foreign key (category_id) 
	references category (id) on delete cascade;
--rollback alter table user_category drop foreign key user_category_ibfk_2;
	
--changeset luyanfei_schema:4
create table user_role(
	user_id bigint(19) not null,
	role_id bigint(19) not null,
	primary key (user_id,role_id)
) engine=innodb default charset=utf8;
--rollback drop table user_role;

--changeset luyanfei_schema:5
alter table user_role add foreign key (user_id) 
	references user (id) on delete cascade;
--rollback alter table user_role drop foreign key user_role_ibfk_1;
	
--changeset luyanfei_schema:6
alter table user_role add foreign key (role_id) 
	references role (id) on delete cascade;
--rollback alter table user_role drop foreign key user_role_ibfk_2;

--changeset luyanfei_schema:7
alter table role drop foreign key FK_svdv2jq4dkan56efhtqpl0wgw;
--rollback alter table role add constraint FK_svdv2jq4dkan56efhtqpl0wgw foreign key FK_svdv2jq4dkan56efhtqpl0wgw (user) references user (id);

--changeset luyanfei_schema:8
alter table role drop column user;
--rollback alter table role add column user bigint(19) default null;

--changeset luyanfei_schema:9
alter table role add column description varchar(2048) default null;
--rollback alter table role drop column description;

--changeset luyanfei_schema:10
alter table user add column email varchar(128) default null;
--rollback alter table user drop column email;
