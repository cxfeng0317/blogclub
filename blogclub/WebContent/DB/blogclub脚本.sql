/*
SQLyog Ultimate v9.10 
MySQL - 5.1.44-community : Database - blogclub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogclub` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blogclub`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) DEFAULT NULL,
  `areaID` varchar(6) NOT NULL,
  `areas` varchar(40) DEFAULT NULL COMMENT '区县名称',
  `cityID` varchar(6) DEFAULT NULL COMMENT '城市ID',
  PRIMARY KEY (`areaID`),
  KEY `FK_area` (`cityID`),
  CONSTRAINT `FK_area` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `area` */

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客编号（博客条码）',
  `kid` int(11) DEFAULT NULL COMMENT 'blogKind(kid)',
  `uid` int(11) DEFAULT NULL COMMENT 'user(uid)',
  `title` varchar(200) NOT NULL COMMENT '名称',
  `schema` varchar(500) NOT NULL COMMENT '概要',
  `content` text NOT NULL COMMENT '详情',
  `clicks` int(11) NOT NULL COMMENT '点击量',
  `datetime` datetime NOT NULL COMMENT '博客发表时间',
  PRIMARY KEY (`id`),
  KEY `FK_blog_1` (`kid`),
  KEY `FK_blog_2` (`uid`),
  CONSTRAINT `FK_blog_1` FOREIGN KEY (`kid`) REFERENCES `blogkind` (`id`),
  CONSTRAINT `FK_blog_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`kid`,`uid`,`title`,`schema`,`content`,`clicks`,`datetime`) values (3,1,3,'aaaa','aaa','aaaa',1,'2019-10-04 16:17:18'),(4,1,3,'1111','2222','11111',6,'2019-10-04 16:17:18'),(5,2,1,'sdfsda','asdfsad','dfsdafsdfsdafsd',213,'2019-02-12 00:00:00'),(6,3,4,'asdasd','asdasdsda','asdasdasdasdasdasdddddddddddddddddddddddddd',55,'2019-02-12 00:00:00'),(7,3,4,'12321',' 2123','2132132133333333333333',11,'2019-02-12 00:00:00'),(8,3,1,'周边便民电话整理','便民电话','<p style=\"text-align:center;\">\r\n	<strong><em><span style=\"font-size:24px;\">周边便民电话</span></em></strong>\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	<strong><em><span style=\"font-size:24px;\"><span style=\"font-size:9px;\"><span style=\"font-size:14px;\">\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		原标题：八提“不容易”，习近平这篇重要文章意味深长\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		10月1日出版的第19期《求是》杂志发表中共中央总书记、国家主席、中央军委主席习近平的重要。\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		这是习近平2018年1月5日在新进中央委员会的委员、候补委员和省部级主要领导干部学习贯彻习近平新时代中国特色社会主义思想和党的十九大精神研讨班上讲话的一部分。\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		在这篇近万字的长文中，习近平8次提到“不容易”，意味深长。\r\n	</p>\r\n	<div class=\"img_wrapper\" style=\"margin:0px;padding:0px;text-align:center;color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		<span class=\"img_descr\" style=\"line-height:20px;font-size:16px;font-weight:700;\">2018年1月5日，习近平在学习贯彻党的十九大精神研讨班开班式上发表重要讲话。新华社记者 鞠鹏&nbsp;摄</span>\r\n	</div>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		<span style=\"font-weight:700 !important;\">◎“能打败我们的只有我们自己”</span>\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		为什么要抓党的建设？\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		习近平一语中的：\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		“马克思主义政党夺取政权不容易，巩固政权更不容易；只要马克思主义执政党不出问题，社会主义国家就出不了大问题，我们就能够跳出‘其兴也勃焉，其亡也忽焉’的历史周期率。”\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		在回顾秦、汉、唐、清的兴衰更替史和李自成、李秀成等中国历史上的农民起义后，习近平又连提4个“不容易”：\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		功成名就时做到居安思危、保持创业初期那种励精图治的精神状态不容易，\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		执掌政权后做到节俭内敛、敬终如始不容易，\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		承平时期严以治吏、防腐戒奢不容易，\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		重大变革关头顺乎潮流、顺应民心不容易。\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		习近平指出，我们党和国家的性质宗旨同封建王朝、农民起义军有着本质区别，不可简单类比，但以史为鉴可以知兴替。\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		“我们党是世界上最大的政党，大就要有大的样子，同时大也有大的难处。”习近平再次感叹“不容易”：把这么大的一个党管好很不容易，把这么大的一个党建设成为坚强的马克思主义执政党更不容易。\r\n	</p>\r\n	<p style=\"color:#4D4F53;font-family:&quot;font-size:18px;background-color:#FFFFFF;\">\r\n		“我们党有8900多万名党员、450多万个基层党组织，我看能打败我们的只有我们自己，没有第二人。”\r\n	</p>\r\n</span></span><br />\r\n</span></em></strong>\r\n</p>',0,'2019-10-07 18:29:33'),(9,1,5,'揭秘阅兵“第100方队”','中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！','<span style=\"color:#333333;font-family:Arial, 宋体;font-size:16px;background-color:#FFFFFF;\">中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！</span><span style=\"color:#333333;font-family:Arial, 宋体;font-size:16px;background-color:#FFFFFF;\">中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！</span><span style=\"color:#333333;font-family:Arial, 宋体;font-size:16px;background-color:#FFFFFF;\">中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！</span><span style=\"color:#333333;font-family:Arial, 宋体;font-size:16px;background-color:#FFFFFF;\">中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！</span><span style=\"color:#333333;font-family:Arial, 宋体;font-size:16px;background-color:#FFFFFF;\">中央广播电视总台以“世界一流 历史最好”为标准，呈现国庆70周年视听盛宴！庆典活动直播总导演在手记中说：国庆当天，军方地方，加起来会有99个方梯队和方阵，在天安门前接受检阅。那天，我们去直播检阅，其实也是在接受检阅。我们要努力拿出高水平的直播，当好第100个“方队”！</span>',0,'2019-10-07 21:21:23');

/*Table structure for table `blogkind` */

DROP TABLE IF EXISTS `blogkind`;

CREATE TABLE `blogkind` (
  `id` int(11) NOT NULL COMMENT '博客类别编号',
  `name` varchar(20) NOT NULL COMMENT '博客类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blogkind` */

