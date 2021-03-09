# Bilan de l'itération 03

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

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
    
## Fonctionnalité et Issues


<p>
Lors de cette itération, nous avons mis en place une seule ressource. Ainsi, une carte a un certain nombre de ressources et un bâtiment a un nombre de ressources entreposé actuellement.
</p>
<p>

Les bâtiments se termine lorsque le nombre de ressources apporté par les ouvriers est suffisant.
</p>
<p>
Nous avons continué à afficher la trace du jeu, en plus de le rendre silencieux pour les tests unitaires.
</p>
<p>
Un nouveau Bot a était ajouté, se dernier tire les 3 cartes bâtiment les plus fortes, puis les finis grâce au meilleur ouvrier.
</p>
<p>
Lorsque ces 3 cartes sont finies, il en tire 3 nouvelles de la même manière et ainsi de suite.
</p>
<p>
Nous pouvons consulter les statistiques du jeu. 
</p>
<p>
Nous avons commencé à ajouter la gestion des écus. 
</p>
<p>
Le joueur peut récupérer des écus et payer les ouvriers. 
</p>
<p>
Cependant, nous n'avons pas géré si le joueur n'a pas asses d'écus pour les ouvriers et les bot ne prennent pas la décision de prendre des écus.
</p>
<p>
Enfin, nous avons commencé à créer des classes d'opération qui nous permettra de remonter la décision des joueurs, et ainsi la faire analyser et appliquer par notre gestionnaire de partie.
</p>


## Test
<p>
Pour les tests, nous en avons créé plusieurs pour tester la méthode de fin de partie. 
</p>
<p>
Il y a aussi des tests pour la classe joueur et nous avons un main principale ou une partie se déroule. 
</p>

## Organisation du code 

Nous avons décomposé le projet en plusieurs packages pour découper le code.
Voici la liste des packages ainsi que les class associé :
- Package 'carte' qui contient la classe Carte, CarteBatiment, CarteOuvrier, PileDeCarte et CarteFactory
- Package 'partie' qui contient la classe Partie et Main
- Package 'joueur' qui contient la classe BotBasique, BotHard, BotMedium, BotInteligent et Joueur
- Package 'operation' qui contient la classe OpAchatNouvelleAction, OpAffectationBatiment,  OpAffectationOuvrier, OpAffectationOuvrierBatiment et Operation
- Package 'statistique' qui contient la classe Statistique
