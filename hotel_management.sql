CREATE DATABASE hm
GO
USE hm
GO
CREATE TABLE rights(
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(50) NOT NULL
)
GO
CREATE TABLE users(
	id VARCHAR(10) PRIMARY KEY,
	userName VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(200) NOT NULL,
	fullName NVARCHAR(50) NOT NULL,
	rightsId INT NOT NULL,
	CONSTRAINT FK_rightsId_users FOREIGN KEY(rightsId) REFERENCES rights(id),
)
GO
CREATE TABLE floors(
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(30) NOT NULL
)
GO
CREATE TABLE roomTypes(
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(50) UNIQUE NOT NULL,
	price FLOAT NOT NULL
)
GO
CREATE TABLE rooms(
	id VARCHAR(40) PRIMARY KEY,
	name NVARCHAR(50) UNIQUE NOT NULL,
	roomTypeId INT NOT NULL,
	floorId INT NOT NULL,
	status TINYINT NOT NULL,
	createdAt DATETIME DEFAULT GETDATE(),
	CONSTRAINT FK_roomTypeId_rooms FOREIGN KEY(roomTypeId) REFERENCES roomTypes(id),
	CONSTRAINT FK_floorId_rooms FOREIGN KEY(floorId) REFERENCES floors(id)
)
GO
CREATE TABLE customers(
	id VARCHAR(40) PRIMARY KEY,
	identityCardNumber VARCHAR(12) NOT NULL UNIQUE,
	name NVARCHAR(50) NOT NULL,
	phone VARCHAR(10) NOT NULL,
	birthday DATE NOT NULL,
	gender TINYINT NOT NULL,
	email VARCHAR(50),
	createdAt DATETIME DEFAULT GETDATE()
)
GO
CREATE TABLE bookings(
	id VARCHAR(40) PRIMARY KEY,
	customerId VARCHAR(40) NOT NULL,
	userId VARCHAR(10) NOT NULL,
	checkin DATE NOT NULL,
	checkout DATE,
	status TINYINT NOT NULL,
	createdAt DATETIME DEFAULT GETDATE(),
	CONSTRAINT FK_guestId_bookings FOREIGN KEY(customerId) REFERENCES customers(id),
	CONSTRAINT FK_userId_bookings FOREIGN KEY(userId) REFERENCES users(id)
)
GO
CREATE TABLE bookingDetails(
	id INT IDENTITY(1,1) PRIMARY KEY,
	bookingId VARCHAR(40) NOT NULL,
	roomId VARCHAR(40) NOT NULL,
	servicePrice FLOAT NOT NULL,
	createdAt DATETIME DEFAULT GETDATE(),
	CONSTRAINT FK_bookingId_bookingDetails FOREIGN KEY(bookingId) REFERENCES bookings(id),
	CONSTRAINT FK_roomId_bookingDetails FOREIGN KEY(roomId) REFERENCES rooms(id)
)
GO
CREATE TABLE services(
	id VARCHAR(40) PRIMARY KEY,
	name NVARCHAR(50) NOT NULL UNIQUE,
	price FLOAT NOT NULL,
	amount INT NOT NULL
)
GO
CREATE TABLE serviceDetails(
	id INT IDENTITY(1,1) PRIMARY KEY,
	amount INT NOT NULL,
	bookingDetailId INT NOT NULL,
	serviceId VARCHAR(40) NOT NULL,
	createdDate DATETIME DEFAULT GETDATE(),
	CONSTRAINT FK_bookingDetailId_serviceDetails FOREIGN KEY(bookingDetailId) REFERENCES bookingDetails(id),
	CONSTRAINT FK_serviceId_serviceDetails FOREIGN KEY(serviceId) REFERENCES services(id)
)
GO
INSERT INTO floors VALUES(N'Tầng 1'),(N'Tầng 2'),(N'Tầng 3'),(N'Tầng 4'),(N'Tầng 5'),(N'Tầng 6')

INSERT INTO roomTypes VALUES(N'đơn thường',500000),(N'đơn vip',800000),(N'đôi thường',1000000),(N'đôi vip',1500000)

