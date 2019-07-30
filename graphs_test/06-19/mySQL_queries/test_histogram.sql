select metabolite_id, 
count(price_per_g)   as num_price_per_g, 
count(price_per_l)   as num_price_per_l
#max(price_per_g) as maximo, 
#avg(price_per_g) as media, 
#min(price_per_g) as minimo, 
#count(price) 
from (
		select bioanalysis_metabolite_price.metabolite_id,
			   bioanalysis_metabolite.common_name                    as metab_name,
			   bioanalysis_metabolite_price.date, 
			   bioanalysis_metabolite_price.price                    as price, 
			   bioanalysis_metabolite_price.amount                   as amount, 
			   bioanalysis_metabolite_price.unity                    as unity, 
			   if(provider.name is null, "None", provider.name)      as provider_name, 
			   price/amount                                          as price_per_unity,
			   price/amount*convert_to_g(unity)                      as price_per_g,
               price/amount*convert_to_l(unity)                      as price_per_l
		from bioanalysis_metabolite_price
		JOIN provider 
			on provider.id = bioanalysis_metabolite_price.provider_id
		JOIN bioanalysis_metabolite
			on bioanalysis_metabolite_price.metabolite_id = bioanalysis_metabolite.id
		where (convert_to_g(unity) is not null 
        or convert_to_l(unity) is not null )       #da apenas os preços por grama, litro e derivados
        
) as metab_prices
group by metabolite_id; #, provider_name, date
