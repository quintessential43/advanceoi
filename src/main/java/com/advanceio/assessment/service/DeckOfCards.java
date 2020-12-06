package com.advanceio.assessment.service;


import com.advanceio.assessment.model.Card;

import java.util.List;

//Other poker games with different rules would implement this interface given that the following methods are enough.
public interface DeckOfCards {

    List<Card> Deal();

    void Shuffle(int numberOfShuffles);

}
