-- 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT sname, ssex, "class" FROM student;

-- 查询教师所有的单位即不重复的Depart列。
SELECT DISTINCT depart FROM teacher;

-- 查询Student表的所有记录。
SELECT * FROM student;

-- 查询Score表中成绩在60到80之间的所有记录。
SELECT * FROM score WHERE "degree" BETWEEN 60 AND 80;

-- 查询Score表中成绩为85，86或88的记录。
SELECT * FROM score WHERE "degree" = 85 OR "degree" = 86 OR "degree" = 88;
SELECT * FROM score WHERE "degree" in (85,86, 88);

-- 查询Student表中“95031”班或性别为“女”的同学记录。
select * from student where ssex = '女' or "class" = '95031';

-- 以Class降序查询Student表的所有记录。
select * from student order by "class" desc;

-- 以Cno升序、Degree降序查询Score表的所有记录。
select * from score order by cno ,"degree" desc;

-- 查询“95031”班的学生人数。
select count(*) from student where "class" = '95031'

-- 查询Score表中的最高分的学生学号和课程号。
select sno, cno from score where "degree" = (select max("degree") from score)

-- 查询‘3-105’号课程的平均分。
select avg("degree") from score where  cno = '3-105'

-- 查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。（计数条件使用having函数来进行筛选）
select avg("degree") from score where cno like '3%' group by cno having count(*) >= 5

-- 查询最低分大于70，最高分小于90的Sno列。
select sno from score group by sno having max("degree") < 90 and min("degree") > 70

-- 查询所有学生的Sname、Cno和Degree列。(使用join来从两个表中获取数据)
SELECT
	student.sname,
	score.cno,
	score."degree"
FROM
	student AS student
JOIN score ON student.sno = score.sno

-- 查询所有学生的Sno、Cname和Degree列。(多个表之间的连接可以使用多个join来进行连接查询)
SELECT
	student.sno,
	course.cno,
	score."degree"
FROM
	student AS student
JOIN score ON student.sno = score.sno
JOIN course ON score.cno = course.cno;

-- 查询所有学生的Sname、Cname和Degree列。
SELECT
	student.sname,
	course.cname,
	score."degree"
FROM
	student AS student
JOIN score ON student.sno = score.sno
JOIN course ON score.cno = course.cno

-- 查询“95033”班所选课程的平均分。
SELECT
	AVG ("degree")
FROM
	score AS score
JOIN student ON student.sno = score.sno
WHERE
	student."class" = '95033';

-- 查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
SELECT
	*
FROM
	score
WHERE
	cno = '3-105'
AND "degree" > (
	SELECT
		"degree"
	FROM
		score
	WHERE
		sno = '109'
	AND cno = '3-105'
)

-- 查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。

-- 查询成绩高于学号为“109”-- 课程号为“3-105”的成绩的所有记录。
-- 查询和学号为108的同学同年出生的所有学生的Sno-- Sname和Sbirthday列。
-- 查询“张旭“教师任课的学生成绩。
-- 查询选修某课程的同学人数多于5人的教师姓名。
-- 查询95033班和95031班全体学生的记录。
-- 查询存在有85分以上成绩的课程Cno.
-- 查询出“计算机系“教师所教课程的成绩表。
-- 查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
-- 查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno-- Sno和Degree,并按Degree从高到低次序排序。
-- 查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno-- Sno和Degree.
-- 查询所有教师和同学的name-- sex和birthday.
-- 查询所有“女”教师和“女”同学的name-- sex和birthday.
-- 查询成绩比该课程平均成绩低的同学的成绩表。
-- 查询所有任课教师的Tname和Depart.
-- 查询所有未讲课的教师的Tname和Depart.
-- 查询至少有2名男生的班号。
-- 查询Student表中不姓“王”的同学记录。
-- 查询Student表中每个学生的姓名和年龄。
-- 查询Student表中最大和最小的Sbirthday日期值。
-- 以班号和年龄从大到小的顺序查询Student表中的全部记录。
-- 查询“男”教师及其所上的课程。
-- 查询最高分同学的Sno-- Cno和Degree列。
-- 查询和“李军”同性别的所有同学的Sname.
-- 查询和“李军”同性别并同班的同学Sname.
-- 查询所有选修“计算机导论”课程的“男”同学的成绩表