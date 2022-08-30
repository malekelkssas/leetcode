SELECT user_id, MAX(time_stamp) AS 'last_stamp'
FROM Logins
WHERE time_stamp > '2019-12-31 23:59:59' and time_stamp < '2021-01-01 0:0:01'
group by user_id;