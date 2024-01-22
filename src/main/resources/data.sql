--CREATE TABLE ingrediente (
--   id_ingrediente BIGINT AUTO_INCREMENT PRIMARY KEY,
--   nome_ingrediente VARCHAR(50) NOT NULL,
--   valor_ingrediente DECIMAL(4,2) NOT NULL
--);
--
--CREATE TABLE pedido
--(
--    id_pedido BIGINT AUTO_INCREMENT PRIMARY KEY,
--    preco_total_pedido DECIMAL(4, 2) NOT NULL
--);
--
--CREATE TABLE pedido_ingrediente
--(
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    id_pedido BIGINT,
--    id_ingrediente BIGINT,
--    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
--    FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id_ingrediente)
--);
--
--CREATE TABLE lanche (
--   id_lanche BIGINT AUTO_INCREMENT PRIMARY KEY,
--   nome_lanche_lanche VARCHAR(255) NOT NULL,
--   customizado_lanche BOOLEAN NOT NULL
--);
--
--CREATE TABLE usuario_admin
--(
--    id_usuario_admin BIGINT AUTO_INCREMENT PRIMARY KEY,
--    nome_admin_usuario_admin VARCHAR(255) NOT NULL,
--    role_usuario_admin VARCHAR(255) NOT NULL
--);
--
--CREATE TABLE promocao
--(
--    id_promocao BIGINT AUTO_INCREMENT PRIMARY KEY,
--    nome_promocao_promocao VARCHAR(255) NOT NULL,
--    regra_de_negocio_promocao VARCHAR(255) NOT NULL,
--    lanche_id BIGINT,
--    FOREIGN KEY (lanche_id) REFERENCES lanche(id_lanche)
--);

--INSERT INTO LANCHE (ID_LANCHE, NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES (1, 'completo com linguiça', FALSE);
--SET @idLanche = LAST_INSERT_ID();
--INSERT INTO lanche_ingrediente (lanche_id_lanche, ingrediente_id_ingrediente) VALUES
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'pão')),
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'batata palha')),
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'linguiça')),
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'ovo de codorna')),
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'pure de batatas')),
--(@idLanche, (SELECT id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'milho'));
--INSERT INTO LANCHE (ID_LANCHE, NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com salsicha', FALSE);
--INSERT INTO LANCHE (ID_LANCHE, NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('low carb completo', FALSE);
-- Inserir lanche
--

---- Inserir lanche
--INSERT INTO LANCHE (LANCHE_NOME_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com linguiça', FALSE);
---- Obter o ID do lanche recém-inserido
--SET @idLanche = LAST_INSERT_ID();
--
---- Inserir ingredientes
--INSERT INTO lanche_ingrediente (lanche_id_lanche, ingrediente_id_ingrediente)
--SELECT @idLanche, id_ingrediente FROM ingrediente
--WHERE nome_ingrediente IN ('pão', 'batata palha', 'linguiça', 'ovo de codorna', 'pure de batatas', 'milho');
--
---- Inserir outros lanches
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com salsicha', FALSE);
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('low carb completo', FALSE);

-- Inserir lanche
--

---- Inserir lanche
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com linguiça', FALSE);
--
---- Obter o ID do último lanche inserido
--DECLARE @idLanche INT;
--SET @idLanche = SCOPE_IDENTITY();
--
---- Inserir ingredientes
--INSERT INTO lanche_ingrediente (lanche_id_lanche, ingrediente_id_ingrediente)
--SELECT @idLanche, id_ingrediente FROM ingrediente
--WHERE nome_ingrediente IN ('pão', 'batata palha', 'linguiça', 'ovo de codorna', 'pure de batatas', 'milho');
--
---- Inserir outros lanches
--INSERT INTO LANCHE (LANCHE_NOME_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com salsicha', FALSE);
--INSERT INTO LANCHE (LANCHE_NOME_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('low carb completo', FALSE);

-- Inserir lanche
--INSERT INTO LANCHE (ID_LANCHE_LANCHE, NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES (1, 'completo com linguiça', FALSE);
--
---- Obter o ID do último lanche inserido
--DECLARE @idLanche INT;
--SET @idLanche = SCOPE_IDENTITY();
--
---- Inserir ingredientes manualmente
--INSERT INTO lanche_ingrediente (lanche_id_lanche, ingrediente_id_ingrediente)
--SELECT @idLanche, id_ingrediente FROM ingrediente WHERE nome_ingrediente = 'pão' OR nome_ingrediente = 'batata palha' OR nome_ingrediente = 'linguiça' OR nome_ingrediente = 'ovo de codorna' OR nome_ingrediente = 'pure de batatas' OR nome_ingrediente = 'milho';
--
---- Inserir outros lanches
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com salsicha', FALSE);
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('low carb completo', FALSE);

-- Inserir lanche
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com linguiça', FALSE);
---- Obter o ID do lanche recém-inserido
--SET @idLanche = LAST_INSERT_ID();
--
---- Inserir ingredientes
--INSERT INTO lanche_ingrediente (lanche_id_lanche, ingrediente_id_ingrediente)
--SELECT @idLanche, id_ingrediente FROM ingrediente
--WHERE nome_ingrediente IN ('pão', 'batata palha', 'linguiça', 'ovo de codorna', 'pure de batatas', 'milho');
--
---- Inserir outros lanches
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('completo com salsicha', FALSE);
--INSERT INTO LANCHE (NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES ('low carb completo', FALSE);


INSERT INTO INGREDIENTE (ID_INGREDIENTE,NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES (1, 'milho', 0.20);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('batata palha', 0.40);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('pão', 2.00);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('linguiça', 3.00);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('salsicha', 2.00);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('ovo de codorna', 0.30);
INSERT INTO INGREDIENTE (NOME_INGREDIENTE, VALOR_INGREDIENTE) VALUES ('purê de batatas', 1.00);
INSERT INTO LANCHE (ID_LANCHE, NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES (1, 'completo com linguiça', FALSE);
INSERT INTO LANCHE (ID_LANCHE,NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES (2, 'completo com salsicha', FALSE);
INSERT INTO LANCHE (ID_LANCHE,NOME_LANCHE_LANCHE, CUSTOMIZADO_LANCHE) VALUES (3, 'low carb completo', FALSE);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 1);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 2);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 3);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 4);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 6);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (1, 7);

INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 1);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 2);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 3);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 5);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 6);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (2, 7);

INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 1);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 2);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 4);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 5);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 6);
INSERT INTO LANCHE_INGREDIENTE (LANCHE_ID_LANCHE, INGREDIENTES_ID_INGREDIENTE) VALUES (3, 7);

INSERT INTO USUARIO_ADMIN (ID_USUARIO_ADMIN, NOME_ADMIN_USUARIO_ADMIN, ROLE_USUARIO_ADMIN) VALUES (1, 'paulo', 'admin');





