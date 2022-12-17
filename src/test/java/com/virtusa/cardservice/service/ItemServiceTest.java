package com.virtusa.cardservice.service;

import com.virtusa.cardservice.dto.request.CardItemRemoveRequest;
import com.virtusa.cardservice.repository.ItemRepository;
import com.virtusa.cardservice.service.impl.ItemServiceImpl;
import com.virtusa.cardservice.util.MockItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void setup() {
//        MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRemoveItemFromCard(){
        CardItemRemoveRequest cardItemRemoveRequest = MockItem.getCardItemRemoveRequest();
    }
}
