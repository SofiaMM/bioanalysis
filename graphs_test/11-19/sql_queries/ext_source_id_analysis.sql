SELECT 
	count(id) as num_id,
    count(name) as num_name, 
    count(external_source_id) as num_externalSourceID,
    count(metabolite_id) as num_metaboliteID
FROM bioeco.external_source_id;

SELECT 
	count(distinct id) as num_id,
    count(distinct name) as num_name, 
    count(distinct external_source_id) as num_externalSourceID,
    count(distinct metabolite_id) as num_metaboliteID
FROM bioeco.external_source_id;