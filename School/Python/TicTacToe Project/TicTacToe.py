#!/usr/bin/env python3
#Simeon Grant

import random as rand
import sys

#creating any global values.
win = 0
lose = 0

#defining a quiting option.
def quitGame():
    y = input("Are you sure? y/n\n")
    if (y == 'y'):
        exit()
        
#Creating a yes/no response function
def yesOrNo():
    y = input().lower()
    if (y == 'y'):
        return True
    elif (y == 'quit'):
        quitGame()
    else:
        return False

#Creating an opening preemble
def openPreemble():
    print("Welcome to Simeon's Tic Tac Toe program!")
    print(f'''
1 || 2 || 3
============
4 || 5 || 6
============
7 || 8 || 9 
    ''')
    print("You can quit at anytime by typing 'quit'.")
    print("Are you a returning player? y/n")
    if yesOrNo():
        returningPlayer()
    else: 
        print("Do you want to create a new account? y/n")
        if yesOrNo():
            newPlayer()
        else:
            print("Have fun!")

#Asking for returning player
def returningPlayer():
    xName=input("What is your player's name?\n")
    with open(f"{xName}.csv","r") as outfile:
            global win
            win = outfile.readline()
            global lose
            lose = outfile.readline()
            print("Have fun!")

def newPlayer():
    xName=input("What do you want your player name to be?\n")
    with open(f"{xName}.csv","w") as outfile:
        outfile.write("New Player")
    print("Have fun!")

#this is the function that handles multiple game instances.
def playingGame():
    while (True):
        global p
        p = {1:"1", 2: "2", 3:"3", 4:"4", 5:"5", 6:"6", 7:"7", 8:"8", 9:"9"} #creating a dictionary for the positions.
        currentGame()
        print("Do you want to play another game? y/n")
        if (not yesOrNo()):
            break
        
#main portion of the game.
def currentGame():
    print("Player is 'o's, computer is 'x's")
    print("Computer goes first.")
    p[5] = 'x'
    while (True): 
        playerTurn()
        if (checkForWin()):
            break
        computerTurn()
        if (checkForWin()):
            break

#checks if a winning condition happened.
def checkForWin():
    if (checkForWinConditions('o')):
        printBoard()
        print("The player wins!")
        global win
        win+=1
        print("Your winning streak:", win)
        return True
    if (checkForWinConditions('x')):
        printBoard()
        print("The computer wins!")
        global lose
        lose+=1
        print("Your lossing streak:", lose)
        return True
    if ((p[1] == 'x' or p[1] == 'o') and (p[2] == 'x' or p[2] == 'o') and (p[3] == 'x' or p[3] == 'o')
        and (p[4] == 'x' or p[4] == 'o') and (p[5] == 'x' or p[5] == 'o') and (p[6] == 'x' or p[6] == 'o')
        and (p[7] == 'x' or p[7] == 'o') and (p[8] == 'x' or p[8] == 'o') and (p[9] == 'x' or p[9] == 'o')):
        print("it's a tie!")
        return True

#Function to check for winning conditions:
def checkForWinConditions(x):
    return ((p[1] == x and p[2] == x and p[3] == x) or (p[4] == x and p[5] == x and p[6] == x) or
    (p[7] == x and p[8] == x and p[9] == x) or (p[1] == x and p[4] == x and p[7] == x) or
    (p[2] == x and p[5] == x and p[8] == x) or (p[3] == x and p[6] == x and p[9] == x) or
    (p[1] == x and p[5] == x and p[9] == x) or (p[3] == x and p[5] == x and p[7] == x))

def playerTurn():
    printBoard()
    while (True):
        position = input("Choose a spot to go into.\n")
        if position == 'quit': #checks to see if the player wants to opt out.
            quitGame()
            continue
        try:
            position = int(position)
            if checksAndBalances(position):
                p[position] = 'o'
                break
        except:
            print("Ah phooey! something went wrong.")

#This is creating the game board.
def printBoard():
    print(f'''
 {p[1]} || {p[2]} || {p[3]}
 ============
 {p[4]} || {p[5]} || {p[6]}
 ============
 {p[7]} || {p[8]} || {p[9]} 
''')

#This is to check if the position number is valid or not.
def checksAndBalances(position):
    if (position > 9 or position < 1):
        print("Ah phooey! number was out of bounds!")
    elif (p[position] == ('x') or p[position] == ('o')):
        print("That spot is already taken! Try again.")
    else:
        return True

def computerTurn():
    while (True):
        position = rand.randrange(1,10)
        if ((p[position] != ('o')) and (p[position] != ('x'))):
            p[position] = 'x'
            break

#This is my save function
#Goal, get this to save to a csv file.
def saveWinAndLose(win, lose):
    print("Do you want to save your stats?")
    if (yesOrNo()):
        xName = input("What is your user name? Or do you want to create a new username?\n")
        with open(f"{xName}.csv","w") as outfile:
            outfile.write(str(win))
            outfile.write("\n")
            outfile.write(str(lose))
            
    print("Bye!")


#main function:
def main():
    openPreemble()
    playingGame()
    saveWinAndLose(win,lose)

if __name__ == "__main__":
    main()
