<#-- 
	TODO: Try to get rid of this incclude, and refactor code in a way to 
	avoid using *.head.ftl since they've depricated!
	Hint: You can create some *-lib.ftl and include it!
-->
<#include "/com/alvexcore/components/form/form.get.head.ftl"> 
<!-- Start Workflow -->
<@link rel="stylesheet" type="text/css" href="${page.url.context}/res/css/components/workflow-shortcuts-admin/start-workflow.css" />
<@script type="text/javascript" src="${page.url.context}/res/js/components/workflow-shortcuts-admin/start-workflow.js" />
