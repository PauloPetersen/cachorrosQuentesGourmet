# cachorrosQuentesGourmet

A aplicação roda utilizando o banco H2. <br />
Após o projeto rodar, o link para acessar o banco é: http://localhost:8080/h2/ <br />
</p>O User é: Admin </p>
A senha é: 123 </p>
Driver Class é: org.h2.Driver </p>
JDBC URL é: jdbc:h2:mem:banco

O projeto foi desenvolvido, inicialmente, orientado a objeto, mas o design inicial apresentou alguns problemas e acabei mudando totalmente a ideia inicial. <br />
<br /> Decidi por desenhar o projeto orientado a dados, comecei desenhando como eu imaginava ser a estrutura do DB para em seguida começar a programar, vi que fazia sentido e em seguida comecei a desenvolver. <br />
<br /> No projeto utilizei um foco grande de Orientação a Objetos em uma estrutura de micro-serviços para fácil leitura e manutenção posterior do código. <br />
<br /> Tentei separas a responsabilidade das classes em classes de entidades e classes de negócio. Sendo que as entidades são as tabelas do DB e as classes de negócio englobam o funcionamento do modelo. <br />
<br /> Por falar em DB, ao iniciar o programa, o script que elaborei fará a inserção de dados no DB do H2. <br />
