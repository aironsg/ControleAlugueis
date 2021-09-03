$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	let button = $(event.relatedTarget);
	
	let codigoTitulo = button.data('codigo');
	let descricaoTitulo = button.data('descricao');
	
	let modal = $(this);
	let form = modal.find('form');
	let action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
});





$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal:',',thousands:'.', allowZero: true});
	
	$('.js-atualizar-status').on('click', function(event){
		event.preventDefault();
		let botaoReceber = $(event.currentTarget);
		let urlReceber = botaoReceber.attr('href');
		
		let response =  $.ajax({
			url:urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e){
			let codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">'+ e +'</span>');
			botaoReceber.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Erro recebendo cobrança');
		});
		
	});
});


