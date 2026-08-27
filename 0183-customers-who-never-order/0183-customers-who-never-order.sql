# Write your MySQL query statement below
#left join on the  table using cid and id and after after join those who got null in there cid are the ones with no order;
select c1.name AS Customers
FROM customers c1 
left join orders c2
on c1.id=c2.customerId
where c2.customerId is null