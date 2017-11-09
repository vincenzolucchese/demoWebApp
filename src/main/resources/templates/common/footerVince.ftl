

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


