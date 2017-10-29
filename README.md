# MinotaurMaze
Project repository for Minotaur Maze Game.

Eric Brigham 
Rain Kwan 
Genevieve Napper 
Emma Schwarz

Draft Design and Initial Tasks

Game Engine: 
The game engine will make mazes and run the game. Additionally, it will have a robot interface that we will implement using the adapter pattern. 

Robot Creation:
We will use the strategy pattern to create our different robots. The reasoning for this is that there will be static and variable code that should be made separate from one another. We will separate behavior that changes in its own class with an interface to be extended by bots that use it. 

Bots of Interest: 
Base, rabbit, skunk, hound, and bat bots. 

Initial Tasks: 
Experimentation will be done with the bots of interest so as to optimize coin accumulation, knowledge of enemy location, and evasion of the minotaur. After efficacy has been optimized, the final group of four bots will be chosen. 

Team Name: Gree[d] 

Upon Receipt of the Game Engine: 
-Create Adapter classes to interface game engine
-Create interface for robots of choice
-Begin the testing process


