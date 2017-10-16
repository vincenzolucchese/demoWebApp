

<footer class="footer">
	<p>&copy; 2016 Company, Inc.</p>
</footer>


<script type="text/javascript" src="<@spring.url '/jquery/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/bootstrap/js/bootstrap.min.js'/>"></script>  
<script type="text/javascript" src="<@spring.url '/datepicker/js/bootstrap-datepicker.min.js'/>"></script>

<script>
	$('#sandbox-container input').datepicker({
		format: "dd/mm/yyyy",
		todayBtn: "linked",
		clearBtn: true,
		language: "it",
		autoclose: true,
		todayHighlight: true
	});
</script>   
      
<script>
function removeRequired(form){
    $.each(form, function(key, value) {
        if ( value.hasAttribute("required")){
            value.removeAttribute("required");
        }
    });
}
</script> 

<#--
<script>
$(".headerCollasabile").click(function () {

    $headerCollasabile = $(this);
    //getting the next element
    $contentCollasabile = $headerCollasabile.next();
    //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
    $contentCollasabile.slideToggle(500, function () {
        //execute this after slideToggle is done
        //change text of header based on visibility of content div
       	// $headerCollasabile.text(function () {
            //change text based on condition
        //   return $contentCollasabile.is(":visible") ? "Nascondi" : "Accedi";
      	//  });
    });

});
</script>
-->

    <script>
      // This example displays an address form, using the autocomplete feature
      // of the Google Places API to help users fill in the information.

      // This example requires the Places library. Include the libraries=places
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

      var placeSearch, autocomplete;
      var componentForm = {
        street_number: 'short_name',
        route: 'long_name',
        locality: 'long_name',
        administrative_area_level_1: 'long_name',
        country: 'long_name',
        postal_code: 'short_name'
      };

      function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.
        autocomplete = new google.maps.places.Autocomplete(
            /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
            {types: ['geocode']});

        // When the user selects an address from the dropdown, populate the address
        // fields in the form.
        autocomplete.addListener('place_changed', fillInAddress);
      }

      function fillInAddress() {
        // Get the place details from the autocomplete object.
        var place = autocomplete.getPlace();

        for (var component in componentForm) {
          document.getElementById(component).value = '';
          document.getElementById(component).disabled = false;
        }

        // Get each component of the address from the place details
        // and fill the corresponding field on the form.
        for (var i = 0; i < place.address_components.length; i++) {
          var addressType = place.address_components[i].types[0];
          if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            document.getElementById(addressType).value = val;
          }
        }
      }

      // Bias the autocomplete object to the user's geographical location,
      // as supplied by the browser's 'navigator.geolocation' object.
      function geolocate() {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var geolocation = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            var circle = new google.maps.Circle({
              center: geolocation,
              radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
          });
        }
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNFAnHRUjUFx36bFNStTCfDGi0Mb8RP0k&libraries=places&callback=initAutocomplete"
        async defer></script>



