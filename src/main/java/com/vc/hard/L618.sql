select min(America) as America, min(Asia) as Asia, min(Europe) as Europe
from
(
    select
        case when continent = 'America' then @r1 := @r1 + 1
             when continent = 'Asia' then @r2 := @r2 + 1
             when continent = 'Europe' then @r3 := @r3 + 1 END row_number,
        case when continent = 'America' then name End America,
        case when continent = 'Asia' then name End Asia,
        case when continent = 'Europe' then name End Europe
    from student, (select @r1 := 0, @r2 := 0, @r3 := 0) sqlvars
    order by name
) temp
group by row_number