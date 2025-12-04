# Two-player Rock-Paper-Scissors game

def rps_game():
    print("Rock-Paper-Scissors Game")
    print("------------------------")

    # Player inputs
    player1 = input("Player 1, enter your choice (rock/paper/scissors): ").lower()
    player2 = input("Player 2, enter your choice (rock/paper/scissors): ").lower()

    # Rules logic
    if player1 == player2:
        print("It's a tie!")
    elif (player1 == "rock" and player2 == "scissors") or \
         (player1 == "scissors" and player2 == "paper") or \
         (player1 == "paper" and player2 == "rock"):
        print("Player 1 wins!")
    elif (player2 == "rock" and player1 == "scissors") or \
         (player2 == "scissors" and player1 == "paper") or \
         (player2 == "paper" and player1 == "rock"):
        print("Player 2 wins!")
    else:
        print("Invalid input! Please choose rock, paper, or scissors.")

# Run the game
rps_game()
