-- 코드를 입력하세요
/*
2022년 10월 16일에 대여 중인 자동차를 구한다.
 */
SELECT      CAR_ID,
            CASE
                WHEN CAR_ID IN
                (
                    SELECT      CAR_ID
                    FROM        CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE       '2022-10-16' >= START_DATE AND
                                '2022-10-16' <= END_DATE
                )
                THEN '대여중'
                ELSE '대여 가능'
            END as 'AVAILABILITY'
FROM        CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY    CAR_ID
ORDER BY    CAR_ID DESC;
