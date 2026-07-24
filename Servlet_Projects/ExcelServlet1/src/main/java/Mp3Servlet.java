import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Mp3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = "bodyguard.mp3";

        String path = getServletContext().getRealPath("/files/bodyguard.mp3");

        File file = new File(path);

        response.setContentType("audio/mpeg");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + fileName + "\"");

        response.setContentLength((int) file.length());

        FileInputStream input = new FileInputStream(file);
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