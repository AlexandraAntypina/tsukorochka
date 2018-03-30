<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url" value="${req.requestURL.toString()}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="baseUrl" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}" scope="session" />



<!DOCTYPE html>

<html lang="uk">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

    <meta name="theme-color" content="#ffffff">
    <meta name="msapplication-TileColor" content="#ffffff">

	<!-- Web site thumbnail image -->
    <link rel="image_src" href="${baseUrl}/media/web-site-thumbnail-og-600x600.png">
    
    <!-- Open Graph: meta info of the web site -->
    <meta property="og:url" content="${baseUrl}" />
    <meta property="og:image" content="${baseUrl}/media/web-site-thumbnail-og-large.png" />
    <meta property="og:image:width" content="1200" />
	<meta property="og:image:height" content="630" />
    <meta property="og:image" content="${baseUrl}/media/web-site-thumbnail-og-600x600.png" />
    <meta property="og:image:width" content="600" />
	<meta property="og:image:height" content="600" />
	<meta property="og:image" content="${baseUrl}/media/web-site-thumbnail-og-middle.png" />
    <meta property="og:image:width" content="600" />
	<meta property="og:image:height" content="315" />
	<meta property="og:image" content="${baseUrl}/media/web-site-thumbnail-og-small.png" />
    <meta property="og:image:width" content="381" />
	<meta property="og:image:height" content="200" />
    <meta property="og:type" content="website" />
    <meta property="og:title" content="цукОрoчка" />
    <meta property="og:description" content="Якісний шугарінг" />
    
    <!-- keywords for search systems -->
    <meta name="keywords" content="Шугаринг, краса, sugaring, beauty" />

    <title>цукОрочка</title>

    <!-- favicon: icon in browser tab -->
    <link rel="shortcut icon" type="image/x-icon"     href="${baseUrl}/media/favicon/favicon.ico" >
    <link rel="icon" type="image/png" sizes="192x192" href="${baseUrl}/media/favicon/favicon-192.png" >
    <link rel="icon" type="image/png" sizes="128x128" href="${baseUrl}/media/favicon/favicon-128.png" >
    <link rel="icon" type="image/png" sizes="96x96"   href="${baseUrl}/media/favicon/favicon-96.png" >
    <link rel="icon" type="image/png" sizes="32x32"   href="${baseUrl}/media/favicon/favicon-32.png" >
    <link rel="icon" type="image/png" sizes="16x16"   href="${baseUrl}/media/favicon/favicon-16.png" >

    <!-- manifest -->
<!-- <link rel="manifest" href="resource/manifest.json"> -->

    <!-- general styles -->
    <link rel="stylesheet" href="${baseUrl}/style/cfx-settings.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-common.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-layout.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-flex.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-menu.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-fonts.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-icons.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-form.css">
    <link rel="stylesheet" href="${baseUrl}/style/cfx-loading.css">

    <!-- general scripts -->
    <script src="${baseUrl}/js/jquery-3.2.1.min.js"></script>
    <script src="${baseUrl}/js/jquery-integration.js"></script>

</head>

<body class="background">
  	
  	<div class="cfx-loader active" type="application" >
		<div class="loading-animation"></div>
	</div>
  
	<cfx-page-header>
		<!-- most top container -->
		<most-top>
			<tiles:insertAttribute name="header" />
		 	 <!-- menu box, that wraps menu + bar -->
			<tiles:insertAttribute name="menubar" />
		</most-top>
	</cfx-page-header>   
   
    <cfx-page-content id="page-content">
		<!--    MAIN PAGE CONTENT    -->
		<tiles:insertAttribute name="content" />
	</cfx-page-content>

	<cfx-page-footer @background-color="#514349">
		<tiles:insertAttribute name="footer" />
	</cfx-page-footer>
	
	<!-- postfix scripts. Fired only when page was totally loaded -->
	<script src="${baseUrl}/js/cfx.js"></script>
	
</body>

</html>
