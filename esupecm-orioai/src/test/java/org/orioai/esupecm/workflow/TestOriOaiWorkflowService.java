package org.orioai.esupecm.workflow;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.orioai.esupecm.OriOaiMetadataType;
import org.orioai.esupecm.workflow.service.OriOaiWorkflowService;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@RepositoryConfig(init = DefaultRepositoryInit.class)
@Deploy({ TestOriOaiWorkflowService.OSGI_BUNDLE_NAME })
public class TestOriOaiWorkflowService {

    @Inject
    private OriOaiWorkflowService service;

    static final String OSGI_BUNDLE_NAME = "org.orioai.nuxeo.workflow";

    @Test
    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
    }

    @Test
    @Ignore
    public void testGetMetadataTypes() throws Exception {
        List<OriOaiMetadataType> metadataTypes = service.getMetadataTypes("admin");
        assertNotNull(
                "metadataTypes obtained from OriOaiWorkflowService is null ??",
                metadataTypes);
    }

}
