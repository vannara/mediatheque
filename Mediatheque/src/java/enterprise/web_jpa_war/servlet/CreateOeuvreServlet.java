/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.servlet;

import enterprise.web_jpa_war.entity.Oeuvre;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Manue
 */
@WebServlet(name="CreateOeuvreServlet", urlPatterns={"/CreateOeuvre"})
public class CreateOeuvreServlet  extends HttpServlet {
    
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
            String title  = (String) request.getParameter("title");
            String author   = (String) request.getParameter("author");
            String genre =(String) request.getParameter("genre");
            String keyWords=(String) request.getParameter("keyWords");
            String date=(String) request.getParameter("releaseDate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date releaseDate= sdf.parse(date);
        
            Oeuvre oeuvre=new Oeuvre(title,author,genre,keyWords,releaseDate);
          
            utx.begin();
        
            em = emf.createEntityManager();
            em.persist(oeuvre);
          
            utx.commit();
            
            //Forward to ListPerson servlet to list persons along with the newly
            //created person above
            request.getRequestDispatcher("ListOeuvres").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if(em != null) {
                em.close();
            }
        }
    }
    
}
