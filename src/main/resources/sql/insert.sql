# CREATE DATABASE  IF NOT EXISTS `personal_budget` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `personal_budget`;
INSERT INTO `personal_budget`.`category` (`name`)
VALUES ('Zakupy'),
       ('Dzieci i edukacja'),
       ('Mieszkanie, dom i ogród'),
       ('Osobiste'),
       ('Przychód'),
       ('Rachunki i media'),
       ('Rozrywka'),
       ('Samochód'),
       ('Usługi biznesowe'),
       ('Zdrowie');
# Zakupy
INSERT INTO subcategory (name, category_id)
VALUES ('Spożywcze', 1),
       ('Papierosy', 1),
       ('Gazety i czasopisma', 1),
       ('Chemia', 1),
       ('Hobby', 1),
       ('Odzież i obuwie', 1),
       ('Elektronika i oprogramowanie', 1),
       ('Alkohol', 1),
       ('Inne zakupy', 1);

# Dzieci i edukacja
INSERT INTO subcategory (name, category_id)
VALUES ('Edukacja i rozwój osobisty', 2),
       ('Inne (dzieci i edukacja)', 2);
# Mieszkanie, dom i ogród
INSERT INTO subcategory (name, category_id)
VALUES ('Meble, sprzęt, wyposażenie', 3),
       ('Ogród', 3),
       ('Remont i rozbudowa', 3);
# Osobiste
INSERT INTO subcategory (name, category_id)
VALUES ('Kosmetyki i higiena osobista', 4),
       ('Bilety i taksówki', 4),
       ('Sport', 4),
       ('Włosy', 4),
       ('Masaż, solarium, spa', 4),
       ('Zwierzęta', 4),
       ('Udzielenie pożyczki', 4),
       ('Inne osobiste', 4);
# Przychód
INSERT INTO subcategory (name, category_id)
VALUES ('Pensja', 5),
       ('Zwrot (pożyczki, podatku, zakupu)', 5);
# Rachunki i media
INSERT INTO subcategory (name, category_id)
VALUES ('Prąd', 6),
       ('Internet)', 6),
       ('Komórka', 6),
       ('Czynsz i wynajem', 6),
       ('Kanalizacja', 6),
       ('Opłaty i prowizje bankowe', 6),
       ('Inne rachunki', 6);
# Rozrywka
INSERT INTO subcategory (name, category_id)
VALUES ('Restauracje', 7),
       ('Filmy, gry, płyty)', 7),
       ('Książki, kino, teatr', 7),
       ('Wyjazdy, podróże, wakacje', 7),
       ('Inne formy rozrywki', 7);
# Samochód
INSERT INTO subcategory (name, category_id)
VALUES ('Paliwo', 8),
       ('Parkowanie)', 8),
       ('Serwis i części', 8),
       ('Opłaty', 8);
