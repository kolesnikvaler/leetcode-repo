SELECT
    t.id AS task_id,
    t.task AS task_desk,
    t.deadline AS deadline,
    e.id AS emp_id,
    e.name AS emp_name,
    e.occupation AS emp_occupation
from employee e, task t
WHERE e.id = t.employee_id;