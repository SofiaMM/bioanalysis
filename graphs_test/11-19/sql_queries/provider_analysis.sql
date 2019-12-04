SELECT 
	count(id) as num_id,
    count(name) as num_provider
FROM bioeco.provider;

SELECT 
	count(distinct id) as num_id,
    count(distinct name) as num_provider
FROM bioeco.provider;

select * 
from provider
where name is Null;

# Amounts equal to 0
select * 
from provider
where id = 9;