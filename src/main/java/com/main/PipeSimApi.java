package com.main;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.Network;

@RestController
public class PipeSimApi {
	Network network = null;


	@GetMapping("/")
	public String index(@RequestParam String name ) {
		return String.format("Welcome %s to PipeSim!", name);
	}

	
	@PostMapping("/build_network")
	// build static network
	public String buildNetwork(@RequestBody final String networkJson) {
		// parse to map
		final JSONObject networkObj = JSON.parseObject(networkJson);
		final String name = networkObj.getString("name");
		// ??
		network = new Network(networkObj);
		return String.format("Finish building %s", name); 
	}

	@GetMapping("/head_loss") 
	// input dynamic hydrualic data
	public double calHeadLoss(@RequestBody String hydrualicJson) {
		network.inputData();
		// get the calculated data
		double headLoss = network.getHeadLoss();
		return 0;
	}
}
