package org.apache.dubbo.sample.tri.direct;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.sample.tri.BaseTriPojoClientTest;
import org.apache.dubbo.sample.tri.util.TriSampleConstants;
import org.apache.dubbo.sample.tri.api.PojoGreeter;

import org.junit.BeforeClass;

public class TriDirectPojoClientTest extends BaseTriPojoClientTest {

    @BeforeClass
    public static void initStub() {
        ReferenceConfig<PojoGreeter> ref = new ReferenceConfig<>();
        ref.setInterface(PojoGreeter.class);
        ref.setCheck(false);
        ref.setTimeout(3000);
        ref.setUrl(TriSampleConstants.DEFAULT_ADDRESS);
        ref.setProtocol(CommonConstants.TRIPLE);
        ref.setLazy(true);

        ReferenceConfig<PojoGreeter> ref2 = new ReferenceConfig<>();
        ref2.setInterface(PojoGreeter.class);
        ref2.setCheck(false);
        ref2.setTimeout(15000);
        ref2.setUrl(TriSampleConstants.DEFAULT_ADDRESS);
        ref2.setRetries(0);
        ref2.setProtocol(CommonConstants.TRIPLE);
        ref2.setLazy(true);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        ApplicationConfig applicationConfig = new ApplicationConfig(TriDirectPojoClientTest.class.getName());
        applicationConfig.setMetadataServicePort(TriSampleConstants.CONSUMER_METADATA_SERVICE_PORT);
        bootstrap.application(applicationConfig)
                .reference(ref)
                .start();
        delegate = ref.get();
        longDelegate = ref2.get();
        appDubboBootstrap = bootstrap;
    }

}
