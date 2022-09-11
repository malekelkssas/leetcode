CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare var int;
set var = N-1;
  RETURN (
      select distinct(salary)
      from Employee
      order by salary desc
      limit 1
      offset var
  );
END