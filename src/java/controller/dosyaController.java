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

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDosyadao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
        this.dosyaList = this.getDosyadao().findAll(page, pageSize);
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
