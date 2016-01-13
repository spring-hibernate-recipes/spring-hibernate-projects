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
<script type="text/javascript">
	$(document).ready(
			function() {
				$.get("rest/productline", function(response) {
					var productLines = response.data;
					var navMenu = '<ul>\n';
					for (var i = 0; i < productLines.length; i++) {
						navMenu += '<li><a href="products.html?line='
								+ productLines[i].productLine + '">'
								+ productLines[i].productLine + '</a></li>\n';
					}
					navMenu += '</ul>\n';
					$('#navigation').html(navMenu);
				});
			});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">TOY UNIVERSE!</div>
			<div id="search">
				<br /> Welcome Chandrakant! [Logout]<br /> <input type="text"
					size="60" value="Search" /><br /> View Cart (0 Items)
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
				<h1 style="height: 250px; line-height: 250px; text-align: center">Customer Testimonials..</h1>
			</div>
		</div>
		<div id="footer">
		(C) 2016 Toy Universe Inc. All Rights Reserved.
		<br/>
		<ul>
			<li><a href="#">Privacy Policy</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Customer Service</a></li>
			<li><a href="#">Stores</a></li>
		</ul>
		</div>
	</div>
</body>
</html>