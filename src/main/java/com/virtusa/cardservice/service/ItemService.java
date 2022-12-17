package com.virtusa.cardservice.service;

import com.virtusa.cardservice.dto.request.CardItemRemoveRequest;
import com.virtusa.cardservice.exception.CardItemNotExistException;
import org.springframework.stereotype.Service;

import javax.smartcardio.CardNotPresentException;

@Service
public interface ItemService {
    public boolean removeItem(CardItemRemoveRequest cardItemRemoveRequest) throws CardNotPresentException, CardItemNotExistException;
}
