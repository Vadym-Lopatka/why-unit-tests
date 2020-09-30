CREATE TABLE traffic_light (
    uuid character varying(39) NOT NULL,
    address  character varying(255) NOT NULL,
    state  character varying(255) NOT NULL,
    indicator  character varying(255) NOT NULL

    PRIMARY KEY (uuid)
);
