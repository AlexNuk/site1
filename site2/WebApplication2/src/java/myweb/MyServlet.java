
package myweb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab1.Main;

public class MyServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String parameterXstart = request.getParameter("x1");
        String parameterXfinish = request.getParameter("x2");
        String parameterDelta = request.getParameter("delta");
        String parameterA = request.getParameter("a1");
        double x1 = Double.valueOf(parameterXstart);
        double x2 = Double.valueOf(parameterXfinish);
        double delta = Double.valueOf(parameterDelta);
        double a1 = Double.valueOf(parameterA);
        lab1.Main lab1 = new Main();
        
        lab1.init_arr((int)lab1.array_len(x1,x2,delta));
        lab1.fill_array(x1, a1,(int)lab1.array_len(x1,x2,delta), delta);
        lab1.arr((int)lab1.array_len(x1,x2,delta));    
       
        double sum = lab1.sum((int)lab1.array_len(x1,x2,delta));
        double ser = lab1.ser((int)lab1.array_len(x1,x2,delta));   
        double y1 = lab1.y1;
        double y2 = lab1.y2;
        double y3 = lab1.y3;
        int i_min = lab1.i_min;
        int i_max = lab1.i_max;
    
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lab2 WEB " + request.getContextPath () + "</h1>");
            out.println("y[0] = " + y1 + "<br/>");
            out.println("y[140] = " + y2 + "<br/>");
            out.println("y[400] = " + y3 + "<br/>");
            out.println("Sum = "+ sum + "<br/>");
            out.println("Middle = "+ ser + "<br/>");         
            out.println("Y min = " + lab1.array[i_min] + "; x = "+lab1.array2[i_min] + "; i = " + i_min + "<br/>");
            out.println("Y max = " + lab1.array[i_max] + "; x = "+lab1.array2[i_max] + "; i = " + i_max);
            out.println("</body>");
            out.println("</html>");         
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
