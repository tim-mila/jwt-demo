CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table application_user(
    user_id uuid not null primary key default uuid_generate_v4 (),
    username character varying(255) not null,
    password character varying(255) not null,
    constraint unique_idx_username unique (username)
);