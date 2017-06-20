<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup</title>
</head>
<body>
	<div class="form">
		<div class="tab-content">
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form action="/signup" method="post">
					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" name="firstName" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" name="lastName" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" />
					</div>

					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" name="password" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type="submit"
						class="button button-block" />

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
</body>
</html>