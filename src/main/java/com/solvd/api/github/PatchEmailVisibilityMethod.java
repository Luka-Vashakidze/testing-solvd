package com.solvd.api.github;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user/email/visibility", methodType = HttpMethodType.PATCH)
public class PatchEmailVisibilityMethod extends AbstractApiMethodV2 {
    public PatchEmailVisibilityMethod() {
        super(null, "api/github/patch_email_visibility_rs.json");
        setProperties("api/github/github.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
