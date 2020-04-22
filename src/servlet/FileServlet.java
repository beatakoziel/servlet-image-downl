package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] fileBytes = getFileBytes("C://Users/beata/Desktop/flower.jpg");
        response.setContentType("image/jpg");
        response.setContentLength(fileBytes.length);
        //response.addHeader("Content-Disposition", "attachment; filename=flowerImage.jpg");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(fileBytes);
        outputStream.flush();
    }

    private byte[] getFileBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long fileSize = file.length();
        byte[] content = new byte[(int) fileSize];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(content);
        fileInputStream.close();
        return content;

    }
}
