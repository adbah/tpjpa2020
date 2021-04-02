# Projet JPA 2021 Université Rennes1
 Réalisé par : BAH Adama Sira, KONE Rahima et AHOUA Benedicte
 
 # Introduction:
 
- Les Travaux pratiques sur JPA et JAXRS nous ont permis de nous familiariser avec les outils et d’appréhender les problématiques liés à ces deux technologies.
- Pour une bonne compréhension des concepts , nous avons fait un modèle représentant toutes les entités et leurs attributs dans un diagramme pour décrire les responsabilités, le   - comportement et le type de l’ensemble de nos objets
- Nous avons eu besoin de quatre (4) classes pour représenter l’ensemble de nos informations à savoir :
- User : qui est la classe centrale de la gestion des utilisateurs
- Tableau: représente le tableau d’un utilisateur .
- Section : représente l’ensemble des sections d’un utilisateur , contenu dans un tableau.
- Fiche : contient l’ensemble informations d’une fiche (Carte) .

# Diagramme de classes UML:
![](image/)

# Réalisation:
- A partir de ces classes nous avons créé également quatre (4) Entités JPA
- en rajoutant les accesseurs (getter et setter pour chaque attribut ainsi que les constructeurs) , dans le package src/main/java/jpa .
- L’objectif était de persister un objet de chacune de ces classes afin de pouvoir stocker dans la base de données des informations
- Mais aussi de pouvoir les récupérer grâce à des requêtes JPQL.
- A cet effet nous avons utilisé la base de données hsql qui était déjà dans le template du projet pour des problèmes de connexion à la base de donnés local
- N’ayant pas pu trouvé de solution au problème, notre chargé de tp Mr OSCAR nous a donc recommandé d’utiliser celle-ci.
- La classe jpaTest.java contient notre objet entityManager et toutes les implémentations des méthodes permettant de :

  - Créer un utilisateur à partir de la méthode persistUser()
  - Récupérer la liste des utilisateurs à partir de la méthode getUsers()
  - Récupérer la liste des sections en cours à partir de la méthode sectionEncours()
  - Récupérer la liste des sections d’un tableau donnée ( Jointure entre les tables tableau et Sectio) -Récupérer la liste des utilisateursagé de moins de MaxAge à partir de la   - méthode getUsersFomAgeMax()
  - Créer une fiche à partir de la méthode createFiches().
  - Pour l’héritage comme recommandé dans le sujet nous avons choisi le cas d’un sondage dont sondageDate et sondageLieu sont des sous-types de TypeSondage
  - Nous avons utilisé la stratégie Single table c’est à dire une seule table pour une hiérarchie d’héritage .
  - Ainsi nous avons créer les sondages date et Lieu à travers les méthodes et createSondageDate() et createSondageLieu() et recupérer les types de sondage avec le nombre de     - sondage dans chaque type.
  - Problème rencontés :
  - comme indiqué ci-desus on a eu un problème de connexion à la base de données locale - un problème avec le type de l’attibut dateButoir dans l’entité Fiche en utilisant Date   - comme type mais finalement nous avons mis un String à la place .
# Conclusion :
-Nous sommes fière de ce qu’on a pu réaliser dans ces deux tp , même si nous avons galérer car c’était la première fois pour nous de travailler avec ces technologies mais nous avons qu’à même eu l’occasion de les découvrir et à chercher les solution par nous même et résoudre certaines erreurs , pour nous c’était le plus important .

