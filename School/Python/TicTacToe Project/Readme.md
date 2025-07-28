# Readme
This is the readme file for my TicTacToe Project.
I did this project for my class: Intro to Python Programming in Fall of 2023. This was one of the first programming classes that I took so this project was difficult at the time.
I also really enjoyed learning how to do the project and it was an excellent capstone for the project.

I have a couple thoughts on this if I do a version 2 of this project. The biggest thing that I would want to do is change how the program determines if a player/computer has
won the game. In version 1, I have a big if statement that checks each of the possible combinations of the board that can be won. That is very ugly to look at and I want to change it.
I would change it so that each of the entries in the dictionary has an interger of a power of 2, so 1, 2, 4, 8, etc up to 256. The player and/or computer would start with 0 and when they successfully
choose a new spot, they will add that position's number to that spot. Then the program will check if a player or the computer won using a bitwise comparision against the 'winning' numbers. If the 
numbers match then the game will end.

I would also implement a harder AI for the computer just so that I can have degrees of difficulty. I am not for sure how I would do that for now.
