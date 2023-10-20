UPDATE test_table t SET salary = 7500 WHERE salary = 4999;

select * from test_table;

select *,
       if(salary >= 5000, CONCAT(name, ' Главный пидор с ЗП: ', salary), CONCAT(name, ' Бомж ебаный')),
       if(deadline < CURRENT_DATE, 'Всё проёбано',
           CONCAT('Работаем парни, всё заебись! Осталось ', deadline - CURRENT_DATE, ' дней до жопы!'))
from test_table;

SELECT
    salary AS Money,
    count(*) AS Quantity
from test_table
GROUP BY salary
HAVING Quantity = 1
ORDER BY salary DESC;

SELECT
    YEAR(deadline) AS year,
    MONTH(deadline) AS month,
    COUNT(*) AS quantity
from test_table
WHERE salary > 1100
GROUP BY year, month;