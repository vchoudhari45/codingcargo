select first.* from stadium as first, stadium as second, stadium as third
where (
    (first.id + 1 = second.id and first.id + 2 = third.id) or
    (first.id - 1 = second.id and first.id + 1 = third.id) or
    (first.id - 2 = second.id and first.id - 1 = third.id)
)
AND first.people >= 100
AND second.people >= 100
AND third.people >= 100
group by first.id