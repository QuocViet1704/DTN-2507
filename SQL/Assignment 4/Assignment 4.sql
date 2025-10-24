USE testingsystem1;

-- Q1 --
SELECT * FROM account AS acc
JOIN department AS dpm
ON acc.departmentid = dpm.departmentid;

-- Q2 --
SELECT * FROM account
WHERE createdate < '2010-12-20 00:00:00';

-- Q3 -- 
SELECT * FROM account AS acc
JOIN position AS pos
ON acc.positionid = 1 AND pos.positionid = 1;

-- Q4 --
SELECT dpm.departmentname ,dpm.departmentid, COUNT(acc.departmentid) AS count FROM account AS acc
JOIN department AS dpm
ON acc.DepartmentID = dpm.DepartmentID
GROUP BY acc.DepartmentID
HAVING count > 3;

-- Q5 --
WITH cte_soLuongDeThi AS (
	SELECT QuestionID, COUNT(QuestionID) AS soLuongDeThi FROM examquestion
	GROUP BY QuestionID
),
cte_MaxUsedExam AS (
	SELECT MAX(soLuongDeThi) AS maxUsedExam FROM (
			SELECT soLuongDeThi FROM cte_soLuongDeThi
		) AS temp
)

SELECT q.Content, q.QuestionID, COUNT(eq.QuestionID) 
FROM examquestion eq
JOIN question q
ON q.questionID = eq.questionID
GROUP BY q.QuestionID
HAVING COUNT(q.QuestionID) = (
	SELECT maxUsedExam FROM cte_MaxUsedExam
);

-- Q6 -- 
SELECT cq.CategoryName, cq.CategoryID, COUNT(q.categoryID) AS QuestionCount
FROM question AS q
RIGHT JOIN categoryquestion AS cq
ON cq.CategoryID = q.CategoryID
GROUP BY cq.CategoryID;

-- Q7 -- 
SELECT q.Content, q.QuestionID, COUNT(eq.QuestionID) AS ExamCount
FROM examquestion AS eq
RIGHT JOIN question AS q
ON q.QuestionID = eq.QuestionID
GROUP BY q.QuestionID;

-- Q8 -- 
SELECT q.Content, q.QuestionID, COUNT(a.QuestionID) 
FROM answer a
JOIN question q
ON a.QuestionID = q.QuestionID
GROUP BY q.QuestionID
HAVING COUNT(a.QuestionID) = (
	SELECT MAX(soCauTraLoi) FROM (
		SELECT QuestionID, COUNT(QuestionID) AS soCauTraLoi FROM answer
		GROUP BY QuestionID
	) AS temp
);

-- Q9 -- 
SELECT g.GroupID, g.GroupName, COUNT(ga.GroupID) AS soLuongAccount
FROM group_account ga
RIGHT JOIN `group` g
ON g.GroupID = ga.GroupID
GROUP BY g.GroupID;

-- Q10 -- 
SELECT p.PositionName, p.PositionID, COUNT(a.PositionID) AS soLuongThanhVien
FROM position p
JOIN account a
ON a.PositionID = p.PositionID
GROUP BY p.PositionID
HAVING COUNT(p.PositionID) = (
	SELECT MIN(soLuong) FROM (
		SELECT PositionID, COUNT(PositionID) AS soLuong FROM account
		GROUP BY PositionID
	) AS temp
);

-- Q11 -- 
SELECT d.DepartmentName, d.DepartmentID, p.PositionName, COUNT(*) 
FROM account a
JOIN position p ON a.PositionID = p.PositionID
JOIN department d ON d.DepartmentID = a.DepartmentID
GROUP BY p.PositionID, d.DepartmentID;

-- Q13 --
SELECT tq.typename, tq.TypeID, COUNT(q.TypeID) AS soLuongCauHoi
FROM question q
JOIN typequestion tq
ON q.TypeID = tq.TypeID
GROUP BY tq.TypeID;

-- Q14 --
SELECT gr.GroupName, gr.GroupID, COUNT(ga.GroupID) AS soLuong
FROM group_account ga
JOIN `group` gr
ON gr.GroupID = ga.GroupID
GROUP BY gr.GroupID
HAVING soLuong = 0;




