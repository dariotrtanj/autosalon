drop database if exists autosalon;
create database autosalon default character set utf8;
use autosalon;

create table kupac(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    oib char(11),
    email varchar(50) not null,
    telefon varchar(20)not null,
    brojugovora varchar(50) not null,
    prodavac int not null,
    datumprodaje datetime
);

create table vozilo(
    sifra int not null primary key auto_increment,
    marka varchar(50) not null,
    model varchar(50) not null,
    godiste int,
    kilometraza int,
    cijena decimal(18,2) not null,
    kupac int not null,
    uvoz boolean default true
);

create table prodavac(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    oib char(11),
    email varchar(50) not null,
    iban varchar(50)
);

create table prodaja(
    sifra int not null primary key auto_increment,
    kupac int not null,
    prodavac int not null,
    vozilo int not null
);


alter table kupac add foreign key (prodavac) references prodavac(sifra);
alter table vozilo add foreign key (kupac) references kupac(sifra);
alter table prodaja add foreign key (kupac) references kupac(sifra);
alter table prodaja add foreign key (prodavac) references prodavac(sifra);
alter table prodaja add foreign key (vozilo) references vozilo(sifra);