<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/test/style.css" />
    
     <script src="${pageContext.servletContext.contextPath}/js/test/smart-table.debug.js"></script>
     <script src="${pageContext.servletContext.contextPath}/js/test/lrInfiniteScrollPlugin.js"></script>
    
	<script src="${pageContext.servletContext.contextPath}/js/test/testController.js"></script>
</head>
 <body >
    <div class="table-container" ng-controller="testCtrl">
      <table st-table="rowCollection" st-pagination-scroll  st-pipe="callServer" class="table table-striped">
    <thead>
    <tr>
        <th st-sort="firstName">first name</th>
        <th st-sort="lastName">last name</th>
        <th st-sort="birthDate">birth date</th>
        <th st-sort="balance">balance</th>
        <th>email</th>
    </tr>
   
    </thead>
    <tbody>
    <tr ng-repeat="row in rowCollection">
        <td>{{row.firstName | uppercase}}</td>
        <td>{{row.lastName}}</td>
        <td>{{row.birthDate | date}}</td>
        <td>{{row.balance | currency}}</td>
        <td><a ng-href="mailto:{{row.email}}">email</a></td>
    </tr>
    </tbody>
</table>
</div>
<div ng-show="isLoading" class="loading-indicator"></div>
</body>
</html>