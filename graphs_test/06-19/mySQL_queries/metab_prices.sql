select metabolite_id, 
metab_name,
provider_name, 
date, 
max(price_per_g) as maximo, 
avg(price_per_g) as media, 
min(price_per_g) as minimo, 
count(price) from (
		select bioanalysis_metabolite_price.metabolite_id,
			   bioanalysis_metabolite.common_name               as metab_name,
			   bioanalysis_metabolite_price.date, 
			   bioanalysis_metabolite_price.price               as price, 
			   bioanalysis_metabolite_price.amount              as amount, 
			   bioanalysis_metabolite_price.unity               as unity, 
			   if(provider.name is null, "None", provider.name) as provider_name, 
			   price/amount                                     as price_per_unity,
			   price/amount*convert_to_g(unity)                 as price_per_g
		from bioanalysis_metabolite_price
		JOIN provider 
			on provider.id = bioanalysis_metabolite_price.provider_id
		JOIN bioanalysis_metabolite
			on bioanalysis_metabolite_price.metabolite_id = bioanalysis_metabolite.id
		where convert_to_g(unity) is not null 
        
		) as metab_prices
where metabolite_id= 1175
group by metabolite_id, provider_name, year(date), month(date);

