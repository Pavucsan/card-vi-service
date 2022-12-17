package com.virtusa.cardservice.exception;

import com.virtusa.cardservice.constant.Constant;

public class CardItemNotExistException extends Exception {
    @Override
    public String getMessage() {
        return Constant.CARD_ITEM_NOT_EXIST;
    }
}
