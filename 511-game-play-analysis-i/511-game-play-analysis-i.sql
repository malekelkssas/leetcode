# Write your MySQL query statement below
select distinct player_id , event_date as first_login
from Activity as a
where event_date = 
(
select min(event_date)
    from Activity
    where a.player_id = player_id
)