INSERT INTO rooms(id, name, roomTypeId, floorId, status) VALUES('0001','0001',1,1,1),('0002','0002',1,1,1),('0003','0003',1,1,1),('0004','0004',1,1,1),
('0005','0005',1,1,1),('0006','0006',3,1,1),('0007','0007',3,1,1),('0008','0008',3,1,1),('0009','0009',3,1,1),('0010','0010',3,1,1),('0011','0011',2,2,1),
('0012','0012',2,2,1),('0013','0013',2,2,1),('0014','0014',2,2,1),('0015','0015',2,2,1),('0016','0016',4,2,1),('0017','0017',4,2,1),('0018','0018',4,2,1),
('0019','0019',4,2,1),('0020','0020',4,2,1),('0021','0021',2,3,1),('0022','0022',2,3,1),('0023','0023',2,3,1),('0024','0024',2,3,1),('0025','0025',2,3,1),
('0026','0026',4,3,1),('0027','0027',4,3,1),('0028','0028',4,3,1),('0029','0029',4,3,1),('0030','0030',4,3,1),('0031','0031',2,4,1),('0032','0032',1,4,2),
('0033','0033',2,4,2),('0034','0034',2,4,2),('0035','0035',2,4,2),('0036','0036',4,4,2),('0037','0037',4,4,2),('0038','0038',4,4,2),('0039','0039',4,4,3),
('0040','0040',4,4,3),('0041','0041',1,5,3),('0042','0042',1,5,3),('0043','0043',1,5,3),('0044','0044',1,5,1),('0045','0045',1,5,1),('0046','0046',3,5,1),
('0047','0047',3,5,1),('0048','0048',3,5,1),('0049','0049',3,5,1),('0050','0050',3,5,1)

INSERT INTO services(id, name, price, amount) VALUES('0001',N'dịch vụ 1',50000,150),('0002',N'dịch vụ 2',50000,180),('0003',N'dịch vụ 3',50000,200),
('0004',N'dịch vụ 4',60000,80),('0005',N'dịch vụ 5',65000,110),('0006',N'dịch vụ 6',65000,250),('0007',N'dịch vụ 7',65000,100),('0008',N'dịch vụ 8',70000,90),
('0009',N'dịch vụ 9',70000,120),('0010',N'dịch vụ 10',70000,320),('0011',N'dịch vụ 11',75000,150),('0012',N'dịch vụ 12',75000,100),('0013',N'dịch vụ 13',75000,160),
('0014',N'dịch vụ 14',80000,240),('0015',N'dịch vụ 15',80000,280),('0016',N'dịch vụ 16',85000,150),('0017',N'dịch vụ 17',90000,150),('0018',N'dịch vụ 18',100000,150),
('0019',N'dịch vụ 19',110000,250),('0020',N'dịch vụ 20',115000,200),('0021',N'dịch vụ 21',120000,210),('0022',N'dịch vụ 22',120000,220),('0023',N'dịch vụ 23',130000,250),
('0024',N'dịch vụ 24',135000,150),('0025',N'dịch vụ 25',150000,260),('0026',N'dịch vụ 26',155000,110),('0027',N'dịch vụ 27',170000,220),('0028',N'dịch vụ 28',175000,200),
('0029',N'dịch vụ 29',180000,150),('0030',N'dịch vụ 30',200000,280)

INSERT INTO rights VALUES(N'Quản lý'),(N'Nhân viên')

INSERT INTO users VALUES('AD001','admin','admin','Aministrator',1),
('EMP0004','anh','12345678',N'Trịnh Văn Anh',2),('EMP0003','trung','12345678',N'Lường Quang Trung',2),
('EMP0002','thin','12345678',N'Ngô Đức Thìn',2),('EMP0001','employee1','12345678',N'Lê Tiến Đạt',2)

