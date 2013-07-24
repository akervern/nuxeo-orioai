package org.orioai.esupecm.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.test.DefaultRepositoryInit;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.orioai.esupecm.nuxeo2xml.service.OriOaiNuxeo2XmlService;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@RepositoryConfig(init = DefaultRepositoryInit.class)
@Deploy({ TestAbstractDocument.OSGI_BUNDLE_NAME })
public class TestOriOaiNuxeo2XmlService extends TestAbstractDocument {

    @Inject
    protected OriOaiNuxeo2XmlService service;

    @Test
    @Ignore
    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
        Map<String, URL> xslMap = null;// (Map<String,
                                       // URL>)((OriOaiNuxeo2XmlServiceImpl)service).getXslMap();
        assertFalse("xslMap is empty ! :-(", xslMap.isEmpty());
    }

    @Test
    public void testDocToXml() throws Exception {
        DocumentModel doc = coreSession.getDocument(createSampleFile());
        // service.docToXml(coreSession, doc, "document");
    }

}
