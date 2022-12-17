package com.virtusa.cardservice.service;

import com.virtusa.cardservice.dto.request.CardItemRequest;
import com.virtusa.cardservice.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {

    public List<Card> getItem();

    public Card addCardItem(CardItemRequest cardItemRequest);

    public boolean removeCard(long cardId);
}
