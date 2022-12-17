package com.virtusa.cardservice.service.impl;

import com.virtusa.cardservice.dto.request.CardItemRequest;
import com.virtusa.cardservice.entity.Card;
import com.virtusa.cardservice.repository.CardRepository;
import com.virtusa.cardservice.repository.ItemRepository;
import com.virtusa.cardservice.service.CardService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    private ItemRepository itemRepository;

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Card> getItem() {
        return cardRepository.findAll();
    }

    @Override
    public Card addCardItem(CardItemRequest cardItemRequest) {
        return cardRepository.save(cardItemRequest.getCard());
    }

    @Override
    public boolean removeCard(long cardId) {
        Optional<Card> card = cardRepository.findById(cardId);
        cardRepository.deleteById(cardId);
        return true;
    }


}
