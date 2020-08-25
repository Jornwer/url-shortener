package com.jornwer.urlshortener.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "dataurl")
public class DataURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "URL should be not empty")
    @Column(name = "long_url")
    private String longURL;

    @NotBlank(message = "URL should be not empty")
    @Size(min = 3, message = "URL should be at least 3 characters")
    @Column(name = "short_url")
    private String shortURL;
}
