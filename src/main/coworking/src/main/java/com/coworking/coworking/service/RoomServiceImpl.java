package com.coworking.coworking.service;


import com.coworking.coworking.model.Room;
import com.coworking.coworking.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
  private final RoomRepo roomRepo;

  @Override
  public List<Room> getAvailableRooms() {
    return roomRepo.findAll().stream()
        .filter(room -> room.isEnabled())
        .toList();
  }

  @Override
  public Room saveRoom(Room room) {
    return roomRepo.save(room);
  }

  @Override
  public Room updateRoom(Long id, Room room) {
    Room existingRoom = roomRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

    existingRoom.setName(room.getName());
    existingRoom.setCapacity(room.getCapacity());
    existingRoom.setLocation(room.getLocation());
    return roomRepo.save(existingRoom);
  }

  @Override
  public void disableRoom(Long id) {
    Room roomToDisable = roomRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Sala no encontrada"));
    roomToDisable.setEnabled(false);
    roomRepo.save(roomToDisable);
  }
}
