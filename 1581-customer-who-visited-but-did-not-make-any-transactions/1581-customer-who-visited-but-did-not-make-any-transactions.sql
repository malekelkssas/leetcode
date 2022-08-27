# Write your MySQL query statement below
select ci customer_id , count(ci) count_no_trans
from 
(
select Visits.customer_id ci,Transactions.amount as tr from Visits
left join Transactions on Transactions.visit_id= Visits.visit_id
)as ass
where tr is null
group by ci