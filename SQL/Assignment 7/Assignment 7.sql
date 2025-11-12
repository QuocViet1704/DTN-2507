-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS Trg_BfInsertIntoGroupCheckDate;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertIntoGroupCheckDate
	BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF(NEW.CreateDate <= CURDATE()- INTERVAL 1 YEAR) THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant insert this Record !!!';
		END IF;
    END$$
DELIMITER ;

INSERT INTO `group` (groupName, creatorID, createDate)
VALUE ('Test', 10, '2019-03-05 00:00:00');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
DROP TRIGGER IF EXISTS Trg_BfInsertIntoAccountCheckDepartment;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertIntoAccountCheckDepartment 
	BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
		DECLARE v_dep VARCHAR(50);
        SELECT DepartmentName INTO v_dep FROM department WHERE DepartmentID = 2;
        IF(NEW.DepartmentID = 2) THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Department Sale cannot add more user';
        END IF;
    END$$
DELIMITER ;

INSERT INTO `testingsystem1`.`account` (`Email`, `Username`, `Fullname`, `DepartmentID`, `positionID`, `CreateDate`) VALUES ('vietle@gmail.com', 'Viett', 'QuocViet', '1', '1', '2022-02-28 00:00:00');

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Trg_BfInsertGroupAccountCheckMax5Members;
DELIMITER $$
CREATE TRIGGER Trg_BfInsertGroupAccountCheckMax5Members
	BEFORE INSERT ON group_account
    FOR EACH ROW
    BEGIN 
		DECLARE v_checkNumberOfMembers INT;
		
        SET v_checkNumberOfMembers = (
			SELECT COUNT(AccountID) FROM group_account 
			WHERE GroupID = NEW.GroupID
        );
		
        
        IF (v_checkNumberOfMembers >= 5) THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant insert more member, group must have no more than 5 members';
		END IF;
    END $$
DELIMITER ;

INSERT INTO group_account (GroupID, AccountID)
VALUES (1, 19);

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Trg_BfInsertExamQuesrtionCheckMax10Questions;
DELIMITER $$ 
	CREATE TRIGGER Trg_BfInsertExamQuesrtionCheckMax10Questions
    BEFORE INSERT ON examquestion
    FOR EACH ROW
    BEGIN 
		DECLARE v_checkNumberOfQuestions INT;
        
        SET v_checkNumberOfQuestions = (
			SELECT COUNT(QuestionID) FROM examquestion
            WHERE ExamID = NEW.ExamID
        );
        
        IF(v_checkNumberOfQuestions >= 10) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cant insert more question, exam must have no more than 10 questions';
        END IF;
    END$$
DELIMITER ;

INSERT INTO examquestion(ExamID, QuestionID)
VALUE (20,2);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS Trg_BfDeleteRecordCheckIfAdminGmail;
DELIMITER $$ 
	CREATE TRIGGER Trg_BfDeleteRecordCheckIfAdminGmail
    BEFORE DELETE ON account
    FOR EACH ROW
    BEGIN
		DECLARE v_RecordEmail VARCHAR(50);
        SELECT Email INTO v_RecordEmail FROM account
        WHERE AccountID = OLD.AccountID;
        
        IF(v_RecordEmail = 'admin@gmail.com') THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cant delete this Record, this is Admin account !!!';
        END IF;
    END$$
DELIMITER ;

DELETE FROM account
WHERE AccountID = 0;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department
DROP TRIGGER IF EXISTS Trg_BfInsertAccountMakeDefaultDepID;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertAccountMakeDefaultDepID
    BEFORE INSERT ON Account
    FOR EACH ROW
		BEGIN
			IF(NEW.DepartmentID IS NULL) THEN
				SET NEW.DepartmentID = 0;
            END IF;
        END$$
DELIMITER ;

INSERT INTO `testingsystem1`.`account` (`AccountID`, `Email`, `Username`, `Fullname`) VALUES ('44', 'vietlee@gmail.com', 'Viet', 'LeQuocViet');

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS Trg_BfInsertAnswersCheckMax4Questions2RightAnswers;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertAnswersCheckMax4Questions2RightAnswers
    BEFORE INSERT ON Answer 
    FOR EACH ROW
    BEGIN 
		DECLARE v_countAnswer INT;
        DECLARE v_countRightAnswer INT;
        
        SELECT COUNT(QuestionID) INTO v_countAnswer FROM answer
        WHERE QuestionID = NEW.QuestionID 
        GROUP BY QuestionID;
	
        SELECT COUNT(isCorrect) INTO v_countRightAnswer FROM answer
        WHERE QuestionID =NEW.QuestionID AND isCorrect = 1
        GROUP BY QuestionID;
       
		IF(v_countAnswer >= 5 OR v_countRightAnswer >= 2) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cant insert Record, Question must not have more than 5 answer and 2 correct answer';
        END IF;
    END$$ 
