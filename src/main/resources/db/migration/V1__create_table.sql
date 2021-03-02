-- 初回でタイムゾーンをセット
SET SESSION time_zone = 'Asia/Tokyo';

DROP TABLE IF EXISTS to_do;

CREATE TABLE to_do (
 id       bigint unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
 theme    VARCHAR(30) NOT NULL,
 message  VARCHAR(500) NOT NULL,
 datetime DATETIME
)ENGINE=InnoDB DEFAULT CHARSET=utf8;