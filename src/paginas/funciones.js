function abrirPopUp (pagina) {
	var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=508, height=365, top=85, left=140";
	window.open(pagina,"",opciones);
}

function changeSelection (element) {
	if (element == null || element.value == 'FALSE') {
		element.value = 'TRUE';
	}else {
		element.value = 'FALSE';
	}
}

function changeAllSelection(element, list) {
	if (element == null || element.value == 'FALSE') {
		element.value = 'TRUE';
		for (var i = 0; i < list.length; i++) {
			(document.getElementById('seleccionados_' + list[i])).value = 'TRUE';
			(document.getElementById('seleccionados_' + list[i])).checked = true;
		}
	}else {
		element.value = 'FALSE';
		for (var i = 0; i < list.length; i++) {
			(document.getElementById('seleccionados_' + list[i])).value = 'FALSE';
			(document.getElementById('seleccionados_' + list[i])).checked = false;
		}
	}
}

function isNumberKey(evt) {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

          return true;
       }