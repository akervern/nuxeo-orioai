package org.orioai.esupecm.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.runtime.api.Framework;
import org.orioai.esupecm.nuxeo2xml.service.OriOaiNuxeo2XmlService;


public class TestOriOaiNuxeo2XmlService extends TestAbstractDocument {

	protected OriOaiNuxeo2XmlService service;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = Framework.getService(OriOaiNuxeo2XmlService.class);
    }

    @Test
    @Ignore
    public void testServiceRegistration() throws Exception {
        assertNotNull(service);
        Map<String, URL> xslMap = null;//(Map<String, URL>)((OriOaiNuxeo2XmlServiceImpl)service).getXslMap();
        assertFalse("xslMap is empty ! :-(", xslMap.isEmpty());
    }

    @Test
    public void testDocToXml() throws Exception {
    	DocumentModel doc =  coreSession.getDocument(createSampleFile());
    	//service.docToXml(coreSession, doc, "document");
    }

}
