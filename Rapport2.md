# A31-Chessgame 

## Description des nouveaux choix de conception :

Par rapport au premier rapport, nous avons mis au fait des changements afin que certaines classes se divise, nous avons notamment crée 
une **vue** `Case`, cette dernière s'occupe directement de l'affichage des cases (chose qui était partiellement fais par la classe `Party`). Elle affichera les cases en vert lorsque la `Piece` peut se deplacer dans cette `Case` et en rouge les `Case` ou l'on peut se deplacer afin de capturer une `Piece`, cela est possible grâce à l'énumération `CaseState` avec les `Case` par **DEFAULT** (les blanches et noires), celle qui est **SELECTED** et celle qui sont **POSSIBLE** à atteindre.

Nous avons aussi crée un **oberserver** `MovementViewObserver` qui permet le déplacement des pièces en "vidant" la `Case` initial de la `Piece`, et en "ajoutant" dans la nouvelle `Case` la `Piece`.

Egalement la classe `Chessboard` possède une nouvelle méthode *getMovements* qui renvoie la liste des mouvements de la `Piece` en fonction de sa position.