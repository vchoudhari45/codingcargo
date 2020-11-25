# Write your MySQL query statement below
WITH recursive month_table AS (
    SELECT 1 AS month
    UNION
    SELECT month + 1 AS month FROM month_table WHERE month < 10
),

rides_table AS (
    SELECT
        month(requested_at) AS month,
        sum(ride_distance) as ride_distance,
        sum(ride_duration) as ride_duration
    FROM rides r
    JOIN acceptedRides ar
    ON r.ride_id = ar.ride_id
    AND r.requested_at >= '2020-01-01'
    AND r.requested_at < '2021-01-01'
    GROUP BY month
)

SELECT
    mt.month,
    IFNULL(ROUND(SUM(ride_distance) / 3, 2), 0) average_ride_distance,
    IFNULL(ROUND(SUM(ride_duration) / 3, 2), 0) average_ride_duration
FROM month_table mt
LEFT OUTER JOIN rides_table rt
ON rt.month - mt.month = 0
OR rt.month - mt.month = 1
OR rt.month - mt.month = 2
GROUP BY mt.month
ORDER BY mt.month;