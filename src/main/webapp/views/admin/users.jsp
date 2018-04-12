<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 
<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

					<div class="content-panel input-panel h-center compact">
						<h1 class="">Клієнти</h1>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<form method="GET" action="${baseUrl}/admin/users" class="search" id="users-form">
							<select name="state" placeholder="статус:">
								<option value="ALL">Всі</option>
								<option value="ACTIVE">Активовані</option>
								<option value="ACTIVATION_PENDING">В стані очікування</option>
								<option value="PERMANENT_BAN">Заблоковані</option>
							</select>
							<input type="text" name="phone" placeholder="номер телефону:" value="${phone}">
							<input type="text" name="surname" placeholder="прізвище:" value="${surname}">
							<button type="submit" class="icon-search" value=""></button>
						</form>
						
						<c:if test="${not empty state}">
						<script type="text/javascript">
							$(function(){ $("select[name=state]").val("${state}"); });	
						</script>
						</c:if>
						
						<hr>
						
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						
						<c:choose>
							<c:when test="${empty users}">
								Немає результатів пошуку
							</c:when>
							<c:otherwise>
							<!-- we have result - print it out -->
							
							<table class="cfx text-left search-result result-set" @width="100%">
								<thead>
									<tr>
										<th>Імя</th>
										<th>Прізвище</th>
										<th>Статус</th>
										<th>Логін</th>
										<th>Пошта</th>
										<th>Телефон</th>
										<th>Дата народження</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="item">
									<tr>
										<td>${item.details.name}</td>
										<td>${item.details.surname}</td>
										<td>${item.status}</td>
										<td>${item.login}</td>
										<td>${item.email}</td>
										<td>${item.details.phoneNumber}</td>
										<td>${item.details.birthday}</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							
							<cfx-v-spacer-middle></cfx-v-spacer-middle>
							<div id="pagination"></div>
							<script type="text/javascript">
							$(function(){
							
								$("#pagination").pagination({
									currentPage: '${index}',
									itemsOnPage: '${elemCount}',
									pages: '${pagesCount}',		
									cssStyle: 'compact-theme',
									onPageClick: function(index, e) {
										e.preventDefault();
										
										var $form = $("#users-form");
										$form.append("<input type='hidden' name='index' value='" + index + "' >");
										$form.submit();
									}
								});
								
							});	
							</script>
							
							</c:otherwise>
						</c:choose>
							
					</div>
		</cfx-section>
	</cfx-paralax-bgnd>
</cfx-page-section>

<script src="${baseUrl}/js/jquery.pagination.js"></script>

<script type="text/javascript">
$(function(){

	
});	
</script>


