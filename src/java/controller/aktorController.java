package controller;

import dao.aktorDAO;
import entity.aktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped
public class aktorController implements Serializable {

    private List<aktor> alist;
    private List<aktor> aFULLlist;
    private aktorDAO adao;
    private aktor aktor;

    private String bul = "";

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {   // aktör kısmının sayfalama da ileri metodu.Sayfanın ileri gitmesi için.
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {  // aktör kısmının sayfalamada geri metodu. Sayfanın geri dönmesi için.
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

    public int getPageCount() { // sayfa sayısını tutan control metodu 
        this.pageCount = (int) Math.ceil(this.getAdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(aktor akt) { // güncelleştirme için butona basıldığında forma aktörn verilerini yollayan metod.
        this.aktor = akt;

    }

    public void clearForm() { // form içerisinde ki veriyi silmeye yarayan metod.
        this.aktor = new aktor();
    }

    public void update() {  // dao sınıfında ki update metodunu çağıran metod. 
        this.getAdao().update(aktor);
        this.clearForm();  // güncelleme yapıldıktan sonra form temilenir.
    }

    public void delete() {  // dao sınıfında ki delete metodunu çağıran metod.
        this.getAdao().delete(aktor);
    }

    public void create() { // dao sınıfında ki create metodunu çağıran metod.
        this.getAdao().create(aktor);
        this.clearForm();
    }

    public void deleteConfirm(aktor aktor) {
        this.aktor = aktor;
    }

    public List<aktor> getAlist() {  // dao sınıfında ki aktör listesini çağıran metod.
        this.alist = this.getAdao().getAktor(this.bul, this.page, this.pageSize);
        return alist;
    }

    public List<aktor> getAFULLlist() {   // eklemede ki sayfalama bug çözümü için çağırılan metod.
        this.aFULLlist = this.getAdao().getAktor();
        return aFULLlist;
    }

    public void setAlist(List<aktor> alist) {
        this.alist = alist;
    }

    public aktorDAO getAdao() {
        if (this.adao == null) {
            this.adao = new aktorDAO();
        }

        return adao;
    }

    public void setAdao(aktorDAO adao) {
        this.adao = adao;
    }

    public aktor getAktor() {
        if (this.aktor == null) {
            this.aktor = new aktor();
        }
        return aktor;
    }

    public void setAktor(aktor aktor) {
        this.aktor = aktor;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

}
