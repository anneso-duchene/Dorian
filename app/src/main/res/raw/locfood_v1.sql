CREATE TABLE IF NOT EXISTS ingredient (
  id_ingredient int(11) NOT NULL,
  nom_ingredient text NOT NULL,
  saison text NOT NULL
);

CREATE TABLE IF NOT EXISTS recette (
  id_recette int(11) NOT NULL,
  nom_recette text NOT NULL,
  nombre_personne int(11) NOT NULL,
  temps_total time NOT NULL,
  temps_prepa time NOT NULL,
  temps_cuisson time NOT NULL,
  etapes longtext NOT NULL,
  saison text NOT NULL,
  tags text NOT NULL
);

CREATE TABLE IF NOT EXISTS recette_ingredient (
  id_ingredient_recette int(11) NOT NULL,
  id_unite int(11) NOT NULL,
  id_ingredient int(11) NOT NULL,
  id_recette int(11) NOT NULL,
  quantite int(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS unite (
  id_unite int(11) NOT NULL,
  nom_unite text NOT NULL
);

INSERT INTO ingredient (id_ingredient, nom_ingredient, saison) VALUES
(1, "lait", "automne"),
(2, "oeuf", "all"),
(3, "sucre vanillé", "all"),
(4, "sucre de canne", "all"),
(5, "levure chimique", "all"),
(6, "raisins secs", "all"),
(7, "sucre glace", "all"),
(8, "chou frisé", "automne"),
(9, "tomate", "automne"),
(10, "tomates concassées", "all"),
(11, "tofus ferme", "all"),
(12, "concentré de tomates", "all"),
(13, "gousse d'ail", "all"),
(14, "oignion", "all"),
(15, "lait", "all"),
(16, "crème fraiche épaisse", "all"),
(17, "maïzena", "all"),
(18, "huile d'olive", "all"),
(19, "fromage râpé", "all"),
(20, "cumin", "all"),
(21, "curry", "all"),
(22, "paprika", "all"),
(23, "poivre ", "all"),
(24, "gingembre", "all"),
(25, "sel", "all"),
(26, "champignon de Paris", "automne"),
(27, "sucre en poudre", "all"),
(28, "Alcool de fraise", "all"),
(29, "gélatine", "all"),
(30, "fraise", "ete"),
(31, "citron", "all"),
(32, "crème liquide", "all"),
(33, "sucre vanillé", "all"),
(34, "boudoir", "all");


INSERT INTO recette (id_recette, nom_recette, nombre_personne, temps_total, temps_prepa, temps_cuisson, etapes, saison, tags) VALUES
(1, "Lasagnes de chou vert frisé", 4, "00:45:00", "00:25:00", "00:20:00", "Etape 1\r\n-------\r\nPréparer une béchamel light : dans une petite casserole, faire fondre la crème fraiche. Dès les premières bulles, ajouter la maizena puis le lait, un peu de sel et de poivre (et de noix de muscade si vous avez) et laisser épaissir en touillant. Couper le feu des que la béchamel commence à prendre.\r\n\r\nEtape 2\r\n-------\r\nPréparer la sauce tomate : dans une casserole, faire chauffer l\'huile et y faire revenir l\'ail écrasé, l\'oignon, le tofu coupé en tout petits dés, et les champignons. Ajouter les épices.\r\n\r\nEtape 3\r\n-------\r\nUne fois que c\'est bien roussis et que le tofu a pris le goût des épices, ajouter les tomates coupées en petits dés et le concentré de tomates avec un demi-verre d\'eau.\r\nEtape 4\r\n-------\r\nPréchauffer le four à 250°C (thermostat 8).\r\n\r\nEtape 5\r\n-------\r\nDresser les lasagnes : dans un plat à gratin, disposer une couche de feuille de choux, puis une couche de tomate (la moitié de la préparation), puis une couche de béchamel (un tiers). Recommencer encore une fois et terminer par une couche de choux et le dernier tiers de béchamel.\r\n\r\nEtape 6\r\n-------\r\nParsemer d\'un peu de gruyère râpé.\r\nEtape 7\r\n-------\r\nEnfourner pendant 20-25 minutes. C\'est prêt quand l\'eau rendue par le chou est évaporée et que le dessus est bien doré. Le chou doit rester croquant.", "Automne", "Facile |Bon marché | Plat principal | Végétarien");


INSERT INTO recette_ingredient (id_ingredient_recette, id_unite, id_ingredient, id_recette, quantite) VALUES
(1, 11, 8, 1, 1),
(2, 11, 9, 1, 3),
(3, 2, 11, 1, 150),
(4, 11, 26, 1, 4),
(5, 3, 12, 1, 1),
(6, 11, 13, 1, 2),
(7, 11, 14, 1, 1),
(8, 8, 15, 1, 25),
(9, 3, 16, 1, 2),
(10, 3, 17, 1, 3),
(11, 10, 19, 1, 1),
(12, 12, 22, 1, 1),
(13, 12, 23, 1, 1),
(14, 12, 20, 1, 1),
(15, 12, 21, 1, 1),
(16, 12, 24, 1, 1);

INSERT INTO unite (id_unite, nom_unite) VALUES
(1, "portion"),
(2, "g"),
(3, "cuillère à soupe"),
(4, "cuillère à café"),
(5, "kg"),
(6, "mg"),
(7, "L"),
(8, "cl"),
(9, "dl"),
(10, "poignée"),
(11, "none"),
(12, "à votre convenance");