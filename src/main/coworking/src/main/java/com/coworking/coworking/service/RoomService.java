package com.coworking.coworking.service;

import com.coworking.coworking.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
  List<Room> getAvailableRooms();
  Optional<Room> getRoomById(Long id);
  Room saveRoom(Room room);
  Room updateRoom(Long id, Room room);
  void disableRoom(Long id);
}
