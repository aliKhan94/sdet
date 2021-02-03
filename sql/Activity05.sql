update salesman 
set grade = 200 
where salesman_city = 'Rome';

update salesman 
set grade = 300 
where salesman_name = 'James Hoog';

update salesman 
set salesman_name = 'Pierre' 
where salesman_name = 'McLyon';

select * from salesman;
