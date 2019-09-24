les tests unitaires sont dans le package: src.test.java.com.gafah.panier.repository

les test integrales sont dans le package src.test.java.com.gafah.panier.web

selon l'énoncé

Produisez un api REST qui permet les scénarios suivants:

1) Afficher un catalogue de produits (Class = ProductyController, method = getAllProducts)
2) Afficher le détail d’un produit    (Class = ProductyController, method = getProductById)
3) Ajouter un produit au panier       (Class = PanierController, method = createOrUpdatePanier)
4) Enlever un produit du panier      (Class = PanierController, method = deletePanierById)
5) Afficher le contenu du panier      (Class = PanierController, method = getAllPaniers)
6) (Bonus) Connexion et déconnexion à un compte utilisateur  (Conexion, Class = UserController,  method = getUser)


Installation
1) Installer jdk 1.8.xx du site web www.oracle.com
2) create a variable: $export JAVA_HOME=Your path
3) Ouvrir un terminal  bash (linux) ou cmd (windows)
4) Aller au path oú le jar se trouve 
5) Taper le suivant "java -jar exercise-0.0.1-SNAPSHOT"
6) Ouvrir un lien sur le browser et taper, et voir tous les produits localhost:8080/products
7) Ouvrir un lien sur le browser et taper localhost:8080/paniers

	
	voir tout le panier (GET)
	http://localhost:8080/paniers

	Ajouter 1 produit au panier (POST)
	http://localhost:8080/paniers/save/1
	http://localhost:8080/paniers/save/2

	Effacer 1 produit du panier (DETELE)
	http://localhost:8080/paniers/delete/1
	