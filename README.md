<h3 align="center">Projet Java périscolaire</h3>

### Présentation du projet
***
Projet de réalisation d'une plate-forme périscolaire en Java.<br/>
Nous avons choisi d'implémenter la partie cantine de la plate-forme c'est à dire la partie calendrier et abonnement.<br/>

### Use Cases
***
La page d'accueuil est page de connexion, il y a deux types de connexion :
* Les employés de mairie (les identifiants sont dans le fichier bdd/employe.bdd)
* Les parents d'élèves (les idenfiants sont dans le dossier bdd/parent l'idenfiant est le nom du fichier et le mot de passe est la deuxième ligne)<br/><br/>
Les use cases de l'employe de mairie sont :
* Ajouter un jour avec un menu dans le calendrier (il faut appuyer sur la touche ctrl pour selectionner plusieurs ingrédients)
* Supprimer un jour du calendrier
* Afficher les informations du menu d'un jour<br/><br/>
Les use cases d'un parent d'élève sont :
* Modifier l'abonnement cantine d'un de ses enfants
* Afficher le calendrier des menus
* Afficher les informations du menu d'un jour

### Base de donnée
***
Nous avons choisi de stocker toutes les données dans des fichiers .bdd où toutes les informations sont écrites directmenet en clair.<br/>
Pour se faire nous avons eu recours à plusieurs fichiers :
* abonnement.bdd : La liste des abonnements possibles, chaque ligne est sous la forme Nom+Description.
* aliment.bdd : La listes des aliments disponibles lors de la création d'un menu.
* employe.bdd : La liste d'identifiants d'emplloyes.
* cantine.bdd : Première ligne : horaires. Deuxième ligne : adresse. Autres lignes menu d'un jour (Année+Mois+Jour+Nom menu+ingrédients)
* parent/ : Chaque fichier parent est de nom identifiant.bdd. Première ligne : Nom+Prénom. Deuxième ligne : mot de passe. Autres lignes : enfants (Nom+Prénom+type d'abonnement)

### Choix d'implémentation
***
Nous avons choisi travailler avec le modèle MVC (model - view - controller) : chaque page a deux classes, sa vue et son controlleur et chaque objet a une classe dédiée dans le modèle.<br/>
Lors d'un changement de page, le controleur appelle un autre controleur avec sa méthode _beginPage_ en se mettant en argument. Il y a retour à cette page quand le controleur fils appelle la méthode _endPage_ du controleur père.

