# A31-Chessgame 

## Description des nouveaux choix de conception :

Par rapport au premier rapport, nous avons mis au fait des changements afin que certaines classes se divise, nous avons notamment crée 
une **vue** `Cell`, cette dernière s'occupe directement de l'affichage des cases (chose qui était partiellement fais par la classe `Party`). Elle affichera les cases en vert lorsque la `Piece` peut se deplacer dans cette `Cell` et en rouge les `Cell` ou l'on peut se deplacer afin de capturer une `Piece`, cela est possible grâce à l'énumération `CellState` avec les `Cell` par **DEFAULT** (les blanches et noires), celle qui est **SELECTED** et celle qui sont **POSSIBLE** à atteindre.

Nous avons aussi crée un **oberserver** `MovementViewObserver` qui permet le déplacement des pièces en "vidant" la `Cell` initial de la `Piece`, et en "ajoutant" dans la nouvelle `Cell` la `Piece`, cet  **observer** permet aussi de faire la promotion des `Pawn`, une fois arriver au bout le choix est laisser au joueur de choisir entre une `Queen`, un `Bishop`,un `Rook` ou un `Knight`.

Egalement la classe `Chessboard` possède une nouvelle méthode *getMovements* qui renvoie la liste des mouvements de la `Piece` en fonction de sa position.

Les couleurs ont changer; `Color` n'existe plus et a été remplacer par `PlayerColor` afin d'être plus cohérent.

Il existe aussi un dernier **observer** `EchecObserver` se dernier à pour but de signaler le joueur lorsqu'il subit un *echec* et de signaler lorsqu'il y'a *echec et mat*, se dernier analyse tout le `Chessboard` afin de faire ses différents signalement.

