import acm.graphics.GLabel;
import acm.util.RandomGenerator;
public class WordBank {

    private int randomNumber;


    public String[] words = {"hello","man","bro" };



    public void roll(){
        randomNumber = RandomGenerator.getInstance().nextInt(1,3);
        System.out.println(randomNumber);

    }

    public int getRandomNumber(){
        return randomNumber;
    }

}
