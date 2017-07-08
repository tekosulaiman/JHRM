package org.module.sysadmin.service;

import org.module.sysadmin.model.SecUser;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
public interface LoginService {
    SecUser getLoginUser(String usrLoginName, String usrPassword);
}