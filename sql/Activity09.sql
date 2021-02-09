select salesman_name, customer_name from customers c 
inner join salesman s on c.salesman_id = s.salesman_id order by salesman_name, customer_name


select c.customer_name, c.city, c.grade, s.salesman_name, s.salesman_city from customers c
left join salesman s on c.salesman_id = s.salesman_id where c.grade < 300
order by customer_id

select c.customer_name, s.salesman_name, s.commission from customers c
inner join salesman s on c.salesman_id = s.salesman_id
where s.commission > 12

select o.order_no, o.order_date, o.purchase_amount, c.customer_name, s.salesman_name from orders o
inner join customers c on o.customer_id = c.customer_id
inner join salesman s on o.salesman_id = s.salesman_id


