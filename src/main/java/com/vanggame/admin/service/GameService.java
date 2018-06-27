package com.vanggame.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.GameDao;
import com.vanggame.admin.entity.Game;
import com.vanggame.admin.util.EncryptUtils;

@Service
public class GameService {

	@Autowired
	private GameDao gameDao;

	public List<Game> queryAllGames() {

		return gameDao.queryAllGames();

	}
	
	public int queryAllGamesCount(List<String> perrsion){
		
		return 	gameDao.queryAllGamesCount( perrsion);
		
	}
	

	public List<Game> queryGames(Integer appId, String appName, Integer pageNo, Integer pageSize,
			List<String> perrsion) {
		Integer firstIndex= null;
		Integer lastIndex= null;
		if(null!=pageNo && null!=pageSize){
		 firstIndex = (pageNo - 1) * pageSize;
		 lastIndex = pageNo * pageSize;
		}
		return gameDao.queryGames(appId, appName, firstIndex, lastIndex, perrsion);
	}

	public void saveGame(Game game) {
		String key_t = EncryptUtils.md5(System.currentTimeMillis() + "aaakdjlafkjdlslfdsfjdsfklj");
		String scret_t = EncryptUtils.md5(System.currentTimeMillis() + "adfasdfsdfasfwetrggagdsf");
		game.setKey(key_t);
		game.setAppSecret(scret_t);
		gameDao.saveGame(game);
	}

	public void upDateGame(Game game) {

	}

}
