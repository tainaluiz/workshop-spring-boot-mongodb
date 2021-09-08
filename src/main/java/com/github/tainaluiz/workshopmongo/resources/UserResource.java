package com.github.tainaluiz.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.tainaluiz.workshopmongo.domain.User;
import com.github.tainaluiz.workshopmongo.dto.UserDTO;
import com.github.tainaluiz.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
}
