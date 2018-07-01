package com.vanggame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vanggame.admin.entity.Game;

public interface GameDao {

	int queryAllGamesCount(@Param("perrsion") List<String> perrsion);

	List<Game> queryAllGames();

	List<Game> queryGames(@Param("appId") Integer appId, @Param("appName") String appName,
			@Param("currIndex") Integer currIndex, @Param("pageSize") Integer pageSize,
			@Param("perrsion") List<String> perrsion);

	void removeGame(@Param("id") Integer id);

	void saveGame(Game game);

	void updateGame(Game game);

}
