-- 코드를 입력하세요
SELECT TO_CHAR(SALES_DATE, 'YYYY') AS YEAR, EXTRACT(MONTH FROM SALES_DATE) AS MONTH, UI.GENDER AS GENDER, COUNT(DISTINCT OS.USER_ID) AS USERS
FROM ONLINE_SALE OS
JOIN USER_INFO UI ON OS.USER_ID = UI.USER_ID
WHERE UI.GENDER IS NOT NULL
GROUP BY TO_CHAR(SALES_DATE, 'YYYY'), EXTRACT(MONTH FROM SALES_DATE), UI.GENDER
ORDER BY TO_CHAR(SALES_DATE, 'YYYY'), EXTRACT(MONTH FROM SALES_DATE), UI.GENDER