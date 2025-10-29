-- Q1 --
DROP VIEW IF EXISTS vw_NhanVienPhongBanSale;
CREATE OR REPLACE VIEW vw_NhanVienPhongBanSale AS (
	SELECT a.AccountID, a.Email, a.Fullname, d.DepartmentName 
	FROM account a
	JOIN department d
	ON d.departmentID = a.departmentID 
	WHERE d.DepartmentName = 'Sale'
);

-- Q2 -- 
DROP VIEW IF EXISTS vw_accthamgianhieuphongbannhat;
CREATE OR REPLACE VIEW vw_accthamgianhieuphongbannhat AS (
	SELECT a.AccountID, a.Email, a.Fullname ,COUNT(ga.AccountID) SL 
	FROM group_account ga
	JOIN account a
	ON ga.AccountID = a.AccountID
	GROUP BY ga.AccountID
	ORDER BY SL DESC
);

-- Q3 --
DROP VIEW IF EXISTS vw_contentquadai;
CREATE OR REPLACE VIEW vw_contentquadai AS
	SELECT * FROM question
	WHERE (LENGTH(TRIM(content)) - LENGTH(REPLACE(TRIM(content), ' ' , '')) + 1) > 300;
    
    DELETE FROM question
    WHERE (LENGTH(TRIM(content)) - LENGTH(REPLACE(TRIM(content), ' ' , '')) + 1) > 300;

-- Q4 --
DROP VIEW IF EXISTS Vw_PhongBanNhieuNhanVienNhat;
CREATE OR REPLACE VIEW Vw_PhongBanNhieuNhanVienNhat AS (
	WITH cte_maxCount AS(
		SELECT COUNT(DepartmentID) AS SL 
		FROM account 
		GROUP BY DepartmentID 
	)
	SELECT d.DepartmentID, d.DepartmentName, COUNT(a.DepartmentID) 
	FROM account a
	JOIN department d
	ON d.DepartmentID = a.DepartmentID
	GROUP BY d.DepartmentID
	HAVING Count(a.DepartmentID) = (
		SELECT MAX(SL) FROM cte_maxCount 
	)
);
    
-- Q5 --


