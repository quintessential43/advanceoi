package com.advanceio.assessment.service.impl.fivecarddraw;

import com.advanceio.assessment.enumeration.SUITS;
import com.advanceio.assessment.model.Card;
import com.advanceio.assessment.service.DeckOfCards;
import com.advanceio.assessment.service.impl.base.GameAbstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implements the DeckOfCards integration interface
 * implementation is defined for the the Standard Five Card Hand Strength poker game, other games that build a different deckSize and deal different count can also implement this same interface.
 * <p>
 * Author:  Lucky/Lehlohonolo Sello
 **/
public class FiveCardDrawStrengthService extends GameAbstract implements DeckOfCards {

    /*
     * On create this does the following
     * We can do this on a POST or INIT methods as well, purely depends on approached subject to the framework.
     * Initializes the the deck for the Standard_Five_Hand_Strength game with 52 cards
     */
    public FiveCardDrawStrengthService() {

        cardList = new ArrayList<>();
        SUITS[] suits = SUITS.values();

        for (int value = 1; value <= 13; value++) {
            for (int mySuit = 0; mySuit < suits.length; mySuit++) {
                cardList.add(new Card(value, suits[mySuit]));
            }
        }

        System.out.println();
    }


    /*
     * Deal the first 5 top cards to the player.
     */
    @Override
    public List<Card> Deal() {
        //TODO: Built for 1 or more players, Ideally as per requirement 'cards.subList(0, 5)' should be enough.
        List<Card> cards = this.cardList.subList(subsetIndex.get(), subsetIndex.addAndGet(5));
        logDealtHand(cards);
        return cards;
    }

    /*
     * Shuffles the cards X number of times.
     */
    @Override
    public void Shuffle(int numberOfShuffles) {

        simulationShufflingTime();
        Collections.shuffle(cardList); //this can als be sent to the abstract/base call or call any new implementation etc

    }
}
