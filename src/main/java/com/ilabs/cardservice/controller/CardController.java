package com.ilabs.cardservice.controller;

import com.ilabs.cardservice.constant.Constant;
import com.ilabs.cardservice.dto.request.CardItemRequest;
import com.ilabs.cardservice.dto.response.CommonResponse;
import com.ilabs.cardservice.entity.Card;
import com.ilabs.cardservice.enumaration.StatusCode;
import com.ilabs.cardservice.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    private CardService cardService;

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "/cards")
    public ResponseEntity<CommonResponse> getCard() {
        log.info(Constant.GET_CARD_LIST);
        CommonResponse response = new CommonResponse();
        List<Card> cardList;

        try {
            cardList = cardService.getItem();

            response.setData(cardList);
            response.setMessage(StatusCode.SUCCESS.getValue());
            response.setStatusCode(StatusCode.SUCCESS.getCode());

            log.info(Constant.THREE_VALUES, Constant.GET_CARD_LIST, Constant.SUCCESS, response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(Constant.FOUR_VALUES, Constant.GET_CARD_LIST, Constant.ERROR, ex.getMessage(), ex);
            response.setMessage(StatusCode.ERROR.getValue());
            response.setStatusCode(StatusCode.ERROR.getCode());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/card/item/add")
    public ResponseEntity<CommonResponse> addCardItem(@RequestBody CardItemRequest cardItemRequest) {
        log.info(Constant.ADD_CARD_ITEM);
        CommonResponse response = new CommonResponse();
        Card card;

        try {
            card = cardService.addCardItem(cardItemRequest);

            response.setData(card);
            response.setMessage(StatusCode.SUCCESS.getValue());
            response.setStatusCode(StatusCode.SUCCESS.getCode());

            log.info(Constant.THREE_VALUES, Constant.ADD_CARD_ITEM, Constant.SUCCESS, response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(Constant.FOUR_VALUES, Constant.ADD_CARD_ITEM, Constant.ERROR, ex.getMessage(), ex);
            response.setMessage(StatusCode.ERROR.getValue());
            response.setStatusCode(StatusCode.ERROR.getCode());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/card/remove/{id}")
    public ResponseEntity<CommonResponse> removeCard(@PathVariable long cardId) {
        log.info(Constant.REMOVE_CARD);
        CommonResponse response = new CommonResponse();

        try {
            boolean result = cardService.removeCard(cardId);

            response.setData(result);
            response.setMessage(StatusCode.SUCCESS.getValue());
            response.setStatusCode(StatusCode.SUCCESS.getCode());

            log.info(Constant.THREE_VALUES, Constant.REMOVE_CARD, Constant.SUCCESS, response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(Constant.FOUR_VALUES, Constant.REMOVE_CARD, Constant.ERROR, ex.getMessage(), ex);
            response.setMessage(StatusCode.ERROR.getValue());
            response.setStatusCode(StatusCode.ERROR.getCode());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
