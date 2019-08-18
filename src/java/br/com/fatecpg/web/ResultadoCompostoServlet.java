/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LeuoO
 */
@WebServlet(name = "ResultadoCompostoServlet", urlPatterns = {"/resultado-composto.html"})
public class ResultadoCompostoServlet extends HttpServlet {

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
            DecimalFormat df = new DecimalFormat("#.00");

            double taxa = Double.parseDouble(request.getParameter("taxa"));
            double capital = Double.parseDouble(request.getParameter("capital"));
            int tempo = Integer.parseInt(request.getParameter("tempo"));
            
            double montante, juros;
            juros = 0;
            montante = 0;
                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport'content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
            out.println("<title>Resultado Juros Composto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' crossorigin='anonymous'></script>");
            out.println("<center>");
            
            taxa = (taxa/100);
            
            out.println("<table class='table'>");
            out.println("<thead class='thead-dark'>");
            out.println("<tr>");
            out.println("<th scope='col'>Mês</th>");
            out.println("<th scope='col'>Capital</th>");
            out.println("<th scope='col'>Juros</th>");
            out.println("<th scope='col'>Montante</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            
            for(int i = 1; i < tempo+1; i++){
                juros = taxa*capital;
                montante = capital+juros;
                
            capital = (capital * 100) /100;
            juros = (juros * 100) /100;
            montante = (montante * 100) /100;
         
            out.println("<tr>");
            out.println("<td>" + i + "</td>");
            out.println("<td>" + df.format(capital) + "</td>");
            out.println("<td>" + df.format(juros) + "</td>");
            out.println("<td>" + df.format(montante) + "</td>");
            out.println("</tr>");
            
            
            capital = (capital+juros);
            
            }
            
            out.println("</body>");
            out.println("</table>");
            out.println("</center>");
            out.println("<center>");
            out.println("<button type='button' class='btn btn-outline-primary'>");
            out.println("<h3><a href='home.html'>Home</a></h3>");
            out.println("</button>");
            out.println("</center>");
    
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
