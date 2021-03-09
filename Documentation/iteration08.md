# Bilan de l'itération 09

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 9 :
    - Modification des stratégies Hard
    - Soutenance final (création de diagrammes)
    - Faire echanger une operation du client au serveur
    - Adapter les statistiques pour le modèle client/serveur
    - Adapter des stratégie pour le mode de jeu 'Antiquité'
    - Ajouter les modification de sansCS dans master
    
## Fonctionnalité et Issues


<p>
    Lors de ce dernier sprint, nous avons mis en place le lancement d'une partie à travers un client serveur.
</p>
<p>
    Nous avons réussi l'échange d'opérations d'un client à un serveur. Nous avons aussi fait une boucle pour pouvoir lancer plusieurs parties. Il existe aussi plusieurs exec pour pouvoir lancer une ou 500 parties du moyen âge ou de l'antiquité.
</p>
<p>
    Nous avons aussi ajouté les éléments de la branche "sansCS" dans la branche master. Toutes les stratégies et opérations on donc était ajouté et adapter. Les arguments et statistique on aussi était ajouter ainsi que l'assignement d'un outil. 
</p>
<p>
    De la javaDoc a été ajouter à la plupart des méthodes et classes. 
</p>
<p>
    Enfin, le décompte final se fait de manière automatique et les stratégies sont sélectionnées de manière aléatoire. Il y a 50% de chance de tomber sur un basique, 30% sur un medium et 20% sur un hard.    
</p>
<p>
    Cependant, l'affichage de couleur ne marche pas dans la branche master, alors que dans sasnCS ça marche, de même, et nous avons un problème lors de l'affectation d'outils, d'esclave, d'emprunt et d'université.
</p>

    
## Test
<p>
    Pour les tests dans la branche sansCS, nous en avons créé plusieurs pour tester la méthode de fin de partie.
</p>
<p>
    Il y a aussi des tests pour la classe joueur et les classes d'opération.
</p>
<p>
    De plus, nous avons une intégration continue qui nous permet de détecter les erreurs de build, de test unitaire ou lors de l'exécution du projet.
</p>
<p>
    La javaDoc a aussi était rajouter.
</p>
<p>
    Cependant, la connexion serveur/client n'a pas était tester.
</p>

## Organisation du code 

<p>
    Par rapport à l'organisation, nous avons deux branches.
</p>

    - Pour la branche master, nous avons décomposé le projet en plusieurs modules :
        - "client", ce module contient les classes de joueur, de stratégie et une partie clientReseau.
        - "server", ce module contient les factorys de carte ainsi qu'un moteur, une partie, un serveur et une serveurReseau.
        - "commun", ce module contient toutes les classes communes aux deux modules. Notamment les opérations, les cartes, les loggers, les identifiants et les statistiques
    
    - Pour la branche sansCS, nous avons plusieurs packages :
        - "carte", ce package contient toutes les cartes.
        - "factory", ce package contient les factorys de carte et de stratégie.
        - "Joueur", ce package contient la classe joueur et les stratégies du joueur.
        - "mainJoueur", ce package permet de manipuler les mùain du joueur.
        - "nommage", ce package contient des classes de nommage pour chaque mode de jeu.
        - "operation", ce package contient toutes les opérations qui peuvent être effectué par le joueur.
        - "partie", ce package contient les classes argument, partie, l'énumération ModeDeJeu ainsi que le main. 
        - "Statistique", ce package contient les statistique des joueurs et de la partie.
   





