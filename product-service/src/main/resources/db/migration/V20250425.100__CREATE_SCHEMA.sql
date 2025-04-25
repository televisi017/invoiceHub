CREATE TABLE product(
    product_id varchar(200) not null,
    name varchar(200) not null,
    description text,
    price decimal(10,2) not null,
    stock_quantity int not null default 0,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    constraint product_id_pk primary key(product_id)
);