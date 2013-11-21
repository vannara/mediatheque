package enterprise.web_jpa_war.servlet;

import enterprise.web_jpa_war.entity.Category;
import enterprise.web_jpa_war.entity.Item;
import enterprise.web_jpa_war.entity.ItemCopy;
import enterprise.web_jpa_war.entity.Oeuvre;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 * The sevelet class to insert andherent into database
 */
@WebServlet(name = "CreateItemCopyServlet", urlPatterns = {"/CreateItemCopy"})
public class CreateItemCopyServlet extends HttpServlet {

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
            Integer itemNumberOfCopies  = Integer.valueOf(request.getParameter("itemcopynb"));
            Long itemId   = Long.valueOf(request.getParameter("itemid"));

            //begin a transaction
            utx.begin();
            em = emf.createEntityManager();
            
            //Get item object associated
            Item item = em.find(Item.class, itemId);
            
            if(item == null || itemNumberOfCopies < 1){
                utx.rollback();   
            }
            else{
                int itemcopynb = 1;
                List itemcopies = em.createQuery("select i from ItemCopy i where i.item = :argument order by i.itemCopyId asc").setParameter("argument", item).getResultList();
                if(itemcopies.size() > 0){
                    String itemcopynbstring = ( (ItemCopy)itemcopies.get(itemcopies.size() - 1) ).getItemCopyCode();
                    itemcopynb = Integer.valueOf(itemcopynbstring) + 1;
                    itemNumberOfCopies += Integer.valueOf(itemcopynbstring);
                }
                //Create the number of copies aked
                while(itemcopynb <= itemNumberOfCopies)
                {
                    //Create an ItemCopy instance out of it
                    ItemCopy newItemCopy  = new ItemCopy (String.valueOf(itemcopynb),item);

                    //persist the new ItemCopy entity
                    em.persist(newItemCopy);
                    
                    itemcopynb++;
                }
                //Since ItemCopies were created, some item at least are available
                item.setIsAvailable(true);
                em.merge(item);
                utx.commit();
            }

            //Forward to the jsp page for rendering
            request.getRequestDispatcher("ListItemCopies").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            //close the em to release any resources held up by the persistebce provider
            if (em != null) {
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
        //processRequest(request, response);
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        em = emf.createEntityManager();

        List itemCopies = em.createQuery("select i from Item i").getResultList();
        request.setAttribute("itemsList", itemCopies);

        request.getRequestDispatcher("CreateItemCopy.jsp").forward(request, response);
        em.close();
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
