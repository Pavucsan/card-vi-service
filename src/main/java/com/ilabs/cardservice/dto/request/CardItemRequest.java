package com.ilabs.cardservice.dto.request;

import com.ilabs.cardservice.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardItemRequest {
    private Card card;
}
