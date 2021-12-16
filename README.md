# How to run our game:

This is a two-player Tetris. You can run this in one computer or in two computers.

### This is general instruction:
1. Configure the environment on ide
   - Eclips
   - IntelliJ
   1. Go to File ->  Project Structure -> Module
   1. Click on “dependencies” -> click “+” button ->choose “1 JARs and Directories …”, choose the sqlite-jdbc-3.30.1.jar
1. Open our project, find “MultiThreadServer” in the server package, run this program to open the server.
1. Then find “ClientMuti” in the same package. run main twice to open two clients.
1. The game will start only when both players press the SPACE button.
  player 2(see the title of the board) should use keys: W/A/S/D and player 1 should use keys: up/down/left/right button to control the block. Up and w is to rotate block, left and A is to move block left, right and D is to move block right and down and S is to make block going down faster
1. Game will end when either one player’s block reaches the top of the board.
1. When the game is over, you will see your score and world best score. Also, you can type your username to store your score in the database.

### We also provide jar files for one machine to run one server and two players.
1. Click on three jar files：Server.jar, LocalClient1.jar, LocalClient2.jar
1. Then one server and two clients will show on the screen and follows the above steps from step 4
### We've also attackd the demo to show how to run the game
1. Demo1:
2. Demo2: 

# How to play the game:
### One-computer-playing instruction: 
In this way, you and your friends should fight for the mouse to click your client window to win the “focus right” to control your block, which may give you more fun.
Find “MultiThreadServer” in server package, run this program to open the sever. Then find “ClientMuti” in the same package. run ClientMuti (open two client). The game will start only when both player press SPACE button.

### Two-computer-playing instruction: 
If so,make sure you are in the same network, and may need to close firewall (connecting to personal hotspot to reduce risk being attack) on the laptop which open the server.
One Player should 
1. find “MultiThreadServer” in server package, run this program to open the sever in his/her computer, 
1. also, he/she should find “ClientMuti” in the same package. run his/her own Tetris client.
1. find his/her IPV4 internet address and tell another person. 
Another Player should 
1. find “clientMuti” in sever package, find ” socket = new Socket("localhost", 8000);”  near line 27
2. change “localhost” to the IPV4 internet address that your friend just told you. Make sure it is still a string. Looks like: socket = new Socket("10.5.50.251", 8000);”  The game will start only when both player press SPACE button.

Make sure you see the world best score and put your username to store your score.

NOTE: if you cannot connect to the database, (we use relative path, but in case the database does not work), please find “database.java” under Database package. and find” connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");”Change the string in this function into your absolute path. Thanks!! This works on our side, the screen shoot is attached.

Enjoy our game!

# Design
In our proposal: we said that we will use four artifacts: MVC, GUI, Server-client, Database, and Thread. Finally, in our
project, we implements all of them. Moreover, we also use Swing,ENUM, Decorator Design

- MVC: we use MVC model to crate the game: model,view, controller, which in our folder: mvc
- GUI: In the view folder, the GameFrame is the JFrame, LeftPanel and RightPanel are both JPanel
- Server-Client:  In the folder server: it includes our server and client as well as datastream class
- Database: In the folder database, it includes database class and the database's name is javabook.db which in the root. 
  Moreover, it has sqlite-jdbc.3.30.1.jar for database configuration
- Thread: In the folder server, the MultiThreadServer use thread to create each client and itself

### More details
-Our design: This is similar to all other Tetris games. There are seven differently shape blocks, which will go down automatically by one block in the map after 1 second time elapse. You can NOT rotate the block if there is not enough space to rotate. The completed lines disappear and the player gain points from completed lines. The game ends when the blocks reach the top of the map. In our game, there will be two players playing together. Open our game window, the up-left corner is the menu of this game. You can exist from there or you can click about to see the game info. In the main window, the left side is a 24 * 12 game map, where is the main game place. The right side is used to update the current score and show what is next block is.
-In model: Each block has its own class to store its center’s position and the offset of different parts in this block to the center. The left panel model is to store information to control the right panel which is the main game window in our Tetris. For example, it stores the size of the game map, current block, whether the game is over. Also, the whole game logic is running in the left panel model. The right panel model stores the information of the next block, current score, and generating next block.
-In view: We use GUI to show information from the model. There are two panels in the frame. The left panel is the main game window, the right panel is show your score and next block.
-In controller: All models and game frame will be initialized here. And it will send messages to get from view to model, eg, the key listener. Also, we have two more different packages to separate our database and server-client design.
-In the database: There will be three queries. One is to find the world best score to show at the end of the game, another two is to update or insert a new username and its score in the database
-In server - client: We use a thread here to create server and client.



