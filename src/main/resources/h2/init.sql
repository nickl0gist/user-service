create table users
(
    id      bigint auto_increment,
    name    varchar(50),
    balance float,
    primary key (id)
);

create table user_transaction
(
    tx_id        bigint auto_increment,
    user_id      bigint,
    amount       float,
    tx_timestamp timestamp,
    foreign key (user_id) references users (id) on delete cascade
);

insert into users (name, balance)
values ('Nick', 2000.0),
       ('Sam', 1000.4),
       ('Bob', 10000.7);
