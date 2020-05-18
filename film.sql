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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.aktor: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
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
	(12, 'Joson', 'Cope');
/*!40000 ALTER TABLE `aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.dosya
CREATE TABLE IF NOT EXISTS `dosya` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `dosya_isim` text COLLATE utf8_turkish_ci NOT NULL,
  `dosya_path` text COLLATE utf8_turkish_ci NOT NULL,
  `dosya_tipi` text COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.dosya: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `dosya` DISABLE KEYS */;
INSERT INTO `dosya` (`dosya_id`, `dosya_isim`, `dosya_path`, `dosya_tipi`) VALUES
	(2, 'ss.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload\\ss.jpg', 'image/jpeg'),
	(6, 'acc.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload', 'image/jpeg'),
	(7, 'yasak.jpg', 'C:\\Users\\asus\\Desktop\\İNTERNET PROG\\05\\filmSitesi\\web\\upload', 'image/jpeg');
/*!40000 ALTER TABLE `dosya` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.filmler
CREATE TABLE IF NOT EXISTS `filmler` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_isim` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `film_tanimi` varchar(1000) COLLATE utf8_turkish_ci NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.filmler: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `filmler` DISABLE KEYS */;
INSERT INTO `filmler` (`film_id`, `film_isim`, `film_tanimi`, `fragman`, `cikis_yili`, `yonetmen`, `kategori_id`, `imbd`, `dosya_id`) VALUES
	(9, 'The Accountant', 'The Accountant, sayılarla arası mükemmel olan Christian Wolff’un hayatını izleyicilere aktarmaktadır. Küçük bir ofisi olan Wolff, aslında büyük suç örgütlerinin serbest muhasebeci olarak çalışmaktadır. Yaptığı işlerden dolayı Maliye Bakanlığı ajanları peşindedir ve artık temiz işler yaparak ismini unutturmak zorundadır. Bunun için robot teknolojileri üreten son sistem bir şirket ile çalışmaya başlar. Araştırmaları sonrasında şirketin hesaplarında milyon dolarlık açıklar bulmuştur. Ancak yolunda gitmeyen bazı olaylar vardır. Şirkette açık devam ettikçe birileri hayatlarını kaybetmeye başlar. Wollf ve arkadaşı da artık o hedefler arasındadır.', 'jPCLE_tDhAY', 2016, 'Gavin O\'Connor', 2, 7.3, 6),
	(10, 'Ben Efsaneyim', 'Robert Neville başarılı bir bilim adamıdır ve insanlığı yok edeceğine inanılan, önüne geçilemez tehlikeli virüs ona bulaşmamıştır. Virüs çok kısa bir zamanda birçok insanın ölümüne sebep olmuş, dünya nüfusunun çoğunu gece avlanan mutantlara çevirmiştir.Neville, salgının başladığı New York şehrinde hayatta kalan tek insan olmayı başarmıştır. Üç yıl boyunca dolaşmakta, yaydığı radyo mesajları ile hayatta kalan insanlara ulaşmaya çalışmaktadır.', 'ckSgdhThuys', 2008, 'Francis Lawrence', 7, 7.2, 2),
	(14, 'DISTRICT 9', 'Yasak Bölge 9, geçen Ağustos\'ta Amerika\'da vizyona girdiğinde bayağı bir gürültü yarattı. Ben filmi vizyona girdiği gün, yani sonradan gelecek \'Yasak Bölge 9 tapınmaları\' başlamadan önce izledim. Her ne kadar filmi başarılı bir bilim-kurgu eforu olarak kabul etsem de neden hem seyirciden, hem de eleştirmenlerden \'son yılların en önemli bilim-kurgu şaheseri\' tarzı bir tepki aldığını anlayabilmiş değilim.  Yanlış anlaşılmasın, Yasak Bölge 9 iyi bir film. Yanlız karşımızda ne 2001 veya Yıldız Savaşları ile anılacak bir bilim kurgu klasiği, ne de yılın en iyi filmlerinden biri duruyor.  Belki de ilgi ve hobi ötesinde türü bazen fazla ciddiye alan uzlanmaz arlanmaz bir bilim kurgu ineği olduğumdan Yasak Bölge 9\'u fazla derinden incelemem yüzeyden haz almamı engelliyor. Ray Bradbury, Philip K. Dick, George Orwell, Arthur C. Clarke isimlerini ilk kez bu yazıda duyan seyirci için Yasak Bölge 9, büyük ihtimalle yılın en tatmin edici filmlerinden biri olacaktır.', 'rB4MaLE7tVU', 2009, 'Neill Blomkamp', 7, 7.9, 7);
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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.film_aktor: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
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
	(91, 10, 8);
/*!40000 ALTER TABLE `film_aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.kategoriler
CREATE TABLE IF NOT EXISTS `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.kategoriler: ~15 rows (yaklaşık) tablosu için veriler indiriliyor
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
	(17, 'Macera');
/*!40000 ALTER TABLE `kategoriler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.puanlar
CREATE TABLE IF NOT EXISTS `puanlar` (
  `puan_id` int(11) NOT NULL AUTO_INCREMENT,
  `puan_degeri` int(11) NOT NULL DEFAULT 0,
  `film_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`puan_id`),
  KEY `film_id` (`film_id`),
  CONSTRAINT `film_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.puanlar: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `puanlar` DISABLE KEYS */;
INSERT INTO `puanlar` (`puan_id`, `puan_degeri`, `film_id`) VALUES
	(25, 8, 9),
	(26, 10, 10),
	(27, 7, 9),
	(28, 9, 14);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.uyeler: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `uyeler` DISABLE KEYS */;
INSERT INTO `uyeler` (`uye_id`, `uye_ad`, `uye_soyad`, `email`, `telefon`, `sifre`, `admin`) VALUES
	(1, 'Mert', 'Batuhan', 'a', '5161616', 'a', 1),
	(7, 'Anıl', 'Aldoğan', 'anilaldogan@gmail.com', '05443779897', 'a1234', 1),
	(8, 'üye', 'üye', 'uyeuye@gmail.com', '00000000000', '00000', 0);
/*!40000 ALTER TABLE `uyeler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.yorumlar
CREATE TABLE IF NOT EXISTS `yorumlar` (
  `yorum_id` int(11) NOT NULL AUTO_INCREMENT,
  `yorum_metni` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `film_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`yorum_id`),
  KEY `yfilm_id` (`film_id`),
  CONSTRAINT `yfilm_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.yorumlar: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yorumlar` DISABLE KEYS */;
INSERT INTO `yorumlar` (`yorum_id`, `yorum_metni`, `film_id`) VALUES
	(4, 'Film efsane, kesinlikle kaçırmayın.', 9),
	(5, '100 yılda geçse bu filmi sıkılmadan izlerim, her seferinde aynı seyir zevkini veriyor.', 10),
	(6, 'Eeeehh işte', 9),
	(7, 'Garip bir film olmuş ama senaristin aklına hayran kaldım doğrusu.', 14),
	(8, 'Vallaha çok hoş.', 14);
/*!40000 ALTER TABLE `yorumlar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
