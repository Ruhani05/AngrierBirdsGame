# AngrierBirds
A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ScreenAdapter` extension that draws a simple GUI on the screen.
Using the LibGDX framework in JAVA, We designed and implemented an angry birds and pigs shooting game with a graphical interface using advanced OOP principles. Designed UMLs and Use Case Diagrams, used design patterns and serialization to make code modular. 


## HOW TO RUN: 
    Open the project in IDEA and run from there, using the Lwjgl3Launcher file in the lwjgl3 directory.

## Diagrams & Use Cases:
Are present in the AngryBirds2027 Folder Itself as PDF files.


## Refernces:
    https://gamedev.stackexchange.com/questions/121115/libgdx-simple-button-with-image
    https://www.youtube.com/watch?v=p2lUdy68s_M&list=PLLwCf-qdpyEnB_FO_1HkUFh7smwGNjAaC
    https://git-scm.com/
    https://libgdx.com/dev/
    https://www.geeksforgeeks.org/
    https://www.w3schools.com/java/default.asp
    https://stackoverflow.com/
    https://github.com/libgdx/libgdx 


## General Instructions to Play the Game:
    On the Start Game Click on Play Button, or Exit Button, according to your own Choice.

    After CLicking Start, you would be redirected to a level selection page. Selct level1 or level2 or level3. inside each level pause menu has options to resume,restart,exit,save,settings. settings can load game. Each level can has its own saved game, therefore we can store a game at any level and will be restored at that level.

    
In the end Tree Looks Like this:


├───.gradle
│   ├───8.10.2
│   │   ├───checksums
│   │   ├───dependencies-accessors
│   │   ├───executionHistory
│   │   ├───expanded
│   │   ├───fileChanges
│   │   ├───fileHashes
│   │   └───vcsMetadata
│   ├───buildOutputCleanup
│   └───vcs-1
├───.idea
├───assets
│   └───ui
├───core
│   ├───build
│   │   ├───classes
│   │   │   └───java
│   │   │       └───main
│   │   │           └───io
│   │   │               └───github              <--- file in which we coded
│   │   │                   ├───Game
│   │   │                   └───some_example_name
│   │   ├───generated
│   │   │   └───sources
│   │   │       ├───annotationProcessor
│   │   │       │   └───java
│   │   │       │       └───main
│   │   │       └───headers
│   │   │           └───java
│   │   │               └───main
│   │   ├───libs
│   │   ├───lombok
│   │   │   └───effective-config
│   │   └───tmp
│   │       ├───compileJava
│   │       │   └───compileTransaction
│   │       │       ├───backup-dir
│   │       │       └───stash-dir
│   │       └───jar
│   └───src
│       └───main
│           └───java
│               └───io
│                   └───github
│                       ├───Game
│                       └───some_example_name
├───gradle
│   └───wrapper
└───lwjgl3
    ├───build
    │   ├───classes
    │   │   └───java
    │   │       └───main
    │   │           └───io
    │   │               └───github
    │   │                   └───some_example_name
    │   │                       └───lwjgl3
    │   ├───generated
    │   │   └───sources
    │   │       ├───annotationProcessor
    │   │       │   └───java
    │   │       │       └───main
    │   │       └───headers
    │   │           └───java
    │   │               └───main
    │   ├───lombok
    │   │   └───effective-config
    │   ├───resources
    │   │   └───main
    │   │       └───ui
    │   └───tmp
    │       └───compileJava
    │           └───compileTransaction
    │               ├───backup-dir
    │               └───stash-dir
    ├───icons
    └───src
        └───main
            ├───java
            │   └───io
            │       └───github
            │           └───some_example_name
            │               └───lwjgl3          <--- FILE WHERE LAUCH FILE IS PRESENT 
            └───resources



.
.
.
github
├───Game
│       MyGame.java
│       SettingsOverlay.java
│       StartGame.java
│       TutorialGame.java
│
└───some_example_name
                 ├───serializationPurposeMyGame
                 │       BirdDTO.jav
                 │       BlockDTO.java
                 │       PigDTO.java
                  ├───Mycontactlistner.java---Mycontactlistner.java
        BirdDTO.jav
        Bird.java
        Block.java
        Catapult.java
        Ground.java
        Level1.java Level2.java Level3.java Level_parent.java
        LevelPage.java SavedLevelPage.java
        LoseScreen.java
        OverlayPause.java
        OverlaySaveGame.java
        PauseScreen.java
        Pig.java
        Structure.java
        WinScreen.java



.
.
.
lwjgl3
    Lwjgl3Launcher.java
    StartupHelper.java











## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
