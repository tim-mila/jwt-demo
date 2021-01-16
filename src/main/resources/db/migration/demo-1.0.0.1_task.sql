
create table task(
    task_id uuid not null primary key default uuid_generate_v4 (),
    owner_id uuid not null references application_user(user_id),
    created_date timestamp with time zone not null,
    last_modified_date timestamp with time zone not null,
    description character varying(1000) not null
);