INSERT INTO customers(id, identityCardNumber, name, phone, birthday, gender, email) VALUES
('00001','001180000001',N'Nguyễn Anh Tuấn','0946205403','1995-10-12',0,'anhtuan0202@gmail.com'),
('00002','001785000002',N'Nguyễn Hà Nam','0986255223','1990-05-08',0,'namnguyen8590@gmail.com'),
('00003','012500000250',N'Lê Thị Huyền','0941896201','1989-02-25',1,null),
('00004','002506020002',N'Trần Quốc Khánh','0946825210','1995-06-15',0,'trankhanh5892@gmail.com'),
('00005','001630000250',N'Ngô Đức Huy','0866520152','1992-12-24',0,'duchuy2412@gmail.com'),
('00007','001652200007',N'Biện Anh Sơn','0942251202','1993-12-14',0,'anhson1255@gmail.com'),
('00008','001632522002',N'Phạm Ngọc Ánh','0948525220','1997-01-29',1,'ngocanh2901@gmail.com'),
('00009','001722500003',N'Bùi Tiến Dũng','0976252102','1995-08-02',0,'tiendung0802@gmail.com'),
('00010','001250000025',N'Lê Hồng Thái','0976142002','1992-03-16',0,'thaile3250@gmail.com'),
('00011','001250002002',N'Trần Bảo Bảo','0945221002','1996-04-05',0,'baobao0405@gmail.com'),
('00012','001725000060',N'Lê Hữu Tuấn','0986200102','1991-05-21',0,'tuanle2500@gmail.com'),
('00013','001735000020',N'Lê Quốc Bảo','0888250221','1991-02-25',0,'quocbao3682@gmail.com'),
('00014','001245006300',N'Nguyễn Nhật Linh','0941250021','1994-02-15',1,'nhatlinh1502@gmail.com'),
('00015','001725500022',N'Lê Nhật Nam','0942158210','1994-04-15',0,'nhatnam5860@gmail.com'),
('00016','001738000202',N'Nguyễn Hoàng Long','0947252002','1995-08-11',0,'hoanglong1108@gmail.com'),
('00017','001752000802',N'Lê Hoàng Giang','0986280541','1993-10-25',1,'hoanggiang5682@gmail.com'),
('00018','006320000028',N'Hồ Phương Linh','0945038218','1995-02-22',1,'phuonglinh58128@gmail.com'),
('00019','001482000027',N'Phạm Văn Tuân','0976251020','1986-05-30',0, null),
('00020','001183522141',N'Trần Tiến Dũng','0978552541','1991-10-11',0,'tiendung1110@gmail.com'),
('00021','079301514231',N'Lê Thị Hải Yến','0941225841','1995-01-20',1,'haiyen5421@gmail.com'),
('00022','001089301542',N'Nguyễn Anh Đức','0945642572','1985-05-24',0,null),
('00023','001830000672',N'Nguyễn Tuấn Anh','0986552154','1986-09-10',0,null),
('00024','001173000684',N'Lê Diễm Quỳnh','0942125562','1996-11-25',1,'diemquynh2511@gmail.com'),
('00025','036087000052',N'Nguyễn Nhật Minh','0866522153','1997-04-12',0,'minhnguyen1204@gmail.com'),
('00026','001184001528',N'Trần Khánh Linh','0943533153','1994-08-20',1,'linhtran5425@gmail.com')

INSERT INTO bookings(id, customerId, userId, checkin, checkout, status, createdAt) VALUES('00001','00016','EMP0001','2020-01-01','2020-01-02',3,'2020-01-01'),('00002','00017','EMP0001','2020-01-01','2020-01-03',3,'2020-01-01'),
('00003','00018','EMP0002','2020-01-11','2020-01-14',3,'2020-01-11'),('00004','00019','EMP0002','2020-01-18','2020-01-20',3,'2020-01-18'),('00005','00020','EMP0001','2020-02-14','2020-02-16',3,'2020-02-14'),('00006','00021','EMP0002','2020-02-14','2020-02-16',3,'2020-02-14'),
('00007','00022','EMP0001','2020-02-22','2020-02-23',3,'2020-02-22'),('00008','00023','EMP0003','2020-02-29','2020-03-01',3,'2020-02-29'),('00009','00024','EMP0001','2020-03-07','2020-03-09',3,'2020-03-07'),('00010','00025','EMP0003','2020-03-14','2020-03-18',3,'2020-03-14'),
('00011','00026','EMP0002','2020-03-21','2020-03-23',3,'2020-03-21'),('00012','00016','EMP0001','2020-03-28','2020-03-30',3,'2020-03-28'),
('00013','00017','EMP0001','2020-03-29','2020-04-01',3,'2020-03-29'),('00014','00018','EMP0001','2020-04-01','2020-04-02',3,'2020-04-01'),
('00015','00019','EMP0002','2020-04-01','2020-04-02',3,'2020-04-01'),('00016','00020','EMP0003','2020-04-01','2020-04-03',3,'2020-04-01'),
('00017','00021','EMP0002','2020-04-02','2020-04-03',3,'2020-04-02'),('00018','00022','EMP0003','2020-04-02','2020-04-04',3,'2020-04-02'),
('00019','00022','EMP0002','2020-04-02','2020-04-04',3,'2020-04-02'),('00020','00024','EMP0003','2020-04-03','2020-04-04',3,'2020-04-03'),
('00021','00025','EMP0001',GETDATE(),null,2,GETDATE()),('00022','00026','EMP0002',GETDATE(),null,2,GETDATE()),
('00023','00016','EMP0003',GETDATE(),null,2,GETDATE()),('00024','00017','EMP0001',GETDATE(),null,2,GETDATE()),
('00025','00018','EMP0002',GETDATE(),null,1,GETDATE()),('00026','00019','EMP0003',GETDATE(),null,1,GETDATE()),
('00027','00020','EMP0001',GETDATE(),null,1,GETDATE())

