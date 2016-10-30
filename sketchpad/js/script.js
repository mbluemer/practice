$(document).ready(function() {
	createGrid(16, "color");
	
	$('#createNewGrid').click(function() {
		var size = prompt("What would you like the width to be? (Warning: above about 200 causes lag)")
		$('#grid_container').empty();
		createGrid(size);
	});

	$('#normalButton').click(function() {
		$('.grid').off("mouseover");
		$('.grid').off("hover");
		$('.grid').mouseover(function() {
			$(this).css("background-color", "white");
		});
	});
	
	$('#colorButton').click(function() {
		$('.grid').off("mouseover");
		$('.grid').off("hover");
		$('.grid').mouseover(function() {
			$(this).css("background-color", randColor());
		});
	});

	$('#fadeButton').click(function() {
		$('.grid').off("mouseover");
		$('.grid').hover(function() {
			$(this).css("opacity", 0);
		}, function() {
			$(this).fadeTo('fast', 1);
		});
	});

	$('#opacityButton').click(function() {
		$('.grid').off("hover");
		$('.grid').off("mouseover");
		$('.grid').mouseover(function() {
			$(this).css("opacity", $(this).css("opacity") * .75);
		});
	});
	
});


function createGrid(width, color) {
	// Define some parameters
	var breakpoint = width;
	var total = width * width;
	var blockSize = 700 / width;
	
	// Time to create the grid
	for(var i=0; i<total; i++) {
		if (i % breakpoint === 0) {
			$('#grid_container').append('<div class="grid breakpoint"></div>');
		} else {
			$('#grid_container').append('<div class="grid"></div>');
		}
	}
	$('.grid').height(blockSize);
	$('.grid').width(blockSize);
	
	
	$('.grid').mouseover(function() {
		$(this).css("background-color", "white");
	});
	
	
}

function randColor() {
	var red = (Math.floor(Math.random() * 256))
	var green = (Math.floor(Math.random() * 256))
	var blue = (Math.floor(Math.random() * 256))
	var colorValue = "rgb(" + red + "," + green + "," + blue + ")";
	return colorValue;
}
