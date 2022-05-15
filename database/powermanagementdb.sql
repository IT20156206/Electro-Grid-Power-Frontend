-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 08:18 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powermanagementdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `powermanagement`
--

CREATE TABLE `powermanagement` (
  `PlanID` int(15) NOT NULL,
  `District` varchar(100) NOT NULL,
  `ConsumedPower` int(200) NOT NULL,
  `Month` varchar(20) NOT NULL,
  `Year` int(50) NOT NULL,
  `NoOfHours` int(50) NOT NULL,
  `NoOfDays` int(70) NOT NULL,
  `PowerSaved` int(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `powermanagement`
--
ALTER TABLE `powermanagement`
  ADD PRIMARY KEY (`PlanID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `powermanagement`
--
ALTER TABLE `powermanagement`
  MODIFY `PlanID` int(15) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
