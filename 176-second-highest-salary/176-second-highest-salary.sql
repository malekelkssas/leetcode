# Write your MySQL query statement below
select max(salary) as SecondHighestSalary
from 
(
    select salary from Employee
where salary not in(
select max(salary) from Employee
    )
) salary