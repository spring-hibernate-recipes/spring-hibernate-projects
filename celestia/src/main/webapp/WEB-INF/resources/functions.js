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

function makeVerticalMenu(metaData, options) {
	var html = '<ul id="' + metaData.id + '">';
	for (key in options) {
		html += '<li><a href="#">' + options.label + '</a></li>';
	}
	html += '</ul>';
	return html;
}