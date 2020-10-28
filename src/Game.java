/*
HND Computing
28/10/2020
Aidan
15027130
Pontoon Assignment
*/

package src;

public class Game {

    public static boolean getResult(int cardTotal, int house) {

        if (cardTotal>house && cardTotal<=21)
            return (true);
        else
            return (false);

    }

    public static int houseTotal(int x) {

        int house=0;
        while (house < x)
            house = Player.AddCards(GameMath.getRandomCard(),GameMath.getRandomCard());
        
        return (house);

    }

    public static void displayCards(int cardsDrawn[]) {

        System.out.print("Cards drawn: ");
        for (int x=1; x<10; x++) {
        
            if (cardsDrawn[x]!=0) {

                if (x==1) {

                    System.out.print(cardsDrawn[x]);

                }
                else {  

                    System.out.print(","+cardsDrawn[x]);

                }

            }

        }
        System.out.println();

    }

    public static void main(String[] args) {

        final int houseMin = 16;
        String playerChoice = "";
        int cardsDrawn[] = new int[10];
        int newCard = 0;
        int cardCount = 3;
        int cardOne, cardTwo;
        int house = 0;
        int cardTotal;

        house = houseTotal(houseMin);
        cardsDrawn[0] = house;
        cardOne = GameMath.getRandomCard();
        cardsDrawn[1] = cardOne;
        cardTwo = GameMath.getRandomCard();
        cardsDrawn[2] = cardTwo;
        cardTotal = Player.AddCards(cardOne,cardTwo);

        System.out.println("You have drawn "+cardOne+" and "+cardTwo);
        System.out.println("Your current total is "+cardTotal);
        System.out.println("Do you wish to draw another card? y/n");

        playerChoice = Input.kboard.nextLine().toLowerCase();

        do {

            if (playerChoice.equals("y")) {

                newCard = GameMath.getRandomCard();
                cardsDrawn[cardCount++] = newCard;
                System.out.println("You have drawn a "+newCard);
                cardTotal = Player.AddCards(cardTotal,newCard);
                System.out.println("Your current total is "+cardTotal);
    
                if (GameMath.busted(cardTotal)==true) {
    
                    System.out.println("Busted! Your hand = "+cardTotal+", which is over 21");
                    break;
    
                }
                else {   
    
                    System.out.println("Do you wish to draw another card? y/n");
                    playerChoice = Input.kboard.nextLine().toLowerCase();
    
                }

            }
            else if (playerChoice.equals("n")) {

                if (getResult(cardTotal, house)==true) {
    
                    System.out.println("You have won with a total of "+cardTotal+"! The house had "+house);
                    displayCards(cardsDrawn);
                    break; //Add in Play Again
                
                }
                else {
        
                    System.out.println("You have lost with a total of "+cardTotal+"! The house had "+house);
                    displayCards(cardsDrawn);
                    break; //Add in Play Again
        
                }

            }
            else {

                System.out.println("Invalid input '"+playerChoice+"'. Please try again with either 'y' or 'n'.");
                playerChoice = Input.kboard.nextLine().toLowerCase();

            }

        }
        while (playerChoice.equals("y") || playerChoice.equals("n"));

    }

}