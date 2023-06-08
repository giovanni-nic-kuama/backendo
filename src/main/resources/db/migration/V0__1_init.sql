create schema if not exists backendo;

CREATE TABLE backendo.todo
(
    id    integer auto_increment PRIMARY KEY,
    title  varchar(255) not null ,
    message text not null ,
    createdAt datetime not null,
    updatedAt datetime,
    deletedAt datetime
);