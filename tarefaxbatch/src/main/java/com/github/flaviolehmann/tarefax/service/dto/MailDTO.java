package com.github.flaviolehmann.tarefax.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailDTO {

    private String title;
    private String description;

    @Override
    public String toString() {
        return "MailDTO{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
