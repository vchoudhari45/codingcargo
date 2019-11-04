select round(count(second_login.player_id)/count(first_login.player_id), 2) as fraction
from (select player_id, min(event_date) as event_date from activity group by player_id) first_login
left join activity as second_login
on first_login.player_id = second_login.player_id
and second_login.event_date - 1 = first_login.event_date