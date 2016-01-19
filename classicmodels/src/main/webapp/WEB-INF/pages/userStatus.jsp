
<%
	String customerName = "Guest";
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("customerName")) {
			customerName = cookie.getValue();
		}
	}
%>
<span id="loginStatusSpan"></span>
<script type="text/javascript">
	function displayWelcome() {
		var customerName = getCookie('customerName');
		alert(customerName);
		if (customerName == null) {
			customerName = 'Guest';
			$('#loginStatusSpan').append('Welcome ' + customerName + '! ');
			$('#loginStatusSpan').append('<a href="#" id="loginButton">Login</a>');
		}
		else {
			$('#loginStatusSpan').append('Welcome ' + customerName + '! ');
			$('#loginStatusSpan').append('<a href="#" id="logoutButton">Logout</a>');
		}
	}
	displayWelcome();
</script>
<div id="loginForm"
	style="display: none; position: absolute; top: 50%; left: 50%; width: 200px; height: 120px; margin-left: -100px; margin-top: -60px; border: 1px solid #808080; text-align: left; padding: 10px;">
	<form id="form000">
		Username<br /> <input type="text" id="customerNumber" class="formField"/><br /> Password<br />
		<input type="password" id="postalCode"  class="formField"/><br /> <input type="submit"
			value="Login" />
	</form>
</div>
<script>
	$('#loginButton').click(function(e) {
		e.preventDefault();
		$('#loginForm').show();
	});
	$('#form000').submit(function(e) {
		//e.stopPropagation();
		e.preventDefault();
		var data = {};
		$('#form000 .formField').each(function(){
			data[this.id] = $(this).val();
		});
		$.ajax({
			contentType: 'application/json',
			data: JSON.stringify(data),
			url: 'rest/customer/authenticate',
			type: 'POST'
		}).done(function(response){
			if (response.code == 1) {
				addCookie('customerNumber', response.data.customerNumber);
				addCookie('customerName', response.data.customerName);
				$('#loginForm').hide();
				$('#loginStatusSpan').html('');
				displayWelcome();
			}
		});
	});
</script>