<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 	<!-- menu box, that wraps menu + bar -->
<cfx-menu-docker id="main-menu-bar">

	<!-- menu tuggle button: visible on small screen devices -->
	<button type="tuggle-button" tuggle-target="#main-menu" class="menu-tuggle">
		<span></span>
	</button>

	<img class="menu-logo" type="dynamic" src="${baseUrl}/media/brand-logo-b.png">

	<!-- MENU -->
	<ul class="cfx menu" id="main-menu">
		<li><a href="${baseUrl}/">Головна</a></li>
		<li>
			<a href="#">Про нас<tuggle /></a>
			<ul>
				<li><a href="#">Відгуки</a></li>
				<li><a href="#">Ми на мапі</a></li>
				<li><a href="#">Сертифікат</a></li>
			</ul>
		</li>
		<li><a href="view:${baseUrl}/user/booking" class="navigate"">Записатися</a></li>
		<li><a href="view:${baseUrl}/price" class="navigate">Ціна</a></li>
		<li><a href="#">Блог</a></li>
		<li><a href="view:${baseUrl}/contacts" class="navigate">Контакти</a></li>
	</ul>
	
	<cfx-h-spacer-middle></cfx-h-spacer-middle>
	
	<div class="button-wrap">
		<button type="tuggle-button" tuggle-target="#main-menu-social" class="menu-tuggle-button">
			<div class="cfx menu-tuggle-icon" --image="url('../media/social-media-white-32.png')"></div>
		</button>
		<!-- menu left sub bar -->
		<ul id="main-menu-social" class="cfx ul-vlist menu-drop-down" --spacing="2px" --text-color="white" --color="#9c9c9c" --fill="#333">
			<li><a class="navigate link-bg icon-round icon-facebook" href="away:https://www.facebook.com/tsukOrochka/?fref=pb&hc_location=profile_browser"></a></li>
			<li><a class="navigate link-bg icon-round icon-instagram" href="away:https://www.instagram.com/zmeeva.alex/"></a></li>
			<li><a class="link-bg icon-round icon-google" href=""></a></li>
			<li><a class="link-bg icon-round icon-twitter" href=""></a></li>
			<li><a class="link-bg icon-round icon-pinterest" href=""></a></li>
			<li><a class="link-bg icon-round icon-linkedin" href=""></a></li>
			
		</ul>

	</div>
	
	
	<div class="menu-right-sub-buttons">
		<button class="navigate menu-tuggle-button" href="view:${baseUrl}/user/profile">
			<div class="cfx menu-tuggle-icon" --image="url('../media/user-white-32.png')"></div>
		</button>
		
	</div>
	
</cfx-menu-docker>
        
<!-- menu anchor: used to scroll menu on top --> 
<div id="menu-anchor"></div>