# Bilan de l'itération 08

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 8 :
    - Adaptation du projet au client/server 
    - Modification des stratégie basique et medium
    - Ajout de stratégie pour le mode de jeu "Antiquité"
    - Modifier la partie pour prendre en compte le mode de jeu "Antiquité" (surtout la fin de la partie)
    
## Fonctionnalité et Issues


<p>
    Lors de ce sprint, nous avons découpé le projet en deux branches. La branche master correspond au projet avec client et serveur et la branche 'sansCS' est le projet sans le client et le serveur.
</p>
<p>
   Pour le client et le serveur, nous avons commencé à mettre en place l'échange de cartes présentes et d'opérations. Nous avons réussi à faire échanger l'inventaire du joueur du serveur aux clients. 
</p>
<p>
    Dans le projet sans clients et serveur, nous avons réussi à mettre en place plusieurs choses. Les stratégies basiques nous permettent d'atteindre 17 points de victoire, de même pour les stratégies médiums. De plus, cette dernière a effectivement plus de chance de gagner (voir les statistiques de fin de partie).
</p>
<p>
   Nous avons commencé à créer des stratégies pour l'antiquité (pour l'instant elles sont similaires à celle du moyenne âgée).
</p>
<p>
    Lors de la fin d'une partie, nous effectuons un décompte final. Dans celle-ci, nous laissons le joueur affranchir ses esclaves ou rembourser ses emprunts. Ensuite, nous supprimons les points de victoire en fonction des esclaves non affranchis et des emprunts non remboursés. Ses actions sont prises en compte en fin de partie, cependant nos stratégies n'ont pas encore implémenté les décisions que prendrons les joueurs.
</p>
<p>
    Enfin, en fonction du mode de jeux, le nommage à était mis en place, de même pour les couleurs d'affichage, chaque joueur a une couleur en particulier et de même pour la partie. Nous avons aussi modifié les messages d'affichage et avons ajouter un esclave ou un apprenti lorsque l'ont commence une partie (en fonction du mode de jeu).
</p>
<p>
    Nous avons aussi rajouté une factory de stratégie.</p>
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

<p>
    Par rapport à l'organisation, nous avons deux branches.
</p>

    - Pour la branche master, nous avons décomposé le projet en plusieurs modules :
        - "client", ce module contient les classes de joueur, de stratégie et une partie clientReseau.
        - "server", ce module contient les factorys de carte ainsi qu'un moteur, une partie, un serveur et une serveurReseau.
        - "commun", ce module contient toutes les classes communes aux deux modules. Notamment les opérations, les cartes, les loggers, les identifiants et les statistiques
        - "lanceur", ce module permet de facilement lancer 2 clients et un serveur, cependant il n'est pas utiliser et seras supprimer prochainement.

    - Pour la branche sansCS, nous avons plusieurs packages :
        - "carte", ce package contient toutes les cartes.
        - "factory", ce package contient les factorys de carte et de stratégie.
        - "Joueur", ce package contient la classe joueur et les stratégies du joueur.
        - "mainJoueur", ce package n'est pas utilisé pour l'instant.
        - "nommage", ce package contient des classes de nommage pour chaque mode de jeu.
        - "operation", ce package contient toutes les opérations qui peuvent être effectué par le joueur.
        - "partie", ce package contient les classes argument, partie, l'énumération ModeDeJeu ainsi que le main. 
        - "Statistique", ce package contient les statistique des joueurs et de la partie.
   





