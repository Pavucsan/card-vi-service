package com.ilabs.cardservice.service;

import com.ilabs.cardservice.dto.request.CardItemRemoveRequest;
import com.ilabs.cardservice.exception.CardItemNotExistException;
import org.springframework.stereotype.Service;

import javax.smartcardio.CardNotPresentException;

@Service
public interface ItemService {
    public boolean removeItem(CardItemRemoveRequest cardItemRemoveRequest) throws CardNotPresentException, CardItemNotExistException;
}
