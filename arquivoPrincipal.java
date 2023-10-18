import java.util.Scanner;

public class arquivoPrincipal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Criando um objeto Produtos com dados para inserir no banco de dados
        System.out.println("Registro de notas");
        System.out.println("1 - Ver alunos e suas respectivas notas");
        System.out.println("2 - Adicionar aluno");
        System.out.println("3 - Editar nome do aluno");
        System.out.println("4 - Editar nota do aluno");
        System.out.println("5 - Deletar aluno");
        System.out.print("Digite aqui: ");
        String resposta = scanner.nextLine();
        if (resposta.equals("1")) {
            // Read
            Crud.buscarNomes();
        }
        else if (resposta.equals("2")) {
            // Insert
            System.out.print("Digite aqui o nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite aqui a nota do aluno: ");
            int nota = scanner.nextInt();
            Crud.inserirNome(nome, nota);
        }
        else if (resposta.equals("3")) {
            // Editar nome
            System.out.print("Digite aqui o nome atual do aluno: ");
            String nome_atual = scanner.nextLine();
            System.out.print("Digite aqui o nome novo do aluno: ");
            String nome_novo = scanner.nextLine();
            Crud.atualizarNome(nome_atual, nome_novo);
        }
        else if (resposta.equals("4")) {
            // Editar nota
            System.out.print("Digite aqui o nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite aqui a nova nota do aluno: ");
            int nota_nova = scanner.nextInt();
            Crud.atualizarNota(nome, nota_nova);
        }
        else if (resposta.equals("5")){
            // Deletar aluno pelo nome
            System.out.print("Digite aqui o nome do aluno: ");
            String nome = scanner.nextLine();
            Crud.excluirNome(nome);
        }
        else{
            System.out.println("Comando não reconhecido");
        }
        scanner.close();
    }
}
