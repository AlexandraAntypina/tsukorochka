<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">
			<h2>Дякуємо за замовлення послуги. Очікуйте дзвінок від нашого спеціаліста для уточнення часу.
			Зареєструйтеся, будь ласка, для більш зручного користування сайтом
			 та отримання розсилки про нові Акції.
			</h2>
		<h3><a href="<c:url value="/user/login" />">Зареєструватися</a></h3>

		</cfx-section>
	</cfx-paralax-bgnd>

</cfx-page-section>
