/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : tdhy

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-02 10:16:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` varchar(255) NOT NULL COMMENT '图片id',
  `image_path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `width` varchar(255) DEFAULT NULL COMMENT '图片宽度',
  `height` varchar(255) DEFAULT NULL COMMENT '图片高度',
  `name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `tags` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `pic_key` varchar(255) DEFAULT NULL COMMENT '存储名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `content` varchar(10000) DEFAULT NULL COMMENT '文章内容',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `sort` int(255) NOT NULL COMMENT '文章分类',
  `sort_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '公司简介', '<p>天地华宇隶属于上汽物流板块，也是国家第一批&quot;AAAAA&quot;级资质的物流企业。截止2018年10月，天地华宇在全国约500个城市拥有74个货物转运中心、2500多家营业网点、近3000台自有运营车辆、4000多条运营线路、超过36万平米的仓库。总部上海华振物流有限公司，位于上海市闵行区华翔路2239号。天地华宇的运输部分全都交由上海华振物流有限公司的兄弟公司上海华振运输有限公司全权承运。</p>\r\n\r\n<p>　　天地华宇致力于打造成为国内领先和最值得信赖的高效物流服务提供商，业务范围覆盖：公路快运服务、仓储/供应链服务、信息技术解决方案等。</p>\r\n\r\n<p>　　天地华宇为中国公路快运行业的领先企业，其运营网络是中国最大的公路快运网络之一。公司服务产品包括：&quot;定日达&quot;、&quot;经济快运&quot;、&ldquo;易到家&rdquo;和&quot;专车达&quot;等，并提供代收货款等多种增值服务。&quot;定日达&quot;是天地华宇面向企业客户推出高端公路快运服务产品，以&quot;准时、安全、优质服务&quot;的特性，成为包括全球财富500强在内的众多企业级客户首选的公路快运产品之一。</p>\r\n\r\n<p>天地华宇运营管理的仓库面积超过36万平米，为各大电商企业提供优质的仓储和供应链服务。</p>\r\n\r\n<p>天地华宇旗下的信息技术服务企业，拥有成熟的O2O，公路快运、快递、仓储、供应链等IT系统的开发和管理能力，可为传统企业提供互联网转型的全套IT解决方案。</p>\r\n\r\n<p>天地华宇通过在服务端开拓自营和特许经营共赢的新商业模式，用一站式的&ldquo;易到家&rdquo;服务电商客户、结合在运营端推进&ldquo;运力小微化&rdquo;等项目，打造轻资产的互联网综合物流平台公司，提升总体业务能力和服务水平。</p>\r\n\r\n<p>天地华宇遵循&quot;以人为本&quot;的人才战略，不断加强员工的培训与职业规划，为全体员工提供良好的职业发展环境和广阔的发展平台，为客户提供最佳的服务体验。</p>\r\n\r\n<p>公司愿景</p>\r\n\r\n<p>成为客户信赖、员工自豪的综合物流服务提供商</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>公司使命</p>\r\n\r\n<p>全心承递</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>核心价值观</p>\r\n\r\n<p>诚信尊重 客户至上 团结协作 变革成长</p>', null, '1', '');
INSERT INTO `article` VALUES ('13', '一点到156', '<p>1</p>', null, '3', '华宇概述');

-- ----------------------------
-- Table structure for back_menu
-- ----------------------------
DROP TABLE IF EXISTS `back_menu`;
CREATE TABLE `back_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `status` int(1) DEFAULT '1',
  `sort` int(11) DEFAULT NULL COMMENT '导航栏排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of back_menu
-- ----------------------------
INSERT INTO `back_menu` VALUES ('1', '导航栏管理', 'fas fa-bars', '/admin/navigation/getAll', '0', '1', '1');
INSERT INTO `back_menu` VALUES ('2', '导航栏添加', null, '/admin/navigation/toAdd', '1', '1', '2');
INSERT INTO `back_menu` VALUES ('4', '产品栏管理', null, '/admin/inproduct/getAll', '0', '1', '4');
INSERT INTO `back_menu` VALUES ('5', '产品栏添加', null, '/admin/inproduct/toAdd', '4', '1', '5');
INSERT INTO `back_menu` VALUES ('7', '用户管理', null, '/admin/user/getAll', '0', '1', '7');
INSERT INTO `back_menu` VALUES ('8', '用户添加', null, '/admin/user/toadd', '7', '1', '8');
INSERT INTO `back_menu` VALUES ('10', '图片管理', null, '/admin/album/getAll', '0', '1', '10');
INSERT INTO `back_menu` VALUES ('11', '图片上传', null, '/admin/album/toupload', '10', '1', '11');
INSERT INTO `back_menu` VALUES ('12', '菜单管理', 'fab fa-500px', '/admin/menuGetAll', '0', '1', '12');
INSERT INTO `back_menu` VALUES ('13', '菜单添加', null, '/admin/menuToAdd', '12', '1', '13');
INSERT INTO `back_menu` VALUES ('17', '分类管理', 'fas fa-align-left', '/admin/sort/sortGetAll', '0', '1', null);
INSERT INTO `back_menu` VALUES ('18', '分类添加', '', '/admin/sort/sortToAdd', '17', '1', null);
INSERT INTO `back_menu` VALUES ('19', '文章管理', 'fas fa-bars', '/admin/article/articleGetAll', '0', '1', null);
INSERT INTO `back_menu` VALUES ('24', '文章添加', '', '/admin/article/articleToAdd', '19', '1', null);
INSERT INTO `back_menu` VALUES ('25', '活动管理', null, '/admin/inpromotion/getAll', '0', '1', null);
INSERT INTO `back_menu` VALUES ('26', '活动添加', null, '/admin/inpromotion/toAdd', '25', '1', null);
INSERT INTO `back_menu` VALUES ('27', '新闻管理', null, '/admin/innews/getAll', '0', '1', null);
INSERT INTO `back_menu` VALUES ('28', '新闻添加', null, '/admin/innews/toAdd', '27', '1', null);

-- ----------------------------
-- Table structure for in_news
-- ----------------------------
DROP TABLE IF EXISTS `in_news`;
CREATE TABLE `in_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻ID',
  `title` varchar(255) DEFAULT NULL COMMENT '新闻标题',
  `time` varchar(255) DEFAULT NULL COMMENT '新闻时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of in_news
