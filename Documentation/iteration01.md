# Bilan de l'itération 01 

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 1 : Initialisation 
    - bot niveau 1 (il a déjà des cartes en main)
    - conception bot niveau 1 (choisir entre 2 cartes)
    - début du jeu (lié au contrôleur de jeux)
    - fin du jeu (lié au contrôleur de jeux)
    - création du moteur de jeu (contrôleur ou arbitre)
    - création de cartes bâtiment (2 ou 3 carte avec un nom, un id et un nombre de point de victoir)

## Fonctionnalité et Issues

Nous avons commencé à créer le premier Bot. Chaque joueur créer a un nom et une liste de cartes de bâtiments. Notre classe "partie" permet de gérer le début et la fin d'une partie. Il y a une méthode "lancer parti" qui boucle et elle vérifie à chaque fois si les joueurs on un score supérieur a une certaine valeur, si c'est le cas, ce la signifie que la partie est finie.

Par rapport aux issues, nous avons rajouté surtout des sous-tâches et des tâches. Mais elles ont toutes étaient terminées.

## Test

Pour les tests, nous en avons créé plusieurs pour tester la méthode de fin de partie. 
Il y a aussi des tests pour la classe joueur et nous avons un main principale ou une partie se déroule. 

## Organisation du code 

Nous avons décomposé le projet en plusieurs packages pour découper le code.
Voici la liste des packages ainsi que les class associé :
- Package 'carte' qui contient la classe Carte, CarteBatiment et CarteOuvrier
- Package 'partie' qui contient la classe Partie et Main
- Package 'joueur' qui contient la classe Bor et Joueur