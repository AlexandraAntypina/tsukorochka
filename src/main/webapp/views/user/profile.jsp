<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="avatarUrl" value="${baseUrl}/media/no-avatar.png" />
<c:if test="${not empty user.avatarUrl}">
	<c:set var="avatarUrl" value="${user.avatarUrl}" />	
</c:if>


<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

			<div class="content-panel input-panel h-center">
				<h1 class="heading">Профайл</h1>
				
				<cfx-flex type="flex"  align="center" >
					<cfx-flex-item class="photo-panel">
						<img src ="${avatarUrl}">
						<form method="POST" action="${baseUrl}/user/avatar" enctype="multipart/form-data" class="compact">
							<input type="file" name="file"/>
							<div class="button-container">
								<button><span>Змінити</span></button>													
							</div>
						</form>
						
						<cfx-v-spacer-small></cfx-v-spacer-small>
						<form action="${baseUrl}/logout" method="POST" class="compact">
							<div class="button-container">
								<button><span>Вийти</span></button>
							</div>
						</form>
					</cfx-flex-item>
					
					<cfx-flex-item>	
						<form method="POST" action="${baseUrl}/user/profile">
							<cfx-flex type="flex">
								<cfx-flex-item>			
									<div class="input-container">
										<input type="text" id="login" name="login" value="${user.login}" readOnly="readonly" />
										<label for="login" >Логін </label>
										<div class="bar" ></div>
									</div>
									<div class="input-container">
										<input type="text" id="name" name="name" value="${user.details.name}" />
										<label for="name">Ім'я</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="text" id="surname" name="surname"  value="${user.details.surname}" />
										<label for="surname">Прізвище</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="text" id="phoneNumber" name="phone-number" value="${user.details.phoneNumber}" />
										<label for="phoneNumber">Номер телефону</label>
										<div class="bar"></div>
									</div>
								</cfx-flex-item>
								<cfx-flex-item>		
									<div class="input-container">
										<input type="date" id="birthday" name="birthday" value="${user.details.birthday}" />
										<label for="birthday">День народження</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<select id="gender" name="gender" >
											<option value="FEMALE">Female</option>
											<option value="MALE">Male</option>
										</select>
										<label for="gender">Стать</label>
										<div class="bar"></div>
									</div>
									
									<div class="input-container">
										<input type="text" id="e-mail" name="e-mail" value="${user.email}" />
										<label for="e-mail">Електронна пошта</label>
										<div class="bar"></div>
									</div>
								</cfx-flex-item>	
							</cfx-flex>
							<div class="button-container">
								<button><span>Зберегти</span></button>													
							</div>
						</form>
						
					</cfx-flex-item>
				</cfx-flex>		
			</div>

		</cfx-section>
	</cfx-paralax-bgnd>

</cfx-page-section>

<<script type="text/javascript">
$(function(){

	$("form input").triggerNotEmpty();
	
});	
</script>
