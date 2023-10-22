SELECT * FROM employee;

SELECT * FROM employee e
WHERE salary > (SELECT AVG(salary) FROM employee);

SELECT DISTINCT employee_id FROM task
WHERE employee_id IS NOT NULL;

SELECT * FROM employee;

SELECT DISTINCT employee_id FROM task
WHERE employee_id IS NOT NULL;

SELECT * FROM employee
WHERE id NOT IN (
    SELECT DISTINCT employee_id FROM task
    WHERE employee_id IS NOT NULL
    )