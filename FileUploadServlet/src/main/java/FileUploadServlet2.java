import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileUploadServlet2 extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException {
		
		try {
			res.setContentType("text/html");
			ServletInputStream in = req.getInputStream();
			ServletInputStream in = req.getInputStream();
			ServletOutputStream out = res.getOutputStream();
			
			FileOutputStream fout = new FileOutputStream("e:\\f2\demo17.txt");
			
			int i =0;
			while(int in.read()) != -1) {
				fout.write(i);
			}
			
			out.println("File uploaded");
		} catch(Exception e) {
			
		}
	}
}
