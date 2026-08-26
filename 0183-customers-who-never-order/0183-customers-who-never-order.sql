# Write your MySQL query statement below
#What i am thinking is using a right join and then joining the first table to the second using the id and customer id and then using where clause and notin clause;
-- SELECT c.name AS Customers
-- FROM CUSTOMERS c
-- WHERE id NOT IN(
--     SELECT c.id
--     FROM customers c RIGHT JOIN orders o ON c.id=o.customerId
-- )
#even better solution is->
#selecting those customers after applying left join whose value is null
SELECT c.name as Customers
from customers c
Left Join orders o on c.id=o.customerId
where o.customerId is null;