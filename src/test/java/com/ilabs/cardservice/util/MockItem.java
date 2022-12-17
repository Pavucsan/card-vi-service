package com.ilabs.cardservice.util;

import com.ilabs.cardservice.dto.request.CardItemRemoveRequest;
import com.ilabs.cardservice.dto.request.CardItemRequest;
import com.ilabs.cardservice.entity.Card;
import com.ilabs.cardservice.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class MockItem {
    public static CardItemRemoveRequest getCardItemRemoveRequest() {
        return new CardItemRemoveRequest(99, 100);
    }
}
