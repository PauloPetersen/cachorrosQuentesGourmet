# cachorrosQuentesGourmet

A aplicação roda utilizando o banco H2. <br />
O link para acessar o banco é: http://localhost:8080/h2/ <br />
O User é: Admin
A senha é: 123

O projeto foi desenvolvido, inicialmente, orientado a objeto, mas o design inicial apresentou alguns problemas e acabei mudando totalmente a ideia inicial. <br />
<br /> Decidi por desenhar o projeto orientado a dados, comecei desenhando como eu imaginava ser a estrutura do DB para em seguida começar a programar, vi que fazia sentido e em seguida comecei a desenvolver. <br />
<br /> No projeto utilizei um foco grande de Orientação a Objetos em uma estrutura de micro-serviços para fácil leitura e manutenção posterior do código. <br />
<br /> Tentei separas a responsabilidade das classes em classes de entidades e classes de negócio. Sendo que as entidades são as tabelas do DB e as classes de negócio englobam o funcionamento do modelo. <br />
<br /> Por falar em DB, ao iniciar o programa, o script que elaborei fará a inserção de dados no DB do H2. <br />
