# Connect Four

Connect Four is a two-player strategy game. The objective of the game is to be the first player to connect four of their token in a row, either horizontally, vertically, or diagonally, on the game grid. The grid usually consists of six rows and seven columns, forming 42 total slots for discs to be placed. Each player has a set of 21 tokens they can use. To play, each player gets their own color token and they take turns selecting a column to drop their token. The token is then placed at the lowest available position in that column. The first player to connect four discs in a row in any direction wins the game. If the grid fills up without a winner, the game is considered a draw. 

## Setup

### Clone the Repository

`git clone https://github.com/maurasweeney1/four-in-a-row.git`

`cd final-game-project-four-in-a-row`


### Install Dependencies 

Ensure Java and Maven are installed on your system.


#### Java Installation

Verify Java installation by running:

`java -version`

If not installed, download and install Java from Oracle or use a package manager like Homebrew or APT.


#### Maven Installation

Verify Maven installation by running:

`mvn -v`

If not installed, install Maven using your system's package manager or download it from Maven's official website.


### Build the Project

Compile and package the application using Maven:

`mvn clean install`


### Run the Application

Run the project using the Maven exec plugin:

`mvn exec:java -Dexec.mainClass="edu.gonzaga.ConnectFour"`


### Usage

- Launch the application, and the GUI will appear.

- Choose between multiplayer mode or single-player mode (against the computer).

- Interact with the GUI to make your moves and enjoy the game!

### Notes

- The backend logic handles game mechanics, including player turns and win condition checks.

- The GUI is powered by Java Swing for a responsive and interactive user experience.

- Ensure all dependencies are properly resolved through Maven to avoid runtime issues.


### Contributing

To contribute to the project:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make changes and commit them with clear messages.

4. Push to your branch and open a pull request.

### Credits 
Developed By: Maya Stelzer, Maura Sweeney, Abby Hidalgo, and Drew Fitzpatrick


### License

This project is licensed under the MIT License. Feel free to use, modify, and share as needed.
