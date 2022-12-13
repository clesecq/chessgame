# A31-Chessgame 

## Description des choix : 
Nous avons créé 3 classes majeures une pour **l'échiquier** `Chessboard`,
une pour les **pièces** `Piece` et une pour le **joueur** `Player`.

La classe `Piece` a une *couleur* `Color` (Blanc ou Noir), 
le nombre de points que la pièce rapporte une fois manger `punct`, 
une *lettre* (qui deviendra une image plus tard) `letter`
et une *stratégie* `PieceStrategy` qui est la classe mère de tous les types de pièces :
- `KingStrategy`
- `QueenStrategy`
- `RookStrategy`
- `BishopStrategy`
- `KnightStrategy`
- `PawnStrategy`

On utilise aussi :
 - La classe `Chessboard` possède une *vue* `ChessboardView`
 - La classe `Position` possède un axe `x` et `y` ainsi qu'une pièce désignant une des 64 cases du `Chessboard`.
 
Nous utilisons aussi un *observer* de mouvement `MoveObserver`. Ce dernier interferat lorsqu'une `Piece` change de `Position`, 
avant et après le changement de position, de cette *interface* découle la classe `CaptureObserver` 
qui s'active si la nouvelle position de la pièce est *null* (donc qu'elle s'est fait manger).

Il y a une *view* `ChessboardView`, qui s'occupe de la création de l'échiquier, c'est lui qui donne 
la taille, les couleurs des pièces et des joueurs ainsi que la position des pièces, en se basant 
sur les règles officielles des échecs.

Pour détailler un peu plus sur la partie `Piece` ses dernières se regroupe dans un package dédié à eux, 
que se sois pour leur création à l'aide d'une *factory* `FactoryStrategy`, comme dit précédemment la fonction 
de la pièce et leur différenciation se fais à l'aide d'une *strategy*. Chacune des pièces possède une méthode 
*getMovement* qui renvoie un tableau en 2 dimensions de tous les mouvements **THÉORIQUE** de la *Piece*.

En dehors de cela il y a 2 *controller* : le *main* `ChessMain` qui est l'exécutable qui va nous lancer la `Party`
cette classe s'avère être primordiale, car c'est cette dernière qui affiche si un mouvement **CONCRET** est possible pour une `Piece` ou non.
 