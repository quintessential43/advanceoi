package com.advanceio.assessment.service.impl.badugi;

import com.advanceio.assessment.model.Card;
import com.advanceio.assessment.service.DeckOfCards;
import com.advanceio.assessment.service.impl.base.GameAbstract;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;


public class BadugiService extends GameAbstract implements DeckOfCards {

    public BadugiService() {
        //TODO: initialize th deck creation.
        throw new NotImplementedException();
    }

    /*
     * Deal the first 5 top cards to the player.
     */
    @Override
    public List<Card> Deal() {
        //TODO: implementation goes here
        throw new NotImplementedException();
    }

    /*
     * Shuffles the cards X number of times.
     */
    @Override
    public void Shuffle(int numberOfShuffles) {
        //TODO: implementation goes here
        throw new NotImplementedException();
    }
}
