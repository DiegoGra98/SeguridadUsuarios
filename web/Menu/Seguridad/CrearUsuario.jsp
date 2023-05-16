<%-- 
    Document   : crearCliente
    Created on : 12/03/2022, 03:01:00 PM
    Author     : migu3
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%--<%@page import="models.tipoCliente"%>
<%@page import="dao.tipoClienteDao"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Crear Usuario</title>
    </head>
    <body>
        <div class="container">  
            <form id="form-work" class="" name="form-work" action="UsuarioController" method="get">
                <div class="form-group" >  
                    <div class="mb-3">
                        <label class="control-label" for="nombre">Nombre</label>
                        <input name="nombre" class="form-control" placeholder="Nombres" type="text">
                    </div>
                    <div class="mb-3">
                        <label class="control-label" for="apellido">Apellido</label>
                        <input name="apellido" class="form-control" placeholder="Apellidos" type="text">
                    </div>
                    <div class="mb-3">
                        <label class="control-label" for="usuario">Usuario</label>
                        <input name="usuario" class="form-control" placeholder="Usuario" type="text">
                    </div>
                    
                    <div class="mb-3">
                        <label class="control-label" for="pass">Contraseña</label>
                        <input name="pass" class="form-control" placeholder="contraseña" type="text">
                    </div>
                    <div class="mb-3">
                        <label class="control-label" for="roll">Rol</label>
                        <input name="roll" class="form-control" placeholder="roll" type="number">
                    </div>
                    <div class="mb-3">
                        <label class="control-label" for="codigo">Codigo</label>
                        <input name="codigo" class="form-control" placeholder="codigo" type="number">
                    </div>

                    <div class="col-md-3">
                        <label class="control-label" for="activo">Activo</label>
                        <select name="activo" class="form-control">
                            <option value="1" selected="">Activo</option>
                            <option value="0" >Inactivo</option>
                        </select>
                        <%--    <input name="estado" class="form-control" placeholder="Estado" type="text"> --%>

                    </div>                  
                    <br><br><br><br>

                    <button type="submit" name="accion" value="create" class="btn btn-success btn-lg btn-block info">Guardar</button>


                 

                </div>


            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
