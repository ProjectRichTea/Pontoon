package src;

public class GameMath {
    
    public static int getRandomCard() {

        return (int)(Math.random()*10 + 1);

    }

    public static boolean busted(int cardTotal) {

        if (cardTotal>21)
            return (true);
        else
            return (false);

    }

}
