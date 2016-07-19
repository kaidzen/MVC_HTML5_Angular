
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:attribute name="title">MVC_HTML5_Angular</jsp:attribute>

    <jsp:body>
        <!--Content-->
        <div class="container">

            <!--Heading/Breadcrumbs-->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Contact <small>Java Mail API and Spring Mail</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="/index.html">Home</a></li>
                        <li class="active">Contact</li>
                    </ol>
                </div>
            </div> <!--row-->

            <!--Content Row-->
            <div class="row">
                <!--Contact Details Column-->
                <div class="col-md-4">
                    <c:if test="${pageContext.request.getParameter('resultSending')==true}">
                        <h3 style="color: green">Email already sent!</h3>
                    </c:if>
                    <c:if test="${pageContext.request.getParameter('resultSending')==false}">
                        <h3 style="color: red">Email wasn't send!</h3>
                    </c:if>
                    <h3>Contact Details:</h3>
                    <p>
                        3877 Melrouse Place <br/>Beverly Hills, CA 90210<br/>
                    </p>
                    <p>
                        <i class="fa fa-phone"></i>
                        <abbr title="Phone">P</abbr>: (888)322-23-32
                    </p>
                    <p>
                        <i class="fa fa-envelope-o"></i>
                        <abbr title="Email">E</abbr>: <a href="mailto:name@example.com">name@example.com</a>
                    </p>
                    <p>
                        <i class="fa fa-clock-o"></i>
                        <abbr title="Hours">H</abbr>: Monday - Friday: 9:00AM - 5:00PM
                    </p>
                    <ul class="list-unstyled list-inline list-social-icon">
                        <li><a href="#"><i class="fa fa-facebook-square fa-2x"></i></a> </li>
                        <li><a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a> </li>
                        <li><a href="#"><i class="fa fa-twitter-square fa-2x"></i></a> </li>
                        <li><a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a> </li>
                    </ul>
                </div>
            </div> <!--row-->

            <c:url value="/email/send" var="send"></c:url>

        </div>


    </jsp:body>
</page:template>
