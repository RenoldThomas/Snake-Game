# Snake Game

A classic Snake game implementation in Java using the Processing library. Navigate the snake to eat various food items, grow longer, and achieve the highest score without colliding with yourself!

## Features

* **Classic Gameplay**: Navigate a snake grid.
* **Screen Wrapping**: The snake wraps around the screen edges instead of dying when hitting a wall.
* **Multiple Food Types**: Randomly spawns Apples, Cherries, and Cookies.
* **Dynamic Graphics**: Uses specific sprites for the snake's head (based on direction), body, and food items.
* **Game States**: Includes Pause and Game Over screens.
* **Score Tracking**: Displays your final score (snake length) upon game over.

## Controls

| Key | Action |
| :--- | :--- |
| **Arrow Keys** | Change direction (Up, Down, Left, Right) |
| **SPACE** | Pause/Unpause game |
| **SPACE** (on Game Over) | Restart game |

## Project Structure

* **`src/SnakeGame.java`**: The main entry point. Handles the game loop, rendering, and input processing.
* **`src/Snake.java`**: Manages the snake's logic, movement, growth, and self-collision detection.
* **`src/Food.java`**: Abstract class for food items.
* **`src/Apple.java`, `Cherry.java`, `Cookie.java`**: Specific food implementations with unique icons.
* **`lib/core.jar`**: The Processing library required for graphics and window management.

## How to Run

### Prerequisites
* Java Development Kit (JDK) installed.
* The `core.jar` file from Processing located in the `lib/` directory.

### Option 1: Command Line (Terminal)

You can compile and run the program directly from the terminal.

1.  Open your terminal or command prompt.
2.  Navigate to the root directory of the project (the folder containing `src` and `lib`).
3.  Run the following command:

    **On Linux/Mac:**
    ```bash
    java -cp lib/core.jar:src SnakeGame
    ```

    **On Windows:**
    ```bash
    java -cp "lib/core.jar;src" SnakeGame
    ```

### Option 2: Visual Studio Code

This project includes a VS Code launch configuration.

1.  Open the project folder in VS Code.
2.  Ensure you have the "Extension Pack for Java" installed.
3.  Go to the **Run and Debug** view (Ctrl+Shift+D).
4.  Select **"SnakeGame"** from the dropdown configuration menu.
5.  Press the **Play** button (Green Arrow) or hit `F5`.

## Credits

* **Copyright**: (c) 2025 Nadine von Frankenberg.