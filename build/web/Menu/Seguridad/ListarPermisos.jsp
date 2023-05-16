
<%@page import="org.models.ModeloPermiso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.dao.DaoPermiso"%>
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
            <h1>Permisos</h1>

            <table border="1" width="1" cellspacing="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID Permiso</th>
                        <th class="text-center">ID Modulo</th>
                        <th class="text-center">ID rol</th>
                        <th class="text-center">FECHA_CREA</th>
                        <th class="text-center">USUARIO_CREA</th>
                        <th class="text-center">ACTIVO</th>
                         
                    </tr>
                </thead>
                <%
          DaoPermiso dapor = new DaoPermiso();
                    ArrayList<ModeloPermiso> list = dapor.listar(1);
                    for (ModeloPermiso mp : list) {
                        System.out.println(mp.getID());
                %>                     
                <tbody>
                    <tr>
                        <td class="text-center"><%= mp.getID()%></td>
                        <td class="text-center"><%= mp.getID_Modulo()%></td>
                        <td class="text-center"><%= mp.getID_Rol()%></td>
                        <td class="text-center"><%= mp.getFecha_Crea() %></td>
                        <td class="text-center"><%= mp.getUsuario_Crea() %></td>
 <td class="text-center"><%= mp.getActivo()%></td>
                     

                    </tr>
                    <%}%>
                </tbody>
            </table>



        </div>
    </body>
</html>
