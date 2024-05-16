/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saiful
 */
public class EditServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<h1>Update User</h1>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        
        User e = UserDAO.getUserById(id);
        
        out.println("<form action='EditServlet2' method='POST'>");
        out.println("<table>");
        out.println("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
        out.println("<tr><td>Username:</td><td><input type='text' name='username' value='"+e.getUsername()+"'/></td></tr>");
        out.println("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
        out.println("<tr><td>Role:</td><td>");
        out.println("<select name='role' style='width: 150px'>");
        out.println("<option>admin</option>");
        out.println("<option>user</option>");
        out.println("</select>");
        out.println("</td></tr>");
        out.println("<tr><td colspan='2'><input type='submit' value='Save User'/></td></tr>");
        out.println("</table>");
        out.println("</form>");
        
        out.close();
        
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
