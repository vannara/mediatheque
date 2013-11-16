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
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * The servlet class to list Persons from database
 */
@WebServlet(name = "ListCategoryServlet", urlPatterns = {"/ListCategory"})
public class ListCategoryServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;

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
            //query for all the categories in database
            em = emf.createEntityManager();
            List categories = em.createQuery("select c from Category c").getResultList();//em.createNamedQuery("getAllCategories").getResultList();
            request.setAttribute("categoryList", categories);
          
            //Forward to the jsp page for rendering
           // request.getRequestDispatcher("ListCategory.jsp").forward(request, response);
            
          // em.createQuery("select p from Person p").getResultList();
          
            
          
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
         assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            //query for all the categories in database
            em = emf.createEntityManager();
            List<Category> categories = em.createQuery("select c from Category c").getResultList();//em.createNamedQuery("getAllCategories").getResultList();
            request.setAttribute("categoryList", categories);
          
            PrintWriter out = response.getWriter();
            for(Category c: categories){
                 out.println("Hi, " + c.getCategoryName() + " Ajax Call is made successfully.");
            }
           
            //Forward to the jsp page for rendering
           // request.getRequestDispatcher("ListCategory.jsp").forward(request, response);
            
          // em.createQuery("select p from Person p").getResultList();
          
            
          
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
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

//    private List<Category> getAllCategories() {
//        emf = Persistence.createEntityManagerFactory("jpaFactory");
//        EntityManager em = emf.createEntityManager();
//        try {
//           
//            Query query = em.createNamedQuery("readAllCategories");
//            List<Category> categories = query.getResultList();
//            return categories;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            em.close();
//        }
//        return null;
//    }
    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "ListPerson servlet";
    }
    // </editor-fold>
}
