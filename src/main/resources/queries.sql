CREATE TABLE `employees` (
  `MID` varchar(255) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `JOIN_DATE` date DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MID`),
  UNIQUE KEY `EMAIL_ID` (`EMAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `employees_events` (
  `MID` varchar(255) NOT NULL,
  `EVENT_ID` int NOT NULL,
  PRIMARY KEY (`MID`,`EVENT_ID`),
  KEY `EVENT_ID` (`EVENT_ID`),
  CONSTRAINT `employees_events_ibfk_1` FOREIGN KEY (`MID`) REFERENCES `employees` (`MID`),
  CONSTRAINT `employees_events_ibfk_2` FOREIGN KEY (`EVENT_ID`) REFERENCES `events` (`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `events` (
  `EVENT_ID` int NOT NULL,
  `EVENT_TITLE` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`),
  UNIQUE KEY `EVENT_TITLE` (`EVENT_TITLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
