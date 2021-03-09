# Bilan de l'itération 04

Groupe Bat20-I

## Membres : 
- Alcaraz Yannick
- Rethers Mathieu
- Lemoine Alexandre
- Deslandes Lisa
- Corbière Nicolas 

### itération 4 :
    - initialisation de toutes les cartes (parti 2/2)
    - nettoyage du code superflu + réorganisation
    - gestion stats
    - bot niveau 2 
    - bot niveau 1 (ajout des nouvelles méthodes)
    - bot niveau 3
    - gestion de toutes actions
    - rajouter toutes les ressources
    
## Fonctionnalité et Issues


<p>
Pendant ce sprint, nous avons ajouté toutes les ressources aux cartes, et avons ajouté toutes les cartes aux jeux.
</p>
<p>
Nous avons aussi modifié le comportement des bots. L'équipe a créé une classe abstraite 'bot intelligent' qui nous permet de regrouper les bots de niveau 2 et 3 ainsi que de leur ajouter des méthodes commun.
</p>
<p>
Le bot de niveau 2 applique la stratégie de 'prendre la meilleure carte' autant pour les bâtiments que pour les ouvriers. (Pour les bâtiments, il prend celle qui a le plus de points de victoire, et pour les ouvriers il prend celui qui rapporte le plus de ressources )
</p>
<p>
Nous avons avancé dans l'implémentation du bot de niveau 3, mais il n'est pas encore fonctionnel.
</p>
<p>
Actuellement, l'affectation d'ouvriers à des bâtiments n'est pas encore intelligent. On prend le premier ouvrier et on l'affecte a notre premier batimant.
</p>
<p>
Lors de l'affectation d'ouvrier, le joueur doit payer un certain nombre d'écus et il a aussi la possibilité d'obtenir des écus contre une ou plusieurs actions.  
</p>
<p>
Les joueurs ont maintenant 3 actions par tours et ils ont aussi la possibilité d'en acheter. De plus, lors d'un tour, si le joueur affecte plusieurs ouvriers a un même bâtiment lors d'un même tous, il devra payer de plus en plus d'action. </p>
<p>
Pour la gestion des statistiques, nous les avons toutes incrémentées sauf pour les machines (car elles ne sont pas encore utiliser). L'affichage se fait en fin de partie si le joueur le désire.
</p>
<p>
Pour finir, chaque membre a réorganisé le code en plus de commencer à analyser leurs codes avec SonarLint.
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

## Organisation du code 

Nous avons décomposé le projet en plusieurs packages pour découper le code.
Voici la liste des packages ainsi que les class associé :
- Package 'carte' qui contient la classe Carte, CarteBatiment, CarteOuvrier, PileDeCarte, CarteMachine et CarteFactory
- Package 'partie' qui contient la classe Partie et Main
- Package 'joueur' qui contient la classe BotBasique, BotHard, BotMedium, BotInteligent et Joueur
- Package 'operation' qui contient la classe OpAchatNouvelleAction, OpAffectationBatiment,  OpAffectationOuvrier, OpAffectationOuvrierBatiment, OpObtenirEcu et Operation
- Package 'statistique' qui contient la classe Statistique
