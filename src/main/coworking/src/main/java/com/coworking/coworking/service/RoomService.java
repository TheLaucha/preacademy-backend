package com.coworking.coworking.service;

import com.coworking.coworking.model.Room;

import java.util.List;

public interface RoomService {
  List<Room> getAvailableRooms();
  Room saveRoom(Room room);
  Room updateRoom(Long id, Room room);
  void disableRoom(Long id);
}
