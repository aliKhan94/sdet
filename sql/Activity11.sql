SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name

select a.salesman_id, a.salesman_name, b.order_no, 'highest on', b.order_date, b.purchase_amount from salesman a, orders b
where a.salesman_id = b.salesman_id
and b.purchase_amount = (select max(purchase_amount) from orders c where c.order_date = b.order_date)
union
select a.salesman_id, a.salesman_name, b.order_no, 'lowest on', b.order_date, b.purchase_amount from salesman a, orders b
where a.salesman_id = b.salesman_id
and b.purchase_amount = (select min(purchase_amount) from orders c where c.order_date = b.order_date)
order by order_date
