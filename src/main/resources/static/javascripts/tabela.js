$(document).ready(function(){
	$('#tbl tbody tr td').dblclick(function(){
		var conteudoOriginal = $(this).text();
		var novoElemento =  $('<input />', {type: 'text', value: conteudoOriginal});
		$(this).html(novoElemento).blur(function(){
			var conteudoNovo = $(this).val();
			$(this).parent().html(conteudoNovo);
		});
	})
})