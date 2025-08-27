package br.com.tuitter.tuitter_api.dtos;

import br.com.tuitter.tuitter_api.entities.Tuitter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TuitterResponse {

    @JsonProperty
    private final Long id;

    @JsonProperty
    private final String content;

    @JsonProperty
    private final String type;

    @JsonProperty
    private final String authorUsername;

    public TuitterResponse(Tuitter tuitter) {
        this.id = tuitter.getId();
        content = tuitter.getContent();
        type = tuitter.getType().name();
        authorUsername = tuitter.getAuthor().getUsername();
    }

}
