package com.service;

import com.dao.ItemDAO;
import com.exception.BadRequestException;
import com.exception.InternalServerError;
import com.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public Item save(Item item) throws InternalServerError, BadRequestException {
        validateItem(item);

        item.setDateCreated(new Date());
        item.setLastUpdatedDate(new Date());
        return itemDAO.save(item);
    }

    public Item update(Item item) throws InternalServerError, BadRequestException {
        validateItem(item);

        item.setLastUpdatedDate(new Date());
        return itemDAO.update(item);
    }

    public Item delete(Long id) throws InternalServerError, BadRequestException {
        Item item = itemDAO.findById(id);
        if(item == null)
            throw new BadRequestException("There is no item with id: "+id);

        return itemDAO.delete(item);
    }

    public Item findById(Long id) throws InternalServerError, BadRequestException{
        Item item = itemDAO.findById(id);
        if(item != null)
            return item;
        throw new BadRequestException("There is no item with id: "+id);
    }

    private void validateItem(Item item) throws InternalServerError , BadRequestException {
        if(item.getName().equals(""))
            throw new BadRequestException("Item name can not be empty");
        if(itemDAO.findByName(item.getName()) != null)
            throw new BadRequestException("Item with name: "+item.getName()+" already exists");
    }

}
