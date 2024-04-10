
USE `demo_crud_api`;

CREATE TABLE `milk_branch` (
  `Milk_branch_id` varchar(20) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Milk_branch_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `milk_type` (
  `Milk_type_id` varchar(3) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Milk_type_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `milk` (
  `Milk_id` varchar(6) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Milk_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Milk_branch_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Milk_type_id` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `Weight` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Nutrition_facts` text COLLATE utf8_unicode_ci NOT NULL,
  `Benefits` text COLLATE utf8_unicode_ci NOT NULL,
  `Picture` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  KEY `Milk_branch_id` (`Milk_branch_id`),
  KEY `Milk_type_id` (`Milk_type_id`),
  CONSTRAINT `sua_ibfk_1` FOREIGN KEY (`Milk_branch_id`) REFERENCES `milk_branch` (`Milk_branch_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sua_ibfk_2` FOREIGN KEY (`Milk_type_id`) REFERENCES `milk_type` (`Milk_type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;