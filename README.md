# AngrierBirds
A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ScreenAdapter` extension that draws a simple GUI on the screen.
Using the LibGDX framework in JAVA, We designed and implemented an angry birds and pigs shooting game with a graphical interface using advanced OOP principles. Designed UMLs and Use Case Diagrams, used design patterns and serialization to make code modular. 


## HOW TO RUN: 
    Open the project in IDEA and run from there, using the Lwjgl3Launcher file in the lwjgl3 directory.

## Features: 
	1. Choose among levels.
 	2. Pause/Resume/Restart/Quit game anytime.
	3. Save game at any point of time.
 	4. Load the last saved game corresponding to any level, before starting or while playing any level.
  	5. Access Settings icon from home page or pause menu while playing any level.


[Click to watch the demo](https://github.com/Ruhani05/AngrierBirdsGame/issues/1#issue-2941255248)

## Diagrams, Demo video & Use Cases:
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

