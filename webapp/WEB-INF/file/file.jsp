<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:body>
        <!--Page context-->
        <div class="container">

            <!--Page Heading/Beadcrumbs-->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Пример загрузки файла <small>pdf или excel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li href="index.html">Home</li>
                        <li class="active">Пример загрузки файла</li>
                    </ol>
                </div>
            </div>

            <c:url value="/uploadFile" var="fileUploadControllerUrl"/>

            <!--Content row-->
            <div class="row">
                <div class="col-lg-12">
                    <p>Пример загрузки файла с помощью Spring MVC</p>
                    <form action="${fileUploadControllerUrl}" method="post">
                        enctype = "multipart/form-data";
                        <table>
                            <tr>
                                <td><b>File:</b></td>
                                <td><input type="file" name="file"/></td>
                                <td><input type="submit" value="Загрузить файл"/></td>
                            </tr>
                        </table>
                    </form>

                    <br/>

                    <c:url value="/excel" var="excelController"/>
                    <c:url value="/pdf" var="pdfController"/>
                    <a href="${excelController}">Excel</a>
                    <br/>
                    <a href="${pdfController}">PDF</a>
                </div>
            </div>

            <hr/>

        </div>
    </jsp:body>
</page:template>
