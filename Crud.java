import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {

    // Create (Inserir Dados)
    public static void inserirNome(String nome, int nota) {
        String sql = "INSERT INTO javasql.nomes (nomescol, nota) VALUES (?, ?)";
    
        try (Connection conexao = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, nota);
            preparedStatement.executeUpdate();
            System.out.println("Nome e nota inseridos com sucesso no banco de dados!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    

    // Read (Buscar Dados)
    public static void buscarNomes() {
        String sql = "SELECT * FROM javasql.nomes";

        try (Connection conexao = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nome = resultSet.getString("nomescol");
                String nota = resultSet.getString("nota");
                System.out.println("Nome: " + nome + " Nota: " + nota);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update (Atualizar Dados)
    public static void atualizarNome(String nomeAntigo, String nomeNovo) {
        String sql = "UPDATE javasql.nomes SET nomescol = ? WHERE nomescol = ?";

        try (Connection conexao = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

            preparedStatement.setString(1, nomeNovo);
            preparedStatement.setString(2, nomeAntigo);
            preparedStatement.executeUpdate();

            System.out.println("Nome atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarNota(String nome, int notaNova) {
        String sql = "UPDATE javasql.nomes SET nota = ? WHERE nomescol = ?";
    
        try (Connection conexao = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
    
            preparedStatement.setInt(1, notaNova); // Define o novo valor da nota
            preparedStatement.setString(2, nome); // Define o nome do aluno para encontrar o registro correspondente
            preparedStatement.executeUpdate();
    
            System.out.println("Nota atualizada com sucesso para o aluno: " + nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    // Delete (Excluir Dados)
    public static void excluirNome(String nome) {
        String sql = "DELETE FROM javasql.nomes WHERE nomescol = ?";

        try (Connection conexao = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

            preparedStatement.setString(1, nome);
            preparedStatement.executeUpdate();

            System.out.println("Nome excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
