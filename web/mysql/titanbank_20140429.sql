-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 29, 2014 at 06:48 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `titanbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `accountnum` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `accounttype` varchar(1) NOT NULL,
  `customerid` int(11) unsigned NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`accountnum`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountnum`, `accounttype`, `customerid`, `balance`) VALUES
(3, 'S', 2, 340),
(7, 'S', 3, 1100),
(10, 'C', 2, 120),
(11, 'S', 6, 500),
(12, 'C', 6, 620);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `personid` int(11) NOT NULL,
  `userid` varchar(30) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`customerid`),
  KEY `personid` (`personid`,`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `personid`, `userid`, `status`, `description`) VALUES
(1, 19, NULL, 'INSERT', 'New customer'),
(2, 8, NULL, 'active', 'New customer'),
(3, 9, NULL, 'active', 'New customer'),
(4, 11, NULL, 'active', 'New customer'),
(5, 13, NULL, 'active', 'New customer'),
(6, 20, NULL, 'INSERT', 'New customer');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `personid` int(11) NOT NULL AUTO_INCREMENT,
  `prefixtitle` varchar(10) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `middlename` varchar(30) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `gender` varchar(1) NOT NULL,
  `suffix` varchar(10) NOT NULL,
  `address1` varchar(30) NOT NULL,
  `address2` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `postalcode` varchar(10) NOT NULL,
  `emailaddress` varchar(50) NOT NULL,
  `phone1` varchar(12) NOT NULL,
  PRIMARY KEY (`personid`),
  UNIQUE KEY `personid` (`personid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`personid`, `prefixtitle`, `lastname`, `firstname`, `middlename`, `birthdate`, `gender`, `suffix`, `address1`, `address2`, `city`, `country`, `state`, `postalcode`, `emailaddress`, `phone1`) VALUES
