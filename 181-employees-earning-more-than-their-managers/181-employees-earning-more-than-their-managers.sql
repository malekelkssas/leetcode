# Write your MySQL query statement below
select name as Employee
from Employee as em
where salary > 
(
select salary
from Employee
where id  = em.managerId
)