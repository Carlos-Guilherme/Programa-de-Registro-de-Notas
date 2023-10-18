import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        String jdbcUrl = ""; // Substitua com o URL do seu banco de dados
        String usuario = ""; // Substitua com seu nome de usuário do banco de dados
        String senha = ""; // Substitua com sua senha do banco de dados
        return DriverManager.getConnection(jdbcUrl, usuario, senha);
    }
}