-- ----------------------------
INSERT INTO `in_news` VALUES ('1', '天地华宇国内率先投放9.6米交换箱车...', '\r\n2019-11-11');
INSERT INTO `in_news` VALUES ('2', '天地华宇荣获金牛奖之品牌企业奖', '2019-10-29');
INSERT INTO `in_news` VALUES ('3', '天地华宇受邀第十四届中国（深圳）国际...', '2019-10-14');

-- ----------------------------
-- Table structure for in_product
-- ----------------------------
DROP TABLE IF EXISTS `in_product`;
CREATE TABLE `in_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '描述内容',
  `icon` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '图片',
  `icon_hover` varchar(255) CHARACTER SET utf8 NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '跳转地址',
  `sort` int(11) NOT NULL COMMENT '菜单排序',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '菜单启用状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of in_product
-- ----------------------------
INSERT INTO `in_product` VALUES ('1', '定日达', '说到做到，定日必达', '0 0', '0 -124px', '#', '1', '1');
INSERT INTO `in_product` VALUES ('2', '经济快运', '运输快捷，经济实用', '-153px 0', '-153px -124px', '#', '2', '2');
INSERT INTO `in_product` VALUES ('3', '易到家', '便捷高效，温馨到家', '-305px 0', '-305px -124px', '#', '3', '1');
INSERT INTO `in_product` VALUES ('4', '专车达', '专车保运，放心承运', '-458px 0', '-458px -124px', '#', '4', '1');
INSERT INTO `in_product` VALUES ('5', '代收货款', '货款回收，便捷安全', '-610px 0', '-610px -124px', '#', '5', '1');
INSERT INTO `in_product` VALUES ('6', '保价运输', '安全保价，放心托运', '-763px 0', '-763px -124px', '#', '1', '1');
INSERT INTO `in_product` VALUES ('7', '777', '777', '0 0', '0 -124px', '#', '52', '1');

-- ----------------------------
-- Table structure for in_promotion
-- ----------------------------
DROP TABLE IF EXISTS `in_promotion`;
CREATE TABLE `in_promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `image` varchar(255) DEFAULT NULL COMMENT '活动图片',
  `title` varchar(255) DEFAULT NULL COMMENT '活动标题',
  `status` varchar(255) DEFAULT NULL COMMENT '活动状态',
  `time` varchar(255) DEFAULT NULL COMMENT '活动时间',
  `place` varchar(255) DEFAULT NULL COMMENT '活动地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of in_promotion
-- ----------------------------
INSERT INTO `in_promotion` VALUES ('1', '/images/AaGRCUlswd.jpg', '双11锦鲤，7折等你', '进行中', '2019.10.28-2019.11.30', '所有直营网点　适用');
INSERT INTO `in_promotion` VALUES ('2', '/images/VJz82Ix0DB.jpg', '国庆钜惠，全场7折', '已结束', '2019.09.27-2019.10.31', '所有直营网点　适用');
INSERT INTO `in_promotion` VALUES ('3', '/images/OLpRzPLzpF.jpg', '开学大聚惠，7折放肆发', '已结束', '2019.08.29-2019.09.30', '所有直营网点　适用');
INSERT INTO `in_promotion` VALUES ('4', '/images/BI51dqrE3y.jpg', '感恩相伴，6折回馈', '已结束', '2019.08.29-2019.09.30', '所有直营网点　适用');

