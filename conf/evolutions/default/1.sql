# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cave (
  id                        bigint not null,
  name                      varchar(255),
  owner_email               varchar(255),
  constraint pk_cave primary key (id))
;

create table cheese (
  id                        bigint not null,
  name                      varchar(255),
  finished                  boolean,
  start_date                timestamp,
  finish_date               timestamp,
  visible                   boolean,
  cave_id                   bigint,
  user_email                varchar(255),
  cheese_style              varchar(255),
  recipe_source             varchar(255),
  coagulant                 varchar(255),
  inoculant                 varchar(255),
  milk_type                 varchar(255),
  image                     varchar(255),
  constraint pk_cheese primary key (id))
;

create table cheese_style (
  id                        bigint not null,
  cheese_style              varchar(255),
  constraint pk_cheese_style primary key (id))
;

create table milk_type (
  id                        bigint not null,
  milk_type                 varchar(255),
  image                     varchar(255),
  constraint pk_milk_type primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create sequence cave_seq;

create sequence cheese_seq;

create sequence cheese_style_seq;

create sequence milk_type_seq;

create sequence user_seq;

alter table cave add constraint fk_cave_owner_1 foreign key (owner_email) references user (email) on delete restrict on update restrict;
create index ix_cave_owner_1 on cave (owner_email);
alter table cheese add constraint fk_cheese_cave_2 foreign key (cave_id) references cave (id) on delete restrict on update restrict;
create index ix_cheese_cave_2 on cheese (cave_id);
alter table cheese add constraint fk_cheese_user_3 foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_cheese_user_3 on cheese (user_email);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cave;

drop table if exists cheese;

drop table if exists cheese_style;

drop table if exists milk_type;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cave_seq;

drop sequence if exists cheese_seq;

drop sequence if exists cheese_style_seq;

drop sequence if exists milk_type_seq;

drop sequence if exists user_seq;

