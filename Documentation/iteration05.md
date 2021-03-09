# Bilan de l'itération 06

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

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
    
## Fonctionnalité et Issues


<p>
    Pendant ce sprint, nous avons ajouté des arguments qui nous permettent d'indiquer le mode de jeu que l'on veut et le nombre de parties. Nous indiquons aussi, si l'on veut voir afficher la trace du jeu et l'affichage des statistiques. Plusieur Exec ou aussi était ajouté (lancer 1 partie -> '1PartieMA' ou lancer 500 parties -> '500PartieMA' ou par défaut).
</p>
<p>
À la fin de chaque partie, les joueurs peuvent voir leurs statistiques, et à la fin de toutes les parties, ils voient leurs statistiques globaux.
</p>
<p>
Le changement des bots en stratégies a aussi était effectué.
</p>
<p>
La partie a maintenant un argument 'ModeDeJeu' qui exprime si on joue au Bâtisseur du Moyenne-Age ou de l'Antiquité. Nous avons aussi créé les nouvelles classes des cartes de ce dernier mode de jeu (esclave, outils, université et emprunt).
</p>
<p>
Notre stratégie basique ne nous permet pas d'atteindre 17 points de victoire. Nous avons commencer a le modifier et nous devrons continuer. De même pour la stratégie moyenne. 
</p>
<p>
Enfin, nous avons rajouté un logger pour gérer l'affichage.</p>
<p>
Cependant, nous n'avons pas réussi à trancher pour la modification de la  CarteFactory en fonction du mode de jeu.
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

Nous avons décomposé le projet en plusieurs packages pour découper le code.
Voici la liste des packages ainsi que les class associé :
- Package 'carte' qui contient la classe Carte, CarteBatiment, CarteOuvrier, PileDeCarte, CarteMachine, CarteEmprunt, CarteEsclave, CarteOutils, IConvertionCarte,  CarteRessource, CarteUniversite et CarteFactory.
- Package 'partie' qui contient la classe Partie ,ModeDeJeu(enum) , Arguments et Main.
- Package 'joueur' qui contient la classe Strategie StrategieBasique, StrategieHard, StrategieMedium, StrategieInteligent et Joueur.
- Package 'operation' qui contient la classe OpAchatNouvelleAction, OpAffectationBatiment,  OpAffectationOuvrier, OpAffectationOuvrierBatiment, OpObtenirEcu et Operation.
- Package 'statistique' qui contient la classe Statistique, StatistiqueJoueur et StatistiqueParties.
- Package 'logger' qui contient la classe LoggerTrace et SimpleLogger.
