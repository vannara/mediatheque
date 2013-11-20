/**
 *
 * @author vannaraloch
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
import javax.persistence.Query;
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
                    if (cate.isIsRenewable()) {
                        request.setAttribute("isRenewable", "checked");
                    }
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
            //name query defined in Categry Entity
            Query q= em.createNamedQuery("getAllCategories");            
            List categories = q.getResultList() ;

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
