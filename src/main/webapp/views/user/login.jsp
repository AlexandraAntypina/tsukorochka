<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

			<div class="login-panel-decoration">
				<div class="login-panel">

					<div class="card">
						<h1 class="heading">Увійти</h1>
						<form method="POST" action="${pageContext.request.contextPath}/user/login">
							<div class="input-container">
								<input type="text" id="login" name="login" required="required" />
								<label for="login">Логін</label>
								<div class="bar"></div>
							</div>
							<div class="input-container">
								<input type="password" id="password" name="password" required="required" />
								<label for="password">Пароль</label>
								<div class="bar"></div>
							</div>
							<div class="input-container mini">
								<input type="checkbox" id="rememberme" name="rememberme" />
								<label for="rememberme">Запамятати</label>
							</div>
							<div class="button-container">
								<button><span>Вхід</span></button>
							</div>
							<div class="footer"><a href="#">Забули пароль?</a></div>
						</form>
					</div>


					<div class="card alt">
						<div class="toggle" id="toggle-registration"></div>
						<h1 class="heading">Реєстрація
							<div class="close" id="close-registration"></div>
						</h1>
						<form  method="POST" action="${pageContext.request.contextPath}/user/registration">
							<div class="input-container">
								<input type="text" id="login" name="login" required="required" />
								<label for="login">Логін</label>
								<div class="bar"></div>
							</div>
							<div class="input-container">
								<input type="password" id="password" name="password" required="required" />
								<label for="password">Пароль</label>
								<div class="bar"></div>
							</div>
							<div class="input-container">
								<input type="password" id="re-password" name="re-password" required="required" />
								<label for="re-password">Пароль повторно</label>
								<div class="bar"></div>
							</div>
							<div class="input-container">
								<input type="text" id="e-mail" name="e-mail" required="required" />
								<label for="e-mail">Електронна пошта</label>
								<div class="bar"></div>
							</div>
							<div class="input-container">
								<input type="text" id="phoneNumber" name="phone-number" required="required" />
								<label for="phoneNumber">Номер телефону</label>
								<div class="bar"></div>
							</div>
							<div class="button-container">
								<button><span>Далі</span></button>
							</div>
						</form>
					</div>

				</div>
			</div>

		</cfx-section>
	</cfx-paralax-bgnd>

</cfx-page-section>

<script type="text/javascript">
$(function() {
	$('#toggle-registration').on('click', function() {
		if ($('.login-panel').hasClass('active')) {
			return false;
		}
		$('.login-panel').stop().addClass('active');
		var $height = $('.card.alt').outerHeight();
		// stiil problem with outer height
		$('.login-panel').animate({
			height: 100 + $height + "px"
		});
	});

	$('#close-registration').on('click', function() {
		$('.login-panel').stop().removeClass('active');
		var $height = $('.card').outerHeight();
		$('.login-panel').animate({
			height: $height + "px"
		});
	});

	$("form input").triggerNotEmpty();
});
</script>
