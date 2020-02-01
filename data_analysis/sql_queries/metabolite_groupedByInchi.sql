SELECT common_name, inchi, count(id) as count_id FROM bioeco.bioanalysis_metabolite
group by common_name, inchi
order by count_id DESC;


# também podemos agrupar por id_bioeco, aí já dá tudo 1 no count

select common_name, inchi, id_bioeco 
from bioanalysis_metabolite
where common_name = 'Temsirolimus' and inchi= 'InChI=1S/C56H87NO16/c1-33-17-13-12-14-18-34(2)45(68-9)29-41-22-20-39(7)56(67,73-41)51(63)52(64)57-24-16-15-19-42(57)53(65)71-46(30-43(60)35(3)26-38(6)49(62)50(70-11)48(61)37(5)25-33)36(4)27-40-21-23-44(47(28-40)69-10)72-54(66)55(8,31-58)32-59/h12-14,17-18,26,33,35-37,39-42,44-47,49-50,58-59,62,67H,15-16,19-25,27-32H2,1-11H3/b14-12-,17-13-,34-18-,38-26-/t33-,35-,36-,37-,39-,40+,41+,42+,44-,45+,46+,47-,49-,50+,56-/m1/s1';
