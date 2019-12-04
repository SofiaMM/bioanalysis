SELECT 
	count(id) as num_id, 
    count(common_name) as num_commonName, 
    count(id_bioeco) as num_idBioeco,
    count(inchi) as num_inchi,
    count(inchi_key) as num_inchiKey,
    count(smiles) as num_smiles
FROM bioeco.bioanalysis_metabolite;

SELECT 
	count(distinct id) as num_id, 
    count(common_name) as num_commonName, 
    count(distinct id_bioeco) as num_idBioeco,
    count(distinct inchi) as num_inchi,
    count(distinct inchi_key) as num_inchiKey,
    count(distinct smiles) as num_smiles
FROM bioeco.bioanalysis_metabolite;

select *
from bioeco.bioanalysis_metabolite
where common_name is Null; 

select *
from bioeco.bioanalysis_metabolite
where id =2; 


select common_name, inchi, count(id) as num_metab
from bioeco.bioanalysis_metabolite
group by inchi;


# The inchi keys aren't specific for each metabolite, however when counting the distinct number of inchi keys it matches
# the number of distinct prices. Therefore, this query verifies how many metabolites are associated to each inchikey and 
# if some metabolites do not have inchi keys associated

select inchi_key, count(id) as num_metab
from (	
	SELECT 
		id, 
		if(common_name is null, "None", common_name) as metab_name,
		id_bioeco, 
		inchi, 
		inchi_key, 
		smiles, 
		count(distinct id, if(common_name is null, "None", common_name), id_bioeco, inchi, inchi_key, smiles) as num_metab 
	FROM bioeco.bioanalysis_metabolite
	group by common_name, inchi, inchi_key, smiles) as dist_metab
group by inchi_key
order by num_metab desc;

select * from bioeco.bioanalysis_metabolite
where inchi_key is null;  # Every metabolite has an inchi key

select count(distinct inchi_key)
from bioeco.bioanalysis_metabolite;

select count(distinct id)
from bioeco.bioanalysis_metabolite
group by id, common_name, inchi, inchi_key, smiles;

SELECT 
	id, 
    if(common_name is null, "None", common_name) as metab_name,
    id_bioeco, 
    inchi, 
    inchi_key, 
    smiles, 
    count(distinct id, if(common_name is null, "None", common_name), id_bioeco, inchi, inchi_key, smiles) as num_metab 
FROM bioeco.bioanalysis_metabolite
group by common_name, inchi, inchi_key, smiles;


# There should be a inchi for all the metabolites, however there are 4292 distinct metabolites, and just 4278 distinct inchi
# Why is that??
select count(distinct inchi)
from bioanalysis_metabolite;

select inchi, count(distinct id, if(common_name is null, "None", common_name), id_bioeco, inchi, inchi_key, smiles) as num_metab
from bioanalysis_metabolite
group by inchi;

SELECT 
	id, 
    if(common_name is null, "None", common_name) as metab_name,
    id_bioeco, 
    inchi, 
    inchi_key, 
    smiles, 
    count(distinct inchi) as num_inchi 
FROM bioeco.bioanalysis_metabolite
group by common_name, inchi_key, smiles;


select inchi, count(inchi)
from bioeco.bioanalysis_metabolite
group by inchi;   # Some inchi's are repeated more than once, even though the inchi is supposed to be unique to each metabolite

#Example of the same inchi in two different metabolites (with the same inchi key too, but different smiles)
select *
from bioeco.bioanalysis_metabolite
where inchi = 'InChI=1S/C3H6N2O2/c4-2-1-7-5-3(2)6/h2H,1,4H2,(H,5,6)/t2-/m1/s1';