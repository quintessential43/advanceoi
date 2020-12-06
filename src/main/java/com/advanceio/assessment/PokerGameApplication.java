package com.advanceio.assessment;

import com.advanceio.assessment.model.Card;
import com.advanceio.assessment.service.DeckOfCards;
import com.advanceio.assessment.service.EvaluationService;
import com.advanceio.assessment.service.impl.fivecarddraw.FiveCardDrawEvaluatorService;
import com.advanceio.assessment.service.impl.fivecarddraw.FiveCardDrawStrengthService;

import java.util.List;

public class PokerGameApplication {

    public static void main(String[] args) {

        //Initialize the deck using the StandardFiveCardHandStrength implementation.
        DeckOfCards deckOfCards = new FiveCardDrawStrengthService();

        //Initialize the the evaluator com.advanceio.assessment.service with the StandardFiveCardHandEvaluator rules/implementation_rules.
        EvaluationService evaluationService = new FiveCardDrawEvaluatorService();

        //Shuffle the deck, provide the number of shuffle iterations.
        deckOfCards.Shuffle(3);

        //Deal the player.
        List<Card> deal = deckOfCards.Deal();

        //Evaluate and print the result.
        System.out.printf("You have: %s %n \n", evaluationService.evaluate(deal));

    }

}
