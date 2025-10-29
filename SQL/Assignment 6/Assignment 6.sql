-- Q1 --
DELIMITER $$
CREATE PROCEDURE sp_DanhSachAccount (IN in_dep VARCHAR(30))
		BEGIN
			SELECT d.DepartmentID, d.DepartmentName, a.AccountID, a.PositionID, a.Email, a.Fullname
            FROM department d
            JOIN account a
            ON d.DepartmentID = a.DepartmentID
            WHERE d.DepartmentName = in_dep;
        END$$
DELIMITER ;

CALL sp_DanhSachAccount('Sale');

-- Q2 -- 	
DELIMITER $$
	CREATE PROCEDURE sp_soLuongAccount ()
		BEGIN
			SELECT g.groupID, COUNT(ga.accountID) AS soLuongAcc
            FROM group_account ga
            RIGHT JOIN `group` g
            ON ga.GroupID = g.GroupID
            GROUP BY g.GroupID ;
        END$$
DELIMITER ;

-- Q3 -- 
DELIMITER $$
	CREATE PROCEDURE sp_thongKeQuestion ()
		BEGIN
			SELECT tq.typeID, tq.typename, COUNT(q.QuestionID) AS soLuong
            FROM question q
            JOIN typequestion tq
            ON q.TypeID = tq.TypeID
            GROUP BY q.TypeID
            HAVING MONTH(q.CreateDate) = MONTH(curdate()) ;
            
        END$$
DELIMITER ;

-- Q4 --
DROP PROCEDURE IF EXISTS sp_dangCauHoiNhieuNhat;
DELIMITER $$
	CREATE PROCEDURE sp_dangCauHoiNhieuNhat(OUT o_countQuestion INT)
		BEGIN 
			WITH cte_dangCauHoiNhieuNhat AS (
				SELECT COUNT(QuestionID) AS soLuong FROM Question
				GROUP BY TypeID
			)
			SELECT TypeID INTO o_countQuestion FROM question
            GROUP BY TypeID
            HAVING COUNT(QuestionID) = (SELECT MAX(soLuong) FROM cte_dangCauHoiNhieuNhat);
		END$$
DELIMITER ;

SET @out_typeID = 0;
CALL sp_dangCauHoiNhieuNhat(@out_typeID);
SELECT @out_typeID;

-- Q5 --
SELECT TypeName FROM typequestion
WHERE TypeID = @out_typeID;

-- Q6 --


-- Q7 --
DROP PROCEDURE IF EXISTS sp_NhapVaoThongTin;
DELIMITER $$
	CREATE PROCEDURE sp_NhapVaoThongTin(IN in_fullName VARCHAR(30), IN in_email VARCHAR(50))
		BEGIN 
            ALTER TABLE account
            MODIFY positionID smallint unsigned DEFAULT 1;
            UPDATE account
            SET username = in_email, DepartmentID = NULL;
            SELECT * FROM account;
		END$$
DELIMITER ;

CALL sp_NhapVaoThongTin('LeQuocViet', 'vietlee@gmail.com');

-- Q8 --
DROP PROCEDURE IF EXISTS sp_contentDaiNhat;
DELIMITER $$
	CREATE PROCEDURE sp_contentDaiNhat (IN in_type ENUM('Essay', 'Multiple-Choice'))
		BEGIN 
			WITH cte_demcontent AS (
				SELECT q.content, LENGTH(q.content) AS soLuong 
                FROM question q
                JOIN typequestion tq
                ON q.TypeID = tq.TypeID 
                WHERE tq.TypeName = in_type
				GROUP BY q.content
			)
			SELECT q.QuestionID, q.Content, tq.TypeName
            FROM question q
            JOIN typequestion tq
            ON q.TypeID = tq.TypeID
            WHERE tq.TypeName = in_type AND LENGTH(content) = (SELECT MAX(soLuong) FROM cte_demcontent);
		END$$
DELIMITER ;

CALL sp_contentDaiNhat('Multiple-Choice');

-- Q9 --
DROP PROCEDURE IF EXISTS sp_xoaExam
DELIMITER $$
	CREATE PROCEDURE sp_xoaExam(IN in_ID INT)
		BEGIN 
			DELETE FROM exam
            WHERE examID = in_ID;
        END$$
DELIMITER ;

CALL sp_xoaExam(22);

-- Q10 --


