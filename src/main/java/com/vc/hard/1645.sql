# Write your MySQL query statement below
WITH RECURSIVE month_table AS (
    SELECT 1 AS month
    UNION ALL
    SELECT month + 1 AS month FROM month_table WHERE month < 12
),

available_drivers_table AS (
    SELECT mt.month,
    IFNULL(MAX(available_drivers) OVER(ORDER BY mt.month), 0) AS available_drivers
    FROM month_table mt
    LEFT OUTER JOIN
    (SELECT
        MONTH(join_date) AS month,
        COUNT(driver_id) OVER(ORDER BY join_date ROWS UNBOUNDED PRECEDING) AS available_drivers
        FROM drivers
        WHERE YEAR(join_date) <= 2020
    ) AS available_drivers
    ON mt.month = available_drivers.month
),


active_drivers_table AS (
    SELECT
    MONTH(r.requested_at) AS month,
    COUNT(DISTINCT(d.driver_id)) AS active_drivers
    FROM acceptedRides ar
    LEFT OUTER JOIN rides r
    ON ar.ride_id = r.ride_id
    LEFT OUTER JOIN drivers d
    ON ar.driver_id = d.driver_id
    AND YEAR(r.requested_at) = 2020
    GROUP BY MONTH(r.requested_at)
)

SELECT
available_drivers.month,
IFNULL(ROUND(active_drivers.active_drivers * 100 / available_drivers.available_drivers, 2), 0) AS working_percentage
FROM available_drivers_table available_drivers
LEFT OUTER JOIN active_drivers_table as active_drivers
ON available_drivers.month = active_drivers.month
GROUP BY available_drivers.month;