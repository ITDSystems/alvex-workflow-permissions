[![Build Status](https://travis-ci.org/ITDSystems/alvex-workflow-permissions.svg?branch=master)](https://travis-ci.org/ITDSystems/alvex-workflow-permissions)

Alvex Workflow Permissions
========================

Features:
* Permission Manager provides assignees access (rw or ro) to all files and documents attached to the task.
* Lock Manager allows to lock documents during they are on review.
* New dashlet on user and site dashboard to start workflows in one-click.
* Permissions for groups and orgchart roles to limit access to some business process types. Sample use case: document registration workflow can be available for secretaries only and budget approval workflow only for managers. Permissions are set by administrator and enforced through the whole system.

Compatible with Alfresco 5.1.

This component depends on:
* [Alvex Utils](https://github.com/ITDSystems/alvex-utils)

# Downloads

Download ready-to-use Alvex components via [Alvex](https://github.com/ITDSystems/alvex#downloads).

# Build from source

To build Alvex follow [this guide](https://github.com/ITDSystems/alvex#build-component-from-source).

# Use

### Configuring Permission Manager

Add the following bean to your workflow context to enable Alvex Permission Manager:
```
<bean id="your_bean_id" parent="alvex-custom-workflows-permission-manager">
	<property name="matches">
		<list>
			<value>task-assign-after-change:.*@PROCESS_ID</value>
			<value>task-done:.*@PROCESS_ID</value>
			<value>process-start@PROCESS_ID</value>
		</list>
	</property>
</bean>
```

*PROCESS_ID* is ID of your workflow. This basic configuration gives all workflow participants read only permissions to the files. If you are to give users additional rights, you need more complex configuration:
```
<bean id="your_bean_id" parent="alvex-custom-workflows-permission-manager">
	<property name="matches">
		<list>
			<value>task-assign-after-change:.*@PROCESS_ID</value>
			<value>task-done:.*@PROCESS_ID</value>
			<value>process-start@PROCESS_ID</value>
		</list>
	</property>
	<property name="filePermission">
		<value>read-write</value>
	</property>
</bean>
```

Additional property filePermission controls what rights assignees are given. There are several valid values for filePermission:
* Alfresco roles: CONSUMER, CONTRIBUTOR, EDITOR, COORDINATOR
* Short options for convenience: 'read' or just 'ro' - assignees get read only access to files (CONSUMER role), 'read-write' or just 'rw' - assignees get read-write access to files (EDITOR role)

To allow workflow participants to add new files to the package after workflow has been started you should override default bpm:packageActionGroup property for your task by adding following section to the custom task model:
```
<overrides>
	<property name="bpm:packageActionGroup">
		<default>add_package_item_actions</default>
	</property>
</overrides>
```

To allow workflow participants to delete and to update files in the package after workflow has been started you should override default bpm:packageItemActionGroup property for your task by adding following section to the custom task model:
```
<overrides>
	<property name="bpm:packageItemActionGroup">
		<default>edit_and_remove_package_item_actions</default>
	</property>
</overrides>
```

To allow workflow participants to add, delete and update files in the package, override both properties.

### Configuring Lock Manager

To lock the documents in a workflow package add the following bean to workflow context (sample):
```
<bean id="your_bean_id-lock" class="com.alvexcore.repo.workflow.activiti.WorkflowLockManager" parent="alvex-activiti-connector-activiti-listener">
	<property name="matches">
		<list>
			<value>task-create:Review Document@alvex-parallel-review-20</value>
		</list>
	</property>
	<property name="action">
		<value>LOCK</value>
	</property>
</bean>

<bean id="your_bean_id-unlock" class="com.alvexcore.repo.workflow.activiti.WorkflowLockManager" parent="alvex-activiti-connector-activiti-listener">
	<property name="matches">
		<list>
			<value>task-create:Revise Document@alvex-parallel-review-20</value>
			<value>process-end@alvex-parallel-review-20</value>
		</list>
	</property>
	<property name="action">
		<value>UNLOCK</value>
	</property>
</bean>
```

The first bean describes the stage of the workflow on which the document should be locked. The second bean describes the stage of the workflow on which the document should be unlocked.

**Note:** Do not forget to unlock documents if the workflow has been canceled!


### Configuring permissions to start workflows

Administrator can configure workflows availability for users in admin console:
![image](http://docs.alvexcore.com/en-US/Alvex/2.1/html-single/Admin_Guide/images/img24.png)
