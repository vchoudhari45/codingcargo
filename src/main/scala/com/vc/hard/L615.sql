select
department_average_table.pay_month,
department_average_table.department_id,
(
 case
    when department_average_table.department_average > company_average_table.company_average then 'higher'
    when department_average_table.department_average < company_average_table.company_average then 'lower'
    else 'same'
 end
) as comparison
from
(
    select
    DATE_FORMAT(pay_date, "%Y-%m") as pay_month,
    department_id, round(sum(s.amount) / count(s.id), 2) department_average
    from salary s inner join employee e
    on s.employee_id = e.employee_id
    group by pay_month, e.department_id
) department_average_table left outer join
(
    select
    DATE_FORMAT(pay_date, "%Y-%m") as pay_month,
    round(sum(s.amount) / count(s.id), 2) company_average
    from salary s
    group by pay_month
) company_average_table
on company_average_table.pay_month = department_average_table.pay_month
order by department_id, pay_month
