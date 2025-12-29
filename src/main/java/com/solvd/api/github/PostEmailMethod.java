package com.solvd.api.github;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user/emails", methodType = HttpMethodType.POST)
public class PostEmailMethod extends AbstractApiMethodV2 {
    public PostEmailMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}