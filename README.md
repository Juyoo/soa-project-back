# Doc pour le front:

### Créer un client:
**Requête**

    POST http://localhost:8080/client/register
    {
    	"lastName": "sandman",
    	"firstName": "mister",
    	"login": "mister",
    	"password": "sandman"
    }

**Réponse**

    {
      "login": "mister",
      "password": "sandman",
      "firstName": "mister",
      "lastName": "sandman",
      "paymentServiceToken": "kmo8i2vk1fs1jca",
      "providerServiceId": "5897567146e0fb0005f358f0"
    }
    
Etant donné que sur l'API des produit il n'y as aucune facon de retrouver l'ID d'un client a partir de ses info, a chaque fois qu'on veut utiliser un client il faut en recréer un.

###Liste des produits:

**Requête**

    GET http://soa-provider.hhacherouf.info/api/products
    
**Réponse**

    [
        {
          "id" : "5839bd82a5ff1f00040367c4",
          "name" : "Nexus 6P",
          "description" : "Smartphone Android, 32G (Aluminium)",
          "price" : 350.0,
          "quantity" : 52,
          "image" : "http://www.android.gs/wp-content/uploads/2015/12/Nexus-5X-600x337.jpg",
          "available" : true
        },
        ...
    ]


##Passer une commande: (TODO)
Le serveur back doit :
 - appeler la méthode createBill() du provider pour enregistrer la facture
 - appeler la méthode addTransac() ()et peut être même validTransac) du payment pour enregistrer le payment.
 - appeler la méthode je sais pas quoi du service de livraison.

**Requête**

    POST http://localhost:8080/order
    {
        "client": {
            "login": "mister",
            "password": "sandman",
            "firstName": "mister",
            "lastName": "sandman",
            "paymentServiceToken": "kmo8i2vk1fs1jca",
            "providerServiceId": "5897567146e0fb0005f358f0"
        },
        "cart": {
            "productWithQties": [
                {
                    "product": {
                        "id": "5839c02aa5ff1f00040367c5",
                        "name": "Lumia 950",
                        "description": "Smartphone Windows",
                        "price": 299.99,
                        "quantity": 21,
                        "image": "http://mynokiablog.com/wp-content/uploads/2013/07/phab--600x337.jpg",
                        "available": true
                    },
                    "quantity": 1
                }
            ]
        },
    }

**Réponse**

    ???