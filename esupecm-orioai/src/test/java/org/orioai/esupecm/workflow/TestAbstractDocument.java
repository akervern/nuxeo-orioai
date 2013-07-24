package org.orioai.esupecm.workflow;

import java.util.Date;
import java.util.Random;

import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.core.api.impl.blob.ByteArrayBlob;
import org.nuxeo.ecm.core.api.impl.blob.StringBlob;

import com.google.inject.Inject;

abstract public class TestAbstractDocument {

    protected static final String OSGI_BUNDLE_NAME = "org.orioai.nuxeo.workflow";

    protected final Random random = new Random(new Date().getTime());

    @Inject
    protected CoreSession coreSession;

    public DocumentRef createSampleFile() throws Exception {
        DocumentModel dm = coreSession.createDocumentModel("/", "file#"
                + String.valueOf(random.nextLong()), "File");
        dm = coreSession.createDocument(dm);

        coreSession.save();

        dm.setProperty("dublincore", "title", "Indexable data");
        dm.setProperty("dublincore", "description", "Indexable description");
        dm.setProperty("file", "filename", "foo.pdf");
        String[] contributors = new String[] { "a", "b" };
        dm.setProperty("dublincore", "contributors", contributors);

        // add a blob
        StringBlob sb = new StringBlob("<doc>Indexing baby</doc>");
        byte[] bytes = sb.getByteArray();
        Blob blob = new ByteArrayBlob(bytes, "text/html", "ISO-8859-15");
        dm.setProperty("file", "content", blob);

        dm.setProperty("dublincore", "created", new Date());

        dm = coreSession.saveDocument(dm);
        coreSession.save();

        return dm.getRef();
    }
}
