INSERT INTO PRODUTO (ID, NOME, VALOR, IS_INGREDIENTE, IS_LANCHE, IS_PROMOCAO, IS_CALCULADO)
VALUES
(1, 'Pão', 2.00, true, false, false, false),
(2, 'Batata Palha', 0.40, true, false, false, false),
(3, 'Linguiça', 3.00, true, false, false, false),
(4, 'Salsicha', 2.00, true, false, false, false),
(5, 'Ovo de Codorna', 0.30, true, false, false, false),
(6, 'Purê de Batatas', 1.00, true, false, false, false),
(7, 'Milho', 0.20, true, false, false, false),
(8, 'Cerveja Long Neck', 10.00, false, false, false, false),
(9, 'Refrigerante', 6.00, false, false, false, false),
(10, 'Completo com Linguiça', 6.90, false, true, false, true),
(11, 'Completo com Salsicha', 5.90, false, true, false, true),
(12, 'LowCarb Completo', 6.90, false, true, false, true),
(13, 'Completo com Linguiça + Refri', 9.90, false, false, true, true),
(14, 'Completo com Salsicha + Refri', 8.90, false, false, true, true),
(15, 'Dois Completos', 19.80, false, false, true, true),
(16, 'Completo com Linguiça + LongNeck', 12.90, false, false, true, true),
(17, 'Completo com Salsicha + LongNeck', 11.90, false, false, true, true);

INSERT INTO RECEITA_LANCHE_PADRAO (ID, ID_PRODUTO_MASTER, ID_PRODUTO_INGREDIENTE)
VALUES
(1, 10, 1),
(2, 10, 2),
(3, 10, 4),
(4, 10, 5),
(5, 10, 6),
(6, 10, 7),
(7, 11, 1),
(8, 11, 2),
(9, 11, 3),
(10, 11, 5),
(11, 11, 6),
(12, 11, 7),
(13, 12, 2),
(14, 12, 3),
(15, 12, 4),
(16, 12, 5),
(17, 12, 6),
(18, 12, 7);

INSERT INTO RECEITA_LANCHE_PROMOCAO (ID, ID_PRODUTO_MASTER, ID_ITEM_PROMOCAO, DESCONTO_ITEM_PORCENTAGEM)
VALUES
(1, 13, 10, 0),
(2, 13, 9, 50),
(3, 14, 11, 0),
(4, 14, 9, 50),
(5, 15, 10, 10),
(6, 15, 10, 10),
(7, 16, 10, 0),
(8, 16, 8, 40),
(9, 16, 11, 0),
(10, 16, 8, 40);

INSERT INTO USUARIO_ADMIN (ID_USUARIO_ADMIN, NOME_ADMIN_USUARIO_ADMIN, ROLE_USUARIO_ADMIN) VALUES (1, 'paulo', 'admin');





