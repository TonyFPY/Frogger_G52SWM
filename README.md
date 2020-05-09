# <img src="/src/main/resources/org/frogger/readme/frog.png" alt="logo" width="30"/> Frogger
> This project is about maintaining and extending a re-implementation of a classic retro game Frogger. The original code is downloaded from the following GitHub *[repository](https://github.com/hirish99/Frogger-Arcade-Game)*. This version has never been completed, but at least it runs, once it is set up properly. More information about the original Frogger game and its history is available *[here](https://www.arcadeclassics.net/80s-game-videos/frogger)*.

### Catalogue
- [Test Environment & Build Script](#Test-Environment-&-Build-Script)
- [Screenshots](#screenshots)
- [Source File Structure](#source-file-structure)
- [High Level Class Diagram](#high-level-class-diagram)
- [Maintenance](#maintenance)
- [Extension](#extension)
- [Arrangement](#arrangement)
- [Video](#video)
- [Credits](#credits)

### Test Environment & Build Script
- IDE: IntelliJ
- Tested on:  
    - Lab Machine in Room A32 of Computer Science Building
    - MacOS 10.14.6 with Java 10 and JavaFX 10.0.2
- Build Script:
    - Maven  
        Step 1: Maven -> Lifecycle -> compile  
        Step 2: import changes  
        Step 3: Maven -> Plugins -> exec -> exec: java  
        If see the following similar result, it means you run program with Maven Successfully.
        <img src="/src/main/resources/org/frogger/readme/maven.png" alt="maven" width=70%/>  
        <br/>
    
    > Note: 
    When I followed the instruction *[Getting Started with JavaFX]((https://openjfx.io/openjfx-docs/))* on the official website to set up configuration of Maven, there were some problems about version incompatibility. The console always displayed "Failed to execute plugin xxx" and "Error injecting: JavaFXCompileMojo". Hence, I found an alternative way to execute a program with Maven, which is using "exec-maven-plugin". For more information, please visit this *[webpage](https://stackoverflow.com/questions/2472376/how-do-i-execute-a-program-using-maven)*. If you fail to run the program with above steps, please use the normal running approach in IntelliJ, click <kbd>Run</kbd>  -> <kbd>Run 'Main()'</kbd>.

### Screenshots
<div align=center>
     <img src="/src/main/resources/org/frogger/readme/shortcut.png" alt="screenshots" width=60% />
</div>  

### Source File Structure

```
src
└── main
    ├── java
    |   └── org
    |       └── frogger
    |           ├── elementFactory
    |           ├── gameController
    |           ├── gameModel
    |           ├── gameView
    |           ├── gameSettings
    |           └── Main.java
    └── resources
        └── org
            └── frogger
                ├── css
                ├── image
                ├── font
                ├── music
                ├── FXML
                └── HighScoreList
```

### High Level Class Diagram
![](/src/main/resources/org/frogger/readme/class_diagram.jpg)
>Please note that it is not standard to include "Resources" folder in the class diagram, because it is not a class. However, in order to show Model-View-Controller pattern clearly, ".fxml" files and `gameView` package are put together to indicate the "View" part. Thanks for understanding !

### Maintenance
- **Basic part**
    - **Dividing all classes into packages**
        - The whole project contains five packages, which are `gameModel`, `gameView`, `gameController`, `gameSettings`, `elementsFactory`. They are classified in order to control access and make researching. 
        - MVC Design Pattern is applied to the first three packages. `gameSettings` contain some game settings, such as background, music, timer, etc. `elementsFactory` integrates the game elements with different parameters (speed, size ... ) and adds them to the game.  
        <br/>

    - **Renaming variables and methods**
        - Some variables and methods are renamed to reveal their purpose and make them understandable.  
        <br/>

    - **Removing redundant code and comments**
        - Some useless setters and getters are removed. For example, getMovement() is useless in `Actor` class.
        - The class `MyStage` is removed completely, because it only contains background music settings, which can be done inside a controller.
        - Some comments were probably used for debugging purpose. These "testing" comments are removed.  
        <br/> 

    - **Making units of code shorter**
        - Long methods are difficult to understand, so long methods are separated into sub-methods. For example, in `Frog` class, sub-methods of `public void act(long now)` are extracted to deal with the cases, such as game elements intersection, movement control, etc.
        - Large classes reduce cohesive and need to be divided into small classes. For example, `Main.java` is modified to trigger the starting page only. Adding elements to the game and controlling animation are put in other classes. 
        - Lamda expression is applied to some methods involving keyboard events to simplify the code.
        - Long Parameter lists are inconsistent. In `Frog.java`, parameter and variable settings are simplified.
        <br/>

    - **Identifying the coding style**
        - The original code contains both K&R and Allman coding style, which makes code less structured. Hence, K&R style is identified and indentation is adjusted to make structure well-organized.  
        <br/>  

    - **Fixing bugs**
        - The visulisation of current score is improved.
        <br>

- **Advanced part**
    - **Applying Java properties**
        - Encapsulation
            - Fields are encapsulated to retain private variables.
        - Inheritance
            - Game elemets such as `Log`, `Obstacle` are inherented from `Actor` to perform a set of actions. Some methods are pulled up to high level class.
            - `WetTurtle` is modified to be a subclass of  `Turtle` to reduce redundant code. 
            - `GameEasyLevel`, `GameMediumLevel`, `GameHardLevel` extends the properties from `Game` class to perform some similar game settings.
        - Polymorphism
            - Overriding is used between parent class and children classes to allow coding extension. 
            - `ElementsFactory` class is applied to generate different elements using Polymorphism.  
        - Abstraction
            - `Game` class is set to be abstract because it will not be instantiated.
            - Interface is used to group a set of methods to specify their purposes. `Actor` implements `Components` interface; `elementsFactory` implements `Integrations` interface. Using interface can help to couple architecture components loosely.  
            <br/>      

    - **Applying design pattern**
        - Singleton design pattern
            - `Music` class is designed to play and stop background music, which only needs one instantce.
            - `HignScoreList` class can be regarded as a "database" of the project. It reads the `HighScoreList.txt` file and updates the latest information. Duplicates will cause data corruption.  
            <br/>   

        - Factory design pattern
            - `ElementsFactory` class encapsulates the process of creating objects and hides the process of matching game level with corresponding parameters. 
            - `Game` class hides the process of generating different game modes.  
            <br/>   

    - **Junit**   

    - **Javadoc**  

### Extension
- **Adding different game pages via Scene Builder**   
    <img src="/src/main/resources/org/frogger/readme/flow_chart.jpg" alt="flow_chart" width=50% />  
        
    
- **Applying three game levels**
    - The speed of game elements is adjusted.
    - Crocodiles and Zombies are added according to different game levels. <br/> 

- **Background Music**
    - Background music is played when the program starts. 
    - When switching to the "End Page", the background music is changed.  
    <br/>     

- **Game settings**
    - A button to pause the game
    - A button to quit the game    
    If player clicks the button, a confirmation alert will be poped up.
    - Timer  
    The time limit is set to 100 seconds. If time's up, the game finishes.
    - Displaying number of lives 
    - Displaying current score  
    <br/>  

- **High Score List**
    - The game will document Top-10 players and their scores in a `.txt` file permanently. 
    - The information will be updated automatically.  
    <br/> 

- **Beautifying the UI**
    - `display.css` file is used to change the font, size, color, button appearance.
    - Appearance of multiple game elements is changed.  
    <br/>  

- **Applying MVC pattern**
    - The controller accepts the inputs (button, keyboards, mouse) from the players and decides what to do with it.
    - The view displays the output on the screen with the help of `.fxml` files.
    - Each view is associated with a unique controller.  

        |     Model    |         View     |            Controller     |
        | :----------: | :--------------: | :------------------------:|
        |    Frog      |  StartingPage    |   StartingPageController  |
        |    Log       |  InfoPage        |   InfoPageController      |
        |    Obstacle  |  UserPage        |   UserPageController      |
        |    Turtle    |  HighScorePage   |   HighScorePageController |
        |    Crocodile |  EndPage         |   EndPageController       |
        |    Zombie    |  LevelPage       |   LevelPageController     |
        |    Habitat   |                  |   GameController          |
        |    Digit     |                  |   GameTimerController     |
<br>

### Arrangement
- **Version Control**
    - GitLab is used to create different branches. Each branch indicates one stage of project maintenance.
    <br>
- **Gantt Chart**
<img src="/src/main/resources/org/frogger/readme/gantt_chart.png" alt="gantt_chart" width=100% /> 
<br>

### Video
https://youtu.be/456PU1yNJ3w
<br>

### Credits
All media assets (images & music) are derived from the internet, and are ensured to be free to use for non-commercial use.

This project adopts MIT license.
