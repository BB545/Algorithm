-- 코드를 입력하세요
SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE MONTH(START_DATE) = 10) AND CAR_TYPE = "세단" ORDER BY CAR_ID DESC