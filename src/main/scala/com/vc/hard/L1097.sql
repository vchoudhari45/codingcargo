select first_login.event_date as install_dt,
count(distinct(first_login.player_id)) as installs,
round((count(distinct(second_login.player_id)) / count(distinct(first_login.player_id))), 2) as Day1_retention
from (
    select player_id, min(event_date) as event_date
    from activity
    group by player_id
) as first_login left join activity as second_login
on first_login.player_id = second_login.player_id
and first_login.event_date + 1 = second_login.event_date
group by first_login.event_date