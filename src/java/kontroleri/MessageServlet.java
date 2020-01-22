package kontroleri;

import entiteti.Kupci;
import entiteti.Proizvodi;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usluge;

@WebServlet(name = "MessageServlet", urlPatterns = {"/MessageServlet"})
public class MessageServlet extends HttpServlet {

    static Kupci k;
    static Proizvodi p;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesija = request.getSession();
        p = Usluge.vratiProizvod((String) sesija.getAttribute("proizvod"));
        k = (Kupci) sesija.getAttribute("imeKorisnika");
        int kolicina = (Integer) sesija.getAttribute("kolicina");

        try (PrintWriter out = response.getWriter()) {

            if (!request.getParameter("buy").isEmpty()) {
                // Insert shopping (buyer, product)
                Usluge.unesiKupovinu(k, p);
                // Updating new amount
                Usluge.updateKolicina(p.getProizvodiId(), kolicina);
                request.setAttribute("itemName", p.getNazivProizvoda());
                request.getRequestDispatcher("last.jsp").forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
