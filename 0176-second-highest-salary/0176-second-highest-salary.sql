# Write your MySQL query statement below
select MAX(salary) AS SecondHighestSalary 
FROM Employee
where salary < (select MAX(salary) from Employee);