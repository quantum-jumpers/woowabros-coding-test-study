-- 코드를 입력하세요

-- 몇 시에 입양이 가장 활발하게 일어났는지 조사하기
-- 09 ~ 19시까지 시간대별로 입양 사건 발생 횟수 조회
SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_OUTS
GROUP BY hour
HAVING  HOUR >= 9 AND  HOUR <= 19
ORDER BY HOUR(DATETIME);
