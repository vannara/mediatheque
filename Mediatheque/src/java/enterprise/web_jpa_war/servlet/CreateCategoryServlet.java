/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package enterprise.web_jpa_war.servlet;

import enterprise.web_jpa_war.entity.Category;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 * The sevelet class to insert category into database
 */
@WebServlet(name = "CreateCategoryServlet", urlPatterns = {"/CreateCategory"})
public class CreateCategoryServlet extends HttpServlet {

    @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;

    @Resource
    private UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            //Get the data from user's form

            String action = request.getParameter("action");
            String cateId = (String) request.getParameter("categoryId");
            String cateName = (String) request.getParameter("categoryName");
            String maxDuration = (String) request.getParameter("maxBorrowDuration");
            String maxQty = (String) request.getParameter("maxBorrowQty");
            String[] checkboxNamesList = request.getParameterValues("chkIsRenewable");
            boolean isRenewable = false;
            if(checkboxNamesList!=null){
                String myCheckBoxValue = checkboxNamesList[0];
                isRenewable = myCheckBoxValue != null;                
            }
            //Create a category instance out of it
            Category category = new Category(cateName, Double.parseDouble(maxDuration), Double.parseDouble(maxQty), isRenewable);

            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();

            if ("Save & New".equals(action) | "Save & Close".equals(action)) {
                if (cateId != null & !cateId.equals("")) { //update
                    //persist the category entity
                    em.merge(category);

                } else {
                    em.persist(category);
                }
            }
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();

            request.setAttribute("category", category);

            if ("Save & Close".equals(action)) {
                //Forward to ListCategory servlet to list persons along with the newly
                //created category above
               //response.sendRedirect("ListCategory.jsp");
               request.getRequestDispatcher("ListCategories").forward(request, response);
            }
            else if ("Save & New".equals(action)){
                response.sendRedirect("CreateCategory.jsp"); 
                PrintWriter out = response.getWriter();
                String name = request.getParameter("action");
                out.println("Hi, " + name + " Ajax Call is made successfully.");
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
