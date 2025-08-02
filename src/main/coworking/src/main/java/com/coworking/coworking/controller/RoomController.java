package com.coworking.coworking.controller;

import com.coworking.coworking.dto.RoomRequestDTO;
import com.coworking.coworking.model.Role;
import com.coworking.coworking.model.Room;
import com.coworking.coworking.model.User;
import com.coworking.coworking.service.RoomService;
import com.coworking.coworking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class RoomController {
  private final RoomService roomService;
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<Room>> getAvailableRooms(){
    List<Room> availableRooms = roomService.getAvailableRooms();

    return ResponseEntity.ok(availableRooms);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Room> getRoomById(@PathVariable Long id){
    Room room = roomService.getRoomById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala no encontrada"));

    return ResponseEntity.status(HttpStatus.FOUND).body(room);
  }

  @PostMapping
  public ResponseEntity<Room> createRoom(@Valid @RequestBody RoomRequestDTO dto, @RequestHeader("userId") Long userId){
    User user = userService.findById(userId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    if(!user.getRole().equals(Role.ADMIN)){
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No autorizado");
    }

    Room room = new Room();

    room.setName(dto.getName());
    room.setCapacity(dto.getCapacity());
    room.setLocation(dto.getLocation());
    room.setEnabled(true);

    Room savedRoom = roomService.saveRoom(room);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody RoomRequestDTO dto){
    Room room = new Room();
    room.setId(id);
    room.setName(dto.getName());
    room.setCapacity(dto.getCapacity());
    room.setLocation(dto.getLocation());

    Room roomUpdated = roomService.updateRoom(id, room);
    return ResponseEntity.ok(roomUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> disableRoom(@PathVariable Long id){
    roomService.disableRoom(id);

    return ResponseEntity.noContent().build();
  }
}
