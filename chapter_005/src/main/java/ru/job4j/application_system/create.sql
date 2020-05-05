drop database if exists application_system;
create database application_system;

create table roles
(
    id         serial primary key,
    role_name varchar(2000)
);

create table rules
(
    id               serial primary key,
    role_description varchar(5000)
);

create table roles_rules
(
    id      serial primary key,
    role_id int references roles (id),
    rule_id int references rules (id)
);

create table users
(
    id       serial primary key,
    username varchar(2000),
    email    varchar(2000),
    created  timestamp,
    role_id int references roles (id)
);

create table application_category
(
    id       serial primary key,
    category varchar(2000)
);

create table application_state
(
    id    serial primary key,
    state varchar(2000)
);

create table applications
(
    id                      serial primary key,
    application             varchar(2000),
    created                 timestamp,
    last_updated            timestamp,
    user_id                 int references users (id),
    application_category_id int references application_category (id),
    application_state_id    int references application_state (id)
);

create table application_comments
(
    id             serial primary key,
    text           varchar(5000),
    application_id int references applications (id)
);

create table attached_files
(
    id             serial primary key,
    attach         varchar(5000),
    application_id int references applications (id)
);

insert into roles (role_name)
values ('admin'),
       ('user');
insert into rules (role_description)
values ('admin_description'),
       ('user_description');
insert into roles_rules (role_id, rule_id)
values (1, 2),
       (2, 1),
       (2, 1);
insert into users (username, email, created, role_id)
values ('Robert', 'robert@gmail.com', '2019-01-08 04:05:06', 1),
       ('Nike', 'nike@gmail.com', '2020-01-08 04:05:06', 2);
insert into application_category (category)
values ('work'),
       ('home');
insert into application_state (state)
values ('open'),
       ('closed');
insert into applications (application, created, last_updated, user_id, application_category_id, application_state_id)
values ('application1', '2020-09-10 04:05:06', '2020-09-10 04:05:06', 1, 1, 1),
       ('application2', '2020-09-10 04:05:06', '2020-09-10 04:05:06', 2, 2, 2);
insert into application_comments (text, application_id)
values ('application_text1', 1),
       ('application_text2', 2);
insert into attached_files (attach, application_id)
values ('attach1', 1),
       ('attach2', 2);













