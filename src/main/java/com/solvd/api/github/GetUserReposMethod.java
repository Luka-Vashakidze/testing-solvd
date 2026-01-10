package com.solvd.api.github;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users/${username}/repos", methodType = HttpMethodType.GET)
public class GetUserReposMethod extends AbstractApiMethodV2 {
    public GetUserReposMethod(String username) {
        super(null, "api/github/get_user_repos_rs.json");
        setProperties("api/github/github.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("username", username);
    }
}
