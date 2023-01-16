# Projeto StarWars

Neste projeto foi usado o clean architecture, que nada mais é que separar as camadas
por suas responsabilidades, exemplo:
__________
 - Camada DATA:
   - responsável pelo banco de dados, acesso a internet e Banco de dados 
 - Camada DOMAIN:
   - responsável pelas entidades e as regras de domínio específicas do seu projeto. Esse módulo deve ser totalmente independente da plataforma Android.
 - Camada PRESENTATION: 
   - Responsável pela interface do aplicativo e a exibição dos dados recebidos do domínio


## Eis a disposição das pastas:
<img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg6.png"  width="100"/>

Foi usado o retrofit para dados Remotos
Foi usado o room pada banco de dados

Na camada core, temo um .KT de eventos, estes eventos são gerados pela
ação do usuário, neste projeto utilizamos o MARAVILHOSO, jetpack compose
e o padrão MVI (model view intent), onde as intents são as ações/intenções do usuário
que acaba refletindo no STATE [presentation - layer ] e o vewModel atualizando

Em data temos framworks [RETROFIT, ROOM], aceitando o contrato
vindo do meu dominio, já na pasta network seguimos com os DTO, Objeto de Transferência de Dados,
para que através do mapper faça a conversão para nossos models

Em DI, usamos o Hilt, criado com base na conhecida biblioteca de DI Dagger,
e assim injetamos nossos usecase, repositórios.

Fiz o uso do padrão usecase, apesar de ser opcional, na recomendação da arquitetura do google
nossos useCase obedecem o Principio da responsabilidade Única

Em domain temos nossa camada de dominio, contendo models, regras de negocios,
contratos

E ara finalizar temos o Presentation, é onde os olhos do cliente final
brilham, seguimos em Screen -> (STATE) -> ViewModel
Resumindo a tela é burra, o viewModel atualiza o State, baseado em um evento
externo ou interno, atualizando o state e devolvendo para a tela

Melhorias:
  - Implementar as outras seções:
    --   Films | Species | Starships | Vehicles | Planets (basicamente um crtl +c  ctrl + v), do que já temos 
  - Implementar o broadcast da conexão com a iternet, para determinar se pega do cache
  -  Usar um Interceptor para fazer cache ou o room

Falta: Testes 




## Screens:
  <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg1.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg2.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg3.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg4.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg5.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg7.png"  width="300"/>
    <img src="https://raw.githubusercontent.com/paulosoujava/starWars/main/app/src/main/res/drawable/pg8.png"  width="300"/>
                    

## Documentation:
 - https://starwars-visualguide.com/#/
 - https://swapi.dev/documentation#root


## Tags:
 - Jetpack Compose
 - Room
 - Retrofit
 - Flow
 - MVI
 - Clean Architecture
 - DI
 - SOLID




