# Write your MySQL query statement below
select  Users.name name , sum(Transactions.amount) as balance
from Users
join Transactions
where Users.account = Transactions.account 
group by name having balance > 10000