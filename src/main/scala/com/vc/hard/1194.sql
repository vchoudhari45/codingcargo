# Write your MySQL query statement below
select group_id, player_id
from (
    select
    group_id,
    player_score_denorm.player as player_id,
    sum(player_score_denorm.score) as score
    from players inner join
    (
        select first_player as player, first_score as score from matches
        union all
        select second_player as player, second_score as score from matches
    ) player_score_denorm
    where player_score_denorm.player = player_id
    group by player_id
    order by group_id, score desc, player_id
) top_score
group by group_id