/**
 * Copyright 1999-2014 dangdang.com.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.config.service.web.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.test.config.service.IAuthService;
import com.test.config.service.zkresource.observer.AbstractSubject;

/**
 * 节点授权
 * 
 * @author <a href="mailto:wangyuxuan@dangdang.com">Yuxuan Wang</a>
 *
 */
@ManagedBean(name = "nodeAuthMB")
@SessionScoped
public class NodeAuthManagedBean extends AbstractSubject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String nodeName;

    private String password;

    private String authedNode;

    @ManagedProperty(value = "#{authService}")
    private IAuthService authService;

    public void checkAuth() {
        boolean login = authService.checkAuth(nodeName, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (login) {
            context.addMessage(null, new FacesMessage("Login suc."));
            authedNode = nodeName;
            notify(authedNode, null);
        } else {
            context.addMessage(null, new FacesMessage("Login fail."));
        }
    }

    public void grantAuth() {
        boolean login = authService.auth(nodeName, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (login) {
            context.addMessage(null, new FacesMessage("Grant auth suc."));
            authedNode = nodeName;
            notify(authedNode, null);
        } else {
            context.addMessage(null, new FacesMessage("Node auth has been granted, cannot do duplicate grant."));
        }
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthService(IAuthService authService) {
        this.authService = authService;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthedNode() {
        return authedNode;
    }

    public void setAuthedNode(String authedNode) {
        this.authedNode = authedNode;
    }

}
