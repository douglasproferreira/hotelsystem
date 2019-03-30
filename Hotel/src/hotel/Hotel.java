/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @authores Douglas e João
 */
public class Hotel {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Criando o vetor de quartos.
        Quarto[] quartos;
        quartos = new Quarto[20];
        // Instanciando o vetor de quartos.
        for (int i = 0; i < quartos.length; i++) {
            quartos[i] = new Quarto();
        }
        // Váriavel para as opcoes de verificação.
        String continuar, identificacao;
        // Variavel de escolha do menú, do tipo de cliente e 
        // uma que ira axiliar para identificção do quarto.
        int escolha, tipo, quarto;
        // Variavel que irá receber a última posição do ArrayList.
        int ultpos, id = 0;

        // Criação dos ArrayLists
        List<Cliente> Clientes = new ArrayList();
        List<Reserva> Reservas = new ArrayList();

        // Laço que garante o retorno ao menú.
        do {
            System.out.println("==========================");
            System.out.println("=    GESTÃO DE HOTEL     =");
            System.out.println("==========================");
            System.out.println(" ");
            System.out.println("> 1- Cadastrar Cliente");
            System.out.println("> 2- Check-In");
            System.out.println("> 3- Check-Out");
            System.out.println("> 4- Disponibilidade de Quarto");
            System.out.println("> 5- Buscar Cliente");
            System.out.println("> 6- Listar Cliente por Tipo");
            System.out.println("> 7- Sair");
            System.out.println(" ");
            System.out.print("Insira a Opção Desejada: > ");
            escolha = sc.nextInt();

            // Escolha do usuário em switch case.
            switch (escolha) {

                case 1:
                    // Laço de cadastro de clientes.
                    do {
                        System.out.println("==========================");
                        System.out.println("=  CADASTRO DE CLIENTE   =");
                        System.out.println("==========================");
                        System.out.println("Informe o Tipo de Cliente:");
                        System.out.println("> 1- Pessoa Física");
                        System.out.println("> 2- Pessoa Jurídica");
                        tipo = sc.nextInt();
                        // Cadastro de pessoa física
                        if (tipo == 1) {
                            id = id + 1;
                            PessoaFisica cliente = new PessoaFisica();
                            cliente.setId(id);
                            cliente.setTipo("Pessoa Fisica");
                            sc.nextLine();
                            System.out.print("Informe o Nome do Cliente: > ");
                            cliente.setNome(sc.nextLine());
                            System.out.print("Informe o CPF do Cliente: > ");
                            cliente.setCpf(sc.nextLine());
                            System.out.print("Informe o Sexo do Cliente: > ");
                            cliente.setSexo(sc.nextLine());
                            System.out.print("Informe o Endereço do Cliente: > ");
                            cliente.setEndereco(sc.nextLine());
                            System.out.print("Informe a Cidade do Cliente: > ");
                            cliente.setCidade(sc.nextLine());
                            System.out.print("Informe o Estado do Cliente: > ");
                            cliente.setEstado(sc.nextLine());
                            System.out.println("Operação Concluída Com Sucesso!!");
                            Clientes.add(cliente);

                        // Cadastro de pessoa jurídica.
                        } else if (tipo == 2) {
                            id = id + 1;
                            PessoaJuridica cliente = new PessoaJuridica();
                            cliente.setId(id);
                            cliente.setTipo("Pessoa Juridica");
                            sc.nextLine();
                            System.out.print("Informe a Razão Social do Cliente: > ");
                            cliente.setRazaoSocial(sc.nextLine());
                            System.out.print("Informe o CNPJ do Cliente: > ");
                            cliente.setCnpj(sc.nextLine());
                            System.out.print("Informe o Endereço do Cliente: > ");
                            cliente.setEndereco(sc.nextLine());
                            System.out.print("Informe a Cidade do Cliente: > ");
                            cliente.setCidade(sc.nextLine());
                            System.out.print("Informe o Estado do Cliente: > ");
                            cliente.setEstado(sc.nextLine());
                            System.out.println("Operação Concluída Com Sucesso!!");
                            Clientes.add(cliente);
                        } else {
                            System.out.println("Comando Inválido");
                        }
                        System.out.println("Deseja Continuar a Cadastrar Clientes?");
                        System.out.println("> Tecle 'Enter' para Continuar");
                        System.out.println("> Digite 'Voltar' para ir ao Menú Principal");
                        continuar = sc.nextLine();
                    } while (!"voltar".equalsIgnoreCase(continuar));
                    break;

                    case 2:
                    // Case de check-in.
                    System.out.println("==========================");
                    System.out.println("    =    CHECK-IN    =    ");
                    System.out.println("==========================");
                    // Criando uma nova reserva no ArrayList.
                    Reservas.add(new Reserva());
                    // Variavél que pega a ultima posição do ArrayList.
                    ultpos = Reservas.size() - 1;
                    System.out.printf("Informe o Número do Quarto: > ");
                    quarto = sc.nextInt();
                    sc.nextLine();
                    // Verificando se o quarto não se encontra reservado.
                    if ("Reservado".equals(quartos[quarto].getStatus())) {
                        System.out.println("Quarto Reservado");
                        System.out.println("Operação Cancelada pelo Sistema");
                        break;
                    }
                    System.out.printf("Informe a Quantidade de Hospedes: > ");
                    int qthosp = sc.nextInt();
                    // Verificando se a quantidade de hospedes para o quarto é válida.
                    if (quartos[quarto].verificarQtdadeHospedes(quartos[quarto].getQuantidadeHospedes()) != true) {
                        System.out.println("Quantidade de Hospedes Inválida");
                        System.out.println("Operação Cancelada pelo Sistema");
                        break;
                    }
                    quartos[quarto].setQuantidadeHospedes(qthosp);
                    sc.nextLine();
                    System.out.print("Informe o Responsável pelo Quarto: > ");
                    identificacao = sc.nextLine();
                    // Verificando se o cliente da reserva está cadastrado.
                    for (Cliente cliente : Clientes) {
                        if (!cliente.getIdentificacao().equalsIgnoreCase(identificacao)) {
                            System.out.println("Cliente Não Cadastrado!");
                            System.out.println("Operação Cancelada pelo Sistema!");
                            break;
                        } else {
                            Reservas.get(ultpos).setResponsavelQuarto(identificacao);
                        }
                    }
                    System.out.print("Informe a Quantidade de Dias: > ");
                    Reservas.get(ultpos).setQuantidadeDias(sc.nextInt());
                    // Setando as informações do quarto.
                    Reservas.get(ultpos).setQuarto(quartos[quarto]);
                    // Calculando o valor da hospedagem.
                    Reservas.get(ultpos).setValorReserva(Reservas.get(ultpos).calcularValorHosp(Reservas.get(ultpos)
                            .getQuarto().getQuantidadeHospedes(),Reservas.get(ultpos).getQuantidadeDias()));
                    // Reservando o quarto setando o status para "Reservado".
                    quartos[quarto].setStatus("Reservado");
                    System.out.println("Valor da Hospedagem: R$ " + Reservas.get(ultpos).getValorReserva());
                    System.out.println("Quarto n° " + quarto + " " + quartos[quarto].getStatus());
                    System.out.println("Operação Concluída com Sucesso!");
                    sc.nextLine();
                    break;

                case 3:
                    // Case de Check-Out.
                    System.out.println("==========================");
                    System.out.println("    =    CHECK-OUT    =   ");
                    System.out.println("==========================");
                    sc.nextLine();
                    System.out.print("Informe o Responsável pelo Quarto: > ");
                    identificacao = sc.nextLine();
                    
                    for (Reserva reserva : Reservas) {
                        // Verificando se o cliente realmente reservou o quarto.
                        if (reserva.getResponsavelQuarto().equalsIgnoreCase(identificacao)) {
                            System.out.print("Informe o Número do Quarto da Reserva: > ");
                            quarto = sc.nextInt();
                            sc.nextLine();
                            // Liberando o quarto.
                            System.out.println("Quarto n° " + quarto + " " + quartos[quarto].getStatus());
                            System.out.println("Operação Concluída Com Sucesso!");
                            quartos[quarto].setStatus("Disponivel");
                        } else {
                            System.out.println("Cliente Não Hospedado!");
                            System.out.println("Operação Concluída Com Sucesso!");
                        }
                    }
                    break;

                case 4:
                    // Case de disponibilidade de quarto.
                    System.out.println("===========================================");
                    System.out.println("    =    DISPONIBILIDADE DE QUARTO    =   ");
                    System.out.println("===========================================");

                    System.out.print("Informe o Número do Quarto: > ");
                    quarto = sc.nextInt();
                    sc.nextLine();
                    // Verificando se o quarto se encontra reservado.
                    if (quartos[quarto].getStatus().equalsIgnoreCase("Reservado")) {
                        System.out.println("Quarto Reservado!");
                        System.out.println("Operação Concluída Com Sucesso!");
                    } else {
                        System.out.println("Quarto Disponível!");
                        System.out.println("Operação Concluída Com Sucesso!");
                    }
                    break;

                case 5:
                    // Case de busca do cliente.
                    System.out.println("================================");
                    System.out.println("     =    BUSCAR CLIENTE    =   ");
                    System.out.println("================================");
                    sc.nextLine();
                    System.out.print("Informe o Nome ou Razão Social do Cliente: > ");
                    identificacao = sc.nextLine();
                    
                    // Varrendo o ArrayList e verificando se o cliente informado se encontra cadastrado.
                    for (Cliente cliente : Clientes) {
                        if (cliente.getIdentificacao().equalsIgnoreCase(identificacao)) {
                            System.out.println("Cliente Cadastrado!");
                        } else {
                            System.out.println("Cliente Não Cadastrado!");
                        }
                    }
                    System.out.println("Operação Concluída Com Sucesso!");
                    break;
                case 6:
                    // Case de listagem de clientes por tipo.
                    
                    // Declaração de variável auxiliar.
                    int aux = 0;
                    sc.nextLine();
                    System.out.print("Informe o Tipo de Cliente: > ");
                    String tipoCliente = sc.nextLine();
                    
                    // Verificando se há clientes do tipo cadastrado.
                    for (Cliente cliente : Clientes) {
                        if (cliente.getTipo().equals(tipoCliente)) {
                            aux = aux + 1;
                        }
                    }
                    
                    // Listando clientes pelo tipo de acordo com o retorno da variável auxiliar.
                    if (aux != 0) {
                        for (Cliente cliente : Clientes) {
                            if (cliente.getTipo().equalsIgnoreCase(tipoCliente)) {
                                System.out.println(cliente.getCliente());
                            }
                        }
                    } else {
                        System.out.println("Não Há Clientes do Tipo Cadastrados");
                    }
                    System.out.println("Operação Concluída Com Sucesso!");
                    break;
            }

        } while (escolha != 7);
    }
}
