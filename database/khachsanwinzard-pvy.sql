-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2022 at 04:46 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khachsanwinzard`
--

-- --------------------------------------------------------

--
-- Table structure for table `calam`
--

CREATE TABLE `calam` (
  `maca` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `gioBD` time NOT NULL,
  `gioKT` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `macv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tencv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `luong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctdatph`
--

CREATE TABLE `ctdatph` (
  `maCTDat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maPH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctdichvu`
--

CREATE TABLE `ctdichvu` (
  `maPhieuDV` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `madv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysudung` date NOT NULL,
  `soluong` int(11) NOT NULL,
  `thanhtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dichvu`
--

CREATE TABLE `dichvu` (
  `madv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maloaidv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tendv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(11) NOT NULL,
  `donvitinh` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maCTDat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maKM` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngaylapHD` date NOT NULL,
  `tienphong` int(11) NOT NULL,
  `tongtien` int(11) NOT NULL,
  `tienKM` int(11) NOT NULL,
  `thuctra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadondph`
--

CREATE TABLE `hoadondph` (
  `maCTDat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maKH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngaydat` date NOT NULL,
  `ngayden` date NOT NULL,
  `ngaydi` date NOT NULL,
  `tienphong` int(11) NOT NULL,
  `tiencoc` int(11) NOT NULL,
  `tennguoidat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `cmndnguoidat` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadonhuy`
--

CREATE TABLE `hoadonhuy` (
  `maphieuhuy` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maCTD` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngayhuy` date NOT NULL,
  `lido` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tenKH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinhKH` date NOT NULL,
  `sdtKH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `maKM` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `TenKM` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phantramKM` int(11) NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaidv`
--

CREATE TABLE `loaidv` (
  `maloaidv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tenloaidv` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loaiphong`
--

CREATE TABLE `loaiphong` (
  `maloaiPH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `TenLoai` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `Soluongtoida` int(11) NOT NULL,
  `dientich` float NOT NULL,
  `dongia` int(11) NOT NULL,
  `mota` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `macv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tennv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `gioitinh` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phancong`
--

CREATE TABLE `phancong` (
  `maca` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `ngayBD` date NOT NULL,
  `ngaKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phong`
--

CREATE TABLE `phong` (
  `maPH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maloaiPH` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `manv` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `tendangnhap` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `maphanquyen` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `calam`
--
ALTER TABLE `calam`
  ADD PRIMARY KEY (`maca`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`macv`);

--
-- Indexes for table `ctdatph`
--
ALTER TABLE `ctdatph`
  ADD PRIMARY KEY (`maCTDat`),
  ADD KEY `maPH` (`maPH`);

--
-- Indexes for table `ctdichvu`
--
ALTER TABLE `ctdichvu`
  ADD PRIMARY KEY (`maPhieuDV`,`madv`),
  ADD KEY `madv` (`madv`);

--
-- Indexes for table `dichvu`
--
ALTER TABLE `dichvu`
  ADD PRIMARY KEY (`madv`),
  ADD KEY `maloaidv` (`maloaidv`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `maCTDat` (`maCTDat`),
  ADD KEY `manv` (`manv`),
  ADD KEY `maKM` (`maKM`);

--
-- Indexes for table `hoadondph`
--
ALTER TABLE `hoadondph`
  ADD PRIMARY KEY (`maCTDat`),
  ADD KEY `maKH` (`maKH`),
  ADD KEY `manv` (`manv`);

--
-- Indexes for table `hoadonhuy`
--
ALTER TABLE `hoadonhuy`
  ADD PRIMARY KEY (`maphieuhuy`),
  ADD KEY `maCTD` (`maCTD`),
  ADD KEY `manv` (`manv`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`maKM`);

--
-- Indexes for table `loaidv`
--
ALTER TABLE `loaidv`
  ADD PRIMARY KEY (`maloaidv`);

--
-- Indexes for table `loaiphong`
--
ALTER TABLE `loaiphong`
  ADD PRIMARY KEY (`maloaiPH`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`(255)),
  ADD KEY `manv` (`manv`),
  ADD KEY `macv` (`macv`);

--
-- Indexes for table `phancong`
--
ALTER TABLE `phancong`
  ADD PRIMARY KEY (`maca`,`manv`),
  ADD KEY `manv` (`manv`);

--
-- Indexes for table `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`maPH`),
  ADD KEY `maloaiPH` (`maloaiPH`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `maphanquyen` (`maphanquyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
