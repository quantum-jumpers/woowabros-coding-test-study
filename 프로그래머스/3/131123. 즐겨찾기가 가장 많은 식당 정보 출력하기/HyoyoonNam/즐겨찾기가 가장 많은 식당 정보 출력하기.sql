-- https://school.programmers.co.kr/learn/courses/30/lessons/131116와 상당히 유사한 문제
-- 1. FOOD_TYPE 별로 최대 즐겨찾기 수를 구한다 (sub query)
SELECT      FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM        REST_INFO
WHERE       (FOOD_TYPE, FAVORITES) IN
(
    SELECT      FOOD_TYPE, MAX(FAVORITES)
    FROM        REST_INFO
    GROUP BY    FOOD_TYPE
)
ORDER BY    FOOD_TYPE DESC;
