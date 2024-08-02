-- create tables
Create table users (
    id                 int    primary key    auto_increment,
    name               text                  not null,
    address            text                  not null,
    birthday           date                  not null,
    phoneNumber        text                  not null,
    email              text                  not null,
    position           text                  not null,
    salary             text                  not null,
    checkinHour        time                          ,
    checkoutHour       time                          ,
    assignedTask       int                           ,
    assignedDepartment int                           ,
    isAdmin            int                   not null
);

Create table permissions (
    id                 int    primary key    auto_increment,
    user               int                   not null,
    checkinHour        time                  not null,
    checkoutHour       time                  not null
);

Create table departments (
    id                 int    primary key    auto_increment,
    name               text                  not null
);

Create table projects (
    id                 int    primary key    auto_increment,
    assignedDepartment int                   not null,
    name               text                  not null,
    status             text                  not null,
    deadline           date                  not null
);

Create table task (
    id                 int    primary key    auto_increment,
    project            int                   not null,
    name               text                  not null,
    status             text                  not null,
    deadline           date                  not null,
    assignedEmployee   int                   not null
);

    alter table users       add foreign key (assignedTask)       references projects(id);
    alter table users       add foreign key (assignedDepartment) references departments(id);

    alter table permissions add foreign key (user)               references users(id);

    alter table projects    add foreign key (assignedDepartment) references departments(id);

    alter table task        add foreign key (assignedEmployee)   references users(id);

-- inserts
insert into users
(name, address, birthday, phoneNumber, email, position,
salary, isAdmin) values
("Kristopher Alexis", "direccion1234", "2003-12-27",
"3229278857", "ritzz", "rootdev", "999999", 1);