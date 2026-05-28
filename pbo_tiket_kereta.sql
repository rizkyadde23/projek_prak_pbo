-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2026 at 12:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_tiket_kereta`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `id_kereta` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` time DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `kursi_tersedia` int(11) DEFAULT NULL,
  `asal` varchar(100) DEFAULT NULL,
  `tujuan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `id_kereta`, `tanggal`, `jam`, `harga`, `kursi_tersedia`, `asal`, `tujuan`) VALUES
(1, 1, '2026-05-20', '08:00:00', 450000, 48, 'Jakarta', 'Surabaya'),
(2, 2, '2026-05-21', '09:30:00', 350000, 39, 'Yogyakarta', 'Jakarta'),
(3, 3, '2026-05-22', '13:15:00', 250000, 59, 'Solo', 'Bandung'),
(4, 4, '2026-05-23', '18:00:00', 400000, 30, 'Semarang', 'Jakarta'),
(5, 5, '2026-05-24', '07:45:00', 275000, 44, 'Malang', 'Yogyakarta'),
(6, 6, '2026-05-25', '10:00:00', 500000, 30, 'Bandung', 'Surabaya'),
(7, 7, '2026-05-26', '12:30:00', 300000, 55, 'Purwokerto', 'Jakarta'),
(8, 8, '2026-05-27', '15:00:00', 375000, 24, 'Jakarta', 'Solo'),
(9, 9, '2026-05-28', '17:45:00', 425000, 49, 'Surabaya', 'Bandung'),
(11, 5, '2026-06-11', '22:10:00', 250000, 100, 'Malang', 'Yogyakarta'),
(12, 6, '2026-06-10', '12:00:00', 350000, 100, 'Bandung', 'Surabaya'),
(14, 8, '2026-07-12', '12:00:00', 350000, 100, 'Yogyakarta', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `kereta`
--

CREATE TABLE `kereta` (
  `id_kereta` int(11) NOT NULL,
  `nama_kereta` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kereta`
--

INSERT INTO `kereta` (`id_kereta`, `nama_kereta`) VALUES
(1, 'Argo Bromo Anggrek'),
(2, 'Taksaka'),
(3, 'Malioboro Express'),
(4, 'Senja Utama'),
(5, 'Lodaya'),
(6, 'Gajayana'),
(7, 'Sri Tanjung'),
(8, 'Turangga'),
(9, 'Jayabaya');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_jadwal` int(11) DEFAULT NULL,
  `jumlah_tiket` int(11) DEFAULT NULL,
  `total_harga` double DEFAULT NULL,
  `tanggal_pesan` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `id_user`, `id_jadwal`, `jumlah_tiket`, `total_harga`, `tanggal_pesan`) VALUES
(1, 2, 1, 2, 900000, '2026-05-09 17:00:00'),
(2, 3, 2, 1, 350000, '2026-05-10 17:00:00'),
(3, 4, 3, 3, 750000, '2026-05-10 17:00:00'),
(4, 5, 4, 1, 400000, '2026-05-11 17:00:00'),
(5, 6, 5, 2, 550000, '2026-05-11 17:00:00'),
(6, 7, 6, 1, 500000, '2026-05-12 17:00:00'),
(7, 8, 7, 4, 1200000, '2026-05-12 17:00:00'),
(8, 9, 8, 2, 750000, '2026-05-13 17:00:00'),
(9, 10, 9, 1, 425000, '2026-05-13 17:00:00'),
(11, 3, 6, 5, 2500000, '2026-05-15 06:04:23'),
(13, 2, 6, 1, 500000, '2026-05-25 06:42:14'),
(14, 2, 1, 5, 2250000, '2026-05-26 08:31:48'),
(15, 2, 1, 1, 450000, '2026-05-26 08:45:11'),
(16, 2, 9, 1, 425000, '2026-05-27 14:08:28'),
(17, 2, 5, 1, 275000, '2026-05-27 14:31:54'),
(18, 2, 1, 1, 450000, '2026-05-28 04:47:40'),
(19, 2, 8, 1, 375000, '2026-05-28 05:26:16'),
(20, 3, 3, 1, 250000, '2026-05-28 05:27:43');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('admin','user') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `username`, `password`, `role`) VALUES
(1, 'Admin Utama', 'admin', 'admin123', 'admin'),
(2, 'Rizky Ramadhan', 'rizky', '1234', 'user'),
(3, 'Budi Santoso', 'budi', '1234', 'user'),
(4, 'Siti Aminah', 'siti', '1234', 'user'),
(5, 'Andi Saputra', 'andi', '1234', 'user'),
(6, 'Dewi Lestari', 'dewi', '1234', 'user'),
(7, 'Fajar Nugroho', 'fajar', '1234', 'user'),
(8, 'Nabila Putri', 'nabila', '1234', 'user'),
(9, 'Yoga Pratama', 'yoga', '1234', 'user'),
(10, 'Cahyo Wijaya', 'cahyo', '1234', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_kereta` (`id_kereta`);

--
-- Indexes for table `kereta`
--
ALTER TABLE `kereta`
  ADD PRIMARY KEY (`id_kereta`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_jadwal` (`id_jadwal`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `kereta`
--
ALTER TABLE `kereta`
  MODIFY `id_kereta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_pemesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_kereta`) REFERENCES `kereta` (`id_kereta`) ON DELETE CASCADE;

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `pemesanan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `pemesanan_ibfk_2` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal` (`id_jadwal`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
