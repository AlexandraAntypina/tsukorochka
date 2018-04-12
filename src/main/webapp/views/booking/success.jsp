<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">
			<h2>Дякуємо за замовлення послуги. Очікуйте дзвінок від нашого спеціаліста для уточнення часу.
			Якщо Ви ще не заповнили свій профайл, то можете це зробити прямо зараз :)
			</h2>
			<h3>
			<a href="<c:url value="/user/profile" />">Заповнити профайл</a>
			</h3>

		</cfx-section>
	</cfx-paralax-bgnd>

</cfx-page-section>
