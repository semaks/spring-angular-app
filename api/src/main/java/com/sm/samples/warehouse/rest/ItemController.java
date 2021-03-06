package com.sm.samples.warehouse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sm.samples.warehouse.domain.ItemModel;
import com.sm.samples.warehouse.service.ItemService;

@RestController
public class ItemController {

  @Autowired
  private ItemService itemService;

  @RequestMapping("/")
  public String hello() {
    return "Hello, warehouse app \r\n";
  }

  @CrossOrigin(origins = {"http://localhost:8000", "http://localhost:8001", "http://172.19.0.4:8000"})
  @RequestMapping(value = "/item", method = RequestMethod.GET)
  public List<ItemModel> getAllItems() {
    return itemService.getAllItems();
  }

  @RequestMapping(value = "/item", method = RequestMethod.POST, consumes="application/json")
  public String addItem(@RequestBody ItemModel item) {
    return itemService.addItem(item);
  }

}
