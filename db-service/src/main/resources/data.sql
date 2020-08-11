DROP TABLE IF EXISTS URL_REPO;

CREATE TABLE URL_REPO (
                    original_url VARCHAR(250) NOT NULL PRIMARY KEY,
                    short_url VARCHAR(250) NOT NULL UNIQUE,
                    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
                  );

INSERT INTO URL_REPO(original_url, short_url) VALUES('https://stackoverflow.com/a/34418151/4286434234234', 'asdf');
INSERT INTO URL_REPO(original_url, short_url) VALUES('https://www.baeldung.com/spring-boot-h2-database', 'jpa');
INSERT INTO URL_REPO(original_url, short_url) VALUES('https://cloud.spring.io/spring-cloud-gateway/reference/html/#gateway-request-predicates-factories', 'gate');
INSERT INTO URL_REPO(original_url, short_url) VALUES('https://techrocking.com/spring-cloud-zuul-proxy-as-api-gateway/', 'zuul');
INSERT INTO URL_REPO(original_url, short_url) VALUES('https://github.com/reactjs/reactjs.org', 'react');

DROP TABLE IF EXISTS ADS_REPO;

CREATE TABLE ADS_REPO (
                id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                text VARCHAR(150) NOT NULL,
                description VARCHAR(250) NOT NULL,
                created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO ADS_REPO(text, description) VALUES('IPhone 11 Pro', 'Special offer!! Use this coupon code ofr $500 discount');
INSERT INTO ADS_REPO(text, description) VALUES('OnePlus 8 Pro', 'Special student offer!! Just at $699');
INSERT INTO ADS_REPO(text, description) VALUES('MacBook Pro', 'Master your crafts with the latest edition of MacBook Pro from Apple');
INSERT INTO ADS_REPO(text, description) VALUES('Google Pixel 4a', 'The latest budget phone from Google just at $349');
INSERT INTO ADS_REPO(text, description) VALUES('Samsung Note 20', 'You do you a phone that does everything? Get the latest Note 20 Ultra');
INSERT INTO ADS_REPO(text, description) VALUES('Need a website?', 'Buy your first domain for price as low as $3 only at namecheap.com');
INSERT INTO ADS_REPO(text, description) VALUES('GoPro 9', 'We heard you like adventure!! Grab the latest GoPro just at $499');
INSERT INTO ADS_REPO(text, description) VALUES('Advertise Here', 'Want you expand your business? Join 2 months free trail at ads.com');
INSERT INTO ADS_REPO(text, description) VALUES('Sony A7s iii is here', 'Here is the long awaited camera of the year - Starting price at $3499');
INSERT INTO ADS_REPO(text, description) VALUES('We heard you', 'You said you want 8K, 60 FPS, Mirrorless with IBIS. We have it all here - Canon R5. Buy today!!!');