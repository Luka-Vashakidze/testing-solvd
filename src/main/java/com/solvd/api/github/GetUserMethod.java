package com.solvd.api.github;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/${username}", methodType = HttpMethodType.GET)
public class GetUserMethod extends AbstractApiMethodV2 {
    public GetUserMethod(String username) {
        super(null, "api/github/get_user_rs.json");
        setProperties("api/github/github.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("username", username);
    }
}
