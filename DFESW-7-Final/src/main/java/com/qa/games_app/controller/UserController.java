package com.qa.games_app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.games_app.data.entity.Games;
import com.qa.games_app.service.UserService;

@RestController


public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping ("/create")
	public Games addGame(@RequestBody Games game) {
		return this.service.addgame(game);
	}
	
	@GetMapping("/getAll")
	public List<Games> getAllGames() {
		return this.service.getAllGames();
		
	}
	@PutMapping("/update/{id}")
	public Games updateGames(@PathVariable Long id, @RequestBody Games game) {
		return this.service.updateGame(id, game);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean removeGame(@PathVariable Long id) {
		return this.service.removeGame(id);
	}
}