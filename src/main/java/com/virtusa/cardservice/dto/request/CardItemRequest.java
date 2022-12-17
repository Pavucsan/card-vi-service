package com.virtusa.cardservice.dto.request;

import com.virtusa.cardservice.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardItemRequest {
    private Card card;
}
