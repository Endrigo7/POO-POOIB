# POO-POOIB

## Sobre
* Projeto academico para servir de exemplo aos alunos da disciplina de programção orientada a objetos
* O POO-POOIB *(POO Internet Bank)* é um projeto para que os alunos possam aplicar conceitos de orientação a objetos como herança, polimofirmos, entre outros.


## Arquitetura
* O POO-POOIB utiliza uma arquitetura em camadas intermediária. Sendo as camadas devididas em:

| Camada      | Função                                                    |
|-------------|-----------------------------------------------------------|
| interface   | Camada responsável por ser a interface com o usuário      |
| controller  | Camada responsável pelas regras de negcio                 |
| repositorio | Camada responsável por persistencia dos dos dados         |
| entidades   | Camada responsável por abstrarir os objetos do mundo real |

```mermaid
flowchart TD
    A[Gui] -->|Solicita aplicação das regras de negocio| B[Controler]
    B --> |Solicita gravação/consulta| D[Respositorio]
``` 

### Entidades
* Suas classes models são Cliente, ContaCorrente, Poupanca

| Classe        | Função                                                    |
|---------------|-----------------------------------------------------------|
| ContaCorrente | Camada responsável por ser a interface com o usuário      |
| Poupanca      | Camada responsável pelas regras de negcio                 |
| Cliente       | Camada responsável por persistencia dos dos dados         |

```mermaid
classDiagram
    ContaCorrente <|-- Poupanca
    ContaCorrente --> Cliente
    ContaCorrente : -String numero
    ContaCorrente : -double saldo
    ContaCorrente: +gerarNumero()
    ContaCorrente: +creditar(valor)
    ContaCorrente: +debitar(valor)
    ContaCorrente: +transferir(valor, contaDestino)
    class Poupanca{
      -double TAXA_DE_JURORS
      +rendeJuros()
    }
    class Cliente{
      +String nome
      +String cpf
    }
```
