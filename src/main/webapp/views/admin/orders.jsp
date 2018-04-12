<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 
<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

					<div class="content-panel input-panel h-center compact">
						<h1 class="">Замовлення</h1>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<form method="GET" action="${baseUrl}/admin/orders" class="search" id="orders-form">
							<select name="state" placeholder="статус:">
								<option value="ALL">Всі</option>
								<option value="APPROVED">Підтверджені</option>
								<option value="PENDING_APPROVE">В стані очікування</option>
								<option value="DONE">Завершені</option>
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
							<c:when test="${empty orders}">
								Немає результатів пошуку
							</c:when>
							<c:otherwise>
							<!-- we have result - print it out -->
							
							<table class="cfx text-left search-result result-set" @width="100%">
								<thead>
									<tr>
										<th>Опис</th>
										<th>Статус</th>
										<th>Імя</th>
										<th>Прізвище</th>
										<th>Примітка</th>
										<th>Дата</th>
										<th>Час</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orders}" var="item">
									<tr>
										<td>${item.title}</td>
										<td>${item.order.status}</td>
										<td>${item.user.details.name}</td>
										<td>${item.user.details.surname}</td>
										<td>${item.order.note}</td>
										<td>${item.date}</td>
										<td>${item.time}</td>
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
										
										var $form = $("#orders-form");
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


