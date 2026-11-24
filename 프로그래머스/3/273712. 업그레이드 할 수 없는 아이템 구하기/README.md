## 1. 풀이에서 `PARENT_ITEM_ID IS NOT NULL`이 필요한 이유

물론 `NOT EXISTS` 풀이 등으로 하면 괜찮음.

`NOT IN`은 다음처럼 동작한다.

```sql
WHERE ITEM_ID NOT IN (1, 2, 3)
--
WHERE ITEM_ID != 1
  AND ITEM_ID != 2
  AND ITEM_ID != 3
```

이때 서브쿼리 결과에 `NULL`이 있다고 하자.

```sql
WHERE ITEM_ID != 1
  AND ITEM_ID != 2
  AND ITEM_ID != NULL
```
sql의 논리 연산 결과는 `TRUE`, `FALSE`, `UNKNOWN` 중에 하나다. 이때 `NULL`과의 비교 연산은 UNKNOWN이 리턴된다.
그런데 `WHERE` clause는 `TRUE`인 row만 리턴한다.

