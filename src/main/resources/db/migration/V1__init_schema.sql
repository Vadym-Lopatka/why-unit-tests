CREATE TABLE traffic_light (
    uuid character varying(50) NOT NULL,

    device_uuid character varying(50),
    device_state  character varying(40) NOT NULL,
    indication_state  character varying(40) NOT NULL,

    address  character varying(255) NOT NULL,

    PRIMARY KEY (uuid)
);
