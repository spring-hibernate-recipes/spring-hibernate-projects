function addTab() {
	
}
function form(formData, divName, action, buttonLabel) {
	var html = '<form id="form0">'
	for (i = 0; i < formData.length; i++) {
		var fieldData = formData[i];
		if (fieldData.type == 'field') {
			var field = '<input type="text" id="' + fieldData.name + '" value="' + fieldData.name + '">';
			html += field;
			html += '<br>';
		} else if (fieldData.type == 'file') {
			var field = '<input type="file" id="' + fieldData.name + '">';
			html += field;
			html += '<br>';
		}
	}
	html += '<input type="submit" value="' + buttonLabel + '">'
	html += '</form>';
	$(divName).html(html);
	$.each(formData, function(k, fieldData) {
		var fieldName = fieldData.name;
		$('#' + fieldName).focus(function(evt) {
			if ($(this).val() == fieldName) {
				$(this).val('');
			}
		});
		$('#' + fieldName).blur(function(evt) {
			if ($(this).val() == '') {
				$(this).val(fieldName);
			}
		});
	});
	$('#form0').submit(function(event) {
		event.preventDefault();
	});
}