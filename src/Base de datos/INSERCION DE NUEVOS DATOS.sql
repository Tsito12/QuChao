set search_path to scautodromo;

--INSERCIÓN DE NUEVOS DATOS

insert into piloto values (65897827,'Heriberto', 'Gonzalez','López', 'SpeedMan'),
						(73628930,'Alfonso','Torres','Márquez','BluesRace'),
						(87364712,'Adalberto','Fernandez','Aguilera','Adalone'),
						(72389230,'Gibrán','Melendez','Sornoza','Gilfas'),
						(79182378,'Oscar','Perez','Marín','Checo'),
						(74673728,'Sergio','Victoria','Guzman','Rredlemon'),
						(87267349,'Alejandro','Bohorquez','Juan','Alexman'),
						(98273849,'Alfredo','Martinez','Altamirano','Fredo'),
						(72282929,'Luis','Gomez','Morales','Luismogo'),
						(98123889,'Joaquin','Fernandez','Aquino','SpeedyG'),
						(73939410,'Gerardo','Montante','Torres','Cachorro'),
						(89198498,'Emanuel','Vega','Montaña','Montañon'),
						(89128912,'Israel','Coronado','Viapri','Viapri Coronado'),
						(98149812,'Juan Carlos','Viana','Primero','Juca');
insert into carrera values
(78712991, 0,'2019/12/14',4, '10:00:00.00'),
(89148912, 0,'2019/12/15',7, '14:00:00.00'),
(89149124, 0,'2019/12/24',9, '13:00:00.00'),
(85428523, 0,'2019/12/17',2, '11:00:00.00'),
(89238923, 0,'2019/12/19',5, '07:00:00.00'),
(89239141, 0,'2019/12/21',4, '17:00:00.00'),
(72387239, 0,'2019/12/18',8, '08:00:00.00'),
(29835981, 0,'2019/12/24',3, '10:00:00.00'),
(98238239, 0,'2019/12/26',9, '19:00:00.00'),
(82323412, 0,'2019/12/27',2, '15:00:00.00');


--ids de las carreras que creaste apenas
--números de licencia de los pilotos que van a correr en esa carrera
--lo demás que se quede nulo
insert into resultados values 
(78712991,65897827,null,null),
(89148912,73628930,null,null),
(89149124,87364712,null,null),
(85428523,72389230,null,null),
(89238923,79182378,null,null),
(89239141,74673728,null,null),
(72387239,87267349,null,null),
(29835981,72282929,null,null),
(98238239,98123889,null,null),
(82323412,73939410,null,null),
(89239141,89198498,null, null),
(89148912,89128912,null, null),
(78712991,98149812,null, null);

insert into apuesta (nombre_usuario, id_carrera, nolicencia, monto,importe)values
('Ignatius99',65432126,78945634,1000),
('Inez28',65432126,63908514,800),
('Reuben08',65432127,79314837,1200),
('Helen101',65432127,93201795,500),
('Katelyn0',65432127,87494127,2000),
('Cooper23',65432128,42488698,5000),
('Derek795',65432128,42488698,1100),
('Hardy830',65432128,36818384,1500),
('Gloria69',65432129,97419638,500),
('Paul2011',65432130,63908514,800),
('Leandra501',65432130,87494127,1100),
('Allegra01',65432130,87494127,2000),
('99Cathleen',65432130,85462974,8000),
('Chandler',65432131,93201795,1000),
('Rogan9',65432131,63908514,800),
('PerryHor',65432132,87494127,2000),
('feliz20',65432132,79830482,1500),
('Rogan9',65432133,36818384,2500),
('Chandler',65432134,85462974,1000),
('Ignatius99',65432134,87494127,2000);

insert into apuesta values
('Amado01',78712991,65897827, 1500, '2019-04-30',0),
('Alfredo91',89148912,73628930, 1984, '2019-03-15',0),
('Hemanuel13',89149124,87364712,1550,'2018-02-15', 0),
('Katya41',85428523, 72389230,1500,'2018-03-18',0),
('Nadya14',89238923, 79182378, 1459,'2019-11-10',0),
('Isai15',89239141, 74673728, 1239,'2018-10-09',0),
('Harold30',72387239,87267349, 1234,'2018-09-12',0),
('Trevi69',29835981,72282929, 1340,'2019-03-15',0),
('Paulo11',98238239,98123889, 1600,'2019-02-21',0),
('YungS24',82323412,73939410, 1250,'2018-07-24',0);




insert into cliente values
('Amado01','52222 4637 4738 2839','AMA09128HFCH','Amado','Riviera','Maya','41245','Orleans ',10,'San Martín','gerardoBlanco@gmail.com'),
('Alfredo91','5222 7382 1213 1931','ALF191DHC12','Alfredo','McGregor','Connor','53451','Jersey',20,'San Taro Sa','gerardoOrtiz@gmail.com'),
('Hemanuel13','5222 7462 1382 1833','HEM292HFR12','Hemanuel','Xavier','López','12556','Alvaro',30,'Crespo','hemaanuelribba@gmailcom'),
('Katya41','5222 4748 3892 9189','KAT834HDC71','Katya','Mendoza','Gomez','36464','Lactan',40,'Mullins','katyamendoza@gmail.com'),
('Nadya14','5222 6362 2134 9831','NAD823UEHR1','Nadya','Mendoza','Gomez','21211','Columbia',50,'Kinging','hibrydTHC@gmail.com'),
('Isai15','5222 1241 8231 8924','ISA983NDM92','Isai','Huggies','Supreme','12451','Lazaro Cardenas.',60,'Brenamiel','isaigomez@gmail.com'),
('Harold30','5222 8723 1489 1245','HAR928FHN23','Harold','Axuara','Perez','53251','Reforma Av.',70,'Pueblo nuevo','haroldazuara@gmail.com'),
('Trevi69','5222 1245 2553 4623','TRE182NCJ3E','Trevi','Gloria','Hackermand','62314','Alfalta boulevard',80,'Reforma','Andres_Calamaro@gmail.com'),
('Paulo11','5222 8341 1245 2353','PAU834NFJV2','Paulo','Londra','Ovydrums','64252','LetorréAv.',90,'Ankara','Pauloglez@gmail.com'),
('YungS24','5222 4525 2515 3251','YUN485FHT48','YungSa Rria','Sarria','Gomez','67345','Lesue ñé Av.',96,'Tennessee','yungSa@gmail.com');
