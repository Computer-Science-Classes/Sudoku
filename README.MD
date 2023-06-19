# Sudoku Solver

Sudoku Solver is a Java application that loads a Sudoku puzzle from a text file, solves it, and displays the solution on a simple graphical user interface.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Creating Your Own Puzzles](#creating-your-own-puzzles)
- [Contributing](#contributing)
- [License](#license)

## Installation

To install this project, simply clone the repository and compile the Java files:

```bash
git clone https://github.com/user/SudokuSolver.git
cd SudokuSolver
javac *.java
```

## Usage

To run the Sudoku solver, use the following command:

java Sudoku

By default, the `Sudoku solver` will attempt to solve the puzzle specified in `SudokuLab/SudokuNYT.txt`.

## Creating Your Own Puzzles

You can create your own `Sudoku puzzles` by creating a new text file in the following format:

.8. .7. .9.
9.. ... ..7
..2 ... 6..

.3. 6.4 .8.
... ... ...
.7. 2.8 .5.

..4 ... 8..
5.. ... ..2
.1. .9. .3.

Each number represents a filled square in the Sudoku puzzle. An empty square is represented by a dot (.). Each Sudoku puzzle must be a 9x9 grid. After creating your puzzle, save it with the .txt file extension in the SudokuLab directory.

To solve a puzzle from a file you created, change the filename variable in the main method of the Sudoku class to match the name of your file:

`String filename = "SudokuLab/YourFileName.txt";`

## Contributing

Contributions are welcome! Please fork the repository and make changes in your own branch. When you're ready, submit a pull request.

## License

Sudoku Solver is released under the MIT License. For more details, see the LICENSE file.
