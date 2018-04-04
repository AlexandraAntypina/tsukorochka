<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <c:set var="name" value="шановний"/>
 <c:set var="surname" value="Користувач"/>

<c:if test="${not empty user}" >
	<c:set var="name" value="${user.details.name}"/>
	<c:set var="inputName" value="${user.details.name}"/>
	<c:set var="surname" value="${user.details.surname}"/>
	<c:set var="phoneNumber" value="${user.details.phoneNumber}"/>
</c:if>

<c:if test="${empty name}">
	<c:set var="name" value="шановний"/>
	<c:set var="surname" value="Користувач"/>
</c:if>
<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

					<div class="content-panel input-panel h-center compact">
						<h1 class="">Записатися</h1>
						<form method="POST" action="${baseUrl}/booking/add" >
						
								<div class="input-container">
									<p>
									Добрий день ${name} ${surname}.
									Для оформлення online-заявки на бронювання послуг, будь ласка, 
									перевірте номер телефону та заповніть форму:
									</p>
								</div>
						
								<cfx-flex type="flex">
									
									<cfx-flex-item>	
									<div class="input-container">
										<input type="name" id="name" name="name" value="${inputName}" required="required"  />
										<label for="name">Ім'я</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="text" id="phoneNumber" name="phone-number" value="${phoneNumber}"  required="required" />
										<label for="phoneNumber">Номер телефону</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="date" id="date" name="date" required="required" />
										<label for="date">Бажана дата</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="time" id="time" name="time" required="required"  />
										<label for="time">Бажаний час</label>
										<div class="bar"></div>
									</div>
									</cfx-flex-item>
									
									<cfx-flex-item class="flex-half-panel">	
									<div class="cfx input-container text-left">
										<select id="services" name="services" multiple="multiple" required="required" >
											<option value="bikini">Бікіні(глибоке)</option>
											<option value="bikini-сlassiс">Бікіні(класичне)</option>
											<option value="armpits">Підпашки</option>
											<option value="lip">Верхня губа</option>
											<option value="chin">Підборіддя</option>
											<option value="hands-completely">Руки(повністю)</option>
											<option value="hands">Руки(до ліктя)</option>
											<option value="legs-completely">Ноги (повністю)</option>
											<option value="legs-knee">Ноги(до коліна)</option>
											<option value="buttocks">Сідниці</option>
										</select>
										<label for="services">Оберіть послуги:</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<textarea id="note" name="note" placeholder="Введіть повідомлення" maxlength="150"></textarea>
										<!-- 
										<label for="note">Примітка</label>
										<div class="bar"></div>
										-->
									</div>
									<cfx-flex-item>
							</cfx-flex>
							
							<div class="button-container">
								<button><span>Забронювати</span></button>
							</div>
						</form>
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


