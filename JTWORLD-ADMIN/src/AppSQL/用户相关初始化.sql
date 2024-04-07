# 后台用户表
DROP TABLE IF EXISTS `jt_admin`;
CREATE TABLE `jt_admin`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `username`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `password`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `icon`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `email`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `nick_name`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `note`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `login_time`  datetime                                                NULL DEFAULT NULL COMMENT '最后登录时间',
    `status`      int(1)                                                  NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户表'
  ROW_FORMAT = DYNAMIC;

# 后台用户登录日志表
DROP TABLE IF EXISTS `jt_admin_login_log`;
CREATE TABLE `jt_admin_login_log`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `admin_id`    bigint(20)                                              NULL DEFAULT NULL,
    `create_time` datetime                                                NULL DEFAULT NULL,
    `ip`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `address`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `user_agent`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 413
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表'
  ROW_FORMAT = DYNAMIC;

# 后台用户权限关系表
DROP TABLE IF EXISTS `jt_admin_permission_relation`;
CREATE TABLE `jt_admin_permission_relation`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id`      bigint(20) NULL DEFAULT NULL,
    `permission_id` bigint(20) NULL DEFAULT NULL,
    `type`          int(1)     NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)'
  ROW_FORMAT = DYNAMIC;

# 后台用户权限表
DROP TABLE IF EXISTS `jt_permission`;
CREATE TABLE `jt_permission`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `pid`         bigint(20)                                              NULL DEFAULT NULL COMMENT '父级权限id',
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `value`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
    `icon`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
    `type`        int(1)                                                  NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `uri`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
    `status`      int(1)                                                  NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `sort`        int(11)                                                 NULL DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户权限表'
  ROW_FORMAT = DYNAMIC;

# 后台用户角色关系表
DROP TABLE IF EXISTS `jt_admin_role_relation`;
CREATE TABLE `jt_admin_role_relation`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) NULL DEFAULT NULL,
    `role_id`  bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 32
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表'
  ROW_FORMAT = DYNAMIC;

# 后台用户角色表
DROP TABLE IF EXISTS `jt_role`;
CREATE TABLE `jt_role`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
    `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `admin_count` int(11)                                                 NULL DEFAULT NULL COMMENT '后台用户数量',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `status`      int(1)                                                  NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
    `sort`        int(11)                                                 NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色表'
  ROW_FORMAT = DYNAMIC;

# 后台用户角色与权限关系表
DROP TABLE IF EXISTS `jt_role_permission_relation`;
CREATE TABLE `jt_role_permission_relation`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`       bigint(20) NULL DEFAULT NULL,
    `permission_id` bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台用户角色和权限关系表'
  ROW_FORMAT = DYNAMIC;

# 资源分类表
DROP TABLE IF EXISTS `jt_resource_category`;
CREATE TABLE `jt_resource_category`  (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                          `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
                                          `sort` int(4) NULL DEFAULT NULL COMMENT '排序',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源分类表' ROW_FORMAT = DYNAMIC;


# 资源表
DROP TABLE IF EXISTS `jt_resource`;
CREATE TABLE `jt_resource`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT,
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `name`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
    `url`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `category_id` bigint(20)                                              NULL DEFAULT NULL COMMENT '资源分类ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 33
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台资源表'
  ROW_FORMAT = DYNAMIC;


# 角色资源关系表
DROP TABLE IF EXISTS `jt_role_resource_relation`;
CREATE TABLE `jt_role_resource_relation`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`     bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
    `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 249
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '后台角色资源关系表'
  ROW_FORMAT = DYNAMIC;

### 新增资源分类信息
INSERT INTO `jt_resource_category` VALUES (1, '2020-02-05 10:21:44', '商品模块', 0);
INSERT INTO `jt_resource_category` VALUES (2, '2020-02-05 10:22:34', '订单模块', 0);
INSERT INTO `jt_resource_category` VALUES (3, '2020-02-05 10:22:48', '营销模块', 0);
INSERT INTO `jt_resource_category` VALUES (4, '2020-02-05 10:23:04', '权限模块', 0);
INSERT INTO `jt_resource_category` VALUES (5, '2020-02-07 16:34:27', '内容模块', 0);
INSERT INTO `jt_resource_category` VALUES (7, '2020-09-19 15:49:08', '其他模块', 0);

### 新增管理员，配置权限、角色、资源
INSERT INTO jt_admin (id, username, `password`, icon, email, nick_name, note, create_time, login_time, status)
VALUES (1, 'admin', '47b6ae57206d923d452844bbeb46316a', '', '2547236893@qq.com', 'JT管理员', '项目管理员最高权限',
        now(), null, 1);

INSERT INTO `jt_role`
VALUES (1, '超级管理员', '拥有所有查看和操作功能', 0, '2020-02-02 15:11:05', 1, 0);

INSERT INTO `jt_admin_role_relation`
VALUES (1, 1, 1);

INSERT INTO `jt_resource`
VALUES (1, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4);

INSERT INTO `jt_role_resource_relation`
VALUES (1, 1, 1);