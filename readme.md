les tests unitaires sont dans le package: src.test.java.com.gafah.panier.repository

les test integrales sont dans le package src.test.java.com.gafah.panier.web

selon l'énoncé

Produisez un api REST qui permet les scénarios suivants:

• Afficher un catalogue de produits (Class = ProductyController, method = getAllProducts)
• Afficher le détail d’un produit    (Class = ProductyController, method = getProductById)
• Ajouter un produit au panier       (Class = ProductyController, method = createOrUpdateProduct)
• Enlever un produit du panier      (Class = ProductyController, method = createOrUpdateProduct)
• Afficher le contenu du panier      (Class = ProductyController, method = )
• (Bonus) Connexion et déconnexion à un compte utilisateur  (Conexion, Class = ProductyController,  method = getUser)


Installation
1) Installer jdk 1.8.xx du site web www.oracle.com
2) Ouvrir un terminal  bash (linux) ou cmd (windows)
3) Aller au path oú le jar se trouve 
3) Taper le suivant "java -jar exercise-0.0.1-SNAPSHOT"
3) Ouvrir un lien sur le browser et taper localhost:8080/products

ProductyController
 
 
 createOrUpdateProduct
 deleteProductById
 
 
  UserController 
getUser(@
	