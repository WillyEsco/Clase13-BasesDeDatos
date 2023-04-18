package com.clase13;

import java.sql.*;

import static com.clase13.ConectorSQL.DB_URL;
import static com.clase13.ConectorSQL.USER;
import static com.clase13.ConectorSQL.PASS;
/**
 * Ejemplode conexion de Java con MySQL
 *
 */
public class App{
public static void main(String[] args) {
    Connection conexion = null;
    Statement consulta = null;

    try {
        System.out.print("\033[H\033[2J"); // borro consola 
        // Abrir la conexión
        System.out.println();
        System.out.println("conectando a la base de datos...");
        conexion = DriverManager.getConnection(DB_URL, USER, PASS);

        // Ejecutar una consulta
        System.out.println();
        System.out.println("Creating statement...");
        System.out.println();
        consulta = conexion.createStatement();

      //*********** punto 4 ************** */
      // insertar un empleado nuevo en la nomina
            String sql;
            try{

                sql = "INSERT INTO qatar2023.empleados(apellido,nombre,nacionalidad,departamentoID) VALUES ('Perez','Juan','colombiano',1);";
                consulta.executeUpdate(sql);
                System.out.println("--Empleado insertado correctamente--");

                }catch (SQLException se) {
                    System.out.println();
                    System.out.println("¡Error al insertar el empleado!");
                    System.out.println();
                }
                try {
                    sql = "INSERT INTO QATAR2023.departamento(departamentoID,departamento_nombre,presupuesto) VALUES (6, 'RRHH', 456456);";
                    consulta.executeUpdate(sql);
                    System.out.println("--Departamento insertado correctamente--");

                }catch (SQLException se) {
                    System.out.println();
                    System.out.println("¡Error al insertar el departamento!");
                    System.out.println();
                }

            //*********** punto 5 ************** */
            // Modificar la nacionalidad de algún empleado
                try{
                sql = "UPDATE empleados SET nacionalidad = 'argentino'  WHERE apellido = 'Perez' and  nombre = 'Juan';";
                consulta.executeUpdate(sql);
                System.out.println("--Nacionalidad modificada correctamente--");
                } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("¡Error al modificar la nacionalidad del empleado!");
                        System.out.println();
                }
            //*********** punto 6 ************** */
            // Eliminar un departamento.
            try {  
                sql = "DELETE FROM departamento WHERE departamento_nombre = 'RRHH';";
                consulta.executeUpdate(sql);
                System.out.println("--Departamento eliminado correctamente--");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("¡Error al modificar la nacionalidad del empleado!");
                    System.out.println();
                }

            //*********** punto 7 ************** */
            // Listar los empleados del departamento 1.
            try {  
                sql = "SELECT nombre, apellido FROM EMPLEADOS WHERE departamentoID=1;";
                ResultSet resultado = consulta.executeQuery(sql);
                System.out.println();
                System.out.println("=================================================================");
                System.out.println("         Listar los empleados del departamento 1.  ");
                System.out.println("=================================================================");
                while (resultado.next()) {
                    // obtener el valor de cada columna   
                    String nombre= resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                
                    // Mostrar los valores obtenidos
                    System.out.print("            Nombre: " + nombre);
                    System.out.print(", Apellido: "  + apellido );
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------");
                }   

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("¡Error al listar los empleados del departamento 1 !");
                    System.out.println();
                }
            //*********** punto 8 ************** */
            // Mostrar todos los departamentos ordenados alfabéticamente.

                try{
                sql = "SELECT departamentoID, departamento_nombre, presupuesto  FROM qatar2023.departamento ORDER BY departamento_nombre ASC;";      
                //En la variable resultado obtendremos las distintas filas que nos devolvió la base
                ResultSet resultado = consulta.executeQuery(sql);
                // limpiar consola
                System.out.println();
                System.out.println("  *************************************************************");
                System.out.println("    Mostrar todos los departamentos ordenados alfabéticamente");
                System.out.println("  *************************************************************");
                // Obtener las distintas filas de la consulta
                while (resultado.next()) {
                    // obtener el valor de cada columna
                    int id = resultado.getInt("departamentoID");
                    String Departamento= resultado.getString("departamento_nombre");
                    String Presupuesto = resultado.getString("presupuesto");
                
                    // Mostrar los valores obtenidos
                    System.out.print("  ID: " + id );
                    System.out.print(", Departamento: " + Departamento);
                    System.out.print(", Presupuesto: "  + Presupuesto );
                    System.out.println();
                    System.out.println("  -------------------------------------------------------------");
                }   
                resultado.close();
                } catch (SQLException se) {
                    System.out.println();
                    System.out.println("¡Error al mostrar los departamentos ordenados alfabéticamente!");
                    System.out.println();
                }
        // Esto se utiliza par cerrar la conexión con la base de datos
        consulta.close();
        conexion.close();
    } catch (SQLException se) {
        // Execpción ante problemas de conexión
        se.printStackTrace();
    } finally {
        // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
        try {
            if (consulta != null)
                consulta.close();
        } catch (SQLException se2) {
        }
        try {
            if (conexion != null)
                conexion.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    System.out.println();
    System.out.println("Fin de la ejecucción");
    System.out.println();
}

}
    
   


