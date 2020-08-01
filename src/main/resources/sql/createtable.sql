CREATE TABLE `t_author` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `real_name` varchar(32) NOT NULL COMMENT '用户名称',
  `nick_name` varchar(32) NOT NULL COMMENT '用户匿名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `lastName` varchar(255) COMMENT '员工名称',
  `email` varchar(255) COMMENT '员工邮箱',
	`gender` int(2) COMMENT '员工性别',
	`d_id` int(11) COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `departmentName` varchar(255) COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;