# Write your MySQL query statement below
#we need to join the same tables but on different basis that is on the basis of managerid
select e1.name as Employee
from Employee e1
join Employee e2 
on e1.managerId=e2.id
where e1.salary>e2.salary