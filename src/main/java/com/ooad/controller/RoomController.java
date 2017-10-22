package com.ooad.controller;

import com.ooad.model.Room;
import com.ooad.service.RoomService;
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
@RequestMapping("/admin/rooms")
@ComponentScan("com.ooad")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/add")
    public String addRoom() {
        return "addRoom";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listRooms(ModelMap model) {
        List<Room> rooms = roomService.findAllRooms();
        model.addAttribute("rooms", rooms);
        return "allRooms";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap model) {
        Room room = roomService.findById(Integer.parseInt(id));
        model.addAttribute("room", room);
        return "editRoom";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Room newRoom = getRoomFromFormData(request);
        newRoom.setId(Integer.parseInt(request.getParameter("roomNo")));
        roomService.saveRoom(newRoom);
        List<Room> rooms = roomService.findAllRooms();
        modelAndView.addObject("rooms", rooms);
        return "allRooms";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Room updatedRoom = getRoomFromFormData(request);
        updatedRoom.setId(id);
        roomService.updateRoom(updatedRoom);
        List<Room> rooms = roomService.findAllRooms();
        modelAndView.addObject("rooms", rooms);
        return "allRooms";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        roomService.deleteRoom(id);
        List<Room> rooms = roomService.findAllRooms();
        model.addAttribute("rooms", rooms);
        return "allRooms";
    }

    private Room getRoomFromFormData(HttpServletRequest request) {
        Room room = new Room();
        if (request.getParameter("patientId") != null && request.getParameter("patientId") != "") {
            room.setPatientId(Integer.parseInt(request.getParameter("patientId")));
        }
        room.setStatus(request.getParameter("status"));
        return room;
    }
}
