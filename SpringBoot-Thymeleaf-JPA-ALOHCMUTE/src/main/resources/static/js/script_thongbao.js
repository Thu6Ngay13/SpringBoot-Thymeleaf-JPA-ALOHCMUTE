let clickCount = 0;

  // Get the button and popup elements
  const button = document.getElementById('bell');
  const popup = document.getElementById('popup');

  // Add a click event listener to the button
  button.addEventListener('click', function() {
    // Increment the click count
    clickCount++;
    if(clickCount===1)
	{
		popup.classList.add("open-popup")
		
	}		
    // Show the popup on the second click
    if (clickCount === 2) {
		popup.classList.remove("open-popup")
		clickCount=0;
    }
  });
function closePopup() {
	popup.classList.remove("open-popup")
};