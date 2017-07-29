package com.app.search.services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.app.search.domain.ProgrammingLangDTO;

/**
 * Created by Artem Karpov
 */
@Service
public class JsonLoaderService {

	private List<ProgrammingLangDTO> data;

	@PostConstruct
	public void init() throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(new File("src/main/resources").getAbsolutePath() + "/" + "data.json")));
		Type listType = new TypeToken<ArrayList<ProgrammingLangDTO>>(){}.getType();
		data = new Gson().fromJson(content, listType);
	}

	public Stream<ProgrammingLangDTO> getDataAsStream(){
		return Collections.unmodifiableList(data).stream();
	}
}
