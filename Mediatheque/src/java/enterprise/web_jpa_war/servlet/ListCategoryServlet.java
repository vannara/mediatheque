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
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * The servlet class to list Persons from database
 */
@WebServlet(name = "ListCategoryServlet", urlPatterns = {"/ListCategories"})
public class ListCategoryServlet extends HttpServlet {

    @PersistenceUnit
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
            throws ServletException, IOException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            utx.begin();
            em = emf.createEntityManager();

            String action = request.getParameter("action");
            String cateId = request.getParameter("cateId");
            int categoryId = 0;
            if (cateId != null) {
                categoryId = Integer.parseInt(cateId);
            }
            if ("Edit".equalsIgnoreCase(action)) {
                Category cate = em.find(Category.class, categoryId);
                if (cate != null) {
                    request.setAttribute("categoryId", cate.getCategoryId());
                    request.setAttribute("categoryName", cate.getCategoryName());
                    request.setAttribute("maxBorrowDuration", cate.getMaxBorrowDuration());
                    request.setAttribute("maxBorrowQty", cate.getMaxBorrowQty());
                    request.setAttribute("isRenewable", cate.isIsRenewable());
                }
                request.getRequestDispatcher("CreateCategory.jsp").forward(request, response);

            } else if ("Delete".equalsIgnoreCase(action)) {
                //test if it get the id correctly from jsp
//                FileWriter writer = new FileWriter("TEST.txt");
//                if (cateId != null) {
//                    writer.write(cateId);
//                } else {
//                    writer.write("Blank");
//                }
//                writer.close();
                Category cate = em.find(Category.class, categoryId);
                em.remove(cate);
                utx.commit();

            } 
            //query for all the categories in database
            List categories = em.createQuery("select c from Category c").getResultList();

            request.setAttribute("categoryList", categories);

            //Forward to the jsp page for rendering
            request.getRequestDispatcher("ListCategory.jsp").forward(request, response);
        } catch (Exception ex) {
            // em.getTransaction().rollback();
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
                em.close();
            }
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
        return "ListCategory servlet";
    }
    // </editor-fold>
}
