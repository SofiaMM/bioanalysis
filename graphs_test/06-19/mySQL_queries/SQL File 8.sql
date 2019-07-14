select bioanalysis_metabolite_price.metabolite_id, 
       bioanalysis_metabolite_price.date, 
       bioanalysis_metabolite_price.price    as price, 
       bioanalysis_metabolite_price.amount   as amount, 
       bioanalysis_metabolite_price.unity    as unity, 
       provider.name                         as provider_name, 
       price/amount                          as price_per_unity,
       price/amount*convert_to_g(unity)
from bioanalysis_metabolite_price
JOIN provider 
on provider.id = bioanalysis_metabolite_price.provider_id;