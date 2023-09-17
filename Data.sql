USE fahodo

INSERT INTO dbo.account
VALUES('ngonc', '19/08/2002', 'admin@gmail.com', 'Admin', 'Male', '1', '0445553331', 'Viet Nam', 'ADMIN', 1, 'Premium'),
('user', '19/08/2002', 'user@gmail.com', 'Customer', 'Male', '2', '0445553332', 'Viet Nam', 'CUSTOMER', 1, 'Normal'),
('user1', '19/08/2002', 'user1@gmail.com', 'Customer 1', 'Female', '3', '0445553332', 'Viet Nam', 'CUSTOMER', 1, 'Normal'),
('store', '19/08/2002', 'store@gmail.com', 'Store', 'Male', '4', '0445553333', 'Viet Nam', 'STORE', 1, 'Store');

INSERT INTO dbo.author
VALUES('7/5/1955', 'Nha van', 'Nguyen Nhat Anh'),
('27/9/1920', 'Nha Van', 'To Hoai');

INSERT INTO dbo.book
VALUES(1, 'Cho toi xin 1 ve di tuoi tho', '...', '1/2/2008', 5, 1, 'Truyen', 'tuoi tho', 2, 1),
(2, 'De men phieu luu ki', '...', '1941', 5, 1, 'Truyen', 'tuoi tho', 3, 5);

INSERT INTO dbo.comment
VALUES('Hay', '17/9/2023', 'user'),
('Cam dong', '16/9/2023', 'user1'),
('Tuoi tho', '16/9/2023', 'user'),
('Yeu thich', '17/9/2023', 'user1');

INSERT INTO dbo.book_comment
VALUES(1, 1),
(2,1),
(3,2),
(4,2);