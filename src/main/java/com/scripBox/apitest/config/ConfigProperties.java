package com.scripBox.apitest.config;

import com.qapitol.sauron.common.configuration.AbstractConfigInitializer;
import com.qapitol.sauron.common.configuration.Config;
import org.testng.ISuite;
import org.testng.ITestContext;

public class ConfigProperties extends AbstractConfigInitializer {

    private static final String PROP_FILENAME = "ScripBox";
    private static final String PROP_DATA_FOLDER = "src/test/resources/";

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void initialize(ITestContext iTestContext) {
    }


    @Override
    public void initialize(ISuite iSuite) {
        String dataLocaleFile = PROP_DATA_FOLDER + PROP_FILENAME + ".properties";
        Config.loadProperties(dataLocaleFile);
    }

    }

