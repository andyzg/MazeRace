$(document).ready(function()
{
	$('.center-content').animate({opacity:1, top:"0px"}, 1000, function() {
	    // setup typer
	    $('[data-typer-targets]').typer();
	    $.typer.options.typerInterval = 4000;
	});	

	$('.button').click(function() {
		$.typer.options.typerActive = false;
		console.log($('#subtitle-bar').html());
		$('#subtitle-bar').animate({opacity:0, bottom:"20px", height:"0px"}, 500, function() {
			setTimeout(function(){
			$('#subtitle-bar').empty();
			}, 1000);
			$('#stretch-contain').animate({width:"300px", left:"0"}, 1000);
		});
		
	})
});