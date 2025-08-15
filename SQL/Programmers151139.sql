-- 프로그래머스 <GROUP BY> '대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
-- DATE 2025/08/15
-- 서브 쿼리를 이용해서 문제를 해결했다. 테이블의 alias를 잘 지정해줘야겠다는 생각이 들었다.

SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
WHERE START_DATE >= '2022-08-01'
AND START_DATE < '2022-11-01'
AND (
    SELECT COUNT(b.CAR_ID)
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    WHERE b.START_DATE >= '2022-08-01'
    AND b.START_DATE < '2022-11-01'
    AND b.CAR_ID = a.CAR_ID
) >= 5
GROUP BY MONTH, CAR_ID
ORDER BY MONTH, CAR_ID DESC
;