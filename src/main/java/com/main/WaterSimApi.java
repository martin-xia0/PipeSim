package com.main;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.Network;

@RestController
public class WaterSimApi {


	@GetMapping("/")
	public String index() {
		return "Welcome to WaterSim!";
	}

	
	@PostMapping("/build_network")
	public String calHeadLose(@RequestBody final String networkJson) {
		final JSONObject networkObj = JSON.parseObject(networkJson);
		final String name = networkObj.getString("name");
		// logger.info(name);
		Network network = new Network(networkObj);
		return String.format("Hello %s", name); 
	}

	// @GetMapping("/head_loss") 
	// public String calHeadLose(@RequestBody String hydroJson) {
		// v, q
	// 	return ""; 
	// }
}
