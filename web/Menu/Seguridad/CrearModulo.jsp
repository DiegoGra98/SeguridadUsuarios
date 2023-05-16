<%-- 
    Document   : crearCliente
    Created on : 12/03/2022, 03:01:00 PM
    Author     : migu3
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Modulo</title>
    </head>
    <body>
        <div class="container">  
            <form id="form-work" class="" name="form-work" action="UsuarioController" method="get">
                <div class="form-group" >  
                    
                    <div class="mb-3">
                        <label class="control-label" for="nombre">NOMBRE</label>
                        <input name="nombre" class="form-control" placeholder="nombre" type="text">
                    </div>
                    
                    <div class="mb-3">
                        <label class="control-label" for="descripcion">DESCRIPCION</label>
                        <input name="descripcion" class="form-control" placeholder="descripcion" type="text">
                    </div>
                    
                    <div class="mb-3">
                        <label class="control-label" for="path">PATH</label>
                        <input name="path" class="form-control" placeholder="path" type="text">
                    </div>
                    
                    <div class="mb-3">
                        <label class="control-label" for="nivel">NIVEL</label>
                        <input name="nivel" class="form-control" placeholder="nivel" type="number">
                    </div>
                    
                    <div class="mb-3">
                        <label class="control-label" for="orden">ORDEN</label>
                        <input name="orden" class="form-control" placeholder="orden" type="number">
                    </div>
                    
                     <div class="mb-3">
                        <label class="control-label" for="idmodpadre">ID_MODULO_PADRE</label>
                        <input name="idmodpadre" class="form-control" placeholder="id modulo padre" type="text">
                    </div>
                    
                                               
                    <div class="col-md-3">
                        <label class="control-label" for="activo">Activo</label>
                        <select name="activo" class="form-control">
                            <option value="1" selected="">Activo</option>
                            <option value="0" >Inactivo</option>
                        </select>
                        <%--    <input name="estado" class="form-control" placeholder="Estado" type="text"> --%>
                        
                    <br><br><br><br>

                    <button type="submit" name="accion" value="create4" class="btn btn-success btn-lg btn-block info">Guardar</button>
                </div>


            </form>

        </div>
    </body>
</html>
