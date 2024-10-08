-- 코드를 입력하세요
WITH AVG_SCORE AS(
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE),2) AS SCORE
    FROM REST_REVIEW
    GROUP BY REST_ID
)

SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, A.SCORE
FROM REST_INFO RI
JOIN AVG_SCORE A ON RI.REST_ID = A.REST_ID
WHERE RI.ADDRESS LIKE '서울%' 
ORDER BY A.SCORE DESC, RI.FAVORITES DESC