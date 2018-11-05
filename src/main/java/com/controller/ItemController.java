package com.controller;

import com.exception.BadRequestException;
import com.exception.InternalServerError;
import com.model.Item;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/orderSave", produces = "text/plan")
    public @ResponseBody
    String save(Item item) throws InternalServerError, BadRequestException {
        return "Item saved with id: "+itemService.save(item).getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderSave", produces = "text/plan")
    public @ResponseBody
    String update(Item item) throws InternalServerError, BadRequestException{
        return "Item with id: "+itemService.update(item)+"was updated";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderSave", produces = "text/plan")
    public @ResponseBody
    String delete(Long id) throws InternalServerError, BadRequestException{
        return "Item with id: "+itemService.delete(id)+" was deleted";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderSave", produces = "text/plan")
    public @ResponseBody
    String findById(Long id) throws InternalServerError, BadRequestException{
        return itemService.findById(id).toString();
    }
}
