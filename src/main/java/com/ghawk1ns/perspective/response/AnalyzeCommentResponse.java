package com.ghawk1ns.perspective.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class AnalyzeCommentResponse extends BaseResponse {

    @JsonProperty("languages")
    public List<String> languages;

    @JsonProperty("attributeScores")
    Map<String, AttributeScores> attributeScores;

    public float getAttributeSummaryScore(String type) {
        if (attributeScores == null) {
            return 0;
        }
        AttributeScores attr = attributeScores.get(type);
        if (attr == null || attr.summaryScore == null) {
            return 0;
        }
        return attr.summaryScore.score;
    }
}
