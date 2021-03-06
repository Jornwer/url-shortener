package com.jornwer.urlshortener.data;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "urls")
public class Urls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "URL should be not empty")
    @URL(message = "This should be an URL")
    @Size(max = 255, message = "URL should be maximum 255 characters long")
    @Column(name = "long_url")
    private String longUrl;

    @NotBlank(message = "URL should be not empty")
    @Size(min = 3, max = 255, message = "URL should be from 3 to 255 characters long")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "URL should contain only letters and digits")
    @Column(name = "short_url")
    private String shortUrl;
}