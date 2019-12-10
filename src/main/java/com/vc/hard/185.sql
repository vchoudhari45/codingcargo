SELECT d.name as Department, e1.name as Employee, salary
FROM employee e1 INNER JOIN department d
WHERE e1.departmentId = d.id
AND 3 > (
    SELECT COUNT(DISTINCT salary)
    FROM employee e2
    WHERE e1.salary < e2.salary
    AND e2.departmentId = d.id
)
order by department, salary desc