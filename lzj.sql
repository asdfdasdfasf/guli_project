/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 5.5.36 : Database - guli
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`guli` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `guli`;

/*Table structure for table `edu_chapter` */

DROP TABLE IF EXISTS `edu_chapter`;

CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `edu_chapter` */

insert  into `edu_chapter`(`id`,`course_id`,`title`,`sort`,`gmt_create`,`gmt_modified`) values 
('1','14','第一章：HTML',0,'2019-01-01 12:27:40','2019-01-01 12:55:30'),
('1181729226915577857','18','第七章：I/O流',70,'2019-10-09 08:32:58','2019-10-09 08:33:20'),
('1192252428399751169','1192252213659774977','第一章节',0,'2019-11-07 09:28:25','2019-11-07 09:28:25'),
('15','18','第一章：Java入门',0,'2019-01-01 12:27:40','2019-10-09 09:13:19'),
('1539173223143436289','1539172863548899330','第一章：语言的艺术',1,'2022-06-21 17:07:47','2022-06-21 17:07:47'),
('1539173578979799042','1539172863548899330','第一章：语言的艺术',1,'2022-06-21 17:09:12','2022-06-21 17:09:12'),
('1539174687874084866','1539172863548899330','111',0,'2022-06-21 17:13:36','2022-06-21 17:13:36'),
('1539175132390551554','1539172863548899330','2222',0,'2022-06-21 17:15:22','2022-06-21 17:15:22'),
('1539175586423959553','1539172863548899330','3333',1,'2022-06-21 17:17:10','2022-06-21 17:17:10'),
('1539187861490823169','1539187840045346818','11111',0,'2022-06-21 18:05:57','2022-06-21 18:05:57'),
('1539191823686205441','1539191808809009154','11',0,'2022-06-21 18:21:42','2022-06-21 18:21:42'),
('1539191836269117441','1539191808809009154','22',0,'2022-06-21 18:21:45','2022-06-21 18:21:45'),
('1539191851725127681','1539191808809009154','333',0,'2022-06-21 18:21:48','2022-06-21 18:21:48'),
('1539191880766488577','1539191808809009154','44',0,'2022-06-21 18:21:55','2022-06-21 18:21:55'),
('1539192217900449794','1539192201592995842','11',0,'2022-06-21 18:23:16','2022-06-21 18:23:16'),
('1539192490903502850','1539192201592995842','222',0,'2022-06-21 18:24:21','2022-06-21 18:24:21'),
('1539192517054988290','1539192201592995842','3333',0,'2022-06-21 18:24:27','2022-06-21 18:24:27'),
('1539192545710473218','1539192201592995842','444',0,'2022-06-21 18:24:34','2022-06-21 18:24:34'),
('1539193202119049218','1539192201592995842','11',0,'2022-06-21 18:27:10','2022-06-21 18:27:10'),
('1539791655194853377','1539779922539597825','12333333',0,'2022-06-23 10:05:13','2022-06-23 10:05:16'),
('1539791688715730945','1539779922539597825','1111123123123123',0,'2022-06-23 10:05:21','2022-06-23 10:05:26'),
('1539893067530694658','1539886952776527873','11111',0,'2022-06-23 16:48:11','2022-06-23 17:05:33'),
('1544643825513811970','1544641617258893313','111',0,'2022-07-06 19:26:00','2022-07-06 19:26:00'),
('3','14','第二章：CSS',0,'2019-01-01 12:55:35','2019-01-01 12:27:40'),
('32','18','第二章：控制台输入和输出',0,'2019-01-01 12:27:40','2019-01-01 12:27:40'),
('44','18','第三章：控制流',0,'2019-01-01 12:27:40','2019-01-01 12:27:40'),
('48','18','第四章：类的定义',0,'2019-01-01 12:27:40','2019-01-01 12:27:40'),
('63','18','第五章：数组',0,'2019-01-01 12:27:40','2019-01-01 12:27:40'),
('64','18','第六章：继承',61,'2019-01-01 12:27:40','2019-10-09 08:32:47');

/*Table structure for table `edu_comment` */

DROP TABLE IF EXISTS `edu_comment`;

CREATE TABLE `edu_comment` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';

/*Data for the table `edu_comment` */

