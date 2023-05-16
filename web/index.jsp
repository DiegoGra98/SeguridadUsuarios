

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ProyectoFinalProgra</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>


        <div class="container">
            <h3>
                Ingresa tu usuario
            </h3>
        </div>


        <div class="container">
            <form class="row g-3" id="form-work" class="" name="form-work" action="ControllerUsuario" method="post">
                <div class="col-auto ">
                    <label class="visually-hidden" for="usuario">Usuario</label>
                    <input name="usuario"type="text" class="form-control" id="exampleFormControlInput1" placeholder="usuario">
                </div>
                <div class="col-auto">
                    <label  class="visually-hidden" for="pass">Contraseña</label>
                    <input name="pass"type="password" class="form-control" id="pass" placeholder="contraseña">
                </div>
                <div class="col-auto">
                    <button type="submit"  name="accion" value="validar" class="btn btn-primary mb-3">Ingresar</button>
                </div>
                <div>
                    <h3>${cError}</h3>
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>