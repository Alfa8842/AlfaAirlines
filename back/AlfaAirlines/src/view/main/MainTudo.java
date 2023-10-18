package view.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.compra.Compra;
import model.compra.CompraDAO;
import model.pacote.Pacote;
import model.pacote.PacotesDAO;
import model.usuario.Usuario;
import model.usuario.UsuariosDAO;

public class MainTudo {

	/*public static void main(String[] args) {
		Usuario usuario = new Usuario(3, "Alfannya","alfannya@gmail.com", "1234567833", "Alfa1234", "849989898s8");
			//System.out.println(usuario.getNome());
			//System.out.println(usuario.getEmail());
			//System.out.println(usuario.getCpf());
			//System.out.println(usuario.getSenha());
			//System.out.println(usuario.getTelefone());
		
		//java.util.Date data = null;
		//UsuariosDAO.criar(usuario);public Pacotes(int id_Pacotes1, String destinos, Double preco, Boolean promocao, Date data, String origem) {
		Date data = new Date(System.currentTimeMillis());
		//Pacotes pacote = new Pacotes(3, "João Pessoa", 1.500, false, data, "Natal");
		//System.out.println(pacote.get);
		//PacotesDAO.criar(pacote);
		//PacotesDAO.deletar(2);
		//PacotesDAO.atualizar(pacote);
		/*for (Usuarios user : UsuariosDAO.getUser()) {

			System.out.println("Usuário: " + user.getNome());
			System.out.println("Seu E-mail: " + user.getEmail());
			System.out.println("Seu Cpf: " + user.getCpf());
			System.out.println("Senha: " + user.getSenha());
			System.out.println("Telefone: " + user.getTelefone());

			System.out.println(".........................");
	}*/
		/*for (Pacotes pac : PacotesDAO.getPacote()) {
			
			System.out.println("Origem: " + pac.getOrigem());
			System.out.println("Destinos: " + pac.getDestinos());
			System.out.println("Preço: " + pac.getPreco());
			System.out.println("Promoção: " + pac.getPromocao());
			System.out.println("Data: " + pac.getData());
			System.out.println(".........................");
	}*/
	//}
	
	public static void main(String[] args) {
		
		int opcao = -1;
		Scanner scan = new Scanner(System.in);
		
		while (opcao != 0) {
			// chamar função escreverMenu
			escreverMenu();
			
			opcao = scan.nextInt();
			
			switch (opcao) {
	        case 1:
	    		menuCadastroDeUsuario();
	            break;
	        case 2:
	    		menuAtualizarUsuario();
	            break;
	        case 3:
	    		menuBuscarUsuario();
	            break;
	        case 4:
	    		menuDeletarUsuario();
	            break;
	        case 5:
	    		menuCadastroPacote();
	            break;
	        case 6:
	        	menuAtualizarPacote();
	            break;
	        case 7:
	        	menuBuscarPacote();
	            break;
	        case 8:
	    		menuDeletarPacote();
	            break;
	        case 9:
	    		menuRealizarCompra();
	            break;
	        case 10:
	    		menuListarcompra();
	            break;
	        case 11:
	    		menuDeletarCompra();
	            break;
	        case 0:
	        	//TODO
	            break;
	        default:
	            System.out.println("Opção inválida");
	            break;
			}//switch
		}//while
	
		System.out.println("Obrigado por usar AlfaAirlines");
	
	}//main

