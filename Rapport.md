# A31-Chessgame 

## Description des choix : 
> Nous avons creér 3 classes majeur une pour **l'échequier** `Chessboard`,
> une pour les **pièces** `Piece` 
> et une pour le **joueur** `Player`.
> 
> La classe `Piece` a une *couleur* `Color` (Blanc ou Noir), 
> le nombre de points que la pièce rapporte une fois manger `punct`, 
> une *lettre* (qui deviendra une image plus tard) `letter`
> et une *stratégie* `PieceStrategy` qui est la classe mère de tous les types de pièces :
> - `King`
> - `Queen`
> - `Rook`
> - `Bishop`
> - `Knight`
> - `Pawn`
> 
> On utilise aussi :
> 
> La classe `Chessboard` possède une *vue* `ChessboardView`
> 
> La classe `Player` designe un des deux joueurs et a une *couleur* `Color`.
> 
> La classe `Position` possède un axe `x` et `y` désignant une des 64 cases du `Chessboard`.
> 
> 
> Nous utilisons aussi un *observer* de mouvement `MoveObserver` se dernier interfera lorsqu'une `Piece` change de `Position` 
> 