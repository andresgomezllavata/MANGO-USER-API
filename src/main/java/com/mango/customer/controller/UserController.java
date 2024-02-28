package com.mango.customer.controller;

import com.mango.customer.dto.UserDTO;
import com.mango.customer.error.InvalidCredentialsException;
import com.mango.customer.error.UserAlreadyExistedException;
import com.mango.customer.error.UserNotFoundException;
import com.mango.customer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

	private UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/singin")
	public ResponseEntity<Object> getUser(@RequestParam String email, @RequestParam String password) {
		if (userService.userExists(email)) {
			if (userService.validatePassword(email, password)) {
				Optional<UserDTO> opt = userService.getUser(email);
				return opt.<ResponseEntity<Object>>map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Ha ocurrido un error inesperado, vuelva a intentar.", HttpStatus.INTERNAL_SERVER_ERROR));
			} else
				throw new InvalidCredentialsException();
		} else {
			throw new UserNotFoundException(email);
		}
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO, @RequestParam String password) {
		if (!userService.userExists(userDTO.getEmail())) {
			userService.createUser(userDTO, password);
			return new ResponseEntity<>(userDTO.getEmail() + " ha sido dado de alta correctamente.", HttpStatus.CREATED);
		} else {
			throw new UserAlreadyExistedException(userDTO.getEmail());
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateUser(@RequestParam String email, @RequestBody UserDTO user) {
		if (userService.userExists(email)) {
			userService.updateUser(email, user);
			return new ResponseEntity<>(user.getEmail() + " ha sido actualizado correctamente.", HttpStatus.OK);
		} else {
			throw new UserNotFoundException(email);
		}
	}

	@PutMapping(value = "/updatePassword")
	public ResponseEntity<Object> updatePassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword) {
		if (userService.userExists(email)) {
			if (userService.validatePassword(email, oldPassword)) {
				userService.updatePassword(email, newPassword);
				return new ResponseEntity<>("La contraseña de " + email + " ha sido actualizada correctamente.", HttpStatus.OK);
			} else {
				throw new InvalidCredentialsException();
			}
		} else {
			throw new UserNotFoundException(email);
		}
	}

	@DeleteMapping(value = "/delete/{email}")
	public ResponseEntity<Object> deleteUser(@PathVariable String email) {
		if (userService.userExists(email)) {
			userService.deleteUser(email);
			return new ResponseEntity<>(email + " ha sido eliminado correctamente de nuestra base de datos.", HttpStatus.OK);
		} else {
			throw new UserNotFoundException(email);
		}
	}

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Object> deleteAll() {
		userService.deleteAll();
		return new ResponseEntity<>("Todos los usuarios fueron eliminados de la base de datos.", HttpStatus.OK);
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<Object> getAll() {
		List<UserDTO> list = userService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
