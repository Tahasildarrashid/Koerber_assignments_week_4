package com.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "information")
public class Information {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
