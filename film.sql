-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.13-MariaDB - mariadb.org binary distribution
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.aktor: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `aktor` DISABLE KEYS */;
INSERT INTO `aktor` (`aktor_id`, `aktor_ad`, `aktor_soyad`) VALUES
	(1, 'Mert', 'Batuhan'),
	(2, 'Anıl', 'Aldoğan'),
	(3, 'Sebati ', 'Doğan'),
	(4, 'Ben ', 'Affleck'),
	(5, 'Anna', ' Kendrick'),
	(6, 'J.K', 'Simmons'),
	(7, 'Jon ', 'Bernthal');
/*!40000 ALTER TABLE `aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.filmler
CREATE TABLE IF NOT EXISTS `filmler` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_isim` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `film_tanimi` varchar(1000) COLLATE utf8_turkish_ci NOT NULL,
  `cikis_yili` int(11) NOT NULL DEFAULT 0,
  `yonetmen` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kategori_id` int(11) NOT NULL DEFAULT 0,
  `imbd` double NOT NULL,
  PRIMARY KEY (`film_id`),
  KEY `fkategori_id` (`kategori_id`),
  CONSTRAINT `fkategori_id` FOREIGN KEY (`kategori_id`) REFERENCES `kategoriler` (`kategori_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.filmler: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `filmler` DISABLE KEYS */;
INSERT INTO `filmler` (`film_id`, `film_isim`, `film_tanimi`, `cikis_yili`, `yonetmen`, `kategori_id`, `imbd`) VALUES
	(1, 'test1', 'test1', 2013, 'tst1', 2, 4.6),
	(2, 'test2', 'test22', 2013, 'test2', 2, 2.1),
	(4, 'The Accountant', 'The Accountant, sayılarla arası mükemmel olan Christian Wolff’un hayatını izleyicilere aktarmaktadır.  Küçük bir ofisi olan Wolff, aslında büyük suç örgütlerinin serbest muhasebeci olarak çalışmaktadır. Yaptığı işlerden dolayı Maliye Bakanlığı ajanları peşindedir ve artık temiz işler yaparak ismini unutturmak zorundadır. Bunun için robot teknolojileri üreten son sistem bir şirket ile çalışmaya başlar. Araştırmaları sonrasında şirketin hesaplarında milyon dolarlık açıklar bulmuştur. Ancak yolunda gitmeyen bazı olaylar vardır. Şirkette açık devam ettikçe birileri hayatlarını kaybetmeye başlar. Wollf ve arkadaşı da artık o hedefler arasındadır.', 2016, 'Gavin O\'Connor', 2, 7.3);
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.film_aktor: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `film_aktor` DISABLE KEYS */;
INSERT INTO `film_aktor` (`id`, `film_id`, `aktor_id`) VALUES
	(22, 4, 4),
	(23, 4, 5),
	(24, 4, 6),
	(25, 4, 7),
	(26, 2, 2),
	(27, 2, 3),
	(28, 1, 1);
/*!40000 ALTER TABLE `film_aktor` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.kategoriler
CREATE TABLE IF NOT EXISTS `kategoriler` (
  `kategori_id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_ad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`kategori_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.kategoriler: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kategoriler` DISABLE KEYS */;
INSERT INTO `kategoriler` (`kategori_id`, `kategori_ad`) VALUES
	(1, 'Korku'),
	(2, 'Aksiyon'),
	(3, 'Komedi');
/*!40000 ALTER TABLE `kategoriler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.puanlar
CREATE TABLE IF NOT EXISTS `puanlar` (
  `puan_id` int(11) NOT NULL AUTO_INCREMENT,
  `puan_degeri` int(11) NOT NULL DEFAULT 0,
  `film_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`puan_id`),
  KEY `film_id` (`film_id`),
  CONSTRAINT `film_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.puanlar: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `puanlar` DISABLE KEYS */;
INSERT INTO `puanlar` (`puan_id`, `puan_degeri`, `film_id`) VALUES
	(8, 3, 2),
	(19, 1, 1),
	(22, 7, 4);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.uyeler: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `uyeler` DISABLE KEYS */;
INSERT INTO `uyeler` (`uye_id`, `uye_ad`, `uye_soyad`, `email`, `telefon`, `sifre`, `admin`) VALUES
	(1, 'Mert', 'Batuhan', 'a', '5161616', 'a', 1),
	(2, 'test1', 'test1', 'test1', '2131231232', '1', 0);
/*!40000 ALTER TABLE `uyeler` ENABLE KEYS */;

-- tablo yapısı dökülüyor film.yorumlar
CREATE TABLE IF NOT EXISTS `yorumlar` (
  `yorum_id` int(11) NOT NULL AUTO_INCREMENT,
  `yorum_metni` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `film_id` int(11) NOT NULL DEFAULT 0,
  `uye_id` int(11) NOT NULL,
  PRIMARY KEY (`yorum_id`),
  KEY `yfilm_id` (`film_id`),
  KEY `yuye_id` (`uye_id`),
  CONSTRAINT `yfilm_id` FOREIGN KEY (`film_id`) REFERENCES `filmler` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `yuye_id` FOREIGN KEY (`uye_id`) REFERENCES `uyeler` (`uye_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- film.yorumlar: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yorumlar` DISABLE KEYS */;
INSERT INTO `yorumlar` (`yorum_id`, `yorum_metni`, `film_id`, `uye_id`) VALUES
	(1, 'mükemmel', 2, 1);
/*!40000 ALTER TABLE `yorumlar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
