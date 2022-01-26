drop database if exists ciclisme;
create database ciclisme;
use ciclisme;

drop table if exists equips;
create table equips
( nom VARCHAR (25) NOT NULL,
  director VARCHAR (50),
  PRIMARY KEY (nom)
) engine=innodb;


drop table if exists ciclistes;
create table ciclistes
( dorsal INT (4) AUTO_INCREMENT,
  nom VARCHAR (30) NOT NULL,
  edat INT (3),
  equip VARCHAR (25),
  PRIMARY KEY (dorsal),
 FOREIGN KEY (equip) references equips (nom)
) engine=innodb;



drop table if exists etapes;
create table etapes
( numero INT (3) AUTO_INCREMENT,
  kms INT (3),
  eixida VARCHAR (35),
  arribada VARCHAR (35),
  dorsal INT (4),
    PRIMARY KEY (numero),
 FOREIGN KEY (dorsal) references ciclistes (dorsal)
) engine=innodb;



drop table if exists mallots;
create table mallots
( codi VARCHAR (3) NOT NULL,
  tipus VARCHAR (30),
  color VARCHAR (20),
  premi INT(10),
  PRIMARY KEY (codi)
) engine=innodb;



drop table if exists ports;
create table ports
(  nom VARCHAR (35) NOT NULL,
   altura INT(4),
   categoria VARCHAR (1),
   pendent FLOAT(3,2),
   etapa INT (3),
   ciclista INT (4),
   PRIMARY KEY (nom),
  FOREIGN KEY (ciclista) references ciclistes (dorsal),
  FOREIGN KEY (etapa) references etapes (numero)
) engine=innodb;



drop table if exists portar;
create table portar
( id INT(4) AUTO_INCREMENT,
  dorsal INT (4),
  numero INT (3) NOT NULL,
  codi VARCHAR (3) NOT NULL,
  PRIMARY KEY (id) ,
  FOREIGN KEY (dorsal) references ciclistes (dorsal),
  FOREIGN KEY (numero) references etapes (numero),
  FOREIGN KEY (codi) references mallots (codi)
) engine=innodb;



insert into equips values('Amore Vita','Ricardo Padacci');
insert into equips values('Artiach','Jose Perez');
insert into equips values('Banesto','Miguel Echevarria');
insert into equips values('Bresciali-Refin','Pietro Armani'); 
insert into equips values('Carrera','Luigi Petroni');
insert into equips values('Castorama','Jean Philip');
insert into equips values('Euskadi','Pedro Txucaru'); 
insert into equips values('Gatorade','Gian Luca Pacceli');
insert into equips values('Gewiss','Moreno Argentin');
insert into equips values('Jolly Club','Johan Richard'); 
insert into equips values('Kelme','Alvaro Pino'); 
insert into equips values('Lotus Festina','Suarez Cuevas');
insert into equips values('Mapei-Clas','Juan Fernandez');
insert into equips values('Mercatone Uno','Ettore Romano'); 
insert into equips values('Motorola','John Fidwell');
insert into equips values('Navigare','Lonrenzo Sciacci'); 
insert into equips values('ONCE','Manuel Sainz'); 
insert into equips values('PDM','Piet Van Der Kruis');
insert into equips values('Seguros Amaya','Minguez'); 
insert into equips values('Telecom','Morgan Reikcard'); 
insert into equips values('TVM','Steveens Henk');
insert into equips values('Wordperfect','Bill Gates');
 

