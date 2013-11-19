/**
 *
 * @author vannaraloch
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
            String categoryId = (String) request.getParameter("categoryId");            
            String cateName = (String) request.getParameter("categoryName");
            String maxDuration = (String) request.getParameter("maxBorrowDuration");
            String maxQty = (String) request.getParameter("maxBorrowQty");
            String[] checkboxNamesList = request.getParameterValues("chkIsRenewable");
            boolean isRenewable = false;
            if (checkboxNamesList != null) {
                String myCheckBoxValue = checkboxNamesList[0];
                isRenewable = myCheckBoxValue != null;
            }
            //begin a transaction
            utx.begin();
            //create an em. 
            //Since the em is created inside a transaction, it is associsated with 
            //the transaction
            em = emf.createEntityManager();

            if ("Save & New".equals(action) | "Save & Close".equals(action)) {
                if ( categoryId !=null && !categoryId.equals("null") ) { //update
                    //modify category entity
                    
                    Category cate = em.find(Category.class, Integer.parseInt(categoryId));
                    if (cate!=null){
                        cate.setCategoryName(cateName);
                        cate.setMaxBorrowDuration(Double.parseDouble(maxDuration));
                        cate.setMaxBorrowQty(Double.parseDouble(maxQty));
                        cate.setIsRenewable(isRenewable);
                        em.merge(cate);
                    }

                } else {
                    //Create a category instance out of it
                    Category category = new Category(cateName, Double.parseDouble(maxDuration), Double.parseDouble(maxQty), isRenewable);
                    em.persist(category);
                }
            }
            //commit transaction which will trigger the em to 
            //commit newly created entity into database
            utx.commit();

            if ("Save & Close".equals(action)) {
                //Forward to ListCategory servlet to list persons along with the newly
                request.getRequestDispatcher("ListCategories").forward(request, response);
            } else if ("Save & New".equals(action)) {
                response.sendRedirect("CreateCategory.jsp");
//                PrintWriter out = response.getWriter();
//                String name = request.getParameter("action");
//                out.println("Hi, " + name + " Ajax Call is made successfully.");
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
