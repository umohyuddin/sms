-- Batch 1: Countries 1–50
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by)
VALUES
(1,'AF','Afghanistan','AFG','+93', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(2,'AL','Albania','ALB','+355', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(3,'DZ','Algeria','DZA','+213', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(4,'AD','Andorra','AND','+376', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(5,'AO','Angola','AGO','+244', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(6,'AR','Argentina','ARG','+54', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(7,'AM_','Armenia','ARM','+374', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(8,'AU','Australia','AUS','+61', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(9,'AT','Austria','AUT','+43', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(10,'AZ','Azerbaijan','AZE','+994', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(11,'BH','Bahrain','BHR','+973', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(12,'BD','Bangladesh','BGD','+880', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(13,'BY','Belarus','BLR','+375', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(14,'BE','Belgium','BEL','+32', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(15,'BZ','Belize','BLZ','+501', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(16,'BJ','Benin','BEN','+229', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(17,'BT','Bhutan','BTN','+975', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(18,'BO','Bolivia','BOL','+591', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(19,'BA','Bosnia and Herzegovina','BIH','+387', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(20,'BW','Botswana','BWA','+267', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(21,'BR','Brazil','BRA','+55', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(22,'BN','Brunei','BRN','+673', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(23,'BG','Bulgaria','BGR','+359', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(24,'BF','Burkina Faso','BFA','+226', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(25,'BI','Burundi','BDI','+257', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(26,'KH','Cambodia','KHM','+855', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(27,'CM','Cameroon','CMR','+237', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(28,'CA','Canada','CAN','+1', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(29,'CV','Cape Verde','CPV','+238', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(30,'CF','Central African Republic','CAF','+236', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(31,'TD','Chad','TCD','+235', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(32,'CL','Chile','CHL','+56', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(33,'CN','China','CHN','+86', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(34,'CO','Colombia','COL','+57', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(35,'KM','Comoros','COM','+269', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(36,'CG','Congo','COG','+242', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(37,'CR','Costa Rica','CRI','+506', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(38,'HR','Croatia','HRV','+385', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(39,'CU','Cuba','CUB','+53', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(40,'CY','Cyprus','CYP','+357', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(41,'CZ','Czech Republic','CZE','+420', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(42,'DK','Denmark','DNK','+45', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(43,'DJ','Djibouti','DJI','+253', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(44,'DO','Dominican Republic','DOM','+1', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(45,'EC','Ecuador','ECU','+593', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(46,'EG','Egypt','EGY','+20', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(47,'SV','El Salvador','SLV','+503', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(48,'EE','Estonia','EST','+372', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(49,'ET','Ethiopia','ETH','+251', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL),
(50,'FI','Finland','FIN','+358', CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, NULL);
-- ====================================================
-- Batch 2: Countries 51–100
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(51,'FR','France','FRA','+33', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(52,'GA','Gabon','GAB','+241', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(53,'GE','Georgia','GEO','+995', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(54,'DE','Germany','DEU','+49', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(55,'GH','Ghana','GHA','+233', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(56,'GR','Greece','GRC','+30', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(57,'GT','Guatemala','GTM','+502', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(58,'GN','Guinea','GIN','+224', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(59,'HT','Haiti','HTI','+509', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(60,'HN','Honduras','HND','+504', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(61,'HK','Hong Kong','HKG','+852', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(62,'HU','Hungary','HUN','+36', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(63,'IS','Iceland','ISL','+354', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(64,'IN','India','IND','+91', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(65,'ID','Indonesia','IDN','+62', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(66,'IR','Iran','IRN','+98', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(67,'IQ','Iraq','IRQ','+964', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(68,'IE','Ireland','IRL','+353', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(69,'IL','Israel','ISR','+972', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(70,'IT','Italy','ITA','+39', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(71,'JM','Jamaica','JAM','+1', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(72,'JP','Japan','JPN','+81', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(73,'JO','Jordan','JOR','+962', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(74,'KZ','Kazakhstan','KAZ','+7', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(75,'KE','Kenya','KEN','+254', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(76,'KW','Kuwait','KWT','+965', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(77,'KG','Kyrgyzstan','KGZ','+996', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(78,'LA','Laos','LAO','+856', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(79,'LV','Latvia','LVA','+371', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(80,'LB','Lebanon','LBN','+961', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(81,'LY','Libya','LBY','+218', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(82,'LT','Lithuania','LTU','+370', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(83,'LU','Luxembourg','LUX','+352', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(84,'MY','Malaysia','MYS','+60', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(85,'MV','Maldives','MDV','+960', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(86,'ML','Mali','MLI','+223', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(87,'MT','Malta','MLT','+356', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(88,'MX','Mexico','MEX','+52', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(89,'MN','Mongolia','MNG','+976', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(90,'MA','Morocco','MAR','+212', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(91,'MM','Myanmar','MMR','+95', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(92,'NP','Nepal','NPL','+977', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(93,'NL','Netherlands','NLD','+31', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(94,'NZ','New Zealand','NZL','+64', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(95,'NG','Nigeria','NGA','+234', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(96,'NO','Norway','NOR','+47', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(97,'OM','Oman','OMN','+968', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(98,'PK','Pakistan','PAK','+92', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(99,'PH','Philippines','PHL','+63', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(100,'PL','Poland','POL','+48', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 3: Countries 101–150
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(101,'PT','Portugal','PRT','+351', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(102,'QA','Qatar','QAT','+974', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(103,'RO','Romania','ROU','+40', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(104,'RU','Russia','RUS','+7', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(105,'SA','Saudi Arabia','SAU','+966', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(106,'SG','Singapore','SGP','+65', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(107,'ZA','South Africa','ZAF','+27', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(108,'KR','South Korea','KOR','+82', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(109,'ES','Spain','ESP','+34', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(110,'LK','Sri Lanka','LKA','+94', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(111,'SE','Sweden','SWE','+46', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(112,'CH','Switzerland','CHE','+41', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(113,'TH','Thailand','THA','+66', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(114,'TR','Turkey','TUR','+90', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(115,'AE','United Arab Emirates','ARE','+971', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(116,'UA','Ukraine','UKR','+380', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(117,'GB','United Kingdom','GBR','+44', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(118,'US','United States','USA','+1', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(119,'UY','Uruguay','URY','+598', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(120,'UZ','Uzbekistan','UZB','+998', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(121,'VN','Vietnam','VNM','+84', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(122,'YE','Yemen','YEM','+967', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(123,'ZM','Zambia','ZMB','+260', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(124,'ZW','Zimbabwe','ZWE','+263', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(125,'AM','Armenia','ARM','+374', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(126,'AZ','Azerbaijan','AZE','+994', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(127,'BY','Belarus','BLR','+375', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(128,'BA','Bosnia and Herzegovina','BIH','+387', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(129,'BG','Bulgaria','BGR','+359', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(130,'HR','Croatia','HRV','+385', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(131,'CY','Cyprus','CYP','+357', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(132,'CZ','Czech Republic','CZE','+420', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(133,'EE','Estonia','EST','+372', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(134,'GE','Georgia','GEO','+995', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(135,'HU','Hungary','HUN','+36', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(136,'IS','Iceland','ISL','+354', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(137,'KZ','Kazakhstan','KAZ','+7', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(138,'KG','Kyrgyzstan','KGZ','+996', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(139,'LV','Latvia','LVA','+371', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(140,'LI','Liechtenstein','LIE','+423', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(141,'LT','Lithuania','LTU','+370', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(142,'LU','Luxembourg','LUX','+352', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(143,'MK','North Macedonia','MKD','+389', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(144,'MT','Malta','MLT','+356', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(145,'MD','Moldova','MDA','+373', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(146,'MC','Monaco','MCO','+377', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(147,'ME','Montenegro','MNE','+382', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(148,'NL','Netherlands','NLD','+31', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(149,'NO','Norway','NOR','+47', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(150,'PL','Poland','POL','+48', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 4: Countries 151–200
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(151,'PT','Portugal','PRT','+351', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(152,'RO','Romania','ROU','+40', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(153,'RU','Russia','RUS','+7', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(154,'SM','San Marino','SMR','+378', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(155,'RS','Serbia','SRB','+381', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(156,'SK','Slovakia','SVK','+421', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(157,'SI','Slovenia','SVN','+386', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(158,'ES','Spain','ESP','+34', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(159,'SE','Sweden','SWE','+46', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(160,'CH','Switzerland','CHE','+41', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(161,'TR','Turkey','TUR','+90', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(162,'UA','Ukraine','UKR','+380', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(163,'GB','United Kingdom','GBR','+44', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(164,'VA','Vatican City','VAT','+379', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(165,'DZ','Algeria','DZA','+213', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(166,'AO','Angola','AGO','+244', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(167,'BJ','Benin','BEN','+229', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(168,'BW','Botswana','BWA','+267', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(169,'BF','Burkina Faso','BFA','+226', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(170,'BI','Burundi','BDI','+257', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(171,'CV','Cape Verde','CPV','+238', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(172,'CM','Cameroon','CMR','+237', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(173,'CF','Central African Republic','CAF','+236', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(174,'TD','Chad','TCD','+235', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(175,'KM','Comoros','COM','+269', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(176,'CG','Congo','COG','+242', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(177,'CD','Democratic Republic of the Congo','COD','+243', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(178,'DJ','Djibouti','DJI','+253', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(179,'EG','Egypt','EGY','+20', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(180,'GQ','Equatorial Guinea','GNQ','+240', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(181,'ER','Eritrea','ERI','+291', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(182,'ET','Ethiopia','ETH','+251', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(183,'GA','Gabon','GAB','+241', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(184,'GM','Gambia','GMB','+220', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(185,'GH','Ghana','GHA','+233', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(186,'GN','Guinea','GIN','+224', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(187,'GW','Guinea-Bissau','GNB','+245', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(188,'CI','Ivory Coast','CIV','+225', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(189,'KE','Kenya','KEN','+254', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(190,'LS','Lesotho','LSO','+266', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(191,'LR','Liberia','LBR','+231', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(192,'LY','Libya','LBY','+218', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(193,'MG','Madagascar','MDG','+261', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(194,'MW','Malawi','MWI','+265', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(195,'ML','Mali','MLI','+223', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(196,'MR','Mauritania','MRT','+222', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(197,'MU','Mauritius','MUS','+230', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(198,'MA','Morocco','MAR','+212', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(199,'MZ','Mozambique','MOZ','+258', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(200,'NA','Namibia','NAM','+264', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL);
-- ====================================================
-- Batch 5: Countries 201–246
-- ====================================================
INSERT INTO country
(id, country_code, country_name, iso_code, phone_code, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES
(201,'NP','Nepal','NPL','+977', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(202,'NL','Netherlands','NLD','+31', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(203,'NZ','New Zealand','NZL','+64', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(204,'NI','Nicaragua','NIC','+505', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(205,'NE','Niger','NER','+227', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(206,'NG','Nigeria','NGA','+234', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(207,'KP','North Korea','PRK','+850', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(208,'MK','North Macedonia','MKD','+389', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(209,'NO','Norway','NOR','+47', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(210,'OM','Oman','OMN','+968', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(211,'PK','Pakistan','PAK','+92', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(212,'PW','Palau','PLW','+680', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(213,'PA','Panama','PAN','+507', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(214,'PG','Papua New Guinea','PNG','+675', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(215,'PY','Paraguay','PRY','+595', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(216,'PE','Peru','PER','+51', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(217,'PH','Philippines','PHL','+63', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(218,'PL','Poland','POL','+48', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(219,'PT','Portugal','PRT','+351', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(220,'QA','Qatar','QAT','+974', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(221,'RO','Romania','ROU','+40', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(222,'RU','Russia','RUS','+7', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(223,'RW','Rwanda','RWA','+250', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(224,'KN','Saint Kitts and Nevis','KNA','+1-869', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(225,'LC','Saint Lucia','LCA','+1-758', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(226,'VC','Saint Vincent and the Grenadines','VCT','+1-784', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(227,'WS','Samoa','WSM','+685', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(228,'SM','San Marino','SMR','+378', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(229,'ST','Sao Tome and Principe','STP','+239', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(230,'SA','Saudi Arabia','SAU','+966', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(231,'SN','Senegal','SEN','+221', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(232,'RS','Serbia','SRB','+381', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(233,'SC','Seychelles','SYC','+248', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(234,'SL','Sierra Leone','SLE','+232', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(235,'SG','Singapore','SGP','+65', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(236,'SK','Slovakia','SVK','+421', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(237,'SI','Slovenia','SVN','+386', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(238,'SB','Solomon Islands','SLB','+677', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(239,'SO','Somalia','SOM','+252', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(240,'ZA','South Africa','ZAF','+27', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(241,'KR','South Korea','KOR','+82', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(242,'SS','South Sudan','SSD','+211', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(243,'ES','Spain','ESP','+34', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(244,'LK','Sri Lanka','LKA','+94', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(245,'SD','Sudan','SDN','+249', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL),
(246,'ZW','Zimbabwe','ZWE','+263', CURRENT_TIMESTAMP, 1, NULL, NULL, NULL, NULL);



INSERT INTO provinces
(country_id, name, code, is_active, created_at, created_by, updated_at)
VALUES
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Punjab', 'PB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Sindh', 'SD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Khyber Pakhtunkhwa', 'KP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Balochistan', 'BL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Gilgit-Baltistan', 'GB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Azad Jammu and Kashmir', 'AJK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM country WHERE iso_code='PAK' LIMIT 1), 'Islamabad Capital Territory', 'ICT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);

INSERT INTO cities
(province_id, name, code, is_active, created_at, created_by, updated_at)
VALUES

-- ================= PUNJAB =================
((SELECT id FROM provinces WHERE name='Punjab'), 'Lahore', 'LHR', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Faisalabad', 'FSD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rawalpindi', 'RWP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Multan', 'MUX', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Gujranwala', 'GUJ', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sialkot', 'SKT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Bahawalpur', 'BWP', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Sargodha', 'SGD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Punjab'), 'Rahim Yar Khan', 'RYK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= SINDH =================
((SELECT id FROM provinces WHERE name='Sindh'), 'Karachi', 'KHI', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Hyderabad', 'HYD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Sukkur', 'SKZ', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Larkana', 'LRK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Nawabshah', 'NWS', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Sindh'), 'Mirpurkhas', 'MPK', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= KP =================
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Peshawar', 'PEW', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Mardan', 'MRD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Abbottabad', 'ABT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Swat', 'SWT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Khyber Pakhtunkhwa'), 'Kohat', 'KHT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= BALOCHISTAN =================
((SELECT id FROM provinces WHERE name='Balochistan'), 'Quetta', 'QTA', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Gwadar', 'GWD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Turbat', 'TBT', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Balochistan'), 'Khuzdar', 'KZD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= GILGIT BALTISTAN =================
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Gilgit', 'GIL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Gilgit-Baltistan'), 'Skardu', 'SKD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= AJK =================
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Muzaffarabad', 'MZD', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Mirpur', 'MPR', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
((SELECT id FROM provinces WHERE name='Azad Jammu and Kashmir'), 'Kotli', 'KTL', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),

-- ================= ISLAMABAD =================
((SELECT id FROM provinces WHERE name='Islamabad Capital Territory'), 'Islamabad', 'ISB', TRUE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);






INSERT INTO institutes
(id, name, address, contact_number, email, website, tagline, logo_url,
 established_date, country_id, province_id, city_id, created_at, updated_at)
VALUES
(
 1, 'Smart Solutions School','123 Main Street, Lahore','+92-300-1234567','info@smartsolutions.edu','https://www.smartsolutions.edu','Excellence in Education',NULL, '2005-08-15',
 (SELECT id FROM country WHERE iso_code='PAK' LIMIT 1),
 (SELECT id FROM provinces WHERE name = 'Punjab'),
 (SELECT id FROM cities WHERE name = 'Lahore'),
 CURRENT_TIMESTAMP,
 CURRENT_TIMESTAMP
);
   -- ==========================================
   -- EMPLOYEE MASTER DATA (Required before system_users)
   -- ==========================================
   INSERT INTO employee_master
   (organization_id, employee_code, first_name, last_name, full_name, gender, date_of_birth, marital_status, joining_date, probation_end_date, primary_phone, email, active, created_by)
   VALUES
   (1, 'EMP001', 'Uzair', 'Anwar', 'Uzair Anwar', 'MALE', '1990-05-12', 'SINGLE', '2022-01-10', '2022-07-10', '03001234567', 'uzair.anwar@example.com', TRUE, 1),
   (1, 'EMP002', 'Ayesha', 'Khan', 'Ayesha Khan', 'FEMALE', '1988-11-25', 'MARRIED', '2021-06-15', '2021-12-15', '03009876543', 'ayesha.khan@example.com', TRUE, 1),
   (1, 'EMP003', 'Ali', 'Raza', 'Ali Raza', 'MALE', '1992-03-30', 'SINGLE', '2023-03-01', '2023-09-01', '03004567890', 'ali.raza@example.com', TRUE, 1);



-- ==========================================
-- SYSTEM USERS WITH USER TYPE
-- ==========================================
INSERT INTO system_users
(organization_id, username, email, phone, password_hash, employee_id, student_id, user_type, is_active, is_verified, created_at, updated_at)
VALUES
-- Admin User (No employee or student link)
(1, 'admin.user', 'admin@gmail.com', '03001234567',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'ADMIN', TRUE, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Employee User (Teacher) - References employee_id 1 (Uzair Anwar)
(1, 'teacher.user', 'teacher@example.com', '03007654321',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 1, NULL, 'EMPLOYEE', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Employee User (HR Officer) - References employee_id 2 (Ayesha Khan)
(1, 'hr.officer', 'hr.officer@example.com', '03012345678',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 2, NULL, 'EMPLOYEE', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Student User (No employee link)
(1, 'student.user', 'student@example.com', '03111223344',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'STUDENT', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Student User (No employee link)
(1, 'ayesha.student', 'ayesha.student@example.com', '03117654321',
 '$2a$10$6rM4qYjGf1MWpzIvS5G72uFXtHTh0VqxGNpZVvBLlXuI9v5snjF6y',
 NULL, NULL, 'STUDENT', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO fee_recurrence_rules(code, name, description, is_active, is_deleted, created_at, created_by, updated_at)
VALUES
('ONE_TIME', 'One Time', 'Fee charged only once (e.g., admission or registration fee)', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MONTHLY', 'Monthly', 'Fee charged every month (common for tuition fees)', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('QUARTERLY', 'Quarterly', 'Fee charged every three months', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('HALF_YEARLY', 'HALF YEARLY', 'Fee charged twice in an academic year',TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ANNUAL', 'Annual', 'Fee charged once per academic year',TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PER_TERM', 'Per Term', 'Fee charged per academic term or semester', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ON_DEMAND', 'On Demand', 'Fee charged when a service is used (transport, lab, activity)', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);



INSERT INTO facility_types (code, name, description, is_active, is_deleted, created_at, created_by, updated_at) VALUES
('LAB', 'Laboratory', 'Science, computer, or language labs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('LIBRARY', 'Library', 'Reading, reference, digital library', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PLAYGROUND', 'Playground', 'Outdoor sports and recreation area', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AUDITORIUM', 'Auditorium', 'Multipurpose hall for events and gatherings', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CAFETERIA', 'Cafeteria', 'Dining area for students and staff', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('HOSTEL', 'Hostel', 'On-campus accommodation for students', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MEDICAL_ROOM', 'Medical Room', 'First-aid and health services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('STAFF_ROOM', 'Staff Room', 'Teachers\' lounge or office area', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('TRANSPORT', 'Transport Facility', 'School buses, vans, or transport services', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PRAYER_HALL', 'Prayer Hall', 'For religious activities or meditation', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SPORTS_GROUND', 'Sports Ground', 'Fields or courts for games like cricket, football, etc.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MUSIC_ROOM', 'Music Room', 'For music classes and practice', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ART_ROOM', 'Art Room', 'For painting, crafts, and other creative activities', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('COMPUTER_ROOM', 'Computer Room', 'Dedicated computer lab for students', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SCIENCE_ROOM', 'Science Lab', 'Physics, Chemistry, or Biology labs', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('LANGUAGE_LAB', 'Language Lab', 'For learning foreign languages', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SWIMMING_POOL', 'Swimming Pool', 'Swimming facility', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('GYM', 'Gymnasium', 'Indoor fitness and exercise facility', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PARKING', 'Parking Facility', 'Staff and visitor parking', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MULTIPURPOSE_HALL', 'Multipurpose Hall', 'For indoor activities, events, or assemblies', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);



INSERT INTO currencies (iso_code, name, symbol, is_active, is_deleted, created_at, created_by, updated_at) VALUES
('AFN', 'Afghan Afghani', '؋', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ALL', 'Albanian Lek', 'L', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('DZD', 'Algerian Dinar', 'د.ج', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('EUR', 'Euro', '€', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AOA', 'Angolan Kwanza', 'Kz', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ARS', 'Argentine Peso', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AUD', 'Australian Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AZN', 'Azerbaijani Manat', '₼', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BSD', 'Bahamian Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BHD', 'Bahraini Dinar', '.د.ب', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BDT', 'Bangladeshi Taka', '৳', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BBD', 'Barbados Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BYN', 'Belarusian Ruble', 'Br', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BZD', 'Belize Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BTN', 'Bhutanese Ngultrum', 'Nu.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BOB', 'Bolivian Boliviano', 'Bs.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BAM', 'Bosnian Convertible Mark', 'KM', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BWP', 'Botswana Pula', 'P', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('BRL', 'Brazilian Real', 'R$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CAD', 'Canadian Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CLP', 'Chilean Peso', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CNY', 'Chinese Yuan', '¥', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('COP', 'Colombian Peso', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CZK', 'Czech Koruna', 'Kč', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('DKK', 'Danish Krone', 'kr', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('DOP', 'Dominican Peso', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('EGP', 'Egyptian Pound', 'E£', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ETB', 'Ethiopian Birr', 'Br', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('INR', 'Indian Rupee', '₹', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('IDR', 'Indonesian Rupiah', 'Rp', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ILS', 'Israeli New Shekel', '₪', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('JPY', 'Japanese Yen', '¥', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('KES', 'Kenyan Shilling', 'Sh', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('KWD', 'Kuwaiti Dinar', 'د.ك', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MYR', 'Malaysian Ringgit', 'RM', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MXN', 'Mexican Peso', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('MAD', 'Moroccan Dirham', 'د.م.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('NPR', 'Nepalese Rupee', '₨', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('NZD', 'New Zealand Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('NGN', 'Nigerian Naira', '₦', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('NOK', 'Norwegian Krone', 'kr', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PKR', 'Pakistani Rupee', '₨', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('PHP', 'Philippine Peso', '₱', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('QAR', 'Qatari Riyal', 'ر.ق', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('RUB', 'Russian Ruble', '₽', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SAR', 'Saudi Riyal', 'ر.س', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SGD', 'Singapore Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ZAR', 'South African Rand', 'R', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('KRW', 'South Korean Won', '₩', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('SEK', 'Swedish Krona', 'kr', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('CHF', 'Swiss Franc', 'CHF', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('THB', 'Thai Baht', '฿', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('TRY', 'Turkish Lira', '₺', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('AED', 'UAE Dirham', 'د.إ', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('USD', 'US Dollar', '$', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('VES', 'Venezuelan Bolívar', 'Bs.', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('XOF', 'West African CFA Franc', 'Fr', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
('ZMW', 'Zambian Kwacha', 'K', TRUE, FALSE, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);

INSERT INTO charge_types
(code, name, description, is_active, deleted, created_at, updated_at)
VALUES
('FIXED',       'Fixed Amount', 'Standard set amount (e.g., tuition, admission)',                                                         TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PERCENTAGE',  'Percentage',   'Fee calculated as a % of another fee or total (e.g., late fine, discount)',                               TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('SLAB',        'Slab Based',   'Amount depends on slabs (e.g., transport fee depends on distance or zone)',                                TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PER_UNIT',    'Per Unit',     'Fee per unit/item (e.g., lab consumables, books, meals)',                                                 TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('CONDITIONAL', 'Conditional',  'Fee applies only if certain condition is met (e.g., extra-curricular activity only for enrolled students)', TRUE, FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE name=VALUES(name), updated_at=VALUES(updated_at);
