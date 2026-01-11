# Write your MySQL query statement below
select name from customer where NOT referee_id = 2 OR referee_id IS null;