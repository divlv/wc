package eu.coreteam;

import eu.coreteam.poi.ExcelToHtml;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel97Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            final String filePath = req.getParameter("f");

            final String html = new ExcelToHtml(new FileInputStream(new File(filePath))).getHTML();

            resp.getWriter().print(html);
            resp.getWriter().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
