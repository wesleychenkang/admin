package com.vanggame.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.vanggame.admin.entity.Game;
import com.vanggame.admin.service.GameService;

@Controller
@RequestMapping(value = "admin/games")
public class GameControl extends BaseControl {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "showGames", produces = ("application/text;charset=utf-8"))
	public String showGames() {
		return "games";

	}

	@RequestMapping(value = "getAllGames", produces = ("application/text;charset=utf-8"))
	@ResponseBody
	public String getAllGames() {
		List<Game> list = gameService.queryAllGames();
		JSONArray array = new JSONArray();
		for (Game game : list) {
			array.add(game.toJsonObject());

		}
		return array.toJSONString();

	}

	/**
	 * 添加游戏
	 * 
	 * @param game
	 */
	@RequestMapping(value = "saveGame")
	@ResponseBody
	public String saveGame(Game game) {
		try {
			gameService.saveGame(game);
			return renderState(true, "add sucess");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return renderState(false, "add fail");
	}

	/**
	 * 删除当前app
	 * 
	 * @param currAppID
	 */
	@RequestMapping(value = "removeGame")
	@ResponseBody
	public void removeGame(int currAppID) {

	}

}
