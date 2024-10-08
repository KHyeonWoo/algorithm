WITH MAX_PRICE AS 
    (SELECT CATEGORY, MAX(PRICE) AS PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
    )
SELECT FP.CATEGORY, FP.PRICE AS MAX_PRICE, FP.PRODUCT_NAME
FROM FOOD_PRODUCT FP
JOIN MAX_PRICE MP ON FP.CATEGORY = MP.CATEGORY AND FP.PRICE = MP.PRICE
ORDER BY FP.PRICE DESC