CREATE TABLE categorias (
cat_iden SERIAL PRIMARY KEY,
cat_nome VARCHAR (50)
);
CREATE TABLE planos (
pla_iden SERIAL PRIMARY KEY,
pla_acesso_simultaneo BOOLEAN,
pla_nome VARCHAR (50),
pla_preco NUMERIC (6,2)
);
CREATE TABLE cup_usuarios (
cup_iden SERIAL PRIMARY KEY,
cup_porcentagem NUMERIC (6,2),
cup_data_geracao DATE,
cup_nome VARCHAR (50),
cup_cpf VARCHAR (14),
cup_email VARCHAR (50),
cup_senha VARCHAR (10)
);
CREATE TABLE filmes (
fil_iden SERIAL PRIMARY KEY,
fil_ano NUMERIC (4),
fil_sinopse VARCHAR (250),
fil_titulo VARCHAR (50),
fil_cat_iden INTEGER,
FOREIGN KEY(fil_cat_iden) references categorias(cat_iden)
);
CREATE TABLE visualiza (
vis_iden SERIAL PRIMARY KEY,
vis_data_visualizacao DATE,
vis_completo BOOLEAN,
vis_fil_iden INTEGER,
FOREIGN KEY (vis_fil_iden) references filmes (fil_iden),
vis_cup_iden INTEGER,
FOREIGN KEY (vis_cup_iden) references cup_usuarios (cup_iden)
);
CREATE TABLE contrata (
con_iden SERIAL PRIMARY KEY,
con_status CHAR (1) CONSTRAINT status CHECK(con_status in ('A','I','S')),
con_fim DATE not null,
con_inicio DATE not null,
con_pla_iden INTEGER,
FOREIGN KEY (con_pla_iden) references planos (pla_iden),
con_cup_iden INTEGER,
FOREIGN KEY (con_cup_iden) references cup_usuarios (cup_iden)
);
