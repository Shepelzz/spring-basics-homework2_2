package com.controller;

import com.exception.BadRequestException;
import com.exception.InternalServerError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Item;
import com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;


@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.POST, value = "/orderSave", produces = "text/plan")
    public @ResponseBody
    String save(InputStream dataStream) {
        try {
            return "Item saved with id: " + itemService.save(new ObjectMapper().readValue(dataStream, Item.class)).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orderUpdate", produces = "text/plan")
    public @ResponseBody
    String update(InputStream dataStream) {
        try {
            return "Item with id: "+itemService.update(new ObjectMapper().readValue(dataStream, Item.class)).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orderDelete", produces = "text/plan")
    public @ResponseBody
    String delete(@RequestParam("id") Long id) {
        try{
            return "Item with id: "+itemService.delete(id).getId()+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderGet", produces = "text/plan")
    public @ResponseBody
    String findById(@RequestParam("id") Long id) {
        try{
            return itemService.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
