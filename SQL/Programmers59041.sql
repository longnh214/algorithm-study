-- 프로그래머스 <GROUP BY> '동명 동물 수 찾기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- DATE 2025/09/06

SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME ASC
;