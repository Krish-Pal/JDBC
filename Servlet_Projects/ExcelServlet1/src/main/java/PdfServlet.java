import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PdfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = "daywise.pdf";

        BufferedInputStream buf = null;
        ServletOutputStream stream = null;

        try {

            String path = getServletContext().getRealPath("/file/daywise.pdf");

            File pdfFile = new File(path);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition",
                    "attachment; filename=\"daywise.pdf\"");

            response.setContentLength((int) pdfFile.length());

            FileInputStream fis = new FileInputStream(pdfFile);

            buf = new BufferedInputStream(fis);

            stream = response.getOutputStream();

            int readBytes;

            while ((readBytes = buf.read()) != -1) {
                stream.write(readBytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (buf != null)
                buf.close();

            if (stream != null)
                stream.close();
        }
    }
}