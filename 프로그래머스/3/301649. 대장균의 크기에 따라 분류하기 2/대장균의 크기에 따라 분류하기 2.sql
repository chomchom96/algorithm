-- 코드를 작성해주세요
select id, case
when ntile(4) over (order by size_of_colony)=4 then 'CRITICAL'
when ntile(4) over (order by size_of_colony)=3 then 'HIGH'
when ntile(4) over (order by size_of_colony)=2 then 'MEDIUM'
else 'LOW'
end as colony_name
from ecoli_data
order by id