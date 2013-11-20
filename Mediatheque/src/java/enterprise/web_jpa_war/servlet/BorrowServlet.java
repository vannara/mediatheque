/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.web_jpa_war.servlet;


import enterprise.web_jpa_war.entity.ItemCopy;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vannaraloch
 */
@WebServlet(name = "BorrowServlet", urlPatterns = {"/Borrow"})
public class BorrowServlet extends HttpServlet {

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
        try {
            String action = request.getParameter("action");
            List<ItemCopy> borrowList = null;

            if ("add".equalsIgnoreCase(action)) {

                borrowList = new ArrayList<ItemCopy>();
                ItemCopy itemcopy = new ItemCopy();
                itemcopy.setItemCopyCode("222");
                borrowList.add(itemcopy);
                borrowList.add(itemcopy);
                borrowList.add(itemcopy);
                borrowList.add(itemcopy);             
                request.setAttribute("borrowList", borrowList);
                String text="";
                text = "<tr>";
                for(ItemCopy i:borrowList){
                    text +=" <td class=\"span1\">"+ i.getItemCopyCode() + "</td> ";
                }
                text += "</tr>";
                out.write(text);
                               
//request.getRequestDispatcher("Borrow").forward(request, response);
            } else if ("save".equalsIgnoreCase(action)) {

            } 
            request.getRequestDispatcher("Borrow.jsp").forward(request, response);
            
        } finally {
            out.close();
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
