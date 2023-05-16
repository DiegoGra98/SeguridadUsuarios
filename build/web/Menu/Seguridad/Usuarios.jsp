<%-- 
    Document   : ListaCliente
    Created on : 18/05/2022, 03:19:34 AM
    Author     : migu3
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.models.ModeloUsuario"%>
<%@page import="org.dao.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Listado </title>
    </head>
    <body>
        <div class="container">            
            <h1>Usuarios</h1>

            <table border="1" width="1" cellspacing="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Apellido</th>
                        <th class="text-center">Rol</th>
                        <th class="text-center">Activo</th>
                        <th class="text-center">Codigo</th>
                       
                    </tr>
                </thead>
                <%
                    DaoUsuario daoUsuario = new DaoUsuario();
                    ArrayList<ModeloUsuario> list = daoUsuario.listar();
                    for (ModeloUsuario usr : list) {
                        System.out.println(usr.getID());
                %>                     
                <tbody>
                    <tr>
                        <td class="text-center"><%= usr.getID()%></td>
                        <td class="text-center"><%= usr.getNombre()%></td>
                        <td class="text-center"><%= usr.getApellido()%></td>
                        <td class="text-center"><%= usr.getID_Rol()%></td>                    
                        <td class="text-center"><%= usr.getActivo()%></td>
                        <td class="text-center"><%= usr.getCodigo()%></td>
                      
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <form action="UsuarioController" method="get">
                <a class="btn btn-warning btn-sm" href="UsuarioController?accion=nuevo">Nuevo Usuario</a>
             
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
