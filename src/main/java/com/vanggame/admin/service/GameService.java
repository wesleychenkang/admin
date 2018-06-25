package com.vanggame.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanggame.admin.dao.GameDao;
import com.vanggame.admin.entity.Game;

@Service
public class GameService {

	@Autowired
	private GameDao gameDao;
	

	public List<Game> queryAllGames() {

		return gameDao.queryAllGames();

	}
	
	
	public List<Game> queryGames(Integer appId,String appName,Integer pageNo,Integer pageSize){
		
		return gameDao.queryGames(appId, appName, pageNo, pageSize);
	}
	
	
	

}
