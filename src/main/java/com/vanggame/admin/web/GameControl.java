package com.vanggame.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vanggame.admin.entity.Game;

@Controller
@RequestMapping(value = "admin/games")
public class GameControl extends BaseControl {

	@RequestMapping(value = "showGames", produces = ("application/text;charset=utf-8"))
	public String showGames() {
		return "games";

	}

	@RequestMapping(value = "getAllGames", produces = ("application/text;charset=utf-8"))
	@ResponseBody
	public String getAllGames(){
		
		
		return "";

	}

	/**
	 * 添加游戏
	 * 
	 * @param game
	 */
	@RequestMapping(value = "saveGame")
	@ResponseBody
	public void saveGame(Game game) {

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
