# Write your MySQL query statement below
delete p1
from Person p1
join Person p2
on p1.email=p2.email
and p1.id>p2.id
#so here this query deletes the record p1 from person which in case has same email as p2 which is said by the join clause as join is performed only by matching subjects/elements;
#also if p1 is having greater id than p2 then p1 gets deleted;