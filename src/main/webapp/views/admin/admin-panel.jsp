<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 
<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

					<div class="content-panel input-panel h-center compact">
						<h1 class="">Адмін панель</h1>
						
							<div class="text-left text-300 padding-middle">
							<ul>
								<li>
								<a href="${baseUrl}/admin/orders">Замовлення</a>
								</li>
								<li>
								<a href="${baseUrl}/admin/users">Клієнти</a>
								</li>
								<li>
								<a href="${baseUrl}/admin/posts">Пости</a>
								</li>
							</ul>	
							</div>
					</div>
		</cfx-section>
	</cfx-paralax-bgnd>
</cfx-page-section>


<script type="text/javascript">
$(function(){

	$("form input").triggerNotEmpty();
	var $service = $("#services").chosen({
		width: "100%"
	});
	
});	
</script>


