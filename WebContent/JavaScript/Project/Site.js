function mascara(t, mask){
	var i = t.value.length;
	var saida = mask.substring(1,0);
	var texto = mask.substring(i)
	if (texto.substring(0,1) != saida){
		t.value += texto.substring(0,1);
	}
}

$('document').ready(function(){
		
	$(".DigitOnly").keypress(function (e) {
	    
	    var key = e.which;
	     if (key != 8 && key != 0 && (key < 48 || key > 57)) {
	        return false;
	    }
	});
	
	$('.btnExcluir').on('click', function(e){

		$("#confirmModal").modal('show');
		
	});

	$('.btnPlay').on('click', function (e) {
		e.preventDefault();
		
		var player = $('#audioPlayer');
		var playerSrc = $('#audioPlayer').attr('src');
		var btnSrc = $(this).data('src');

		if (btnSrc != playerSrc) {
			player.attr('src', btnSrc);
		}

		if(player[0].paused){
			player[0].play();
		}else{
			player[0].pause();
		}
		
	});
});