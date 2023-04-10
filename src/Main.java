import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        String sql="delete from city where id = ?";
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        ResultSet resultSet;

        try {
            connection= dbHelper.getConnection();
            statement=connection.prepareStatement(
                    sql);
            statement.setInt(1,4081);
            int result= statement.executeUpdate();
            System.out.println("Kayıt silindi : ");
        }
        catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
    public static void selectDemo() throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet;

        try {
            connection= dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select Code,Name" +
                    " from country");
            ArrayList<Country> arrayList=new ArrayList<>();
            while (resultSet.next()){
                arrayList.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name")));
            }

            System.out.println(arrayList.size());
        }
        catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
    public static void insertData() throws SQLException{
        Connection connection=null;
        String sql="insert into city (Name,CountryCode,District,Info)" +
                " values(?,?,?,?)";
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        ResultSet resultSet;

        try {
            connection= dbHelper.getConnection();
            statement=connection.prepareStatement(
                    sql);
            statement.setString(1,"Düzce 2");
            statement.setString(2,"TUR");
            statement.setString(3,"TURKEY");
            statement.setString(4,"50000");
            int result= statement.executeUpdate();
            System.out.println("Kayıt eklendi : "+result);
        }
        catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
    public static void updateData() throws SQLException{
        Connection connection=null;
        String sql="update city set Name='Malatya' where id = ?";
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        ResultSet resultSet;

        try {
            connection= dbHelper.getConnection();
            statement=connection.prepareStatement(
                    sql);
            statement.setInt(1,4081);
            int result= statement.executeUpdate();
            System.out.println("Kayıt güncellendi : ");
        }
        catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}