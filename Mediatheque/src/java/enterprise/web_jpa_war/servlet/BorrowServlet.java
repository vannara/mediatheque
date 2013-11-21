/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.web_jpa_war.servlet;

import enterprise.web_jpa_war.entity.Adherent;
import enterprise.web_jpa_war.entity.Borrow;
import enterprise.web_jpa_war.entity.BorrowItem;
import enterprise.web_jpa_war.entity.Card;
import enterprise.web_jpa_war.entity.Item;
import enterprise.web_jpa_war.entity.ItemCopy;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 *
 * @author vannaraloch
 */
@WebServlet(name = "BorrowServlet", urlPatterns = {"/Borrow"})
public class BorrowServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;

    List<ItemCopy> itemCopies = new ArrayList<ItemCopy>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NotSupportedException, SystemException {
        assert emf != null;  //Make sure injection went through correctly.
        EntityManager em = null;
        FileWriter writer=null;
        try {
            String action = request.getParameter("action");
            String itemCopyCode = request.getParameter("itemCopyCode");
            String adherentNumber = request.getParameter("adherentNumber");

            utx.begin();
            
            em = emf.createEntityManager();
            
            if ("Add to List".equalsIgnoreCase(action)) {
                //query the item_copy infor based on scanning barcode
                Query itemCp = em.createQuery("select c from ItemCopy c WHERE c.itemCopyCode=:itemCode");
                itemCp.setParameter("itemCode", itemCopyCode);
                ItemCopy itemcopy = (ItemCopy) itemCp.getSingleResult();
                if (itemcopy != null) {
                    // ItemCopy borrowItem = em.find(ItemCopy.class, Long.parseLong(itemcopy.getItemCopyId()));
                    itemCopies.add(itemcopy);
                    request.setAttribute("borrowList", itemCopies);
                    if (adherentNumber == null | adherentNumber == "null") {
                        request.setAttribute("adherentNumber", "");
                    } else {
                        request.setAttribute("adherentNumber", adherentNumber);
                    }
                }

                //request.getRequestDispatcher("Borrow.jsp").forward(request, response);
            }
            if ("Save".equalsIgnoreCase(action)) {    
                
               ///// create borrow information
                Borrow borrow = new Borrow();
                Query cardQuery = em.createQuery("select c from Card c WHERE c.login=:adherentNumber");
                cardQuery.setParameter("adherentNumber", adherentNumber);              
                Card card =(Card) cardQuery.getSingleResult();
                
                Query adherentQuery = em.createQuery("select ad from Adherent ad WHERE ad.card=:card");
                adherentQuery.setParameter("card", card);                 
                Adherent adherent= (Adherent)adherentQuery.getSingleResult();               
                borrow.setAdherent(adherent);
                borrow.setBorrowDate(new java.util.Date());
                //persist in persistence context
                em.persist(borrow);
                
                for(ItemCopy ic: itemCopies){
                    BorrowItem borrowItem=new BorrowItem();
                    borrowItem.setBorrowId(borrow.getBorrowId());
                    borrowItem.setItemCopyId(ic.getItemCopyId());
                    int maxDuration= (int) ic.getItem().getCategory().getMaxBorrowDuration();
                    Calendar cal = Calendar.getInstance();    
                    cal.add(Calendar.DAY_OF_MONTH, maxDuration);
                    java.util.Date expectedReturnDate =new java.util.Date(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE));

                    borrowItem.setExpectedReturnDate(expectedReturnDate);
                    em.persist(borrowItem);
                   
                }
                utx.commit();
                ////remove all items before another save transaction
                for(ItemCopy ic: itemCopies){
                    itemCopies.remove(ic);
                }
                request.getRequestDispatcher("ListBorrows").forward(request, response);
                
            }
            else {
            
                request.getRequestDispatcher("Borrow.jsp").forward(request, response);
            }
        } catch (Exception e) {
              writer = new FileWriter("TEST.txt");
                    writer.write(e.getMessage());
               
                writer.close();
            utx.rollback();
        } finally {
           em.close();
           //em.clear();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NotSupportedException ex) {
            Logger.getLogger(BorrowServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BorrowServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NotSupportedException ex) {
            Logger.getLogger(BorrowServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BorrowServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
