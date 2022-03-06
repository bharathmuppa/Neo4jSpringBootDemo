create table example_jsonb.material
(
    ecr_id bigint GENERATED ALWAYS AS IDENTITY (CACHE 200) ,
    version bigint,
    data jsonb,
    primary key (ecr_id, version)
);

