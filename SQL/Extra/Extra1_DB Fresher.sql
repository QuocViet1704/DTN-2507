-- CREATE DATABASE fresher;
-- USE  fresher;

-- Q1 --

-- CREATE TABLE Trainee (
-- 	TraineeID 			SMALLINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     Full_Name 			VARCHAR(30) NOT NULL,
--     Birth_Date 		DATE,
--     Gender 				ENUM ('MALE', 'FEMALE', 'UNKNOWN'),
--     ET_IQ  				TINYINT UNSIGNED NOT NULL CHECK (ET_IQ >=0 AND ET_IQ <=20),
--     ET_Gmath			TINYINT UNSIGNED NOT NULL CHECK (ET_Gmath >=0 AND ET_Gmath <= 20),
--     ET_English 			TINYINT UNSIGNED NOT NULL CHECK (ET_English >=0 AND ET_English <= 50),
--     Training_Class 		VARCHAR(10) NOT NULL,
--     Evaluation_Notes	VARCHAR(20) NOT NULL
-- );


-- Q2 --

-- INSERT INTO  trainee (full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes)
-- VALUES
-- 	('Lê Quốc Việt', '2004-04-17', 'MALE', 20, 19, 45, 'VTI001', 'DHGTVT' ),
--     ('Nguyễn Thành Sinh', '2004-08-23', 'MALE', 18, 20, 35, 'VTI004', 'DHCMC'),
--     ('Nguyễn Hùng Mạnh', '2003-11-15', 'MALE', 15, 20, 48, 'VTI002', 'DHKTQD'),
--     ('Nguyễn Khắc Trường', '2000-12-20', 'MALE', 16, 16, 10, 'VTI001', 'DHFPT'),
--     ('Nguyễn Hương Giang', '2004-05-15', 'FEMALE', 10, 18, 30, 'VTI005', 'DHCD'),
--     ('Vũ Huyền Trang', '2003-05-03', 'FEMALE', 10, 09, 47, 'VTI005', 'DHCD'),
--     ('Lê Thanh Thủy', '2002-03-10', 'FEMALE', 19, 20, 50, 'VTI002', 'DHNT'),
--     ('Phạm Chi', '2003-04-01', 'FEMALE', 15, 15, 45, 'VTI003', 'HVNH'),
--     ('Nguyễn Trung Hiếu', '2004-10-05', 'MALE', 6, 7, 5, 'VTI004', 'DHGTVT'),
-- 	('Phạm Hoàng Tú', '2000-01-01', 'UNKNOWN', 5, 10, 9, 'VTI003', 'DHFPT');

-- Q3 --

-- INSERT INTO trainee (full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes)
-- VALUE 
-- 	('Nguyễn Văn A', '2020-01-01', 'MALE', 30, 20 ,40, 'VTI000', 'DHBKHN')

-- Hiện lỗi sau khi chạy: Error Code: 3819. Check constraint 'trainee_chk_1' is violated. 

-- Q4 --

-- SELECT * FROM trainee
-- WHERE ET_IQ >= 12 AND ET_Gmath >= 12 AND ET_English >= 20
-- ORDER BY birth_date 

-- Q5 -- 

-- SELECT * FROM trainee
-- WHERE full_name LIKE 'N%C'

-- Q6 --

-- Q7 -- 
SELECT * FROM trainee
WHERE full_name LIKE '---------C';

-- Q8 --
SELECT DISTINCT full_name FROM trainee;

-- Q9 -- 
SELECT full_name FROM trainee
ORDER BY full_name ASC;

-- Q10 --
SELECT * FROM trainee
WHERE CHAR_LENGTH(full_name) = (
	SELECT MAX(CHAR_LENGTH(full_name)) AS maxLength FROM trainee
); 

-- Q11 --
SELECT TraineeID, full_name, birth_date FROM trainee
WHERE CHAR_LENGTH(full_name) = (
	SELECT MAX(CHAR_LENGTH(full_name)) AS maxLength FROM trainee
);

-- Q12 -- 
SELECT full_name, et_iq, et_gmath, et_english FROM trainee
WHERE CHAR_LENGTH(full_name) = (
	SELECT MAX(CHAR_LENGTH(full_name)) AS maxLength FROM trainee
);

-- Q13 -- 
SELECT * FROM trainee
ORDER BY birth_date DESC
LIMIT 5;

-- Q15 --
DELETE FROM trainee WHERE TraineeID = 5;

-- Q16 --
DELETE FROM trainee WHERE et_iq <= 15 AND et_gmath <= 15;

-- Q17 -- 
DELETE FROM trainee WHERE birdth_date <= '1995-01-01';

-- Q18 -- 
UPDATE trainee
SET training_class = 'VTI003'
WHERE traineeid = 3;

-- Q19 -- 
UPDATE trainee
SET full_name = 'Le Van A', et_iq = 10, et_gmath = 15, et_english = 30
WHERE traineeid = 10;

-- Q20 -- 
SELECT COUNT(*) AS soLuong FROM trainee 
WHERE training_class = 'VTI001';

-- Q22 -- 
SELECT COUNT(*) AS tongSoLuong FROM trainee
WHERE training_class = 'VTI001' OR training_class = 'VTI003';

-- Q23 -- 
SELECT gender, COUNT(gender) AS soLuong FROM trainee
GROUP BY gender;

 -- Q24 -- 
SELECT training_class, COUNT( training_class) AS soLuong FROM trainee
GROUP BY training_class
HAVING soLuong >= 3;

-- Q27 -- 
SELECT traineeid, full_name, training_class FROM trainee 
WHERE training_class = 'VTI001'
UNION
SELECT traineeid, full_name, training_class FROM trainee 
WHERE training_class = 'VTI002';