INSERT INTO bookingDetails(bookingId,roomId,servicePrice, createdAt) VALUES('00001','0017',540000,'2020-01-01'),
('00001','0019',555000,'2020-01-01'),('00002','0020',0,'2020-01-01'),
('00003','0021',0,'2020-01-11'),('00003','0022',0,'2020-01-11'),
('00003','0032',0,'2020-01-11'),('00004','0036',0,'2020-01-18'),
('00005','0016',0,'2020-02-14'),('00006','0026',0,'2020-02-14'),
('00007','0024',0,'2020-02-22'),('00007','0023',0,'2020-02-22'),
('00008','0030',700000,'2020-02-29'), ('00009','0031',0,'2020-03-07'),
('00010','0033',0,'2020-03-14'),('00010','0039',0,'2020-03-14'),
('00010','0041',0,'2020-03-14'),('00010','0046',0,'2020-03-14'),
('00011','0025',950000,'2020-03-21'),('00012','0035',785000,'2020-03-28'),
('00013','0031',570000,'2020-03-29'),('00014','0032',350000,'2020-04-01'),
('00014','0033',220000,'2020-04-01'),('00014','0034',150000,'2020-04-01'),
('00015','0017',250000,'2020-04-01'),('00015','0018', 0,'2020-04-01'),
('00016','0019',785000,'2020-04-01'),('00016','0020',550000,'2020-04-01'),
('00016','0021',385000,'2020-04-01'),('00016','0022',250000,'2020-04-01'),
('00017','0023',285000,'2020-04-02'),('00017','0024',200000,'2020-04-02'),
('00018','0025',1120000,'2020-04-02'),('00018','0026',950000,'2020-04-02'),
('00018','0027',685000,'2020-04-02'),('00019','0028',575000,'2020-04-02'),
('00019','0029',285000,'2020-04-02'),('00019','0030',150000,'2020-04-02'),
('00020','0031',475000,'2020-04-03'),('00021','0032',0,GETDATE()),
('00021','0033',0,GETDATE()),('00021','0034',0,GETDATE()),
('00022','0035',0,GETDATE()),('00023','0036',0,GETDATE()),
('00023','0037',0,GETDATE()),('00024','0038',0,GETDATE()),
('00025','0039',0,GETDATE()),('00025','0040',0,GETDATE()),
('00026','0041',0,GETDATE()),('00027','0042',0,GETDATE()),
('00027','0043',0,GETDATE())

