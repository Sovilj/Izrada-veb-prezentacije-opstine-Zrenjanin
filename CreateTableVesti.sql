CREATE TABLE dbo.Vesti
(
    Id int PRIMARY KEY NOT NULL,
    Title varchar(MAX) NOT NULL,
	DateStr varchar(MAX) NOT NULL,
	DateSql datetime NOT NULL,
	TextP1 varchar(MAX) NOT NULL,
	TextP2 varchar(MAX) NOT NULL,
	TextP3 varchar(MAX) NOT NULL,
	ImgUrl varchar(MAX) NOT NULL

);

CREATE TABLE dbo.VestiEn
(
    Id int PRIMARY KEY NOT NULL,
    Title varchar(MAX) NOT NULL,
	DateStr varchar(MAX) NOT NULL,
	DateSql datetime NOT NULL,
	TextP1 varchar(MAX) NOT NULL,
	TextP2 varchar(MAX) NOT NULL,
	TextP3 varchar(MAX) NOT NULL,
	ImgUrl varchar(MAX) NOT NULL

);

CREATE TABLE dbo.Poruke
(
    Id int PRIMARY KEY NOT NULL,
    Name varchar(100) NOT NULL,
	Lastname varchar(100) NOT NULL,
	UserEmail varchar(100) NOT NULL,
	Subject varchar(100) NOT NULL,
	Message varchar(MAX) NOT NULL,
	

);






