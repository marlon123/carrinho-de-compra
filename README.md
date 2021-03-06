# Automação Adicionando item ao carrinho de compra

## Ferramentas utilizadas
### IDE: IntelliJ Community
### Gradle
### Selenium + Java utilizando SpringBoot + Lombok

## Execução do Projeto
### Drivers
- Para baixar os drivers do chrome e firefox, execute o comando abaixo, esse comando cria uma pasta na raiz do projeto e faz download dos drivers:
- ./gradlew downloadDriversTar
- Chrome: chromedriver - validado chrome na versão 80
- Firefox: geckodriver - não validado no firefox

### Execução na IDE
Executar a classe 'CarrinhoDeCompraApplication' informando como argumento o navegador

### Execução com Gradle
- ./gradlew run --args='chrome linux'
- ./gradlew run --args='firefox linux'

- ./gradlew run --args='chrome mac'
- ./gradlew run --args='firefox mac'

- ./gradlew run --args='chrome windows'
- ./gradlew run --args='firefox windows'

### Execução pelo jar
##### Pré-condição: Java 8 ou superior 
Gere o jar do projeto com o comando abaixo, o jar será gerado na pasta build/libs e mova-o para a pasta raiz:
- ./gradlew clean build -x test
Executar o comando abaixo na pasta raiz:
- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "chrome" "linux"
- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "firefox" "linux"

- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "chrome" "mac"
- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "firefox" "mac"

- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "chrome" "windows"
- java -jar carrinho-de-compra-0.0.1-SNAPSHOT.jar "firefox" "windows"
