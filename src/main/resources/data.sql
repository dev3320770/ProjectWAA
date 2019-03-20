insert into role ( role , role_id ) values ('ADMIN',1);
insert into role ( role , role_id ) values ('FACULTY',2);
insert into role ( role , role_id ) values ('STUDENT',3);

insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'festusiipito@gmail.com','festus','I','Festus','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',1);
insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'dawit@gmail.com','dawit','W','Dawit','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',2);
insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'alaa@gmail.com','alaa','A','Alaa','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',3);
insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'balindra@gmail.com','balindra','B','Balindra','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',4);

insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'faculty@mum.edu','faculty1','One','Faculty','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',5);
insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'student1@mum.edu','986683','One','Student','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',6);
insert  into user ( active,email,username,last_name,first_name,password ,user_id) values (1,'student2@mum.edu','student2','Two','Student','$2a$10$lTuThBZRK74EWYblQoMXE.mscfRX41tN4QumVbAYCFftNU7o1.2dK',7);

insert  into user_role (role_id, user_id) values(1,1);
insert  into user_role (role_id, user_id) values(1,2);
insert  into user_role (role_id, user_id) values(1,3);
insert  into user_role (role_id, user_id) values(1,4);
insert  into user_role (role_id, user_id) values(2,5);
insert  into user_role (role_id, user_id) values(3,6);
insert  into user_role (role_id, user_id) values(3,7);
