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
            //query for all the categories in database
            utx.begin();
            em = emf.createEntityManager();

            //Get the data from user's form
            String itemCopyCode = request.getParameter("itemcopynb");
            String itemId = (String) request.getParameter("itemid");

            if (itemId == null || itemCopyCode == null) {
                utx.rollback();
            } else {
                Item item = em.find(Item.class, Long.parseLong(itemId));
                //Create an ItemCopy instance out of it
                ItemCopy newItemCopy = new ItemCopy(itemCopyCode, item);

                em.persist(newItemCopy);

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
