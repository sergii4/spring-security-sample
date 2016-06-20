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
insert into customer (id, name, email, phone, address, city_region, cc_number) values (6, 'Donna', 'dhamilton5@princeton.edu', '48-(798)246-0653', '46667 Buhler Park', null, '3565283436553310');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (7, 'Richard', 'rgraham6@home.pl', '55-(348)410-8607', '0 Northridge Crossing', null, '3538306821106982');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (8, 'Carlos', 'cpayne7@webeden.co.uk', '86-(138)476-1591', '73545 Knutson Terrace', null, '5602225889886259');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (9, 'Doris', 'djohnson8@blinklist.com', '382-(164)637-2093', '73038 Judy Terrace', null, '5602247329864290');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (10, 'Sharon', 'scarpenter9@google.com', '62-(247)828-2308', '35088 7th Place', null, '3568697395947956');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (11, 'Diane', 'djacobsa@foxnews.com', '55-(432)411-9319', '9675 Buhler Parkway', null, '67634590456534273');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (12, 'Marilyn', 'mcarpenterb@wikia.com', '686-(854)289-0959', '85959 Fairview Place', null, '3587698773693680');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (13, 'Peter', 'pellisc@wikipedia.org', '33-(656)379-8954', '1 Kipling Parkway', 'Corse', '5100135090399355');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (14, 'Kathleen', 'khilld@cnn.com', '7-(485)673-3842', '1440 Dennis Junction', null, '30303857379996');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (15, 'Mark', 'mmillse@webs.com', '975-(362)911-6776', '171 Coleman Plaza', null, '58937802729001698');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (16, 'Sharon', 'sturnerf@go.com', '53-(932)902-6607', '6055 Glendale Trail', null, '374622560693599');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (17, 'Aaron', 'abrooksg@creativecommons.org', '216-(273)623-7674', '06 Di Loreto Lane', null, '3539752613420066');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (18, 'Beverly', 'brichardsonh@hp.com', '63-(818)393-0839', '5 Anniversary Circle', null, '4844989417483399');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (19, 'Johnny', 'jhanseni@dion.ne.jp', '62-(167)661-5659', '7742 Montana Crossing', null, '5610025287824054');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (20, 'Samuel', 'swellsj@salon.com', '353-(276)675-3858', '3952 Marcy Parkway', null, '3529718301470426');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (21, 'Joseph', 'jhansonk@timesonline.co.uk', '86-(705)258-5839', '7 Elka Street', null, '6304045047652029917');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (22, 'Martha', 'mwilsonl@state.gov', '66-(460)244-5226', '6 Swallow Center', null, '5552805103381565');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (23, 'Donna', 'dhartm@netscape.com', '509-(503)420-6188', '845 Westport Point', null, '3539768399692892');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (24, 'Betty', 'blewisn@hibu.com', '234-(747)261-4613', '110 Boyd Junction', null, '3553973712853822');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (25, 'Martin', 'mandrewso@uol.com.br', '1-(320)750-1886', '7 Reinke Way', 'Minnesota', '3531749497724256');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (26, 'Christine', 'crogersp@adobe.com', '62-(926)752-3320', '35545 Melvin Place', null, '6397204812074157');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (27, 'Ann', 'alawrenceq@ebay.com', '62-(438)883-0518', '30424 Dapin Drive', null, '3538633964067436');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (28, 'Frances', 'fmillsr@usgs.gov', '504-(815)554-5778', '9747 Dakota Hill', null, '3537285910438376');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (29, 'Roger', 'relliotts@businessweek.com', '52-(525)346-1854', '873 Arapahoe Avenue', 'Guerrero', '4905538212169699');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (30, 'Emily', 'ediazt@cbc.ca', '86-(753)368-1573', '593 Muir Alley', null, '3537878151537276');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (31, 'Paul', 'phayesu@github.com', '63-(583)536-6356', '5589 Merchant Hill', null, '3581248678471372');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (32, 'Michelle', 'mharveyv@yellowbook.com', '375-(127)541-2595', '52 Hoffman Avenue', null, '3528675695295952');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (33, 'Mildred', 'mdavisw@ucoz.ru', '81-(993)164-2677', '05989 Old Shore Trail', null, '3570263704320330');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (34, 'Joe', 'jcolemanx@eventbrite.com', '30-(383)744-6369', '656 Riverside Trail', null, '5560883275695021');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (35, 'Andrea', 'aharrisony@dagondesign.com', '389-(419)502-5743', '4734 Packers Pass', null, '4041371937392');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (36, 'Kimberly', 'kjacobsz@independent.co.uk', '62-(757)439-2367', '242 Onsgard Junction', null, '3583577613271069');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (37, 'Anthony', 'arivera10@storify.com', '98-(849)189-9316', '345 Helena Plaza', null, '3564844110910737');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (38, 'Rebecca', 'rlane11@homestead.com', '63-(998)169-2501', '73 Anzinger Street', null, '5610940710113455');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (39, 'Chris', 'ccole12@msu.edu', '7-(820)391-8837', '37759 Myrtle Terrace', null, '3559666177601934');
insert into customer (id, name, email, phone, address, city_region, cc_number) values (40, 'Justin', 'jjordan13@theguardian.com', '86-(208)898-5496', '687 Heffernan Way', null, '3559016225934152');


