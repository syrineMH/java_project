# java_project
L'exercice consiste à faire un moteur de recherche de base.
On dispose d'un un  fichier texte. On veut chercher les numéros des lignes qui contiennent un ensemble de mots non forcément les unes à coté des autres tapés par l'utilisateur.
Le projet est constitué deux packages.

1-utils: contient une classe  TextSplit qui contient des méthodes qui permettent de séparer et traiter les mots d'une chaine de caractère.

2-ds.searchengine.tool qui contient les classes de fonctionalités  de base:
  
  #####  classe MapText:
la responsabilité de cette classe est de lire un fichier texte et de creer à partir de ce fichier un fichier json qui contient
pour chaque mot du fichier initial l'ensemble des numéros des lignes ou le mot a été apparu.

     Map<String, Set<Integer>> getWordLineNumbers(String filepath):
Prend en paramètre un path du fichier entré et retourne une collection map
ou les clés sont les mots et les valeurs sont l'ensemble des numéros des lignes ou le mot apparu.

    createJsonFile(Map<String, Set<Integer>> map, String filepath):
À partir d'une collection map on cree un fichier json.

#####  classe App: 
le point d'entrée de notre application.



    Set<Integer> searchLineNumbers(Map<String, Set<Integer>> map, String[] words):
cette méthode prend en entrée une collection map qui représente en clé les mots et en
valeur l'ensemble de numéros des lignes ou le mot a éte apparu. et un array de string qui représente les mots de recherche.
la fonction retourne les lignes qui contiennent tous les mots de l'array Words.

    Map<String, Set<Integer>> readJsonToHashMap(String filepath):
À partir du fichier json s'il existe (sinon elle génère le json en faisant appel à la classe Map Text).
elle recrée une collection Map. Ceci permet de lire le fichier texte de départ une seule fois et faire d'autant de requêtes qu'on veut.

    public static void main(String[] args)

la fonction main notre point d'entrée, j'ai essayé de faire une simple expérience utilisateur
Très basiques pour faire plusieurs qu'ne requête à chaque fois en exécute le programme.


#### AppTest
C'est une classe de test, j'ai essayé de faire un test unitaire et un test end2end.
Par contrainte de temps, j'ai voulais respecter la contrainte du temps et par suite j'ai pas pu aller
plus loins dans les tests.
Etant donnée, l'importance des tests et comme mesures d'amélioration, il faut ajouter des tests
et assurer une bonnes couvrance de tous les uses cases.