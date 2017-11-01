package sistemas;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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
    public static void eliminarUsuario(String name){
           String sql = "delete from usuarios where nombre = '" + name + "'";
           try {
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void insertar(String nombre, String material, String fecha) throws SQLException {

        String consulta = "insert into reporteprestamo values('" + nombre + "','" + material + "','" + fecha + "')";
        try {
            PreparedStatement us = con.prepareStatement(consulta);
            us.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static void nuevoNombre(String nom) throws SQLException {

        String sqlInsert = "insert into usuarios values('" + nom + "')";
        try {
            PreparedStatement st = con.prepareStatement(sqlInsert);
            st.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void nuevoMaterial(String mat) {

        String sqlIn = "insert into material values('" + mat + "')";
        try {
            PreparedStatement st = con.prepareStatement(sqlIn);
            st.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static void setFilas(DefaultTableModel mod) {

        String sql = "select nombre,material,fecha from reporteprestamo";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            resultado = st.executeQuery();

            Object datos[] = new Object[3];

            while (resultado.next()) {
                for (int i = 0; i < 3; i++) {
                    datos[i] = resultado.getObject(i + 1);
                }
                mod.addRow(datos);
            }
            resultado.close();
        } catch (Exception e) {

        }
    }
}
