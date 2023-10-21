select * from task;

SELECT
    id,
    IFNULL(employee_id, 4) AS emp_ID,
    task,
    deadline
FROM task t;