create table sys_user (
 `id` int(11) not null auto_increment,
 `username` varchar(30) not null,
 `password` varchar(64) not null,
 `email`    varchar(50),
 `address`  varchar(100),
 `age`      int,
 `expired` int,     -- 是否过期
 `disabled` int,    -- 是否禁用
 `locked` int,      -- 是否锁定
  primary key (`id`)
) engine=innodb auto_increment=1 default charset=utf8;

/*123*/
insert into sys_user values ('1', 'admin', '202cb962ac59075b964b07152d234b70', 'admin@foxmail.com', '广州天河', 24, 0, 0, 0);

/*12345678*/
insert into sys_user values ('2', 'zhangsan', '25d55ad283aa400af464c76d713c07ad', 'zhangsan@foxmail.com', '广州越秀', 26, 0, 0, 0);

/*1234*/
/*禁用账户*/
insert into sys_user values('3', 'zhaosi','81dc9bdb52d04dc20036dbd8313ed055', 'zhaosi@foxmail.com', '广州海珠', 25, 0 , 1, 0);

/*12345*/
/*过期账户*/
insert into sys_user values('4', 'wangwu','827ccb0eea8a706c4c34a16891f84e7b', 'wangwu@foxmail.com', '广州番禺', 27, 1 , 0, 0);

/*123*/
/*锁定账户*/
insert into sys_user values('5', 'boss','202cb962ac59075b964b07152d234b70', 'boss@foxmail.com', '深圳', 30, 0 , 0, 1);

insert into sys_user VALUES('6','eric','eric','ericling666@gmail.com', '深圳', 30, 0 , 0, 1);

