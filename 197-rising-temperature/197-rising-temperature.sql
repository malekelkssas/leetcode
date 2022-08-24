# Write your MySQL query statement below
select id 
from Weather as w
where temperature > 
(
SELECT max(temperature)
from Weather
    where  recordDate= date_sub(w.recordDate, interval 1 day) 
)