WITH task2(id, employee_id, task_desc, deadline) AS (
    SELECT id, IFNULL(employee_id, 6), task_desc, deadline
    FROM task
)
SELECT * FROM employee e JOIN task2 t ON e.id = t.employee_id;
