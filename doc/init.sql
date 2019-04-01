
Drop Table If Exists `user`;
CREATE TABLE `user` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `Nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `Mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) Comment = '用户表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `Description` varchar(100) DEFAULT NULL,
  `Available` tinyint(1) DEFAULT '0',
  `Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '角色表';

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
	`Id` int unsigned NOT NULL AUTO_INCREMENT,
	`Userid` int unsigned NOT NULL,
	`Roleid` int unsigned NOT NULL,
	`Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
	`Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`Id`),
	Constraint `fk_UserRole_UID` Foreign Key(`Userid`) References `user`(`Id`),
	Constraint `fk_UserRole_RID` Foreign Key(`Roleid`) References `role`(`Id`)
) Comment = '用户角色表';


DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `parentId` bigint(20) unsigned DEFAULT '0',
  `sort` int unsigned DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '路径表';

DROP TABLE IF EXISTS `roleresources`;
CREATE TABLE `roleresources` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Roleid` int unsigned NOT NULL,
  `Resourcesid` int unsigned NOT NULL,
  `Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
	Constraint `fk_RoleResources_RoleID` Foreign Key(`Roleid`) References `role`(`Id`),
	Constraint `fk_RoleResources_RID` Foreign Key(`Resourcesid`) References `resources`(`Id`)
) Comment = '角色资源表';

