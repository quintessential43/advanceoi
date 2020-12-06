import com.advanceio.assessment.enumeration.SUITS;
import com.advanceio.assessment.model.Card;
import com.advanceio.assessment.service.EvaluationService;
import com.advanceio.assessment.service.impl.fivecarddraw.FiveCardDrawEvaluatorService;
import com.advanceio.assessment.service.impl.fivecarddraw.FiveCardDrawStrengthService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PokerIntergrationTest {

    @Test
    public void engineHas52Cards() {

        FiveCardDrawStrengthService fiveCardDrawStrengthService = new FiveCardDrawStrengthService();

        assertEquals(fiveCardDrawStrengthService.getCardList().size(), 52);
    }

    @Test
    public void fiverCardDrawShouldOnlyServeFiveCards() {

        FiveCardDrawStrengthService fiveCardDrawStrengthService = new FiveCardDrawStrengthService();

        List<Card> handSize = fiveCardDrawStrengthService.Deal();

        assertEquals(5, handSize.size());
    }

    @Test
    public void checkShufflingEfficiency() {

        //init
        FiveCardDrawStrengthService fiveCardDrawStrengthService = new FiveCardDrawStrengthService();

        //get the first five cards from the unshuffled list
        List<Card> unshuffledList = fiveCardDrawStrengthService.Deal();

        //shuffle the list 5 times
        fiveCardDrawStrengthService.Shuffle(5);

        //get the first five cards from the shaffled list
        List<Card> shuffledList = fiveCardDrawStrengthService.Deal();

        assertNotEquals(unshuffledList.subList(0, 5), shuffledList.subList(0, 5));
    }


    @Test
    public void test_High_Card_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(new Card(6, SUITS.Clubs), new Card(9, SUITS.Diamonds), new Card(7, SUITS.Diamonds), new Card(10, SUITS.Clubs), new Card(11, SUITS.Diamonds));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "HIGH CARDS");
    }

    @Test
    public void test_One_Pair_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(10, SUITS.Hearts),
                new Card(13, SUITS.Diamonds),
                new Card(7, SUITS.Clubs),
                new Card(3, SUITS.Diamonds),
                new Card(10, SUITS.Clubs));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "ONE PAIR");
    }

    @Test
    public void test_Two_Pair_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(10, SUITS.Clubs),
                new Card(3, SUITS.Diamonds),
                new Card(7, SUITS.Clubs),
                new Card(3, SUITS.Diamonds),
                new Card(10, SUITS.Hearts));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "TWO PAIR");
    }

    @Test
    public void test_There_Pair_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(10, SUITS.Clubs),
                new Card(13, SUITS.Diamonds),
                new Card(10, SUITS.Clubs),
                new Card(3, SUITS.Diamonds),
                new Card(10, SUITS.Clubs));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "THREE OF A KIND");
    }

    @Test
    public void test_Straight_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(7, SUITS.Clubs),
                new Card(6, SUITS.Spades),
                new Card(5, SUITS.Spades),
                new Card(4, SUITS.Hearts),
                new Card(3, SUITS.Hearts));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "STRAIGHT");
    }

    @Test
    public void test_Flush_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(12, SUITS.Clubs),
                new Card(10, SUITS.Clubs),
                new Card(7, SUITS.Clubs),
                new Card(6, SUITS.Clubs),
                new Card(4, SUITS.Clubs));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "FLUSH");
    }

    @Test
    public void test_Full_House_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(3, SUITS.Clubs),
                new Card(3, SUITS.Spades),
                new Card(3, SUITS.Diamonds),
                new Card(6, SUITS.Clubs),
                new Card(6, SUITS.Hearts));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "FULL HOUSE");
    }


    @Test
    public void test_Four_Of_A_Kind_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        List<Card> cardList = Arrays.asList(
                new Card(9, SUITS.Clubs),
                new Card(9, SUITS.Spades),
                new Card(10, SUITS.Hearts),
                new Card(9, SUITS.Diamonds),
                new Card(9, SUITS.Hearts));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "FOUR OF A KIND");
    }

    @Test
    public void test_STRAIGHT_FLUSH_Evaluation() {

        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();


        List<Card> cardList = Arrays.asList(
                new Card(10, SUITS.Clubs),
                new Card(9, SUITS.Clubs),
                new Card(8, SUITS.Clubs),
                new Card(7, SUITS.Clubs),
                new Card(6, SUITS.Clubs));

        String result = evaluationService.evaluate(cardList);

        assertEquals(result, "STRAIGHT FLUSH");
    }

}
