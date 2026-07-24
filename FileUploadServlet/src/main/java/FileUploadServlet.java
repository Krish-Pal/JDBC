import java.io.IOException;
import java.io.PrintWriter;

import com.oreilly.servlet.MultipartRequest;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FileUploadServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<body>");

        try {

            String path = getServletContext().getRealPath("/file");

            MultipartRequest mpr =
                    new MultipartRequest(req, path, 500 * 1024 * 1024);

            String fileName = mpr.getOriginalFileName("file123");

            out.println("<h2>File Uploaded Successfully</h2>");
            out.println("<br>File Name : " + fileName);

        } catch (Exception e) {

            out.println("<h3>File Upload Failed</h3>");
            out.println(e.getMessage());
            e.printStackTrace();

        }

        out.println("</body>");
        out.println("</html>");
    }
}