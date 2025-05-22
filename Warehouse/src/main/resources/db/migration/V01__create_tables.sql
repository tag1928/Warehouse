CREATE TABLE IF NOT EXISTS public.warehouse
(
    id character varying(36) NOT NULL,
    name character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.shop
(
    id character varying(36) NOT NULL,
    name character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.product
(
    id character varying(36) NOT NULL,
    name character varying(40) NOT NULL,
    price double precision,
    quantity integer,
    shop_id character varying(36),
    warehouse_id character varying(36),
    PRIMARY KEY (id),
    FOREIGN KEY (shop_id)
        REFERENCES public.shop (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    FOREIGN KEY (warehouse_id)
        REFERENCES public.warehouse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.shop_warehouse
(
    id bigint,
    shop_id character varying(36) NOT NULL,
    warehouse_id character varying(36) NOT NULL,
    FOREIGN KEY (shop_id)
        REFERENCES public.shop (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    FOREIGN KEY (warehouse_id)
        REFERENCES public.warehouse (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)