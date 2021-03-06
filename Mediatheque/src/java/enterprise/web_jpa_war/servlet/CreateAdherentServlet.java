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


import enterprise.web_jpa_war.entity.Address;
import enterprise.web_jpa_war.entity.Adherent;
import enterprise.web_jpa_war.entity.Card;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name="CreateAdherentServlet", urlPatterns={"/CreateAdherent"})
public class CreateAdherentServlet extends HttpServlet {
    
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
            
            //Get the data from user's form
            String adherentName  = (String) request.getParameter("lastName");
            String adherentFirstName   = (String) request.getParameter("firstName");
            String adherentDateofBirth =(String) request.getParameter("dateofBirth");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dateofBirth= sdf.parse(adherentDateofBirth);
            String adherentDateAdhesion = (String) request.getParameter("registeredDate");
            Date dateAdhesion=sdf.parse(adherentDateAdhesion);
            
            String guaranteeAmt= (String)request.getParameter("guaranteeAmt");
            String annualFee= (String)request.getParameter("annualFee");
            
            String city  = (String) request.getParameter("city");
            String street  = (String) request.getParameter("street");
            String postalCode  = (String) request.getParameter("postalCode");
            //Create an adherent instance out of it
            //Category category = new Category(adherentName,Double.parseDouble(maxDuration),Double.parseDouble(maxQty));
            Address address=new Address(city,street,postalCode);
            Adherent adherent =new Adherent (adherentName, adherentFirstName, dateofBirth, dateAdhesion,address);
            Card card = new Card(Double.parseDouble(guaranteeAmt),Double.parseDouble(annualFee),adherent);
            adherent.setCard(card);
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();
            //persist the adherent/card entity
            em.persist(card);
            em.persist(adherent);
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();
            
            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.getRequestDispatcher("ListAdherents").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
