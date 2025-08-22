-- 프로그래머스 <IS NULL> '나이 정보가 없는 회원 수 구하기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- DATE 2025/08/22

SELECT COUNT(*)
FROM USER_INFO
WHERE AGE IS NULL
;