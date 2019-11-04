# 0 0 0 0 0 0 1 1 2 2 2  3
# 0 1 2 3 4 5 6 7 8 9 10 11
# number are 0, 1, and avg of those numbers are 0.5

select round(avg(n1.number), 4) as median
from numbers n1 inner join
(
    select number,
    @prev := @count prevCount,
    @count := @count + frequency nextCount
    from numbers,
    (
        select @prev := 0,
        @count := 0,
        @total := (select sum(frequency) from numbers)
    ) temp order by number
) n2
on n1.number = n2.number
where (n2.prevCount < floor((@total + 1) / 2) and n2.nextCount >= floor((@total + 1) / 2))
or (n2.prevCount < floor((@total + 2) / 2) and n2.nextCount >= floor((@total + 2) / 2))
