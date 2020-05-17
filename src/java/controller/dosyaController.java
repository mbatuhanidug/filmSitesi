package controller;

import dao.dosyaDAO;
import entity.dosya;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@SessionScoped
public class dosyaController implements Serializable {

    private dosya dosya;
    private List<dosya> dosyaList;
    private dosyaDAO dosyadao;

    private Part doc;
    private final String uploadTo = "C:\\Users\\asus\\Desktop\\İNTERNET PROG\\04\\filmSitesi\\web\\upload\\";

    public void upload() {
        try {
            InputStream upload = doc.getInputStream();
            File file = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(upload, file.toPath());

            dosya = this.getDosya();
            dosya.setDosya_path(file.getPath());
            dosya.setDosya_isim(file.getName());
            dosya.setDosya_tipi(doc.getContentType());
            this.getDosyadao().insert(dosya);

        } catch (IOException e) {
            System.out.println("DosyaController UPLOAD):" + e.getMessage());
        }
    }

    public void clearForm() {
        this.dosya = new dosya();
    }

    public void deleteConfirm(dosya dosya) {
        this.dosya = dosya;
    }

    public void delete() {
        this.getDosyadao().delete(dosya);
        this.clearForm();
    }
    
    public void update() {
        this.getDosyadao().update(dosya);
        this.clearForm();
    }
    public void updateForm(dosya dosya) {
        this.dosya = dosya;
    }
    public dosya getDosya() {
        if (this.dosya == null) {
            this.dosya = new dosya();
        }
        return dosya;
    }

    public void setDosya(dosya dosya) {
        this.dosya = dosya;
    }

    public List<dosya> getDosyaList() {
        return dosyaList;
    }

    public void setDosyaList(List<dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public dosyaDAO getDosyadao() {
        if (this.dosyadao == null) {
            this.dosyadao = new dosyaDAO();
        }
        return dosyadao;
    }

    public void setDosyadao(dosyaDAO dosyadao) {
        this.dosyadao = dosyadao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }

}
