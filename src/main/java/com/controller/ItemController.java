package com.controller;

import com.exception.BadRequestException;
import com.exception.InternalServerError;
import com.model.Item;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    public Item save(Item item) throws InternalServerError, BadRequestException {
        return itemService.save(item);
    }

    public Item update(Item item) throws InternalServerError, BadRequestException{
        return itemService.update(item);
    }

    public Item delete(Long id) throws InternalServerError, BadRequestException{
        return itemService.delete(id);
    }

    public Item findById(Long id) throws InternalServerError, BadRequestException{
        return itemService.findById(id);
    }

}
