package sistemas;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author herned1
 */
public class Conexion {

    static Connection con = null;
    static Statement sentencia;
    static ResultSet resultado;

    public static void conexion() {
        String ruta = "jdbc:mysql://localhost/db_prestamo";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(ruta, user, pass);
            sentencia = con.createStatement();
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Fallo en la conexion");
        }
    }

    public void cerrarConexion(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
        }
    }

    public static ArrayList<String> llenar_comboNombre() {

        ArrayList<String> lista = new ArrayList<String>();
        String query = "select * from usuarios order by nombre";
        try {
            resultado = sentencia.executeQuery(query);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("Fallo");
        }
        try {
            while (resultado.next()) {
                lista.add(resultado.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public static ArrayList<String> llenarComboMaterial() {

        ArrayList<String> listaAp = new ArrayList<String>();
        String consulta = "Select * from material order by nombreMaterial";
        try {
            resultado = sentencia.executeQuery(consulta);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("Fallo");
        }
        try {
            while (resultado.next()) {
                listaAp.add(resultado.getString("nombreMaterial"));
            }
        } catch (Exception e) {
        }
        return listaAp;
    }

}
