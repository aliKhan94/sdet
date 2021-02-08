select * from orders;

select sum(purchase_amount) Total_purchase_amount from orders;

select avg(purchase_amount) avg_purchase_amount from orders;

select max(purchase_amount) max_purchase_amount from orders;

select min(purchase_amount) min_purchase_amount from orders;

select count(salesman_id) salesman_count from orders group by (salesman_id);