(1, '', 'Smith', 'John', 'T', '1967-07-27', '', '', '', '', '', '', '', '', '0', '0'),
(2, '', 'Jones', 'Tom', 'R', '1954-12-15', '', '', '', '', '', '', '', '', '0', '0'),
(3, '', 'Jones', 'Zeke', 'M', '1975-08-12', '', '', '', '', '', '', '', '', '0', '0'),
(4, '', 'Presley', 'Elvis', 'A', '1936-04-24', '', '', '', '', '', '', '', '', '0', '0'),
(5, '', 'Spratt', 'Jack', 'B', '1961-03-16', '', '', '', '', '', '', '', '', '0', '0'),
(7, 'Mr', 'Meijer', 'Rick', 'Steven', '1961-08-20', 'M', 'None', '6232 Spoonbill Drive', 'None', 'New Port Richey', 'US', 'FL', '34652', 'rmeijer61@hotmail.com', '727-364-9191'),
(8, 'Mr', 'Wilson', 'Thomas', 'D', '1965-00-12', 'M', 'Jr', '123 Main Street', 'Apt 21', 'Rockaway', 'US', 'CO', '07834', 'twilson@hotmail.com', '555-123-0909'),
(9, 'Ms', 'Fields', 'Sally', 'K', '1953-00-06', 'F', '', '98 Hollywood Drive', '', 'Hollywood', 'US', 'CA', '90120', 'sfields@aol.com', '555-768-5456'),
(10, 'Ms', 'Fields', 'Sally', 'K', '1953-00-06', 'F', '', '98 Hollywood Drive', '', 'Hollywood', 'US', 'CA', '90120', 'sfields@aol.com', '555-768-5456'),
(11, 'Mr', 'Jones', 'Tom', 'G', '1934-00-23', 'M', 'Jr', '90 Vegas Drive', 'Suite 30', 'Los Vegas', 'US', 'NV', '98765', 'tjones@aol.com', '555-768-5456'),
(12, 'Mr', 'Jones', 'Tom', 'G', '1934-00-23', 'M', 'Jr', '90 Vegas Drive', 'Suite 30', 'Los Vegas', 'US', 'NV', '98765', 'tjones@aol.com', '555-768-5456'),
(13, 'Ms', 'Johnson', 'Mary', 'J', '1977-00-12', 'F', 'None', '109 Hillcrest Drive', 'Apt 2', 'Rockaway', 'US', 'AL', '23232', 'mjohnson@verizon.net', '555-992-8657'),
(14, 'Ms', 'Johnson', 'Mary', 'J', '1977-00-12', 'F', 'None', '109 Hillcrest Drive', 'Apt 2', 'Rockaway', 'US', 'CA', '23232', 'mjohnson@verizon.net', '555-992-8657'),
(15, 'Ms', 'Johnson', 'Mary', 'J', '1977-00-12', 'F', 'None', '109 Hillcrest Drive', 'Apt 2', 'Rockaway', 'US', 'AK', '23232', 'mjohnson@verizon.net', '555-992-8657'),
(16, 'Ms', 'Johnson', 'Mary', 'J', '1977-00-12', 'F', 'None', '109 Hillcrest Drive', 'Apt 2', 'Rockaway', 'US', 'ID', '23232', 'mjohnson@verizon.net', '555-992-8657'),
(17, 'Mr', 'Brownstone', 'Ralph', 'Jim', '1942-00-14', 'M', 'Sr', '80 Houses street', 'Suite 45', 'Hicksville', 'US', 'DE', '43532', 'rbrown@yahoo.com', '555-657-8912'),
(18, 'Mr', 'Brownstone', 'Ralph', 'Jim', '1942-00-14', 'M', 'Sr', '80 Houses street', 'Suite 45', 'Hicksville', 'US', 'CT', '43532', 'rbrown@yahoo.com', '555-657-8912'),
(19, 'Mr', 'Brownstone', 'Ralph', 'Jim', '1942-00-14', 'M', 'Sr', '80 Houses street', 'Suite 45', 'Hicksville', 'US', 'IL', '43532', 'rbrown@yahoo.com', '555-657-8912'),
(20, 'Mrs', 'Floyd', 'Tammy', 'Jane', '1972-00-18', 'F', '', '8345 Third street', 'apt 9', 'Morristown', 'US', 'NJ', '07801', 'tfloyd@gmail.com', '555-764-1746');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE IF NOT EXISTS `transfer` (
  `transferid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customerid` int(11) unsigned NOT NULL,
  `transferstatus` varchar(1) NOT NULL,
  `fromaccountnum` int(11) unsigned NOT NULL,
  `toaccountnum` int(11) unsigned NOT NULL,
  `amount` double NOT NULL,
  `transferimmediately` tinyint(1) NOT NULL,
  `scheduledate` date NOT NULL,
  PRIMARY KEY (`transferid`),
  KEY `customerid` (`customerid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`transferid`, `customerid`, `transferstatus`, `fromaccountnum`, `toaccountnum`, `amount`, `transferimmediately`, `scheduledate`) VALUES
(1, 6, 'P', 101, 201, 123, 0, '2014-00-12'),
(2, 6, 'C', 101, 201, 20, 0, '2014-00-12'),
(3, 6, 'C', 101, 201, 10, 0, '2014-00-12'),
(4, 6, 'P', 101, 201, 12, 0, '2014-00-12'),
(5, 6, 'P', 101, 201, 12, 0, '2014-00-12'),
(6, 6, 'C', 101, 201, 11, 0, '2014-00-12'),
(7, 6, 'P', 101, 201, 5, 1, '2014-00-12'),
(8, 6, 'P', 101, 201, 32, 1, '2014-00-12'),
(9, 6, 'P', 101, 201, 99, 1, '2014-00-29'),
(10, 6, 'P', 101, 201, 103, 1, '2014-04-29'),
(11, 6, 'P', 101, 201, 104, 1, '2014-04-29'),
(12, 6, 'P', 101, 201, 320, 1, '2014-04-29');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `usertype` varchar(1) NOT NULL,
  `password` text NOT NULL,
  `customerid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`),
  UNIQUE KEY `username` (`username`),
  KEY `username_2` (`username`),
  KEY `usertype` (`usertype`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `usertype`, `password`, `customerid`) VALUES
(1, 'admin1', 'E', 'password1', 0),
(2, 'tfloyd', 'C', 'password', 6),
(3, 'rbrownstone', 'C', 'password', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
