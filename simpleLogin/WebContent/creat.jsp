<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="service" action="CreatAccount">
		<table>
			<tr>
				<td>User name</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>phone No</td>
				<td><input type="text" name="phone No"></td>
			</tr>
			<tr>
				<td>emali</td>
				<td><input type="email" name="mail id"></td>
			</tr>
			<tr>
				<td>full name</td>
				<td><input type="text" name="full name"></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><input type="radio" name="gender" value="male">
					Male <input type="radio" name="gender" value="female">
					Female<input type="radio" name="gender" value="other"></td>
			</tr>

			<tr>
				<td>Location</td>
				<td><select input name="country" class="countries"
					id="countryId">
						<option value="">Select Country</option>
				</select> <select input name="state" class="states" id="stateId">
						<option value="">Select State</option>
				</select> <select input name="city" class="cities" id="cityId">
						<option value="">Select City</option>
				</select> <script
						src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
					<script src="//geodata.solutions/includes/countrystatecity.js"></script>
				</td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="loging"></td>
			</tr>
		</table>
	</form>
</body>
</html>