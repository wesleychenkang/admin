package com.vanggame.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vanggame.admin.entity.Game;

public interface GameDao {
	List<Game> queryAllGames();

	List<Game> queryGames(@Param("id") Integer id, @Param("appName") String appName, @Param("pageNo") Integer pageNo,
			@Param("pageSize") Integer pageSize);

	void removeGame(@Param("id") Integer id);

	void saveGame(Game game);
}
