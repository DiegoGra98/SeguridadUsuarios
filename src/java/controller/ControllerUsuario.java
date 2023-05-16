/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoUsuario;
import org.models.ModeloUsuario;

/**
 *
 * @author Diego Gramajo
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

    String ingreso = "Menu/newindex.jsp";
    String inicio = "index.jsp";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect(inicio);
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
        processRequest(request, response);

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
        //processRequest(request, response);
        String acceso = "", error = "";
        String action = request.getParameter("accion");
        String usr = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String id_rol = "";
        DaoUsuario daoUsuario = new DaoUsuario();
        ModeloUsuario usuario = daoUsuario.list(0, usr);
        switch (action) {
            case "validar":
                System.out.println(usuario.getUsuario() + usr);
                if (usuario.getUsuario() != null) {
                    if (usuario.getUsuario().equals(usr) && usuario.getPassword().equals(pass)) {
                        acceso = ingreso;
                        id_rol = String.valueOf(usuario.getID_Rol());
                    } else {
                        acceso = inicio;
                        error = "Usuario o contraseña invalidos";
                    }
                } else {
                    acceso = inicio;
                    error = "Usuario o contraseña invalidos";
                }
                break;
           
        }

        request.setAttribute("cID_ROL", id_rol);
        request.setAttribute("cError", error);
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
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
