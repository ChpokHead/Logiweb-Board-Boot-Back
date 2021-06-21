create table location
(
    id bigserial not null
        constraint location_pkey
            primary key,
    name varchar(255)
);

alter table location owner to chpok;

create table driver
(
    id bigserial not null
        constraint driver_pkey
            primary key,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    month_worked_hours smallint default 0,
    location varchar(30),
    status integer,
    current_truck_reg_number varchar(7),
    current_order_id varchar(30)
);

alter table driver owner to chpok;

create table truck
(
    id bigserial not null
        constraint truck_pkey
            primary key,
    capacity smallint,
    drivers_shift smallint,
    reg_number varchar(255),
    status integer,
    location varchar(30),
    current_order_id varchar(30)
);

alter table truck owner to chpok;

create table customer_order
(
    id bigserial not null
        constraint customer_order_pkey
            primary key,
    is_completed boolean default false,
    current_truck_id bigint,
    creation_date varchar(30),
    start_date varchar(30),
    end_date varchar(30)
);

alter table customer_order owner to chpok;

