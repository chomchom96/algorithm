-- 코드를 입력하세요
SELECT a.factory_id, a.factory_name, a.address
from food_factory a
where a.address like '강원도%'
order by factory_id asc