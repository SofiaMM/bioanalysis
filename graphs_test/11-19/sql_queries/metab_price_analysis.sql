SELECT 
	count(id) as num_id, 
    count(amount) as num_amount, 
    count(currency) as num_currency,
    count(date) as num_date,
    count(log_id) as num_logID,
    count(price) as num_price, 
    count(source) as num_source,
    count(unity) as num_unit,
    count(metabolite_id) as num_metabID,
    count(provider_id) as num_providerID
FROM bioeco.bioanalysis_metabolite_price;

SELECT 
	count(distinct id) as num_id, 
    count(distinct amount) as num_amount, 
    count(distinct currency) as num_currency,
    count(distinct date) as num_date,
    count(distinct log_id) as num_logID,
    count(distinct price) as num_price, 
    count(distinct source) as num_source,
    count(distinct unity) as num_unit,
    count(distinct metabolite_id) as num_metabID,
    count(distinct provider_id) as num_providerID
FROM bioeco.bioanalysis_metabolite_price;


SELECT
	count(id) as num_id,
    count(distinct amount, currency, date, price, source, unity, metabolite_id, provider_id) as num_price
FROM bioeco.bioanalysis_metabolite_price;

SELECT
	count(id) as num_id,
    count(distinct amount, currency, date, price, source, unity, metabolite_id, provider_id, log_id) as num_price
FROM bioeco.bioanalysis_metabolite_price;


SELECT id, amount, currency, date, log_id, price, source, unity as unit, metabolite_id, provider_id, count(distinct amount, currency, date, price, source, unity, metabolite_id, provider_id, log_id) as num_price
FROM bioeco.bioanalysis_metabolite_price
group by amount, currency, date, price, source, unity, metabolite_id, provider_id;


SELECT * from bioeco.bioanalysis_metabolite_price
where amount = 20 and date = '2017-09-22 17:55:02' and price = 0.82 and source = 'DRUGBANK' and unity = 'mg' and metabolite_id = '1465' and provider_id = 8;


SELECT * from bioeco.bioanalysis_metabolite_price
where provider is null;