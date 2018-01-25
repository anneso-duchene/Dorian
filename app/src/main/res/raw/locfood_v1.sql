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
(13, "gousse d\'ail", "all"),
(14, "oignion", "all"),
(15, "lait", "all"),
(16, "crème fraiche épaisse", "all"),
(17, "maïzena", "all"),
(18, "huile d\'olive", "all"),
(19, "fromage râpé", "all"),
(20, "cumin", "all"),
(21, "curry", "all"),
(22, "paprika", "all"),
(23, "poivre ", "all"),
(24, "gingembre", "all"),
(25, "sel", "all"),
(26, "champignon de Paris", "automne"),
(27, "sucre en poudre", "all"),
(28, "alcool de fraise", "all"),
(29, "gélatine", "all"),
(30, "fraise", "ete"),
(31, "citron", "all"),
(32, "crème liquide", "all"),
(33, "sucre vanillé", "all"),
(34, "boudoir", "all"),
(35, "topinambour", "hiver"),
(36, "pommes de terre", "hiver"),
(37, "chapelure", "all"),
(38, "gruyère râpé", "all"),
(39, "navet", "printemps"),
(40, "sucre en poudre", "all"),
(41, "beurre", "all");


INSERT INTO recette (id_recette, nom_recette, nombre_personne, temps_total, temps_prepa, temps_cuisson, etapes, saison, tags) VALUES
(1, "Lasagnes de chou vert frisé", 4, "00:45:00", "00:25:00", "00:20:00", "Etape 1\r\n-------\r\nPréparer une béchamel light : dans une petite casserole, faire fondre la crème fraiche. Dès les premières bulles, ajouter la maizena puis le lait, un peu de sel et de poivre (et de noix de muscade si vous avez) et laisser épaissir en touillant. Couper le feu des que la béchamel commence à prendre.\r\n\r\nEtape 2\r\n-------\r\nPréparer la sauce tomate : dans une casserole, faire chauffer l\'huile et y faire revenir l\'ail écrasé, l\'oignon, le tofu coupé en tout petits dés, et les champignons. Ajouter les épices.\r\n\r\nEtape 3\r\n-------\r\nUne fois que c\'est bien roussis et que le tofu a pris le goût des épices, ajouter les tomates coupées en petits dés et le concentré de tomates avec un demi-verre d\'eau.\r\nEtape 4\r\n-------\r\nPréchauffer le four à 250°C (thermostat 8).\r\n\r\nEtape 5\r\n-------\r\nDresser les lasagnes : dans un plat à gratin, disposer une couche de feuille de choux, puis une couche de tomate (la moitié de la préparation), puis une couche de béchamel (un tiers). Recommencer encore une fois et terminer par une couche de choux et le dernier tiers de béchamel.\r\n\r\nEtape 6\r\n-------\r\nParsemer d\'un peu de gruyère râpé.\r\nEtape 7\r\n-------\r\nEnfourner pendant 20-25 minutes. C\'est prêt quand l\'eau rendue par le chou est évaporée et que le dessus est bien doré. Le chou doit rester croquant.", "automne", "Facile |Bon marché | Plat principal | Végétarien"),
(2, "Charlotte aux fraises", 6, "01:00:00", "01:00:00", "00:00:00", "Etape 1\r\n-------\r\nPréparer un sirop en portant à ébullition 15 cl d\'eau et 80 g de sucre. Ôter du feu et laisser refroidir, ensuite y mettre l\'alcool de fraise.\r\n\r\nEtape 2\r\n-------\r\nFaire tremper la gélatine dans un bol d\'eau froide.\r\n\r\nEtape 3\r\n-------\r\nLaver et équeuter les fraises et en mettre 8 entières de côté.\r\nMettre les autres fraises dans un mixeur avec le jus de citron et mixer jusqu\'à obtenir une purée lisse. Transvaser cette purée dans une passoire afin de récolter le coulis et retenir les grains.\r\n\r\nEtape 4\r\n-------\r\nPrélever un quart de ce coulis et le faire chauffer doucement dans une casserole en y incorporant la gélatine essorée et le restant de sucre.\r\n\r\nEtape 5\r\n-------\r\nEnsuite, mélanger le coulis obtenu (chaud) avec le coulis froid. Laisser tiédir à température ambiante.\r\n\r\nEtape 6\r\n-------\r\nMettre la crème liquide dans un saladier et mettre au congélateur 20 min. Puis la fouetter de façon à obtenir une crème chantilly. Mettre le sucre vanillé, remuer doucement et mettre en attente au frais.\r\n\r\nEtape 7\r\n-------\r\nPlacer le récipient où se trouve le coulis dans un récipient + grand rempli de glaçons. Remuer le coulis jusqu\'à constater son épaississement. A ce moment, l\'ôter des glaçons et y ajouter la chantilly en tournant délicatement. Laisser à température ambiante.\r\n\r\nEtape 8\r\n-------\r\nCouper les 8 fraises mises de côté dans leur hauteur.\r\nTapisser le fond et les parois du moule avec des boudoirs trempés (vite fait) dans le sirop (les tailler si besoin). Pour les parois : côté bombé contre le moule.\r\n\r\nEtape 9\r\n-------\r\nVerser un tiers de la crème puis parsemer de fraises coupées (la moitié).\r\n\r\nEtape 10\r\n-------\r\nCouvrir du second tiers de crème, disposer le restant de fraises coupées. Terminer par le dernier tiers de crème. Finir par une couche de biscuits (toujours trempés dans le sirop).\r\n\r\nEtape 11\r\n-------\r\nMettre du film plastique sur le plat et laisser au frais 6h (une nuit est l\'idéal) avant de démouler.", "ete", "Dessert |Bon marché | Difficile"),
(3, "Gratin de topinambours", 2, "00:40:00", "00:10:00", "00:30:00", "Etape 1\r\n-------\r\nPeler les topinambours et les pommes de terre.\r\n\r\nEtape 2\r\n-------\r\nLes couper en grosses rondelles.\r\n\r\nEtape 3\r\n-------\r\nLes faire cuire à la vapeur.\r\n\r\nEtape 4\r\n-------\r\nPréchauffer le four à 200°C (thermostat 6-7).\r\n\r\nEtape 5\r\n-------\r\nÉcraser à la fourchette ou au presse-purée.\r\n\r\nEtape 6\r\n-------\r\nVerser 10 cl de crème liquide, bien mélanger. Le mélange doit avoir la consistance d\'une purée épaisse, Ajouter de la crème si nécessaire.\r\n\r\nEtape 7\r\n-------\r\nVerser dans un plat à gratin.\r\n\r\nEtape 8\r\n-------\r\nSaupoudrer de chapelure puis de fromage râpé.\r\n\r\nEtape 9\r\n-------\r\nFaire gratiner 10 minutes environ au four.", "hiver", "Accompagnement | Végétarien | Four | Facile |Bon marché"),
(4, "Navets caramélisés", 4, "00:25:00", "00:10:00", "00:15:00", "Etape 1\r\n--------\r\nEpluchez et lavez les navets.\r\n\r\nEtape 2\r\n--------\r\nDans une casserole, portez de l\'eau à ébullition et mettez-y les navets à cuire 10/15 min selon leur grosseur (vérifier la cuisson avec la pointe d\'un couteau, comme pour les pommes de terre).\r\n\r\nEtape 3\r\n--------\r\nEgouttez-les lorsqu\'ils sont cuits.\r\n\r\nEtape 4\r\n--------\r\nDans une poêle, faire chauffer un peu de beurre, y faire revenir les navets pour qu\'ils dorent et saupoudrer de sucre. Remuer. Ajouter un petit peu d\'eau (10 cl) pour finaliser. Faire revenir les navets jusqu\'à ce que tout soit évaporé dans la poêle.\r\n\r\nEtape 5\r\n--------\r\nServez avec un confit de canard par exemple, un régal", "printemps", "Accompagnement | Végétarien | Très facile | Bon marché ");

--
-- Déchargement des données de la table `recette_ingredient`
--

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
(16, 12, 24, 1, 1),
(27, 2, 27, 2, 140),
(28, 3, 28, 2, 1),
(29, 13, 29, 2, 6),
(30, 2, 30, 2, 500),
(31, 11, 31, 2, 1),
(32, 8, 32, 2, 40),
(33, 14, 3, 2, 1),
(34, 11, 34, 2, 26),
(35, 2, 35, 3, 400),
(36, 2, 36, 3, 400),
(37, 8, 32, 3, 10),
(38, 2, 37, 3, 200),
(39, 2, 38, 3, 200),
(40, 2, 39, 4, 500),
(41, 3, 40, 4, 1),
(42, 2, 41, 4, 10);

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
(12, "à votre convenance"),
(13, "feuille"),
(14, "sachet");
