# CopiaTurbinada
Este projeto refere-se ao quarto exercício de MAC0321-2020, no qual era necessário criar um software que copiasse arquivos. Conforme demandado no enuncido do trabalho, foi uitlizado o padrão *Strategy* e o padrão *Decorator*.

## Breve comentário sobre o software
Ao iniciar o programa, a classe **ArgumentsHandler** será responsável por definir os tipos de input/output baseado nos argumentos entrados pelo utilizador do programa. Feito tal definição, a classe **InputHandler** gerará uma string que conterá o conteúdo do que foi lido não importando o tipo de entrada e essa string será usada na classe **OutputHandler**, que a utilizará para criar algum output, seja na tela ou em algum arquivo.  
É importante ressaltar que o padrão *Strategy* aparece tanto no **InputHandler** quanto no **OutputHandler** para definir quais inputs e outputs serão gerados. Dessa forma, por exemplo, somente fazendo um ```InputHandler.getInput().input()```, conseguimos a String de input supracitada. Já o padrão *Decorator* é usado para lidar com criptografia e/ou compressão tanto no input quanto no output de um arquivo. Assim, por exemplo, para ler um input criptografado, o ```InputHandler.getInput()``` retornará um objeto do tipo ```EncryptedInputDecorator(new FileInput())``` de modo que a criptografia será gerenciada antes da leitura usual de um arquivo, evitando código repetido.

## Código inspirado no trabalho de outros
Existem duas partes do código que foram inspiradas no trabalho alheio. A primeira é a classe "CryptoUtils", cujo código foi adaptado de um exemplo do site www.codejava.net. Ele torna muito mais fácil a criptografia de arquivos e após testes que garantiram sua adaptação ao software por mim criado, ele foi utilizado.  
A segunda inspiração encontra-se na parte de compressão e descompressão de arquivos. O código foi baseado em exemplos encontrados na página baeldung.com/java-compress-and-uncompress, que foram adaptados para este trabalho.  
É importante dar créditos a essas pessoas por facilitarem o aprendizado de diversos programadores do mundo e por tornarem simples a implementação desses recursos.

## Limitações
* Arquivos comprimidos somente podem ser de extensão .zip
* Arquivos criptografados somente podem ser de extensão .cript
* Arquivos comprimidos e criptografados somente podem ser de extensão .zip.cript

## Argumentos recomendados
Abaixo, haverá uma lista de argumentos recomendados **para serem usados no eclipse** de modo a testar o funcionamento do software considerando que há um arquivo chamado ```poema.txt``` na pasta do programa
* ```-origem -arquivo poema.txt -destino -tela```
* ```-origem -arquivo poema.txt -destino -arquivo poema1.c```
* ```-origem -arquivo poema.txt -destino -arquivo -comprimido poema2.zip```
* ```-origem -arquivo poema.txt -destino -arquivo -criptografado -senha mac0321 poema3.cript```
* ```-origem -arquivo poema.txt -destino -arquivo -comprimido -criptografado -senha mac0321 poema4.zip.cript```
* ```-origem -arquivo poema1.c -destilo -tela```
* ```-origem -arquivo -comprimido poema2.zip -destino -tela```
* ```-origem -arquivo -criptografado -senha mac0321 poema3.cript -destino -tela```
* ```-origem -arquivo -comprimido -criptografado -senha mac0321 poema4.zip.cript -destino -tela```

O primeiro item da lista exibirá o poema na tela. Os próximos quatro criarão diferentes tipos de arquivo com o mesmo poema gravado nele e os últimos quatro lerão esses arquivos criados e exibirão o mesmo poema na tela

## Entrada pelo teclado
A entrada pelo tecledo ocorre até que o usuário inicie uma nova linha e escreva ```_@end_``` nela. Então, caso queiramos escrever:
```
Hello!
My name is Caio!
```
Devemos, no input, escrever:
```
Hello!
My name is Caio!
_@end_
```
e dar um enter no final. A linha nova com o ```_@end_``` será ignorada ao gerar a entrada.

## Problemas conhecidos
* Criar um arquivo .zip.cript de mesmo nome de um arquivo .zip já existente na pasta acabará deletando o arquivo .zip