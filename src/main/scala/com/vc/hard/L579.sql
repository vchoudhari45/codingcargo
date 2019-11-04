select
e1.Id,
e2.Month,
sum(e1.Salary) as Salary
from Employee e1 inner join Employee e2
where e1.id = e2.id
and (e2.Month - e1.Month) between 0 and 2
and (e2.Id, e2.Month) not in (select Id, max(Month) from Employee group by id)
group by id,month
order by id,month desc