# Write your MySQL query statement below
#at first u will think that join is required as the customer is referrin to others;
#but that is not true as we just need the names of those customers who does not have a refer id of 2;
SELECT name
FROM CUSTOMER 
Where referee_id!=2 or referee_id is null;