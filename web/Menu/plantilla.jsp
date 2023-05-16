
<%@page import="org.models.ModeloModulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.models.ModeloPermiso"%>
<%@page import="org.dao.DaoPermiso"%>
<%@page import="org.dao.DaoModulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Proyecto Final</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">Inicio</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <form class="row g-3" id="form-work" class="" name="form-work" action="ControllerMenu" method="get">
                <%
                    int idRol = Integer.parseInt((String) request.getAttribute("cID_ROL"));

                    DaoPermiso daoPermiso = new DaoPermiso();
                    DaoModulo daoModulo = new DaoModulo();
                    ArrayList<ModeloPermiso> listP = daoPermiso.listar(idRol);
                    ArrayList<ModeloModulo> listM = daoModulo.listar();

                %>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <%  for (ModeloPermiso p : listP) {
                                ModeloModulo modulo = daoModulo.list(p.getID_Modulo());
                                System.out.println(p.getID_Modulo());
                        %>
                        <li class="nav-item dropdown">
                            <%if (modulo.getNivel() == 1) {%>
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%=modulo.getNombre()%>
                            </a>
                            <%
                                }
                            %>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <%for (ModeloModulo m : listM) {
                                        if (m.getNivel() == 2 && m.getID_Modulo_Padre() == modulo.getID()) {
                                %>
                                <li><a class="dropdown-item" href="ControllerMenu?accion=<%=m.getID()%>"><%=m.getNombre()%></a></li>
                                    <%
                                            }
                                        }
                                    %>
                            </ul>
                        </li>
                        <%
                            }
                        %>
                    
                    </ul>
                      </div>
                                            </form>

                        
                        
                     <div>
                         <ul class="navbar-nav navbar-collapse" id="navbarSupportedContent">
                                  <li class="nav-item dropdown">         
         <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Roles
                                  </a>

                                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">   <li><a class="dropdown-item" href="UsuarioController?accion=read2">Listar Roles</a></li>
                                        <li><a class="dropdown-item" href="UsuarioController?accion=nuevo2">Crear Rol</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        
                                     </ul>
                    </ul> 
                            
                        </div>
                        
                        
            <div>
        <ul class="navbar-nav navbar-collapse" id="navbarSupportedContent">
                                       
             <li class="nav-item dropdown">         
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Permiso
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="UsuarioController?accion=read3">Listar Permiso</a></li>
            <li><a class="dropdown-item" href="UsuarioController?accion=nuevo3">Crear Permiso</a></li>
            <li><hr class="dropdown-divider"></li>
          </ul>
                    </ul> 
                            
                        </div>
                   
                   
                        <div>
                            <ul class="navbar-nav navbar-collapse" id="navbarSupportedContent">
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Modulo
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="UsuarioController?accion=read4">Listar Modulo</a></li>
            <li><a class="dropdown-item" href="UsuarioController?accion=nuevo4">Crear Modulo</a></li>
            <li><hr class="dropdown-divider"></li>
          </ul>
                            </ul>
            </div>
                        
                        
                    </nav>
         
      
            
            
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </body>
</html>

