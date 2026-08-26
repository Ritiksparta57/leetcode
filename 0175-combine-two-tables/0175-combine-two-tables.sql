# Write your MySQL query statement below
#we want the first name,last name,city and state of a person which has its information stored in two tables;
#therefore join will be applied;
#And the basis or the column on which they will be joined will be personId;
#Also we want the  null to be represented thus no need to worry about null check;
#One More important thing that is since we want all from the first table then we use left join as every category from person is used;
Select person.firstName,person.lastName,address.city,address.state
FROM Person Left Join Address ON person.personId=address.personId
