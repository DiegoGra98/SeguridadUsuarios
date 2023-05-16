/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.dao.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoModulo;
import org.dao.DaoPermiso;
import org.dao.DaoRol;
import org.models.ModeloModulo;
import org.models.ModeloPermiso;
import org.models.ModeloRol;
import org.models.ModeloUsuario;

/**
 *
 * @author migu3
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {
       String listar = "Menu/Seguridad/Usuarios.jsp";
        String listar2 = "Menu/Seguridad/ListarRol.jsp";
        String listar3 = "Menu/Seguridad/ListarPermisos.jsp";
        String listar4 = "Menu/Seguridad/ListarModulo.jsp";
        
        String regra = "Menu/newindex.jsp";
        
       String add =  "Menu/Seguridad/CrearUsuario.jsp";
       String add2 = "Menu/Seguridad/CrearRol.jsp";
       String add3 = "Menu/Seguridad/CrearPermiso.jsp";
       String add4 = "Menu/Seguridad/CrearModulo.jsp";
       

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
  
        
           String acceso = "";        
        String action = request.getParameter("accion");   
          ModeloUsuario usuario = new ModeloUsuario();
          ModeloRol modor = new ModeloRol();
          ModeloPermiso moper = new ModeloPermiso();
          ModeloModulo modemo = new ModeloModulo();
        DaoUsuario daoUsuario = new DaoUsuario();
        DaoRol darol = new DaoRol();
        DaoPermiso dapor = new DaoPermiso();
        DaoModulo damod = new DaoModulo();
        
            switch (action) {
                
                
            case "read":
                    System.out.println("controller.UsuarioController.doGet()");
                   acceso = listar;
                        break;
            //para roles
            case "read2":
                    System.out.println("controller.UsuarioController.doGet()");
                   acceso = listar2;
                break;
                
                case "read3":
                    System.out.println("controller.UsuarioController.doGet()");
                   acceso = listar3;
                break;
                
                 case "read4":
                    System.out.println("controller.UsuarioController.doGet()");
                   acceso = listar4;
                break;
             
             //cliente -----------------------------------------------------------
                case "create":                
                int idCliente;
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String usuario2 = request.getParameter("usuario");
                String pass = request.getParameter("pass");
                int idroll = Integer.parseInt(request.getParameter("roll")); 
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int activo = Integer.parseInt(request.getParameter("activo"));
  
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setUsuario(usuario2);
               usuario.setPassword(pass);
               usuario.setID_Rol(idroll);
               usuario.setCodigo(codigo);
               usuario.setActivo(activo);
                daoUsuario.insertar(usuario);
                acceso = listar;
                break;
                

                 case "nuevo":
                     System.out.println("controller.UsuarioController.doGet()");
                     acceso = add;
                break;
                
              
             // -----------------------------------------------------------
                
             // ROL------------------------------------------------------------
               case "create2":                
                int idrol;
                String nombrer = request.getParameter("nombre");
                String descripcionr = request.getParameter("descripcion");
                int activor = Integer.parseInt(request.getParameter("activo"));
                String ustt = "admin";
                
                modor.setNombre(nombrer);
                modor.setDescripcion(descripcionr);
                modor.setActivo(activor);
                modor.setUsuario_Crea(ustt);
                modor.setUsuario_Mod(ustt);
                darol.insertar(modor);
                acceso = listar2;
                break;
                
                 case "nuevo2":
                     System.out.println("controller.UsuarioController.doGet()");
                     acceso = add2;
                break;
             // -----------------------------------------------------------   
                
              // PERMISO------------------------------------------------------------
              case "create3":  
                 int idpermi;
                 int idmodup = Integer.parseInt(request.getParameter("idmod"));
                 int idrollp = Integer.parseInt(request.getParameter("idrol"));
                 int activop = Integer.parseInt(request.getParameter("activo"));
                 String ust2 = "admin";
                 
                 moper.setID_Modulo(idmodup);
                 moper.setID_Rol(idrollp);
                 moper.setUsuario_Crea(ust2);
                 moper.setUsuario_Mod(ust2);
                 moper.setActivo(activop);
                 dapor.insertar(moper);
   
                acceso = listar3;
                break;
                
                 case "nuevo3":
                     System.out.println("controller.UsuarioController.doGet()");
                     acceso = add3;
                break;
             // -----------------------------------------------------------   
                
              // MODULO------------------------------------------------------------
              case "create4":                
                  int idmodu;
                  String nombremod = request.getParameter("nombre");
                  String descripcionmod = request.getParameter("descripcion");
                  String path = request.getParameter("path");
                  int nivel = Integer.parseInt(request.getParameter("nivel"));
                 int orden = Integer.parseInt(request.getParameter("orden"));
                 int idmodpadre = Integer.parseInt(request.getParameter("idmodpadre"));
                  int activomod = Integer.parseInt(request.getParameter("activo"));
                 String ust4 = "admin";
                 
                 modemo.setNombre(nombremod);
                 modemo.setDescripcion(descripcionmod);
                 modemo.setPath(path);
                 modemo.setOrden(orden);
                 modemo.setID_Modulo_Padre(idmodpadre);
                 modemo.setUsuario_Crea(ust4);
                 modemo.setUsuario_Mod(ust4);
                 damod.insertar(modemo);
                 
                  
                acceso = listar4;
                break;
                
                 case "nuevo4":
                     System.out.println("controller.UsuarioController.doGet()");
                     acceso = add4;
                break;
             // -----------------------------------------------------------   
                
        }
      
      
       RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
