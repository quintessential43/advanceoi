package com.advanceio.assessment.model;

import com.advanceio.assessment.enumeration.SUITS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card implements Comparable{

    private int value;
    private SUITS suit;

    public String toString() {
        if(value == 13)
            return "Ace of " + suit;

        if(value == 12)
            return "King of " + suit;

        if(value == 11)
            return "Queen of " + suit;

        if(value == 10)
            return "Jack of " + suit;

        return (value + 1) + " of " + suit;
    }


    public int compareTo(Object otherCard){

        int thisValue = ((Card)this).getValue();

        int otherValue = ((Card)otherCard).getValue();

        return (thisValue - otherValue);

    }


}