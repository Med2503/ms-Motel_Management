

create table if not exists roomType
(
    id          integer not null
        primary key,
    description varchar(255),
    type        varchar(255)
);

create table if not exists room
(
    id                 integer          not null
        primary key,
    availablePlaces decimal(19,4) not null,
    description        varchar(255),
    price              numeric(38, 2),
    roomType_id        integer
        constraint fk1gtr7tgyt649mq9s
            references roomType
);

create sequence if not exists roomType_seq increment by 50;
create sequence if not exists room_seq increment by 50;