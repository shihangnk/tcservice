use tcservice;

drop table Centers;
CREATE TABLE Centers(
	Id	int	identity(1,1) not null,
	Name nvarchar(30) NOT NULL,
	StreetAddress nvarchar(30) NOT NULL,
	CenterTypeId int NOT NULL,
	CenterTypeValue nvarchar(30) NOT NULL,
	Primary Key(Id)
);


