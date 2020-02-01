SELECT 
	count(id) as num_id,
    count(name) as num_metabName, 
    count(metabolite_id) as num_metabID
FROM bioeco.metabolite_name;

SELECT 
	count(id) as num_id,
    count(distinct name) as num_metabName, 
    count(distinct metabolite_id) as num_metabID
FROM bioeco.metabolite_name;