-- ----------------------------
-- Table structure for navigation
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `navName` varchar(255) DEFAULT NULL COMMENT '导航栏名称',
  `navIcon` varchar(255) DEFAULT NULL COMMENT '导航栏图片',
  `pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `isShow` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navigation
-- ----------------------------
INSERT INTO `navigation` VALUES ('1', '首页', '', '0', '#', null, null);
INSERT INTO `navigation` VALUES ('2', '我的华宇', '', '0', '#', null, null);
INSERT INTO `navigation` VALUES ('3', '自助服务', '', '0', '#', null, null);
INSERT INTO `navigation` VALUES ('4', '网上下单', '-207px 0', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('5', '批量下单', '-103px 0', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('6', '企业服务', '', '0', '#', null, null);
INSERT INTO `navigation` VALUES ('7', '特许经营', '', '0', '#', null, null);
INSERT INTO `navigation` VALUES ('8', '帮助与支持', null, '0', '#', null, null);
INSERT INTO `navigation` VALUES ('9', '批量下单', '-103px 0', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('10', '关于华宇', null, '0', '#', null, null);
INSERT INTO `navigation` VALUES ('11', '产品与服务', null, '0', '#', null, null);
INSERT INTO `navigation` VALUES ('12', '我的订单', '-311px 0', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('13', '我的理赔', '0 -57px', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('14', '我的资料管理', '-103px -57px', '2', '#', null, null);
INSERT INTO `navigation` VALUES ('15', '货物追踪', '-207px -57px', '3', '#', null, null);
INSERT INTO `navigation` VALUES ('16', '网点查询', '-311px -57px', '3', '#', null, null);
INSERT INTO `navigation` VALUES ('17', '价格时效查询', '-415px -57px', '3', '#', null, null);
INSERT INTO `navigation` VALUES ('18', '标签打印', '-519px -57px', '3', '#', null, null);
INSERT INTO `navigation` VALUES ('19', '主营产品', '0 -114px', '11', '#', null, null);
INSERT INTO `navigation` VALUES ('20', '增值服务', '-103px -114px', '11', '#', null, null);
INSERT INTO `navigation` VALUES ('21', '市场活动', '-207px -114px', '11', '#', null, null);
INSERT INTO `navigation` VALUES ('22', '电商合作', '0 -171px', '6', '#', null, null);
INSERT INTO `navigation` VALUES ('23', '开放平台', '-103px -171px', '6', '#', null, null);
INSERT INTO `navigation` VALUES ('24', '采购平台', '-207px -171px', '6', '#', null, null);
INSERT INTO `navigation` VALUES ('25', '经营资质', '-311px -171px', '7', '#', null, null);
INSERT INTO `navigation` VALUES ('26', '招商区域', '0 -228px', '7', '#', null, null);
INSERT INTO `navigation` VALUES ('27', '特许动态', '-103px -228px', '7', '#', null, null);
INSERT INTO `navigation` VALUES ('28', '在线报名', '-207px -228px', '7', '#', null, null);
INSERT INTO `navigation` VALUES ('29', '常见答疑', '-311px -228px', '8', '#', null, null);
INSERT INTO `navigation` VALUES ('30', '资料下载中心', '-415px -228px', '8', '#', null, null);
INSERT INTO `navigation` VALUES ('31', '咨询|建议|投诉', '-519px -228px', '8', '#', null, null);
INSERT INTO `navigation` VALUES ('32', '在线客服', '0 -285px', '8', '#', null, null);
INSERT INTO `navigation` VALUES ('33', '禁运品', '-103px -285px', '8', '#', null, null);
INSERT INTO `navigation` VALUES ('34', '华宇概述', '-207px -285px', '10', '#', null, null);
INSERT INTO `navigation` VALUES ('35', '华宇新闻', '-311px -285px', '10', '#', null, null);
INSERT INTO `navigation` VALUES ('36', '人才招聘', '-415px -285px', '10', '#', null, null);
INSERT INTO `navigation` VALUES ('37', '联系我们', '0 -343px', '10', '#', null, null);

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('1', '华宇概述');
INSERT INTO `sort` VALUES ('2', '华宇新闻');
INSERT INTO `sort` VALUES ('3', '人才招聘');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_tele` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `user_status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `user_code` varchar(255) NOT NULL COMMENT '激活码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', '324', null, '324', '1187382451@qq.com', '0', '0e5684dc301748f591ef3f2817d6d740');
INSERT INTO `user` VALUES ('10', '123123', '18160999831', '1', '1378476425@qq.com', '0', '4fe1e0079cc843a39e0e97792019c592');
INSERT INTO `user` VALUES ('11', '1', null, '1', '1378476425@qq.com', '0', '4');
