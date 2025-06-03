-- 코드를 입력하세요
SELECT first_half.flavor from first_half
join july
on first_half.flavor = july.flavor
group by first_half.flavor
order by sum(first_half.total_order + july.total_order) desc
limit 3