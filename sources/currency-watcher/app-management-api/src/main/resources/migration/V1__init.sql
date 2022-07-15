create sequence hibernate_sequence start 1 increment 1;

CREATE TABLE cryptocurrency (
    id varchar(8) primary key,
    symbol varchar(16) not null unique,
    price_usd varchar(16) default null
);

CREATE TABLE client (
    id int8 primary key,
    username varchar (128) not null unique,
    fixed_cryptocurrency_price varchar (16) default null,
    subscription_ts timestamp default null
);

CREATE TABLE client_cryptocurrencies (
    client_entity_id int8 not null,
    cryptocurrencies_id varchar(255) not null
);



