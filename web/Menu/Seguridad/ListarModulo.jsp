
<%@page import="org.models.ModeloModulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.dao.DaoModulo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado </title>
    </head>
    <body>
        <div class="container">            
            <h1>Modulos</h1>

            <table border="1" width="1" cellspacing="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID_MODULO</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">PATH</th>
                        <th class="text-center">NIVEL</th>
                        <th class="text-center">ORDEN</th>
                        <th class="text-center">ID_MODULO_PADRE</th>
                         <th class="text-center">USUARIO_CREA</th>
                        <th class="text-center">ACTIVO</th>
                         
                    </tr>
                </thead>
                <%
                    DaoModulo damod = new DaoModulo();
                    ArrayList<ModeloModulo> list = damod.listar();
                    for (ModeloModulo mm : list) {
                        System.out.println(mm.getID());
                %>                     
                <tbody>
                    <tr>
                       <td class="text-center"><%= mm.getID()%></td>
                        <td class="text-center"><%= mm.getNombre()%></td>
                        <td class="text-center"><%= mm.getDescripcion()%></td>
                        <td class="text-center"><%= mm.getPath() %></td>                    
                        <td class="text-center"><%= mm.getNivel() %></td>
                        <td class="text-center"><%= mm.getOrden() %></td>
                        <td class="text-center"><%= mm.getID_Modulo_Padre() %></td>
                        <td class="text-center"><%= mm.getUsuario_Crea() %></td>
                        <td class="text-center"><%= mm.getActivo()%></td>

                    </tr>
                    <%}%>
                </tbody>
            </table>



        </div>
    </body>
</html>
