/**
 * Copyright © 2012 ITD Systems
 *
 * This file is part of Alvex
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alvexcore.repo;

import java.util.HashSet;
import java.util.Set;

import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.security.authentication.AuthenticationUtil.RunAsWork;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.security.AuthorityService;
import org.alfresco.service.cmr.security.AuthorityType;

import com.alvexcore.repo.workflow.activiti.WorkflowPermissionManager;

/**
 * WorkflowPermissions extension implementation
 */

public class WorkflowPermissionsExtension extends RepositoryExtension {

	public static final String ROOT_GROUP_NAME = "alvex_workflow_groups";

	// constructor
	public WorkflowPermissionsExtension() throws Exception {
		id = "workflow-permissions";
		fileListPath = "alvex-workflow-permissions-file-list.txt";
		extInfoPath = "alvex-workflow-permissions.properties";
	}

	@Override
	public void init(boolean failIfInitialized) throws Exception {
		super.init(failIfInitialized);
		AuthorityService as = serviceRegistry.getAuthorityService();
		if (!as.authorityExists(as.getName(AuthorityType.GROUP,
				WorkflowPermissionsExtension.ROOT_GROUP_NAME))) {
			Set<String> zones = new HashSet<String>();
			zones.add(WorkflowPermissionManager.ZONE_ALVEX);
			as.createAuthority(AuthorityType.GROUP,
					WorkflowPermissionsExtension.ROOT_GROUP_NAME,
					WorkflowPermissionsExtension.ROOT_GROUP_NAME, zones);
		}
	}

	void upgradeConfiguration(String oldVersion, String oldEdition) {
		//
	}

}
