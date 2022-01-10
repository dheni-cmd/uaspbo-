-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 06:23 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `kategori_kd` varchar(45) NOT NULL,
  `kategori` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kategori_kd`, `kategori`) VALUES
('01', 'Obat Batuk'),
('02', 'Obat Flu'),
('03', 'Obat Demam'),
('04', 'Obat Diare');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `obat_kd` varchar(45) NOT NULL,
  `obat` varchar(45) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `kategori_kd` varchar(45) NOT NULL,
  `tgl_kadaluarsa` varchar(45) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`obat_kd`, `obat`, `jumlah`, `kategori_kd`, `tgl_kadaluarsa`, `harga`) VALUES
('K_O/000001', 'Komix', 100, '01', '2025-07-31', 2000),
('K_O/000002', 'Procole', 100, '02', '2025-07-31', 10000),
('K_O/000003', 'Bodrexin', 100, '03', '2025-07-31', 10000),
('K_O/000004', 'Diapet', 100, '04', '2025-07-31', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `petugas_kd` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`petugas_kd`, `username`, `password`) VALUES
('KP/000001', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `transaksi_kd` varchar(45) NOT NULL,
  `tanggal_transaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`transaksi_kd`, `tanggal_transaksi`) VALUES
('KT/000001', '2020-07-04'),
('KT/000002', '2020-07-04'),
('KT/000003', '2020-07-04'),
('KT/000004', '2020-07-04'),
('KT/000005', '2020-07-04'),
('KT/000006', '2020-07-04'),
('KT/000007', '2020-07-04'),
('KT/000008', '2020-07-04'),
('KT/000009', '2020-07-04'),
('KT/000010', '2020-07-04'),
('KT/000011', '2020-07-04'),
('KT/000012', '2020-07-04'),
('KT/000013', '2020-07-04'),
('KT/000014', '2020-07-05'),
('KT/000015', '2020-07-05'),
('KT/000016', '2020-07-05'),
('KT/000017', '2020-07-05'),
('KT/000018', '2020-07-05'),
('KT/000019', '2020-07-05'),
('KT/000020', '2020-07-05'),
('KT/000021', '2020-07-05'),
('KT/000022', '2020-07-05'),
('KT/000023', '2020-07-05'),
('KT/000024', '2020-07-05'),
('KT/000025', '2020-07-05'),
('KT/000026', '2020-07-05'),
('KT/000027', '2020-07-05'),
('KT/000028', '2020-07-05'),
('KT/000029', '2020-07-05'),
('KT/000030', '2020-07-05'),
('KT/000031', '2020-07-05'),
('KT/000032', '2020-07-05'),
('KT/000033', '2020-07-05'),
('KT/000034', '2020-07-05'),
('KT/000035', '2020-07-05'),
('KT/000036', '2020-07-05'),
('KT/000037', '2020-07-05'),
('KT/000038', '2020-07-05'),
('KT/000039', '2020-07-05'),
('KT/000040', '2020-07-05'),
('KT/000041', '2020-07-05'),
('KT/000042', '2020-07-05'),
('KT/000043', '2020-07-05'),
('KT/000044', '2020-07-05'),
('KT/000045', '2020-07-05'),
('KT/000046', '2020-07-05'),
('KT/000047', '2020-07-11'),
('KT/000048', '2020-07-11'),
('KT/000049', '2020-07-11'),
('KT/000050', '2020-07-11');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_detil`
--

CREATE TABLE `transaksi_detil` (
  `transaksi_kd` varchar(45) NOT NULL,
  `obat_kd` varchar(45) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi_detil`
--

