#--------用户信息表--------#
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE user_info(
  `user_id` CHAR(32) NOT NULL COMMENT '用户ID/用户名',
  `password` VARCHAR(15) NOT NULL COMMENT '登录密码',
  `phone` CHAR(11) NOT NULL COMMENT '手机号',
  `user_name` VARCHAR(15) NOT NULL COMMENT '真实姓名',
  `birthday` Date NOT NULL COMMENT '生日',
  `gmt_create` DATETIME NOT NULL DEFAULT now() COMMENT '写入时间',
  `author_create` CHAR(32) COMMENT '创建人ID',
  `gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
  `author_modified` CHAR(32) COMMENT '修改人',
  `org_id` CHAR(36) COMMENT '组织机构ID',
  `email` CHAR(100) COMMENT 'EMAIL邮箱',
  `delete_flag` INT(1) NOT NULL DEFAULT 0 COMMENT '是否删除[0未删除|1删除]',
  `is_first_login` INT(1) NOT NULL DEFAULT 0 COMMENT '是否删除[0未删除|1删除]',
  PRIMARY KEY (user_id),
  KEY idx_user_id(user_name),
  KEY idx_org_id(org_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';


#--------车辆信息表--------#
DROP TABLE IF EXISTS `vehicle_info`;
CREATE TABLE vehicle_info(
  `vehicle_id` CHAR(20) NOT NULL PRIMARY KEY COMMENT '车辆ID,车牌号+车牌颜色',
  `license_plate` CHAR(20) NOT NULL COMMENT '车牌号',
  `license_plate_color` CHAR(2) NOT NULL COMMENT '车牌颜色',
  `sim_id` CHAR(11) COMMENT 'SIM卡号',
  `termianl_id` CHAR(20) COMMENT '终端编号',
  `org_id` CHAR(36) COMMENT '组织机构编号',
  `vehicle_type_id` CHAR(36) COMMENT '车辆类型',
  `scrapped_flag` INT(1) NOT NULL DEFAULT 0 COMMENT '是否报废[0不报废|1报废]',
  `org_using` CHAR(36) COMMENT '所使用的组织结构编号',
  `gmt_create` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `author_create` CHAR(32) COMMENT '创建人',
  `gmt_modified` DATETIME COMMENT '修改时间',
  `author_modified` CHAR(32) COMMENT '修改人',
  `delete_flag` INT(1) NOT NULL DEFAULT 0 COMMENT '是否删除[0未删除|1删除]',
  KEY idx_vehicle_id(vehicle_id),
  KEY idx_sim_id(sim_id),
  KEY idx_terminal_id(termianl_id),
  KEY idx_org_id(org_id)
)ENGINE=InnoDB CHARSET=utf8 COMMENT '车辆信息表';


#--------登录信息表--------#
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE user_login(
  `user_login_id` int(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` CHAR(32) NOT NULL,
  `login_time` DATETIME NOT NULL DEFAULT now() COMMENT '登录时间',
  `logout_time` DATETIME COMMENT '登出时间',
  constraint FK_user_id foreign key(user_id) references user_info(user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8 COMMENT '登录信息表';



#--------组织机构表--------#
DROP TABLE IF EXISTS `organization_info`;
CREATE TABLE organization_info(
  `org_id` CHAR(36) NOT NULL PRIMARY KEY COMMENT '组织机构ID',
  `org_name` CHAR(255) NOT NULL COMMENT '组织机构名称',
  `delete_flag` INT(1) NOT NULL DEFAULT 0 COMMENT '是否删除[0未删除|1删除]',
  `gmt_create` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
  `create_by` CHAR(16) NOT NULL COMMENT '创建人',
  `gmt_modified` DATETIME COMMENT '修改时间',
  `modified_by` CHAR(16) COMMENT '修改人',
  `is_hidden` INT(1) NOT NULL DEFAULT 0 COMMENT '是否隐藏[不隐藏0|隐藏1]',
  `logtitude` DECIMAL(9,6) NOT NULL COMMENT '经度',
  `latitude` DECIMAL(9,6) NOT NULL COMMENT '纬度'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '组织机构表';


#--------用户角色表--------#
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE role_info(
  `user_role_id` INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '用户角色ID',
  `user_id` CHAR(32) COMMENT '用户ID',
  `role_id` INT(10) COMMENT '角色ID,还没想好都要啥'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色表';


#--------终端信息表--------#
DROP TABLE IF EXISTS `terminal_info`;
CREATE TABLE terminal_info(
  `terminal_id` CHAR(20) NOT NULL COMMENT '终端编号',
  `terminal_type_id` INT NOT NULL COMMENT '终端类型[808,TQ,HQ,ET08]',
  `gmt_create` DATETIME NOT NULL DEFAULT now() COMMENT '写入时间',
  `author_create` CHAR(32) COMMENT '创建人',
  `gmt_modified` DATETIME COMMENT '修改日期',
  `delete_flag` INT(1) NOT NULL DEFAULT 0 COMMENT '删除标志[未删除0|删除1]'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '终端信息表';