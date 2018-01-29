create database if not exists locadora;
-- sobe a aplicação e depois insere
use locadora;
insert into usuario (id,nome,login,email,ativo,senha) values (1,'Carlos Barbosa', 'cbgomes', 'cbgomes@gmail.com',false,'$2a$10$VDGLYxdBu0av0eYYwh/X.etCYErb0dDV6hoRDyOMlRPFg6hn5B7Cy'); 
insert into usuario (id,nome,login,email,ativo,senha) values (2,'Xico Pereira','xicop','xico@gmail.com',false,'$2a$10$X0Q69sPcGDQE1QF25VBdHeifxp/oW26sFeLShrhQ9WFjeJTcn.JlW');
insert into usuario (id,nome,login,email,ativo,senha) values (3,'Zão Pereira','zepa','zepa@gmail.com',false,'$2a$10$X0Q69sPcGDQE1QF25VBdHeifxp/oW26sFeLShrhQ9WFjeJTcn.JlW$2a$10$X0Q69sPcGDQE1QF25VBdHeifxp/oW26sFeLShrhQ9WFjeJTcn.JlW');
insert into usuario (id,nome,login,email,ativo,senha) values (4,'Jão Pereira','jaop','jaop@gmail.com',false,'$2a$10$X0Q69sPcGDQE1QF25VBdHeifxp/oW26sFeLShrhQ9WFjeJTcn.JlW');
insert into usuario (id,nome,login,email,ativo,senha) values (5,'Tião Pereira','tiaop','tiaop@gmail.com',false,'$2a$10$X0Q69sPcGDQE1QF25VBdHeifxp/oW26sFeLShrhQ9WFjeJTcn.JlW');

insert into cliente (id,nome,email,telefone,cpf) values (1,'Natan Cardoso','natan@gmail.com',88669977,12345678910);
insert into cliente (id,nome,email,telefone,cpf) values (2,'Zé da Silva','zesilva@gmail.com',99117755,09876543210);
insert into cliente (id,nome,email,telefone,cpf) values (3,'Sicrano Ramos','sicrano@gmail.com',55883377,78596248963);

insert into permissao (id, nome) values (1, 'USUARIO');
insert into permissao (id, nome) values (2, 'VISUALIZAR_RELATORIO_CUSTOS');
insert into permissao (id, nome) values (3, 'VISUALIZAR_RELATORIO_EQUIPE');
insert into permissao (id, nome) values (4, 'ADMIN');
insert into permissao (id, nome) values (5, 'MASTER');
insert into permissao (id, nome) values (6, 'VISITANTE');

insert into grupo (id,descricao,nome) values (1,'Grupo de analistas','ANALISTA');
insert into grupo (id,descricao,nome) values (2,'Grupo de Gerentes', 'GERENTES');
insert into grupo (id,descricao,nome) values (3,'Grupo de Diretores', 'DIRETORES');
insert into grupo (id,descricao,nome) values (4,'Grupo de Estagirios', 'ESTAGIARIOS');
insert into grupo (id,descricao,nome) values (5,'Grupo de Visitantes', 'VISITANTES');

insert into usuario_grupos (usuarios_id, grupos_id) values (1, 1);
insert into usuario_grupos (usuarios_id, grupos_id) values (1, 2);
insert into usuario_grupos (usuarios_id, grupos_id) values (1, 3);
insert into usuario_grupos (usuarios_id, grupos_id) values (1, 4);
insert into usuario_grupos (usuarios_id, grupos_id) values (1, 5);
insert into usuario_grupos (usuarios_id, grupos_id) values (2, 1);
insert into usuario_grupos (usuarios_id, grupos_id) values (2, 2);
insert into usuario_grupos (usuarios_id, grupos_id) values (2, 3);
insert into usuario_grupos (usuarios_id, grupos_id) values (2, 4);
insert into usuario_grupos (usuarios_id, grupos_id) values (3, 1);
insert into usuario_grupos (usuarios_id, grupos_id) values (3, 2);
insert into usuario_grupos (usuarios_id, grupos_id) values (4, 3);
insert into usuario_grupos (usuarios_id, grupos_id) values (5, 4);

insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 3);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 4);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 5);
insert into grupo_permissoes (grupos_id, permissoes_id) values (1, 6);
insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 5);
insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 3);
insert into grupo_permissoes (grupos_id, permissoes_id) values (2, 6);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 4);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 5);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 6);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (3, 3);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 1);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 2);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 3);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 4);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 5);
insert into grupo_permissoes (grupos_id, permissoes_id) values (4, 6);
insert into grupo_permissoes (grupos_id, permissoes_id) values (5, 6);
