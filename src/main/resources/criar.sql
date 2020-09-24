 create table empresa (id  serial not null, cnpj varchar(255), nome varchar(255), primary key (id))
 create table exame (id  serial not null, observacao varchar(255), risco_ocupacional varchar(255), tipo_exame varchar(255),
  funcionario_id int4, medico_id int4, primary key (id))
 create table funcionario (id  serial not null, matricula int4, nome varchar(255), empresa_id int4, primary key (id))
 create table medico (id  serial not null, crm varchar(255), nome varchar(255), primary key (id))
 alter table exame add constraint FKa3qgkaw9softjq1y2djjod803 foreign key (funcionario_id) references funcionario
 alter table exame add constraint FK4quj24xlxhi57oerid7hlb1xo foreign key (medico_id) references medico
 alter table funcionario add constraint FK4cm1kg523jlopyexjbmi6y54j foreign key (empresa_id) references empresa