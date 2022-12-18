package com.virtusa.cardservice.controller;

import com.virtusa.cardservice.constant.Constant;
import com.virtusa.cardservice.dto.request.CardItemRemoveRequest;
import com.virtusa.cardservice.dto.response.CommonResponse;
import com.virtusa.cardservice.enumaration.StatusCode;
import com.virtusa.cardservice.exception.CardItemNotExistException;
import com.virtusa.cardservice.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.smartcardio.CardNotPresentException;

@RestController
public class ItemController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }


    @DeleteMapping(path = "/card/item/remove")
    public ResponseEntity<CommonResponse> removeItem(@RequestBody CardItemRemoveRequest cardItemRemoveRequest) {
        log.info(Constant.REMOVE_CARD_ITEM);
        CommonResponse response = new CommonResponse();
        try {
            boolean result = itemService.removeItem(cardItemRemoveRequest);

            response.setData(result);
            response.setMessage(StatusCode.SUCCESS.getValue());
            response.setStatusCode(StatusCode.SUCCESS.getCode());

            log.info(Constant.THREE_VALUES, Constant.REMOVE_CARD_ITEM, Constant.SUCCESS, response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CardNotPresentException | CardItemNotExistException ex) {
            log.error(Constant.THREE_VALUES, Constant.REMOVE_CARD_ITEM, Constant.ERROR, ex.getMessage());
            response.setMessage(ex.getMessage());
            response.setStatusCode(StatusCode.ERROR.getCode());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error(Constant.FOUR_VALUES, Constant.REMOVE_CARD_ITEM, Constant.ERROR, ex.getMessage(), ex);
            response.setMessage(StatusCode.ERROR.getValue());
            response.setStatusCode(StatusCode.ERROR.getCode());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test")
    public String getMapping() {
        return "TEST_ROLE";
    }

}
