$(document).ready(function(){
	var imgItems = $('.slider li').length;
	var imgPos = 1;
	
	//paginación------
	for (i =1; i <= imgItems; i++){
		$('.pagination').append('<li><span class="fa fa-circle"></span></li>');
	}

	//-------------------------
	$('.slider li').hide();
	$('.slider li:first').show();
	$('.pagination li:first').css({'color':'#A4A4A4'});

	//------------------
	$('.pagination li').click(pagination);
	$('.right span').click(nextSlider);
	$('.left span').click(prevSlider);

	//---------------------

	function pagination(){
		var paginationPos = $(this).index() + 1;
		


		$('.slider li').hide();
		$('.slider li:nth-child('+ paginationPos +')').fadeIn();

		$('.pagination li').css({'color':'#F7D358'});
		$(this).css({'color':'#A4A4A4'});
	}

	function nextSlider(){
		if(imgPos >= imgItems){imgPos = 1;} 
		else{imgPos++;}

		$('.pagination li').css({'color':'#F7D358'});
		$('.pagination li:nth-child('+ imgPos +')').css({'color':'#F7D358'});

		$('.slider li').hide();
		$('.slider li:nth-child('+ imgPos +')').fadeIn();

	}

});