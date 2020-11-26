# Write your MySQL query statement below
With RECURSIVE month_table AS (
    SELECT 1 AS month
    UNION ALL
    SELECT month + 1 AS month FROM month_table WHERE month < 12
),

active_drivers_table AS (
    SELECT
    mt.month,
    IFNULL(MAX(jd.active_drivers) OVER(ORDER BY month), 0) as active_drivers
    FROM month_table mt
    LEFT OUTER JOIN(
        SELECT MONTH(join_date) as month,
        COUNT(driver_id) OVER(ORDER BY join_date ROWS UNBOUNDED PRECEDING) AS active_drivers
        FROM drivers
        WHERE YEAR(join_date) < 2021
    ) AS jd
    ON mt.month = jd.month
),

accepted_rides_table AS (
    SELECT
    mt.month,
    IFNULL(arm.accepted_rides, 0) as accepted_rides
    FROM month_table mt
    LEFT OUTER JOIN(
        SELECT MONTH(r.requested_at) as month,
        COUNT(ar.ride_id) as accepted_rides
        FROM acceptedRides ar
        INNER JOIN rides r
        ON ar.ride_id = r.ride_id
        WHERE YEAR(r.requested_at) = 2020
        GROUP BY MONTH(r.requested_at)
    ) AS arm
    ON mt.month = arm.month
)

SELECT
active_drivers.month,
active_drivers.active_drivers,
accepted_rides.accepted_rides
FROM accepted_rides_table accepted_rides
INNER JOIN active_drivers_table active_drivers
ON accepted_rides.month = active_drivers.month
GROUP BY active_drivers.month;
