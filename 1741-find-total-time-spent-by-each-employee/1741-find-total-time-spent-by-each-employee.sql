# Write your MySQL query statement below
select event_day day , emp_id , (sum(out_time) - sum(in_time)) as total_time
from Employees
group by event_day , emp_id