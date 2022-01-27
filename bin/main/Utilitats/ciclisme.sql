drop database if exists ciclisme;
create database ciclisme;
use ciclisme;




drop table if exists ciclistes;
create table ciclistes
( dorsal INT (4) AUTO_INCREMENT,
  nom VARCHAR (30) NOT NULL,
  edat INT (3),
  PRIMARY KEY (dorsal)
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




 

insert into ciclistes (dorsal,edat,nom) values(1,32,'Miguel Indurain');
insert into ciclistes (dorsal,edat,nom) values(2,35,'Pedro Delgado');
insert into ciclistes (dorsal,edat,nom) values(3,27,'Alex Zulle');
insert into ciclistes (dorsal,edat,nom) values(4,30,'Tony Rominger');
insert into ciclistes (dorsal,edat,nom) values(5,32,'Gert-Jan Theunisse');
insert into ciclistes (dorsal,edat,nom) values(6,33,'Adriano Baffi');
insert into ciclistes (dorsal,edat,nom) values(7,30,'Massimiliano Lelli');
insert into ciclistes (dorsal,edat,nom) values(8,33,'Jean Van Poppel');
insert into ciclistes (dorsal,edat,nom) values(9,34,'Massimo Podenzana');
insert into ciclistes (dorsal,edat,nom) values(10,28,'Mario Cipollini');
insert into ciclistes (dorsal,edat,nom) values(11,31,'Flavio Giupponi');
insert into ciclistes (dorsal,edat,nom) values(12,31,'Alessio Di Basco');
insert into ciclistes (dorsal,edat,nom) values(13,28,'Lale Cubino');
insert into ciclistes (dorsal,edat,nom) values(14,33,'Roberto Pagnin');
insert into ciclistes (dorsal,edat,nom) values(15,31,'Jesper Skibby');
insert into ciclistes (dorsal,edat,nom) values(16,29,'Dimitri Konishev');
insert into ciclistes (dorsal,edat,nom) values(17,37,'Bruno Leali');
insert into ciclistes (dorsal,edat,nom) values(18,37,'Robert Millar');
insert into ciclistes (dorsal,edat,nom) values(19,34,'Julian Gorospe');
insert into ciclistes (dorsal,edat,nom) values(20,29,'Alfonso Gutierrez');
insert into ciclistes (dorsal,edat,nom) values(21,31,'Erwin Nijboer');
insert into ciclistes (dorsal,edat,nom) values(22,32,'Giorgio Furlan');
insert into ciclistes (dorsal,edat,nom) values(23,27,'Lance Armstrong');
insert into ciclistes (dorsal,edat,nom) values(24,29,'Claudio Chiappucci');
insert into ciclistes (dorsal,edat,nom) values(25,32,'Gianni Bugno');
insert into ciclistes (dorsal,edat,nom) values(26,27,'Mikel Zarrabeitia');
insert into ciclistes (dorsal,edat,nom) values(27,28,'Laurent Jalabert');
insert into ciclistes (dorsal,edat,nom) values(28,33,'Jesus Montoya');
insert into ciclistes (dorsal,edat,nom) values(29,28,'Angel Edo');
insert into ciclistes (dorsal,edat,nom) values(30,28,'Melchor Mauri');
insert into ciclistes (dorsal,edat,nom) values(31,30,'Vicente Aparicio');
insert into ciclistes (dorsal,edat,nom) values(32,28,'Laurent Dufaux');
insert into ciclistes (dorsal,edat,nom) values(33,29,'Stefano della Santa');
insert into ciclistes (dorsal,edat,nom) values(34,30,'Angel Yesid Camargo');
insert into ciclistes (dorsal,edat,nom) values(35,28,'Erik Dekker');
insert into ciclistes (dorsal,edat,nom) values(36,32,'Gian Matteo Fagnini');
insert into ciclistes (dorsal,edat,nom) values(37,29,'Scott Sunderland');
insert into ciclistes (dorsal,edat,nom) values(38,25,'Javier Palacin');
insert into ciclistes (dorsal,edat,nom) values(39,30,'Rudy Verdonck');
insert into ciclistes (dorsal,edat,nom) values(40,32,'Viatceslav Ekimov');
insert into ciclistes (dorsal,edat,nom) values(41,25,'Rolf Aldag');
insert into ciclistes (dorsal,edat,nom) values(42,29,'Davide Cassani');
insert into ciclistes (dorsal,edat,nom) values(43,28,'Francesco Casagrande');
insert into ciclistes (dorsal,edat,nom) values(44,27,'Luca Gelfi');
insert into ciclistes (dorsal,edat,nom) values(45,26,'Alberto Elli');
insert into ciclistes (dorsal,edat,nom) values(46,24,'Agustin Sagasti');
insert into ciclistes (dorsal,edat,nom) values(47,32,'Laurent Pillon');
insert into ciclistes (dorsal,edat,nom) values(48,29,'Marco Saligari');
insert into ciclistes (dorsal,edat,nom) values(49,23,'Eugeni Berzin');
insert into ciclistes (dorsal,edat,nom) values(50,27,'Fernando Escartin');
insert into ciclistes (dorsal,edat,nom) values(51,30,'Udo Bolts');
insert into ciclistes (dorsal,edat,nom) values(52,26,'Vladislav Bobrik');
insert into ciclistes (dorsal,edat,nom) values(53,28,'Michele Bartoli');
insert into ciclistes (dorsal,edat,nom) values(54,30,'Steffen Wesemann');
insert into ciclistes (dorsal,edat,nom) values(55,28,'Nicola Minali');
insert into ciclistes (dorsal,edat,nom) values(56,29,'Andrew Hampsten');
insert into ciclistes (dorsal,edat,nom) values(57,28,'Stefano Zanini');
insert into ciclistes (dorsal,edat,nom) values(58,34,'Gerd Audehm');
insert into ciclistes (dorsal,edat,nom) values(59,28,'Mariano Picolli');
insert into ciclistes (dorsal,edat,nom) values(60,28,'Giovanni Lombardi');
insert into ciclistes (dorsal,edat,nom) values(61,26,'Walte Castignola');
insert into ciclistes (dorsal,edat,nom) values(62,30,'Raul Alcala');
insert into ciclistes (dorsal,edat,nom) values(63,32,'Alvaro Mejia');
insert into ciclistes (dorsal,edat,nom) values(64,28,'Giuseppe Petito');
insert into ciclistes (dorsal,edat,nom) values(65,29,'Pascal Lino');
insert into ciclistes (dorsal,edat,nom) values(66,24,'Enrico Zaina');
insert into ciclistes (dorsal,edat,nom) values(67,28,'Armand de las Cuevas');
insert into ciclistes (dorsal,edat,nom) values(68,28,'Angel Citracca');
insert into ciclistes (dorsal,edat,nom) values(69,27,'Eddy Seigneur');
insert into ciclistes (dorsal,edat,nom) values(70,29,'Sandro Heulot');
insert into ciclistes (dorsal,edat,nom) values(71,27,'Prudencio Indurain');
insert into ciclistes (dorsal,edat,nom) values(72,28,'Stefano Colage');
insert into ciclistes (dorsal,edat,nom) values(73,35,'Laurent Fignon');
insert into ciclistes (dorsal,edat,nom) values(74,36,'Claudio Chioccioli');
insert into ciclistes (dorsal,edat,nom) values(75,32,'Juan Romero');
insert into ciclistes (dorsal,edat,nom) values(76,34,'Marco Giovannetti');
insert into ciclistes (dorsal,edat,nom) values(77,33,'Javier Mauleon');
insert into ciclistes (dorsal,edat,nom) values(78,35,'Antonio Esparza');
insert into ciclistes (dorsal,edat,nom) values(79,33,'Johan Bruyneel');
insert into ciclistes (dorsal,edat,nom) values(80,37,'Federico Echave');
insert into ciclistes (dorsal,edat,nom) values(81,33,'Piotr Ugrumov');
insert into ciclistes (dorsal,edat,nom) values(82,30,'Edgar Corredor');
insert into ciclistes (dorsal,edat,nom) values(83,32,'Hernan Buenahora');
insert into ciclistes (dorsal,edat,nom) values(84,31,'Jon Unzaga');
insert into ciclistes (dorsal,edat,nom) values(85,30,'Dimitri Abdoujaparov');
insert into ciclistes (dorsal,edat,nom) values(86,32,'Juan Martinez Oliver');
insert into ciclistes (dorsal,edat,nom) values(87,32,'Fernando Mota');
insert into ciclistes (dorsal,edat,nom) values(88,28,'Angel Camarillo');
insert into ciclistes (dorsal,edat,nom) values(89,36,'Stefan Roche');
insert into ciclistes (dorsal,edat,nom) values(90,27,'Ivan Ivanov');
insert into ciclistes (dorsal,edat,nom) values(91,28,'Nestor Mora');
insert into ciclistes (dorsal,edat,nom) values(92,27,'Federico Garcia');
insert into ciclistes (dorsal,edat,nom) values(93,29,'Bo Hamburger');
insert into ciclistes (dorsal,edat,nom) values(94,30,'Marino Alonso');
insert into ciclistes (dorsal,edat,nom) values(95,31,'Manuel Guijarro');
insert into ciclistes (dorsal,edat,nom) values(96,29,'Tom Cordes');
insert into ciclistes (dorsal,edat,nom) values(97,28,'Casimiro Moreda');
insert into ciclistes (dorsal,edat,nom) values(98,25,'Eleuterio Anguita');
insert into ciclistes (dorsal,edat,nom) values(99,29,'Per Pedersen');
insert into ciclistes (dorsal,edat,nom) values(100,30,'William Palacios');


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
