USE testingsystem1;
-- Q1--

INSERT INTO account (email, username, fullname, departmentID, positionID, createDate)
VALUES 
	('Email11@gmail.com', 'Username11', 'Fullname11', 2, 1, '2021-02-10 00:00:00' ),
    ('Email12@gmail.com', 'Username12', 'Fullname12', 4, 3, '2023-04-09 00:00:00' ),
    ('Email13@gmail.com', 'Username13', 'Fullname13', 1, 2, '2022-01-23 00:00:00' ),
    ('Email14@gmail.com', 'Username14', 'Fullname14', 5, 1, '2021-05-09 00:00:00' ),
    ('Email15@gmail.com', 'Username15', 'Fullname15', 5, 2, '2022-05-05 00:00:00' ),
    ('Email16@gmail.com', 'Username16', 'Fullname16', 5, 3, '2023-05-09 00:00:00' ),
    ('Email17@gmail.com', 'Username17', 'Fullname17', 4, 1, '2021-04-03 00:00:00' ),
    ('Email18@gmail.com', 'Username18', 'Fullname18', 4, 4, '2024-04-17 00:00:00' ),
    ('Email19@gmail.com', 'Username19', 'Fullname19', 3, 2, '2022-03-21 00:00:00' ),
    ('Email20@gmail.com', 'Username20', 'Fullname20', 2, 2, '2022-02-28 00:00:00' );

INSERT INTO answer (content, QuestionID, isCorrect)
VALUES 
	('Trả lời 20', 7, 0),
    ('Trả lời 14', 2, 1),
    ('Trả lời 12', 3, 1),
    ('Trả lời 19', 1, 0),
    ('Trả lời 11', 9, 1),
    ('Trả lời 13', 7, 0),
    ('Trả lời 16', 8, 1),
    ('Trả lời 18', 4, 0),
    ('Trả lời 15', 5, 1),
    ('Trả lời 17', 3, 0);

INSERT INTO categoryquestion (categoryname)
VALUES 
	('Golang'),
	('JS'),
    ('C'),
    ('HTML'),
    ('CSS'),
    ('Swift'),
    ('React'),
    ('Kotlin'),
    ('Go'),
    ('Rust');

INSERT INTO department (departmentname)
VALUES
	('Tài chính'),
    ('Công An'),
    ('Bộ đội'),
    ('Dân quân'),
    ('Kiểm sát'),
    ('Ca sĩ'),
    ('Diễn viên'),
    ('Kho'),
    ('Logistic'),
    ('Luật sư');

INSERT INTO exam (code, title, categoryID, duration, creatorID, createDate)
VALUES 
	('VTIQ011',	'Đề thi Golang', 7, '60', 1, '2019-04-05 00:00:00'),
    ('VTIQ012',	'Đề thi JS', 4, '120', 5, '2021-02-06 00:00:00'),
    ('VTIQ013',	'Đề thi C', 8, '90', 2, '2021-04-07 00:00:00'),
    ('VTIQ014',	'Đề thi Go', 2, '60', 4, '2023-09-08 00:00:00'),
    ('VTIQ015',	'Đề thi Rust', 3, '120', 3, '2024-08-09 00:00:00'),
    ('VTIQ016',	'Đề thi Kotlin', 1, '90',9, '2020-07-10 00:00:00'),
    ('VTIQ017',	'Đề thi Swift', 9, '60', 3, '2019-06-05 00:00:00'),
    ('VTIQ018',	'Đề thi CSS', 2, '60', 10, '2018-05-23 00:00:00'),
    ('VTIQ019',	'Đề thi React', 3, '120', 6, '2018-04-05 00:00:00'),
    ('VTIQ020',	'Đề thi HTML', 1, '60', 7, '2019-01-05 00:00:00');

