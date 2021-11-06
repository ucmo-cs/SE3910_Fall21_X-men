DROP TABLE IF EXISTS usertable;

CREATE TABLE userTable (
    userID VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    password VARCHAR(250) DEFAULT NULL
);

INSERT INTO userTable (userID, name, password) VALUES
    ('SA7465','Samantha Alister','C4LNhbQk'),
    ('JD4532','John Doe','RxLVf9qc'),
    ('KF5288','Karen Freed','9sDkMJbG'),
    ('WB2533','Will Bonds','RH5Wc8RF');

CREATE TABLE reservationTable (
    reservationID VARCHAR(250) NOT NULL,
    userID VARCHAR(250) NOT NULL,
    name VARCHAR(250) DEFAULT NULL,
    sDate VARCHAR(250) NOT NULL,
    eDate VARCHAR(250) NOT NULL,
    cubicleID VARCHAR(250) Not NULL
);

INSERT INTO reservationTable (reservationID, userID, name, sDate, eDate, cubicleID) VALUES
    ('Mgx6wAtp','C4LNhbQk','Samantha Alister','2/12/22','2/14/22',3),
    ('wzFVYTur','RxLVf9qc','John Doe','2/15/22','2/17/22','1');

CREATE TABLE cubicleTable (
    cubicleID VARCHAR(250) NOT NULL,
    sDate VARCHAR(250) DEFAULT NULL,
    eDate VARCHAR(250) DEFAULT NULL
);

INSERT INTO cubicleTable (cubicleID, sDate, eDate) VALUES
    (1,'2/15/22','2/17/22'),
    (3,'2/12/22','2/14/22');