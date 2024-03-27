package com.jt.secure.yml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class SecureIgnoreUrlsYml {

    private List<String> urls = new ArrayList<>();
}
