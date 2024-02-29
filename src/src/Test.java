import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        Database db = new Database("user", "password");
        System.out.println(db.rechercheParNom("ai"));
    }

}
