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