# Write your MySQL query statement below
select employee_id from Employees
where employee_id not in(
Select distinct Employees.employee_id
from Employees
join Salaries on Employees.employee_id = Salaries.employee_id
)
union
select employee_id from Salaries
where employee_id not in(
Select distinct Employees.employee_id
from Employees
join Salaries on Employees.employee_id = Salaries.employee_id
)
order by employee_id


# Select employee_id
# from Employees
# where employee_id in()

