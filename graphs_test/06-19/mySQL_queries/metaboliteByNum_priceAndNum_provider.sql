select bioanalysis_metabolite_price.metabolite_id, bioanalysis_metabolite.common_name, count(DISTINCT bioanalysis_metabolite_price.price, bioanalysis_metabolite_price.amount, bioanalysis_metabolite_price.date, bioanalysis_metabolite_price.source, bioanalysis_metabolite_price.unity, bioanalysis_metabolite_price.provider_id) as num_price, count(distinct bioanalysis_metabolite_price.provider_id) as num_provider
from bioanalysis_metabolite_price
JOIN bioanalysis_metabolite
on bioanalysis_metabolite_price.metabolite_id = bioanalysis_metabolite.id 
group by metabolite_id
order by num_provider DESC, num_price DESC;



