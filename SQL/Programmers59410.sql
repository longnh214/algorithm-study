-- 프로그래머스 <IS NULL> 'NULL 처리하기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- DATE 2025/08/16
-- 특정 컬럼의 값이 NULL일 때 대체 값을 지정해줘야했다. MySQL 문법에서는 IFNULL 함수로 커버가 가능했다.

SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
;