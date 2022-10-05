/*
 * Projeto: Manipulação de arquivos txt
 * Equipe:
 * 			Marcos Antonio
 * 			Filipe Pessoa Rodriguez		 
 * 			Ana Vitória
 * 1 - Inserir nome no arquivo
 * 2 - Exibir todos os nomes do arquivo
 * 3 - Apagar todo o arquivo
 */

// Bibliotecas do projeto
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File arquivo = new File("lista_de_nomes.txt");
		FileWriter fw = new FileWriter(arquivo, true);
		PrintWriter pw = new PrintWriter(fw);
		Scanner entrada = new Scanner(System.in);
		Scanner meu_leitor = new Scanner(arquivo);
		
		System.out.println("ESCRITA E LEITURA EM ARQUIVO TXT");
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Inserir novo nome.");
		System.out.println("2 - Exibir nomes gravados.");
		System.out.println("3 - Limpar todos os nomes.");
		System.out.println("0 - Sair");
		System.out.print("Opcao:");
		int opcao = entrada.nextInt();
		entrada.nextLine();
		
		if(opcao == 1) {
			System.out.println("Opcao 1 escolhida.");
			System.out.println("Digite o seu nome: ");
			String nome = entrada.nextLine();
			pw.print("\t" + nome + "\n");
		} else if(opcao == 2){
			System.out.println("Opcao 2 escolhida.");
			System.out.println("Nomes:");
			while(meu_leitor.hasNextLine()) {
				String nomes = meu_leitor.nextLine();
				System.out.println(nomes);
			}
		} else if(opcao == 3) {
			if(arquivo.delete()) {
				System.out.println("Arquivo " + arquivo.getName() + " deletado");
			}
		} else {
			System.out.println("Opção Inválida!");
		}
		
		
		pw.close();
		meu_leitor.close();
		entrada.close();
		System.out.println("Programa finalizado, Obrigado!");
	}
}
