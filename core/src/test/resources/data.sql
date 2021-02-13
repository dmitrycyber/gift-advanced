DROP TABLE IF EXISTS gift_certificate CASCADE;
DROP TABLE IF EXISTS tag CASCADE;
DROP TABLE IF EXISTS gift_tags CASCADE;

CREATE TABLE gift_certificate (
                                  id BIGSERIAL PRIMARY KEY,
                                  name varchar(255),
                                  description varchar(255),
                                  price integer,
                                  duration integer,
                                  create_date timestamp,
                                  last_update_date timestamp
);

CREATE TABLE tag (
                     id BIGSERIAL PRIMARY KEY,
                     name varchar(255)
);

CREATE TABLE gift_tags (
                           gift_id bigint,
                           tag_id bigint,
                           PRIMARY KEY (gift_id, tag_id),
                           FOREIGN KEY (gift_id) REFERENCES gift_certificate(id) ON UPDATE CASCADE ON DELETE CASCADE,
                           FOREIGN KEY (tag_id) REFERENCES tag(id) ON UPDATE CASCADE ON DELETE CASCADE
);


insert into gift_certificate values
(1, 'name1', 'description1', 10, 10, null, null),
(2, 'name2', 'description2', 20, 20, null, null),
(3, 'name3', 'description3', 30, 30, null, null),
(4, 'name4', 'description4', 40, 40, null, null),
(5, 'name5', 'description5', 50, 50, null, null);

insert into tag values
(1, 'name1'),
(2, 'name2'),
(3, 'name3'),
(4, 'name4'),
(5, 'name5');

insert into gift_tags values
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5);