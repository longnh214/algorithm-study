-- 프로그래머스 <SELECT> '조건에 부합하는 중고거래 댓글 조회하기'
-- https://school.programmers.co.kr/learn/courses/30/lessons/164673
-- DATE 2025/08/22

SELECT ugb.TITLE, ugb.BOARD_ID, ugp.REPLY_ID, ugp.WRITER_ID, ugp.CONTENTS, DATE_FORMAT(ugp.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD ugb, USED_GOODS_REPLY ugp
WHERE ugb.BOARD_ID = ugp.BOARD_ID
AND ugb.CREATED_DATE >= '2022-10-01'
AND ugb.CREATED_DATE < '2022-11-01'
ORDER BY ugp.CREATED_DATE, ugb.TITLE
;