INSERT INTO serviceDetails(amount, bookingDetailId, serviceId) VALUES(3,1,'0001'),(5,1,'0001'),(2,1,'0010'),(6,2,'0001'),
(3,2,'0016'),(2,12,'0025'),(8,12,'0001'),(5,18,'0025'),(2,18,'0018'),(2,19,'0001'),(3,19,'0014'),(2,19,'0019'),(1,19,'0016'),(1,19,'0030'),
(1,20,'0009'),(1,20,'0020'),(1,20,'0022'),(1,20,'0001'),(1,20,'0018'),(2,21,'0018'),(1,21,'0025'),(2,22,'0007'),(1,22,'0017'),(3,23,'0001'),
(2,24,'0001'),(1,24,'0006'),(1,24,'0016'),(2,26,'0001'),(1,26,'0024'),(1,26,'0025'),(2,26,'0018'),(1,26,'0021'),(1,26,'0015'),(2,27,'0026'),
(2,27,'0006'),(1,27,'0019'),(1,28,'0016'),(2,28,'0025'),(2,29,'0001'),(1,29,'0025'),(2,30,'0001'),(1,30,'0016'),(1,30,'0018'),(2,31,'0006'),(1,31,'0009'),(4,32,'0001'),(4,32,'0016'),(1,32,'0006'),
(2,32,'0018'),(3,32,'0011'),(1,32,'0017'),(2,33,'0030'),(1,33,'0025'),(5,33,'0015'),(2,34,'0021'),(1,34,'0018'),(1,34,'0025'),(1,34,'0015'),
(1,34,'0020'),(3,35,'0016'),(1,35,'0018'),(2,35,'0019'),(1,36,'0016'),(2,36,'0018'),(1,37,'0025'),(3,38,'0001'),(1,38,'0011'),(1,38,'0018'),
(1,38,'0025')
GO
CREATE PROC usp_getUserByUserName(@userName AS VARCHAR(50))
AS
SELECT * FROM users WHERE userName = @userName
GO
CREATE PROC usp_getUserById(@id AS VARCHAR(10))
AS
SELECT * FROM users WHERE id = @id
GO
CREATE PROC usp_getRightsById(@id AS INT)
AS
SELECT * FROM rights WHERE id = @id
GO
CREATE PROC usp_insertRoomType(@name AS NVARCHAR(50), @price AS FLOAT)
AS
INSERT INTO roomTypes VALUES(@name, @price)
GO 
CREATE PROC usp_getAllRoomTypes 
AS
SELECT * FROM roomTypes
GO
CREATE PROC usp_getRoomTypeById(@id AS INT)
AS
SELECT * FROM roomTypes WHERE id = @id
GO 
CREATE PROC usp_deleteRoomTypeByName(@name AS NVARCHAR(50))
AS
DELETE FROM roomTypes WHERE name = @name
GO 
CREATE PROC usp_editRoomTypeByName(@id AS INT, @newName AS NVARCHAR(50), @newPrice AS FLOAT)
AS
UPDATE roomTypes SET name = @newName, price = @newPrice WHERE id = @id
GO
CREATE PROC usp_getFloorById(@id AS INT)
AS
SELECT * FROM floors WHERE id = @id
GO
CREATE PROC usp_getAllFloors
AS
SELECT * FROM floors
GO
CREATE PROC usp_insertRoom(@id AS VARCHAR(40), @name AS NVARCHAR(50), @status AS TINYINT, @floorId AS INT, @roomTypeId AS INT)
AS
INSERT INTO rooms(id, name, status, floorId, roomTypeId) VALUES(@id, @name, @status, @floorId, @roomTypeId)
GO
CREATE PROC usp_getAllRooms
AS
SELECT * FROM rooms ORDER BY name
GO
CREATE PROC usp_getRoomById(@id AS VARCHAR(40))
AS
SELECT * FROM rooms WHERE id = @id
GO
CREATE PROC usp_getEmptyRooms
AS
SELECT * FROM rooms WHERE status = 1
GO
CREATE PROC usp_getRoomByFilter(@floorId AS INT, @roomTypeId AS INT, @status AS TINYINT)
AS
SELECT * FROM rooms WHERE floorId = @floorId AND roomTypeId = @roomTypeId AND status = @status
GO
CREATE PROC usp_deleteRoomById(@id AS VARCHAR(40))
AS
DELETE FROM rooms WHERE id = @id
GO
CREATE PROC usp_updateRoom(@id AS VARCHAR(40), @name AS NVARCHAR(50), @roomTypeId AS INT, @floorId AS INT, @status AS TINYINT)
AS
UPDATE rooms SET name = @name, roomTypeId = @roomTypeId, floorId = @floorId, status = @status WHERE id = @id
GO 
CREATE PROC usp_getAllCustomers
AS
SELECT * FROM customers
GO 
CREATE PROC usp_getCustomerById(@id AS VARCHAR(40))
AS
SELECT * FROM customers WHERE id = @id
GO
CREATE PROC usp_insertCustomer(@id AS VARCHAR(40),@identityCardNumber AS VARCHAR(12), @name AS NVARCHAR(50), @birthday AS DATETIME, @phone AS VARCHAR(10), @gender AS TINYINT, @email AS VARCHAR(50))
AS
INSERT INTO customers(id, identityCardNumber, name, birthday, phone, gender, email) VALUES(@id, @identityCardNumber, @name, @birthday,@phone,@gender,@email)
GO
CREATE PROC usp_getCustomerByIdentityCard(@identityCardNumber AS VARCHAR(12))
AS 
SELECT * FROM customers WHERE identityCardNumber = @identityCardNumber
GO
CREATE PROC usp_updateCustomer(@id AS VARCHAR(40),@identityCardNumber AS VARCHAR(12), @name AS NVARCHAR(50), @birthday AS DATETIME, @phone AS VARCHAR(10), @gender AS TINYINT, @email AS VARCHAR(50))
AS
UPDATE customers SET identityCardNumber = @identityCardNumber, name = @name, birthday = @birthday, phone = @phone, gender = @gender, email = @email WHERE id = @id
GO
CREATE PROC usp_insertService(@id AS VARCHAR(40), @name AS NVARCHAR(50), @price AS FLOAT, @amount AS INT)
AS
INSERT INTO services(id, name, price, amount) VALUES(@id, @name, @price, @amount)
GO
CREATE PROC usp_updateService(@id AS VARCHAR(40), @name AS NVARCHAR(50), @price AS FLOAT, @amount AS INT)
AS
UPDATE services SET name = @name, price = @price, amount = @amount WHERE id = @id
GO 
CREATE PROC usp_deleteService(@id AS VARCHAR(40))
AS
DELETE FROM services WHERE id = @id
GO 
CREATE PROC usp_getAllServices
AS 
SELECT * FROM services
GO
CREATE PROC usp_getAllBookings
AS
SELECT * FROM bookings ORDER BY checkin DESC
GO
CREATE PROC usp_getBookingById(@id AS VARCHAR(40)) 
AS
SELECT * FROM bookings WHERE id = @id
GO
CREATE PROC usp_getBookingDetailsByBookingId(@id AS VARCHAR(40))
AS
SELECT * FROM bookingDetails WHERE bookingId = @id
GO
CREATE PROC usp_insertBooking(@id AS VARCHAR(40),@customerId AS VARCHAR(40),@userId AS VARCHAR(40),@checkin AS DATETIME, @status AS TINYINT)
AS
INSERT INTO bookings(id, customerId, userId, checkin, status) VALUES(@id, @customerId, @userId, @checkin,@status)
GO
CREATE PROC usp_insertBookingDetail(@bookingId AS VARCHAR(40), @roomId AS VARCHAR(40), @servicePrice AS FLOAT)
AS
INSERT INTO bookingDetails(bookingId,roomId,servicePrice) VALUES(@bookingId, @roomId, @servicePrice)
GO
CREATE PROC usp_getServiceDetailByBookingDetailId(@id AS INT)
AS
SELECT * FROM serviceDetails WHERE bookingDetailId = @id
GO
CREATE PROC usp_getBookingDetailById(@id AS INT)
AS
SELECT * FROM bookingDetails WHERE id = @id
GO
CREATE PROC usp_getServiceById(@id AS VARCHAR(40))
AS
SELECT * FROM services WHERE id = @id
GO
CREATE PROC usp_updateBooking(@id AS VARCHAR(40), @customerId AS VARCHAR(40), @userId AS VARCHAR(40), @checkin AS DATETIME, @checkout AS DATETIME,@status AS TINYINT)
AS
UPDATE bookings SET customerId = @customerId, userId = @userId, checkin = @checkin, checkout = @checkout, status = @status WHERE id = @id
GO
CREATE PROC usp_deleteBookingDetailById(@id AS INT) 
AS 
DELETE FROM bookingDetails WHERE id = @id
GO
CREATE PROC usp_deleteBookingById(@id AS VARCHAR(40))
AS
DELETE FROM bookings WHERE id = @id
GO
CREATE PROC usp_getUsingRooms
AS
SELECT * FROM rooms WHERE status = 2
GO
CREATE PROC usp_getBookingDetailByRoomId(@id AS VARCHAR(40))
AS
SELECT * FROM bookingDetails WHERE roomId = @id
GO
CREATE PROC usp_insertServiceDetail(@amount AS INT, @bookingDetailId AS INT, @serviceId AS VARCHAR(40))
AS 
INSERT INTO serviceDetails(amount, bookingDetailId, serviceId) VALUES(@amount, @bookingDetailId, @serviceId)
GO 
CREATE PROC usp_updateBookingDetail(@id AS INT, @bookingId AS VARCHAR(40), @roomId AS VARCHAR(40), @servicePrice AS FLOAT)
AS
UPDATE bookingDetails SET bookingId = @bookingId, roomId = @roomId, servicePrice = servicePrice + @servicePrice WHERE id = @id
GO
CREATE PROC usp_deleteCustomerById(@id AS VARCHAR(40))
AS
DELETE FROM customers WHERE id = @id
GO
CREATE PROC usp_deleteFloorByName(@name AS NVARCHAR(30))
AS
DELETE FROM floors WHERE name = @name
GO
CREATE PROC usp_insertFloor(@name AS NVARCHAR(30))
AS
INSERT INTO floors(name) VALUES(@name)
GO
CREATE PROC usp_getAllBookingDetails
AS
SELECT * FROM bookingDetails
