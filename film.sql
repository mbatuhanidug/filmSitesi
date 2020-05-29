-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- film için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `film` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci */;
USE `film`;

-- tablo yapısı dökülüyor film.aktor
CREATE TABLE IF NOT EXISTS `aktor` (
  `aktor_id` int(11) NOT NULL AUTO_INCREMENT,
  `aktor_ad` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `aktor_soyad` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`aktor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.aktor: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `aktor` DISABLE KEYS */;
INSERT INTO `aktor` (`aktor_id`, `aktor_ad`, `aktor_soyad`) VALUES
	(4, 'Ben ', 'Affleck'),
	(5, 'Anna', ' Kendrick'),
	(6, 'J.K', 'Simmons'),
	(7, 'Jon ', 'Bernthal'),
	(8, 'Will', 'Smith'),
	(9, 'Alice', 'Braga'),
	(10, 'Sharlto', 'Copley'),
	(11, 'Vannessa', 'Haywood'),
	(12, 'Joson', 'Cope'),
	(13, ' Kristen ', 'Stewart'),
	(14, 'T.J. ', 'Miller'),
	(15, 'Brad', 'Pitt'),
	(16, 'Mireille ', 'Enos'),
	(17, 'Tom ', 'Hanks'),
	(18, ' Tim ', 'Allen'),
	(19, ' Annie ', 'Potts'),
	(20, ' Michael ', 'Fassbender'),
	(21, 'Kate ', 'Winslet'),
	(22, ' Seth ', 'Rogen'),
	(23, 'Joaquin ', 'Phoenix'),
	(24, 'Robert ', 'De Niro'),
	(25, 'Zazie ', 'Beetz');
/*!40000 ALTER TABLE `aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.dosya
CREATE TABLE IF NOT EXISTS `dosya` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `dosya_isim` text COLLATE utf8_turkish_ci NOT NULL,
  `dosya_path` text COLLATE utf8_turkish_ci NOT NULL,
  `dosya_tipi` text COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.dosya: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `dosya` DISABLE KEYS */;
INSERT INTO `dosya` (`dosya_id`, `dosya_isim`, `dosya_path`, `dosya_tipi`) VALUES
	(2, 'ss.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload\\ss.jpg', 'image/jpeg'),
	(6, 'acc.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload', 'image/jpeg'),
	(7, 'yasak.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload', 'image/jpeg'),
	(8, 'Derin_Sular.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload', 'image/jpeg'),
	(9, 'dünya_savaşı.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload', 'image/jpeg'),
	(10, 'toy-story-4.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload', 'image/jpeg'),
	(11, 'steve-jobs.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload', 'image/jpeg'),
	(12, 'joker.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\Film Sitesi\\filmSitesi\\web\\upload', 'image/jpeg');
/*!40000 ALTER TABLE `dosya` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.filmler
CREATE TABLE IF NOT EXISTS `filmler` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_isim` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `film_tanimi` varchar(20000) COLLATE utf8_turkish_ci NOT NULL,
  `fragman` varchar(300) COLLATE utf8_turkish_ci NOT NULL,
  `cikis_yili` int(11) NOT NULL DEFAULT 0,
  `yonetmen` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kategori_id` int(11) NOT NULL DEFAULT 0,
  `imbd` double NOT NULL,
  `dosya_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`film_id`),
  KEY `fkategori_id` (`kategori_id`),
  KEY `fdosya_id` (`dosya_id`),
  CONSTRAINT `fdosya_id` FOREIGN KEY (`dosya_id`) REFERENCES `dosya` (`dosya_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkategori_id` FOREIGN KEY (`kategori_id`) REFERENCES `kategoriler` (`kategori_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.filmler: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `filmler` DISABLE KEYS */;
INSERT INTO `filmler` (`film_id`, `film_isim`, `film_tanimi`, `fragman`, `cikis_yili`, `yonetmen`, `kategori_id`, `imbd`, `dosya_id`) VALUES
	(9, 'The Accountant', 'The Accountant, sayılarla arası mükemmel olan Christian Wolff’un hayatını izleyicilere aktarmaktadır. Küçük bir ofisi olan Wolff, aslında büyük suç örgütlerinin serbest muhasebeci olarak çalışmaktadır. Yaptığı işlerden dolayı Maliye Bakanlığı ajanları peşindedir ve artık temiz işler yaparak ismini unutturmak zorundadır. Bunun için robot teknolojileri üreten son sistem bir şirket ile çalışmaya başlar. Araştırmaları sonrasında şirketin hesaplarında milyon dolarlık açıklar bulmuştur. Ancak yolunda gitmeyen bazı olaylar vardır. Şirkette açık devam ettikçe birileri hayatlarını kaybetmeye başlar. Wollf ve arkadaşı da artık o hedefler arasındadır.', 'jPCLE_tDhAY', 2016, 'Gavin O\'Connor', 2, 7.3, 6),
	(10, 'Ben Efsaneyim', 'Robert Neville başarılı bir bilim adamıdır ve insanlığı yok edeceğine inanılan, önüne geçilemez tehlikeli virüs ona bulaşmamıştır. Virüs çok kısa bir zamanda birçok insanın ölümüne sebep olmuş, dünya nüfusunun çoğunu gece avlanan mutantlara çevirmiştir.Neville, salgının başladığı New York şehrinde hayatta kalan tek insan olmayı başarmıştır. Üç yıl boyunca dolaşmakta, yaydığı radyo mesajları ile hayatta kalan insanlara ulaşmaya çalışmaktadır.', 'ckSgdhThuys', 2008, 'Francis Lawrence', 7, 7.2, 2),
	(14, 'DISTRICT 9', 'Yasak Bölge 9, geçen Ağustos\'ta Amerika\'da vizyona girdiğinde bayağı bir gürültü yarattı. Ben filmi vizyona girdiği gün, yani sonradan gelecek \'Yasak Bölge 9 tapınmaları\' başlamadan önce izledim. Her ne kadar filmi başarılı bir bilim-kurgu eforu olarak kabul etsem de neden hem seyirciden, hem de eleştirmenlerden \'son yılların en önemli bilim-kurgu şaheseri\' tarzı bir tepki aldığını anlayabilmiş değilim.  Yanlış anlaşılmasın, Yasak Bölge 9 iyi bir film. Yanlız karşımızda ne 2001 veya Yıldız Savaşları ile anılacak bir bilim kurgu klasiği, ne de yılın en iyi filmlerinden biri duruyor.  Belki de ilgi ve hobi ötesinde türü bazen fazla ciddiye alan uzlanmaz arlanmaz bir bilim kurgu ineği olduğumdan Yasak Bölge 9\'u fazla derinden incelemem yüzeyden haz almamı engelliyor. Ray Bradbury, Philip K. Dick, George Orwell, Arthur C. Clarke isimlerini ilk kez bu yazıda duyan seyirci için Yasak Bölge 9, büyük ihtimalle yılın en tatmin edici filmlerinden biri olacaktır.', 'rB4MaLE7tVU', 2009, 'Neill Blomkamp', 7, 7.9, 7),
	(18, 'Derin Sular', 'Su altında geçen korku/gerilim filmlerine zaafı olanları (biri de bizzat benim) bile memnun etmekten uzakta seyreden Underwater, ‘formül film’ tanımının tam karşılığı. 10.000 metre derinlikteki bir sondaj tesisinde gerçekleşen patlamayla açılışını yapıyor ve bizleri hemen kurtulanlarla tanıştırıyor. Tesisin yıkılması yakın, su altı kıyafetleri hasarlı, oksijen tüpleri limitli. Yapılabilecek tek şey komşu tesise ulaşmak ancak kahramanlarımızı bekleyen derin su yaratıklarının buna izin vermeye pek niyeti yok.   ‘Zamana karşı yarış’ mefhumuna eklemlediği klostrofobi duygusuyla yürümeye devam etmesi halinde iyi bir film olabilirdi Underwater. Kendi yağında kavrulan bir B-sineması örneği olamamasının nedeni kuşkusuz ki 80 milyon dolarlık bütçesi. Anlatısını ve duruşunu büyütmeye çalıştığı andan itibaren irtifa kaybetmesi, ‘bir yandan da blockbuster olabilir miyim?’ hayalinin gerçek dışılığıyla paralel seyrediyor. Disney-Fox anlaşmazlığının sonucu olarak, çekimlerinin tamamlanmasından 3 sene sonra vizyon görebilmesi ‘baştan kokan bir sualtı yaratığı’ ile baş başa bırakıyor bizleri.', 'kl9nuOoKTzk', 2020, 'William Eubank', 6, 6.1, 8),
	(19, 'Dünya Savaşı Z', 'İlk zombi filminden 80 yıl sonra, sibernetiğin, dijital teknolojilerin, biyolojinin, ilâç ve genetik biliminin, doğayı ve insanları yeniden değişip dönüştürebildiği çağda, 7 milyara dayanmış nüfusun korkunç bir salgına yakalanmasının etkileri de büyük olacak tabii. "Dünya Savaşı Z" (World War Z), kökeni tespit edilemeyen bir salgının hızla yayılması ve insanların, ilk paragrafta tanımlamaya çalıştığım zombilere dönüşmesiyle, günümüz sosyal bilimlerini, politik argümanları, psikolojik analizleri fena halde hükümsüz kılan enfes bir kıyamet senaryosu tasarlayıp uyguluyor. Senaryonun çıkışı, efsanevi sinemacı Mel Brooks\'un ve müteveffa karısı Anne Bancroft\'un (ünlü "Mrs.Robinson") oğlu, 1972 doğumlu korku yazarı Max Brooks\'un romanı. Bu çağdaş küresel felaket, içeriğine uygun olarak dünyanın farklı noktalarından en az dört büyük sahne ile dehşeti inanılır kılıyor.', 'Xw4bqaW_jPA', 2013, 'Marc Forster', 6, 7, 9),
	(20, 'Oyuncak Hikayesi 4', '1995 yılında izlediğimiz filmde yeni alınan Buzz Lightyear adlı havalı oyuncak yüzünden gözden düşen Woody’nin bir yanlış anlamalar silsilesi sonucu atıldığı macerayı izlemiştik. Buzz’ı yeniden eve getirmek ve alnına sürülen lekeyi temizlemek için uğraşan Woody oyuncaklar için oldukça tehlikeli bir yer olan dış dünyada (evin dışında) inanılmaz bir serüven yaşamıştı ve biz de buna şahit olmuştuk. 50’lerden 80’lere oradan da şimdilere ışınlanan çocuk ruhlu serüven sinemasının animasyona yansımış haliydi bu film ama bazı devrimci özellikler de taşıyordu. Pixar’ın ilk filmi ve çocuklar için hazırlanmış ilk uzun metrajlı CGI animasyon olan Toy Story, klasik Disney tarzı çizgi filmlerin sonunu getiren dönemi müjdeliyordu. Disney krizi fırsata çevirip 2006 yılında stüdyoyu satın aldı ama bu başka bir hikaye...     Lafı uzattığımın farkındayım ama dedim ya, bu oyuncaklar eski dostlarımız. Franchise imkanları sayesinde gerçekten bir sürü çocuk bu oyuncaklarla büyüdü. Benim oğlumun da hala odasında tuttuğu bir Buzz’ı var mesela...', 'Kc9ACVzxF04', 2019, ' Josh Cooley', 18, 8.2, 10),
	(21, 'Steve Jobs', '“Mühendis değilsin, tasarımcı değilsin. Duvara bir çivi bile çakamazsın. Nasıl oluyor da günde 10 defa Steve Jobs bir dahi cümlesini duyuyorum. Sahiden sen ne yapıyorsun?”  “Müzisyenler enstrümanları çalar, ben ise orkestrayı yönetirim.”  Apple’ın iki ortak kurucusu Steve Jobs ve Steve Wozniak arasında geçen bu diyalog filmi özetler nitelikte. Teknolojiye yeni bir boyut getirdiğine hemfikir olduğumuz Steve Jobs, geleceği ben yarattım dediğinde aslında hiç de abartmıyordu. Bu dahi adamın biyografisini yazan Walter Isaacson’ın kitabından uyarlanarak sinemaya aktarılan filmin yönetmenliğini Danny Boyle, senaristliğini ise Oscarlı senarist Aaron Sorkin üstleniyor. Danny Boyle ve Aaron Sorkin ortaklığından sıradan bir film beklemiyorduk, dürüst olalım. Beklentilerimiz de boşa çıkmadı… Ashton Kutcher\'lı Jobs filminden sonra bu yapım ilaç gibi geliyor desem abartmış olmam. ', 'gnO40GH62jU', 2015, ' Danny Boyle', 21, 7.2, 11),
	(22, 'Joker', 'Batman mitolojisi küresel popüler kültürün artık o kadar entegral bir parçası ki, karakter ve içerdiği dünya her türlü hikaye anlatım tonuna ve hatta türe oturtulabiliyor. Bir yanda Christopher Nolan’ın olabildiğince gerçekçi Kara Şövalye üçlemesi varken, diğer yanda 1960’lı yılların Batman’i camp türüne otururken, Lego Batman Filmi gibi animasyon örnekler kendini tiye alırken, aynı zamanda bu mitoloji hakkında yeni bir şeyler sunmayı da başarıyor. Batman ying’inin yang’ı süper kötü adam Joker ise aynı konumda, ki hayranlar arasında soru Joker’i sevip sevmemeleri değil, hangi Joker’in favori versiyonları olduğu hakkında tartışmalar geçer. Bir yandan Jack Nicholson veya Heath Ledger argümanı geçerken, Batman’ın animasyonunu sevenler Mark Hamill’in ses performansının en kalite Joker olduğunu öne atar. Jared Leto’nun Joker’inin bile hayranları vardır kesin, henüz kişisel olarak bir tane bile görmemiş olmama rağmen.   Bir popüler kültür süper kötü adamı olarak Joker’in özellikle Batman’a kıyasla albenisi karakterin tamamen motivasyonsuz ve anarşik olması, ve bu anarşiden aldığı zevkin seyircide yarattığı katartik hislere bağlı kanımca. Eğer Batman kontrol ve düzeni temsil ediyorsa, Joker metafiziksel bir tepki olarak dizginsiz kaosu sunuyor ona. Karakterin bu kadar basit ve natürel bir biçimde insan doğasının yokedici tarafını, bir bakıma insan ruhunun id’ini temsil etmesi yüzünden hep orijin hikayesi verilmemiş Joker’leri tercih etmişimdir. Geçmişi ile beraber bir isim bile verilmemiş Heath Ledger Joker’i hala favorimdir.', 'WVC1KC4Lauc', 2019, 'Todd Phillips', 8, 8.7, 12);
/*!40000 ALTER TABLE `filmler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.film_aktor
CREATE TABLE IF NOT EXISTS `film_aktor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `aktor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `afilm_id` (`film_id`),
  KEY `aaktor_id` (`aktor_id`),
  CONSTRAINT `aaktor_id` FOREIGN KEY (`aktor_id`) REFERENCES `aktor` (`aktor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `afilm_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.film_aktor: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `film_aktor` DISABLE KEYS */;
INSERT INTO `film_aktor` (`id`, `film_id`, `aktor_id`) VALUES
	(79, 14, 12),
	(80, 14, 10),
	(81, 14, 11),
	(86, 9, 5),
	(87, 9, 4),
	(88, 9, 6),
	(89, 9, 7),
	(90, 10, 9),
	(91, 10, 8),
	(94, 18, 13),
	(95, 18, 14),
	(97, 19, 15),
	(98, 19, 16),
	(102, 20, 19),
	(103, 20, 18),
	(104, 20, 17),
	(107, 21, 20),
	(108, 21, 22),
	(109, 21, 21),
	(111, 22, 23),
	(112, 22, 24),
	(113, 22, 25);
/*!40000 ALTER TABLE `film_aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.kategoriler
CREATE TABLE IF NOT EXISTS `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.kategoriler: ~19 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kategoriler` DISABLE KEYS */;
INSERT INTO `kategoriler` (`kategori_id`, `kategori_ad`) VALUES
	(1, 'Korku'),
	(2, 'Aksiyon'),
	(3, 'Komedi'),
	(6, 'Gerilim'),
	(7, 'Bilim Kurgu'),
	(8, 'Dram'),
	(9, 'Romantik'),
	(10, 'Animasyon'),
	(11, 'Belgesel'),
	(12, 'Polisiye'),
	(13, 'Suç'),
	(14, 'Fantastik'),
	(15, 'Savaş'),
	(16, 'Tarih'),
	(17, 'Macera'),
	(18, 'Aile'),
	(19, 'Gençlik'),
	(20, 'Spor'),
	(21, 'Biyografi');
/*!40000 ALTER TABLE `kategoriler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.puanlar
CREATE TABLE IF NOT EXISTS `puanlar` (
  `puan_id` int(11) NOT NULL AUTO_INCREMENT,
  `puan_degeri` int(11) NOT NULL DEFAULT 0,
  `film_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`puan_id`),
  KEY `film_id` (`film_id`),
  CONSTRAINT `film_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.puanlar: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `puanlar` DISABLE KEYS */;
INSERT INTO `puanlar` (`puan_id`, `puan_degeri`, `film_id`) VALUES
	(25, 8, 9),
	(26, 10, 10),
	(27, 7, 9),
	(28, 9, 14),
	(29, 6, 14),
	(30, 9, 10),
	(31, 5, 9),
	(32, 9, 22),
	(33, 10, 22),
	(34, 10, 21),
	(35, 6, 20),
	(36, 8, 22),
	(37, 8, 19),
	(38, 5, 18),
	(39, 6, 18),
	(40, 8, 18);
/*!40000 ALTER TABLE `puanlar` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.uyeler
CREATE TABLE IF NOT EXISTS `uyeler` (
  `uye_id` int(11) NOT NULL AUTO_INCREMENT,
  `uye_ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `uye_soyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`uye_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.uyeler: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `uyeler` DISABLE KEYS */;
INSERT INTO `uyeler` (`uye_id`, `uye_ad`, `uye_soyad`, `email`, `telefon`, `sifre`, `admin`) VALUES
	(1, 'admin', 'admin', 'admin', 'admin', 'admin', 1),
	(7, 'Anıl', 'Aldoğan', 'anilaldogan@gmail.com', '05443779897', 'a1234', 1),
	(8, 'üye', 'üye', 'uyeuye@gmail.com', '00000000000', '00000', 0),
	(10, 'Ali', 'Kaya', 'ali_kaya@hotmail.com', '00000000000', '00000', 0);
/*!40000 ALTER TABLE `uyeler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.yorumlar
CREATE TABLE IF NOT EXISTS `yorumlar` (
  `yorum_id` int(11) NOT NULL AUTO_INCREMENT,
  `yorum_metni` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `film_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`yorum_id`),
  KEY `yfilm_id` (`film_id`),
  CONSTRAINT `yfilm_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.yorumlar: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yorumlar` DISABLE KEYS */;
INSERT INTO `yorumlar` (`yorum_id`, `yorum_metni`, `film_id`) VALUES
	(4, 'Film efsane, kesinlikle kaçırmayın.', 9),
	(5, '100 yılda geçse bu filmi sıkılmadan izlerim, her seferinde aynı seyir zevkini veriyor.', 10),
	(6, 'Eeeehh işte', 9),
	(7, 'Garip bir film olmuş ama senaristin aklına hayran kaldım doğrusu.', 14),
	(8, 'Vallaha çok hoş.', 14),
	(9, 'Çok gerildik be kardeşim. Yıllar geçse de asla sıkıcı olmayacak bir film.', 10),
	(10, 'Gereksiz gerilim.', 18),
	(11, 'Tek kelimeyle efsane.', 19),
	(12, 'Joker fanıyım artık. Batman\'de kimmiş.', 22),
	(13, 'Adamın dibi.', 21),
	(14, 'Çocuğum benden oyuncak istiyor sağolun :(', 20);
/*!40000 ALTER TABLE `yorumlar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
