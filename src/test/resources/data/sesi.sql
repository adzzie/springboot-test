delete from peserta_pelatihan;
delete from sesi;

insert into sesi (id, id_materi, mulai, sampai)
values ('aa', 'aa6', '2019-01-01', '2019-01-05');

insert into sesi (id, id_materi, mulai, sampai)
values ('ab', 'aa6', '2019-01-08', '2019-01-12');

insert into sesi (id, id_materi, mulai, sampai)
values ('ac', 'aa7', '2019-01-01', '2019-01-05');


insert into peserta_pelatihan (id_sesi, id_peserta)
values ('ac', 'aa7', '2019-01-01', '2019-01-05');

