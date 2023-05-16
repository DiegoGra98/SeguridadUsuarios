
<%@page import="org.models.ModeloRol"%>
<%@page import="org.dao.DaoRol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.dao.DaoUsuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
            <h1>Roles</h1>

            <table border="1" width="1" cellspacing="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">ACTIVO</th>
                        <th class="text-center">USUARIO_CREA</th>
                        <th class="text-center">FECHA_CREA</th>
                       
                         
                    </tr>
                </thead>
                <%
                 DaoRol darol = new DaoRol();
                    ArrayList<ModeloRol> list = darol.listar();
                    for (ModeloRol roll : list) {
                        System.out.println(roll.getID());
                %>                     
                <tbody>
                    <tr>
                      <td class="text-center"><%= roll.getID()%></td>
                        <td class="text-center"><%= roll.getNombre()%></td>
                        <td class="text-center"><%= roll.getDescripcion()%></td>
                        <td class="text-center"><%= roll.getActivo() %></td>                    
                        <td class="text-center"><%= roll.getUsuario_Crea() %></td>
                        <td class="text-center"><%= roll.getFecha_Crea() %></td>
                   
                    </tr>
                    <%}%>
                </tbody>
            </table>



        </div>
    </body>
</html>
