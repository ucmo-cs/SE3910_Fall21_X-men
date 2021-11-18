DROP TABLE IF EXISTS usertable;

CREATE TABLE userTable (
    userID VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    password VARCHAR(250) DEFAULT NULL
);

INSERT INTO USER_TABLE (name, password) VALUES
    ('Samantha Alister','C4LNhbQk'),
    ('John Doe','RxLVf9qc'),
    ('Karen Freed','9sDkMJbG'),
    ('Will Bonds','RH5Wc8RF');

CREATE TABLE reservationTable (
    reservationID VARCHAR(250) NOT NULL,
    userID VARCHAR(250) NOT NULL,
    name VARCHAR(250) DEFAULT NULL,
    sDate VARCHAR(250) NOT NULL,
    eDate VARCHAR(250) NOT NULL,
    cubicleID VARCHAR(250) Not NULL
);

INSERT INTO RESERVATIONS_TABLE (userID, name, sDate, eDate, cubicleID) VALUES
(1,'Samantha Alister','2/12/22','2/14/22',3),
(2,'John Doe','2/15/22','2/17/22',1);

CREATE TABLE cubicleTable (
    cubicleID VARCHAR(250) NOT NULL,
    sDate VARCHAR(250) DEFAULT NULL,
    eDate VARCHAR(250) DEFAULT NULL
);

INSERT INTO CUBICLE_TABLE (cubicleID, S_DATE, E_DATE) VALUES
(1,'2/15/22','2/17/22'),
(3,'2/12/22','2/14/22');