INSERT INTO `transaksi_detil` (`transaksi_kd`, `obat_kd`, `jumlah`, `harga`) VALUES
('KT/000001', 'K_O/000001', 2, 2000),
('KT/000001', 'K_O/000002', 1, 10000),
('KT/000001', 'K_O/000003', 1, 10000),
('KT/000002', 'K_O/000001', 2, 2000),
('KT/000003', 'K_O/000001', 2, 2000),
('KT/000004', 'K_O/000001', 2, 2000),
('KT/000005', 'K_O/000001', 2, 2000),
('KT/000006', 'K_O/000002', 1, 10000),
('KT/000006', 'K_O/000003', 1, 10000),
('KT/000007', 'K_O/000002', 1, 10000),
('KT/000007', 'K_O/000003', 1, 10000),
('KT/000008', 'K_O/000001', 1, 2000),
('KT/000008', 'K_O/000002', 2, 10000),
('KT/000009', 'K_O/000001', 2, 2000),
('KT/000010', 'K_O/000001', 1, 2000),
('KT/000011', 'K_O/000001', 1, 2000),
('KT/000012', 'K_O/000001', 1, 2000),
('KT/000013', 'K_O/000001', 1, 2000),
('KT/000013', 'K_O/000002', 1, 10000),
('KT/000014', 'K_O/000001', 1, 2000),
('KT/000014', 'K_O/000002', 2, 10000),
('KT/000015', 'K_O/000001', 2, 2000),
('KT/000016', 'K_O/000001', 2, 2000),
('KT/000016', 'K_O/000002', 2, 10000),
('KT/000017', 'K_O/000002', 2, 10000),
('KT/000017', 'K_O/000003', 2, 10000),
('KT/000018', 'K_O/000002', 2, 10000),
('KT/000018', 'K_O/000003', 2, 10000),
('KT/000019', 'K_O/000003', 2, 10000),
('KT/000020', 'K_O/000003', 2, 10000),
('KT/000021', 'K_O/000003', 2, 10000),
('KT/000022', 'K_O/000003', 2, 10000),
('KT/000023', 'K_O/000003', 2, 10000),
('KT/000024', 'K_O/000003', 1, 10000),
('KT/000025', 'K_O/000003', 1, 10000),
('KT/000026', 'K_O/000003', 1, 10000),
('KT/000027', 'K_O/000003', 2, 10000),
('KT/000028', 'K_O/000002', 1, 10000),
('KT/000029', 'K_O/000002', 2, 10000),
('KT/000030', 'K_O/000002', 2, 10000),
('KT/000031', 'K_O/000002', 1, 10000),
('KT/000032', 'K_O/000002', 1, 10000),
('KT/000033', 'K_O/000002', 2, 10000),
('KT/000034', 'K_O/000001', 2, 2000),
('KT/000035', 'K_O/000003', 2, 10000),
('KT/000036', 'K_O/000001', 1, 2000),
('KT/000037', 'K_O/000003', 1, 10000),
('KT/000038', 'K_O/000001', 2, 2000),
('KT/000039', 'K_O/000003', 2, 10000),
('KT/000040', 'K_O/000001', 2, 2000),
('KT/000041', 'K_O/000001', 2, 2000),
('KT/000042', 'K_O/000001', 2, 2000),
('KT/000043', 'K_O/000001', 1, 2000),
('KT/000044', 'K_O/000001', 2, 2000),
('KT/000045', 'K_O/000001', 1, 2000),
('KT/000046', 'K_O/000001', 1, 2000),
('KT/000047', 'K_O/000001', 2, 2000),
('KT/000048', 'K_O/000001', 3, 2000),
('KT/000049', 'K_O/000001', 2, 2000),
('KT/000050', 'K_O/000001', 2, 2000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kategori_kd`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`obat_kd`),
  ADD KEY `fk_kategorikd_obat_idx` (`kategori_kd`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`petugas_kd`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`transaksi_kd`);

--
-- Indexes for table `transaksi_detil`
--
ALTER TABLE `transaksi_detil`
  ADD PRIMARY KEY (`transaksi_kd`,`obat_kd`),
  ADD KEY `fk_obat_kd_idx` (`obat_kd`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `fk_kategorikd_obat` FOREIGN KEY (`kategori_kd`) REFERENCES `kategori` (`kategori_kd`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_detil`
--
ALTER TABLE `transaksi_detil`
  ADD CONSTRAINT `fk_obat_kd` FOREIGN KEY (`obat_kd`) REFERENCES `obat` (`obat_kd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_transaksi_kd` FOREIGN KEY (`transaksi_kd`) REFERENCES `transaksi` (`transaksi_kd`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
