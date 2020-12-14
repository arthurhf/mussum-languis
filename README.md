# mussum-languis

<img src="mussum.jpg" alt="Mussum" width="200"/>

A linguagem de programação preferida de todo trapalhão.  
O resultado é um arquivo Java.

## Fluxo do programa
prog → programis  
fimprog → cacildis  

## Estrutura de decisão
se → se  
senão → senãozis  

## Entrada/saída
escreva → escrevis  
leia → inputis  

## Variáveis

int → inteiris  
double → quebradis  
string → textis/stringuis  
boolean → booleanis  

## Estrutura de repetição
for → paris  
while-> enquantis  
do/while → facis{...} enquantis (...) 

## Comentários
Os comentários começam com ```#```.
  
## Começandis
Abaixo temos um exemplo correto de como declarar três variáveis inteiras, atribuir valores à elas, somar e exibir o valor.
```
#Esse é um comentário
programis  
    inteiris a, b, c;
    a = 1;
    b = 2;
    c = a+b;
    escrevis(c)	
cacildis;
```
O bloco de declaração de variáveis pode ser feito antes ou depois do bloco com os comandos de Entrada/Saída, Estruturas de Repetição ou atribuição de variável. 
```
programis  
    inteiris a, b;
    a = 1;
    b = 2;
    inteiris c;
    c = a+b;
    escrevis(c)	
cacildis;
```
É possível declarar uma variável já atribuindo valor à ela:  
```
programis  
    inteiris a = 1, b;
    b = 2;
    inteiris c;
    c = a+b;
    escrevis(c)	
cacildis;
```
Para **Estruturas de Decisão**, fazemos o seguinte:

```
programis  
    inteiris a = 1, b = 2;
    se (a < b) {
        escrevis(a);
    }
    senãozis {
        escrevis(b);
    }
cacildis;
```
Para **Estruturas de Repetição**, temos:  
### Laço 'Paris'
```
programis  
    inteiris a, c;
    a = 1;
    paris(c=0;c<3;c++){
        escrevis(a);
    }
cacildis;
``` 
### Laço 'Enquantis'
```
programis  
    inteiris a, b;
    a = 1;
    b = 2;
    enquantis (a < b) {
        escrevis(b);
    }
cacildis;
```
### Laço 'Facis...Enquantis'
```
programis  
    inteiris a, b;
    a = 1;
    b = 2;
    facis{
        escrevis(a);
    }enquantis(b==2)
cacildis;
```
Tentar fazer, por exemplo, ```paris(inteiris c=0;c<3;c++)``` ou  
```
paris(c=0;c<3;c++){
    inteiris(h);
    escrevis(a);
}
```
gera erro de compilação. Não é possível declarar uma variável dentro do laço.

## Autores
* [Arthur Henrique Fernandes](https://github.com/arthurhf/)
* [Igor Neres](https://github.com/igornerest)