package com.advanceio.assessment.service;


import com.advanceio.assessment.model.Card;

import java.util.List;

public interface EvaluationService {

    String evaluate(List<Card> cardList);
}
