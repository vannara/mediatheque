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
import enterprise.web_jpa_war.entity.Item;
import enterprise.web_jpa_war.entity.Oeuvre;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;


/**
 * The sevelet class to insert andherent into database
 */
@WebServlet(name="CreateItemServlet", urlPatterns={"/CreateItem"})
public class CreateItemServlet extends HttpServlet {
    
    @PersistenceUnit
    //The emf corresponding to 
    private EntityManagerFactory emf;  
    
    @Resource
    private UserTransaction utx;

    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        try {
            //query for all the categories in database
            em = emf.createEntityManager();
              
            List categories = em.createQuery("select c from Category c").getResultList();
            request.setAttribute("categoryList", categories);
            
            List oeuvres = em.createQuery("select c from Oeuvre c").getResultList();
            request.setAttribute("oeuvreList",oeuvres);
            
            //Get the data from user's form
            String itemNumber  = (String) request.getParameter("itemnb");
            String oeuvreId   = (String) request.getParameter("oeuvreid");
            String categoryId =(String) request.getParameter("categoryid");

            //begin a transaction
            utx.begin();
            
            //Get oeuvre and category object
            Oeuvre oeuvre = em.find(Oeuvre.class, Long.valueOf(oeuvreId));
//            String dateOeuvre = "12-12-2012";
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//            Date releaseDate= sdf.parse(dateOeuvre);
//            Oeuvre oeuvre = new Oeuvre("livre du suspens","auteur","policier","suspens",releaseDate);
            Category category = em.find(Category.class, Integer.valueOf(categoryId));
            
            if(oeuvre == null || category == null){
                utx.rollback();   
            }
            else
            {
                //Create an Item instance out of it
                Item newItem  = new Item (itemNumber,oeuvre,category);
                System.out.println("IN TRANSACTION CREATE ITEM " + newItem.getOeuvre().getTitle() + "/" + newItem.getCategory().getCategoryName());
                
                //create an em. 
                //Since the em is created inside a transaction, it is associsated with 
                //the transaction
                //persist the newItem entity
                em.persist(newItem);
                //commit transaction which will trigger the em to 
                //commit newly created entity into database
                utx.commit();
            }
            
            //Forward to the jsp page for rendering
            request.getRequestDispatcher("ListItems").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
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
        return "CreateItem servlet";
    }
}
