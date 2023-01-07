package com.rowha.iljalleo.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rowha.iljalleo.project.model.GitToNotionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/git-to-notion")
@RequiredArgsConstructor
public class GitToNotionController {

    @PostMapping
    public Map<String, Object> exportGitCommitHistoryToNotion(@RequestBody Map<String, Object> jsonMap)
            throws JsonProcessingException {
        String url = "https://api.notion.com/v1/pages";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("secret_lcWclh8J0HKh2EZ8xrFm0DSIYvopWELKnTZ0NK5qNCQ");
        headers.set("Notion-Version", "2022-06-28");

        ObjectMapper mapper = new ObjectMapper();
        String jsonBodyStr = mapper.writeValueAsString(jsonMap);

        HttpEntity<String> entity = new HttpEntity<String>(jsonBodyStr, headers);

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> result = restTemplate.postForObject(url, entity, Map.class);
        return result;
    }
}
