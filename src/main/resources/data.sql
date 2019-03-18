insert into role ( role , role_id ) values ('ADMIN',1);

insert  into user ( active,email,last_name,first_name,password ,user_id) values (1,'festusiipito@gmail.com','Iipito','festus','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',1);
insert  into user ( active,email,last_name,first_name,password ,user_id) values (1,'dawit@gmail.com','lastname','firstname','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',2);
insert  into user ( active,email,last_name,first_name,password ,user_id) values (1,'alaa@gmail.com','lastname','firstname','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',3);
insert  into user ( active,email,last_name,first_name,password ,user_id) values (1,'balindra@gmail.com','lastname','firstname','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',4);

insert  into user_role(role_id, user_id) values(1,1);
insert  into user_role(role_id, user_id) values(1,2);
insert  into user_role(role_id, user_id) values(1,3);
insert  into user_role(role_id, user_id) values(1,4);