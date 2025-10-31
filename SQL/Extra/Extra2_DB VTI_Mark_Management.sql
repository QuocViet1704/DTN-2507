-- CREATE DATABASE VTI_Mark_Management;
USE VTI_Mark_Management;

CREATE TABLE Trainee (
		Trainee_ID		SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
        First_Name		VARCHAR(30),	
        Last_Name		VARCHAR(30),
        Age				TINYINT UNSIGNED,
        Gender 			ENUM ('Male', 'Female', 'Unknown')
);

CREATE TABLE Subject (
	Subject_ID			SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Subject_Name 		ENUM ('MySQL', 'JavaCore', 'FronEnd Basic', 'Spring Framework', 'FrontEnd Advance', 'Mock Project', 'BackEnd Basic', 'BackEnd Advance')
);

CREATE TABLE Trainee_Subject (
	Trainee_ID		SMALLINT UNSIGNED,
	Subject_ID		SMALLINT UNSIGNED,
    PRIMARY KEY (Trainee_ID, Subject_ID),
	FOREIGN KEY(Subject_ID) REFERENCES Subject (Subject_ID),
    Mark			FLOAT UNSIGNED,
    Exam_day		DATETIME
);

-- Q1 -- 
INSERT INTO Trainee (First_Name, Last_Name, Age, Gender)
VALUES 
	('Việt', 'Lê Quốc', 21, 'Male'),
    ('Mạnh', 'Nguyễn Hùng', 20, 'Male'),
    ('Chi', 'Phạm Phương', 22, 'Female'),
    ('Trường', 'Nguyễn Khắc', 21, 'Male');
    
INSERT INTO subject (Subject_Name)
VALUES 
	('MySQL'),
    ('JavaCore'),
    ('FronEnd Basic'),
    ('Spring Framework'),
    ('FrontEnd Advance'),
    ('Mock Project'),
    ('BackEnd Basic'),
    ('BackEnd Advance');
    
INSERT INTO Trainee_Subject (Trainee_ID, Subject_ID, Mark, Exam_day)
VALUES 
	(1, 8, 9, '2022-10-09 00:00:00'),
    (2, 3, 8, '2022-11-10 00:00:00'),
    (3, 5, 9.5, '2022-11-15 00:00:00'),
    (4, 1, 7.75, '2022-11-15 00:00:00');

-- Q2 a --
SELECT s.Subject_ID, s.Subject_Name, COUNT(ts.Subject_ID) AS count
FROM trainee_subject ts
RIGHT JOIN subject s
ON ts.Subject_ID = s.Subject_ID
GROUP BY s.Subject_ID
HAVING count = 0;

-- Q2 b --
SELECT s.Subject_ID, s.Subject_Name, COUNT(ts.Subject_ID) AS count
FROM trainee_subject ts
RIGHT JOIN subject s
ON ts.Subject_ID = s.Subject_ID
GROUP BY s.Subject_ID
HAVING count >= 2;

-- Q3 -- 
CREATE VIEW TraineeInfo AS 
SELECT t.Trainee_ID, CONCAT(t.Last_Name, ' ', t.First_Name) AS FullName, t.Age, t.Gender, s.Subject_ID, s.Subject_Name, ts.Mark, ts.Exam_day
FROM trainee_subject ts
JOIN subject s
ON ts.Subject_ID = s.Subject_ID
JOIN trainee t
ON 	ts.Trainee_ID = t.Trainee_ID

-- Q4 a--






    