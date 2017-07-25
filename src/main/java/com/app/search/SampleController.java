package com.app.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.app.search.domain.ProgrammingLangDTO;

@Controller
public class SampleController {

	@Autowired
	private JsonLoaderService service;

	private final String regex = "\\s+";

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getitem(@RequestParam("query") String query) {
		Gson gson = new Gson();
		String[] splited = query.split(regex);
		return Arrays.stream(splited).map(this::getListByCriteria)
				.flatMap(f -> f)
				.map(gson::toJson)
				.collect(Collectors.toList());
	}

	private Stream<ProgrammingLangDTO> getListByCriteria(String query) {
		return service.getDataAsStream()
					.filter(programmingLangDTO -> programmingLangDTO.getName().contains(query)
							|| Arrays.asList(programmingLangDTO.getDesignedBy().split(regex)).contains(query)
							|| Arrays.asList(programmingLangDTO.getType().split(regex)).contains(query));
	}

}