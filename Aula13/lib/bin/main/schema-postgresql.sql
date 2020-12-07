CREATE TABLE IF NOT EXISTS produto (
     id serial PRIMARY KEY,
     nome varchar(50),
     preco real
);

CREATE TABLE IF NOT EXISTS cliente (
     id serial PRIMARY KEY,
     nome varchar(50),
     tel varchar(50),
     email varchar(50),
     endereco varchar(50)
);


CREATE TABLE IF NOT EXISTS concessionaria (
     id serial PRIMARY KEY,
     nome varchar(50),
     endereco varchar(50),
     tel varchar(50),
     email varchar(50),
     nome_veiculo varchar(50),
     preco_veiculo real 
     );
