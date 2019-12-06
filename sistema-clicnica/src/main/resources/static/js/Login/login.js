function ingresar(){
	//alert('Hola');
	
	$.ajax({
		type:'GET',
		url:'./usuarios',
		data: { },
		success:function(responseText) {
			$('#respuesta').html(responseText);
		}
	});
}