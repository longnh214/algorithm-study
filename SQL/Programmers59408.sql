-- 프로그래머스 <SUM, MAX, MIN> '중복 제거하기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/59408
-- DATE 2024/09/29

SELECT COUNT(DISTINCT(NAME))
FROM ANIMAL_INS
WHERE NAME != ''
;