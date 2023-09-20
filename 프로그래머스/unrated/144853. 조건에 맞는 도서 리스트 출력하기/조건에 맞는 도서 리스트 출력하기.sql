-- 코드를 입력하세요
SELECT a.book_id, date_format(a.published_date,"%Y-%m-%d") as published_date  
from book a 
where a.category = '인문'
and published_date like '2021%'
order by published_date desc