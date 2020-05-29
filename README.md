# Film Tanıtım Sitesi

# Amaç:

DP Film bir film tanıtım sitesidir. Bu site de üye olan kullanıcılarımız izledikleri filmlere puan ve yorum yazabilir, kendi seyir zevklerine göre film bulup fragmanını izleyip kendisine en uygun filmi seçebilir. Ulusal bir puanlama sistemi olan IMBD puanlarıyla da desteklenen sitemiz kullanıcılarına büyük bir kolaylık sağlayarak saatlerce film arama sorununa çözüm getirmektedir. Projemiz gelişime tamamen açıktır.

# Not:

Commitler içersinde bulunan Asus isimli comitter Zilan Turana ait, Dell isimli Comitter da Mert Batuhan İduğ a ait. Takım katkılarını öğrenmek için [commitler](https://github.com/mbatuhanidug/filmSitesi/commits/master) bölümünden inceleme yapabilirsiniz.

# Projeyi Nasıl Kullanabilirim?

1-Netbeans 8.2, jdk 1.8.0_251 ve Java-EE kurulumu.

2-Glassfish 5.1.0 kurulumu.

3-HeidiSQL 10.4 kurulumu. (MariaDB or MySQL)

4-Kurulumlar sağlandıktan sonra proje içerisinde bulunan [SQL](film.sql) dosyasını HeidiSQL üzerinde açıp kaydediniz.

5-Projeyi IDE üzerinde açtıktan sonra [DBConnection](src/java/util/DBConnection.java) sınıfında bulunan veritabanını ayarlayınız ve [dosyaController](src/java/controller/dosyaController.java) sınıfı içinde yazılmış olan "String uploadTo" path adresini dosya içinde bulunan [upload](web) klasörünün path adresiyle değişiniz.

6-Projeyi Run etmek için gerekli ayarlar yapıldıktan sonra projeyi Netbeans IDE'si üzerinde bulunan tarayıcı seçeneklerini [GoogleChrome](https://www.google.com.tr/chrome/) seçtikten sonra Run edebilirsiniz.

7-Admin girişi için

* Email:admin

* Şifre:admin

8-Üye girişi için kayıt olarak girebilirsiniz ya da aşağıdaki üyelikle girebilirsiniz.

* Email:uyeuye@gmail.com

* Şifre:00000
