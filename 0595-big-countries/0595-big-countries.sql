# Write your MySQL query statement below
#we only have one table so no need of join as the queries just ask us for those countries whose area or population meets certain standards;
Select name,population,area
From World
Where area>=3000000 or population>=25000000