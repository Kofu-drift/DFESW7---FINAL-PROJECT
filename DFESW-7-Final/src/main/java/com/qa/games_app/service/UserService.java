package com.qa.games_app.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.games_app.data.entity.Games;
import com.qa.games_app.data.repository.UserRepository;
import com.qa.games_app.exceptions.GameNotFoundException;

@Service
public class UserService {

	private UserRepository repo;
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	
	
	// CRUD FUNCTIONALITY
	
	
		public Games addgame(Games games) {
		return this.repo.save(games);
		}
	
	
		public List<Games> getAllGames() {
		return this.repo.findAll();
		
	}
	
		public Games getById(Long id) {
			if(repo.existsById(id)) {
				return repo.findById(id).get();
			}
			throw new GameNotFoundException("Game with id " + id + " cannot be found");
		}
	
		public Games updateGame(long id, Games newGame) {

			Games update = this.repo.getById(id);

			// update the data
			update.setgDeveloper(newGame.getgDeveloper());
			update.setgGenre(newGame.getgGenre());
			update.setgPlatform(newGame.getgPlatform());
			update.setgProducer(newGame.getgProducer());
			update.setgTitle(newGame.getgTitle());
			update.setrDate(newGame.getrDate());
			// Save "newGame" back to the database and JPA updates for us
			return this.repo.save(update);
			
	}
	
	// Delete is a boolean to show whether the delete method has functioned properly
		public boolean removeGame(long id) {
		this.repo.deleteById(id);
		// Checks repo to see if the id still exists
		boolean exist = this.repo.existsById(id);
		// returns true is id doesn't exist
		return !exist;
		}
	
	
	
	
	



}
