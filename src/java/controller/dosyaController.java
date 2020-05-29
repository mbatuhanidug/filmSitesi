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
    private List<dosya> fullList;
    private dosyaDAO dosyadao;
    private Part doc;
    private final String uploadTo = "C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload\\";  // Buraya proje için dosya yükeleyeceğiniz dosya yolunu giriniz.

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {  // sayfalama tekniği için ileri gitme metodu.
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {  // sayfalama tekniği için geri gitme metodu.
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

    public int getPageCount() {  // sayfa sayısını döndüren metod.
        this.pageCount = (int) Math.ceil(this.getDosyadao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {    // form u temizleme metodu.
        this.dosya = new dosya();
    }

    public void deleteConfirm(dosya dosya) { //silmek istediğimiz veri için arayüzde silme için onaylama gönderen metod.
        this.dosya = dosya;
    }

    public void delete() {   // dao sınıfında ki delete metodunu çağıran metod.
        this.getDosyadao().delete(this.dosya);
        this.dosya = new dosya();
    }

    public dosyaController() {
    }

    public void update() {   //dao sınıfındaki update çağıran metod.
        this.getDosyadao().update(dosya);
        this.clearForm();
    }

    public void updateForm(dosya dosya) {  // update işlemi için veri yi form a aktaran metod.
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

    public List<dosya> getDosyaList() {   // verileri, dao sınıfındaki metodu çağırarak döndüren metod.
        this.dosyaList = this.getDosyadao().findAll(this.page, this.pageSize);
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

    public List<dosya> getFullList() {
        this.fullList = this.getDosyadao().fullDosya();
        return fullList;
    }

    public void setFullList(List<dosya> fullList) {
        this.fullList = fullList;
    }

    public void upload() {
        try (InputStream input = doc.getInputStream()) {
            String file = doc.getSubmittedFileName();
            File f = new File(uploadTo, file);
            Files.copy(input, f.toPath());

            dosya = this.getDosya();
            dosya.setDosya_path(f.getParent());
            dosya.setDosya_isim(f.getName());
            dosya.setDosya_tipi(doc.getContentType());

            this.getDosyadao().insert(dosya);

        } catch (IOException e) {
            System.out.println("DosyaController UPLOAD):" + e.getMessage());
        }
    }

}
