

<jsp:include page="../plantilla.jsp"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>UPDATE</title>
         <link href="Styles/Site.css" rel="stylesheet" type="text/css"/>
        <link href="Content/bootstrap.css" rel="stylesheet" type="text/css"/>
       <script src="Scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
       <script src="Scripts/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
       <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerKardex" method="get">
                    <h1>Modifica Cliente</h1>
                  <div class="form-group" >  
                      <%
                          /*
                          DaoKardex daoka = new DaoKardex();
                          //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                          int idKard = Integer.parseInt((String) request.getAttribute("idKardex"));
                          ModelKardex modka = new ModelKardex();
                          modka = daoka.list(idKard);
*/
                          
                      %>
                      
                    
                          <label class="control-label" for="idus">Usuario</label>
                          <input name="idus" class="form-control" placeholder="" type="text" value ="</%= modka.getID_USUARIO()%>">
                      </div>
                      <br><br><br>
                      <div class="col-md-4">
                          <label class="control-label" for="nombre">Nombre</label>
                          <input name="nombre" class="form-control" placeholder="" type="text" value="</%= modka.getID_PRODUCTO() %>">
                      </div>
                      <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="Apellido">Apellido</label>
                          <input name="apellido" class="form-control" placeholder="" type="text" value="</%= modka.getID_TIPO_MOVIMIENTO() %>">
                      </div>
                       <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="idrol">ID_ROL</label>
                          <input name="idrol" class="form-control" placeholder="" type="text" value="</%= modka.getCANTIDAD() %>">
                      </div>
                      <div class="col-md-3">
                          <label class="control-label" for="activo">Activo</label>
                          <input name="activo" class="form-control" placeholder="" type="text" value="</%=  %>">
                      </div>
                      <div class="col-md-3">
                          <label class="control-label" for="idrol">Codigo</label>
                          <input name="codigo" class="form-control" placeholder="" type="text" value="</%=  %>">
                      </div>
                        <br><br><br>
                      <br><br><br><br>
                      <div class="col-md-3">
                          <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                      </div>
                      <div class="col-md-3">

                      </div>
                  </div>

                
            </form>
        </div>
    </body>
</html>
