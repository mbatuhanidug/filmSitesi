package util;

import controller.dosyaController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DosyaServlet", urlPatterns = {"/dosya/*"})
public class DosyaServlet extends HttpServlet {

    @Inject
    private dosyaController dc;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dosya = request.getPathInfo();

        File f = new File(dc.getUploadTo() + dosya);

        Files.copy(f.toPath(), response.getOutputStream());
    }

}
