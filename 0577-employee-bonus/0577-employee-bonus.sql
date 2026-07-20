# Write your MySQL query statement below
Select name,bonus from Employee e Left Join Bonus b on e.empId=b.empId where b.bonus<1000 or b.bonus is null;