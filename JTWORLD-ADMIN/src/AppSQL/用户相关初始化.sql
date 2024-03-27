# 后台用户表
DROP TABLE IF EXISTS `jt_admin`;
CREATE TABLE `jt_admin`  (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
                              `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                              `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
                              `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
                              `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户表' ROW_FORMAT = DYNAMIC;

# 后台用户登录日志表
DROP TABLE IF EXISTS `jt_admin_login_log`;
CREATE TABLE `jt_admin_login_log`  (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `admin_id` bigint(20) NULL DEFAULT NULL,
                                        `create_time` datetime NULL DEFAULT NULL,
                                        `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                        `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                        `user_agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 413 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = DYNAMIC;

# 后台用户权限关系表
DROP TABLE IF EXISTS `jt_admin_permission_relation`;
CREATE TABLE `jt_admin_permission_relation`  (
                                                  `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                                  `admin_id` bigint(20) NULL DEFAULT NULL,
                                                  `permission_id` bigint(20) NULL DEFAULT NULL,
                                                  `type` int(1) NULL DEFAULT NULL,
                                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和权限关系表(除角色中定义的权限以外的加减权限)' ROW_FORMAT = DYNAMIC;

# 后台用户权限表
DROP TABLE IF EXISTS `jt_permission`;
CREATE TABLE `jt_permission`  (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级权限id',
                                   `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
                                   `value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
                                   `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
                                   `type` int(1) NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
                                   `uri` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
                                   `status` int(1) NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户权限表' ROW_FORMAT = DYNAMIC;

# 后台用户角色关系表
DROP TABLE IF EXISTS `jt_admin_role_relation`;
CREATE TABLE `jt_admin_role_relation`  (
                                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                            `admin_id` bigint(20) NULL DEFAULT NULL,
                                            `role_id` bigint(20) NULL DEFAULT NULL,
                                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和角色关系表' ROW_FORMAT = DYNAMIC;

# 后台用户角色表
DROP TABLE IF EXISTS `jt_role`;
CREATE TABLE `jt_role`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
                             `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
                             `admin_count` int(11) NULL DEFAULT NULL COMMENT '后台用户数量',
                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `status` int(1) NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
                             `sort` int(11) NULL DEFAULT 0,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色表' ROW_FORMAT = DYNAMIC;

# 后台用户角色与权限关系表
DROP TABLE IF EXISTS `jt_role_permission_relation`;
CREATE TABLE `jt_role_permission_relation`  (
                                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                                 `role_id` bigint(20) NULL DEFAULT NULL,
                                                 `permission_id` bigint(20) NULL DEFAULT NULL,
                                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户角色和权限关系表' ROW_FORMAT = DYNAMIC;
