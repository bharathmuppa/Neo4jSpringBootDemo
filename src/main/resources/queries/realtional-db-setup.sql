create table material
(
    id bigint GENERATED ALWAYS AS IDENTITY (CACHE 200) PRIMARY KEY,
    material_id varchar(100) ,
    description varchar(200),
    ecr_id  bigint not null,
    version varchar(3),
    predecessor varchar(20),
    factory varchar(200)
);


INSERT INTO material(material_id, description, ecr_id, version, predecessor, factory)
SELECT '4022.567.'||seq, 'description about' || seq, 10001, 'AA', '4022.567.'|| seq+1  , 'factory in ' || seq
FROM GENERATE_SERIES(1, 20000) seq;


create table relation
(
    relation_id bigint GENERATED ALWAYS AS IDENTITY (CACHE 200) PRIMARY KEY,
--     quantity_number INTEGER,
    type varchar(20),
    description varchar(200),
    source_id bigint references material(id),
    dest_id  bigint references material(id)
);

-- COPY relation( source_id, dest_id, description, type)
--     FROM 'C:\MrGoddish\dump\relations.csv'
--     DELIMITER ','
--     CSV HEADER;

INSERT INTO relation(quantity_number, type, source_id, dest_id)
SELECT seq,  CASE (RANDOM() )::INT
                 WHEN 0 THEN 'add'
                 WHEN 1 THEN 'impacted'
    END, RANDOM()*19999+1 ,RANDOM()*19999+1
FROM GENERATE_SERIES(1, 2000) seq;

WITH RECURSIVE material_h AS (
    SELECT source_id, dest_id
    FROM relation
    WHERE source_id = 19999
    UNION ALL
    SELECT e.source_id, e.dest_id
    FROM relation e
             JOIN material_h ON e.source_id = material_h.dest_id
)

SELECT * FROM material_h  ;

