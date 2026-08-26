# Write your MySQL query statement below
#What i am thinking is using a right join and then joining the first table to the second using the id and customer id and then using where clause and notin clause;
SELECT c.name AS Customers
FROM CUSTOMERS c
WHERE id NOT IN(
    SELECT c.id
    FROM customers c RIGHT JOIN orders o ON c.id=o.customerId
)