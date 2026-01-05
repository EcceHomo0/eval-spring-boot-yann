Ajout d'un produit

Méthode HTTP : POST

URL : 
http://localhost:8080/api/produits

Body valide :
{
"nom": "Smartphone",
"prix": 399.99,
"categorie": {
"id": 1
}
}

Body non valide (nom trop court) :
{
"nom": "TV",
"prix": 899.99,
"categorie": {
"id": 1
}
}




Afficher tous les produits

Méthode HTTP : GET

URL :
http://localhost:8080/api/produits



Afficher une catégorie par son ID

Méthode HTTP : GET

URL :
http://localhost:8080/api/categories/{id}

