# Advanced Programming - Laboratory 7

## Tasks
```text
Write a program that simulates the following positional game between a given number of players (TSP Game).

At the beginning of the game the board contains a number of tokens, each token containing a distinct pair of numbers between 1 and n, and a specific positive value.
Each player extracts tokens successively from the board and must create with them a a closed sequence, that is t1=(i1,i2), t2=(i2,i3),...,tk=(ik,i1), where ti are tokens.
The value of a sequences may be evaluated in various modes: the sum of the token values, the number of tokens, etc. A special bonus may be given if the length of the sequence is n.
The game ends when all tokens have been removed from the board and each player receives a number of points equal to the the value of its largest sequence, or equal to the sum of its sequences, etc.
The players might take turns (or not...) and a time limit might be imposed (or not...).

The main specifications of the application are:
```
COMPULSORY
```text
Create classes in order to model the problem. You may assume that all possible tokens are initially available, having random values.
Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board.
Simulate the game using a thread for each player.
Pay attention to the synchronization of the threads when extracting tokens from the board.
```
OPTIONAL
```text
Implement the scoring and determine who the winner is at the end of the game.
Make sure that players wait their turns, using a wait-notify approach.
Consider the situation when each player might have a different strategy for extracting a number: automated (random) or manual.
A manual player will use the keyboard, while the bot will extract a random token. Simulate bot contests on large graphs.
Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.
```

## Solved tasks

As of today (21.03.2021), I have solved all tasks regarding the compulsory task.

On 16th of April I have solved the first 2 tasks in the optional part, and I have also tried to do the free drawing task. However, because of the lack of time (and skill) I have skipped the last task after several unsuccessful  attempts.
## Build and run

To compile and run my project I have typed the following commands in the terminal:
```bash
javac -classpath . *.java Main.java
java compulsory.Main
```

## Output

The output is:
```text
The game has begun:  maximum right value of token: 5, number of players: 2, with the following players: [Nume_Player = 'John', Nume_Player = 'Mary'], on the following board:
 (new board here){[1-1, 1-2, 1-3, 1-4, 1-5, 2-1, 2-2, 2-3, 2-4, 2-5, 3-1, 3-2, 3-3, 3-4, 3-5, 4-1, 4-2, 4-3, 4-4, 4-5, 5-1, 5-2, 5-3, 5-4, 5-5]}.


Insert a value smaller than 25
0
Player John has chosen the following token: 1-1 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 2-4 and this is his turn 1
Insert a value smaller than 23
0
Player John has chosen the following token: 1-2 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 5-2 and this is his turn 1
Insert a value smaller than 21
0
Player John has chosen the following token: 1-3 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 3-2 and this is his turn 1
Insert a value smaller than 19
0
Player John has chosen the following token: 1-4 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 5-3 and this is his turn 1
Insert a value smaller than 17
5
Player John has chosen the following token: 3-1 with the index 5 and this is his turn 0
Player Mary has chosen the following token: 2-5 and this is his turn 1
Insert a value smaller than 15
8
Player John has chosen the following token: 4-2 with the index 8 and this is his turn 0
Player Mary has chosen the following token: 2-2 and this is his turn 1
Insert a value smaller than 13
15
Insert a value smaller than 13
12
Player John has chosen the following token: 5-5 with the index 12 and this is his turn 0
Player Mary has chosen the following token: 4-3 and this is his turn 1
Insert a value smaller than 11
9
Player John has chosen the following token: 5-1 with the index 9 and this is his turn 0
Player Mary has chosen the following token: 4-4 and this is his turn 1
Insert a value smaller than 9
4
Player John has chosen the following token: 3-4 with the index 4 and this is his turn 0
Player Mary has chosen the following token: 3-3 and this is his turn 1
Insert a value smaller than 7
0
Player John has chosen the following token: 1-5 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 2-3 and this is his turn 1
Insert a value smaller than 5
2
Player John has chosen the following token: 4-1 with the index 2 and this is his turn 0
Player Mary has chosen the following token: 2-1 and this is his turn 1
Insert a value smaller than 3
0
Player John has chosen the following token: 3-5 with the index 0 and this is his turn 0
Player Mary has chosen the following token: 5-4 and this is his turn 1
Insert a value smaller than 1
0
Player John has chosen the following token: 4-5 with the index 0 and this is his turn 0
Player Mary with the following score = 118 has won the game!
with the following tokens = [2-4, 5-2, 3-2, 5-3, 2-5, 2-2, 4-3, 4-4, 3-3, 2-3, 2-1, 5-4]
```