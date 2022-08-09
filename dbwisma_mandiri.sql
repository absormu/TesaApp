-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2022 at 03:56 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbwisma_mandiri`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_config`
--

CREATE TABLE `tb_config` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `pegawai_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_config`
--

INSERT INTO `tb_config` (`id`, `nama`, `pegawai_id`) VALUES
(1, 'Tesalonika Kalangi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id_pegawai` int(18) NOT NULL,
  `nama_pengguna` varchar(50) NOT NULL,
  `ktp` varchar(20) DEFAULT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `id_jabatan` varchar(18) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `nama_pengguna`, `ktp`, `nama_pegawai`, `id_jabatan`, `password`) VALUES
(1, 'admin', '0', 'Tesalonika Kalangi', 'Administrasi', 'admin'),
(2, 'absor', '0', 'M Ulil Absor', 'Administrasi', 'absor'),
(3, 'malika', '0', 'Malika Nur Fadia', 'Administrasi', '123'),
(4, 'nana', '0', 'Farah Nana Setia', 'Administrasi', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penyewa`
--

CREATE TABLE `tb_penyewa` (
  `id` int(50) NOT NULL,
  `ktp` varchar(20) DEFAULT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `no_tlp` varchar(15) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penyewa`
--

INSERT INTO `tb_penyewa` (`id`, `ktp`, `nama`, `email`, `no_tlp`, `alamat`) VALUES
(1, '0123456789123456', 'Amanda Manopo', 'amanda@gmail.com', '081291808440', 'Jl. Ir. H Juanda No.50 Jakarta Barat'),
(2, '121232423423', 'Nabila Karisma', 'nabila_karisma@gmail.com', '082158451534', 'JL. Harapan Jaya No.90A Tangerang Banten'),
(3, '7894561230', 'Ali Akbar', 'ali@gmail.com', '081234568880', 'Jl. Sudirman No.23 Batang Jawa Tengah');

-- --------------------------------------------------------

--
-- Table structure for table `tb_ruang`
--

CREATE TABLE `tb_ruang` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `luas` int(10) NOT NULL,
  `deskripsi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ruang`
--

INSERT INTO `tb_ruang` (`id`, `nama`, `harga`, `luas`, `deskripsi`) VALUES
(1, 'Aula Serbaguna', 3500000, 200, 'Aula Serbaguna Lt Dasar Blok A1'),
(2, 'Aula Serbaguna Rooftop', 2500000, 100, 'Aula Serbaguna Rooftop A3'),
(3, 'Meeting Room', 2000000, 50, 'Meeting Room VIP');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sewa`
--

CREATE TABLE `tb_sewa` (
  `no_sewa` varchar(20) NOT NULL,
  `tgl_sewa` varchar(20) NOT NULL,
  `periode_awal` varchar(20) NOT NULL,
  `periode_akhir` varchar(20) NOT NULL,
  `periode_total` int(5) NOT NULL,
  `harga` int(20) NOT NULL,
  `total` int(20) NOT NULL,
  `say_total` varchar(50) DEFAULT NULL,
  `ruang_id` int(10) NOT NULL,
  `penyewa_id` int(10) NOT NULL,
  `pegawai_id` int(10) NOT NULL,
  `status_id` int(20) NOT NULL DEFAULT '2',
  `tgl_pembayaran` varchar(20) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_sewa`
--

INSERT INTO `tb_sewa` (`no_sewa`, `tgl_sewa`, `periode_awal`, `periode_akhir`, `periode_total`, `harga`, `total`, `say_total`, `ruang_id`, `penyewa_id`, `pegawai_id`, `status_id`, `tgl_pembayaran`, `created_at`, `created_by`) VALUES
('20090101001', '01/01/2009', '2009-01-01', '2009-01-01', 1, 3500000, 3500000, NULL, 1, 1, 1, 1, '06/08/2022', '2009-01-01 01:17:09', 'Tesalonika Kalangi'),
('20090101002', '01/01/2009', '2009-01-01', '2009-01-03', 3, 2500000, 7500000, NULL, 2, 3, 1, 1, '06/08/2022', '2009-01-01 01:13:53', 'Tesalonika Kalangi'),
('20220801001', '01/08/2022', '2022-08-01', '2022-08-02', 2, 3500000, 7000000, NULL, 1, 1, 1, 1, '06/08/2022', '2022-08-01 20:55:06', 'Tesalonika Kalangi'),
('20220805001', '05/08/2022', '2022-08-06', '2022-08-07', 6, 2500000, 15000000, NULL, 2, 2, 1, 1, '06/08/2022', '2022-08-05 01:15:46', 'Tesalonika Kalangi'),
('20220805002', '05/08/2022', '2022-08-05', '2022-08-05', 5, 2000000, 10000000, 'sepuluh juta rupiah', 3, 1, 1, 1, '06/08/2022', '2022-08-05 08:16:09', 'Tesalonika Kalangi'),
('20220805003', '05/08/2022', '2022-08-01', '2022-08-05', 5, 2500000, 12500000, 'Dua Juta Lima Ratus Ribu Rupiah', 2, 1, 1, 1, '05/08/2022', '2022-08-05 08:27:31', 'Tesalonika Kalangi'),
('20220805004', '05/08/2022', '2022-08-31', '2022-08-31', 1, 2000000, 2000000, 'dua juta rupiah', 3, 3, 1, 1, '06/08/2022', '2022-08-05 10:07:19', 'Tesalonika Kalangi'),
('20220806001', '06/08/2022', '2022-08-06', '2022-08-06', 1, 3500000, 3500000, NULL, 1, 2, 1, 2, NULL, '2022-08-06 15:52:26', 'Tesalonika Kalangi');

-- --------------------------------------------------------

--
-- Table structure for table `tb_status`
--

CREATE TABLE `tb_status` (
  `id` int(10) NOT NULL,
  `status` varchar(20) NOT NULL,
  `deskripsi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_status`
--

INSERT INTO `tb_status` (`id`, `status`, `deskripsi`) VALUES
(1, 'Paid', 'Sudah bayar'),
(2, 'Unpaid', 'Belum bayar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_config`
--
ALTER TABLE `tb_config`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_ruang`
--
ALTER TABLE `tb_ruang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_sewa`
--
ALTER TABLE `tb_sewa`
  ADD PRIMARY KEY (`no_sewa`),
  ADD KEY `FK_ruangID` (`ruang_id`),
  ADD KEY `FK_penyewaID` (`penyewa_id`),
  ADD KEY `FK_status` (`status_id`),
  ADD KEY `FK_PersonOrder` (`pegawai_id`);

--
-- Indexes for table `tb_status`
--
ALTER TABLE `tb_status`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_config`
--
ALTER TABLE `tb_config`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_penyewa`
--
ALTER TABLE `tb_penyewa`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_ruang`
--
ALTER TABLE `tb_ruang`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_sewa`
--
ALTER TABLE `tb_sewa`
  ADD CONSTRAINT `FK_PersonOrder` FOREIGN KEY (`pegawai_id`) REFERENCES `tb_pegawai` (`id_pegawai`),
  ADD CONSTRAINT `FK_penyewaID` FOREIGN KEY (`penyewa_id`) REFERENCES `tb_penyewa` (`id`),
  ADD CONSTRAINT `FK_ruangID` FOREIGN KEY (`ruang_id`) REFERENCES `tb_ruang` (`id`),
  ADD CONSTRAINT `FK_status` FOREIGN KEY (`status_id`) REFERENCES `tb_status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
