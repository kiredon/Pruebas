<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/test/style.css" />
    
     <script src="${pageContext.servletContext.contextPath}/js/test/smart-table.debug.js"></script>
     <%-- <script src="${pageContext.servletContext.contextPath}/js/test/lrInfiniteScrollPlugin.js"></script> --%>
     <script src="${pageContext.servletContext.contextPath}/js/test/lrDragNDrop.js"></script>
    
	<script src="${pageContext.servletContext.contextPath}/js/test/test2Controller.js"></script>
</head>
 <body >
    <div class="table-container" ng-controller="mainCtrl">
 
      <table st-table="rowCollection" class="table table-striped" class="ui celled blue striped table">
    <thead>
    <tr>
        <th lr-drag-src="headers" lr-drop-target="headers" ng-repeat="col in columns" st-sort="{{col}}">{{col}}</th>
    </tr>
    <tr>
        <th>
            <input st-search="firstName" placeholder="search for firstname" class="input-sm form-control" type="search"/>
        </th>
        <th colspan="4">
            <input st-search placeholder="global search" class="input-sm form-control" type="search"/>
        </th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="row in rowCollection">
        <td ng-repeat="col in columns">{{row[col]}}</td>
    </tr>
    </tbody>
</table>
</div>
<div ng-show="isLoading" class="loading-indicator"></div>
</body>
</html>