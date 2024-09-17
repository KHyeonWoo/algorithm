
-- Date 포멧 맞추기
SELECT B.BOOK_ID, A.AUTHOR_NAME, TO_CHAR(B.PUBLISHED_DATE,'YYYY-MM-DD')
FROM BOOK B, AUTHOR A
WHERE B.AUTHOR_ID = A. AUTHOR_ID
AND B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE



--TO_CHAR
WITH REVIEW_CNT AS(
    SELECT MEMBER_ID, RANK() OVER(ORDER BY COUNT(*) DESC) AS RANK
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
)

SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, TO_CHAR(RR.REVIEW_DATE,'YYYY-MM-DD')
FROM MEMBER_PROFILE MP, REST_REVIEW RR, REVIEW_CNT RC
WHERE MP.MEMBER_ID = RR.MEMBER_ID
AND RR.MEMBER_ID = RC.MEMBER_ID
AND RC.RANK = 1
ORDER BY RR.REVIEW_DATE, RR.REVIEW_TEXT
