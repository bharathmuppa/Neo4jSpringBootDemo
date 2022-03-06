# Docker
docker run --name neo4j-local --publish=7474:7474 --publish=7687:7687 neo4j

then connect to bolt://localhost:7687 with neo4j and neo4j as password

## Load Material Data
```
LOAD CSV WITH HEADERS FROM "file:///C:\MrGoddish\dump\myimpact_public_material.csv" AS row
CREATE (n:Material)
SET n = row,
n.id = toInteger(row.id),
n.material_id = row.material_id,
n.description = row.description,
n.ecr_id = toInteger(row.ecr_id),
n.predecessor = row.predecessor,
n.factory=row.factory

// or use below cql

LOAD CSV WITH HEADERS FROM "file:///C:\MrGoddish\dump\myimpact_public_material.csv" AS row
CREATE (n:Material)
SET n = row{
    .*,id: toInteger(row.id), ecr_id: toInteger(row.ecr_id),title:  row.id
} 

```

## Create indexes to speed up the querying

```
create index for(m: Material) on m.id;
create index for(m: Material) on m.material_id;
```

## Load Material Relations Data
```
LOAD CSV WITH HEADERS FROM "file:///C:\\MrGoddish\\dump\\relations.csv" AS row
Match (src:Material),(dest:Material) where src.id=toInteger(row.source_id) and dest.id=toInteger(row.dest_id)
CALL apoc.create.relationship(src, row.type,row, dest) YIELD rel
return rel
```


## Required Queries 


|Query|time|
| ----------- | ----------- |
|MATCH p=(m:material{ecr: 10001})-[:add]->(material) RETURN p||
|MATCH p=()-[r:add]->() RETURN p LIMIT 25|| 
|MATCH p=(m:Material{id: 10000})<-[r:Add*]-(Material) RETURN p|
|match p=(m: Material{id: 10000})-[:Add*1..2]->(n:Material) return p|
|match (m: Material{id: 10000})-[:Add*1..2]->(n:Material) return n |
|MATCH (m:Material) where not (m)-[:Add*]->() RETURN m.material_id|


## Other related queries
`MATCH (Material { ecr_id: 10001 }) REMOVE Material.ecr_id RETURN Material`