insert into ciclistes (dorsal,edat,nom,equip) values(1,32,'Miguel Indurain','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(2,35,'Pedro Delgado','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(3,27,'Alex Zulle','ONCE');
insert into ciclistes (dorsal,edat,nom,equip) values(4,30,'Tony Rominger','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(5,32,'Gert-Jan Theunisse','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(6,33,'Adriano Baffi','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(7,30,'Massimiliano Lelli','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(8,33,'Jean Van Poppel','Lotus Festina');
insert into ciclistes (dorsal,edat,nom,equip) values(9,34,'Massimo Podenzana','Navigare');
insert into ciclistes (dorsal,edat,nom,equip) values(10,28,'Mario Cipollini','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(11,31,'Flavio Giupponi','Bresciali-Refin');
insert into ciclistes (dorsal,edat,nom,equip) values(12,31,'Alessio Di Basco','Amore Vita');
insert into ciclistes (dorsal,edat,nom,equip) values(13,28,'Lale Cubino','Seguros Amaya');
insert into ciclistes (dorsal,edat,nom,equip) values(14,33,'Roberto Pagnin','Navigare');
insert into ciclistes (dorsal,edat,nom,equip) values(15,31,'Jesper Skibby','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(16,29,'Dimitri Konishev','Jolly Club');
insert into ciclistes (dorsal,edat,nom,equip) values(17,37,'Bruno Leali','Bresciali-Refin');
insert into ciclistes (dorsal,edat,nom,equip) values(18,37,'Robert Millar','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(19,34,'Julian Gorospe','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(20,29,'Alfonso Gutierrez','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(21,31,'Erwin Nijboer','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(22,32,'Giorgio Furlan','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(23,27,'Lance Armstrong','Motorola');
insert into ciclistes (dorsal,edat,nom,equip) values(24,29,'Claudio Chiappucci','Carrera');
insert into ciclistes (dorsal,edat,nom,equip) values(25,32,'Gianni Bugno','Gatorade');
insert into ciclistes (dorsal,edat,nom,equip) values(26,27,'Mikel Zarrabeitia','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(27,28,'Laurent Jalabert','ONCE');
insert into ciclistes (dorsal,edat,nom,equip) values(28,33,'Jesus Montoya','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(29,28,'Angel Edo','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(30,28,'Melchor Mauri','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(31,30,'Vicente Aparicio','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(32,28,'Laurent Dufaux','ONCE');
insert into ciclistes (dorsal,edat,nom,equip) values(33,29,'Stefano della Santa','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(34,30,'Angel Yesid Camargo','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(35,28,'Erik Dekker','Wordperfect');
insert into ciclistes (dorsal,edat,nom,equip) values(36,32,'Gian Matteo Fagnini','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(37,29,'Scott Sunderland','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(38,25,'Javier Palacin','Euskadi');
insert into ciclistes (dorsal,edat,nom,equip) values(39,30,'Rudy Verdonck','Lotus Festina');
insert into ciclistes (dorsal,edat,nom,equip) values(40,32,'Viatceslav Ekimov','Wordperfect');
insert into ciclistes (dorsal,edat,nom,equip) values(41,25,'Rolf Aldag','Telecom');
insert into ciclistes (dorsal,edat,nom,equip) values(42,29,'Davide Cassani','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(43,28,'Francesco Casagrande','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(44,27,'Luca Gelfi','Gatorade');
insert into ciclistes (dorsal,edat,nom,equip) values(45,26,'Alberto Elli','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(46,24,'Agustin Sagasti','Euskadi');
insert into ciclistes (dorsal,edat,nom,equip) values(47,32,'Laurent Pillon','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(48,29,'Marco Saligari','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(49,23,'Eugeni Berzin','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(50,27,'Fernando Escartin','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(51,30,'Udo Bolts','Telecom');
insert into ciclistes (dorsal,edat,nom,equip) values(52,26,'Vladislav Bobrik','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(53,28,'Michele Bartoli','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(54,30,'Steffen Wesemann','Telecom');
insert into ciclistes (dorsal,edat,nom,equip) values(55,28,'Nicola Minali','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(56,29,'Andrew Hampsten','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(57,28,'Stefano Zanini','Navigare');
insert into ciclistes (dorsal,edat,nom,equip) values(58,34,'Gerd Audehm','Telecom');
insert into ciclistes (dorsal,edat,nom,equip) values(59,28,'Mariano Picolli','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(60,28,'Giovanni Lombardi','Bresciali-Refin');
insert into ciclistes (dorsal,edat,nom,equip) values(61,26,'Walte Castignola','Navigare');
insert into ciclistes (dorsal,edat,nom,equip) values(62,30,'Raul Alcala','Motorola');
insert into ciclistes (dorsal,edat,nom,equip) values(63,32,'Alvaro Mejia','Motorola');
insert into ciclistes (dorsal,edat,nom,equip) values(64,28,'Giuseppe Petito','Mercatone Uno');
insert into ciclistes (dorsal,edat,nom,equip) values(65,29,'Pascal Lino','Amore Vita');
insert into ciclistes (dorsal,edat,nom,equip) values(66,24,'Enrico Zaina','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(67,28,'Armand de las Cuevas','Castorama');
insert into ciclistes (dorsal,edat,nom,equip) values(68,28,'Angel Citracca','Navigare');
insert into ciclistes (dorsal,edat,nom,equip) values(69,27,'Eddy Seigneur','Castorama');
insert into ciclistes (dorsal,edat,nom,equip) values(70,29,'Sandro Heulot','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(71,27,'Prudencio Indurain','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(72,28,'Stefano Colage','Bresciali-Refin');
insert into ciclistes (dorsal,edat,nom,equip) values(73,35,'Laurent Fignon','Gatorade');
insert into ciclistes (dorsal,edat,nom,equip) values(74,36,'Claudio Chioccioli','Amore Vita');
insert into ciclistes (dorsal,edat,nom,equip) values(75,32,'Juan Romero','Seguros Amaya');
insert into ciclistes (dorsal,edat,nom,equip) values(76,34,'Marco Giovannetti','Gatorade');
insert into ciclistes (dorsal,edat,nom,equip) values(77,33,'Javier Mauleon','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(78,35,'Antonio Esparza','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(79,33,'Johan Bruyneel','ONCE');
insert into ciclistes (dorsal,edat,nom,equip) values(80,37,'Federico Echave','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(81,33,'Piotr Ugrumov','Gewiss');
insert into ciclistes (dorsal,edat,nom,equip) values(82,30,'Edgar Corredor','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(83,32,'Hernan Buenahora','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(84,31,'Jon Unzaga','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(85,30,'Dimitri Abdoujaparov','Carrera');
insert into ciclistes (dorsal,edat,nom,equip) values(86,32,'Juan Martinez Oliver','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(87,32,'Fernando Mota','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(88,28,'Angel Camarillo','Mapei-Clas');
insert into ciclistes (dorsal,edat,nom,equip) values(89,36,'Stefan Roche','Carrera');
insert into ciclistes (dorsal,edat,nom,equip) values(90,27,'Ivan Ivanov','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(91,28,'Nestor Mora','Kelme');
insert into ciclistes (dorsal,edat,nom,equip) values(92,27,'Federico Garcia','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(93,29,'Bo Hamburger','TVM');
insert into ciclistes (dorsal,edat,nom,equip) values(94,30,'Marino Alonso','Banesto');
insert into ciclistes (dorsal,edat,nom,equip) values(95,31,'Manuel Guijarro','Lotus Festina');
insert into ciclistes (dorsal,edat,nom,equip) values(96,29,'Tom Cordes','Wordperfect');
insert into ciclistes (dorsal,edat,nom,equip) values(97,28,'Casimiro Moreda','ONCE');
insert into ciclistes (dorsal,edat,nom,equip) values(98,25,'Eleuterio Anguita','Artiach');
insert into ciclistes (dorsal,edat,nom,equip) values(99,29,'Per Pedersen','Seguros Amaya');
insert into ciclistes (dorsal,edat,nom,equip) values(100,30,'William Palacios','Jolly Club');


insert into etapes(kms,eixida,arribada,dorsal) values( 9,'Valladolid','Valladolid',1); 
insert into etapes(kms,eixida,arribada,dorsal) values( 180,'Valladolid','Salamanca',36); 
insert into etapes(kms,eixida,arribada,dorsal) values( 240,'Salamanca','Caceres',12);
insert into etapes(kms,eixida,arribada,dorsal) values( 230,'Almendralejo','Cordoba',83);
insert into etapes(kms,eixida,arribada,dorsal) values( 170,'Cordoba','Granada',27); 
insert into etapes(kms,eixida,arribada,dorsal) values( 150,'Granada','Sierra Nevada',52); 
insert into etapes(kms,eixida,arribada,dorsal) values( 250,'Baza','Alicante',22); 
insert into etapes(kms,eixida,arribada,dorsal) values( 40,'Benidorm','Benidorm',1); 
insert into etapes(kms,eixida,arribada,dorsal) values( 150,'Benidorm','Valencia',35); 
insert into etapes(kms,eixida,arribada,dorsal) values( 200,'Igualada','Andorra',2); 
insert into etapes(kms,eixida,arribada,dorsal) values( 195,'Andorra','Estacion de Cerler',65); 
insert into etapes(kms,eixida,arribada,dorsal) values( 220,'Benasque','Zaragoza',12);
insert into etapes(kms,eixida,arribada,dorsal) values( 200,'Zaragoza','Pamplona',93);
insert into etapes(kms,eixida,arribada,dorsal) values( 172,'Pamplona','Alto de la Cruz de la Demanda',86);
insert into etapes(kms,eixida,arribada,dorsal) values( 207,'Santo Domingo de la Calzada','Santander',10); 
insert into etapes(kms,eixida,arribada,dorsal) values( 160,'Santander','Lagos de Covadonga',5);
insert into etapes(kms,eixida,arribada,dorsal) values( 140,'Cangas de Onis','Alto del Naranco',4); 
insert into etapes(kms,eixida,arribada,dorsal) values( 195,'Avila','Avila',8); 
insert into etapes(kms,eixida,arribada,dorsal) values( 190,'Avila','Destilerias Dyc',2);
insert into etapes(kms,eixida,arribada,dorsal) values( 200, 'Segovia','Destilerias Dyc',2); 
insert into etapes(kms,eixida,arribada,dorsal) values( 170,'Destilerias Dyc','Madrid',27);



insert into mallots values('MGE','General','amarillo',8000000);
insert into mallots values('MMO','Montanya','blanco y rojo',2000000);
insert into mallots values('MMS','Mas Sufrido','estrellas moradas',2000000);
insert into mallots values('MMV','Metas volantes','rojo',2000000);
insert into mallots values('MRE','Regularidad','verde',2000000);
insert into mallots values('MSE','Sprints especiales','rosa',2000000);



insert into ports values('Alto del Naranco',510,'1',6.90,10,30);
insert into ports values('Arcalis',510,'E',6.5,10,4);
insert into ports values('Cerler-Circo de Ampriu',510,'E',5.8,11,9);
insert into ports values('Coll de la Comella',510,'1',8.7,10,2);
insert into ports values('Coll de Ordino',510,'E',5.3,10,7);
insert into ports values('Cruz de la Demanda',510,'E',7.0,11,20);
insert into ports values('Lagos de Covadonga',510,'E',6.8,16,42);
insert into ports values('Navacerrada',510,'1',7.5,19,2);
insert into ports values('Puerto de Alisas',510,'1',5.8,15,1);
insert into ports values('Puerto de la Morcuera',510,'2',6.5,19,2);
insert into ports values('Puerto de Mijares',510,'1',4.9,18,24);
insert into ports values('Puerto de Navalmoral',510,'2',4.3,18,2);
insert into ports values('Puerto de Pedro Bernardo',510,'1',4.2,18,25);
insert into ports values('Sierra Nevada',510,'E',6.0,2,26);



insert into portar(dorsal,numero,codi) values(1,2,'MGE');
insert into portar(dorsal,numero,codi) values(1,1,'MGE');
insert into portar(dorsal,numero,codi) values(1,4,'MGE'); 
insert into portar(dorsal,numero,codi) values(1,3,'MGE'); 
insert into portar(dorsal,numero,codi) values(1,16,'MGE'); 
insert into portar(dorsal,numero,codi) values(1,17,'MGE'); 
insert into portar(dorsal,numero,codi) values(1,1,'MSE'); 
insert into portar(dorsal,numero,codi) values(1,18,'MGE');
insert into portar(dorsal,numero,codi) values(1,19,'MGE');
insert into portar(dorsal,numero,codi) values(1,1,'MRE'); 
insert into portar(dorsal,numero,codi) values(1,1,'MMO');
insert into portar(dorsal,numero,codi) values(1,21,'MGE');
insert into portar(dorsal,numero,codi) values(1,1,'MMV');
insert into portar(dorsal,numero,codi) values(1,20,'MGE'); 
insert into portar(dorsal,numero,codi) values(2,7,'MGE'); 
insert into portar(dorsal,numero,codi) values(2,6,'MGE'); 
insert into portar(dorsal,numero,codi) values(2,5,'MGE'); 
insert into portar(dorsal,numero,codi) values(2,21,'MMO');
insert into portar(dorsal,numero,codi) values(3,12,'MGE');
insert into portar(dorsal,numero,codi) values(3,11,'MGE'); 
insert into portar(dorsal,numero,codi) values(4,8,'MGE'); 
insert into portar(dorsal,numero,codi) values(8,2,'MSE');
insert into portar(dorsal,numero,codi) values( 8,4,'MSE'); 
insert into portar(dorsal,numero,codi) values( 10,18,'MSE');
insert into portar(dorsal,numero,codi) values( 12,5,'MSE'); 
insert into portar(dorsal,numero,codi) values( 12,3,'MSE'); 
insert into portar(dorsal,numero,codi) values( 12,6,'MSE'); 
insert into portar(dorsal,numero,codi) values( 16,2,'MMV'); 
insert into portar(dorsal,numero,codi) values( 16,6,'MMV'); 
insert into portar(dorsal,numero,codi) values( 16,3,'MMV'); 
insert into portar(dorsal,numero,codi) values( 16,5,'MMV'); 
insert into portar(dorsal,numero,codi) values( 17,4,'MMV'); 
insert into portar(dorsal,numero,codi) values( 20,17,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,21,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,19,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,11,'MRE');
insert into portar(dorsal,numero,codi) values( 20,8,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,18,'MMV'); 
insert into portar(dorsal,numero,codi) values( 20,12,'MRE');
insert into portar(dorsal,numero,codi) values( 20,9,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,13,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,6,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,20,'MRE');
insert into portar(dorsal,numero,codi) values( 20,14,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,10,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,7,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,16,'MRE'); 
insert into portar(dorsal,numero,codi) values( 20,15,'MRE'); 
insert into portar(dorsal,numero,codi) values( 22,20,'MSE'); 
insert into portar(dorsal,numero,codi) values( 22,16,'MSE'); 
insert into portar(dorsal,numero,codi) values( 22,21,'MSE');
insert into portar(dorsal,numero,codi) values( 22,15,'MSE'); 
insert into portar(dorsal,numero,codi) values( 22,19,'MSE'); 
insert into portar(dorsal,numero,codi) values( 22,14,'MSE'); 
insert into portar(dorsal,numero,codi) values( 22,17,'MSE');
insert into portar(dorsal,numero,codi) values( 24,4,'MMO'); 
insert into portar(dorsal,numero,codi) values( 25,5,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 25,3,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 25,2,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 26,8,'MMO');
insert into portar(dorsal,numero,codi)  values( 26,10,'MGE'); 
insert into portar(dorsal,numero,codi)  values( 26,18,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 26,7,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 26,9,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 26,9,'MGE'); 
insert into portar(dorsal,numero,codi)  values( 26,6,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 27,5,'MRE');
insert into portar(dorsal,numero,codi)  values( 27,4,'MRE'); 
insert into portar(dorsal,numero,codi)  values( 27,3,'MRE'); 
insert into portar(dorsal,numero,codi)  values( 27,2,'MRE'); 
insert into portar(dorsal,numero,codi)  values( 27,18,'MRE'); 
insert into portar(dorsal,numero,codi)  values( 28,15,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 28,16,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 28,17,'MMO');
insert into portar(dorsal,numero,codi)  values( 28,19,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 28,20,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 28,14,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 30,13,'MGE'); 
insert into portar(dorsal,numero,codi)  values( 30,15,'MGE'); 
insert into portar(dorsal,numero,codi)  values( 30,14,'MGE');
insert into portar(dorsal,numero,codi)  values( 30,13,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 30,12,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 30,11,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 30,10,'MMO'); 
insert into portar(dorsal,numero,codi)  values( 33,8,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 33,7,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,21,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,20,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,19,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,17,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,16,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,15,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 42,14,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 48,13,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 48,12,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 48,9,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 48,11,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 48,10,'MMV'); 
insert into portar(dorsal,numero,codi)  values( 67,3,'MMS');
insert into portar(dorsal,numero,codi)  values( 67,1,'MMS');
insert into portar(dorsal,numero,codi)  values( 69,2,'MMS');
insert into portar(dorsal,numero,codi)  values( 69,4,'MMS'); 
insert into portar(dorsal,numero,codi)  values( 99,10,'MSE'); 
insert into portar(dorsal,numero,codi)  values( 99,8,'MSE');
insert into portar(dorsal,numero,codi)  values( 99,12,'MSE'); 
insert into portar(dorsal,numero,codi)  values( 99,7,'MSE'); 
insert into portar(dorsal,numero,codi)  values( 99,11,'MSE');
insert into portar(dorsal,numero,codi)  values( 99,9,'MSE'); 
insert into portar(dorsal,numero,codi)  values( 99,13,'MSE');
