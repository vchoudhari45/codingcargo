select
d.spend_date,
d.platform,
(case when st.amount is null then 0 else sum(st.amount) end) as total_amount,
(case when st.user_id is null then 0 else count(st.user_id) end) as total_users
from
(
    select distinct spend_date, 'desktop' as platform from spending
    union all
    select distinct spend_date, 'mobile' as platform from spending
    union all
    select distinct spend_date, 'both' as platform from spending
) d left join
(
    select user_id,
    spend_date,
    (case when count(distinct platform) > 1 then 'both' else platform end) as platform,
    sum(amount) as amount
    from spending
    group by user_id, spend_date
) st
on d.spend_date = st.spend_date
and d.platform = st.platform
group by d.spend_date, d.platform