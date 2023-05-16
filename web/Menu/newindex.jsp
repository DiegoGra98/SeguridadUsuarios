

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="plantilla.jsp"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>ProyectoFinal</title>
    </head>
    <body onload="startTime()">
        <div class="container">
            <div class="row row-centered pos">
                <div class="col-lg-8 col-xs-12 col-centered">                    
                    <h1>Bienvenido!</h1>
                    
                    <h1 id="txt"> </h1>
                </div>
                
            </div>
        </div>
        
        <script>
function startTime() {
  const today = new Date();
  let h = today.getHours();
  let m = today.getMinutes();
  let s = today.getSeconds();
  m = checkTime(m);
  s = checkTime(s);
  document.getElementById('txt').innerHTML =  h + ":" + m + ":" + s;
  setTimeout(startTime, 1000);
}

function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}
</script>
    </body>
</html>
