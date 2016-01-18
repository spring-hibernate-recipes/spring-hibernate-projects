function loadMenu() {
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
}

function displayProduct(product, i) {
	var html = '<div class="smallProductDisplay">\n';
	html += '<div class="smallProductImage">Lorem Ipsum dolor sit amet</div>\n';
	html += '<b>' + product.productName + '</b><br/>\n';
	html += '$ ' + product.buyPrice + '<br/>\n';
	html += '<a class="addToCartButton" href="#">Add to Cart</a>\n';
	html += '</div>';
	if ((i + 1) % 4 == 0) {
		html += '<div class="clearDiv"></div>';
	}
	$("#productPane").append(html);
}

function loadProductsForLine(productline) {
	$.get('rest/product/productline/' + productline, function(response) {
		if (response.data != null) {
			var products = response.data;
			$.each(products, function(i, product) {
				displayProduct(product, i);
			});
		}
	});
}

function authenticate() {
	var customerNumber = $('#customerNumber').val();
	var postalCode = $('#postalCode').val();
	var data = {
		"postalCode" : postalCode,
		"customerNumber" : customerNumber
	};
	$.post('rest/customer/authenticate', data, function(response) {
		var customerName = response.data.customerName;
		document.cookie = 'customerName=' + customerName + '; customerNumber='
				+ customerNumber;
		$('#loginStatusSpan').html(
				'Welcome ' + customerName
						+ ' ! [<a href="#" id="logoutButton">Logout</a>]');
		$('#logoutButton').click(function(e) {
			logoutAndEndSession();
			e.stopPropagation();
			$('#loginPanel').hide();
		});
	});
}

function logoutAndEndSession() {
	var response = confirm('Are you sure you want to end the session?');
	if (response) {
		document.cookie = 'customerName=; expires=Thu, 01 Jan 1970 00:00:00 UTC';
		document.cookie = 'customerNumber=; expires=Thu, 01 Jan 1970 00:00:00 UTC';
		$('#loginStatusSpan').html(
				'Welcome Guest! [<a href="#" id="loginButton">Login</a>]');
		$('#loginButton').click(function(e) {
			loadLoginPanel();
			e.stopPropagation();
		});
	}
}

function makeFormField(selector, label) {
	$(selector).val(label);
	$(selector).blur(function(e) {
		if ($(selector).val() == '') {
			$(selector).val(label);
		}
	});
	$(selector).focus(function(e) {
		if ($(selector).val() == label) {
			$(selector).val('');
		}
	});
}

function addCookie(name, value) {
	if (document.cookie != null && document.cookie != '') {
		document.cookie += name + "=" + value;
	}

}

function getCookie(name) {
	var cookies = document.cookie;
	var slices = cookies.split(';');
	for (i = 0; i < slices.length; i++) {
		slice = slices[i];
		slice = slice.trim();
		var cookieParts = slice.split('=');
		cookieParts[0] = cookieParts[0].trim();
		cookieParts[1] = cookieParts[1].trim();
		if (cookieParts[0] === name) {
			return cookieParts[1];
		}
	}
	return null;
}

function removeCookie(name) {
	document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
}