CREATE EXTENSION age;

LOAD 'age';

SET search_path = ag_catalog, "$user", public;


SELECT * FROM ag_catalog.create_graph('bom');

SELECT * FROM ag_catalog.cypher('bom', $$
   CREATE (n:Material{
   id: 1,
   material_id: '4022.168.1',
   ecr_id: 10001,
   factory: 'U1'
   })
$$) as (n ag_catalog.agtype);

SELECT *
FROM ag_catalog.cypher('bom', $$
	match (m:Material) return m
$$) AS (v ag_catalog.agtype);

SELECT * FROM ag_catalog.drop_graph('bom', true);