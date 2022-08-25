# Write your MySQL query statement below
select sell_date,count(distinct product) num_sold,GROUP_CONCAT(distinct product) products
from Activities
group by sell_date

#function returns a string with concatenated non-NULL value from a group.