INSERT INTO `group` (groupname, creatorID, createDate)
VALUES 
	('Beginner', 11, '2019-03-05 00:00:00'),
    ('Senior', 12, '2019-04-05 00:00:00'),
    ('Junior 1', 13, '2019-05-01 00:00:00'),
    ('Junior 2', 14, '2019-06-05 00:00:00'),
    ('Junior 3', 15, '2019-07-10 00:00:00'),
    ('Expert 1', 16, '2019-08-09 00:00:00'),
    ('Expert 2', 17, '2019-09-08 00:00:00'),
    ('VTI media', 18, '2019-03-07 00:00:00'),
    ('VTI content', 19, '2019-10-06 00:00:00'),
    ('VTI editor', 20, '2019-03-05 00:00:00');

INSERT INTO group_account (groupid, accountid, joindate)
VALUES 
	(15, 11, '2021-04-11 00:00:00'),
    (14, 12, '2021-04-12 00:00:00'),
    (12, 13, '2021-04-14 00:00:00'),
    (19, 14, '2021-06-11 00:00:00'),
    (20, 15, '2021-07-20 00:00:00'),
    (11, 16, '2021-08-19 00:00:00'),
    (10, 17, '2021-04-11 00:00:00'),
    (17, 18, '2021-03-22 00:00:00'),
    (9, 19, '2022-04-17 00:00:00'),
    (8, 20, '2022-06-15 00:00:00');

INSERT INTO question (content, categoryid, typeid, creatorid, createdate)
VALUES 
	('Hỏi về Golang', 11, 2, 11, '2021-04-08 00:00:00'),
    ('Hỏi về JS', 12, 1, 12, '2021-04-08 00:00:00'),
    ('Hỏi về C', 13, 2, 13, '2021-04-09 00:00:00'),
    ('Hỏi về HTML', 14, 2, 14, '2021-05-09 00:00:00'),
    ('Hỏi về CSS', 15, 1, 15, '2021-05-10 00:00:00'),
    ('Hỏi về Swift', 16, 2, 16, '2021-05-21 00:00:00'),
    ('Hỏi về React', 17, 1, 17, '2022-01-08 00:00:00'),
    ('Hỏi về Kotlin', 18, 2, 18, '2022-03-12 00:00:00'),
    ('Hỏi về Go', 19, 1, 19, '2022-05-11 00:00:00'),
    ('Hỏi về Rust', 20, 2, 20, '2022-06-08 00:00:00');

INSERT INTO  examquestion (questionid)
VALUES 
	(11),
    (17),
    (20),
    (18),
    (13),
    (12),
    (16),
    (15),
    (17),
    (20);

-- Q2 --
SELECT * FROM department; 

-- Q3 -- 
SELECT departmentid FROM department WHERE departmentname = 'Sale';

-- Q4 -- 
SELECT *
FROM account
WHERE CHAR_LENGTH(fullname) = (
    SELECT MAX(CHAR_LENGTH(fullname)) FROM account
);

-- Q5 -- 
SELECT *
FROM account
WHERE departmentid = 3 AND CHAR_LENGTH(fullname) = (
    SELECT MAX(CHAR_LENGTH(fullname)) FROM account
);

-- Q6 --
SELECT groupname FROM `group` WHERE createdate < '2019-12-20  00:00:00';

-- Q7 -- 
SELECT questionid
FROM (
	SELECT questionid, COUNT(questionid) AS soLuong
	FROM answer 
	GROUP BY questionid
) AS temp
WHERE soLuong >= 4;

 -- Q8 --    
 SELECT examid FROM exam 
 WHERE duration >=60 AND createdate < '2019-12-20 00:00:00'

-- Q9 --
SELECT * FROM `group`
ORDER BY createdate DESC 
LIMIT 5;

-- Q10 -- 
SELECT COUNT(accountid) FROM account 
WHERE DepartmentID = 2;

-- Q11 -- 
SELECT * FROM account 
WHERE fullname LIKE 'D%o';

-- Q12 --
DELETE FROM exam  WHERE createDate < '2019-12-20 00:00:00';

-- Q13 -- 
DELETE FROM question WHERE content LIKE 'câu hỏi%';

-- Q14 --
UPDATE account 
SET fullname = 'Nguyễn Bá Lộc' AND email = 'loc.nguyenba@vti.com.vn'
WHERE accountid = 5;

-- Q15 --
UPDATE group_account
SET groupid = 4
WHERE accountid = 5 ;