var entityDef = {
	name : 'entity',
	description : 'Entity',
	submitLabel : 'Save',
	identifier : {
		name : 'id',
		type : 'Integer',
		label : 'ID',
		auto : true
	},
	properties : [ {
		name : 'entityName',
		type : 'text',
		size : 50,
		label : 'Entity Name'
	}, {
		name : 'entityDescription',
		type : 'text',
		size : 80,
		label : 'Entity Description'
	} ],
	lists : [ {
		type : 'entityProperty',
		label : 'Properties'
	} ]
};

var propertyDef = {
	name : 'property',
	description : 'Property',
	submitLabel : 'Save',
	identifier : {
		name : 'id',
		type : 'Integer',
		auto : true
	},
	properties : [ {
		name : 'name',
		type : 'text',
		size : '30',
		label : 'Name'
	}, {
		name : 'dataType',
		type : 'select',
		choices : [ 'Integer', 'String', 'Date', 'EMail', 'Float', 'BLOB' ],
		label : 'Data Type'
	}, {
		name : 'relation',
		type : 'select',
		choices : [],
		label : 'Relation'
	} ],
	lists : []
};

var elements = {
	entityProperty : propertyDef,
	entity : entityDef
};

function select(data) {
	var html = '<select name="' + data.name + '">';
	for (i = 0; i < data.choices.length; i++) {
		html += '<option>' + data.choices[i] + '</option>';
	}
	html += '</select>';
	return html;
}

function textField(data) {
	return '<input type="text" name="' + data.name + '" size="' + data.size
			+ '" class="field"/>';
}

function submit(label) {
	return '<input type="submit" value="' + label + '"/>';
}

function generateForm(formData) {
	var form = '<div class="heading">' + formData.description + '</div>';
	form += '<form id="' + formData.id + '">';
	form += '<table>';
	for (i = 0; i < formData.properties.length; i++) {
		form += '<tr>';
		form += '<td>' + formData.properties[i].label + '</td>';
		if (formData.properties[i].type == 'text') {
			form += '<td>' + textField(formData.properties[i]) + '</td>';
		} else if (formData.properties[i].type == 'select') {
			form += '<td>' + select(formData.properties[i]) + '</td>';
		}
		form += '</tr>';
	}
	form += '<tr>';
	form += '<td></td>';
	form += '<td>' + submit(formData.submitLabel) + '</td>';
	form += '</tr>';
	form += '</table>';
	for (i = 0; i < formData.lists.length; i++) {
		form += '<div class="heading">' + formData.lists[i].label + '</div>';
		form += generateForm(elements[formData.lists[i].type]);
	}
	return form;
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
			var heading = metaData.headings[j];
			if (!heading.type) {
				table += '<td>' + data[i][heading.key] + '</td>';
			} else if (heading.type && heading.type == 'edit') {
				table += '<td><a href="#" onclick="edit('
						+ data[i][heading.key] + ');">' + 'Edit</a></td>';
			} else if (heading.type && heading.type == 'delete') {
				table += '<td><a href="#" click="delete('
						+ data[i][heading.key] + ');">' + 'Delete</a></td>';
			}
		}
		table += '</tr>';
	}
	table += '</table>';
	return table;
}