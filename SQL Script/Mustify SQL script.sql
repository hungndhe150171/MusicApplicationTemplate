use MUSTIFY

create table ACCOUNT_TYPE(
accType_id int primary key identity,
type_name varchar(30) not null,
description nvarchar(300),
)

create table ACCOUNT(
account_id int primary key identity,
username varchar(20) not null,
password varchar(20) not null,
first_name nvarchar(30) not null,
last_name nvarchar(30) not null,
gender bit default 0 not null,
phone varchar(13),
email varchar(30),
address nvarchar(150) not null,
join_date datetime default getdate(),
account_type int foreign key references ACCOUNT_TYPE(accType_id),
is_active bit default 0,
)

drop table account