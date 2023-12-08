$(document).ready(function() {
	// Tab click event handling
	$('.nav-link').on('click', function(e) {
		e.preventDefault(); // Prevent the default action of the anchor tag

		// Remove 'active' class from all tabs and 'show' class from tab content
		$('.nav-link').removeClass('active');
		$('.tab-pane').removeClass('show active');

		// Add 'active' class to the clicked tab
		$(this).addClass('active');

		// Get the target tab pane and show it
		var target = $(this).attr('href');
		$(target).addClass('show active');
	});
	
	$('.dropdown-toggle').on('click', function(e) {
		e.stopPropagation();

		var $dropdownMenu = $(this).siblings('.dropdown-menu');

		$('.dropdown-menu').not($dropdownMenu).removeClass('show');

		$dropdownMenu.toggleClass('show');
	});

	$(document).on('click', function(e) {
		if (!$('.dropdown').is(e.target) && $('.dropdown').has(e.target).length === 0) {
			$('.dropdown-menu').removeClass('show');
		}
	});
});
