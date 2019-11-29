SELECT 
	count(id) as num_id,
    count(name) as num_name
FROM bioeco.external_source;

SELECT 
	count(distinct id) as num_id,
    count(distinct name) as num_name
FROM bioeco.external_source;
