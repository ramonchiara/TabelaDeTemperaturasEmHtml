package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Cor;
import modelos.TemperaturaC;

@WebServlet("/html")
public class TabelaCToFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double t0 = -10;
        double t = 110;
        double step = 0.5;
        double delta = 255 / ((t - t0) / step);
        Cor cor = new Cor(0, 0, 255);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.printf("<table border=\"1\" cellpadding=\"5\" cellspacing=\"0\">%n");
        out.printf("\t<tr><th>°C</th><th>°F</th></tr>%n");
        for (double c = t0; c <= t; c += 0.5) {
            TemperaturaC tc = new TemperaturaC(c);
            double f = tc.getF();
            out.printf("\t<tr style=\"background-color: %s\"><td>%.2f</td><td>%.2f</td></tr>%n", cor, c, f);
            cor.incR(delta);
            cor.decB(delta);
        }
        out.printf("</table>%n");
    }

}
