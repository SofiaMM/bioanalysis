select bioanalysis_metabolite_price.metabolite_id       as metab_id,  
	   bioanalysis_metabolite.common_name               as metab_name,
	   bioanalysis_metabolite_price.date, 
	   bioanalysis_metabolite_price.price               as price, 
	   bioanalysis_metabolite_price.amount              as amount, 
	   bioanalysis_metabolite_price.unity               as unit, 
	   if(provider.name is null, "None", provider.name) as provider_name, 
	   bioanalysis_metabolite_price.source              as source,
	   price/amount                                     as price_per_unit,
	   price/(amount*convert_to_g(unity))               as price_per_g,
	   year(date)                                       as year, 
	   month(date)                                      as month
from bioanalysis_metabolite_price
JOIN provider 
	on provider.id = bioanalysis_metabolite_price.provider_id
JOIN bioanalysis_metabolite
	on bioanalysis_metabolite_price.metabolite_id = bioanalysis_metabolite.id
where convert_to_g(unity) is not null; # and ((year(date)*10000) + (month(date)*100) between 20180100 and 20190600);