WITH task2(id, employee_id, task_desc, deadline) AS (
    SELECT id, IFNULL(employee_id, 7), task_desc, deadline FROM task
)
SELECT * from employee e JOIN task2 t on e.id = t.employee_id;

drop view if exists vir_view;

WITH task2(id, employee_id, task_desc, deadline) AS (
    SELECT id, IFNULL(employee_id, 7), task_desc, deadline FROM task
)
SELECT * from employee e JOIN task2 t on e.id = t.employee_id;

create view vir_view as
SELECT
    t.task_desc,
    t.deadline,
    e.name AS respones,
    e.occupation
FROM employee e JOIN task t on e.id = t.employee_id;

SELECT * from vir_view;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL ,
    level INT DEFAULT 1,
    created_date DATE NOT NULL
);

SELECT * FROM employee
WHERE id NOT IN (
    SELECT employee_id FROM task
                       WHERE employee_id IS NOT NULL
                       GROUP BY employee_id
    );