package com.scripBox.apitest.impl;


import com.qapitol.sauron.common.configuration.Config;
import com.scripBox.apitest.pojos.Credentials;
import com.scripBox.apitest.pojos.ResToken;
import com.scripBox.apitest.ScripBoxApi;
import com.qapitol.sauron.api.providers.LoginService;
import com.qapitol.sauron.logging.SauronLogger;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import java.util.Map;

public class LoginServiceImpl implements LoginService {


    @Override
    public Map<String, String> login() {
        Config.getConfigProperty("password");
        JAXRSClientFactoryBean bean = getJaxRsClientFactoryBean();
        bean.setResourceClass(ScripBoxApi.class);
        ScripBoxApi scripBoxApi = bean.create(ScripBoxApi.class);
        Credentials credentials = new Credentials();
        credentials.setEmail(Config.getConfigProperty("email"));
        credentials.setPassword(Config.getConfigProperty("password"));
        ResToken users = scripBoxApi.RegisterAPI(credentials);
        SauronLogger.getLogger().info("Login called and Token is " + users.getToken());
        return Map.of("Authorization", "Bearer " + users.getToken());
    }
}
