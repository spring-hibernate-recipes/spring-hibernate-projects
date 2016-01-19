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

function projectPropertiesForm() {
	var formData = {
		heading : 'Project Properties',
		action : '/rest/projectproperties',
		id : 'form0',
		submitLabel : 'Save Project',
		fields : [ {
			label : 'Project Name',
			type : 'text',
			name : 'projectName',
			size : 50
		}, {
			label : 'Project Path',
			type : 'text',
			name : 'projectPath',
			size : 50
		} ]
	};
	return generateForm(formData);
}

function entityForm() {
	var formData = {
		heading : 'Create Entity',
		action : '/rest/entity',
		id : 'form0',
		submitLabel : 'Create',
		fields : [ {
			label : 'Name',
			type : 'text',
			name : 'entityName',
			size : 50
		}, {
			label : 'Description',
			type : 'text',
			name : 'description',
			size : 80
		} ]
	};
	return generateForm(formData);
}

function databasePropertiesForm() {
	var formData = {
		heading : 'Database Properties',
		action : '/rest/databaseproperties',
		id : 'form0',
		submitLabel : 'Save',
		fields : [ {
			label : 'Driver Class Name',
			type : 'text',
			name : 'driverClassName',
			size : 50
		}, {
			label : 'URL',
			type : 'text',
			name : 'url',
			size : 50
		}, {
			label : 'Username',
			type : 'text',
			name : 'username',
			size : 50
		}, {
			label : 'Password',
			type : 'text',
			name : 'password',
			size : 50
		}, {
			label : 'Show SQL',
			type : 'text',
			name : 'showSQL',
			size : 50
		}, {
			label : 'Dialect',
			type : 'text',
			name : 'dialect',
			size : 50
		}, {
			label : 'Export Schema',
			type : 'text',
			name : 'hbm2ddl',
			size : 50
		} ]
	};
	return generateForm(formData);
}

function textField(data) {
	return '<input type="text" name="' + data.name + '" size="' + data.size
			+ '" class="field"/>';
}

function submit(label) {
	return '<input type="submit" value="' + label + '"/>';
}

function generateForm(formData) {
	var form = '<div class="heading">' + formData.heading + '</div>';
	form += '<form id="' + formData.id + '">';
	form += '<table>';
	for (i = 0; i < formData.fields.length; i++) {
		form += '<tr>';
		form += '<td>' + formData.fields[i].label + '</td>';
		if (formData.fields[i].type == 'text') {
			form += '<td>' + textField(formData.fields[i]) + '</td>';
		}
		form += '</tr>';
	}
	form += '<tr>';
	form += '<td></td>';
	form += '<td>' + submit(formData.submitLabel) + '</td>';
	form += '</tr>';
	form += '</table>';
	return form;
}

function entitiesTable() {
	var metaData = {
		heading : 'All Entities',
		headings : [ {
			label : 'ID',
			key : 'id'
		}, {
			label : 'Name',
			key : 'entityName'
		}, {
			label : 'Description',
			key : 'description'
		} ]
	};
	return generateTable(metaData, []);
}

function generateTable(metaData, data) {
	var table = '<div class="heading">' + metaData.heading + '</div>';
	table += '<table width="100%" cellspacing="0" cellpadding="10" style="border-collapse: collapse">';
	table += '<tr>';
	for (i = 0; i < metaData.headings.length; i++) {
		table += '<td>';
		table += metaData.headings[i].label;
		table += '</td>';
	}
	table += '</tr>';
	for (i = 0; i < data.length; i++) {
		table += '<tr>';
		for (j = 0; j < metaData.headings.length; j++) {
			table += '<td>' + data[i][metaData.key] + '</td>';
		}
		table += '</tr>';
	}
	table += '</table>';
	return table;
}