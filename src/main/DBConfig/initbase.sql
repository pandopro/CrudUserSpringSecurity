# create table user(id, name, lastname, number)
# delete  from user;
# delete from role;
# truncate table role_user;
# truncate table user_role;
# create table role_user
# (
#     Role_id bigint not null,
#     user_id bigint not null,
#     primary key (Role_id, user_id),
#     constraint FKlbksi13vvo76ffjxy02ijiqfy
#         foreign key (user_id) references user (id),
#     constraint FKs3v3hpya7d60cgd0k0vr2u3ki
#         foreign key (Role_id) references role (id)
# );
drop table role, role_user, user, user_role;
create table role
(
    id   bigint auto_increment
        primary key,
    role varchar(255) null
);
create table user
(
    id                      bigint auto_increment
        primary key,
    email                   varchar(255) null,
    isAccountNonExpired     bit          not null,
    isAccountNonLocked      bit          not null,
    isCredentialsNonExpired bit          not null,
    isEnabled               bit          not null,
    lastname                varchar(255) null,
    name                    varchar(255) null,
    number                  varchar(255) null,
    password                varchar(255) null,
    constraint UK_e6gkqunxajvyxl5uctpl2vl2p
        unique (email)
);
create table user_role
(
    User_id  bigint not null,
    roles_id bigint not null,
    primary key (User_id, roles_id),
    constraint FK7qnwwe579g9frolyprat52l4d
        foreign key (roles_id) references role (id),
    constraint FKc52d1rv3ijbpu6lo2v3rej1tx
        foreign key (User_id) references user (id)
);



create table role_user
(
    Role_id bigint not null,
    user_id bigint not null,
    primary key (Role_id, user_id),
    constraint FKlbksi13vvo76ffjxy02ijiqfy
        foreign key (user_id) references user (id),
    constraint FKs3v3hpya7d60cgd0k0vr2u3ki
        foreign key (Role_id) references role (id)
);


insert into user (lastname, name, number, password, email, isAccountNonExpired, isAccountNonLocked,
                  isCredentialsNonExpired, isEnabled)
VALUES ("pupkin", "vasya", "+78914560986", "qwerty", "pupkin@qwerty.com", true, true, true, true),
#        ("ivanov", "kolya", "+78914576943", "qwerty", "ivanov@qwerty.com"),
#        ("ponomarev", "vlad", "+78916793579", "qwerty", "ponomarev@qwerty.com"),
#        ("pluskin", "igor", "+78914558012", "qwerty", "pluskin@qwerty.com"),
#        ("vorobeichik", "igor", "+78914590908", "qwerty", "vorobeichik@qwerty.com"),
       ("Userovich", "User", "+79118076543", "qwerty", "user@qwerty.com", true, true, true, true),
       ("Adminovich", "admin", "+78765546789", "qwerty", "admin@qwerty.com", true, true, true, true),
       ("Inn", "All", "+783456789", "qwerty", "all@qwerty.com", true, true, true, true);
insert into role(role)
VALUES ("ROLE_USER"),
       ("ROLE_USER"),
       ("ROLE_ADMIN"),
       ("ROLE_ADMIN"),
       ("ROLE_USER");
insert into user_role(user_id, roles_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (4, 5);
# insert into role_user (Role_id, user_id)
# values (1,1),
#        (2, 2),
#        (3, 3);