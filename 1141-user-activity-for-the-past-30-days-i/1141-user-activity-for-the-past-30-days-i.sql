# Write your MySQL query statement below
select activity_date as day ,count(distinct user_id)  active_users
from Activity
group by activity_date having day between  date_sub(cast('2019-07-27' as date), interval 29 day) and cast('2019-07-27' as date)