insert  into `edu_comment`(`id`,`course_id`,`teacher_id`,`member_id`,`nickname`,`avatar`,`content`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1194499162790211585','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','课程很好',0,'2019-11-13 14:16:08','2019-11-13 14:16:08'),
('1194898406466420738','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','11',0,'2019-11-14 16:42:35','2019-11-14 16:42:35'),
('1194898484388200450','1192252213659774977','1189389726308478977','1','小三123','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','111',0,'2019-11-14 16:42:53','2019-11-14 16:42:53'),
('1195251020861317122','1192252213659774977','1189389726308478977','1',NULL,NULL,'2233',0,'2019-11-15 16:03:45','2019-11-15 16:03:45'),
('1195251382720700418','1192252213659774977','1189389726308478977','1',NULL,NULL,'4455',0,'2019-11-15 16:05:11','2019-11-15 16:05:11'),
('1195252819177570306','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','55',0,'2019-11-15 16:10:53','2019-11-15 16:10:53'),
('1195252899448160258','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','55',0,'2019-11-15 16:11:13','2019-11-15 16:11:13'),
('1195252920587452417','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','223344',0,'2019-11-15 16:11:18','2019-11-15 16:11:18'),
('1195262128095559681','14','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','11',0,'2019-11-15 16:47:53','2019-11-15 16:47:53'),
('1196264505170767874','1192252213659774977','1189389726308478977','1','小三1231','http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132','666666',0,'2019-11-18 11:10:58','2019-11-18 11:10:58');

/*Table structure for table `edu_course` */

DROP TABLE IF EXISTS `edu_course`;

CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint(3) DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `edu_course` */

insert  into `edu_course`(`id`,`teacher_id`,`subject_id`,`subject_parent_id`,`title`,`price`,`lesson_num`,`cover`,`buy_count`,`view_count`,`version`,`status`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1192252213659774977','1189389726308478977','1178214681139539969','1178214681118568449','java基础课程：test',0.01,2,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/cover/default.gif',4,387,1,'Normal',0,'2019-11-07 09:27:33','2019-11-18 13:35:03'),
('14','1189389726308478977','1101348944971091969','1101348944920760321','XHTML CSS2 JS整站制作教程课程学习',0.00,3,'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/d0086eb0-f2dc-45f7-bba1-744d95e5be0f.jpg',3,44,15,'Normal',0,'2018-04-02 18:33:34','2019-11-16 21:21:45'),
('15','1189389726308478977','1101348944971091969','1101348944920760321','HTML5入门课程学习',0.00,23,'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/22997b8e-3606-4d2e-9b4f-09f48418b6e4.jpg',0,51,17,'Normal',0,'2018-04-02 18:34:32','2019-11-12 10:19:20'),
('1535842850632142849','','','','111',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-12 12:34:04','2022-06-12 12:34:04'),
('1535869928530317313','','','','1111111111111111111111111111',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-12 14:21:40','2022-06-12 14:21:40'),
('1535873516694474754','1189426437876985857','','','测试讲师下拉列表',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-12 14:35:56','2022-06-12 14:35:56'),
('1536252887615766530','1189426437876985857','1178585108407984130','1178214681118568449','最终测试数据',2.00,10,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-13 15:43:25','2022-06-13 15:43:25'),
('1536579569035800578','','','','',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-14 13:21:32','2022-06-14 13:21:32'),
('1536582412799078401','','1178585108407984130','1178214681118568449','',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-14 13:32:50','2022-06-14 13:32:50'),
('1536596720232697857','1','1178214681139539969','1178214681118568449','heheh',5.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-14 14:29:41','2022-06-14 14:29:41'),
('1536603204442132482','1192249914833055746','1178214681294729217','1178214681231814658','Lucy1111',2.00,5,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-14 14:55:27','2022-06-14 15:00:40'),
('1539064449644675074','1192249914833055746','1178585108407984130','1178214681118568449','我是测试数据',5.00,10,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 09:55:33','2022-06-21 09:55:33'),
('1539118701918339074','1189426437876985857','1178214681294729217','1178214681231814658','test',0.00,3,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 13:31:08','2022-06-21 13:31:08'),
('1539172863548899330','1189390295668469762','1178214681139539969','1178214681118568449','嘻嘻哈哈',1.00,3,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 17:06:21','2022-06-21 17:06:21'),
('1539187840045346818','1189390295668469762','1178585108454121473','1178214681181483010','111',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 18:05:52','2022-06-21 18:05:52'),
('1539191808809009154','1189426437876985857','1178585108454121473','1178214681181483010','11111',0.00,5,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 18:21:38','2022-06-21 18:21:38'),
('1539192201592995842','1189390295668469762','','1178214681181483010','123123123',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-21 18:23:12','2022-06-21 18:23:12'),
('1539779922539597825','1189390295668469762','1178585108454121473','1178214681181483010','111',0.00,2,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-23 09:18:35','2022-06-23 09:18:35'),
('1539886952776527873','1189389726308478977','','1178214681181483010','1123',0.00,0,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-06-23 16:23:53','2022-06-23 16:42:06'),
('1544641617258893313','1189389726308478977','1178585108407984130','1178214681118568449','123',3.00,2,'/static/01.jpg',0,0,1,'Draft',NULL,'2022-07-06 19:17:14','2022-07-06 19:17:14'),
('18','1189389726308478977','1178214681139539969','1178214681118568449','Java精品课程',0.01,20,'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/06/866e9aca-b530-4f71-a690-72d4a4bfd1e7.jpg',151,737,6,'Normal',0,'2018-04-02 21:28:46','2019-11-18 11:14:52');

/*Table structure for table `edu_course_collect` */

DROP TABLE IF EXISTS `edu_course_collect`;

CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程收藏';

/*Data for the table `edu_course_collect` */

insert  into `edu_course_collect`(`id`,`course_id`,`member_id`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1196269345666019330','1192252213659774977','1',1,'2019-11-18 11:30:12','2019-11-18 11:30:12');

/*Table structure for table `edu_course_description` */

DROP TABLE IF EXISTS `edu_course_description`;

CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

/*Data for the table `edu_course_description` */

insert  into `edu_course_description`(`id`,`description`,`gmt_create`,`gmt_modified`) values 
('1104870479077879809','<p>11</p>','2019-03-11 06:23:44','2019-03-11 06:23:44'),
('1192252213659774977','<p>测试</p>','2019-11-07 09:27:33','2019-11-13 16:21:28'),
('14','','2019-03-13 06:04:43','2019-03-13 06:05:33'),
('15','','2019-03-13 06:03:33','2019-03-13 06:04:22'),
('1535842850632142849','111','2022-06-12 12:34:04','2022-06-12 12:34:04'),
('1535869928530317313','111111111111111111111111111','2022-06-12 14:21:40','2022-06-12 14:21:40'),
('1535873516694474754','1111','2022-06-12 14:35:56','2022-06-12 14:35:56'),
('1536252887615766530','测试课程数据','2022-06-13 15:43:25','2022-06-13 15:43:25'),
('1536579569035800578','','2022-06-14 13:21:32','2022-06-14 13:21:32'),
('1536582412799078401','','2022-06-14 13:32:50','2022-06-14 13:32:50'),
('1536596720232697857','hehehehe','2022-06-14 14:29:41','2022-06-14 14:29:41'),
('1536603204442132482','Lucy','2022-06-14 14:55:27','2022-06-14 15:00:40'),
('1539064449644675074','这个课程针对的就是测试','2022-06-21 09:55:33','2022-06-21 09:55:33'),
('1539118701918339074','test','2022-06-21 13:31:08','2022-06-21 13:31:08'),
('1539172863548899330','11111','2022-06-21 17:06:21','2022-06-21 17:06:21'),
('1539187840045346818','1111','2022-06-21 18:05:52','2022-06-21 18:05:52'),
('1539191808809009154','123123','2022-06-21 18:21:38','2022-06-21 18:21:38'),
('1539192201592995842','1234234','2022-06-21 18:23:12','2022-06-21 18:23:12'),
('1539779922539597825','1111','2022-06-23 09:18:35','2022-06-23 09:18:35'),
('1539886952776527873','123123','2022-06-23 16:23:53','2022-06-23 16:42:06'),
('1544641617258893313','12321313123','2022-07-06 19:17:14','2022-07-06 19:17:14'),
('18','<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>','2019-03-06 18:06:36','2019-10-30 19:58:36');

/*Table structure for table `edu_subject` */

DROP TABLE IF EXISTS `edu_subject`;

CREATE TABLE `edu_subject` (
  `id` char(19) CHARACTER SET utf8mb4 NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) CHARACTER SET utf8mb4 NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `edu_subject` */

insert  into `edu_subject`(`id`,`title`,`parent_id`,`sort`,`gmt_create`,`gmt_modified`) values 
('1178214681118568449','后端开发','0',1,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681139539969','Java','1178214681118568449',1,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681181483010','前端开发','0',3,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681210843137','JavaScript','1178214681181483010',4,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681231814658','云计算','0',5,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681252786178','Docker','1178214681231814658',5,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681294729217','Linux','1178214681231814658',6,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681324089345','系统/运维','0',7,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681353449473','Linux','1178214681324089345',7,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681382809602','Windows','1178214681324089345',8,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681399586817','数据库','0',9,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681428946945','MySQL','1178214681399586817',9,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681454112770','MongoDB','1178214681399586817',10,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681483472898','大数据','0',11,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681504444418','Hadoop','1178214681483472898',11,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681529610242','Spark','1178214681483472898',12,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681554776066','人工智能','0',13,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681584136193','Python','1178214681554776066',13,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681613496321','编程语言','0',14,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178214681626079234','Java','1178214681613496321',14,'2019-09-29 15:47:25','2019-09-29 15:47:25'),
('1178585108407984130','Python','1178214681118568449',2,'2019-09-30 16:19:22','2019-09-30 16:19:22'),
('1178585108454121473','HTML/CSS','1178214681181483010',3,'2019-09-30 16:19:22','2019-09-30 16:19:22');

/*Table structure for table `edu_teacher` */

DROP TABLE IF EXISTS `edu_teacher`;

CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师';

/*Data for the table `edu_teacher` */

insert  into `edu_teacher`(`id`,`name`,`intro`,`career`,`level`,`avatar`,`sort`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1','老六','近年主持国家自然科学基金（6项）、江苏省重大科技成果转化项目（5项）、江苏省产学研前瞻性联合研究项目（3项）、省工业科技支撑、省高技术、省自然科学基金等省部级及其企业的主要科研项目40多个，多个项目在企业成功转化，产生了较好的经济、社会和环境效益。积极开展产学研科技合作，并与省内16家企业建立了江苏省研究生工作站，其中6家为江苏省优秀研究生工作站','高级',1,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg',0,0,'2019-10-30 14:18:46','2019-11-12 13:36:36'),
('1189389726308478977','晴天','高级讲师简介','高级讲师资历',2,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/de47ee9b-7fec-43c5-8173-13c5f7f689b2.png',1,0,'2019-10-30 11:53:03','2019-10-30 11:53:03'),
('1189390295668469762','李刚','高级讲师简介','高级讲师',2,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/b8aa36a2-db50-4eca-a6e3-cc6e608355e0.png',2,0,'2019-10-30 11:55:19','2019-11-12 13:37:52'),
('1189426437876985857','王二','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/08/e44a2e92-2421-4ea3-bb49-46f2ec96ef88.png',0,0,'2019-10-30 14:18:56','2019-11-12 13:37:35'),
('1189426464967995393','王五','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/65423f14-49a9-4092-baf5-6d0ef9686a85.png',0,0,'2019-10-30 14:19:02','2019-11-12 13:37:18'),
('1192249914833055746','李四','高级讲师简介','高级讲师',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/07/91871e25-fd83-4af6-845f-ea8d471d825d.png',0,0,'2019-11-07 09:18:25','2019-11-12 13:37:01'),
('1192327476087115778','1222-12-12','1111','11',1,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/08/5805c6cd-c8ad-4a77-aafd-d2e083bfd8a4.png',0,1,'2019-11-07 14:26:37','2019-11-11 16:26:26'),
('1195337453429129218','test','sdfsdf','sdfdf',1,'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg',0,1,'2019-11-15 21:47:12','2019-11-15 21:47:27'),
('1533364500139388930','11','111','11',1,'',0,1,'2022-06-05 16:26:00','2022-06-05 16:26:00'),
('1533365256733110273','1112222','1111','11111',1,'',1,0,'2022-06-05 16:29:00','2022-06-05 18:55:07'),
('1533365998307037185','181111111','111','11',1,'',2,0,'2022-06-05 16:31:57','2022-06-05 17:44:04'),
('1534513836835487745','1111111111111111111','1111111111111111111','11111111111',2,'https://kyrie-file.oss-cn-hangzhou.aliyuncs.com/2022/06/08/file.png370afe0590844b99952d6246455fc22c',0,0,'2022-06-08 20:33:03','2022-06-08 20:33:03');

/*Table structure for table `edu_video` */

DROP TABLE IF EXISTS `edu_video`;

CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频';

/*Data for the table `edu_video` */

insert  into `edu_video`(`id`,`course_id`,`chapter_id`,`title`,`video_source_id`,`video_original_name`,`sort`,`play_count`,`is_free`,`duration`,`status`,`size`,`version`,`gmt_create`,`gmt_modified`) values 
('1182499307429339137','18','32','第一节','','',0,0,0,0,'',0,1,'2019-10-11 11:32:59','2019-10-11 11:57:38'),
('1185312444399071234','14','1','12','','',0,0,0,0,'Empty',0,1,'2019-10-19 05:51:23','2019-10-19 05:51:33'),
('1189434737808990210','18','44','测试','','',1,0,0,0,'Empty',0,1,'2019-10-30 14:51:55','2019-10-30 14:51:55'),
('1189471423678939138','18','1181729226915577857','test','2b887dc9584d4dc68908780ec57cd3b9','视频',1,0,0,0,'Empty',0,1,'2019-10-30 17:17:41','2019-10-30 17:17:41'),
('1189476403626409986','18','1181729226915577857','22','5155c73dc112475cbbddccf4723f7cef','视频.mp4',0,0,0,0,'Empty',0,1,'2019-10-30 17:37:29','2019-10-30 17:37:29'),
('1192252824606289921','1192252213659774977','1192252428399751169','第一课时','756cf06db9cb4f30be85a9758b19c645','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,'Empty',0,1,'2019-11-07 09:29:59','2019-11-07 09:29:59'),
('1192628092797730818','1192252213659774977','1192252428399751169','第二课时','2a02d726622f4c7089d44cb993c531e1','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,1,0,'Empty',0,1,'2019-11-08 10:21:10','2019-11-08 10:21:22'),
('1192632495013380097','1192252213659774977','1192252428399751169','第三课时','4e560c892fdf4fa2b42e0671aa42fa9d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,1,0,'Empty',0,1,'2019-11-08 10:38:40','2019-11-08 10:38:40'),
('1194117638832111617','1192252213659774977','1192252428399751169','第四课时','4e560c892fdf4fa2b42e0671aa42fa9d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,'Empty',0,1,'2019-11-12 13:00:05','2019-11-12 13:00:05'),
('1196263770832023554','1192252213659774977','1192252428399751169','第五课时','27d21158b0834cb5a8d50710937de330','eae2b847ef8503b81f5d5593d769dde2.mp4',5,0,0,0,'Empty',0,1,'2019-11-18 11:08:03','2019-11-18 11:08:03'),
('1539886453654351873','18','1181729226915577857','1','','',1,0,0,0,'Empty',0,1,'2022-06-23 16:21:54','2022-06-23 16:21:54'),
('1539901176856768514','1539886952776527873','1539893067530694658','123123','','',0,0,0,0,'Empty',0,1,'2022-06-23 17:20:25','2022-06-23 17:20:25'),
('1544644897879904258','1544641617258893313','1544643825513811970','5645641','','',0,0,0,0,'Empty',0,1,'2022-07-06 19:30:16','2022-07-06 19:37:53'),
('1544646720791531522','1544641617258893313','1544643825513811970','1212','','',0,0,0,0,'Empty',0,1,'2022-07-06 19:37:31','2022-07-06 19:37:31'),
('17','18','15','第一节：Java简介','196116a6fee742e1ba9f6c18f65bd8c1','1',1,1000,1,100,'Draft',0,1,'2019-01-01 13:08:57','2019-10-11 11:26:39'),
('18','18','15','第二节：表达式和赋值语句','2d99b08ca0214909899910c9ba042d47','7 - How Do I Find Time for My ',2,999,1,100,'Draft',0,1,'2019-01-01 13:09:02','2019-03-08 03:30:27'),
('19','18','15','第三节：String类','51120d59ddfd424cb5ab08b44fc8b23a','eae2b847ef8503b81f5d5593d769dde2.mp4',3,888,0,100,'Draft',0,1,'2019-01-01 13:09:05','2019-11-12 12:50:45'),
('20','18','15','第四节：程序风格','2a38988892d84df598752226c50f3fa3','00-day10总结.avi',4,666,0,100,'Draft',0,1,'2019-01-01 13:09:05','2019-10-11 09:20:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
