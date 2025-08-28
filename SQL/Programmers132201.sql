-- 프로그래머스 <SELECT> '12세 이하인 여자 환자 목록 출력하지'
-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- DATE 2025/08/28

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE GEND_CD = 'W'
AND AGE <= 12
ORDER BY AGE DESC, PT_NAME ASC
;