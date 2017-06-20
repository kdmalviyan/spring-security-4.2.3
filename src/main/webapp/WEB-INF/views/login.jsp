<html>
<head></head>
<body>
	<h1>Login Page</h1>
	<form method="POST" action="/login" name="f">
		<table>
			<tbody>
				<tr>
					<td>User:</td>
					<td><input type="text" value="" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Login"
						name="submit"></td>
				</tr>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</tbody>
		</table>
	</form>
	<h3>
		Not registered, click <a href="signup">here</a>.
	</h3>
</body>
</html>