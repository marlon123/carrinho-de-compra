# Automação Adicionando item ao carrinho de compra

## Ferramentas utilizadas
### IDE: IntelliJ Community
### Gradle
### Selenium + Java utilizando SpringBoot

## Execução do Projeto
### Execução na IDE
Executar a classe CarrinhoDeCompraApplication informando como argumento o navegador

###Execução com Gradle
- ./gradlew run --args='chrome'
- ./gradlew run --args='firefox'

## Drivers
- Chrome: chromedriver - validado chrome na versão 80
- Firefox: geckodriver - não validado

### Execução pelo jar
#####Pré-condição: Java 8 ou superior 
Executar o comando abaixo:
- java -jar redmine-teste-1.0-SNAPSHOT.jar "chrome"
- java -jar redmine-teste-1.0-SNAPSHOT.jar "firefox"