package com.ilabs.cardservice.exception;

import com.ilabs.cardservice.constant.Constant;

public class CardItemNotExistException extends Exception {
    @Override
    public String getMessage() {
        return Constant.CARD_ITEM_NOT_EXIST;
    }
}
