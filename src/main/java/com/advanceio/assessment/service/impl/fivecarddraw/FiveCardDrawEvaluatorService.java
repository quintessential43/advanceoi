package com.advanceio.assessment.service.impl.fivecarddraw;

import com.advanceio.assessment.model.Card;
import com.advanceio.assessment.service.EvaluationService;
import com.advanceio.assessment.service.impl.base.GameAbstract;

import java.util.List;


/**
 * FiveCardDrawEvaluatorService class for evaluating cards for the standard Five Card Draw poker game.
 * Implements the evaluation interface which will be the interface of other games that can and will be implemented on this service.
 *
 * Author Lucky/Lehlohonolo Sello
 * */
public class FiveCardDrawEvaluatorService extends GameAbstract implements EvaluationService {

    //Evaluates the cards for FiveCardDraw game
    @Override
    public String evaluate(List<Card> cardList) {
        cardArray = cardList.toArray(new Card[cardList.size()]);
        return runEvaluation();
    }


    private String runEvaluation() {

        if (isStraightFlush()) return "STRAIGHT FLUSH";
        if (isFourOfAKind()) return "FOUR OF A KIND";
        if (isFullHouse()) return "FULL HOUSE";
        if (isFlush()) return "FLUSH";
        if (isStraight()) return "STRAIGHT";
        if (isThreeOfAKind()) return "THREE OF A KIND";
        if (isTwoPair()) return "TWO PAIR";
        if (isPair()) return "ONE PAIR";

        return "HIGH CARDS";

    }

    private boolean isFlush() {
        if (cardArray[0].getSuit().equals(cardArray[1].getSuit()) &&
                cardArray[0].getSuit().equals(cardArray[2].getSuit()) &&
                cardArray[0].getSuit().equals(cardArray[3].getSuit()) &&
                cardArray[0].getSuit().equals(cardArray[4].getSuit())) {

            if (!isStraightFlush()) {
                return true;
            }
        }

        return false;
    }

    private boolean isStraight() {

        int[] cardValues = new int[13];

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        int firstValue = -1, inARow = 0, lastValue = -5;

        for (int i = 0; i < cardValues.length; i++) {

            if (firstValue == -1 && cardValues[i] != 0) {

                firstValue = i;

                lastValue = firstValue;

                inARow++;

            }

            if (cardValues[i] != 0 && (i - 1) == lastValue) {

                lastValue = i;

                inARow++;

            }

        }

        if (inARow == 5)  //if it's a straight, make sure it's not a flush:

        {

            if (!isStraightFlush()) {

                return true;

            }

        }

        return false;

    }

    private boolean isFourOfAKind() {

        int[] cardValues = new int[13];

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        for (int i = 0; i < cardValues.length; i++) {

            if (cardValues[i] == 4) {

                return true;

            }

        }

        return false;

    }

    private boolean isThreeOfAKind() {

        int[] cardValues = new int[13];

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        for (int i = 0; i < cardValues.length; i++) {

            if (cardValues[i] == 3) {

                if (!isFullHouse()) {

                    return true;

                }

            }

        }

        return false;

    }

    private boolean isPair() {

        int[] cardValues = new int[13];

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        for (int i = 0; i < cardValues.length; i++) {

            if (cardValues[i] == 2) {

                if (!isTwoPair() && !isFullHouse()) {

                    return true;

                }

            }

        }

        return false;

    }

    private boolean isTwoPair() {

        int[] cardValues = new int[13];

        int numberOfPairs = 0;

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        for (int i = 0; i < cardValues.length; i++) {

            if (cardValues[i] == 2) {

                numberOfPairs++;

            }

        }

        if (numberOfPairs == 2) {

            return true;

        }

        return false;

    }

    private boolean isFullHouse() {

        int[] cardValues = new int[13];

        boolean hasThreeOfAKind = false;

        boolean hasAPair = false;

        for (int i = 0; i < cardArray.length; i++) {

            cardValues[cardArray[i].getValue() - 1]++;

        }

        for (int i = 0; i < cardValues.length; i++) {

            if (cardValues[i] == 3) {

                hasThreeOfAKind = true;

            }

            if (cardValues[i] == 2) {

                hasAPair = true;

            }

        }

        if (hasAPair && hasThreeOfAKind) {

            return true;

        }

        return false;

    }

    private boolean isStraightFlush() {

        if (cardArray[0].getSuit().equals(cardArray[1].getSuit()) &&  //if flush

                cardArray[0].getSuit().equals(cardArray[2].getSuit()) &&

                cardArray[0].getSuit().equals(cardArray[3].getSuit()) &&

                cardArray[0].getSuit().equals(cardArray[4].getSuit())) {

            //check if it's a straight

            int[] cardValues = new int[13];

            for (int i = 0; i < cardArray.length; i++) {

                cardValues[cardArray[i].getValue() - 1]++;

            }

            int firstValue = -1, inARow = 0, lastValue = -5;

            for (int i = 0; i < cardValues.length; i++) {

                if (firstValue == -1 && cardValues[i] != 0) {

                    firstValue = i;

                    lastValue = firstValue;

                    inARow++;

                }

                if (cardValues[i] != 0 && (i - 1) == lastValue) {

                    lastValue = i;

                    inARow++;

                }

            }

            if (inARow == 5)  //it's a straight and a flush so

                return true;

        }

        return false;  //it's not a straight or not a flush

    }

}
