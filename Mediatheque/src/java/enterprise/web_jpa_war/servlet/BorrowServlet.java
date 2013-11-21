/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.web_jpa_war.servlet;

import enterprise.web_jpa_war.entity.Item;
import enterprise.web_jpa_war.entity.ItemCopy;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
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

    @PersistenceUnit
    private EntityManagerFactory emf;
    List<Item> items = new ArrayList<Item>();

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
//        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
//              
//            List<ItemCopy> borrowList = null;
            if ("Save".equalsIgnoreCase(action)) {
//                borrowList = new ArrayList<ItemCopy>();
//                ItemCopy itemcopy = new ItemCopy();
//                itemcopy.setItemCopyCode("222");
//                borrowList.add(itemcopy);
//                borrowList.add(itemcopy);
//                borrowList.add(itemcopy);
//                borrowList.add(itemcopy);
//                request.setAttribute("borrowList", borrowList);
//                String text = "";
//                StringBuffer str = new StringBuffer();
//                text = "<tr>";
//               // str.append("{\"borrows\" : ");
//                for (ItemCopy i : borrowList) {
////                    str.append("{\"itemCopyCode\": ").append(i.getItemCopyCode())
////                            .append("," + "\"itemCopyCode\": ").append(i.getItemCopyCode())
////                            .append("," + "\"itemCopyCode\": ").append(i.getItemCopyCode())
////                            .append("," + "\"itemCopyCode\": ").append(i.getItemCopyCode())
////                            .append("}}");
//                     text +=" <td class=\"span1\">"+ i.getItemCopyCode() + "</td> ";
//                }
//                text += "</tr>";
//               // out.write(str.toString());
//                out.write(text);
                request.getRequestDispatcher("Borrow.jsp").forward(request, response);
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
        // processRequest(request, response);
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        em = emf.createEntityManager();
        String action = request.getParameter("action");
        String ItemId = request.getParameter("itemCopyId");
        if ("Add to List".equalsIgnoreCase(action)) {
            Item borrowItem = em.find(Item.class, Integer.parseInt(ItemId));

            request.setAttribute("borrowList", borrowItem);

        }
        request.getRequestDispatcher("Borrow.jsp").forward(request, response);
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
         assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        em = emf.createEntityManager();
        String action = request.getParameter("action");
        String ItemId = request.getParameter("itemCopyId");
        if ("Add to List".equalsIgnoreCase(action)) {
           
            Item borrowItem = em.find(Item.class, Long.parseLong(ItemId));
            items.add(borrowItem);
              request.setAttribute("borrowList", items);
              request.setAttribute("itemId", borrowItem.getItemId());
              request.setAttribute("categoryName", borrowItem.getCategory().getCategoryName());
                    
        request.getRequestDispatcher("Borrow.jsp").forward(request, response);
        }
        
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
