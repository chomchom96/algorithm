SELECT FLAVOR
FROM JULY
JOIN FIRST_HALF USING(FLAVOR)
GROUP BY FLAVOR
ORDER BY SUM(JULY.TOTAL_ORDER) + SUM(FIRST_HALF.TOTAL_ORDER) DESC
LIMIT 3