select
employee_rank.id,
employee_rank.company,
employee_rank.salary
from (
    select e.id,
    e.company,
    e.salary,
    @rank := (case when @lastcompany = e.company then @rank + 1 else 1 END) as rank,
    @lastcompany := e.company,
    employee_total.total
    from
    (
        select @rank := 0,
        @lastcompany := ''
    ) sql_variables inner join employee e inner join
    (select company, count(1) as total from employee group by company) as employee_total
    on employee_total.company = e.company
    order by e.company, e.salary, e.id
) as employee_rank
where employee_rank.rank = employee_rank.total DIV 2 + 1
or (employee_rank.rank = employee_rank.total DIV 2 and employee_rank.total % 2 = 0)
order by employee_rank.company, employee_rank.rank, employee_rank.id