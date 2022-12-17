package com.virtusa.cardservice.service;

import com.virtusa.cardservice.dto.request.CardItemRequest;
import com.virtusa.cardservice.entity.Card;
import com.virtusa.cardservice.repository.CardRepository;
import com.virtusa.cardservice.service.impl.CardServiceImpl;
import com.virtusa.cardservice.util.MockCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardServiceImpl cardService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookList() {
        List<Card> allCards = MockCard.getAllCards();
        Mockito.when(cardService.getItem()).thenReturn(allCards);

        List<Card> cardList = cardService.getItem();

        assertEquals(allCards.size(), cardList.size());
        assertEquals(allCards.get(0).getCardId(), cardList.get(0).getCardId());
    }

    @Test
    public void testAddCardItem() {
        CardItemRequest cardItemRequest = MockCard.getCardItemRequest();
        Card card = MockCard.getCard();
        Mockito.when(cardRepository.save(any(Card.class))).thenReturn(card);

        Card cardR = cardService.addCardItem(cardItemRequest);
        assertEquals(cardR.getCardName(), card.getCardName());
    }
}
