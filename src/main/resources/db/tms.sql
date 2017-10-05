#管理员
CREATE TABLE `user_info` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `user_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `real_name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '真实姓名',
  `avatar` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` int(11) NOT NULL COMMENT '性别',
  `phone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `id_card` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门',
  `role_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 删除  0  未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

#首页功能模块
CREATE TABLE `home_page_module` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '模块名称',
  `icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `content` varchar(1000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `subject` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 下线  0 上线）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='首页功能表';

#景区景点
CREATE TABLE `scenic_spot` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '景区名称',
  `icon` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `level` int(11) NOT NULL COMMENT '景区级别（1 景区  2 景点）',
  `parent_id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '父景区id',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `content` varchar(1000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `subject` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 删除  0 未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='景区表';

#景区资源
CREATE TABLE `scenic_spot_resource` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `data_id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '景区id',
  `sourceUrl` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '资源地址',
  `type` int(11) NOT NULL COMMENT '资源类型（1 图片  2 视频  3 音频）',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 删除  0 未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='景区资源';

#游客须知
CREATE TABLE `custom_notice` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `content` varchar(1000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `subject` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `phone` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 删除  0 未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='游客须知表';

#用户反馈
CREATE TABLE `feed_back` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
  `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `image_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片',
  `content` varchar(1000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `subject` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `phone` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
  `create_time` TIMESTAMP NULL COMMENT '创建时间',
  `modify_time` TIMESTAMP NULL COMMENT '更新时间',
  `flag_delete` int(11) DEFAULT NULL COMMENT '是否删除（1 删除  0 未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='游客须知表';
