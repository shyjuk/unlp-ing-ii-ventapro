function abrirPopUp(pagina) {
	var opciones = "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=508, height=365, top=85, left=140";
	window.open(pagina, "", opciones);
}

function abrirPopUpConParam(pagina, paramName, paramValue) {
	var opciones = "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=508, height=365, top=85, left=140";
	window.open(pagina + '?' + paramName + '=' + paramValue, "", opciones);
}

function changeSelection(element) {
	if (element == null || element.value == 'FALSE') {
		element.value = 'TRUE';
	} else {
		element.value = 'FALSE';
	}
}

function changeAllSelection(element, list) {
	if (element == null || element.value == 'FALSE') {
		element.value = 'TRUE';
		for ( var i = 0; i < list.length; i++) {
			(document.getElementById('seleccionados_' + list[i])).value = 'TRUE';
			(document.getElementById('seleccionados_' + list[i])).checked = true;
		}
	} else {
		element.value = 'FALSE';
		for ( var i = 0; i < list.length; i++) {
			(document.getElementById('seleccionados_' + list[i])).value = 'FALSE';
			(document.getElementById('seleccionados_' + list[i])).checked = false;
		}
	}
}

function algunoCheckeado(list) {
	
	for (var i = 0; i < list.length; i++){
		if ((document.getElementById('seleccionados_' + list[i])).checked)
			return true;
	}
	
	alert('No hay ningún casillero marcado');
	return false;
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;

	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function isDecimalNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;

	if (charCode <= 31 || charCode >= 48 && charCode <= 57 || charCode == 44
			|| charCode == 46)
		return true;

	return false;
}

// No usen las siguientes tres funciones porque no fueron probadas y algunas no las logré hacer andar bien...

function checkearLongitud(valor, max) {

	if (valor.replace(/^\s+|\s+$/g, "").length > max)
		return false;

	return true;
}

function mascaraNumero(evt, max) {

	return isNumberKey(evt) && checkearLongitud(evt.target.value, max);
}

function mascaraNumeroDecimal(evt, maxInt, maxDec) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	var valor = evt.target.value;
	var punto = Math.max(valor.indexOf("."), valor.indexOf(","));

	if (!isDecimalNumberKey(evt))
		return false;

	if (punto > 0) {

		if (charCode == 44 || charCode == 46)
			return false;

		if (!(checkearLongitud(valor.substring(0, punto), maxInt) && checkearLongitud(
				valor.substring(punto + 1, valor.length + 1), maxDec)))
			return false;

	} else if (!checkearLongitud(valor, maxInt)) {

		return false;
	}

	return true;
}