create table role
(
   role_id integer not null,
   role varchar(255) not null,
   primary key(role_id)
);

create table user
(
   user_id integer not null,
   active integer not null,
   email varchar(255) not null,
   last_name varchar(255) not null,
   name varchar(255) not null,
   password varchar(255) not null,
   primary key(user_id)
);

create table user_role
(
   user_id integer not null,
   role_id integer not null

);