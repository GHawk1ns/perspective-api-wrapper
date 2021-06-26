package com.ghawk1ns.perspective.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://github.com/conversationai/perspectiveapi/blob/master/api_reference.md#models
 */
public class Attribute {

    /**
     * For more information visit
     https://developers.perspectiveapi.com/s/about-the-api-attributes-and-languages
     */

    public static final String TOXICITY = "TOXICITY";
    public static final String TOXICITY_EXPERIMENTAL = "TOXICITY_EXPERIMENTAL";
    public static final String SEVERE_TOXICITY = "SEVERE_TOXICITY";
    public static final String SEVERE_TOXICITY_EXPERIMENTAL = "SEVERE_TOXICITY_EXPERIMENTAL";
    public static final String IDENTITY_ATTACK = "IDENTITY_ATTACK";
    public static final String IDENTITY_ATTACK_EXPERIMENTAL = "IDENTITY_ATTACK_EXPERIMENTAL";
    public static final String INSULT = "INSULT";
    public static final String INSULT_EXPERIMENTAL = "INSULT_EXPERIMENTAL";
    public static final String PROFANITY = "PROFANITY";
    public static final String PROFANITY_EXPERIMENTAL = "PROFANITY_EXPERIMENTAL";
    public static final String THREAT = "THREAT";
    public static final String THREAT_EXPERIMENTAL = "THREAT_EXPERIMENTAL";
    public static final String SEXUALLY_EXPLICIT = "SEXUALLY_EXPLICIT";
    public static final String FLIRTATION = "FLIRTATION";


    @JsonIgnore
    public final String type;

    @JsonProperty("scoreType")
    public String scoreType;

    @JsonProperty("scoreThreshold")
    public float scoreThreshold;

    private Attribute(String type) {
        this.type = type;
    }

    public static Attribute ofType(String type) {
        return new Attribute(type);
    }

    public Attribute setScoreType(String scoreType) {
        this.scoreType = scoreType;
        return this;
    }

    public Attribute setScoreThreshold(float scoreThreshold) {
        this.scoreThreshold = scoreThreshold;
        return this;
    }
}