insert  into `blogkind`(`id`,`name`) values (1,'原创'),(2,'经典'),(3,'转载');

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) DEFAULT NULL,
  `cityID` varchar(6) NOT NULL,
  `city` varchar(40) DEFAULT NULL COMMENT '城市名称',
  `provinceID` varchar(6) DEFAULT NULL COMMENT '省份ID',
  PRIMARY KEY (`cityID`),
  KEY `FK_city` (`provinceID`),
  CONSTRAINT `FK_city` FOREIGN KEY (`provinceID`) REFERENCES `province` (`provinceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '评论人',
  `bid` int(11) NOT NULL COMMENT '博客编号',
  `ip` varchar(100) NOT NULL COMMENT '评论时机器ip',
  `datetime` datetime NOT NULL COMMENT '日期',
  `content` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`),
  KEY `FK_comment_1` (`uid`),
  KEY `FK_comment_2` (`bid`),
  CONSTRAINT `FK_comment_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_comment_2` FOREIGN KEY (`bid`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`uid`,`bid`,`ip`,`datetime`,`content`) values (4,3,3,'111','2019-10-05 15:40:11','aaaaaaa'),(5,3,3,'111','2019-10-05 15:40:14','aaaaaaa'),(6,4,4,'sadf','2019-10-05 21:16:41','asdf');

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) DEFAULT NULL,
  `provinceID` varchar(6) NOT NULL,
  `province` varchar(40) DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`provinceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `province` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `pass` varchar(50) NOT NULL COMMENT '密码',
  `sex` char(1) NOT NULL DEFAULT 'f' COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `tel` varchar(15) NOT NULL COMMENT '电话',
  `provinceId` varchar(6) DEFAULT NULL COMMENT '省(直辖市)代码',
  `cityId` varchar(6) DEFAULT NULL COMMENT '市(自治区)代码',
  `areaId` varchar(6) DEFAULT NULL COMMENT '区(县)代码',
  `inputdate` datetime NOT NULL COMMENT '注册时间',
  `ip` varchar(100) NOT NULL COMMENT '注册时机器IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`pass`,`sex`,`age`,`tel`,`provinceId`,`cityId`,`areaId`,`inputdate`,`ip`) values (1,'admin','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:29:03','123.123.123.123'),(3,'aa','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:28:27','123.123.123.123'),(4,'bb','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:09:33','123.123.123.123'),(5,'curry','123','f',22,'12312321','0','0','0','2019-10-06 10:55:55','0:0:0:0:0:0:0:1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