	private static void menuDeletarCompra() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF para escolher qual compra deseja deletar: ");
		String cpf = scan.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		if (usuario == null)
			System.out.println("Usuário não existe.");
		else {
			CompraDAO.listarPorUsuario(usuario);
			System.out.println("Qual o ID da compra deseja deletar?");
			int idCompra = scan.nextInt();
			CompraDAO.excluir(idCompra);
		}
	}

	private static void menuListarcompra() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual usuário gostaria de listar as compras? Digite o CPF");
		String cpf = scan.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		if (usuario == null)
			System.out.println("Usuário não existe.");
		else {
			CompraDAO.listarPorUsuario(usuario);
		}
	}

	private static void menuRealizarCompra() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Menu de compra de pacote");
		System.out.print("Qual usuário está realizando a compra? Digite o CPF: ");
		String cpf = scan.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		
		System.out.print("Digite o id do pacote a ser comprado: ");
		int idPacote = scan.nextInt();
		
		Pacote pacote = PacotesDAO.buscarPacote(idPacote);
		
		if (usuario == null || pacote == null)
			System.out.println("Usuário ou Pacote não encontrado");
		else {
			Compra compra = new Compra(usuario, pacote);
			System.out.println("Compra criada no Java");
			
			CompraDAO.criar(compra);
		}
			
	}

	private static void escreverMenu() {
		System.out.println("Menu");
		System.out.println("1 - Cadastro de Usuário");
		System.out.println("2 - Atualizar Usuário");
		System.out.println("3 - Buscar Usuário");
		System.out.println("4 - Deletar Usuário");
		System.out.println("5 - Cadastro de Pacote");
		System.out.println("6 - Atualizar Pacote");
		System.out.println("7 - Buscar Pacote");
		System.out.println("8 - Deletar Pacote");
		System.out.println("9 - Realizar Compra");
		System.out.println("10 - Listar Compra");
		System.out.println("11 - Deletar Compra");
		System.out.println("0 - Sair");
		System.out.println("Digite qual opção gostaria de realizar:");
	}
	
	private static void menuAtualizarPacote() {
		// menu de atualização de pacote
		Scanner scan = new Scanner(System.in);
		System.out.println("Area de Administrador");
		System.out.println("Atualização de Pacote");
		
		System.out.print("Digite o ID do pacote a ser modificado: ");
		int idPacote = scan.nextInt();
		Pacote pacote = PacotesDAO.buscarPacote(idPacote);
		
		// a atualização do pacote só modificada temporariamente preco e promocao
		
		// obter novo preco e novo promocao
		System.out.print("Digite o novo preço: ");
		double preco = scan.nextDouble();
		
		System.out.println("Digite se esse valor é promocional: 1-Sim, 2-Não");
		int promocaoId = scan.nextInt();
		boolean promocao = false;
		
		// converter o valor 1-Sim e 2-Não para boolean
		
		if (promocaoId == 1)
			promocao = true;
		else if (promocaoId == 2)
			promocao = false;
		else {
			promocao = false;
			System.out.println("Opção inválida, automaticamente definido pacote como não promocional");
		}
		
		pacote.setPromocao(promocao);
		pacote.setPreco(preco);
		
		PacotesDAO.atualizar(pacote);
	}
	
	private static void menuBuscarPacote() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Area de Administrador");
		System.out.print("Digite o Id do Pacote para buscar: ");
		int idPacote = scan.nextInt();
		
		Pacote pacote = PacotesDAO.buscarPacote(idPacote);
		if (pacote == null)
			System.out.println("Pacote não encontrado com esse id: "+ idPacote);
		else
			System.out.println(pacote.toString());
	}
	
	private static void menuDeletarPacote() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Area de Administrador");
		System.out.print("Digite o Id do Pacote para deletar: ");
		int idPacote = scan.nextInt();
		
		Pacote pacote = PacotesDAO.buscarPacote(idPacote);
		if (pacote == null)
			System.out.println("Pacote não encontrado com esse id: "+ idPacote);
		else
			PacotesDAO.deletar(idPacote);
		
	}
		
	private static void menuCadastroPacote() {
		
		// menu de cadastro de pacotes
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Area de Administrador");
		System.out.println("Cadastro de Pacote");
		
		System.out.print("Nome da Destino: ");
		String destino = scan.nextLine();
		
		System.out.print("Nome da Origem: ");
		String origem = scan.nextLine();
		
		System.out.print("Digite o preço (use ponto para cada decimal): ");
		double preco = scan.nextDouble();
		
		System.out.println("Esse pacote está em promoção? 1-Sim, 2-Não");
		int promocaoId = scan.nextInt();
		boolean promocao = false;
		
		// converter 1-Sim e 2-Não para boolean
		
		if (promocaoId == 1)
			promocao = true;
		else if (promocaoId == 2)
			promocao = false;
		else {
			promocao = false;
			System.out.println("Opção inválida, automaticamente definido pacote como não promocional");
		}
		
		// pegar a data no formato dd/mm/aaaa
		
		System.out.println("Qual a data da viagem? (formato dd/mm/aaaa)");
		// pular linha extra pra poder pegar o dataStr corretamente
		scan.nextLine();
		String dataStr = scan.nextLine();
		Date dataSql;
		
		// converter a data que era em String para o formato Date (java.util.Date)
		// para depois converter para o Date (java.jql.Date)
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date dataUtil = formato.parse(dataStr);
			dataSql = new Date(dataUtil.getTime());
		}catch (ParseException e) {
			// no caso de o usuário não digitar uma data no formato dd/mm/aaaa será usada
			// uma data genérica do dia de hoje
			System.out.println("Formato de data inválido. Utilizado data de hoje");
			dataSql = new Date(new java.util.Date().getTime());
		}
		
		// criando pacote com os dados digitados anteriormente
		// (obs. a dataSql precisou ser inicializada no catch com um valor genérico pois na criação do pacote abaixo
		// dataSql poderia ficar com valor vazio caso o usuário digitasse um valor incorreto)
		Pacote pacote = new Pacote(destino, preco, promocao, dataSql, origem);
		System.out.println("Pacote criado no Java");
		
		int idGerado = PacotesDAO.criar(pacote);
		pacote.setId(idGerado);
		
		System.out.println(pacote.toString());
		
	}
	
	public static void menuCadastroDeUsuario() {
		// cadastro de usuario
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de usuário");
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("E-mail: ");
		String email = scanner.nextLine();
		
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = scanner.nextLine();
		
		System.out.print("Senha: ");
		String senha = scanner.nextLine();
		
		Usuario usuario = new Usuario(nome, email, cpf, senha, telefone);
		
		// exibicao do usuario criado no java
		
		System.out.println();
		System.out.println(usuario.toStringSimplificada());
		
		System.out.println("Usuario criado no Java");
		
		// cadastrar usuario no mysql
		
		UsuariosDAO.criar(usuario);
	}

	private static void menuAtualizarUsuario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Qual o CPF deseja atualizar? ");
		String cpf = scanner.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		
		if (usuario != null) {
			System.out.println(usuario.toString());
			
			System.out.println("Atualizar usuário");
			
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			
			System.out.print("E-mail: ");
			String email = scanner.nextLine();
			
			System.out.print("Telefone: ");
			String telefone = scanner.nextLine();
			
			System.out.print("Senha: ");
			String senha = scanner.nextLine();
			
			Usuario novoDadosDeUsuario = new Usuario(nome, email, cpf, senha, telefone);
			
			UsuariosDAO.atualizar(novoDadosDeUsuario);
		}
		else
			
			System.out.println("Usuário não encontrado");
	}

	private static void menuBuscarUsuario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Qual o CPF deseja buscar? ");
		String cpf = scanner.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		if (usuario != null)
			System.out.println(usuario.toString());
		else
			System.out.println("Usuário não encontrado");
	}

	private static void menuDeletarUsuario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Qual o CPF deseja deletar? ");
		String cpf = scanner.nextLine();
		
		Usuario usuario = UsuariosDAO.buscarUsuario(cpf);
		if (usuario == null)
			System.out.println("Usuário não encontrado");
		else
			UsuariosDAO.deletar(cpf);
		
		
	}
	
}
