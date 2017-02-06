# Doc pour le front:

### Créer un client:

Le nom des clients est limité 6 caratères !!!!!

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


##Passer une commande:

**Requête**

    POST http://localhost:8080/order
      {
        "client": {
          "login": "johnny",
          "password": "begood",
          "firstName": "begood",
          "lastName": "johnny",
          "paymentServiceId": 84,
          "paymentServiceToken": "ehb9tb69j05jssl",
          "providerServiceId": "5897a63046e0fb0005f35903"
        },
        "recipientAddress": {
          "streetNumber": "9",
          "street": "rue philippe marcombe",
          "zip": "63000",
          "city": "Clermont-Ferrand"
        },
        "cart": {
          "productWithQties": [
            {
              "product": {
                "id": "5839bd82a5ff1f00040367c4",
                "name": "Nexus 6P",
                "description": "Smartphone Android, 32G (Aluminium)",
                "price": 350,
                "quantity": 52,
                "image": "http://www.android.gs/wp-content/uploads/2015/12/Nexus-5X-600x337.jpg",
                "available": true
              },
              "quantity": 2
            }
          ]
        }
      }

**Réponse**

    ???
    
    
##Suivre un colis

**Requête**

    GET http://localhost:8080/tracking/{shippingId}

**Réponse**

    ???