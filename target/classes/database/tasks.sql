USE app;

SELECT * FROM task;

select * FROM task
WHERE task.deadline BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH);

SELECT
    id,
    IFNULL(employee_id, 4) AS emp_ID,
    task_desc,
    deadline
FROM task t;

SELECT * FROM task
WHERE DATEDIFF(deadline, CURDATE()) < 7;


SELECT CONCAT('EXPIRED ', CURDATE() - task.deadline, ' days ago! ', task_desc) AS description,
       deadline, CURDATE() AS cur_date FROM task
where deadline < CURDATE();

SELECT * FROM test_tab;

SELECT * FROM user;
