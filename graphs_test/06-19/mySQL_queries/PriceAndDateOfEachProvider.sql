select bioanalysis_metabolite_price.date, bioanalysis_metabolite_price.price, provider.name as provider_name
from bioanalysis_metabolite_price
JOIN provider 
on provider.id = bioanalysis_metabolite_price.provider_id
where metabolite_id = 2314; 