<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template ><jsp:attribute name="title">JDBC Page</jsp:attribute>
    <jsp:attribute name="content">
        <c:url value="/jdbcQueryAllUsers" var="jdbcQueryAllUsers"/>
        <c:url value="/jdbcInsert" var="jdbcInsert"/>
        <c:url value="/jdbcSelectLogs" var="jdbcSelectLogs"/>
        <c:url value="/jdbcDelete" var="jdbcDelete"/>
        <c:url value="/jdbcUpdate" var="jdbcUpdate"/>

        <div class="container">

            <!--Page Heading/Breadcrumbs-->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">JDBC in Spring <small>JDBCTemplate</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="/index.html">Home</a></li>
                        <li class="active"> JDBC sidebar page</li>
                    </ol>
                </div>
            </div>

            <!--Content Row-->
            <div class="row">
            <form>

                <!--Sidebar column-->
                <div class="col-md-3">
                    <div class="list-group">
                        <a href="/index.html" class="list-group-item">Home</a>
                        <a href="${jdbcQueryAllUsers}" class="list-group-item">Get all users</a>
                        <a href="${jdbcInsert}/logstring/jdbcTestLogString" class="list-group-item">JDBC insert</a>
                        <a href="${jdbcSelectLogs}" class="list-group-item">Select all Logs</a>
                        <a href="${jdbcDelete}" class="list-group-item">Delete user</a>
                        <a href="${jdbcUpdate}" class="list-group-item">Update user</a>
                    </div>
                </div>

                <!--Content column-->
                <div class="col-md-9">
                    <c:if test="${not empty resultObject}">
                        Result:
                        <c:if test="${resultObject==true}">
                            <span style="color: green;"><b>${resultObject}</b></span>
                        </c:if>
                        <c:if test="${resultObject==false}">
                            <span style="color: red;"><b>${resultObject}</b></span>
                        </c:if>
                        <c:if test="${resultObject != 'true' and resultObject != 'false'}">
                            <p>${resultObject}</p>
                        </c:if>
                    </c:if>
                </div>

            </form>
            </div>

        </div>

    </jsp:attribute>
</page:template>
