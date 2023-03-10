package com.virtusa.cardservice.service.impl;

import com.virtusa.cardservice.constant.Constant;
import com.virtusa.cardservice.dto.request.CardItemRemoveRequest;
import com.virtusa.cardservice.entity.Card;
import com.virtusa.cardservice.exception.CardItemNotExistException;
import com.virtusa.cardservice.repository.CardRepository;
import com.virtusa.cardservice.repository.ItemRepository;
import com.virtusa.cardservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.smartcardio.CardNotPresentException;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    private CardRepository cardRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public boolean removeItem(CardItemRemoveRequest cardItemRemoveRequest) throws CardNotPresentException, CardItemNotExistException {
        Optional<Card> card = cardRepository.findById(cardItemRemoveRequest.getCardId());
        if (!card.isPresent()) throw new CardNotPresentException(Constant.CARD_NOT_EXIST);
        if(itemRepository.cardItemExist(cardItemRemoveRequest.getCardId(), cardItemRemoveRequest.getItemId())==0) throw new CardItemNotExistException();
        itemRepository.removeCaItem(cardItemRemoveRequest.getCardId(), cardItemRemoveRequest.getItemId());
        return true;
    }
}
