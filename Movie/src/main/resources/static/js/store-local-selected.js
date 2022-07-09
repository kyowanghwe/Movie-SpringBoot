// On submit
$("#submit").click(function(){
    // Store last select value
    var pickupdatehour = $('#actress').val();
    localStorage.setItem('storedPickup', JSON.stringify(pickupdatehour));
    		
    getCurrentTime();
});

// On the pages that have the select box
jQuery(document).ready(function () {
  var loadedPickup = JSON.parse(localStorage.getItem('storedPickup'));
  $('#actress').val(loadedPickup);
});