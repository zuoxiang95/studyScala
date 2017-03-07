-- 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT sname, ssex, "class" FROM student;

-- 查询教师所有的单位即不重复的Depart列。
SELECT DISTINCT depart FROM teacher;

-- 查询Student表的所有记录。
SELECT * FROM student;

-- 查询Score表中成绩在60到80之间的所有记录。
SELECT * FROM score WHERE degree BETWEEN 60 AND 80;

-- 查询Score表中成绩为85，86或88的记录。
SELECT * FROM score WHERE degree = 85 OR degree = 86 OR degree = 88;

-- 查询Student表中“95031”班或性别为“女”的同学记录。
select * from student where ssex = '女' or "class" = '95031';

-- 以Class降序查询Student表的所有记录。
select * from student order by "class" desc;

-- 以Cno升序、Degree降序查询Score表的所有记录。
select * from score order by cno ,degree desc;

-- 查询“95031”班的学生人数。
select count(*) from student where "class" = '95031'

-- 查询Score表中的最高分的学生学号和课程号。
select sno, cno from score where "degree" = (select max("degree") from score)
