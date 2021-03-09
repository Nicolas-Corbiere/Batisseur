# Bilan de l'itération 02

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 2 :
    - le joueur a une seule action
    - création de cartes ouvrier
    - tirer carte parmi une pile de cartes
    - bot niveau 1 (bot qui tire la première carte)
    - créer le plateau
    - poser bâtiment sur le plateau
    - poser ouvrier sur le plateau
    - gérer les 5 premiers carte des piles (bâtiment et ouvrier)
    - affichage de l'état du jeu avec des affichages console
    - mise en place de l'aléatoire dans les piles
    - gagner des points quand un bâtiment est fini
    - pouvoir choisir une carte parmi la pile d'ouvriers ou de bâtiment (entre 1 et 5)
    
## Fonctionnalité et Issues

Dans cette itération, nous avons créé un objet "pile de cartes" qui nous permet de gérer facilement des listes de cartes. 
Nous avons aussi créé 2 tableaux: 5 cartes de bâtiment et 5 cartes d'ouvrier.
Ces dernières sont accessibles par le joueur(bot), et il a la possibilité de tirer l'une des cartes.
De plus, la partie ajoute une nouvelle carte lorsqu'un joueur(bot) en tire une dans le tableau correspondant.
Le joueur(bot) a une liste de carte d'ouvrier et il peut affecter un ouvrier à un bâtiment.
Lors de cette itération, nous partons du principe que si un ouvrier est affecté à un bâtiment, celui-ci se termine. 
Dans ce cas, le joueur(bot) récupère les ouvriers qui y étaient affectés au bâtiment et il gagne les points de victoire marqués sur la carte Bâtiment terminée.
La partie se termine lorsqu'un joueur obtient 3 points.
Actuellement, les Bots tirent la première carte de la ligne visible puis au tour suivant tirent un ouvrier. Ensuite, ils l'affectent au bâtiment de leur main lors du prochain tour et ainsi de suite.

Par rapport aux issues, nous avons ajouté quelques issues et elles ont toutes étaient terminées.

## Test

Pour les tests, nous en avons créé plusieurs pour tester la méthode de fin de partie. 
Il y a aussi des tests pour la classe joueur et nous avons un main principale ou une partie se déroule. 

## Organisation du code 

Nous avons décomposé le projet en plusieurs packages pour découper le code.
Voici la liste des packages ainsi que les class associé :
- Package 'carte' qui contient la classe Carte, CarteBatiment et CarteOuvrier
- Package 'partie' qui contient la classe Partie et Main
- Package 'joueur' qui contient la classe Bor et Joueur