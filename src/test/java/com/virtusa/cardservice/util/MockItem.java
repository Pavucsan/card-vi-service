package com.virtusa.cardservice.util;

import com.virtusa.cardservice.dto.request.CardItemRemoveRequest;

public class MockItem {
    public static CardItemRemoveRequest getCardItemRemoveRequest() {
        return new CardItemRemoveRequest(99, 100);
    }
}
