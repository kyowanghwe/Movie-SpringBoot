// Get clientIP (no limit)
// $.getJSON('https://api.ipify.org?format=jsonp&callback=?', function(data) {
//     document.myForm.clientIP.value = data.ip;
// });


// Get country, city (150 requests per minute)
$.get("http://ip-api.com/json", function(response) {
    document.myForm.clientCountry.value = response.country;
    document.myForm.clientCity.value = response.city;
    document.myForm.clientIP.value = response.query;
    console.log(response);
}, "jsonp");



// $.get("https://ipinfo.io", function(response) {
//     console.log(response.city, response.country);
// }, "jsonp");


function getCurrentTime(){
    var date = new Date();
    var datetime = date.getDate() +"/"+ (date.getMonth()+1) +"/"+ date.getFullYear() + " " 
                + date.toLocaleTimeString();
    document.myForm.currentDate.value = datetime;
};