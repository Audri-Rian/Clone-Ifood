# Simple Clone IFood
Fiz esse projeto para a faculdade usando Java, JavaFX, MySQL com a API fornecida pela "https://viacep.com.br/ws/s";

Primeiro vamos começar com o checklist feito pelo professor para dar notas no trabalho:
Checklist
[x] Listagem vindo do banco de dados ou dos arrays restaurantes
[x] Selecionar um dos restaurantes listados
[x] Listagem dos produtos do restaurante selecionado
[x] Selecionar o produto
[x] Escolher se quero adicionar mais produtos ao pedido
[x] Listagem do meu pedido completo
[x] Cadastrar endereço de entrega
[x] Digitar meu CEP e exibir o endereço na tela
[x] Adicionar o número ao endereço
[X] Listar formas de pagamento
[x] Selecionar forma de pagamento
[x] Finalizar Pedido
[ ] Threads para atualizar status do pedido [produção, saiu para entrega, entregue]
[x] Listar meus pedidos já realizados
13/14

# Instalação

Você clona no repositorio ai do github, utilizei o Scene Builder para abrir e editar o arquivo FXML, e o Intelij usando a versão java 22 SDK.
![image](https://github.com/user-attachments/assets/86a05bcc-fbac-45ff-93bd-b976204ec53b)


# Como funciona cada página do Projeto.

![image](https://github.com/user-attachments/assets/c36b3685-55f7-4ff1-a063-462ba0c11950)

# 1 - Página 1 - Login
Códigos: Login.java , IfoodLogin.fxml, Sample Controller.

A primeira página é destinada a página de Login, onde o Login e a senha é definido diretamente no Banco de Dados com o comando Insert INTO.
Temos o código Login.java que é usado para apenas dar RUN no projeto, com um simples código do FXMLLoader que serve para dar GetResource na pagina FXML em questão.
A página SampleController é a aonde damos toda a funcionalidade aplicavel do código, ou seja, onde todos os IDs, funções, try and catch são atribuidos.
E a página IFoodLogin.fxml é aonde fica os códigos de FrontEND nele são atribuidos se nescessario os IDs e funções que são descritas no Controller da página.

A página de Login temos 3 importantes funções. 
-LoginButtonOnAction é aonde testamos se o botão for clicado é verificado se o TextField usarname e Password estão vazios ou não.
-CancelButton simplismente é pra fechar a página toda.
-ValidadeLogin, aqui é aonde fica a verificação no banco de dados, se caso o Usuario e a senha baterem vai entrar, se não vai dar uma mensagem de erro que editei.(A conexão feita com o banco foi deixado em outra página."DatabaseConnection").

# 2 - Página 2 - Ifood
Códigos: IfoodController.java , Ifood.fxml.

Essa página não possui nada muito diferencial, apenas funciona como um Menu de opções, tem várias opções porém apenas 3 delas estão funcionaveis, o botão de restaurante, o botão de carrinho, e o botão com o nome de um endereço(Rua 17 de agosto).
Essa página possue o mesmo código, apenas para poder abrir outras páginas.
![image](https://github.com/user-attachments/assets/307b59eb-eaf6-402d-a275-2f9e53416ea6)

# 3 - Página 3 - Lista de Restaurantes.
Códigos: RestaurantController.java , Restaurant.fxml.

Essa página tem apenas como função de apresentar a lista de restaurantes descritas no ArrayList e se caso clicar em uma delas, vai ser aberto o restaurante em questão.
![image](https://github.com/user-attachments/assets/c9ac5a65-d3be-40ae-90a1-aba0d5723ab1)

# 4 - Página 4 - TallesTapiocaria.
Códigos: TallesTapiocariaController.java , TallesTapiocaria.fxml.

Aqui é aonde a gambiarra corre solta, nem eu to entendendo meu código direito, mas com umas 2 horinhas de leitura de código você entende bem.(É uma tapiocaria que vende hamburguer, muito doido)
Vou explicar mais detalhado a estrutura desse código, pois além de ser o mais extenso também é o mais complicado.
Primeiro começamos obviamente declarando cada variável de cada coisa que possue sua funcionalidade.
Cada componente definido no código possue um @FXML que vincula ao arquivo TallbesTapiocaria.fxml.
Temos em seguida um Map<Button, product> é usado para relacionar cada butão com um produto específico. Isso facilita a vinculação entre a interface gráfica e os dados subjacentes.
Temos o Método initialize, é executado automaticamente quando o controlador é carregado. Ele configura as colunas da tabela(TableView e TableColumn) para exibir propriedades como nome, quantidade, preço dos produtos. E tambem incializa os produtos disponíveis e seus respectivos botões e spinner, associando-os ao estabelecimento padrão.

Agora vamos falar das funções.

addProduct serve para criar um produto e associar seu botão e spinner, ou seja, baseado no número presente do spinner o botão(addToCart) vai receber a informação e mandar para a tabela(tableView)
addToCart como dito anteriormente adiciona o produto a tabela de exibição lateral com a quantidade selecionada, e também calcula o preço total acumulado e atualiza o rótulo(Label) que exibe o total da tabela.
clearAllProdutcs função criada para estar presente no button de remover, nele remove todos os itens da tabela e reseta o total acumulado.
addToDatabase salva os produtos adicionados ao carrinho em um banco de dados no mysql, chama a função DatabaseConnection, insere os dados na tabela cart_items do banco, utiliza executeBatch para eficiencia ao inserir multiplos registros.
Inicio(ActionEvent) isso aqui é so um button que serve apenas para voltar para o inicio abrindo novamente o arquivo Ifood.fxml e fechando o atual

![image](https://github.com/user-attachments/assets/547a1f2c-b3c3-484a-ad78-e3e58b0cce5d)

# 5 - Página 5 - CEP.
Códigos: Cep.fxml, CepController.java , ViaCepService.java, MySQLHelper.java.

Esses códigos sao partes de um sistema modular que interage com a API ViaCEP para buscar informações de endereços com base no CEP, e com o um banco de dados MySQL para armazenar e recuperar informações(nem parece que foi eu que escrevi isso). Cada classe tem um proposito especifico e se comunica com as outras para completar o fluxo de dados e funcionalidade.

Na interface parece tão simples, mas tem muita coisa por trás.

ViaCEPService esta classe é resposavel por interagir com a API para buscar informações de endereço com base em um CEP fornecido.(Aqui eu fiz no chatGPT mesmo, é isso ai)
MySQLHELPER esta classe gerencia interações com o banco de dados MySQL, especificamente para armazenar e recuperar informações relacionadas a produtos de um carrinho de compras.
CEPController Esta classe é responsavel por intergir com a interface FXML e gerenciar ações relacionadas ao CEP e endereço, como aparecer os dados.

![image](https://github.com/user-attachments/assets/ff249eb0-7374-42e2-b661-fe95af5ea87b)


# 6 - Página 6 - Carrinho
Códigos: Carrinho.fxml , CarrinhoController.

Aqui é onde nos interagirmos com o carrinho de compras, aonde tudo vai parar. Essa classe interage com uma tabela no banco de dados, exibe Informações para o usuário, calcula totais e permite exportar e limpar os dados.

![image](https://github.com/user-attachments/assets/6b7c9458-4ee2-4d96-9a3e-7f473a8e2d07)














