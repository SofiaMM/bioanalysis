SELECT unity, count(price) FROM bioeco.bioanalysis_metabolite_price
where metabolite_id = 1175
group by unity;


select distinct(metabolite_id) from bioanalysis_metabolite_price
where unity = 'mg/ml';

select * from bioanalysis_metabolite_price
where metabolite_id = 2;
