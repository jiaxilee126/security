
Drop Table If Exists `admin`;
CREATE TABLE `admin` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE Key(`username`)
) Comment = '用户表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `code` Varchar(24) Not Null Comment '角色编码',
  `description` varchar(100) DEFAULT NULL,
  `available` Bit Not Null Default 0 Comment '是否可用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '角色表';

DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
	`id` int unsigned NOT NULL AUTO_INCREMENT,
	`admin_id` int unsigned NOT NULL,
	`role_id` int unsigned NOT NULL,
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`id`),
	Constraint `fk_AdminRole_UID` Foreign Key(`admin_id`) References `admin`(`id`),
	Constraint `fk_AdminRole_RID` Foreign Key(`role_id`) References `role`(`id`)
) Comment = '用户角色表';


DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) unsigned DEFAULT '0',
  `sorted` int unsigned DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '路径表';

DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int unsigned NOT NULL,
  `resource_id` int unsigned NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  Constraint `fk_RoleResource_RoleID` Foreign Key(`role_id`) References `role`(`id`),
  Constraint `fk_RoleResource_RID` Foreign Key(`resource_id`) References `resource`(`id`)
) Comment = '角色资源表';

Drop Table If Exists `product_info`;
Create Table `product_info`(
  `id` Int Unsigned Not Null Auto_Increment,
  `name` Varchar(24) Not Null Comment '产品名称',
  `image` Varchar(256) Not Null Comment '产品图标',
  `description` Varchar(512) Not Null Comment '产品描述',
  `status` Bit Not Null Default 1 Comment '状态',
  `create_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '创建时间',
  `update_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '更新时间',
  Primary Key (`id`)
)Comment = '产品信息表';

Drop Table If Exists `product_super`;
Create Table `product_super`(
  `id` Int Unsigned Not Null Auto_Increment,
  `name` Varchar(24) Not Null Comment '优势名称',
  `description` Varchar(128) Not Null Comment '优势描述',
  `image` Varchar(256) Not Null Comment '产品优势图标',
  `status` Bit Not Null Default 1 Comment '状态',
  `create_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '创建时间',
  `update_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '更新时间',
  Primary Key (`id`)
)Comment = '产品优势表';

Drop Table If Exists `product_case`;
Create Table `product_case`(
  `id` Int Unsigned Not Null Auto_Increment,
  `name` Varchar(24) Not Null Comment '案例名称',
  `image` Varchar(256) Not Null Comment '案例图片',
  `description` Varchar(512) Not Null Comment '案例描述',
  `status` Bit Not Null Default 1 Comment '状态',
  `create_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '创建时间',
  `update_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '更新时间',
  Primary Key (`id`)
)Comment = '应用案例';

Drop Table If Exists `recruit`;
Create Table `recruit`(
  `id` Int Unsigned Not Null Auto_Increment,
  `name` Varchar(24) Not Null Comment '案例名称',
  `description` Varchar(512) Not Null Comment '案例描述',
  `status` Bit Not Null Default 1 Comment '状态',
  `create_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '创建时间',
  `update_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '更新时间',
  Primary Key (`id`)
)Comment = '招聘表';

Drop Table If Exists `recruit_item`;
Create Table `recruit_item`(
  `id` Int Unsigned Not Null Auto_Increment,
  `recruit_id` Int Unsigned Not Null,
  `description` Varchar(512) Not Null Comment '案例描述',
  `Status` Bit Not Null Default 1 Comment '状态',
  `sorted` Int Not Null Comment '排序',
  `create_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '创建时间',
  `update_time`  DateTime Not Null  DEFAULT CURRENT_TIMESTAMP Comment '更新时间',
  Primary Key (`id`),
  Constraint `fk_RecruitId` Foreign Key(`recruit_id`) References `recruit`(`id`)
)Comment = '招聘条件表';

Insert admin(`username`,`password`,`nickname`) Values('admin','$2a$10$LB5DH3mm0oq5ZA.ziD7v/.JzycwbP/dba8uqGx2YSchhoxmFFEmw.','管理员');
Insert role(`name`,`code`,`description`,`available`) Values('超级管理员','admin','拥有最高权限',1);
Insert resource(`name`,`type`,`url`,`parent_id`,`sorted`,`icon`) values('系统管理',1,'#',0,10,'fa fa-gears');

Insert resource(`name`,`type`,`url`,`parent_id`,`sorted`,`icon`)
  values
    ('用户管理',1,'#',1,10,null),
    ('角色管理',1,'#',1,20,null),
    ('菜单管理',1,'#',1,30,null);
Insert resource(`name`,`type`,`url`,`parent_id`,`sorted`,`icon`) values('官网管理',1,'#',0,20,'fa fa-gears');
Insert resource(`name`,`type`,`url`,`parent_id`,`sorted`,`icon`)
  values
    ('招聘管理',1,'#',2,10,null),
    ('产品管理',1,'#',2,20,null),
    ('案例管理',1,'#',2,30,null);
Insert admin_role(`admin_id`,`role_id`) values(1,1);
Insert role_resource(`role_id`,`resource_id`)
  values
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (1,5),
    (1,6),
    (1,7),
    (1,8);


