package kontroleri;

import entiteti.Kupci;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usluge;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    static boolean insert = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesija = request.getSession();
        RequestDispatcher rd = null;
        String ime = request.getParameter("ime");
        String e_mail = request.getParameter("e-mail");
        String lozinka1 = request.getParameter("lozinka1");
        String lozinka2 = request.getParameter("lozinka2");
        String adresa = request.getParameter("adresa");
        String txt = "You haven't inserted your data correctly. Please try again!";
        
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,5}");
        Matcher m = pattern.matcher(e_mail);
        
        // Checking if all fields are empty and setting corresponding message
        if (!request.getParameter("submit").isEmpty()) {
            if (e_mail.isEmpty()) {
                txt = "You must enter e-mail!";
            } else if (!m.matches()) {
                txt = "Incorrect e-mail. Try again!";
            } else if (lozinka1.isEmpty()) {
                txt = "You must enter password!";
            } else if (ime.isEmpty()) {
                txt = "You must enter name!";
            } else if (lozinka2.isEmpty()) {
                txt = "You must confirm password!";
            } else if (adresa.isEmpty()) {
                txt = "You must enter address!";
            } else if (!lozinka1.contentEquals(lozinka2)) {
                txt = "Your password doesn't match. Please try again!";
            } else {
                txt = "";
                // Insert new buyer
                Usluge.unesiKupca(new Kupci(ime, e_mail, adresa, lozinka1));
            }
        }
        try (PrintWriter out = response.getWriter()) {
            if (Usluge.login(e_mail, lozinka1)) {
                sesija.setAttribute("imeKorisnika", ime);
                request.getRequestDispatcher("glavna.jsp").forward(request, response);
            } else {
                request.setAttribute("txt", txt);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();

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
