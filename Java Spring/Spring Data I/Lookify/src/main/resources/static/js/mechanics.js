$(document).ready(function() {
	$("#boton").click(function(){
		if($("#buscar").val()==""){
			return;
		} else {
			location.href="/search/"+$("#buscar").val();
		}
	
	});	
});