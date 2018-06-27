package com.vanggame.admin.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vanggame.admin.entity.Admin;
import com.vanggame.admin.entity.Game;
import com.vanggame.admin.log.Log;
import com.vanggame.admin.service.AdminService;
import com.vanggame.admin.service.GameService;

@Controller
@RequestMapping(value = "admin/games")
public class GameControl extends BaseControl {

	@Autowired
	private GameService gameService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "showGames", produces = ("application/text;charset=utf-8"))
	public String showGames() {
		return "games";

	}

	@RequestMapping(value = "getAllGames", produces = ("text/json;charset=utf-8"))
	@ResponseBody
	public String getAllGames(HttpSession session, Integer appID, String name, Integer page, Integer rows) {
		System.out.println("start all games appId" + appID + "name" + name + "page" + page + "rows" + rows);
		Log.d("start all games appId:%s;name:%s;page:%s;rows:%s", appID, name, page, rows);
		Admin admin = getSessionAdmin(session);
		List<String> permiss = adminService.getPermissonedGameIDs(admin);
		int count = gameService.queryAllGamesCount(permiss);
		System.out.println("count" + count);
		List<Game> list = gameService.queryGames(appID, name, page, rows, permiss);

		JSONArray array = new JSONArray();
		for (Game game : list) {
			array.add(game.toJsonObject());
		}

		JSONObject json = new JSONObject();
		json.put("rows", array);
		json.put("total", count);
		System.out.println("all game" + json.toJSONString());
		return json.toJSONString();
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
			e.printStackTrace();
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
