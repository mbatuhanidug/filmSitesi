package entity;

import java.util.Objects;

public class dosya {

    private int id;
    private String dosya_path;
    private String dosya_isim;
    private String dosya_tipi;

    public dosya() {
    }

    public dosya(int id, String dosya_isim, String dosya_path, String dosya_tipi) {
        this.id = id;
        this.dosya_path = dosya_path;
        this.dosya_isim = dosya_isim;
        this.dosya_tipi = dosya_tipi;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosya_path() {
        return dosya_path;
    }

    public void setDosya_path(String dosya_path) {
        this.dosya_path = dosya_path;
    }

    public String getDosya_isim() {
        return dosya_isim;
    }

    public void setDosya_isim(String dosya_isim) {
        this.dosya_isim = dosya_isim;
    }

    public String getDosya_tipi() {
        return dosya_tipi;
    }

    public void setDosya_tipi(String dosya_tipi) {
        this.dosya_tipi = dosya_tipi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.dosya_path);
        hash = 59 * hash + Objects.hashCode(this.dosya_isim);
        hash = 59 * hash + Objects.hashCode(this.dosya_tipi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final dosya other = (dosya) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dosya_path, other.dosya_path)) {
            return false;
        }
        if (!Objects.equals(this.dosya_isim, other.dosya_isim)) {
            return false;
        }
        if (!Objects.equals(this.dosya_tipi, other.dosya_tipi)) {
            return false;
        }
        return true;
    }


  
}
