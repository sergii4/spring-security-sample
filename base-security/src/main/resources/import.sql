INSERT INTO category (name) VALUES ('dairy'),('meats'),('bakery'),('fruit & veg');

INSERT INTO product (name, price, description, category_id) VALUES ('milk', 1.70, 'semi skimmed (1L)', 1);
INSERT INTO product (name, price, description, category_id) VALUES ('cheese', 2.39, 'mild cheddar (330g)', 1);
INSERT INTO product (name, price, description, category_id) VALUES ('butter', 1.09, 'unsalted (250g)', 1);
INSERT INTO product (name, price, description, category_id) VALUES ('free range eggs', 1.76, 'medium-sized (6 eggs)', 1);

INSERT INTO product (name, price, description, category_id) VALUES ('organic meat patties', 2.29, 'rolled in fresh herbs<br>2 patties (250g)', 2);
INSERT INTO product (name, price, description, category_id) VALUES ('parma ham', 3.49, 'matured, organic (70g)', 2);
INSERT INTO product (name, price, description, category_id) VALUES ('chicken leg', 2.59, 'free range (250g)', 2);
INSERT INTO product (name, price, description, category_id) VALUES ('sausages', 3.55, 'reduced fat, pork<br>3 sausages (350g)', 2);

INSERT INTO product (name, price, description, category_id) VALUES ('sunflower seed loaf', 1.89, '600g', 3);
INSERT INTO product (name, price, description, category_id) VALUES ('sesame seed bagel', 1.19, '4 bagels', 3);
INSERT INTO product (name, price, description, category_id) VALUES ('pumpkin seed bun', 1.15, '4 buns', 3);
INSERT INTO product (name, price, description, category_id) VALUES ('chocolate cookies', 2.39, 'contain peanuts<br>(3 cookies)', 3);

INSERT INTO product (name, price, description, category_id) VALUES ('corn on the cob', 1.59, '2 pieces', 4);
INSERT INTO product (name, price, description, category_id) VALUES ('red currants', 2.49, '150g', 4);
INSERT INTO product (name, price, description, category_id) VALUES ('broccoli', 1.29, '500g', 4);
INSERT INTO product (name, price, description, category_id) VALUES ('seedless watermelon', 1.49, '250g', 4);

insert into customer (id, name, email, phone, address, city_region, cc_number) values (1, 'Jeremy', 'jmitchell0@jugem.jp', '7-(476)767-1456', '7167 Sunbrook Road', null, '3577572210921933');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (2, 'Ronald', 'rnguyen1@mit.edu', '63-(469)200-6514', '1 Knutson Drive', null, '4041371067835528');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (3, 'Kelly', 'kboyd2@paypal.com', '63-(810)882-6073', '16 Northport Terrace', null, '3558790922141250');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (4, 'Howard', 'hadams3@earthlink.net', '373-(416)936-2118', '768 Browning Pass', null, '3555407971397286');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (5, 'Shawn', 'scollins4@abc.net.au', '63-(130)955-4031', '7 Arkansas Road', null, '3577328100382557');

insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('63.53', 1, '12/3/2015', 3);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('34.71', 2, '2/8/2016', 3);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('99.48', 3, '3/9/2016', 5);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('278.83', 4, '11/2/2015', 5);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('145.44', 5, '3/28/2016', 1);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('214.04', 6, '1/8/2016', 2);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('210.88', 7, '9/30/2015', 3);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('126.26', 8, '9/11/2015', 4);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('77.52', 9, '6/29/2015', 3);
insert into customer_order (amount, confirmation_number, date_created, customer_id) values ('63.84', 10, '9/11/2015', 1);

insert into ordered_product (customer_order_id, product_id, quantity) values (5, 16, 1);
insert into ordered_product (customer_order_id, product_id, quantity) values (4, 4, 1);
insert into ordered_product (customer_order_id, product_id, quantity) values (7, 4, 4);
insert into ordered_product (customer_order_id, product_id, quantity) values (5, 7, 5);
insert into ordered_product (customer_order_id, product_id, quantity) values (7, 13, 1);
insert into ordered_product (customer_order_id, product_id, quantity) values (1, 13, 3);
insert into ordered_product (customer_order_id, product_id, quantity) values (5, 6, 1);
insert into ordered_product (customer_order_id, product_id, quantity) values (6, 1, 2);
insert into ordered_product (customer_order_id, product_id, quantity) values (6, 4, 1);
insert into ordered_product (customer_order_id, product_id, quantity) values (3, 4, 4);


INSERT INTO roles ("id", "name") VALUES (1, 'ADMIN_ROLE');
INSERT INTO roles ("id", "name") VALUES (2, 'MGR_ROLE');

INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 0);
INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 1);
INSERT INTO permissions ("role_id", "permission_id") VALUES (2, 1);

-- Passwords are same as corresponding usernames
INSERT INTO users ("id", "name", "password_hash") VALUES (1, 'admin', '$2a$10$vqjSFNSRKdTczpm.xTKZJuoiJ4VXPhmKII2rJ9FOGgNlGa1yBZ2C6');
INSERT INTO users ("id", "name", "password_hash") VALUES (2, 'mgr', '$2a$10$RWMNFYSY2Ps.YdoZJMw2/O9W7x7a52w8w5jwvwOSRnmy51i.Lwzmq');
INSERT INTO users ("id", "name", "password_hash") VALUES (3, 'user', '$2a$10$2LDzugB6LyO9dHT9po8Y2Otq2bBbeiCuBdGO.rakto62r1xVgZ2/a');

INSERT INTO jt_roles ("user_id", "role_id") VALUES (1, 1);
INSERT INTO jt_roles ("user_id", "role_id") VALUES (2, 2);