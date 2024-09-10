# LumaStoreTest
LumaStoreTest é um projeto de automação de testes para a loja online LumaStore. O objetivo principal deste teste é realizar corretamente o fluxo de compra de um produto na aplicação.

## Tecnologias Utilizadas
Linguagem: Java
Frameworks e Ferramentas:
-Selenium WebDriver: Para automação de testes de interface.
-Cucumber: Para testes baseados em comportamento (BDD - Behavior Driven Development).
-JUnit: Para execução e organização dos testes.
Gerenciador de Dependências: Maven
Controle de Versão: Git

## Instalação e Uso
Pré-requisitos
Antes de começar, você precisará ter o JDK (Java Development Kit) e o Maven instalados em seu sistema.
- Instalar JDK:
https://docs.oracle.com/en/java/javase/

-Instalar Maven:
https://maven.apache.org/install.html

## Clonando o Repositório
Clone o repositório do projeto para sua máquina local:
git clone https://github.com/viniciusLemosDeSouza/dmo.git

## Configuração do Projeto
Navegue até o diretório do projeto:
cd dmo

Instale as dependências do projeto usando Maven:
mvn install

## Configuração do Ambiente
Certifique-se de que o .gitignore está corretamente configurado para ignorar arquivos e diretórios indesejados, como arquivos de compilação e configurações específicas do ambiente.

## Executando os Testes
Para executar os testes, use o comando Maven:
mvn test

**Este projeto na sua criação está utilizando o chromedriver na versão 128.0.6613.119, se o seu browser chrome estiver em uma versão superior a este devera ser baixado um novo chromedriver com a versão correta.**
https://googlechromelabs.github.io/chrome-for-testing/
