package com.ilabs.cardservice.util;

import com.ilabs.cardservice.dto.request.CardItemRequest;
import com.ilabs.cardservice.entity.Card;
import com.ilabs.cardservice.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class MockCard {
    public static List<Card> getAllCards() {
        List<Card> cardList = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item A", (short) 99));
        cardList.add(new Card(1, "card A", itemList));
        return cardList;
    }

    public static Card getCard() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item A", (short) 99));
        return new Card(1, "card A", itemList);
    }

    public static CardItemRequest getCardItemRequest() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1L, "Item A", (short) 99));
        return new CardItemRequest(new Card(1, "card A", itemList));
    }

}
