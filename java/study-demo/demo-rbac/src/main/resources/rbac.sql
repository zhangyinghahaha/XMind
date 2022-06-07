-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                        `password` VARCHAR(50) NOT NULL COMMENT '密码',
                        PRIMARY KEY (`user_id`)
) ENGINE=INNODB;

INSERT INTO `user`(username, `password`) VALUES ('admin', 'admin');
INSERT INTO `user`(username, `password`) VALUES ('root', 'root');
INSERT INTO `user`(username, `password`) VALUES ('user1', 'user1');
INSERT INTO `user`(username, `password`) VALUES ('user2', 'user2');
INSERT INTO `user`(username, `password`) VALUES ('user3', 'user3');
INSERT INTO `user`(username, `password`) VALUES ('user4', 'user4');
INSERT INTO `user`(username, `password`) VALUES ('user5', 'user5');
INSERT INTO `user`(username, `password`) VALUES ('user6', 'user6');
INSERT INTO `user`(username, `password`) VALUES ('user7', 'user7');
INSERT INTO `user`(username, `password`) VALUES ('user8', 'user8');
INSERT INTO `user`(username, `password`) VALUES ('user9', 'user9');

-- 角色表
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `role_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` VARCHAR(255) NOT NULL COMMENT '名称',
                        PRIMARY KEY (`role_id`)
) ENGINE=INNODB;

INSERT INTO `role` (`name`) VALUES ('管理员');
INSERT INTO `role` (`name`) VALUES ('普通用户');

-- 资源表
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
                            `resource_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` VARCHAR(255) NOT NULL COMMENT '名称',
                            `path` VARCHAR(255) NOT NULL COMMENT '路径',
                            `type` CHAR(1) NOT NULL COMMENT '类型(0菜单 1按钮)',
                            PRIMARY KEY (`resource_id`)
) ENGINE=INNODB;

INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/user', '查看用户', '0');
INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/user/add', '添加用户', '0');
INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/user/update', '修改用户', '0');
INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/user/delete', '删除用户', '0');
INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/data', '查看数据', '0');
INSERT INTO `resource` (`path`, `name`, `type`) VALUES ('/data/add', '添加数据', '0');

-- 用户角色表
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
                             `user_id` BIGINT(20) NOT NULL COMMENT '用户Id',
                             `role_id` BIGINT(20) NOT NULL COMMENT '角色Id',
                             PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=INNODB;

INSERT INTO `user_role` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 2);

-- 角色资源表
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
                                 `role_id` BIGINT(20) NOT NULL COMMENT '角色Id',
                                 `resource_id` BIGINT(20) NOT NULL COMMENT '资源Id',
                                 PRIMARY KEY (`role_id`, `resource_id`)
) ENGINE=INNODB;

INSERT INTO `role_resource` (role_id, resource_id) VALUES (1, 1);
INSERT INTO `role_resource` (role_id, resource_id) VALUES (1, 2);
INSERT INTO `role_resource` (role_id, resource_id) VALUES (1, 3);
INSERT INTO `role_resource` (role_id, resource_id) VALUES (1, 4);
INSERT INTO `role_resource` (role_id, resource_id) VALUES (2, 5);
INSERT INTO `role_resource` (role_id, resource_id) VALUES (2, 6);
