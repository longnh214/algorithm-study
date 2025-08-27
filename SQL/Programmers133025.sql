-- 프로그래머스 <SELECT> '과일로 만든 아이스크림 고르기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- DATE 2025/08/27

SELECT fh.FLAVOR
FROM FIRST_HALF fh, ICECREAM_INFO ii
WHERE fh.FLAVOR = ii.FLAVOR
AND fh.TOTAL_ORDER > 3000
AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY fh.TOTAL_ORDER DESC
;