package org.orioai.esupecm.webapp.action;

import static org.nuxeo.ecm.core.api.security.SecurityConstants.*;
import static org.nuxeo.ecm.webapp.helpers.EventNames.NAVIGATE_TO_DOCUMENT;

import java.security.Principal;

import org.apache.commons.lang.StringUtils;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.core.api.UnrestrictedSessionRunner;
import org.nuxeo.ecm.core.api.security.ACE;
import org.nuxeo.ecm.core.api.security.ACL;
import org.nuxeo.ecm.core.api.security.ACP;
import org.nuxeo.ecm.platform.ui.web.api.NavigationContext;
import org.nuxeo.ecm.platform.usermanager.UserManager;
import org.nuxeo.runtime.api.Framework;

/**
 * @author <a href="mailto:ak@nuxeo.com">Arnaud Kervern</a>
 * @since 5.7
 */
@Scope(ScopeType.CONVERSATION)
@Name("userRpn")
public class UserRPNActions {
    public static final String RPN_PATH_KEY = "rpn.path";

    @In
    protected transient CoreSession documentManager;

    @In(create = true)
    protected transient FacesMessages facesMessages;

    @In
    protected transient Principal currentUser;

    @In
    protected transient UserManager userManager;

    @In(required = false)
    protected transient NavigationContext navigationContext;

    protected boolean checked = false;

    @Observer({ NAVIGATE_TO_DOCUMENT })
    public void createUserRpn() throws ClientException {
        final String rpnPath = Framework.getProperty(RPN_PATH_KEY, "/default-domain/workspaces/Ressources pédagogique n");
        if (checked || navigationContext == null
                || "system".equals(currentUser.getName())
                || StringUtils.isBlank(rpnPath)) {
            return;
        }

        checked = true;

        if (documentManager.exists(new PathRef(rpnPath))) {
            final NuxeoPrincipal nxp = (NuxeoPrincipal) currentUser;
            final String userDocName = String.format("%s", nxp.getName());
            final String userDocPath = String.format("%s/%s", rpnPath,
                    userDocName);

            if (!documentManager.exists(new PathRef(userDocPath))) {
                new UnrestrictedSessionRunner(documentManager) {
                    @Override
                    public void run() throws ClientException {
                        DocumentModel folder = session.createDocumentModel(
                                rpnPath, userDocName, "Folder");
                        String dcTitle = nxp.getName();
                        if (!StringUtils.isBlank(nxp.getFirstName()
                                + nxp.getLastName())) {
                            dcTitle = String.format("%s_%s",
                                    nxp.getFirstName(), nxp.getLastName());
                        }
                        folder.setPropertyValue("dc:title", dcTitle);
                        folder = session.createDocument(folder);

                        ACP acp = session.getACP(folder.getRef());
                        ACL local = acp.getOrCreateACL("local");
                        local.add(new ACE(nxp.getName(), READ_WRITE, true));
                        local.add(new ACE(EVERYONE, EVERYTHING, false));

                        session.setACP(folder.getRef(), acp, true);
                    }
                }.runUnrestricted();
            }
        }
    }
}
