<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title>
        <tiles:getAsString name="title"/>
    </title>
    <style type="text/css">
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dijit/themes/tundra/tundra.css";
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dijit/themes/soria/soria.css";
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dijit/themes/dijit.css";
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/resources/dojo.css";
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojox/grid/resources/Grid.css";
        @import "http://ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojox/grid/resources/tundraGrid.css";
        /*Grid needs an explicit height by default*/
        #grid {
            height: 20em;
        }
        /* TabContainer requires an explicit height by default */
        .tabbedContainer {
            height: 20em;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />
</head>

<body class="tundra">

<div class="header">
    <tiles:insertAttribute name="header" ignore="true"/>
</div>

<div class="wrapper">
    <div class="left-nav-wrapper">
        <div class="left-nav">
            <tiles:insertAttribute name="left-nav" ignore="true"/>
        </div>
    </div>
    <div class="main-content-wrapper">
        <div class="main-content">
            <tiles:insertAttribute name="body" ignore="true"/>
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="footer">
    <tiles:insertAttribute name="footer" ignore="true"/>
</div>

</body>
</html>
