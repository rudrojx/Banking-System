-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2022 at 05:51 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Age` int(10) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `Aadhar` varchar(12) NOT NULL,
  `DateofBirth` varchar(20) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `AccountType` varchar(255) NOT NULL,
  `AccountNo` varchar(255) NOT NULL,
  `CIF` varchar(255) NOT NULL,
  `BranchCode` varchar(100) NOT NULL,
  `OpeningDate` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Pin` int(6) NOT NULL,
  `Deposit` float(14,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ID`, `Name`, `Mobile`, `Age`, `Gender`, `Aadhar`, `DateofBirth`, `Email`, `AccountType`, `AccountNo`, `CIF`, `BranchCode`, `OpeningDate`, `Username`, `Password`, `Pin`, `Deposit`) VALUES
(1, 'Rajan Sen', '9740369850', 23, 'Male', '9870003156', '1999-06-24', 'raj@gmail.com', 'Saving', '811567699', '59009270', '1769', '19/06/2022 22:54:22', 'raj', '2438', 9624, 90577.00),
(2, 'Max Sen', '9744023590', 12, 'Male', '78941002369', '2010-07-27', 'max@gmail.com', 'Saving', '765256306', '66594545', '1769', '21/06/2022 15:57:13', 'max', '1505', 2669, 71500.00);

-- --------------------------------------------------------

--
-- Table structure for table `cesc`
--

CREATE TABLE `cesc` (
  `AccountNo` varchar(255) NOT NULL,
  `ConsumerNo` varchar(255) NOT NULL,
  `Amount` float(14,2) NOT NULL DEFAULT 0.00,
  `Date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cesc`
--

INSERT INTO `cesc` (`AccountNo`, `ConsumerNo`, `Amount`, `Date`) VALUES
('811567699', '6600053258', 1580.00, '22/06/2022');

-- --------------------------------------------------------

--
-- Table structure for table `cesccno`
--

CREATE TABLE `cesccno` (
  `AccountNo` varchar(255) NOT NULL,
  `ConsumerNo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cesccno`
--

INSERT INTO `cesccno` (`AccountNo`, `ConsumerNo`) VALUES
('811567699', '6600053258');

-- --------------------------------------------------------

--
-- Table structure for table `credit`
--

CREATE TABLE `credit` (
  `AccountNo` varchar(255) NOT NULL,
  `CardNO` varchar(255) NOT NULL,
  `HolderName` varchar(255) NOT NULL,
  `CVV` int(50) NOT NULL,
  `CardType` varchar(255) NOT NULL,
  `IssueDate` varchar(255) NOT NULL,
  `ExpiryDate` varchar(255) NOT NULL,
  `Balance` float(14,2) DEFAULT 0.00,
  `InterestRate` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `credit`
--

INSERT INTO `credit` (`AccountNo`, `CardNO`, `HolderName`, `CVV`, `CardType`, `IssueDate`, `ExpiryDate`, `Balance`, `InterestRate`) VALUES
('811567699', '7921822085', 'Rajan Sen', 244, 'Platinum', 'Sat Jun 26 00:00:00 IST 2021', 'Sun Jul 21 00:00:00 IST 2024', 150000.00, '2.6%'),
('765256306', '6299037592', 'Max Sen', 173, 'Platinum', 'Fri Jul 09 00:00:00 IST 2021', 'Fri Jul 18 00:00:00 IST 2025', 20000.00, '2.6%');

-- --------------------------------------------------------

--
-- Table structure for table `debit`
--

CREATE TABLE `debit` (
  `AccountNo` varchar(255) NOT NULL,
  `CardNO` varchar(255) NOT NULL,
  `HolderName` varchar(255) NOT NULL,
  `CVV` int(10) NOT NULL,
  `IssueDate` varchar(255) NOT NULL,
  `ExpiryDate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `debit`
--

INSERT INTO `debit` (`AccountNo`, `CardNO`, `HolderName`, `CVV`, `IssueDate`, `ExpiryDate`) VALUES
('811567699', '6717506924', 'Rajan Sen', 261, 'Mon Jul 19 00:00:00 IST 2021', 'Tue Aug 05 00:00:00 IST 2025'),
('765256306', '7019686024', 'Max Sen', 304, 'Fri Jul 16 00:00:00 IST 2021', 'Sat Aug 09 00:00:00 IST 2025');

-- --------------------------------------------------------

--
-- Table structure for table `donatedb`
--

CREATE TABLE `donatedb` (
  `AccountNo` varchar(255) NOT NULL,
  `FundName` varchar(255) NOT NULL,
  `Amount` float(14,2) NOT NULL DEFAULT 0.00,
  `Date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donatedb`
--

INSERT INTO `donatedb` (`AccountNo`, `FundName`, `Amount`, `Date`) VALUES
('811567699', 'Save the Children ', 100.00, '23/06/2022'),
('811567699', 'West Bengal Relief Fund ', 1200.00, '23/06/2022'),
('811567699', 'Give India CovidSOS ', 500.00, '23/06/2022');

-- --------------------------------------------------------

--
-- Table structure for table `donationrecord`
--

CREATE TABLE `donationrecord` (
  `FundName` varchar(255) NOT NULL,
  `TotalAmount` float(14,2) NOT NULL DEFAULT 0.00,
  `TotalDepositor` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donationrecord`
--

INSERT INTO `donationrecord` (`FundName`, `TotalAmount`, `TotalDepositor`) VALUES
('Save the Children ', 100.00, 1),
('West Bengal Relief Fund ', 1200.00, 1),
('Give India CovidSOS ', 500.00, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mrecharge`
--

CREATE TABLE `mrecharge` (
  `AccountNo` int(20) NOT NULL,
  `MobileNo` varchar(20) NOT NULL,
  `Operator` varchar(255) NOT NULL,
  `Amount` float(14,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mrecharge`
--

INSERT INTO `mrecharge` (`AccountNo`, `MobileNo`, `Operator`, `Amount`) VALUES
(811567699, '9740123950', 'Jio', 533.00);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `Date` varchar(255) NOT NULL,
  `AccountNo` int(20) NOT NULL,
  `Amount` float(14,2) NOT NULL DEFAULT 0.00,
  `CreditDebit` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`Date`, `AccountNo`, `Amount`, `CreditDebit`, `Type`) VALUES
('21/06/2022', 811567699, 533.00, 'Debited', 'Recharge'),
('21/06/2022', 811567699, 2500.00, 'Debited', 'Withdraw'),
('21/06/2022', 765256306, 50000.00, 'Credit', 'Transfer'),
('21/06/2022', 811567699, 50000.00, 'Debited', 'Transfer'),
('22/06/2022', 811567699, 1580.00, 'Debited', 'Electricity'),
('22/06/2022', 811567699, 5.00, 'Credited', 'Rewards'),
('22/06/2022', 811567699, 2500.00, 'Debited', 'Transfer'),
('22/06/2022', 765256306, 2500.00, 'Credited', 'Received'),
('22/06/2022', 811567699, 2.00, 'Credited', 'Rewards'),
('23/06/2022', 811567699, 100.00, 'Debited', 'Donations'),
('23/06/2022', 811567699, 5.00, 'Credited', 'Rewards'),
('23/06/2022', 811567699, 1200.00, 'Debited', 'Donations'),
('23/06/2022', 811567699, 7.00, 'Credited', 'Rewards'),
('23/06/2022', 811567699, 500.00, 'Debited', 'Donations'),
('23/06/2022', 811567699, 4.00, 'Credited', 'Rewards');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
