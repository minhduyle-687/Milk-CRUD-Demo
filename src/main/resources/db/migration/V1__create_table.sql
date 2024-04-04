
USE `demo_crud_api`;

CREATE TABLE `hang_sua` (
  `Ma_hang_sua` varchar(20) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Ten_hang_sua` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Dia_chi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Dien_thoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `loai_sua` (
  `Ma_loai_sua` varchar(3) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Ten_loai_sua` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `sua` (
  `Ma_sua` varchar(6) PRIMARY KEY COLLATE utf8_unicode_ci NOT NULL,
  `Ten_sua` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_hang_sua` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_loai_sua` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `Trong_luong` int(11) NOT NULL,
  `Don_gia` int(11) NOT NULL,
  `Tp_dinh_duong` text COLLATE utf8_unicode_ci NOT NULL,
  `Loi_ich` text COLLATE utf8_unicode_ci NOT NULL,
  `Hinh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  KEY `Ma_hang_sua` (`Ma_hang_sua`),
  KEY `Ma_loai_sua` (`Ma_loai_sua`),
  CONSTRAINT `sua_ibfk_1` FOREIGN KEY (`Ma_hang_sua`) REFERENCES `hang_sua` (`Ma_hang_sua`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sua_ibfk_2` FOREIGN KEY (`Ma_loai_sua`) REFERENCES `loai_sua` (`Ma_loai_sua`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;