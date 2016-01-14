<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Toy Universe</title>
<link rel="stylesheet" type="text/css" href="resources/style.css" />
<script type="text/javascript" src="resources/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/functions.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				loadMenu();
				$('#showFormLink').click(function(e) {
					$('#loginPanel').show();
					e.preventDefault();
				});
				$('#form000').submit(
						function(e) {
							alert('Authenticating...');
							var data = {
								customerNumber: $('#customerNumber').val(),
								postalCode: $('#postalCode').val()
							};
							$.ajax({
								type: 'POST',
								contentType : 'application/json',
								url: 'rest/customer/authenticate',
								data: JSON.stringify(data),
								dataType: 'json',
								timeout: 10000
							}).done(function(response){
								if (response.data != null) {
									var name = response.data.customerName;
									var html = 'Welcome ' + name + '! [<a href="#" id="logoutLink">Logout</a>]';
									$('#loginStatusSpan').html(html);
									$('#logoutLink').click(function(event) {
										$('#loginStatusSpan').html('Welcome Guest! <a href="#" id="showFormLink">Login</a>');
										$('#showFormLink').click(function(evt) {
											$('#loginPanel').show();
											evt.preventDefault();
										});
									});

									$('#loginPanel').hide();
								}
								else {
									$('.errorMessage').html('Customer Number/Postal Code Incorrect. Please try again.');
								}
							});
							e.preventDefault();
						});
				makeFormField('#customerNumber', 'Customer Number');
				makeFormField('#postalCode', 'Postal Code');
			});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">TOY UNIVERSE!</div>
			<div id="search">
				<br /> <span id="loginStatusSpan">Welcome Guest! <a href="#"
					id="showFormLink">Login</a></span><br /> <input type="text" size="60"
					value="Search" /><br /> View Cart (0 Items)
			</div>
			<div class="clearDiv"></div>
		</div>
		<div id="banner">
			<div id="navigation"></div>
			<div id="carousel">&nbsp;</div>
			<div class="clearDiv"></div>
		</div>
		<div id="mainContent">
			<div id="offerForCustomer">
				<h1 style="height: 250px; line-height: 250px; text-align: center">Offers
					for you...</h1>
			</div>
			<div id="popularToys">
				<h1 style="height: 250px; line-height: 250px; text-align: center">Popular
					toys this season...</h1>
			</div>
			<div id="testimonials">
				<h1 style="height: 250px; line-height: 250px; text-align: center">Customer
					Testimonials..</h1>
			</div>
		</div>
		<div id="footer">
			(C) 2016 Toy Universe Inc. All Rights Reserved. <br />
			<ul>
				<li><a href="#">Privacy Policy</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Customer Service</a></li>
				<li><a href="#">Stores</a></li>
			</ul>
		</div>
	</div>
	<div id="loginPanel">
		<div class="errorMessage">
		</div>
		<form id="form000" action="rest/customer/authentication" method="post">
			<input name="customerNumber" value="Customer Number"
				id="customerNumber" /> <br /> <input name="postalCode"
				value="Postal Code" id="postalCode" /><br /> <input value="Login"
				type="submit" />
		</form>
	</div>
</body>
</html>