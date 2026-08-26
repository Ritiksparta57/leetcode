#This can be done using group by and having clause;
#GROUP BY IS USED TO GROUP THE WHOLE TABLE INTO CERTAIN THINGS THAT MAY BE USEFUL IN AGGREGATE FUNCTIONS;
#Having is used to filter data that is already grouped using group by;
Select person.email As Email
from person
GROUP BY person.email
HAVING COUNT(*)>1