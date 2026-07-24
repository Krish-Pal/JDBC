import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = "temp.docx";

        String path = getServletContext().getRealPath("/files/temp.docx");

        File doc = new File(path);

        response.setContentType(
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + fileName + "\"");

        response.setContentLength((int) doc.length());

        FileInputStream input = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(input);
        ServletOutputStream stream = response.getOutputStream();

        int readBytes;

        while ((readBytes = buf.read()) != -1) {
            stream.write(readBytes);
        }

        buf.close();
        input.close();
        stream.close();
    }
}