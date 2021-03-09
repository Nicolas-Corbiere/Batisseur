# Liste des itérations du projet Les batisseurs Moyen-Age

Groupe Bat20-I

## Note : 
- Stratégie de niveau 1 : prend la première carte batiment et la fini
- Stratégie de niveau 2 : prend la carte avec le meilleur points de victoire 
- Stratégie de niveau 3 : prend la carte batiment la plus rentable

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
### itération 3 :
    - gestion d’une seule ressource (construction de bâtiment avec les ouvriers)
    - mettre a jour les classes existante
    - affichage de l'état du jeu avec des affichages console
    - bot niveau 2 
    - gestion stats
    - création d'une fabrique
    - gestion écu basique (payer ouvrier et gagner pour fin bâtiment)
    - initialisation de toutes les cartes (parti 1/2)
    - récupère écu
    - bot niv 3 (instanciation)
    - Mise en place des opérations (début)
### itération 4 :
    - initialisation de toutes les cartes (parti 2/2)
    - nettoyage du code superflu + réorganisation
    - gestion stats
    - bot niveau 2 
    - bot niveau 1 (ajout des nouvelles méthodes)
    - bot niveau 3
    - gestion de toutes actions
    - rajouter toutes les ressources
### itération 5 :
    - Rapport intermédiaire
    - ajout des machines dans les cartes
### itération 6 :
    - ajout d'argument au main (nbPartie, affichage de la trame et affichage des statistiques)
    - ajout de plusieur exec
    - Ajout des statistique globale pour N parties
    - changement des bots en stratégies
    - Modifier la partie pour prendre en compte le mode de jeu "Antiquité"
    - Ajout des nouvelles classe de carte pour le mode de jeu "Antiquité"
    - Modification de la stratégie basique
    - Modification de la stratégie moyen
    - ajout de logger
### itération 7 :
    - Ajout des nouvelles carte pour le mode de jeu "Antiquité"
    - Modification du pom pour prendre en compte la multimodalité
    - création des modules client, serveur et commun
    - création de la classe réseau client
    - création de la classe réseau serveur
    - ajout de couleur dans la trace 
    - adaptation des noms en fonction du mode de jeu
### itération 8 :
    - Adaptation du projet au client/server 
    - Modification des stratégie basique et medium
    - Ajout de stratégie pour le mode de jeu "Antiquité"
    - Modifier la partie pour prendre en compte le mode de jeu "Antiquité" (surtout la fin de la partie)
### itération 9:
    - Modification des stratégies Hard
    - Soutenance final (création de diagrammes)
    - Faire echanger une operation du client au serveur
    - Adapter les statistiques pour le modèle client/serveur
    - Adapter des stratégie pour le mode de jeu 'Antiquité'
    - Ajouter les modification de sansCS dans master
    
