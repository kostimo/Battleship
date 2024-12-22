# Battleship
## Class diagram
![class-diagram.png](img/battleship-class-diagram.png)

## Player infos
There are two types of ship you can place. The `battleship` has a size of four and the `destroyer` has a size of two.
When placing a ship, you will be asked for the **ship type** you want to place, for the **orientation** and for the
**coordinates.**

- If you type `r` for **ship type**, a random ship will be created

- If you enter something else than the values you're asked to enter for the ship's type, it will automatically be a
  destroyer.

- If you enter something else then the values you're asked to enter for the ship's orientation, it will automatically be
  placed horizontally.

Ships can be placed directly next to each other.  
A ship is placed at the entered coordinates.

- If it's horizontal, it will be placed from the starting coordinate to the right.

- If it's vertical, it will be placed from the starting coordinate to the bottom.
  Ships can be placed directly next to each other.

- If you're trying to place a ship outside the game board or the ship can't be placed at the entered coordinates because
  it would leave the board or overlap with other ships, you will be asked again to place a ship.
