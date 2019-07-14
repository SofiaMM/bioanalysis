SELECT common_name,inchi, count(id) as count_id FROM bioeco.bioanalysis_metabolite
group by common_name, inchi
order by count_id DESC ;


# também podemos agrupar por id_bioeco, aí já dá tudo 1 no count