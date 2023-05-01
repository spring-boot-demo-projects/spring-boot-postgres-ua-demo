create table if not exists dictionary_ua
(
    id      uuid   not null default gen_random_uuid() primary key,
    caption text   not null default '' collate "uk-UA-x-icu",
    number  bigint not null default 0
);
