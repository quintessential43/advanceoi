package com.advanceio.assessment.service.impl.base;

import com.advanceio.assessment.model.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Abstracted class for the the pocker games.
 * Contains the common fields and methods for the the inheriting classs
 *
 * Author Lucky/Lehlohonolo Sello
 * */
@Getter
@Setter
public class GameAbstract {

    protected Card[] cardArray;
    protected List<Card> cardList;
    protected final AtomicInteger subsetIndex = new AtomicInteger(0);

    protected void logDealtHand(List<Card> cards) {
        if (cards != null && !cards.isEmpty()) {
            System.out.print("\nYour hand:  ");
            cards.forEach(card -> System.out.printf("%s, ", card.toString()));
            System.out.println("\n");
        }
    }

    //Simulating a shuffling method.
    protected void simulationShufflingTime()  {
        try {
            System.out.print("Shuffling...");
            Thread.sleep(350);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

}
