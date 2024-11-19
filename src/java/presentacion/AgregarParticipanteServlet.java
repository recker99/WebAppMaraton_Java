/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dto.ParticipanteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.MaratonService;
import servicio.ServicioException;

/**
 *
 * @author ivanb
 */
@WebServlet(name = "AgregarParticipanteServlet", urlPatterns = {"/AgregarParticipanteServlet"})
public class AgregarParticipanteServlet extends HttpServlet {

   @EJB
    private MaratonService service;
    
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
            out.println("<title>Servlet AgregarParticipanteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarParticipanteServlet at " + request.getContextPath() + "</h1>");
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
        
                ParticipanteDTO participante = new ParticipanteDTO();

                request.setAttribute("participante", participante);
                request.getRequestDispatcher("/agregar_participante.jsp").forward(request, response);
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
            request.setCharacterEncoding("UTF-8");

               ParticipanteDTO participante = new ParticipanteDTO();
               Map<String, String> mapMensajes = new HashMap<>();
               String mensaje;

               //convertir y validar
               try {
                   int id = Integer.parseInt(request.getParameter("id"));
                   if(id <= 0){
                       mapMensajes.put("id", "Favor Ingrese un ID Positivo");
                   }else{
                       participante.setId(id);
                   }
               }catch (NumberFormatException ex) {
                   mapMensajes.put("id", "ID no es valido " + request.getParameter("id"));
               }

               String nombre = request.getParameter("nombre");
               if(nombre.isEmpty()){
                   mapMensajes.put("nombre", "Favor, Ingrese Nombre");
               } else {
                   participante.setNombre(nombre);
               }

               String sexo = request.getParameter("sexo");
               if(sexo.isEmpty()) {
                   mapMensajes.put("sexo", "Favor, Seleccione Sexo");
               } else {
                   participante.setSexo(sexo);
               }

               try{
                   int distancia = Integer.parseInt(request.getParameter("distancia"));
                   if(distancia <= 0) {
                       mapMensajes.put("distancia", "Favor, Ingrese Distancia Positiva");
                   } else {
                       participante.setDistancia(distancia);
                   }
               } catch (NumberFormatException ex) {
                   mapMensajes.put("distancia", "Distancia no es vàlida: " + request.getParameter("distancia"));
               }

               String categoria = request.getParameter("categoria");
               if(categoria.isEmpty()) {
                   mapMensajes.put("categoria", "Favor, Ingrese Categoria");
               } else {
                   participante.setCategoria(categoria);
               }

               //delegarla logica de negocio
               if(mapMensajes.isEmpty()) {
                   try {
                       service.agregarParticipante(participante);
                       mensaje = "Participante agregado exitosamente";
                   } catch (ServicioException ex) {
                       mensaje = ex.getMessage();
                   }
               } else {
                   mensaje = "Favor, revise el formulario";
               }

               request.setAttribute("mapMensajes", mapMensajes);
               request.setAttribute("mensaje", mensaje);
               request.setAttribute("participante", participante);
               request.getRequestDispatcher("/agregar_participante.jsp").forward(request, response);
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
