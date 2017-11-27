package com.ooad.controller;

import com.ooad.model.InventoryItem;
import com.ooad.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/staff/inventory")
@ComponentScan("com.ooad")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/")
    public String home() {
        return "inventoryHome";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listItems(ModelMap model) {
        List<InventoryItem> inventoryItemList = inventoryService.findAllInventoryItems();
        model.addAttribute("items", inventoryItemList);
        return "allItems";
    }

    @RequestMapping(value = {"/orderList"}, method = RequestMethod.GET)
    public String listItemsToOrder(ModelMap model) {
        List<InventoryItem> inventoryItemList = inventoryService.findItemsToOrder();
        model.addAttribute("items", inventoryItemList);
        return "allItems";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public String search(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String searchTerm = request.getParameter("searchTerm");
        List<InventoryItem> inventoryItemList = inventoryService.findItems(searchTerm);
        model.addAttribute("items", inventoryItemList);
        return "allItems";
    }

    @RequestMapping(value = "/add")
    public String addItem() {
        return "addItem";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap model) {
        InventoryItem inventoryItem = inventoryService.findById(Integer.parseInt(id));
        model.addAttribute("item", inventoryItem);
        return "editItem";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response) {
        InventoryItem newItem = parseItem(request);
        inventoryService.save(newItem);
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        InventoryItem updatedItem = parseItem(request);
        updatedItem.setId(id);
        inventoryService.update(updatedItem);
        return "redirect:../list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        inventoryService.delete(id);
        return "redirect:list";
    }

    private InventoryItem parseItem(HttpServletRequest request) {
        InventoryItem inventoryItem = new InventoryItem();
        if (request.getParameter("available") != null && request.getParameter("available") != "") {
            inventoryItem.setAvailable(Integer.parseInt(request.getParameter("available")));
        }
        inventoryItem.setName(request.getParameter("name"));
        inventoryItem.setType(request.getParameter("type"));
        return inventoryItem;
    }
}
