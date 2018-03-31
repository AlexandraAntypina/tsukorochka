<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="avatarUrl" value="${baseUrl}/media/no-avatar.png" />
<c:if test="${not empty user.avatarUrl}">
	<c:set var="avatarUrl" value="${user.avatarUrl}" />	
</c:if>


<cfx-page-section id="cfx-main-sugaring-intro">

	<cfx-paralax-bgnd --image="url('../media/main-logo-bgnd.png')">
		<cfx-section class="text-center h-center">

			<div class="cfx content-panel input-panel h-center" @max-width="60vw">
				<h1 class="heading">Прайс</h1>
				 <table class="price h-center">
			        <tbody>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1042;&#1077;&#1088;&#1093;&#1085;&#1103; &#1075;&#1091;&#1073;&#1072;</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>60</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1055;&#1110;&#1076;&#1073;&#1086;&#1088;&#1110;&#1076;&#1076;&#1103;</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>70</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1056;&#1091;&#1082;&#1080; (&#1087;&#1086;&#1074;&#1085;&#1110;&#1089;&#1090;&#1102;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>150</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1056;&#1091;&#1082;&#1080; (&#1076;&#1086; &#1083;&#1110;&#1082;&#1090;&#1103;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>100</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1055;&#1110;&#1076;&#1087;&#1072;&#1096;&#1082;&#1080;</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>60</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1041;&#1110;&#1082;&#1110;&#1085;&#1110; (&#1082;&#1083;&#1072;&#1089;&#1080;&#1095;&#1085;&#1077;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>100</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1041;&#1110;&#1082;&#1110;&#1085;&#1110; (&#1075;&#1083;&#1080;&#1073;&#1086;&#1082;&#1077;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>150</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1053;&#1086;&#1075;&#1080; (&#1087;&#1086;&#1074;&#1085;&#1110;&#1089;&#1090;&#1102;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>180</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1053;&#1086;&#1075;&#1080; (&#1076;&#1086; &#1082;&#1086;&#1083;&#1110;&#1085;&#1072;)</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>100</span></p>
			                </td>
			            </tr>
			            <tr>
			                <td colspan="1" rowspan="1">
			                    <p><span>&#1057;&#1110;&#1076;&#1085;&#1080;&#1094;&#1110;</span></p>
			                </td>
			                <td colspan="1" rowspan="1">
			                    <p><span>120</span></p>
			                </td>
			            </tr>
			            
			        </tbody>
			    </table>
				<cfx-v-spacer-large></cfx-v-spacer-large>		
			</div>

		</cfx-section>
	</cfx-paralax-bgnd>

</cfx-page-section>
