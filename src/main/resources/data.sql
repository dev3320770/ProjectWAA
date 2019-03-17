insert into role ( role , role_id ) values ('ADMIN',1);
insert  into user ( active,email,last_name,name,password ,user_id) values (1,'festusiipito@gmail.com','Iipito','festus','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',1);
insert  into user_role(role_id, user_id) values(1,1);