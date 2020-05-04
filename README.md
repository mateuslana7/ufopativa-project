# UFOP Ativa Application

## 1. O UFOP Ativa

A humanidade foi e continuará sendo movida pelo conhecimento e pelas inovações que são oriundas das pesquisas que são realizadas dia após dia no mundo inteiro. Atualmente, a UFOP conta com mais de mil e seiscentos servidores e, grande parte destes estão envolvidos em diversos projetos e realizam pesquisas e orientações nas mais diversas áreas de estudo presentes na universidade. 

Este projeto de Monografia teve como principal finalidade o desenvolvimento de um sistema que agrupe e organize em um banco de dados as informações, provenientes da Plataforma Lattes e da própria UFOP, que estejam relacionadas aos servidores que atuam na universidade. Além disso, o sistema teve como objetivo ser organizado, com uma interface amigável. 

Pensando no futuro suporte e manutenção que o NTI(Núcleo de Tecnologia da Informação) da UFOP possa dar ao sistema, as tecnologias escolhidas para o desenvolvimento da aplicação foram as utilizadas na maioria dos sistemas desenvolvidos por eles. Portanto utilizou-se as seguintes tecnologias:

- Java Spring Boot (Backend)
- PostgreSQL (Banco de Dados)
- Angular 8 (Frontend) 

Além disso foram utilizadas algumas outras ferramentas na parte do backend, na obtenção dos dados do Lattes e no pré-processamento dos mesmos. São elas:

- Java 8
- Maven
- Hibernate
- PHP
- JAXB


## 2. Configurando

...

## 3. Executanto a Aplicação

Para executar a aplicação primeiramente certifique-se que tem as ferramentas de compilação para Angular e Spring Boot instaladas em sua máquina. Além disso, verifique se tem tambem o Node Package Manager(NPM) e o Maven instalados. Caso não tenha faça as instalações necessárias e prossiga com a execução. 

### 3.1 Backend

**Obs.: O banco de dados da aplicação está hospedado no GCloud e tem permissão de acesso restringida. Como ele lida com alguns dados extremamente importantes e pessoais relacionados aos servidores da instituição de ensino UFOP, não é possível executar o backend sem uma autorização prévia que deve ser solicitada por email (mateus_lana7@hotmail.com). A solicitação será analisada e caso não haja problemas o acesso será concedido.** 

Para executar o backend da aplicação primeiramente dê um build da mesma por meio da sua IDE de preferência ou abra o terminal no diretório do backend e execute `mvn install`. Em seguida, caso esteja em alguma IDE execute por meio dela, caso contrário execute o comando `mvn spring-boot:run` no terminal. Ao executar, caso o IP da sua máquina esteja resgistrado nas permissões de acesso ao banco de dados, o backend vai entrar em execução. 

### 3.2 Frontend

Para executar o frontend da aplicação abra o terminal no diretório do mesmo e instale as dependências executando o comando `npm install`. Em seguida execute com o comando `ng serve` ou `npm start`.

## Outras Informações

No diretório 'doc' temos a apresentação referente a este projeto utilizada no dia da banca. 