DELIMITER ;
SHOW TRIGGERS LIKE 'answer';

INSERT INTO `testingsystem1`.`answer` (`AnswerID`, `Content`, `QuestionID`, `isCorrect`) VALUES ('21', 'Trả lời 21', '1', b'1');

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS Trg_BfInsertAccountCheckGender
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertAccountCheckGender
    BEFORE INSERT ON Account
    FOR EACH ROW
    BEGIN
		IF(NEW.Gender = 'nam') THEN 
        SET NEW.Gender = 'Male';
        ELSEIF(NEW.Gender = 'nữ') THEN 
        SET NEW.Gender = 'Female';
        ELSEIF(NEW.Gender = 'chưa xác định') THEN 
        SET NEW.Gender = 'Unknown';
        END IF;
    END$$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Trg_BfDeleteExamCheckCreateDate;
DELIMITER $$
	CREATE TRIGGER Trg_BfDeleteExamCheckCreateDate
    BEFORE DELETE ON exam
    FOR EACH ROW
    BEGIN
		DECLARE v_date DATETIME;
		SELECT CreateDate INTO v_date FROM exam
        WHERE examID = OLD.ExamID;
        
		IF(TIMESTAMPDIFF(DAY, OLD.CreateDate, NOW()) <= 2) THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cant delete exam within 2 days of creation';
        END IF;
    END$$
DELIMITER ;

DELETE FROM `testingsystem1`.`exam` WHERE (`ExamID` = '16');

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Trg_BfDeleteteCheckIfQuestionInAnyExam;
DELIMITER $$ 
	CREATE TRIGGER Trg_BfDeleteOrUpdateCheckIfQuestionInAnyExam
    BEFORE DELETE ON question
    FOR EACH ROW
    BEGIN 
		DECLARE cnt INT;
        
		SELECT COUNT(QuestionID) INTO cnt FROM examquestion
        WHERE QuestionID = 6;
        
        IF(cnt > 0) THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Question already in an exam, cannot delete !!';
        END IF;
    END$$
DELIMITER ;

DROP TRIGGER IF EXISTS Trg_BfUpdateCheckIfQuestionInAnyExam;
DELIMITER $$
	CREATE TRIGGER Trg_BfUpdateCheckIfQuestionInAnyExam
    BEFORE UPDATE ON question
    FOR EACH ROW
    BEGIN 
		IF EXISTS (
			SELECT 1 
            FROM examquestion
            WHERE QuestionID = OLD.QuestionID
        ) THEN 
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Question already in an exam, cannot update !!';
        END IF;
	END$$
DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
DROP PROCEDURE IF EXISTS sp_ChangeInfoExam;
DELIMITER $$ 
	CREATE PROCEDURE sp_ChangeInfoExam()
		BEGIN
			SELECT ExamID, Code, Title, CategoryID, Duration, 
            CASE 
				WHEN Duration <= 30 THEN 'Short time'
                WHEN Duration > 30 AND Duration <= 60 THEN 'Medium time'
                ELSE 'Long time'
			END AS DurationType
            FROM exam;
		END$$
DELIMITER ;

CALL sp_ChangeInfoExam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
DROP PROCEDURE IF EXISTS sp_changeInfoAccount;
DELIMITER $$
	CREATE PROCEDURE sp_changeInfoAccount()
    BEGIN 
		SELECT GroupID, COUNT(groupID) AS theNumberOfUsers, 
        CASE 
			WHEN  COUNT(groupID) <= 5 THEN 'few'
            WHEN  COUNT(groupID) > 5 AND  COUNT(groupID) <= 20 THEN 'normal'
            ELSE 'higher'
		END AS the_number_user_amount
        FROM group_account
        GROUP BY GroupID;
    END$$
DELIMITER ;

CALL sp_changeInfoAccount;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
DROP PROCEDURE IF EXISTS sp_changeInfoDep;
DELIMITER $$
	CREATE PROCEDURE sp_changeInfoDep()
    BEGIN 
		SELECT d.DepartmentID, COUNT(a.DepartmentID),
        CASE 	
			WHEN COUNT(a.DepartmentID) = 0 THEN 'Khong co User'
		END AS depType
        FROM account a
        RIGHT JOIN department d
        ON a.DepartmentID = d.DepartmentID
        GROUP BY d.DepartmentID
        
    END$$
DELIMITER ; 

	
