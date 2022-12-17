package com.ilabs.cardservice.service;

import com.ilabs.cardservice.dto.request.CardItemRemoveRequest;
import com.ilabs.cardservice.entity.Card;
import com.ilabs.cardservice.entity.Item;
import com.ilabs.cardservice.repository.CardRepository;
import com.ilabs.cardservice.repository.ItemRepository;
import com.ilabs.cardservice.service.impl.CardServiceImpl;
import com.ilabs.cardservice.service.impl.ItemServiceImpl;
import com.ilabs.cardservice.util.MockItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.smartcardio.CardNotPresentException;

import static org.mockito.ArgumentMatchers.*;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRemoveItemFromCard(){
        CardItemRemoveRequest cardItemRemoveRequest = MockItem.getCardItemRemoveRequest();
    }
}
