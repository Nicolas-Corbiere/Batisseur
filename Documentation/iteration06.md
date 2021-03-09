# Bilan de l'itération 07

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 7 :
    - Ajout des nouvelles carte pour le mode de jeu "Antiquité"
    - Modification du pom pour prendre en compte la multimodalité
    - création des modules client, serveur et commun
    - création de la classe réseau client
    - création de la classe réseau serveur
    - ajout de couleur dans la trace 
    - adaptation des noms en fonction du mode de jeu
    
## Fonctionnalité et Issues


<p>
    Pendant cette itération, nous avons commencé à mettre en place le système de client et de serveur. Actuellement, plusieurs clients peuvent se connecter à un serveur. Ce dernier attend que tous les clients soient connectés et met fin à la connexion.
</p>
<p>
    Actuellement, notre projet comporte 3 modules, le client, le serveur et le commun. Le lanceur n'est pas utilisé pour l'instant.
</p>
<p>
    Nous avons aussi commencé à réfléchir sur comment adapter notre projet au modèle "client-serveur".
</p>
<p>
    Le logger à était modifier pour qu'il affiche des messages en couleur. La couleur est donnée lorsque l'on crée l'objet "LoggerTrace". De plus, nous avons ajouté un système de nommage en fonction du mode de jeux. Lorsqu'il s'agit d'une partie du moyen âge, nous parlons d'écus, et s’il s'agit d'une partie de l'Antiquité nous parlons de Sesterces.
</p>
<p>
    Par rapport aux statistiques, la statique finale des N partis s'affiche forcément, même si un joueur ne veut pas afficher ses stats à la fin de chaque partie.
</p>
<p>
    Nous avons commencé à créer une "main" pour les joueurs, celle-ci contient toutes les cartes qu'ils possèdent. De plus, nous avons créé une interface "ICarteFactory", ainsi que deux factorys concrètes, l'une pour le moyen âge et l'autre pour l'antiquité.
</p>
<p>
    Concrètement, lors de cette itération, nous nous sommes concentrés sur la mise en place du serveur et des clients. Lors de la prochaine itération, nous souhaitons adapter le projet au système de client serveur.
</p>


## Test
<p>
Pour les tests, nous en avons créé plusieurs pour tester la méthode de fin de partie. 
</p>
<p>
Il y a aussi des tests pour la classe joueur et nous avons un main principale ou 100 parties se déroule. 
</p>
<p>
De plus, nous avons une intégration continue qui nous permet de détecter les erreurs de build, de test unitaire ou lors de l'exécution du projet.
</p>
<p>
La javaDoc a aussi était rajouter.
</p>

## Organisation du code 

Nous avons décomposé le projet en plusieurs modules :
- "client", ce module contient les classes de joueur, de stratégie et une partie clientReseau.
- "server", ce module contient les factorys de carte ainsi qu'un moteur, une partie, un serveur et une serveurReseau.
- "commun", ce module contient toute les classes commune au deux module. Notamment les opérations, les cartes, les loggers, les identifiants et les statistiques
- "lanceur", ce module permet de facilement lancer 2 clients et un serveur

