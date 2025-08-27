create table tuitter(
                        id          bigint           not null auto_increment,
                        content     varchar(42)      not null,
                        created_at  datetime         not null,
                        type        enum('POST', 'REPOST', 'QUOTE')      not null,
                        author_id   bigint           not null,
                        post_tuitter_id  bigint,
                        primary key(id),
                        foreign key (author_id) references "user" (id),
                        foreign key (post_tuitter_id) references tuitter (id)
);